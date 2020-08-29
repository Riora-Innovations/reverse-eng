package com.ftdi.j2xx;

import android.support.p000v4.view.MotionEventCompat;
import android.util.Log;
import com.ftdi.j2xx.D2xxManager.D2xxException;
import com.google.android.gms.location.LocationRequest;

class FT_EE_Ctrl {
    private static final int BUS_POWERED = 128;
    private static final short EE_MAX_SIZE = 1024;
    private static final int ENABLE_SERIAL_NUMBER = 8;
    private static final int PULL_DOWN_IN_USB_SUSPEND = 4;
    private static final int SELF_POWERED = 64;
    private static final int USB_REMOTE_WAKEUP = 32;
    private FT_Device mDevice;
    boolean mEepromBlank;
    int mEepromSize;
    short mEepromType;

    static final class EepromType {
        static final short INVALID = 255;
        static final short TYPE_46 = 70;
        static final short TYPE_52 = 82;
        static final short TYPE_56 = 86;
        static final short TYPE_66 = 102;
        static final short TYPE_MTP = 1;

        EepromType() {
        }
    }

    FT_EE_Ctrl(FT_Device dev) {
        this.mDevice = dev;
    }

    /* access modifiers changed from: 0000 */
    public int readWord(short offset) {
        byte[] dataRead = new byte[2];
        Log.d("FT_EE_Ctrl", "Entered ReadWord.");
        if (offset >= 1024) {
            return -1;
        }
        this.mDevice.getConnection().controlTransfer(-64, 144, 0, offset, dataRead, 2, 0);
        return ((dataRead[1] & MotionEventCompat.ACTION_MASK) << 8) | (dataRead[0] & MotionEventCompat.ACTION_MASK);
    }

    /* access modifiers changed from: 0000 */
    public boolean writeWord(short offset, short value) {
        int wValue = value & 65535;
        int wIndex = offset & 65535;
        boolean rc = false;
        Log.d("FT_EE_Ctrl", "Entered WriteWord.");
        if (offset >= 1024) {
            return false;
        }
        if (this.mDevice.getConnection().controlTransfer(64, 145, wValue, wIndex, null, 0, 0) == 0) {
            rc = true;
        }
        return rc;
    }

    /* access modifiers changed from: 0000 */
    public int eraseEeprom() {
        return this.mDevice.getConnection().controlTransfer(64, 146, 0, 0, null, 0, 0);
    }

    /* access modifiers changed from: 0000 */
    public short programEeprom(FT_EEPROM eeprom) {
        return 1;
    }

    /* access modifiers changed from: 0000 */
    public boolean programEeprom(int[] dataToWrite, int ee_size) {
        int checksumLocation = ee_size - 1;
        int Checksum = 43690;
        for (int addressCounter = 0; addressCounter < checksumLocation; addressCounter++) {
            writeWord((short) addressCounter, (short) dataToWrite[addressCounter]);
            int TempChecksum = dataToWrite[addressCounter] ^ Checksum;
            Checksum = (TempChecksum << 1) | (TempChecksum >> 15);
        }
        writeWord((short) checksumLocation, (short) Checksum);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public FT_EEPROM readEeprom() {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public int setUSBConfig(Object ee) {
        FT_EEPROM ft = (FT_EEPROM) ee;
        int lowerbits = 0 | 128;
        if (ft.RemoteWakeup) {
            lowerbits |= 32;
        }
        if (ft.SelfPowered) {
            lowerbits |= 64;
        }
        return ((ft.MaxPower / 2) << 8) | lowerbits;
    }

    /* access modifiers changed from: 0000 */
    public void getUSBConfig(FT_EEPROM ee, int dataRead) {
        ee.MaxPower = (short) (((byte) (dataRead >> 8)) * 2);
        byte P = (byte) dataRead;
        if ((P & 64) == 64 && (P & D2xxManager.FT_DCD) == 128) {
            ee.SelfPowered = true;
        } else {
            ee.SelfPowered = false;
        }
        if ((P & 32) == 32) {
            ee.RemoteWakeup = true;
        } else {
            ee.RemoteWakeup = false;
        }
    }

    /* access modifiers changed from: 0000 */
    public int setDeviceControl(Object ee) {
        int data;
        FT_EEPROM ft = (FT_EEPROM) ee;
        if (ft.PullDownEnable) {
            data = 0 | 4;
        } else {
            data = 0 & 251;
        }
        if (ft.SerNumEnable) {
            return data | 8;
        }
        return data & 247;
    }

    /* access modifiers changed from: 0000 */
    public void getDeviceControl(Object ee, int dataRead) {
        FT_EEPROM ft = (FT_EEPROM) ee;
        if ((dataRead & 4) > 0) {
            ft.PullDownEnable = true;
        } else {
            ft.PullDownEnable = false;
        }
        if ((dataRead & 8) > 0) {
            ft.SerNumEnable = true;
        } else {
            ft.SerNumEnable = false;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [char[]] */
    /* JADX WARNING: type inference failed for: r4v5, types: [char] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char, code=null, for r4v5, types: [char] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=char[], code=null, for r3v0, types: [char[]] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setStringDescriptor(java.lang.String r7, int[] r8, int r9, int r10, boolean r11) {
        /*
            r6 = this;
            r1 = 0
            int r4 = r7.length()
            int r4 = r4 * 2
            int r2 = r4 + 2
            int r4 = r2 << 8
            int r5 = r9 * 2
            r4 = r4 | r5
            r8[r10] = r4
            if (r11 == 0) goto L_0x0018
            r4 = r8[r10]
            int r4 = r4 + 128
            r8[r10] = r4
        L_0x0018:
            char[] r3 = r7.toCharArray()
            int r0 = r9 + 1
            r4 = r2 | 768(0x300, float:1.076E-42)
            r8[r9] = r4
            int r2 = r2 + -2
            int r2 = r2 / 2
            r9 = r0
        L_0x0027:
            int r0 = r9 + 1
            char r4 = r3[r1]
            r8[r9] = r4
            int r1 = r1 + 1
            if (r1 < r2) goto L_0x0032
            return r0
        L_0x0032:
            r9 = r0
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ftdi.j2xx.FT_EE_Ctrl.setStringDescriptor(java.lang.String, int[], int, int, boolean):int");
    }

    /* access modifiers changed from: 0000 */
    public String getStringDescriptor(int addr, int[] dataRead) {
        String descriptor = "";
        int addr2 = addr + 1;
        int endaddr = addr2 + (((dataRead[addr] & MotionEventCompat.ACTION_MASK) / 2) - 1);
        for (int i = addr2; i < endaddr; i++) {
            descriptor = new StringBuilder(String.valueOf(descriptor)).append((char) dataRead[i]).toString();
        }
        return descriptor;
    }

    /* access modifiers changed from: 0000 */
    public void clearUserDataArea(int saddr, int eeprom_size, int[] data) {
        int saddr2 = saddr;
        while (saddr2 < eeprom_size) {
            int saddr3 = saddr2 + 1;
            data[saddr2] = 0;
            saddr2 = saddr3;
        }
    }

    /* access modifiers changed from: 0000 */
    public int getEepromSize(byte location) throws D2xxException {
        int[] dataRead = new int[3];
        int eeData = (short) readWord((short) (location & -1));
        if (eeData != 65535) {
            switch (eeData) {
                case 70:
                    this.mEepromType = 70;
                    this.mEepromSize = 64;
                    this.mEepromBlank = false;
                    return 64;
                case 82:
                    this.mEepromType = 82;
                    this.mEepromSize = 1024;
                    this.mEepromBlank = false;
                    return 1024;
                case 86:
                    this.mEepromType = 86;
                    this.mEepromSize = 128;
                    this.mEepromBlank = false;
                    return 128;
                case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                    this.mEepromType = 102;
                    this.mEepromSize = 128;
                    this.mEepromBlank = false;
                    return 256;
                default:
                    return 0;
            }
        } else {
            boolean rc = writeWord(192, (short) 192);
            dataRead[0] = readWord(192);
            dataRead[1] = readWord(64);
            dataRead[2] = readWord(0);
            if (!rc) {
                this.mEepromType = 255;
                this.mEepromSize = 0;
                return 0;
            }
            this.mEepromBlank = true;
            if ((readWord(0) & MotionEventCompat.ACTION_MASK) == 192) {
                eraseEeprom();
                this.mEepromType = 70;
                this.mEepromSize = 64;
                return 64;
            } else if ((readWord(64) & MotionEventCompat.ACTION_MASK) == 192) {
                eraseEeprom();
                this.mEepromType = 86;
                this.mEepromSize = 128;
                return 128;
            } else if ((readWord(192) & MotionEventCompat.ACTION_MASK) == 192) {
                eraseEeprom();
                this.mEepromType = 102;
                this.mEepromSize = 128;
                return 256;
            } else {
                eraseEeprom();
                return 0;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public int writeUserData(byte[] data) {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public byte[] readUserData(int length) {
        return null;
    }

    /* access modifiers changed from: 0000 */
    public int getUserSize() {
        return 0;
    }
}
