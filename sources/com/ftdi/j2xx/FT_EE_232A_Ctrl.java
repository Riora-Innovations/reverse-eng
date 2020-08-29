package com.ftdi.j2xx;

import android.support.p000v4.view.MotionEventCompat;

class FT_EE_232A_Ctrl extends FT_EE_Ctrl {
    private static final short CHECKSUM_LOCATION = 63;
    private static final short EEPROM_SIZE = 64;

    FT_EE_232A_Ctrl(FT_Device usbC) {
        super(usbC);
    }

    /* access modifiers changed from: 0000 */
    public short programEeprom(FT_EEPROM ee) {
        int[] data = new int[64];
        if (ee.getClass() != FT_EEPROM.class) {
            return 1;
        }
        FT_EEPROM eeprom = ee;
        try {
            data[1] = eeprom.VendorId;
            data[2] = eeprom.ProductId;
            data[3] = 512;
            data[4] = setUSBConfig(ee);
            int saddr = setStringDescriptor(eeprom.Manufacturer, data, 10, 7, true) + eeprom.Manufacturer.length() + 2;
            int saddr2 = setStringDescriptor(eeprom.Product, data, saddr, 8, true) + eeprom.Product.length() + 2;
            if (eeprom.SerNumEnable) {
                int saddr3 = setStringDescriptor(eeprom.SerialNumber, data, saddr2, 9, true) + eeprom.SerialNumber.length() + 2;
            }
            if (data[1] == 0 || data[2] == 0) {
                return 2;
            }
            if (programEeprom(data, 63)) {
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
        FT_EEPROM eeprom = new FT_EEPROM();
        int[] data = new int[64];
        for (int i = 0; i < 64; i++) {
            data[i] = readWord((short) i);
        }
        try {
            eeprom.VendorId = (short) data[1];
            eeprom.ProductId = (short) data[2];
            getUSBConfig(eeprom, data[4]);
            eeprom.Manufacturer = getStringDescriptor(10, data);
            int addr = 10 + eeprom.Manufacturer.length() + 1;
            eeprom.Product = getStringDescriptor(addr, data);
            eeprom.SerialNumber = getStringDescriptor(addr + eeprom.Product.length() + 1, data);
            return eeprom;
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public int getUserSize() {
        return ((63 - ((((((readWord(7) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) / 2) + 10) + (((readWord(8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) / 2)) + 1)) - (((readWord(9) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) / 2)) * 2;
    }

    /* access modifiers changed from: 0000 */
    public int writeUserData(byte[] data) {
        int dataWrite;
        if (data.length > getUserSize()) {
            return 0;
        }
        short offset = (short) ((63 - (getUserSize() / 2)) - 1);
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
        if (length == 0 || length > getUserSize() - 1) {
            return null;
        }
        int i = 0;
        short offset = (short) (65535 & ((short) (63 - (getUserSize() / 2))));
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
