package com.futaba.androidmadlink;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.device.FtdiAdapter;
import com.futaba.androidmadlink.p005ui.AppUiService;
import java.util.LinkedList;
import java.util.List;

public class SystemSetActivity extends Activity {
    private ProgressDialog MyDialog;
    boolean _isEnter = false;
    boolean _isListen = false;
    int _linkCount = 0;
    Button btnEnter = null;
    protected FtdiAdapter ftdiAdapter2 = null;
    /* access modifiers changed from: private */
    public ProgressDialog mDialog;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public Runnable mLoop = new Runnable() {
        public void run() {
            byte[] bArr = new byte[4096];
            String str = "";
            try {
                Thread.sleep(2000);
                SystemSetActivity.this.mHandler.post(new Runnable() {
                    public void run() {
                        SystemSetActivity.this.btnEnter.setEnabled(true);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (SystemSetActivity.this._isListen) {
                try {
                    if (SystemSetActivity.this._isEnter) {
                        SystemSetActivity.this._linkCount++;
                        if (SystemSetActivity.this._linkCount > 30) {
                            SystemSetActivity.this._isEnter = false;
                            SystemSetActivity.this._linkCount = 0;
                            if (SystemSetActivity.this.strWrite == "@FASSTest\r\n") {
                                SystemSetActivity.this.strWrite = "@T-FHSS\r\n";
                            } else {
                                SystemSetActivity.this.strWrite = "@FASSTest\r\n";
                            }
                            SystemSetActivity.this.ftdiAdapter2.SendMessage(SystemSetActivity.this.strWrite.getBytes());
                            SystemSetActivity.this.strWrite = "";
                            SystemSetActivity.this.mHandler.post(new Runnable() {
                                public void run() {
                                    AppUiService.ShowMsgDialog(SystemSetActivity.this, SystemSetActivity.this.getString(C0112R.string.labSetErrorTitle), SystemSetActivity.this.getString(C0112R.string.labSetError));
                                }
                            });
                        } else {
                            String strAscii = "";
                            byte[] rbuf = new byte[4096];
                            if (SystemSetActivity.this.ftdiAdapter2.ReadData(rbuf) <= 0) {
                                SystemSetActivity.this.ftdiAdapter2.SendMessage(SystemSetActivity.this.strWrite.getBytes());
                                Thread.sleep(500);
                            } else {
                                String strAscii2 = new String(rbuf);
                                try {
                                    if (strAscii2.indexOf("P0") > -1) {
                                        SystemSetActivity.this.mHandler.post(new Runnable() {
                                            public void run() {
                                                AppUiService.ShowMsgDialog(SystemSetActivity.this, SystemSetActivity.this.getString(C0112R.string.labSetSuccessTitle), SystemSetActivity.this.getString(C0112R.string.labSetSuccess));
                                            }
                                        });
                                        SystemSetActivity.this._isEnter = false;
                                        SystemSetActivity.this._linkCount = 0;
                                        SystemSetActivity.this.strWrite = "";
                                        String str2 = strAscii2;
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    String str3 = strAscii2;
                                    Log.e(Parameter.TAG, e.getMessage(), e);
                                }
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    Log.e(Parameter.TAG, e.getMessage(), e);
                }
            }
        }
    };
    BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                    SystemSetActivity.this.ftdiAdapter2.Connect();
                    Toast.makeText(context, "USB Attached", 1).show();
                } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                    SystemSetActivity.this.ftdiAdapter2.Disconnect();
                    Toast.makeText(context, "USB Detached", 1).show();
                    SystemSetActivity.this.finish();
                }
            } catch (Exception e) {
            }
        }
    };
    /* access modifiers changed from: private */
    public List<Byte> receivedSettingData = new LinkedList();
    String strWrite = "";

    class SettingSystemTask extends AsyncTask<String, Long, String> {
        SettingSystemTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... arg0) {
            try {
                Log.d(Parameter.TAG, "ReadSettings Start...");
                SystemSetActivity.this.receivedSettingData.clear();
                new Thread(SystemSetActivity.this.mLoop).start();
            } catch (Exception e) {
                Log.e(Parameter.TAG, e.getMessage(), e);
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

    class SettingTask extends AsyncTask<String, Long, String> {
        SettingTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... arg0) {
            do {
                try {
                } catch (Exception e) {
                    Log.e(Parameter.TAG, e.getMessage(), e);
                }
            } while (SystemSetActivity.this._isEnter);
            return "ok";
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            SystemSetActivity.this.mDialog = new ProgressDialog(SystemSetActivity.this);
            SystemSetActivity.this.mDialog.setMessage(new StringBuilder(String.valueOf(SystemSetActivity.this.getString(C0112R.string.action_set))).append("...").toString());
            SystemSetActivity.this.mDialog.setCancelable(false);
            SystemSetActivity.this.mDialog.setProgressStyle(0);
            SystemSetActivity.this.mDialog.setButton(SystemSetActivity.this.getString(C0112R.string.cancel), new OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    SystemSetActivity.this._isEnter = false;
                }
            });
            SystemSetActivity.this.mDialog.show();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result.equals("ok")) {
                SystemSetActivity.this.mDialog.dismiss();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        setContentView(C0112R.layout.system_set);
        this.btnEnter = (Button) findViewById(C0112R.C0114id.btnEnter);
        this.btnEnter.setEnabled(false);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        filter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        filter.setPriority(500);
        registerReceiver(this.mUsbReceiver, filter);
        this.ftdiAdapter2 = FtdiAdapter.getInstance(this);
        loadSettings2();
    }

    private void loadSettings2() {
        this.ftdiAdapter2.BaudRate = 9600;
        this.ftdiAdapter2.Parity = 0;
        this.ftdiAdapter2.DataBit = 8;
        this.ftdiAdapter2.StopBit = 0;
        this.ftdiAdapter2.FlowControl = 0;
    }

    public void onStart() {
        super.onStart();
        Log.d(Parameter.TAG, "SystemSetActivity.onStart()");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.d(Parameter.TAG, "SystemSetActivity.onPause()");
        this.ftdiAdapter2.Disconnect();
        super.onPause();
    }

    public void onStop() {
        Log.d(Parameter.TAG, "SystemSetActivity.onStop()");
        try {
            this._isListen = false;
            unregisterReceiver(this.mUsbReceiver);
        } catch (IllegalArgumentException e) {
            Log.d(Parameter.TAG, "SystemSetActivity onStop() Error:" + e.getMessage());
        }
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.d(Parameter.TAG, "SystemSetActivity.onResume()");
        if (!this.ftdiAdapter2.isConnected()) {
            this.ftdiAdapter2.Connect();
            if (this.ftdiAdapter2.isConnected()) {
                this._isListen = true;
                new SettingSystemTask().execute(new String[0]);
            }
        }
    }

    public void btnEnterClick(View view) throws InterruptedException {
        this.strWrite = "";
        RadioButton mRadioSystem1 = (RadioButton) findViewById(C0112R.C0114id.radioBtn_system1);
        this._isEnter = true;
        if (mRadioSystem1.isChecked()) {
            this.strWrite = "@FASSTest\r\n";
        } else {
            this.strWrite = "@T-FHSS\r\n";
        }
        new SettingTask().execute(new String[0]);
        this.ftdiAdapter2.SendMessage(this.strWrite.getBytes());
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        this.ftdiAdapter2.Disconnect();
        finish();
        return true;
    }

    public void btnCancelClick(View view) {
        this._isListen = false;
        this.ftdiAdapter2.Disconnect();
        finish();
    }
}
