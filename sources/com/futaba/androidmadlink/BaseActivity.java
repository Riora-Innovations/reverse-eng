package com.futaba.androidmadlink;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.data.ByteArrayConverter;
import com.futaba.androidmadlink.device.FtdiAdapter;
import com.futaba.androidmadlink.exception.CommunicationException;
import java.util.LinkedList;
import java.util.List;

public class BaseActivity extends FragmentActivity {
    protected String _msg = "";
    protected FtdiAdapter ftdiAdapter = null;
    protected String lastCmdString = "";
    protected String logDate = "";
    protected boolean mBusy = false;
    protected Handler mHandler = new Handler();
    protected boolean mIsListen = false;
    BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                    BaseActivity.this.ftdiAdapter.Connect();
                    Toast.makeText(context, "USB Attached", 1).show();
                } else if ("android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                    BaseActivity.this.ftdiAdapter.Disconnect();
                    Toast.makeText(context, "USB Detached", 1).show();
                    BaseActivity.this.finish();
                }
            } catch (Exception e) {
                Log.e(Parameter.TAG, "GaugeActivity " + e.getMessage());
            }
        }
    };
    protected List<Byte> receivedLogData = new LinkedList();
    protected List<Byte> receivedSettingData = new LinkedList();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Parameter.TAG, "GaugeActivity.onCreate()");
        this.ftdiAdapter = FtdiAdapter.getInstance(this);
        loadSettings();
    }

    public void onStart() {
        super.onStart();
        Log.d(Parameter.TAG, "GaugeActivity.onStart()");
    }

    public void onStop() {
        Log.d(Parameter.TAG, "GaugeActivity.onStop()");
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.d(Parameter.TAG, "GaugeActivity.onResume()");
        super.onResume();
    }

    public boolean systemSetting(String cmd) {
        boolean status = false;
        byte[] rbuf = new byte[4096];
        String str = "";
        try {
            Log.d(Parameter.TAG, "GaugeActivity Send Command:" + cmd);
            if (!this.ftdiAdapter.SendMessage(new StringBuilder(String.valueOf(cmd)).append("\r\n").toString())) {
                throw new Exception("Communication Error");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!this.ftdiAdapter.isConnected()) {
                throw new Exception("Communication Error");
            }
            int index = 0;
            do {
                index++;
                int len = this.ftdiAdapter.ReadData(rbuf);
                new String();
                if (len <= 0) {
                    status = false;
                } else if (ByteArrayConverter.BinaryToHexString(rbuf).toString().indexOf("P0") > -1) {
                    status = true;
                }
                if (status) {
                    return status;
                }
            } while (index <= 3);
            return status;
        } catch (Exception e2) {
            Log.e(Parameter.TAG, "GaugeActivity " + e2.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean readAndVerify() throws CommunicationException {
        byte[] rbuf = new byte[4096];
        int flag = 0;
        int dataNum = 0;
        StringBuffer dataLog = new StringBuffer();
        try {
            if (!this.mIsListen) {
                return false;
            }
            LinkedList linkedList = new LinkedList();
            boolean readCompleted = false;
            do {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    if (this.ftdiAdapter.isConnected()) {
                        int len = this.ftdiAdapter.ReadData(rbuf);
                        if (len > 0 && rbuf.length >= 49) {
                            int i = 0;
                            while (true) {
                                if (i >= len) {
                                    break;
                                }
                                if (flag != 0) {
                                    linkedList.add(Byte.valueOf(rbuf[i]));
                                    dataLog.append(String.format("%02X,", new Object[]{Byte.valueOf(rbuf[i])}));
                                    dataNum++;
                                    if (dataNum == 49) {
                                        dataLog.append("\r\n");
                                        flag = 0;
                                        dataNum = 0;
                                    }
                                    if (linkedList.size() == 196) {
                                        readCompleted = true;
                                        break;
                                    }
                                } else if (rbuf[i] == 15 && rbuf.length > i + 49 && ((rbuf[i + 25] == 0 || (rbuf[i + 25] != 0 && (rbuf[i + 25] == 3 || rbuf[i + 25] == 19 || rbuf[i + 25] == 11 || rbuf[i + 25] == 27))) && ((rbuf[i + 28] == 0 || (rbuf[i + 28] != 0 && (rbuf[i + 28] == -125 || rbuf[i + 28] == -109 || rbuf[i + 28] == -117 || rbuf[i + 28] == -101))) && ((rbuf[i + 31] == 0 || (rbuf[i + 31] != 0 && (rbuf[i + 31] == 67 || rbuf[i + 31] == 83 || rbuf[i + 31] == 75 || rbuf[i + 31] == 91))) && ((rbuf[i + 34] == 0 || (rbuf[i + 34] != 0 && (rbuf[i + 34] == -61 || rbuf[i + 34] == -45 || rbuf[i + 34] == -53 || rbuf[i + 34] == -37))) && ((rbuf[i + 37] == 0 || (rbuf[i + 37] != 0 && (rbuf[i + 37] == 35 || rbuf[i + 37] == 51 || rbuf[i + 37] == 43 || rbuf[i + 37] == 59))) && ((rbuf[i + 40] == 0 || (rbuf[i + 40] != 0 && (rbuf[i + 40] == -93 || rbuf[i + 40] == -77 || rbuf[i + 40] == -85 || rbuf[i + 40] == -69))) && ((rbuf[i + 43] == 0 || (rbuf[i + 43] != 0 && (rbuf[i + 43] == 99 || rbuf[i + 43] == 115 || rbuf[i + 43] == 107 || rbuf[i + 43] == 123))) && ((rbuf[i + 46] == 0 || (rbuf[i + 46] != 0 && (rbuf[i + 46] == -29 || rbuf[i + 46] == -13 || rbuf[i + 46] == -21 || rbuf[i + 46] == -5))) && rbuf[i + 49] == 15))))))))) {
                                    flag = 1;
                                    linkedList.add(Byte.valueOf(rbuf[i]));
                                    dataLog.append(String.format("%02X,", new Object[]{Byte.valueOf(rbuf[i])}));
                                    dataNum++;
                                }
                                i++;
                            }
                        }
                        if (readCompleted) {
                            break;
                        }
                    } else {
                        throw new Exception("Communication Error");
                    }
                } catch (Exception e2) {
                    e = e2;
                    LinkedList linkedList2 = linkedList;
                    Log.e(Parameter.TAG, "GaugeActivity Catch Exception from FtdiAdapter : " + e.getMessage());
                    throw new CommunicationException(e.getMessage());
                }
            } while (this.mIsListen);
            this.logDate = dataLog.toString();
            this.receivedSettingData = linkedList;
            LinkedList linkedList3 = linkedList;
            return true;
        } catch (Exception e3) {
            e = e3;
            Log.e(Parameter.TAG, "GaugeActivity Catch Exception from FtdiAdapter : " + e.getMessage());
            throw new CommunicationException(e.getMessage());
        }
    }

    private void loadSettings() {
        SharedPreferences sp = getSharedPreferences(Parameter.PREFS_NAME, 0);
        if (!checkPrefIsExists(sp)) {
            Editor pe = sp.edit();
            pe.putInt(Parameter.PREFS_KEY_BAUD_RATE, ((Integer) Parameter.BAUD_RATE.get("115200")).intValue());
            pe.putInt(Parameter.PREFS_KEY_PARITY, ((Byte) Parameter.PARITY.get("Even")).byteValue());
            pe.putInt(Parameter.PREFS_KEY_DATA_BITS, ((Byte) Parameter.DATA_BITS.get("8")).byteValue());
            pe.putInt(Parameter.PREFS_KEY_STOP_BITS, ((Byte) Parameter.STOP_BITS.get("2")).byteValue());
            pe.putInt(Parameter.PREFS_KEY_FLOW, ((Integer) Parameter.FLOW.get("None")).intValue());
            pe.commit();
        }
        this.ftdiAdapter.BaudRate = sp.getInt(Parameter.PREFS_KEY_BAUD_RATE, ((Integer) Parameter.BAUD_RATE.get("115200")).intValue());
        this.ftdiAdapter.Parity = (byte) sp.getInt(Parameter.PREFS_KEY_PARITY, ((Byte) Parameter.PARITY.get("Even")).byteValue());
        this.ftdiAdapter.DataBit = (byte) sp.getInt(Parameter.PREFS_KEY_DATA_BITS, ((Byte) Parameter.DATA_BITS.get("8")).byteValue());
        this.ftdiAdapter.StopBit = (byte) sp.getInt(Parameter.PREFS_KEY_STOP_BITS, ((Byte) Parameter.STOP_BITS.get("2")).byteValue());
        this.ftdiAdapter.FlowControl = (byte) sp.getInt(Parameter.PREFS_KEY_FLOW, ((Integer) Parameter.FLOW.get("None")).intValue());
    }

    private boolean checkPrefIsExists(SharedPreferences prefs) {
        try {
            if (getSharedPreferences(Parameter.PREFS_NAME, 0).getInt(Parameter.PREFS_KEY_BAUD_RATE, 0) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
