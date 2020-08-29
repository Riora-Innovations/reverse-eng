package com.futaba.androidmadlink.device;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.ftdi.j2xx.D2xxManager;
import com.ftdi.j2xx.D2xxManager.D2xxException;
import com.ftdi.j2xx.FT_Device;

public class FtdiAdapter {
    public static final int BUFFER_SIZE = 4096;
    private static FtdiAdapter _instance = null;
    public int BaudRate = 115200;
    public byte DataBit = 8;
    int DevCount = -1;
    public short FlowControl = 0;
    public byte Parity = 2;
    public byte StopBit = 2;
    protected final String TAG = "FtdiAdapter";
    D2xxManager d2xxManager;
    FT_Device ftDevice;
    Context parentContext;
    boolean uart_configured = false;

    public static FtdiAdapter getInstance(Context ctx) {
        if (_instance == null) {
            _instance = new FtdiAdapter(ctx);
        }
        return _instance;
    }

    public FtdiAdapter(Context ctx) {
        this.parentContext = ctx;
        try {
            this.d2xxManager = D2xxManager.getInstance(ctx);
        } catch (D2xxException ex) {
            ex.printStackTrace();
        }
        SetupD2xxLibrary();
    }

    public boolean isConnected() {
        if (this.d2xxManager == null || this.DevCount <= 0 || this.ftDevice == null) {
            return false;
        }
        return this.ftDevice.isOpen();
    }

    private void SetupD2xxLibrary() {
        Log.d("FtdiAdapter", "FtdiAdapter.SetupD2xxLibrary()");
        if (!this.d2xxManager.setVIDPID(4104, 3)) {
            Log.i("ftd2xx-java", "setVIDPID Error");
        }
    }

    private void CreateDeviceList() {
        Log.d("FtdiAdapter", "FtdiAdapter.createDeviceList()");
        int tempDevCount = this.d2xxManager.createDeviceInfoList(this.parentContext);
        if (tempDevCount > 0) {
            this.DevCount = tempDevCount;
        } else {
            this.DevCount = -1;
        }
    }

    public void Disconnect() {
        Log.d("FtdiAdapter", "FtdiAdapter.disconnect()");
        this.DevCount = -1;
        if (this.ftDevice != null) {
            synchronized (this.ftDevice) {
                if (this.ftDevice.isOpen()) {
                    this.ftDevice.close();
                }
            }
        }
    }

    public void Connect() {
        Log.d("FtdiAdapter", "FtdiAdapter.connect()");
        this.DevCount = 0;
        CreateDeviceList();
        if (this.DevCount > 0) {
            if (this.ftDevice == null) {
                this.ftDevice = this.d2xxManager.openByIndex(this.parentContext, 0);
            } else {
                synchronized (this.ftDevice) {
                    if (this.ftDevice.isOpen()) {
                        this.ftDevice.close();
                    }
                    this.ftDevice = this.d2xxManager.openByIndex(this.parentContext, 0);
                }
            }
            this.uart_configured = false;
            if (this.ftDevice == null) {
                Toast.makeText(this.parentContext, "open device port failed, ftDevice == null", 1).show();
            } else if (this.ftDevice.isOpen()) {
                SetConfig();
                Toast.makeText(this.parentContext, "open device port OK", 0).show();
            } else {
                Toast.makeText(this.parentContext, "open device port failed", 1).show();
            }
        }
    }

    public void SetConfig() {
        SetConfig(this.BaudRate, this.DataBit, this.StopBit, this.Parity, this.FlowControl);
    }

    /* access modifiers changed from: protected */
    public void SetConfig(int baud, byte dataBits, byte stopBits, byte parity, short flowControl) {
        byte dataBits2;
        byte stopBits2;
        byte parity2;
        short flowCtrlSetting;
        Log.d("FtdiAdapter", "BaseActivity.SetConfig()");
        if (this.ftDevice == null) {
            Log.e("FtdiAdapter", "SetConfig: device is null");
        } else if (!this.ftDevice.isOpen()) {
            Log.e("FtdiAdapter", "SetConfig: device not open");
        } else {
            this.ftDevice.setBitMode(0, 0);
            this.ftDevice.setBaudRate(baud);
            this.BaudRate = baud;
            switch (dataBits) {
                case 7:
                    dataBits2 = 7;
                    break;
                case 8:
                    dataBits2 = 8;
                    break;
                default:
                    dataBits2 = 8;
                    break;
            }
            this.DataBit = dataBits2;
            switch (stopBits) {
                case 1:
                    stopBits2 = 0;
                    break;
                case 2:
                    stopBits2 = 2;
                    break;
                default:
                    stopBits2 = 0;
                    break;
            }
            this.StopBit = stopBits2;
            switch (parity) {
                case 0:
                    parity2 = 0;
                    break;
                case 1:
                    parity2 = 1;
                    break;
                case 2:
                    parity2 = 2;
                    break;
                case 3:
                    parity2 = 3;
                    break;
                case 4:
                    parity2 = 4;
                    break;
                default:
                    parity2 = 1;
                    break;
            }
            this.Parity = parity2;
            this.ftDevice.setDataCharacteristics(dataBits2, stopBits2, parity2);
            switch (flowControl) {
                case 0:
                    flowCtrlSetting = 0;
                    break;
                case 1:
                    flowCtrlSetting = D2xxManager.FT_FLOW_RTS_CTS;
                    break;
                case 2:
                    flowCtrlSetting = D2xxManager.FT_FLOW_DTR_DSR;
                    break;
                case 3:
                    flowCtrlSetting = D2xxManager.FT_FLOW_XON_XOFF;
                    break;
                default:
                    flowCtrlSetting = 0;
                    break;
            }
            this.FlowControl = flowCtrlSetting;
            this.ftDevice.setFlowControl(flowCtrlSetting, 11, 13);
            this.uart_configured = true;
            Toast.makeText(this.parentContext, "Config done", 0).show();
        }
    }

    public int ReadData(byte[] buffer) {
        int iavailable = 0;
        if (this.ftDevice == null) {
            Log.e("FtdiAdapter", "SendMessage: device not open. ftDevice=null");
        } else if (!this.ftDevice.isOpen()) {
            Log.e("FtdiAdapter", "SendMessage: device not open");
        } else {
            synchronized (this.ftDevice) {
                Log.d("FtdiAdapter", "ftDevice.getQueueStatus Start");
                iavailable = this.ftDevice.getQueueStatus();
                Log.d("FtdiAdapter", "ftDevice.getQueueStatus End");
                if (iavailable > 0) {
                    Log.d("FtdiAdapter", "Available:" + iavailable);
                    if (iavailable > buffer.length) {
                        iavailable = buffer.length;
                    }
                    if (iavailable > 4096) {
                        iavailable = 4096;
                    }
                    this.ftDevice.read(buffer, iavailable);
                } else {
                    byte[] buffer2 = new byte[0];
                }
            }
        }
        return iavailable;
    }

    public boolean SendMessage(String msg) {
        if (msg == null || msg.length() == 0) {
            Log.e("FtdiAdapter", "SendMessage: Data Length is 0");
            return false;
        } else if (this.ftDevice == null) {
            Log.e("FtdiAdapter", "SendMessage: device not open. ftDevice=null");
            return false;
        } else if (!this.ftDevice.isOpen()) {
            Log.e("FtdiAdapter", "SendMessage: device not open");
            return false;
        } else {
            this.ftDevice.setLatencyTimer(16);
            this.ftDevice.write(msg.getBytes(), msg.length());
            return true;
        }
    }

    public boolean SendMessage(byte[] data) {
        return SendMessage(data, data.length);
    }

    public boolean SendMessage(byte[] data, int length) {
        if (data == null || data.length == 0) {
            Log.e("FtdiAdapter", "SendMessage: Data Length is 0");
            return false;
        } else if (this.ftDevice == null) {
            Log.e("FtdiAdapter", "SendMessage: device not open. ftDevice=null");
            return false;
        } else if (!this.ftDevice.isOpen()) {
            Log.e("FtdiAdapter", "SendMessage: device not open");
            return false;
        } else {
            this.ftDevice.setLatencyTimer(16);
            int len = length;
            if (data.length < length) {
                len = data.length;
            }
            if (len <= 4096) {
                this.ftDevice.write(data, len);
            } else {
                byte[] writeData = new byte[4096];
                int packetCout = 0;
                for (int i = 0; i < len; i++) {
                    writeData[i - (packetCout * 4096)] = data[i];
                    if (i % 4096 == 4095 || i == len - 1) {
                        Log.d("FtdiAdapter", "Write Settings Transmission Size[" + packetCout + "]:" + ((i - (packetCout * 4096)) + 1));
                        this.ftDevice.write(writeData, (i - (packetCout * 4096)) + 1);
                        packetCout++;
                        writeData = new byte[4096];
                    }
                }
            }
            return true;
        }
    }

    public boolean StartInTask() {
        if (this.ftDevice == null) {
            Log.e("FtdiAdapter", "SendMessage: device not open. ftDevice=null");
            return false;
        } else if (!this.ftDevice.isOpen()) {
            Log.e("FtdiAdapter", "SendMessage: device not open");
            return false;
        } else {
            this.ftDevice.purge(2);
            this.ftDevice.restartInTask();
            return true;
        }
    }

    public boolean StopInTask() {
        if (this.ftDevice == null) {
            Log.e("FtdiAdapter", "SendMessage: device not open. ftDevice=null");
            return false;
        } else if (!this.ftDevice.isOpen()) {
            Log.e("FtdiAdapter", "SendMessage: device not open");
            return false;
        } else {
            this.ftDevice.stopInTask();
            return true;
        }
    }

    public boolean ClearInBuffer() {
        if (this.ftDevice == null) {
            Log.e("FtdiAdapter", "SendMessage: device not open. ftDevice=null");
            return false;
        } else if (!this.ftDevice.isOpen()) {
            Log.e("FtdiAdapter", "SendMessage: device not open");
            return false;
        } else {
            this.ftDevice.purge(2);
            return true;
        }
    }

    public boolean ClearOutBuffer() {
        if (this.ftDevice == null) {
            Log.e("FtdiAdapter", "SendMessage: device not open. ftDevice=null");
            return false;
        } else if (!this.ftDevice.isOpen()) {
            Log.e("FtdiAdapter", "SendMessage: device not open");
            return false;
        } else {
            this.ftDevice.purge(1);
            return true;
        }
    }
}
