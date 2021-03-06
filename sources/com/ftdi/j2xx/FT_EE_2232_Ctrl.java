package com.ftdi.j2xx;

import android.support.p000v4.view.MotionEventCompat;
import com.ftdi.j2xx.D2xxManager.D2xxException;

class FT_EE_2232_Ctrl extends FT_EE_Ctrl {
    private static final short CHECKSUM_LOCATION = 63;
    private static final String DEFAULT_PID = "6010";
    private static final byte EEPROM_SIZE_LOCATION = 10;

    FT_EE_2232_Ctrl(FT_Device usbC) throws D2xxException {
        super(usbC);
        getEepromSize(EEPROM_SIZE_LOCATION);
    }

    /* access modifiers changed from: 0000 */
    public short programEeprom(FT_EEPROM ee) {
        int[] data = new int[this.mEepromSize];
        if (ee.getClass() != FT_EEPROM_2232D.class) {
            return 1;
        }
        FT_EEPROM_2232D eeprom = (FT_EEPROM_2232D) ee;
        try {
            data[0] = 0;
            if (eeprom.A_FIFO) {
                data[0] = data[0] | 1;
            } else if (eeprom.A_FIFOTarget) {
                data[0] = data[0] | 2;
            } else {
                data[0] = data[0] | 4;
            }
            if (eeprom.A_HighIO) {
                data[0] = data[0] | 16;
            }
            if (eeprom.A_LoadVCP) {
                data[0] = data[0] | 8;
            } else if (eeprom.B_FIFO) {
                data[0] = data[0] | 256;
            } else if (eeprom.B_FIFOTarget) {
                data[0] = data[0] | 512;
            } else {
                data[0] = data[0] | 1024;
            }
            if (eeprom.B_HighIO) {
                data[0] = data[0] | 4096;
            }
            if (eeprom.B_LoadVCP) {
                data[0] = data[0] | 2048;
            }
            data[1] = eeprom.VendorId;
            data[2] = eeprom.ProductId;
            data[3] = 1280;
            data[4] = setUSBConfig(ee);
            data[4] = setDeviceControl(ee);
            boolean eeprom46 = false;
            int offset = 75;
            if (this.mEepromType == 70) {
                offset = 11;
                eeprom46 = true;
            }
            int offset2 = setStringDescriptor(eeprom.Manufacturer, data, offset, 7, eeprom46);
            int offset3 = setStringDescriptor(eeprom.Product, data, offset2, 8, eeprom46);
            if (eeprom.SerNumEnable) {
                int offset4 = setStringDescriptor(eeprom.SerialNumber, data, offset3, 9, eeprom46);
            }
            data[10] = this.mEepromType;
            if (data[1] == 0 || data[2] == 0) {
                return 2;
            }
            if (programEeprom(data, this.mEepromSize)) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: 0000 */
    public FT_EEPROM readEeprom() {
        FT_EEPROM_2232D eeprom = new FT_EEPROM_2232D();
        int[] dataRead = new int[this.mEepromSize];
        int i = 0;
        while (i < this.mEepromSize) {
            try {
                dataRead[i] = readWord((short) i);
                i++;
            } catch (Exception e) {
                return null;
            }
        }
        switch ((short) (dataRead[0] & 7)) {
            case 0:
                eeprom.A_UART = true;
                break;
            case 1:
                eeprom.A_FIFO = true;
                break;
            case 2:
                eeprom.A_FIFOTarget = true;
                break;
            case 4:
                eeprom.A_FastSerial = true;
                break;
        }
        if (((short) ((dataRead[0] & 8) >> 3)) == 1) {
            eeprom.A_LoadVCP = true;
        } else {
            eeprom.A_HighIO = true;
        }
        if (((short) ((dataRead[0] & 16) >> 4)) == 1) {
            eeprom.A_HighIO = true;
        }
        switch ((short) ((dataRead[0] & 1792) >> 8)) {
            case 0:
                eeprom.B_UART = true;
                break;
            case 1:
                eeprom.B_FIFO = true;
                break;
            case 2:
                eeprom.B_FIFOTarget = true;
                break;
            case 4:
                eeprom.B_FastSerial = true;
                break;
        }
        if (((short) ((dataRead[0] & 2048) >> 11)) == 1) {
            eeprom.B_LoadVCP = true;
        } else {
            eeprom.B_LoadD2XX = true;
        }
        if (((short) ((dataRead[0] & 4096) >> 12)) == 1) {
            eeprom.B_HighIO = true;
        }
        eeprom.VendorId = (short) dataRead[1];
        eeprom.ProductId = (short) dataRead[2];
        getUSBConfig(eeprom, dataRead[4]);
        int addr = dataRead[7] & MotionEventCompat.ACTION_MASK;
        if (this.mEepromType == 70) {
            eeprom.Manufacturer = getStringDescriptor((addr - 128) / 2, dataRead);
            eeprom.Product = getStringDescriptor(((dataRead[8] & MotionEventCompat.ACTION_MASK) - 128) / 2, dataRead);
            eeprom.SerialNumber = getStringDescriptor(((dataRead[9] & MotionEventCompat.ACTION_MASK) - 128) / 2, dataRead);
            return eeprom;
        }
        eeprom.Manufacturer = getStringDescriptor(addr / 2, dataRead);
        eeprom.Product = getStringDescriptor((dataRead[8] & MotionEventCompat.ACTION_MASK) / 2, dataRead);
        eeprom.SerialNumber = getStringDescriptor((dataRead[9] & MotionEventCompat.ACTION_MASK) / 2, dataRead);
        return eeprom;
    }

    /* access modifiers changed from: 0000 */
    public int getUserSize() {
        int data = readWord(9);
        return ((this.mEepromSize - 1) - ((data & MotionEventCompat.ACTION_MASK) + (((65280 & data) >> 8) / 2))) * 2;
    }

    /* access modifiers changed from: 0000 */
    public int writeUserData(byte[] data) {
        int dataWrite;
        if (data.length > getUserSize()) {
            return 0;
        }
        short offset = (short) ((this.mEepromSize - (getUserSize() / 2)) - 1);
        int i = 0;
        while (i < data.length) {
            if (i + 1 < data.length) {
                dataWrite = data[i + 1] & MotionEventCompat.ACTION_MASK;
            } else {
                dataWrite = 0;
            }
            short offset2 = (short) (offset + 1);
            writeWord(offset, (short) ((dataWrite << 8) | (data[i] & MotionEventCompat.ACTION_MASK)));
            i += 2;
            offset = offset2;
        }
        return data.length;
    }

    /* access modifiers changed from: 0000 */
    public byte[] readUserData(int length) {
        byte[] data = new byte[length];
        if (length == 0 || length > getUserSize()) {
            return null;
        }
        int i = 0;
        short offset = (short) ((this.mEepromSize - (getUserSize() / 2)) - 1);
        while (i < length) {
            short offset2 = (short) (offset + 1);
            int dataRead = readWord(offset);
            if (i + 1 < data.length) {
                data[i + 1] = (byte) (dataRead & MotionEventCompat.ACTION_MASK);
            }
            data[i] = (byte) ((65280 & dataRead) >> 8);
            i += 2;
            offset = offset2;
        }
        return data;
    }
}
