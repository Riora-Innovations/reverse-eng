package com.futaba.androidmadlink;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.data.ByteArrayConverter;
import com.futaba.androidmadlink.data.DataFunctions;
import com.futaba.androidmadlink.file.FileDialog;
import com.futaba.androidmadlink.file.OnFileOkListener;
import com.futaba.androidmadlink.map.Showpath;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class MapActivity extends BaseActivity implements OnClickListener {
    /* access modifiers changed from: private */
    public double TempregulateValue = 0.0d;
    boolean _isListen = false;
    boolean _run = false;
    double altitude = 0.0d;

    /* renamed from: am */
    AlphaAnimation f4am = new AlphaAnimation(0.1f, 1.0f);
    Object[] data2Value = new Object[32];
    List<Integer> dataValue;
    public double distance = 0.0d;
    boolean firstLoad = true;
    boolean hasWifi = false;
    int iffirst = 0;
    double latitude = 0.0d;
    double longitude = 0.0d;
    /* access modifiers changed from: private */
    public Button mButton01;
    /* access modifiers changed from: private */
    public Button mButton02;
    private Button mButton03;
    /* access modifiers changed from: private */
    public Runnable mLoop = new Runnable() {
        public void run() {
            while (MapActivity.this._isListen) {
                if (MapActivity.this.checkWifiGps()) {
                    MapActivity.this.hasWifi = true;
                    MapActivity.this.findviews();
                    MapActivity.this.connected();
                    while (MapActivity.this._isListen) {
                        try {
                            if (MapActivity.this.readAndVerify()) {
                                MapActivity.this.ReadData();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.e(Parameter.TAG, "MapActivity Error :" + e.getMessage());
                        } finally {
                            MapActivity.this.mHandler.post(new Runnable() {
                                public void run() {
                                    MapActivity.this.off_busyAnimation();
                                }
                            });
                        }
                    }
                }
            }
        }
    };
    private GoogleMap map;

    /* renamed from: mk */
    Marker f5mk = null;

    /* renamed from: p1 */
    LatLng f6p1;

    /* renamed from: p2 */
    LatLng f7p2;
    /* access modifiers changed from: private */
    public double regulateValue = 0.0d;
    String sdate;
    double speed = 0.0d;
    String strDateTime = "";
    TextView tv_show_gps;

    class ReadSettingTask extends AsyncTask<String, Long, String> {
        ReadSettingTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... arg0) {
            try {
                Log.d(Parameter.TAG, "ReadSettings Start...");
                MapActivity.this.receivedSettingData.clear();
                MapActivity.this._isListen = true;
                new Thread(MapActivity.this.mLoop).start();
            } catch (Exception e) {
                Log.e(Parameter.TAG, e.getMessage(), e);
                e.printStackTrace();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0112R.layout.map);
        this.tv_show_gps = (TextView) findViewById(C0112R.C0114id.showgeo);
        findviews();
    }

    public void onStart() {
        super.onStart();
        Log.d(Parameter.TAG, "MapActivity.onStart()");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        Log.d(Parameter.TAG, "MapActivity.onStop()");
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mHandler.removeCallbacks(this.mLoop);
        super.onDestroy();
    }

    public boolean checkWifiGps() {
        boolean status;
        NetworkInfo info = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (info == null || !info.isAvailable()) {
            status = false;
            if (this.hasWifi || this.firstLoad) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        new Builder(MapActivity.this).setTitle("System Message").setMessage("Can't use the Internet!").setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                MapActivity.this.findviewsnonet();
                                MapActivity.this.hasWifi = false;
                            }
                        }).show();
                    }
                });
            }
            this.hasWifi = false;
        } else {
            status = true;
            this.hasWifi = true;
        }
        this.firstLoad = false;
        return status;
    }

    /* access modifiers changed from: private */
    public void ReadData() {
        this.mHandler.post(new Runnable() {
            public void run() {
                byte[] rawData = new byte[24];
                byte[] rawData2 = new byte[96];
                int data2Index = 0;
                for (int j = 1; j < 196; j++) {
                    if ((j < 49 || j > 73) && ((j < 98 || j > 122) && (j < 147 || j > 171))) {
                        if (j <= 24) {
                            rawData[j - 1] = ((Byte) MapActivity.this.receivedSettingData.get(j)).byteValue();
                        } else {
                            rawData2[data2Index] = ((Byte) MapActivity.this.receivedSettingData.get(j)).byteValue();
                            data2Index++;
                        }
                    }
                }
                MapActivity.this.dataValue = ByteArrayConverter.SettingValues(rawData);
                MapActivity.this.data2Value = ByteArrayConverter.DataToByteArray(rawData2, MapActivity.this.data2Value);
                char[] collectChars = ByteArrayConverter.SlotsToBinaryArray2(MapActivity.this.data2Value, 24, 8);
                String str = "";
                Double altitudeValue = Double.valueOf(1.0d);
                MapActivity.this.TempregulateValue = ((double) (ByteArrayConverter.convertToInt(collectChars, 13, 16) - 8551)) / 10.0d;
                String strValue = String.valueOf(new DecimalFormat("0.0").format((MapActivity.this.TempregulateValue - MapActivity.this.regulateValue) * altitudeValue.doubleValue()));
                MapActivity.this.altitude = Double.parseDouble(strValue);
                String strValue2 = "";
                String strValue3 = String.valueOf(ByteArrayConverter.convertToInt(collectChars, 46, 1));
                String strValue4 = "";
                String strValue5 = String.valueOf(((double) ByteArrayConverter.convertToInt(collectChars, 47, 9)) * Double.valueOf(1.0d).doubleValue());
                MapActivity.this.speed = Double.parseDouble(strValue5);
                String str2 = "";
                switch (ByteArrayConverter.convertToInt(collectChars, 56, 1)) {
                    case 0:
                        String lonStr = "E";
                        break;
                    case 1:
                        String lonStr2 = "W";
                        break;
                }
                String strValue6 = "";
                int lonValue = ByteArrayConverter.convertToInt(collectChars, 57, 27);
                MapActivity.this.longitude = Double.parseDouble(new DecimalFormat("000.0000").format((((double) lonValue) / 60.0d) / 10000.0d));
                String str3 = "";
                switch (ByteArrayConverter.convertToInt(collectChars, 84, 1)) {
                    case 0:
                        String latStr = "N";
                        break;
                    case 1:
                        String latStr2 = "S";
                        break;
                }
                String strValue7 = "";
                int latValue = ByteArrayConverter.convertToInt(collectChars, 85, 26);
                MapActivity.this.latitude = Double.parseDouble(new DecimalFormat("000.0000").format((((double) latValue) / 60.0d) / 10000.0d));
                String strValue8 = "";
                int strTime = ByteArrayConverter.convertToInt(collectChars, 111, 17);
                String strValue9 = String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(strTime / 3600), Integer.valueOf((strTime / 60) % 60), Integer.valueOf(strTime % 60)});
                MapActivity.this.strDateTime = DataFunctions.converTimeUtcToLocal(strValue9);
                MapActivity.this.f7p2 = new LatLng(MapActivity.this.latitude, MapActivity.this.longitude);
                if (MapActivity.this._run) {
                    MapActivity.this.distance += MapActivity.this.GetDistance(MapActivity.this.f6p1, MapActivity.this.f7p2);
                    if (MapActivity.this.distance < 1000.0d) {
                        MapActivity.this.tv_show_gps.setText("move distance:" + MapActivity.this.disformat(MapActivity.this.distance) + " m  " + "Latitude：" + MapActivity.this.formatgeo(MapActivity.this.latitude) + "  Longitude：" + MapActivity.this.formatgeo(MapActivity.this.longitude) + "  Altitude：" + MapActivity.this.formatspeed(MapActivity.this.altitude) + " m  speed：" + MapActivity.this.formatspeed(MapActivity.this.speed) + "km/h");
                    } else {
                        MapActivity.this.tv_show_gps.setText("move distance:" + MapActivity.this.disformat(MapActivity.this.distance / 1000.0d) + " km  " + "Latitude：" + MapActivity.this.formatgeo(MapActivity.this.latitude) + "  Longitude：" + MapActivity.this.formatgeo(MapActivity.this.longitude) + "  Altitude：" + MapActivity.this.formatspeed(MapActivity.this.altitude) + " m   speed：" + MapActivity.this.formatspeed(MapActivity.this.speed) + "km/h");
                    }
                    MapActivity.this.showlocation(MapActivity.this.latitude, MapActivity.this.longitude, new StringBuilder(String.valueOf(MapActivity.this.latitude)).append(" , ").append(MapActivity.this.longitude).toString(), "", 2);
                    try {
                        FileWriter fileWriter = new FileWriter(Parameter.rootGPS + "/" + MapActivity.this.sdate + "." + Parameter.FILE_EXT_GPS, true);
                        BufferedWriter bw = new BufferedWriter(fileWriter);
                        Date current = new Date();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        bw.write(new StringBuilder(String.valueOf(MapActivity.this.f7p2.latitude)).append(",").append(MapActivity.this.f7p2.longitude).append(",").append(simpleDateFormat.format(current)).append(",").append(MapActivity.this.altitude).append(",").append(MapActivity.this.speed).toString());
                        bw.newLine();
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    MapActivity.this.showlocation(MapActivity.this.latitude, MapActivity.this.longitude, new StringBuilder(String.valueOf(MapActivity.this.latitude)).append(" , ").append(MapActivity.this.longitude).toString(), "", 3);
                }
                MapActivity.this.f6p1 = MapActivity.this.f7p2;
                if (MapActivity.this.iffirst == 0) {
                    MapActivity.this.mButton01.setVisibility(0);
                    MapActivity.this.iffirst = 1;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void connected() {
        do {
            if (!this.ftdiAdapter.isConnected()) {
                Log.d(Parameter.TAG, "Device disconnected");
                this.mIsListen = false;
            } else {
                Log.d(Parameter.TAG, "Start reading thread...");
                this.mIsListen = true;
            }
        } while (!this.mIsListen);
        this.mHandler.post(new Runnable() {
            public void run() {
                MapActivity.this.on_busyAnimation();
            }
        });
    }

    /* access modifiers changed from: private */
    public void on_busyAnimation() {
        ImageView iv = (ImageView) findViewById(C0112R.C0114id.imgBusy);
        iv.setImageResource(C0112R.C0113drawable.busy);
        this.f4am = new AlphaAnimation(0.1f, 1.0f);
        this.f4am.setDuration(200);
        this.f4am.setRepeatCount(-1);
        this.f4am.setRepeatMode(2);
        iv.setAnimation(this.f4am);
        this.f4am.startNow();
    }

    /* access modifiers changed from: private */
    public void off_busyAnimation() {
        this.f4am.cancel();
        ((ImageView) findViewById(C0112R.C0114id.imgBusy)).setImageResource(C0112R.C0113drawable.idle);
    }

    public String formatgeo(double num) {
        return new DecimalFormat("###.####").format(num);
    }

    public String formatspeed(double num) {
        return new DecimalFormat("###.##").format(num);
    }

    /* access modifiers changed from: private */
    public void findviewsnonet() {
        this.mButton01 = (Button) findViewById(C0112R.C0114id.myButton1);
        this.mButton02 = (Button) findViewById(C0112R.C0114id.myButton2);
        this.mButton01.setVisibility(4);
        this.mButton02.setVisibility(4);
        this.mButton03 = (Button) findViewById(C0112R.C0114id.myButton3);
        this.mButton03.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void findviews() {
        this.mButton01 = (Button) findViewById(C0112R.C0114id.myButton1);
        this.mButton02 = (Button) findViewById(C0112R.C0114id.myButton2);
        this.mButton03 = (Button) findViewById(C0112R.C0114id.myButton3);
        this.mButton01.setOnClickListener(this);
        this.mButton02.setOnClickListener(this);
        this.mButton03.setOnClickListener(this);
        this.mHandler.post(new Runnable() {
            public void run() {
                MapActivity.this.mButton01.setVisibility(4);
                MapActivity.this.mButton02.setVisibility(4);
            }
        });
    }

    /* access modifiers changed from: private */
    public void showlocation(double d, double e, String title, String snip, int type) {
        LatLng CTU = new LatLng(d, e);
        this.map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0112R.C0114id.map)).getMap();
        if (this.f5mk != null) {
            this.f5mk.remove();
        }
        switch (type) {
            case 1:
                this.f5mk = this.map.addMarker(new MarkerOptions().position(CTU).title(title).icon(BitmapDescriptorFactory.defaultMarker(60.0f)).snippet(snip));
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(CTU, 19.0f));
                return;
            case 2:
                this.f5mk = this.map.addMarker(new MarkerOptions().position(CTU).title(title).snippet(snip));
                this.map.addPolyline(new PolylineOptions().add(this.f6p1, this.f7p2).width(5.0f).color(SupportMenu.CATEGORY_MASK));
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(this.f7p2, 19.0f));
                return;
            case 3:
                this.f5mk = this.map.addMarker(new MarkerOptions().position(CTU).title(title).snippet(snip));
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(CTU, 19.0f));
                return;
            default:
                return;
        }
    }

    public double GetDistance(LatLng gp1, LatLng gp2) {
        double latDiff = Math.toRadians(gp2.latitude - gp1.latitude);
        double lngDiff = Math.toRadians(gp2.longitude - gp1.longitude);
        double a = (Math.sin(latDiff / 2.0d) * Math.sin(latDiff / 2.0d)) + (Math.cos(Math.toRadians(gp1.latitude)) * Math.cos(Math.toRadians(gp2.latitude)) * Math.sin(lngDiff / 2.0d) * Math.sin(lngDiff / 2.0d));
        return (double) new Float(((double) 1609) * 3958.75d * 2.0d * Math.atan2(Math.sqrt(a), Math.sqrt(1.0d - a))).floatValue();
    }

    private double ConvertDegreeToRadians(double degrees) {
        return 0.017453292519943295d * degrees;
    }

    public String disformat(double num) {
        return new DecimalFormat("###").format(num);
    }

    public String disformat1(double num) {
        return new DecimalFormat("###.##").format(num);
    }

    public static void deleteDir(File dir) {
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                deleteDir(f);
            }
            dir.delete();
            return;
        }
        dir.delete();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0112R.C0114id.myButton1 /*2131165318*/:
                SimpleDateFormat nowdate = new SimpleDateFormat("yyyyMMddHHmmss");
                nowdate.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                this.sdate = nowdate.format(new Date());
                this.sdate.replaceAll("\\s+", "");
                File vPath = new File(Parameter.rootPath + "/MyPath");
                if (!vPath.exists()) {
                    vPath.mkdirs();
                }
                if (this.map != null) {
                    this.map.clear();
                }
                this.f6p1 = this.f7p2;
                this._run = true;
                String str = this.latitude + " , " + this.longitude;
                showlocation(this.f6p1.latitude, this.f6p1.longitude, "Start", str, 1);
                this.distance = 0.0d;
                this.mButton01.setVisibility(4);
                this.mButton02.setVisibility(0);
                this.mButton03.setVisibility(4);
                return;
            case C0112R.C0114id.myButton2 /*2131165319*/:
                this._run = false;
                new Builder(this).setTitle("OK").setMessage("Save Completed").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).show();
                this.mButton01.setVisibility(0);
                this.mButton02.setVisibility(4);
                this.mButton03.setVisibility(0);
                if (this.map != null) {
                    this.map.clear();
                    return;
                }
                return;
            case C0112R.C0114id.myButton3 /*2131165320*/:
                File v_Path = new File(Parameter.rootPath + "/MyPath");
                if (!v_Path.exists()) {
                    v_Path.mkdirs();
                }
                final FileDialog f = new FileDialog(this, "MyPath", Parameter.FILE_EXT_GPS);
                f.setOnFileOkListener(new OnFileOkListener() {
                    public void onFileDialog_FileOk() {
                        Intent it = new Intent();
                        it.setClass(MapActivity.this, Showpath.class);
                        it.putExtra("FilePath", f.FileName);
                        MapActivity.this.startActivity(it);
                    }
                });
                f.show();
                return;
            default:
                return;
        }
    }
}
