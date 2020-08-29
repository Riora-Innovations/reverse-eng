package com.futaba.androidmadlink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;
import com.futaba.androidmadlink.config.GaugeViewSetting;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.view.GPSLocusView;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class GPSLocusActivity extends BaseActivity {
    public static int handleFLAG = 1;
    public static Handler handler;
    public static boolean handlerStatus = false;
    private String _attributes = "{'Slot':'24'}";
    private int _colNo;
    boolean _isListen = false;
    private String _logFileName;
    List<LatLng> _mapLists;
    private int _pageNo;
    private int _rowNo;
    private String _title;
    GPSLocusView gpsLocusView;
    private int linkCount;
    GaugeViewSetting mGaugeViewSetting = null;
    BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                    GPSLocusActivity.this.startService(GaugeActivity.dataService);
                    GPSLocusActivity.handlerStatus = true;
                    GPSLocusActivity.this.ftdiAdapter.Connect();
                    Toast.makeText(context, "USB Attached", 1).show();
                } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                    GPSLocusActivity.this.ftdiAdapter.Disconnect();
                    Toast.makeText(context, "USB Detached", 1).show();
                    GPSLocusActivity.this.finish();
                }
            } catch (Exception e) {
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        setContentView(C0112R.layout.gps_locus);
        Bundle bundle = getIntent().getExtras();
        this.gpsLocusView = (GPSLocusView) findViewById(C0112R.C0114id.GPSLocusView);
        if (bundle != null) {
            this._attributes = bundle.getString("Attributes");
            this._title = bundle.getString("Title");
            this._logFileName = bundle.getString("LogFileName");
            this._pageNo = bundle.getInt("PageNo");
            this._rowNo = bundle.getInt("RowNo");
            this._colNo = bundle.getInt("ColNo");
            this._mapLists = bundle.getParcelableArrayList("MapLists");
            this.gpsLocusView.setMapLists(this._mapLists);
            this.mGaugeViewSetting = GaugeActivity.mGaugePagerAdapter.getGaugePageSetting(this._pageNo).getGaugeViewSetting(this._colNo, this._rowNo);
        }
        this.gpsLocusView.setLogFileName2(this._logFileName);
        this.gpsLocusView.setAttributes(this._attributes);
        this.gpsLocusView.setSensorTitle(this._title);
        this.gpsLocusView.setShowValue(true);
        handler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (GPSLocusActivity.handlerStatus && msg.what == GPSLocusActivity.handleFLAG) {
                    GPSLocusActivity.this.gpsLocusView.setSensorValue(GPSLocusActivity.this.mGaugeViewSetting.getSersorValueList());
                }
            }
        };
    }

    public void onStart() {
        super.onStart();
        Log.d(Parameter.TAG, "GPSLocusActivity.onStart()");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.d(Parameter.TAG, "GPSLocusActivity.onPause()");
        handlerStatus = false;
        try {
            unregisterReceiver(this.mUsbReceiver);
        } catch (Exception e) {
        }
        super.onPause();
    }

    public void onStop() {
        Log.d(Parameter.TAG, "GPSLocusActivity.onStop()");
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        registerReceiver(this.mUsbReceiver, filter);
        Log.d(Parameter.TAG, "GPSLocusActivity.onResume()");
        handlerStatus = true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        ResultGpsLocus();
        return true;
    }

    public void btnBackClick(View view) {
        ResultGpsLocus();
    }

    private void ResultGpsLocus() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("RowNo", this._rowNo);
        bundle.putInt("ColNo", this._colNo);
        ArrayList<LatLng> list = new ArrayList<>();
        list.addAll(this.gpsLocusView.getMapLists());
        bundle.putParcelableArrayList("MapLists", list);
        bundle.putString("Attributes", this.gpsLocusView.getAttributes());
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    public void btnResetClick(View view) {
        this.gpsLocusView.reset();
    }
}
