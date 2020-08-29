package com.ftdi.j2xx;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbRequest;
import android.support.p000v4.view.MotionEventCompat;
import android.util.Log;
import com.ftdi.j2xx.D2xxManager.D2xxException;
import com.ftdi.j2xx.D2xxManager.DriverParameters;
import com.ftdi.j2xx.D2xxManager.FtDeviceInfoListNode;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FT_Device {
    private static final String TAG = "FTDI_Device::";
    private BulkInWorker mBulkIn;
    UsbEndpoint mBulkInEndpoint;
    private Thread mBulkInThread;
    UsbEndpoint mBulkOutEndpoint;
    Context mContext;
    FtDeviceInfoListNode mDeviceInfoNode;
    private DriverParameters mDriverParams;
    private FT_EE_Ctrl mEEPROM;
    long mEventMask;
    TFtEventNotify mEventNotification;
    private int mInterfaceID = 0;
    Boolean mIsOpen;
    private byte mLatencyTimer;
    private int mMaxPacketSize;
    private ProcessInCtrl mProcessInCtrl;
    private Thread mProcessRequestThread;
    TFtSpecialChars mTftSpecialChars;
    private UsbDeviceConnection mUsbConnection;
    UsbDevice mUsbDevice;
    UsbInterface mUsbInterface;

    public FT_Device(Context parentContext, UsbManager usbManager, UsbDevice dev, UsbInterface itf) {
        byte[] buffer = new byte[MotionEventCompat.ACTION_MASK];
        this.mContext = parentContext;
        this.mDriverParams = new DriverParameters();
        try {
            this.mUsbDevice = dev;
            this.mUsbInterface = itf;
            this.mBulkOutEndpoint = null;
            this.mBulkInEndpoint = null;
            this.mMaxPacketSize = 0;
            this.mTftSpecialChars = new TFtSpecialChars();
            this.mEventNotification = new TFtEventNotify();
            this.mDeviceInfoNode = new FtDeviceInfoListNode();
            setConnection(usbManager.openDevice(this.mUsbDevice));
            if (getConnection() == null) {
                Log.e(TAG, "Failed to open the device!");
                throw new D2xxException("Failed to open the device!");
            }
            getConnection().claimInterface(this.mUsbInterface, false);
            byte[] rawDescriptors = getConnection().getRawDescriptors();
            int devID = this.mUsbDevice.getDeviceId();
            this.mInterfaceID = this.mUsbInterface.getId() + 1;
            this.mDeviceInfoNode.location = (devID << 4) | (this.mInterfaceID & 15);
            ByteBuffer bcdDevice = ByteBuffer.allocate(2);
            bcdDevice.order(ByteOrder.LITTLE_ENDIAN);
            bcdDevice.put(rawDescriptors[12]);
            bcdDevice.put(rawDescriptors[13]);
            this.mDeviceInfoNode.bcdDevice = bcdDevice.getShort(0);
            this.mDeviceInfoNode.iSerialNumber = rawDescriptors[16];
            this.mDeviceInfoNode.serialNumber = getConnection().getSerial();
            this.mDeviceInfoNode.breakOnParam = 8;
            getConnection().controlTransfer(-128, 6, rawDescriptors[15] | 768, 0, buffer, MotionEventCompat.ACTION_MASK, 0);
            this.mDeviceInfoNode.description = stringFromUtf16le(buffer);
            switch (this.mDeviceInfoNode.bcdDevice & 65280) {
                case 512:
                    if (this.mDeviceInfoNode.iSerialNumber != 0) {
                        this.mDeviceInfoNode.type = 1;
                        this.mEEPROM = new FT_EE_232A_Ctrl(this);
                        break;
                    } else {
                        this.mEEPROM = new FT_EE_232B_Ctrl(this);
                        this.mDeviceInfoNode.type = 0;
                        break;
                    }
                case 1024:
                    this.mEEPROM = new FT_EE_232B_Ctrl(this);
                    this.mDeviceInfoNode.type = 0;
                    break;
                case 1280:
                    this.mEEPROM = new FT_EE_2232_Ctrl(this);
                    this.mDeviceInfoNode.type = 4;
                    dualQuadChannelDevice();
                    break;
                case 1536:
                    this.mEEPROM = new FT_EE_Ctrl(this);
                    short word00x00 = (short) (this.mEEPROM.readWord(0) & 1);
                    this.mEEPROM = null;
                    if (word00x00 != 0) {
                        this.mDeviceInfoNode.type = 5;
                        this.mEEPROM = new FT_EE_245R_Ctrl(this);
                        break;
                    } else {
                        this.mDeviceInfoNode.type = 5;
                        this.mEEPROM = new FT_EE_232R_Ctrl(this);
                        break;
                    }
                case 1792:
                    this.mDeviceInfoNode.type = 6;
                    dualQuadChannelDevice();
                    this.mEEPROM = new FT_EE_2232H_Ctrl(this);
                    break;
                case 2048:
                    this.mDeviceInfoNode.type = 7;
                    dualQuadChannelDevice();
                    this.mEEPROM = new FT_EE_4232H_Ctrl(this);
                    break;
                case 2304:
                    this.mDeviceInfoNode.type = 8;
                    this.mEEPROM = new FT_EE_232H_Ctrl(this);
                    break;
                case 4096:
                    this.mDeviceInfoNode.type = 9;
                    this.mEEPROM = new FT_EE_X_Ctrl(this);
                    break;
                default:
                    this.mDeviceInfoNode.type = 3;
                    this.mEEPROM = new FT_EE_Ctrl(this);
                    break;
            }
            getConnection().releaseInterface(this.mUsbInterface);
            getConnection().close();
            setConnection(null);
            setClosed();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e(TAG, e.getMessage());
            }
        }
    }

    private final boolean isHiSpeed() {
        return isFt232h() || isFt2232h() || isFt4232h();
    }

    private final boolean isBmDevice() {
        return isFt232b() || isFt2232() || isFt232r() || isFt2232h() || isFt4232h() || isFt232h() || isFt232ex();
    }

    /* access modifiers changed from: 0000 */
    public final boolean isMultiIfDevice() {
        return isFt2232() || isFt2232h() || isFt4232h();
    }

    private final boolean isFt232ex() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 4096;
    }

    private final boolean isFt232h() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 2304;
    }

    /* access modifiers changed from: 0000 */
    public final boolean isFt4232h() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 2048;
    }

    private final boolean isFt2232h() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 1792;
    }

    private final boolean isFt232r() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 1536;
    }

    private final boolean isFt2232() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 1280;
    }

    private final boolean isFt232b() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 1024 || ((this.mDeviceInfoNode.bcdDevice & 65280) == 512 && this.mDeviceInfoNode.iSerialNumber == 0);
    }

    private final boolean ifFt8u232am() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 512 && this.mDeviceInfoNode.iSerialNumber != 0;
    }

    private final String stringFromUtf16le(byte[] data) throws UnsupportedEncodingException {
        return new String(data, 2, data[0] - 2, "UTF-16LE");
    }

    /* access modifiers changed from: 0000 */
    public UsbDeviceConnection getConnection() {
        return this.mUsbConnection;
    }

    /* access modifiers changed from: 0000 */
    public void setConnection(UsbDeviceConnection mUsbConnection2) {
        this.mUsbConnection = mUsbConnection2;
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean setContext(Context parentContext) {
        boolean rc;
        rc = false;
        if (parentContext != null) {
            this.mContext = parentContext;
            rc = true;
        }
        return rc;
    }

    /* access modifiers changed from: protected */
    public void setDriverParameters(DriverParameters params) {
        this.mDriverParams.setMaxBufferSize(params.getMaxBufferSize());
        this.mDriverParams.setMaxTransferSize(params.getMaxTransferSize());
        this.mDriverParams.setBufferNumber(params.getBufferNumber());
        this.mDriverParams.setReadTimeout(params.getReadTimeout());
    }

    /* access modifiers changed from: 0000 */
    public DriverParameters getDriverParameters() {
        return this.mDriverParams;
    }

    private void dualQuadChannelDevice() {
        if (this.mInterfaceID == 1) {
            this.mDeviceInfoNode.serialNumber += "A";
            this.mDeviceInfoNode.description += " A";
        } else if (this.mInterfaceID == 2) {
            this.mDeviceInfoNode.serialNumber += "B";
            this.mDeviceInfoNode.description += " B";
        } else if (this.mInterfaceID == 3) {
            this.mDeviceInfoNode.serialNumber += "C";
            this.mDeviceInfoNode.description += " C";
        } else if (this.mInterfaceID == 4) {
            this.mDeviceInfoNode.serialNumber += "D";
            this.mDeviceInfoNode.description += " D";
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean openDevice(UsbManager usbManager) {
        boolean z;
        if (isOpen()) {
            z = false;
        } else if (usbManager == null) {
            Log.e(TAG, "UsbManager cannot be null.");
            z = false;
        } else if (getConnection() != null) {
            Log.e(TAG, "There should not have an UsbConnection.");
            z = false;
        } else {
            setConnection(usbManager.openDevice(this.mUsbDevice));
            if (getConnection() == null) {
                Log.e(TAG, "UsbConnection cannot be null.");
                z = false;
            } else if (!getConnection().claimInterface(this.mUsbInterface, true)) {
                Log.e(TAG, "ClaimInteface returned false.");
                z = false;
            } else {
                Log.d(TAG, "open SUCCESS");
                if (!findDeviceEndpoints()) {
                    Log.e(TAG, "Failed to find endpoints.");
                    z = false;
                } else {
                    Log.d("D2XX::", "**********************Device Opened**********************");
                    this.mProcessInCtrl = new ProcessInCtrl(this);
                    this.mBulkIn = new BulkInWorker(this, this.mProcessInCtrl, getConnection(), this.mBulkInEndpoint);
                    this.mBulkInThread = new Thread(this.mBulkIn);
                    this.mBulkInThread.setName("bulkInThread");
                    this.mProcessRequestThread = new Thread(new ProcessRequestWorker(this.mProcessInCtrl));
                    this.mProcessRequestThread.setName("processRequestThread");
                    purgeRxTx(true, true);
                    this.mBulkInThread.start();
                    this.mProcessRequestThread.start();
                    setOpen();
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized boolean isOpen() {
        return this.mIsOpen.booleanValue();
    }

    private synchronized void setOpen() {
        this.mIsOpen = Boolean.valueOf(true);
    }

    private synchronized void setClosed() {
        this.mIsOpen = Boolean.valueOf(false);
    }

    public synchronized void close() {
        if (this.mProcessRequestThread != null) {
            this.mProcessRequestThread.interrupt();
        }
        if (this.mBulkInThread != null) {
            this.mBulkInThread.interrupt();
        }
        if (this.mUsbConnection != null) {
            this.mUsbConnection.releaseInterface(this.mUsbInterface);
            this.mUsbConnection.close();
            this.mUsbConnection = null;
        }
        if (this.mProcessInCtrl != null) {
            this.mProcessInCtrl.close();
        }
        this.mProcessRequestThread = null;
        this.mBulkInThread = null;
        this.mBulkIn = null;
        this.mProcessInCtrl = null;
        setClosed();
    }

    /* access modifiers changed from: protected */
    public UsbDevice getUsbDevice() {
        return this.mUsbDevice;
    }

    public FtDeviceInfoListNode getDeviceInfo() {
        return this.mDeviceInfoNode;
    }

    public int read(byte[] data, int length, long wait_ms) {
        if (!isOpen()) {
            return -1;
        }
        if (length <= 0) {
            return -2;
        }
        if (this.mProcessInCtrl == null) {
            return -3;
        }
        return this.mProcessInCtrl.readBulkInData(data, length, wait_ms);
    }

    public int read(byte[] data, int length) {
        return read(data, length, (long) this.mDriverParams.getReadTimeout());
    }

    public int read(byte[] data) {
        return read(data, data.length, (long) this.mDriverParams.getReadTimeout());
    }

    public int write(byte[] data, int length) {
        return write(data, length, true);
    }

    public int write(byte[] data, int length, boolean wait) {
        int rc = 0;
        if (!isOpen()) {
            return 0;
        }
        if (length <= 0) {
            return 0;
        }
        UsbRequest request = new UsbRequest();
        request.initialize(this.mUsbConnection, this.mBulkOutEndpoint);
        if (wait) {
            request.setClientData(this);
        }
        if (request.queue(ByteBuffer.wrap(data), length)) {
            rc = length;
        }
        if (wait) {
            do {
            } while (this.mUsbConnection.requestWait().getClientData() != this);
        }
        return rc;
    }

    public int write(byte[] data) {
        return write(data, data.length, true);
    }

    public short getModemStatus() {
        if (!isOpen()) {
            return -1;
        }
        if (this.mProcessInCtrl == null) {
            return -2;
        }
        this.mEventMask &= -3;
        return (short) (this.mDeviceInfoNode.modemStatus & 255);
    }

    public short getLineStatus() {
        if (!isOpen()) {
            return -1;
        }
        if (this.mProcessInCtrl == null) {
            return -2;
        }
        return this.mDeviceInfoNode.lineStatus;
    }

    public int getQueueStatus() {
        if (!isOpen()) {
            return -1;
        }
        if (this.mProcessInCtrl == null) {
            return -2;
        }
        return this.mProcessInCtrl.getBytesAvailable();
    }

    public boolean readBufferFull() {
        return this.mProcessInCtrl.isSinkFull();
    }

    public long getEventStatus() {
        if (!isOpen()) {
            return -1;
        }
        if (this.mProcessInCtrl == null) {
            return -2;
        }
        long j = this.mEventMask;
        this.mEventMask = 0;
        return j;
    }

    public boolean setBaudRate(int baudRate) {
        int result = 1;
        int[] divisors = new int[2];
        boolean boolresult = false;
        if (!isOpen()) {
            return false;
        }
        switch (baudRate) {
            case 300:
                divisors[0] = 10000;
                break;
            case 600:
                divisors[0] = 5000;
                break;
            case 1200:
                divisors[0] = 2500;
                break;
            case 2400:
                divisors[0] = 1250;
                break;
            case 4800:
                divisors[0] = 625;
                break;
            case 9600:
                divisors[0] = 16696;
                break;
            case 19200:
                divisors[0] = 32924;
                break;
            case 38400:
                divisors[0] = 49230;
                break;
            case 57600:
                divisors[0] = 52;
                break;
            case 115200:
                divisors[0] = 26;
                break;
            case 230400:
                divisors[0] = 13;
                break;
            case 460800:
                divisors[0] = 16390;
                break;
            case 921600:
                divisors[0] = 32771;
                break;
            default:
                if (!isHiSpeed() || baudRate < 1200) {
                    result = FT_BaudRate.FT_GetDivisor(baudRate, divisors, isBmDevice());
                } else {
                    result = FT_BaudRate.FT_GetDivisorHi(baudRate, divisors);
                }
                break;
        }
        if (isMultiIfDevice() || isFt232h() || isFt232ex()) {
            divisors[1] = divisors[1] << 8;
            divisors[1] = divisors[1] & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            divisors[1] = divisors[1] | this.mInterfaceID;
        }
        if (result == 1 && getConnection().controlTransfer(64, 3, divisors[0], divisors[1], null, 0, 0) == 0) {
            boolresult = true;
        }
        return boolresult;
    }

    public boolean setDataCharacteristics(byte dataBits, byte stopBits, byte parity) {
        boolean rc = false;
        if (!isOpen()) {
            return false;
        }
        short wValue = (short) ((stopBits << 11) | ((short) ((parity << 8) | dataBits)));
        this.mDeviceInfoNode.breakOnParam = wValue;
        if (getConnection().controlTransfer(64, 4, wValue, this.mInterfaceID, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    public boolean setBreakOn() {
        return setBreak(16384);
    }

    public boolean setBreakOff() {
        return setBreak(0);
    }

    private boolean setBreak(int OnOrOff) {
        boolean rc = false;
        int wValue = this.mDeviceInfoNode.breakOnParam | OnOrOff;
        if (!isOpen()) {
            return false;
        }
        if (getConnection().controlTransfer(64, 4, wValue, this.mInterfaceID, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    public boolean setFlowControl(short flowControl, byte xon, byte xoff) {
        boolean rc = false;
        short wValue = 0;
        short wIndex = flowControl;
        if (!isOpen()) {
            return false;
        }
        if (wIndex == 1024) {
            wValue = (short) ((xon & 255) | ((short) (xoff << 8)));
        }
        if (getConnection().controlTransfer(64, 2, wValue, this.mInterfaceID | wIndex, null, 0, 0) == 0) {
            if (flowControl == 256) {
                rc = setRts();
            } else if (flowControl == 512) {
                rc = setDtr();
            }
        }
        return rc;
    }

    public boolean setRts() {
        boolean rc = false;
        if (!isOpen()) {
            return false;
        }
        if (getConnection().controlTransfer(64, 1, 514, this.mInterfaceID, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    public boolean clrRts() {
        boolean rc = false;
        if (!isOpen()) {
            return false;
        }
        if (getConnection().controlTransfer(64, 1, 512, this.mInterfaceID, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    public boolean setDtr() {
        boolean rc = false;
        if (!isOpen()) {
            return false;
        }
        if (getConnection().controlTransfer(64, 1, 257, this.mInterfaceID, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    public boolean clrDtr() {
        boolean rc = false;
        if (!isOpen()) {
            return false;
        }
        if (getConnection().controlTransfer(64, 1, 256, this.mInterfaceID, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    public boolean setChars(byte eventChar, byte eventCharEnable, byte errorChar, byte errorCharEnable) {
        boolean rc = false;
        TFtSpecialChars SpecialChars = new TFtSpecialChars();
        SpecialChars.EventChar = eventChar;
        SpecialChars.EventCharEnabled = eventCharEnable;
        SpecialChars.ErrorChar = errorChar;
        SpecialChars.ErrorCharEnabled = errorCharEnable;
        if (!isOpen()) {
            return false;
        }
        int wValue = eventChar & MotionEventCompat.ACTION_MASK;
        if (eventCharEnable != 0) {
            wValue |= 256;
        }
        if (getConnection().controlTransfer(64, 6, wValue, this.mInterfaceID, null, 0, 0) != 0) {
            return false;
        }
        int wValue2 = errorChar & MotionEventCompat.ACTION_MASK;
        if (errorCharEnable > 0) {
            wValue2 |= 256;
        }
        if (getConnection().controlTransfer(64, 7, wValue2, this.mInterfaceID, null, 0, 0) == 0) {
            this.mTftSpecialChars = SpecialChars;
            rc = true;
        }
        return rc;
    }

    public boolean setBitMode(byte mask, byte bitMode) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        int devType = this.mDeviceInfoNode.type;
        boolean boolStatus = false;
        if (!isOpen()) {
            return false;
        }
        if (devType == 1) {
            return false;
        }
        if (devType != 0 || bitMode == 0) {
            if (devType != 4 || bitMode == 0) {
                if (devType != 5 || bitMode == 0) {
                    if (devType != 6 || bitMode == 0) {
                        if (devType != 7 || bitMode == 0) {
                            if (devType == 8 && bitMode != 0 && bitMode > 64) {
                                return false;
                            }
                        } else if ((bitMode & 7) == 0) {
                            return false;
                        } else {
                            if (bitMode == 2) {
                                z = true;
                            } else {
                                z = false;
                            }
                            boolean z5 = z & (this.mUsbInterface.getId() != 0);
                            if (this.mUsbInterface.getId() == 1) {
                                z4 = false;
                            }
                            if (z5 && z4) {
                                return false;
                            }
                        }
                    } else if ((bitMode & 95) == 0) {
                        return false;
                    } else {
                        if ((bitMode & 72) > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (this.mUsbInterface.getId() == 0) {
                            z4 = false;
                        }
                        if (z2 && z4) {
                            return false;
                        }
                    }
                } else if ((bitMode & 37) == 0) {
                    return false;
                }
            } else if ((bitMode & 29) == 0) {
                return false;
            } else {
                if (bitMode == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.mUsbInterface.getId() == 0) {
                    z4 = false;
                }
                if (z3 && z4) {
                    return false;
                }
            }
        } else if ((bitMode & 1) == 0) {
            return false;
        }
        if (getConnection().controlTransfer(64, 11, (bitMode << 8) | (mask & MotionEventCompat.ACTION_MASK), this.mInterfaceID, null, 0, 0) == 0) {
            boolStatus = true;
        }
        return boolStatus;
    }

    public byte getBitMode() {
        byte[] buf = new byte[1];
        if (!isOpen()) {
            return -1;
        }
        if (!isBmDevice()) {
            return -2;
        }
        if (getConnection().controlTransfer(-64, 12, 0, this.mInterfaceID, buf, buf.length, 0) == buf.length) {
            return buf[0];
        }
        return -3;
    }

    public boolean resetDevice() {
        boolean rc = false;
        if (!isOpen()) {
            return false;
        }
        if (getConnection().controlTransfer(64, 0, 0, 0, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    public void stopInTask() {
        try {
            if (!this.mBulkIn.paused()) {
                this.mBulkIn.pause();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void restartInTask() {
        this.mBulkIn.restart();
    }

    public boolean stoppedInTask() {
        return this.mBulkIn.paused();
    }

    public boolean purge(byte flags) {
        boolean RXBuffer = false;
        boolean TXBuffer = false;
        if ((flags & 1) == 1) {
            RXBuffer = true;
        }
        if ((flags & 2) == 2) {
            TXBuffer = true;
        }
        return purgeRxTx(RXBuffer, TXBuffer);
    }

    private boolean purgeRxTx(boolean RXBuffer, boolean TXBuffer) {
        boolean rc = false;
        int status = 0;
        if (!isOpen()) {
            return false;
        }
        if (RXBuffer) {
            for (int i = 0; i < 6; i++) {
                status = getConnection().controlTransfer(64, 0, 1, this.mInterfaceID, null, 0, 0);
            }
            if (status > 0) {
                return false;
            }
            this.mProcessInCtrl.purgeINData();
        }
        if (TXBuffer && getConnection().controlTransfer(64, 0, 2, this.mInterfaceID, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    public boolean setLatencyTimer(byte latency) {
        boolean rc;
        int wValue = latency & MotionEventCompat.ACTION_MASK;
        if (!isOpen()) {
            return false;
        }
        if (getConnection().controlTransfer(64, 9, wValue, this.mInterfaceID, null, 0, 0) == 0) {
            this.mLatencyTimer = latency;
            rc = true;
        } else {
            rc = false;
        }
        return rc;
    }

    public byte getLatencyTimer() {
        byte[] latency = new byte[1];
        if (!isOpen()) {
            return -1;
        }
        if (getConnection().controlTransfer(-64, 10, 0, this.mInterfaceID, latency, latency.length, 0) == latency.length) {
            return latency[0];
        }
        return 0;
    }

    public boolean setEventNotification(long Mask) {
        boolean rc = false;
        if (!isOpen()) {
            return false;
        }
        if (Mask != 0) {
            this.mEventMask = 0;
            this.mEventNotification.Mask = Mask;
            rc = true;
        }
        return rc;
    }

    private boolean findDeviceEndpoints() {
        for (int i = 0; i < this.mUsbInterface.getEndpointCount(); i++) {
            Log.i(TAG, "EP: " + String.format("0x%02X", new Object[]{Integer.valueOf(this.mUsbInterface.getEndpoint(i).getAddress())}));
            if (this.mUsbInterface.getEndpoint(i).getType() != 2) {
                Log.e(TAG, "Not Bulk");
            } else if (this.mUsbInterface.getEndpoint(i).getDirection() == 128) {
                this.mBulkInEndpoint = this.mUsbInterface.getEndpoint(i);
                this.mMaxPacketSize = this.mBulkInEndpoint.getMaxPacketSize();
            } else {
                this.mBulkOutEndpoint = this.mUsbInterface.getEndpoint(i);
            }
        }
        if (this.mBulkOutEndpoint == null || this.mBulkInEndpoint == null) {
            return false;
        }
        return true;
    }

    public FT_EEPROM eepromRead() {
        if (!isOpen()) {
            return null;
        }
        return this.mEEPROM.readEeprom();
    }

    public short eepromWrite(FT_EEPROM eeData) {
        if (!isOpen()) {
            return -1;
        }
        return this.mEEPROM.programEeprom(eeData);
    }

    public boolean eepromErase() {
        boolean rc = false;
        if (!isOpen()) {
            return false;
        }
        if (this.mEEPROM.eraseEeprom() == 0) {
            rc = true;
        }
        return rc;
    }

    public int eepromWriteUserArea(byte[] data) {
        if (!isOpen()) {
            return 0;
        }
        return this.mEEPROM.writeUserData(data);
    }

    public byte[] eepromReadUserArea(int length) {
        if (!isOpen()) {
            return null;
        }
        return this.mEEPROM.readUserData(length);
    }

    public int eepromGetUserAreaSize() {
        if (!isOpen()) {
            return -1;
        }
        return this.mEEPROM.getUserSize();
    }

    public int eepromReadWord(short offset) {
        if (!isOpen()) {
            return -1;
        }
        return this.mEEPROM.readWord(offset);
    }

    public boolean eepromWriteWord(short address, short data) {
        if (!isOpen()) {
            return false;
        }
        return this.mEEPROM.writeWord(address, data);
    }

    /* access modifiers changed from: 0000 */
    public int getMaxPacketSize() {
        return this.mMaxPacketSize;
    }
}
