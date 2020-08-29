package com.futaba.androidmadlink.service;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.futaba.androidmadlink.GPSLocusActivity;
import com.futaba.androidmadlink.GaugeActivity;
import com.futaba.androidmadlink.config.GaugePageSetting;
import com.futaba.androidmadlink.config.GaugeViewSetting;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.data.ByteArrayConverter;
import com.futaba.androidmadlink.data.WriteLog;
import com.futaba.androidmadlink.device.FtdiAdapter;
import com.futaba.androidmadlink.exception.CommunicationException;
import com.futaba.androidmadlink.view.DataTypes;
import com.google.android.gms.maps.model.LatLng;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class ViewDataService extends Service {
    /* access modifiers changed from: private */
    public boolean _alertStutas = false;
    /* access modifiers changed from: private */
    public boolean _isListen = false;
    /* access modifiers changed from: private */
    public int _rateStatus = 0;
    int byteSize = Parameter.SETTING_DATA_SIZE;
    private Object[] data2Value = new Object[32];
    private List<Integer> dataValue = new ArrayList();
    boolean extFlog = false;
    private FtdiAdapter ftdiAdapter = null;
    private int linkCount;
    private LinkedList<Byte> loadSettingData = new LinkedList<>();
    /* access modifiers changed from: private */
    public String logDate = "";
    private Handler mHandler = new Handler();
    private boolean mIsListen = false;
    private Runnable mLoop = new Runnable() {
        public void run() {
            while (ViewDataService.this._isListen) {
                try {
                    ViewDataService.this.connected();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                int Index = 0;
                while (ViewDataService.this._isListen) {
                    try {
                        if (!ViewDataService.this.readAndVerify2()) {
                            Message msg = new Message();
                            msg.what = GaugeActivity.handleNoSignal;
                            GaugeActivity.handler.sendMessage(msg);
                        } else {
                            if (GaugeActivity.IsWriteLog()) {
                                WriteLog.writeLog(GaugeActivity.getLogFileName(), ViewDataService.this.logDate);
                            }
                            ViewDataService.this.ReadData2();
                            if (Index < 20) {
                                Index++;
                            } else {
                                ViewDataService.this._alertStutas = false;
                                ViewDataService.this._rateStatus = 0;
                                ViewDataService.this.setRate();
                                ViewDataService.this.SetSensorData();
                                Message msg2 = new Message();
                                Object[] msgStutas = new Object[2];
                                if (GaugeActivity.handlerStatus) {
                                    msg2.what = GaugeActivity.handleFLAG;
                                    msgStutas[0] = Boolean.valueOf(ViewDataService.this._alertStutas);
                                    msgStutas[1] = Integer.valueOf(ViewDataService.this._rateStatus);
                                    msg2.obj = msgStutas;
                                    GaugeActivity.handler.sendMessage(msg2);
                                } else if (GPSLocusActivity.handlerStatus) {
                                    msg2.what = GPSLocusActivity.handleFLAG;
                                    msg2.obj = Boolean.valueOf(ViewDataService.this._alertStutas);
                                    GPSLocusActivity.handler.sendMessage(msg2);
                                }
                            }
                        }
                    } catch (Exception e) {
                        Log.e(Parameter.TAG, "Service Error :" + e.getMessage());
                    }
                }
            }
        }
    };
    private boolean mReceiverAleart = false;
    int noDataCount = 0;
    boolean readHendOK = false;
    private List<Byte> receivedSettingData = new LinkedList();
    private byte[] receivedSettingData2 = new byte[this.byteSize];
    boolean rxFlog = false;
    double startTime;
    int startTimeFlog = 0;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.ftdiAdapter = FtdiAdapter.getInstance(this);
        loadSettings();
        try {
            Log.d(Parameter.TAG, "ReadSettings Start...");
            this.receivedSettingData.clear();
            this._isListen = true;
            new Thread(this.mLoop).start();
        } catch (Exception e) {
            Log.e(Parameter.TAG, e.getMessage(), e);
        }
    }

    public void onDestroy() {
        this._isListen = false;
        super.onDestroy();
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
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    if (this.ftdiAdapter.isConnected()) {
                        int len = this.ftdiAdapter.ReadData(rbuf);
                        if (len > 0 && rbuf.length >= 49) {
                            this.noDataCount = 0;
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
                        } else {
                            this.noDataCount++;
                            if (this.noDataCount > 20) {
                                LinkedList linkedList2 = linkedList;
                                return false;
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
                    LinkedList linkedList3 = linkedList;
                    Log.e(Parameter.TAG, "Catch Exception from FtdiAdapter : " + e.getMessage());
                    throw new CommunicationException(e.getMessage());
                }
            } while (this.mIsListen);
            this.logDate = dataLog.toString();
            this.receivedSettingData = linkedList;
            LinkedList linkedList4 = linkedList;
            return true;
        } catch (Exception e3) {
            e = e3;
            Log.e(Parameter.TAG, "Catch Exception from FtdiAdapter : " + e.getMessage());
            throw new CommunicationException(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public boolean readAndVerify2() throws CommunicationException {
        byte[] rcvData = new byte[this.byteSize];
        StringBuffer dataLog = new StringBuffer();
        try {
            if (!this.mIsListen) {
                return false;
            }
            boolean readCompleted = false;
            while (true) {
                if (this.loadSettingData.size() >= 196 && this.readHendOK) {
                    int lastIndex = 0;
                    int i = 0;
                    while (true) {
                        if (i >= this.loadSettingData.size()) {
                            break;
                        } else if (((Byte) this.loadSettingData.get(i)).byteValue() != 15 || this.loadSettingData.size() <= i + 49 || ((((Byte) this.loadSettingData.get(i + 25)).byteValue() != 0 && (((Byte) this.loadSettingData.get(i + 25)).byteValue() == 0 || !(((Byte) this.loadSettingData.get(i + 25)).byteValue() == 3 || ((Byte) this.loadSettingData.get(i + 25)).byteValue() == 19 || ((Byte) this.loadSettingData.get(i + 25)).byteValue() == 11 || ((Byte) this.loadSettingData.get(i + 25)).byteValue() == 27))) || ((((Byte) this.loadSettingData.get(i + 28)).byteValue() != 0 && (((Byte) this.loadSettingData.get(i + 28)).byteValue() == 0 || !(((Byte) this.loadSettingData.get(i + 28)).byteValue() == -125 || ((Byte) this.loadSettingData.get(i + 28)).byteValue() == -109 || ((Byte) this.loadSettingData.get(i + 28)).byteValue() == -117 || ((Byte) this.loadSettingData.get(i + 28)).byteValue() == -101))) || ((((Byte) this.loadSettingData.get(i + 31)).byteValue() != 0 && (((Byte) this.loadSettingData.get(i + 31)).byteValue() == 0 || !(((Byte) this.loadSettingData.get(i + 31)).byteValue() == 67 || ((Byte) this.loadSettingData.get(i + 31)).byteValue() == 83 || ((Byte) this.loadSettingData.get(i + 31)).byteValue() == 75 || ((Byte) this.loadSettingData.get(i + 31)).byteValue() == 91))) || ((((Byte) this.loadSettingData.get(i + 34)).byteValue() != 0 && (((Byte) this.loadSettingData.get(i + 34)).byteValue() == 0 || !(((Byte) this.loadSettingData.get(i + 34)).byteValue() == -61 || ((Byte) this.loadSettingData.get(i + 34)).byteValue() == -45 || ((Byte) this.loadSettingData.get(i + 34)).byteValue() == -53 || ((Byte) this.loadSettingData.get(i + 34)).byteValue() == -37))) || ((((Byte) this.loadSettingData.get(i + 37)).byteValue() != 0 && (((Byte) this.loadSettingData.get(i + 37)).byteValue() == 0 || !(((Byte) this.loadSettingData.get(i + 37)).byteValue() == 35 || ((Byte) this.loadSettingData.get(i + 37)).byteValue() == 51 || ((Byte) this.loadSettingData.get(i + 37)).byteValue() == 43 || ((Byte) this.loadSettingData.get(i + 37)).byteValue() == 59))) || ((((Byte) this.loadSettingData.get(i + 40)).byteValue() != 0 && (((Byte) this.loadSettingData.get(i + 40)).byteValue() == 0 || !(((Byte) this.loadSettingData.get(i + 40)).byteValue() == -93 || ((Byte) this.loadSettingData.get(i + 40)).byteValue() == -77 || ((Byte) this.loadSettingData.get(i + 40)).byteValue() == -85 || ((Byte) this.loadSettingData.get(i + 40)).byteValue() == -69))) || ((((Byte) this.loadSettingData.get(i + 43)).byteValue() != 0 && (((Byte) this.loadSettingData.get(i + 43)).byteValue() == 0 || !(((Byte) this.loadSettingData.get(i + 43)).byteValue() == 99 || ((Byte) this.loadSettingData.get(i + 43)).byteValue() == 115 || ((Byte) this.loadSettingData.get(i + 43)).byteValue() == 107 || ((Byte) this.loadSettingData.get(i + 43)).byteValue() == 123))) || ((((Byte) this.loadSettingData.get(i + 46)).byteValue() != 0 && (((Byte) this.loadSettingData.get(i + 46)).byteValue() == 0 || !(((Byte) this.loadSettingData.get(i + 46)).byteValue() == -29 || ((Byte) this.loadSettingData.get(i + 46)).byteValue() == -13 || ((Byte) this.loadSettingData.get(i + 46)).byteValue() == -21 || ((Byte) this.loadSettingData.get(i + 46)).byteValue() == -5))) || ((Byte) this.loadSettingData.get(i + 49)).byteValue() != 15))))))))) {
                            this.readHendOK = false;
                            i++;
                        } else {
                            if (this.byteSize + i > this.loadSettingData.size()) {
                                int lastIndex2 = i;
                                this.readHendOK = false;
                            }
                            for (int j = 0; j < this.byteSize; j++) {
                                rcvData[j] = ((Byte) this.loadSettingData.get(i + j)).byteValue();
                                dataLog.append(String.format("%02X,", new Object[]{this.loadSettingData.get(i + j)}));
                                if (j == 48 || j == 97 || j == 146 || j == 195) {
                                    dataLog.append("\r\n");
                                }
                            }
                            lastIndex = i + this.byteSize;
                            this.readHendOK = true;
                            readCompleted = true;
                        }
                    }
                    for (int j2 = 0; j2 < lastIndex; j2++) {
                        this.loadSettingData.pop();
                    }
                    if (readCompleted || !this.mIsListen) {
                        this.logDate = dataLog.toString();
                        this.receivedSettingData2 = rcvData;
                    }
                } else if (!this.ftdiAdapter.isConnected()) {
                    this.loadSettingData.clear();
                    throw new Exception("Communication Error");
                } else {
                    readUsbData();
                    if (this.loadSettingData.size() <= 0 || this.loadSettingData.size() < this.byteSize) {
                        this.noDataCount++;
                        if (this.noDataCount > 20) {
                            return false;
                        }
                    } else {
                        this.noDataCount = 0;
                        this.readHendOK = true;
                    }
                }
            }
            this.logDate = dataLog.toString();
            this.receivedSettingData2 = rcvData;
            return true;
        } catch (Exception e) {
            Log.e(Parameter.TAG, "Catch Exception from FtdiAdapter : " + e.getMessage());
            throw new CommunicationException(e.getMessage());
        }
    }

    private void readUsbData() {
        byte[] rbuf = new byte[4096];
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int len = this.ftdiAdapter.ReadData(rbuf);
        for (int i = 0; i < len; i++) {
            this.loadSettingData.add(Byte.valueOf(rbuf[i]));
        }
    }

    private void ReadData() {
        byte[] rawData = new byte[24];
        byte[] rawData2 = new byte[96];
        int data2Index = 0;
        for (int j = 1; j < 196; j++) {
            if ((j < 49 || j > 73) && ((j < 98 || j > 122) && (j < 147 || j > 171))) {
                if (!this._isListen) {
                    return;
                }
                if (j <= 24) {
                    rawData[j - 1] = ((Byte) this.receivedSettingData.get(j)).byteValue();
                } else {
                    rawData2[data2Index] = ((Byte) this.receivedSettingData.get(j)).byteValue();
                    data2Index++;
                }
            }
        }
        this.dataValue = ByteArrayConverter.SettingValues(rawData);
        this.data2Value = ByteArrayConverter.DataToByteArray(rawData2, this.data2Value);
    }

    /* access modifiers changed from: private */
    public void ReadData2() {
        byte[] rawData = new byte[24];
        byte[] rawData2 = new byte[96];
        int data2Index = 0;
        int j = 1;
        while (j < this.byteSize) {
            if (this._isListen) {
                if (j <= 24) {
                    rawData[j - 1] = this.receivedSettingData2[j];
                } else {
                    rawData2[data2Index] = this.receivedSettingData2[j];
                    data2Index++;
                }
                if (j == 48) {
                    j = 73;
                } else if (j == 97) {
                    j = 122;
                } else if (j == 146) {
                    j = 171;
                }
                j++;
            } else {
                return;
            }
        }
        this.dataValue = ByteArrayConverter.SettingValues(rawData);
        this.data2Value = ByteArrayConverter.DataToByteArray(rawData2, this.data2Value);
    }

    /* access modifiers changed from: private */
    public void connected() throws InterruptedException {
        do {
            if (!this.ftdiAdapter.isConnected()) {
                Log.d(Parameter.TAG, "Device disconnected");
                this.mIsListen = false;
                this.linkCount++;
                if (this.linkCount == 10) {
                    Thread.sleep(1000);
                    this.linkCount = 0;
                }
            } else {
                this.mIsListen = true;
            }
            if (this.mIsListen) {
                return;
            }
        } while (this._isListen);
    }

    /* access modifiers changed from: private */
    public void SetSensorData() {
        String SensorType;
        for (GaugePageSetting mPageSetting : GaugeActivity.mGaugePagerAdapter.getPageSettingList()) {
            for (GaugeViewSetting mViewSetting : mPageSetting.getGaugeViewList()) {
                if (mViewSetting.getDataType() != null) {
                    if (mViewSetting.getDataType() == DataTypes.Servo) {
                        setServor(mViewSetting);
                    } else {
                        if (mViewSetting.getSensorType() == null) {
                            SensorType = "";
                        } else {
                            SensorType = mViewSetting.getSensorType().toString();
                        }
                        if (SensorType.equals("Receiver")) {
                            setReceiver(mViewSetting);
                        } else if (SensorType.equals("Voltage")) {
                            setVoltage(mViewSetting);
                        } else if (SensorType.equals("Temperature")) {
                            setTemperature(mViewSetting);
                        } else if (SensorType.equals("RPM")) {
                            setRpm(mViewSetting);
                        } else if (SensorType.equals("Altitude")) {
                            setAltitude(mViewSetting);
                        } else if (SensorType.equals("GPS") || SensorType.equals("GPSLocus")) {
                            setGPS(mViewSetting);
                        }
                    }
                }
            }
        }
    }

    private void setServor(GaugeViewSetting mViewSetting) {
        if (this.dataValue != null && this.dataValue.size() > 0) {
            float[] values = new float[18];
            for (int i = 0; i < 18; i++) {
                String value = String.valueOf(this.dataValue.get(i)).trim();
                if (i >= 16) {
                    switch (Integer.valueOf(value).intValue()) {
                        case 0:
                            value = "-95.0";
                            break;
                        case 1:
                            value = "95.0";
                            break;
                    }
                    values[i] = Float.valueOf(value).floatValue();
                } else {
                    values[i] = Float.valueOf(String.valueOf(new BigDecimal((((double) Integer.parseInt(value)) * 0.0977039d) - 100.0d).setScale(1, 3))).floatValue();
                }
            }
            List<Object> valueList = new ArrayList<>();
            valueList.add(values);
            mViewSetting.setSersorValueList(valueList);
        }
    }

    /* access modifiers changed from: private */
    public void setRate() {
        try {
            switch (ByteArrayConverter.convertToInt(ByteArrayConverter.SlotsToBinaryArray(this.data2Value, 0, 1), 0, 2)) {
                case 0:
                    this._rateStatus = 1;
                    return;
                case 1:
                    this._rateStatus = 2;
                    return;
                case 2:
                    this._rateStatus = 3;
                    return;
                case 3:
                    this._rateStatus = 4;
                    return;
                default:
                    this._rateStatus = 0;
                    return;
            }
        } catch (Exception e) {
            Log.d(Parameter.TAG, "Service setReceiver Error:" + e.getMessage());
        }
        Log.d(Parameter.TAG, "Service setReceiver Error:" + e.getMessage());
    }

    private void setReceiver(GaugeViewSetting mViewSetting) {
        String[] voltageValues = new String[2];
        List<Object> valueList = new ArrayList<>();
        String str = "";
        try {
            if (mViewSetting.getSersorValueList().size() != 0) {
                voltageValues = (String[]) mViewSetting.getSersorValueList().get(0);
            }
            char[] collectChars = ByteArrayConverter.SlotsToBinaryArray(this.data2Value, mViewSetting.getSlot(), 1);
            String strValue = new BigDecimal(((double) ByteArrayConverter.convertToInt(collectChars, 6, 10)) / 10.0d).setScale(1, 4).toString();
            switch (ByteArrayConverter.convertToInt(collectChars, 4, 2)) {
                case 0:
                    voltageValues[0] = strValue;
                    this.rxFlog = true;
                    break;
                case 1:
                    voltageValues[1] = strValue;
                    this.extFlog = true;
                    break;
            }
            valueList.add(voltageValues);
            mViewSetting.setSersorValueList(valueList);
            if (this.rxFlog && mViewSetting.getAlertEnable() && (mViewSetting.getAlertMax() < ((double) Float.valueOf(voltageValues[0]).floatValue()) || mViewSetting.getAlertMin() > ((double) Float.valueOf(voltageValues[0]).floatValue()))) {
                this._alertStutas = true;
            }
            if (this.extFlog && mViewSetting.getAlert2Enable()) {
                if (mViewSetting.getAlert2Max() < ((double) Float.valueOf(voltageValues[1]).floatValue()) || mViewSetting.getAlert2Min() > ((double) Float.valueOf(voltageValues[1]).floatValue())) {
                    this._alertStutas = true;
                }
            }
        } catch (Exception e) {
            Log.d(Parameter.TAG, "Service setReceiver Error:" + e.getMessage());
        }
    }

    private void setVoltage(GaugeViewSetting mViewSetting) {
        String[] voltageValues = new String[2];
        List<Object> valueList = new ArrayList<>();
        try {
            if (mViewSetting.getSersorValueList().size() != 0) {
                voltageValues = (String[]) mViewSetting.getSersorValueList().get(0);
            }
            String str = "";
            String strReceiverValue = new BigDecimal(((double) ByteArrayConverter.convertToInt(ByteArrayConverter.SlotsToBinaryArray(this.data2Value, mViewSetting.getSlot(), 1), 1, 15)) / 10.0d).setScale(1, 4).toString();
            voltageValues[0] = strReceiverValue;
            String str2 = "";
            String strExternalValue = new BigDecimal(((double) ByteArrayConverter.convertToInt(ByteArrayConverter.SlotsToBinaryArray(this.data2Value, mViewSetting.getSlot() + 1, 1), 0, 16)) / 10.0d).setScale(1, 4).toString();
            voltageValues[1] = strExternalValue;
            valueList.add(voltageValues);
            mViewSetting.setSersorValueList(valueList);
            if ((mViewSetting.getShowBattery().equals("A") || mViewSetting.getShowBattery().equals("I")) && mViewSetting.getAlertEnable() && (mViewSetting.getAlertMax() < ((double) Float.valueOf(strReceiverValue).floatValue()) || mViewSetting.getAlertMin() > ((double) Float.valueOf(strReceiverValue).floatValue()))) {
                this._alertStutas = true;
            } else if ((!mViewSetting.getShowBattery().equals("A") && !mViewSetting.getShowBattery().equals("E")) || !mViewSetting.getAlert2Enable()) {
            } else {
                if (mViewSetting.getAlert2Max() < ((double) Float.valueOf(strExternalValue).floatValue()) || mViewSetting.getAlert2Min() > ((double) Float.valueOf(strExternalValue).floatValue())) {
                    this._alertStutas = true;
                }
            }
        } catch (Exception e) {
            Log.d(Parameter.TAG, "Service setVoltage Error:" + e.getMessage());
        }
    }

    private void setTemperature(GaugeViewSetting mViewSetting) {
        List<Object> valueList = new ArrayList<>();
        try {
            float fValue = Float.valueOf((float) (ByteArrayConverter.convertToInt(ByteArrayConverter.SlotsToBinaryArray2(this.data2Value, mViewSetting.getSlot(), 1), 1, 15) - 100)).floatValue();
            valueList.add(Float.valueOf(fValue));
            mViewSetting.setSersorValueList(valueList);
            if (mViewSetting.getAlertEnable()) {
                float value = Float.valueOf(fValue).floatValue();
                if (mViewSetting.getUnit().equals("˚F")) {
                    value = Float.valueOf(new BigDecimal((((double) (9.0f * value)) / 5.0d) + 32.0d).setScale(1, 4).toString()).floatValue();
                }
                if (mViewSetting.getAlertMax() < ((double) value) || mViewSetting.getAlertMin() > ((double) value)) {
                    this._alertStutas = true;
                }
            }
        } catch (Exception e) {
            Log.d(Parameter.TAG, "Service setTemperature Error:" + e.getMessage());
        }
    }

    private void setRpm(GaugeViewSetting mViewSetting) {
        List<Object> valueList = new ArrayList<>();
        try {
            char[] collectChars = ByteArrayConverter.SlotsToBinaryArray2(this.data2Value, mViewSetting.getSlot(), 1);
            String strValue = String.valueOf((int) (((double) (ByteArrayConverter.convertToInt(collectChars, 0, 16) * 6)) / new JSONObject(mViewSetting.getAttributes()).getDouble("Range")));
            valueList.add(Double.valueOf(strValue));
            mViewSetting.setSersorValueList(valueList);
            if (mViewSetting.getAlertEnable()) {
                if (mViewSetting.getAlertMax() < ((double) Float.valueOf(strValue).floatValue()) || mViewSetting.getAlertMin() > ((double) Float.valueOf(strValue).floatValue())) {
                    this._alertStutas = true;
                }
            }
        } catch (Exception e) {
            Log.d(Parameter.TAG, "Service setRpm Error:" + e.getMessage());
        }
    }

    private void setAltitude(GaugeViewSetting mViewSetting) {
        List<Object> valueList = new ArrayList<>();
        try {
            char[] collectChars = ByteArrayConverter.SlotsToBinaryArray2(this.data2Value, mViewSetting.getSlot(), 3);
            valueList.add(Integer.valueOf((ByteArrayConverter.convertToInt(collectChars, 3, 12) / 10) - 150));
            float regulateValue = 0.0f;
            if (mViewSetting.getRegulateValue().size() != 0) {
                regulateValue = ((Float) mViewSetting.getRegulateValue().get(0)).floatValue();
            }
            valueList.add(Float.valueOf(((float) ((ByteArrayConverter.convertToInt(collectChars, 15, 16) - 8551) / 10)) - regulateValue));
            valueList.add(Float.valueOf(new BigDecimal(((double) ByteArrayConverter.convertToInt(collectChars, 31, 17)) / 100.0d).setScale(1, 4).toString()));
            float fAltitudeValue = ((float) (ByteArrayConverter.convertToInt(collectChars, 15, 16) - 8551)) / 10.0f;
            valueList.add(Float.valueOf(fAltitudeValue));
            mViewSetting.setSersorValueList(valueList);
            if (mViewSetting.getAlertEnable()) {
                if (mViewSetting.getAlertMax() < ((double) Float.valueOf(fAltitudeValue - regulateValue).floatValue()) || mViewSetting.getAlertMin() > ((double) Float.valueOf(fAltitudeValue - regulateValue).floatValue())) {
                    this._alertStutas = true;
                }
            }
        } catch (Exception e) {
            Log.d(Parameter.TAG, "Service setAltitude Error:" + e.getMessage());
        }
    }

    private void setGPS(GaugeViewSetting mViewSetting) {
        ArrayList arrayList = new ArrayList();
        try {
            char[] collectChars = ByteArrayConverter.SlotsToBinaryArray2(this.data2Value, mViewSetting.getSlot(), 8);
            int intGpsEnable = ByteArrayConverter.convertToInt(collectChars, 46, 1);
            arrayList.add(Integer.valueOf(intGpsEnable));
            if (intGpsEnable == 0) {
                mViewSetting.setSersorValueList(arrayList);
                return;
            }
            arrayList.add(Double.valueOf((((double) ByteArrayConverter.convertToInt(collectChars, 1, 12)) / 10.0d) - 150.0d));
            int speedValue = ByteArrayConverter.convertToInt(collectChars, 47, 9);
            arrayList.add(Integer.valueOf(speedValue));
            arrayList.add(Double.valueOf(((double) (ByteArrayConverter.convertToInt(collectChars, 13, 16) - 8551)) / 10.0d));
            String lonStr = "";
            switch (ByteArrayConverter.convertToInt(collectChars, 56, 1)) {
                case 0:
                    lonStr = "E";
                    break;
                case 1:
                    lonStr = "W";
                    break;
            }
            int lonValue = ByteArrayConverter.convertToInt(collectChars, 57, 27);
            arrayList.add(new String[]{lonStr, String.valueOf(lonValue)});
            String latStr = "";
            switch (ByteArrayConverter.convertToInt(collectChars, 84, 1)) {
                case 0:
                    latStr = "N";
                    break;
                case 1:
                    latStr = "S";
                    break;
            }
            int latValue = ByteArrayConverter.convertToInt(collectChars, 85, 26);
            arrayList.add(new String[]{latStr, String.valueOf(latValue)});
            mViewSetting.setSersorValueList(arrayList);
            if (GaugeActivity.IsWriteLog()) {
                WriteLog.WriteGPSLog(GaugeActivity.getLogFileName() + "-GPS" + mViewSetting.getPageNo() + "-Slot" + mViewSetting.getSlot(), new LatLng((((double) latValue) / 60.0d) / 10000.0d, (((double) lonValue) / 60.0d) / 10000.0d), 0.0d, Double.valueOf(new BigDecimal(speedValue).setScale(1, 4).toString()).doubleValue());
            }
        } catch (Exception e) {
            Log.d(Parameter.TAG, "Service setGPS Error:" + e.getMessage());
        }
    }
}
