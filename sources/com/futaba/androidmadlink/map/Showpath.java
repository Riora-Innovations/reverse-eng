package com.futaba.androidmadlink.map;

import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.internal.view.SupportMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.file.FileDialog;
import com.futaba.androidmadlink.file.OnFileOkListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import p004au.com.bytecode.opencsv.CSVWriter;

public class Showpath extends FragmentActivity implements OnClickListener {
    private Button btnBack;
    private Button btnPathLog;
    public double distance = 0.0d;
    String filePath;
    /* access modifiers changed from: private */
    public GoogleMap map;
    public double maxh = 0.0d;
    public double maxs = 0.0d;
    public double minh = 0.0d;
    public double mins = 0.0d;
    String storyID;
    String story_title;
    TextView tv_show_gps;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0112R.layout.showpath);
        findviews();
        this.filePath = getIntent().getExtras().getString("FilePath");
        if (!new File(this.filePath).exists()) {
            Toast.makeText(this, "目前沒有任何記錄!", 1).show();
        } else {
            drawmap();
        }
    }

    private void findviews() {
        this.map = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(C0112R.C0114id.map)).getMap();
        this.btnPathLog = (Button) findViewById(C0112R.C0114id.btnPathLog);
        this.btnBack = (Button) findViewById(C0112R.C0114id.btnBack);
        this.tv_show_gps = (TextView) findViewById(C0112R.C0114id.showgeo);
        this.btnPathLog.setOnClickListener(this);
        this.btnBack.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0112R.C0114id.btnBack /*2131165277*/:
                finish();
                return;
            case C0112R.C0114id.btnPathLog /*2131165328*/:
                File v_Path = new File(Parameter.rootPath + "/MyPath");
                if (!v_Path.exists()) {
                    v_Path.mkdirs();
                }
                final FileDialog f = new FileDialog(this, "MyPath", Parameter.FILE_EXT_GPS);
                f.setOnFileOkListener(new OnFileOkListener() {
                    public void onFileDialog_FileOk() {
                        Showpath.this.filePath = f.FileName;
                        Showpath.this.map.clear();
                        Showpath.this.drawmap();
                    }
                });
                f.show();
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

    public String disformat(double num) {
        return new DecimalFormat("###").format(num);
    }

    public String disformat1(double num) {
        return new DecimalFormat("###.##").format(num);
    }

    /* access modifiers changed from: private */
    public void drawmap() {
        LatLng p2;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            String temp_data = br.readLine();
            String[] dd = temp_data.split(",");
            double lot = Double.parseDouble(dd[0]);
            double lgt = Double.parseDouble(dd[1]);
            this.maxh = Double.parseDouble(dd[3]);
            this.minh = Double.parseDouble(dd[3]);
            this.maxs = Double.parseDouble(dd[4]);
            this.mins = Double.parseDouble(dd[4]);
            int k = 1;
            LatLng p22 = null;
            LatLng p1 = new LatLng(lot, lgt);
            while (temp_data != null) {
                if (k == 1) {
                    p2 = p1;
                    this.distance += GetDistance(p1, p2);
                    Marker addMarker = this.map.addMarker(new MarkerOptions().position(p1).icon(BitmapDescriptorFactory.defaultMarker(120.0f)).title("Start").snippet(""));
                    this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(p1, 19.0f));
                    this.map.addPolyline(new PolylineOptions().add(p1, p2).width(5.0f).color(SupportMenu.CATEGORY_MASK));
                    this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(p2, 19.0f));
                } else {
                    String[] dd2 = temp_data.split(",");
                    p2 = new LatLng(Double.parseDouble(dd2[0]), Double.parseDouble(dd2[1]));
                    this.distance += GetDistance(p1, p2);
                    this.map.addPolyline(new PolylineOptions().add(p1, p2).width(5.0f).color(SupportMenu.CATEGORY_MASK));
                    this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(p2, 19.0f));
                    p1 = p2;
                    if (this.maxh < Double.parseDouble(dd2[3])) {
                        this.maxh = Double.parseDouble(dd2[3]);
                    }
                    if (this.minh > Double.parseDouble(dd2[3])) {
                        this.minh = Double.parseDouble(dd2[3]);
                    }
                    if (this.maxs < Double.parseDouble(dd2[4])) {
                        this.maxs = Double.parseDouble(dd2[4]);
                    }
                    if (this.mins > Double.parseDouble(dd2[4])) {
                        this.mins = Double.parseDouble(dd2[4]);
                    }
                }
                temp_data = br.readLine();
                k++;
                p22 = p2;
            }
            try {
                Marker addMarker2 = this.map.addMarker(new MarkerOptions().position(p22).icon(BitmapDescriptorFactory.defaultMarker(1.0f)).title("End").snippet(""));
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(p22, 19.0f));
                if (this.distance < 1000.0d) {
                    this.tv_show_gps.setText("Distance:" + disformat(this.distance) + " m \n" + "MaxAltitude：" + new DecimalFormat("0.0").format(this.maxh) + " | MinAltitude：" + new DecimalFormat("0.0").format(this.minh) + CSVWriter.DEFAULT_LINE_END + "MaxSpeed：" + new DecimalFormat("0.0").format(this.maxs) + " m | MinSpeed：" + new DecimalFormat("0.0").format(this.mins) + "km/h");
                } else {
                    this.tv_show_gps.setText("Distance:" + disformat(this.distance / 1000.0d) + " km \n" + "MaxAltitude：" + new DecimalFormat("0.0").format(this.maxh) + " | MinAltitude：" + new DecimalFormat("0.0").format(this.minh) + CSVWriter.DEFAULT_LINE_END + "MaxSpeed：" + new DecimalFormat("0.0").format(this.maxs) + " m | MinSpeed：" + new DecimalFormat("0.0").format(this.mins) + "km/h");
                }
                LatLng latLng = p22;
            } catch (IOException e) {
                LatLng latLng2 = p22;
            }
        } catch (IOException e2) {
        }
    }
}
