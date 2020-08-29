package com.ftdi.j2xx;

import android.support.p000v4.view.MotionEventCompat;
import com.ftdi.j2xx.D2xxManager.D2xxException;

class FT_EE_232H_Ctrl extends FT_EE_Ctrl {
    private static final int AL_DRIVE_CURRENT = 3;
    private static final int AL_FAST_SLEW = 4;
    private static final int AL_SCHMITT_INPUT = 8;
    private static final int BL_DRIVE_CURRENT = 768;
    private static final int BL_FAST_SLEW = 1024;
    private static final int BL_SCHMITT_INPUT = 2048;
    private static final String DEFAULT_PID = "6014";
    private static final byte EEPROM_SIZE_LOCATION = 15;
    private static FT_Device ft_device;

    FT_EE_232H_Ctrl(FT_Device usbc) throws D2xxException {
        super(usbc);
        getEepromSize(EEPROM_SIZE_LOCATION);
    }

    /* access modifiers changed from: 0000 */
    public short programEeprom(FT_EEPROM ee) {
        int[] dataToWrite = new int[this.mEepromSize];
        if (ee.getClass() != FT_EEPROM_232H.class) {
            return 1;
        }
        FT_EEPROM_232H eeprom = (FT_EEPROM_232H) ee;
        try {
            if (eeprom.FIFO) {
                dataToWrite[0] = dataToWrite[0] | 1;
            } else if (eeprom.FIFOTarget) {
                dataToWrite[0] = dataToWrite[0] | 2;
            } else if (eeprom.FastSerial) {
                dataToWrite[0] = dataToWrite[0] | 4;
            }
            if (eeprom.FT1248) {
                dataToWrite[0] = dataToWrite[0] | 8;
            }
            if (eeprom.LoadVCP) {
                dataToWrite[0] = dataToWrite[0] | 16;
            }
            if (eeprom.FT1248ClockPolarity) {
                dataToWrite[0] = dataToWrite[0] | 256;
            }
            if (eeprom.FT1248LSB) {
                dataToWrite[0] = dataToWrite[0] | 512;
            }
            if (eeprom.FT1248FlowControl) {
                dataToWrite[0] = dataToWrite[0] | 1024;
            }
            if (eeprom.PowerSaveEnable) {
                dataToWrite[0] = dataToWrite[0] | 32768;
            }
            dataToWrite[1] = eeprom.VendorId;
            dataToWrite[2] = eeprom.ProductId;
            dataToWrite[3] = 2304;
            dataToWrite[4] = setUSBConfig(ee);
            dataToWrite[5] = setDeviceControl(ee);
            short driveA = eeprom.AL_DriveCurrent;
            if (driveA == -1) {
                driveA = 0;
            }
            dataToWrite[6] = dataToWrite[6] | driveA;
            if (eeprom.AL_SlowSlew) {
                dataToWrite[6] = dataToWrite[6] | 4;
            }
            if (eeprom.AL_SchmittInput) {
                dataToWrite[6] = dataToWrite[6] | 8;
            }
            byte b = eeprom.BL_DriveCurrent;
            if (b == -1) {
                b = 0;
            }
            dataToWrite[6] = dataToWrite[6] | ((short) (b << 8));
            if (eeprom.BL_SlowSlew) {
                dataToWrite[6] = dataToWrite[6] | 1024;
            }
            if (eeprom.BL_SchmittInput) {
                dataToWrite[6] = dataToWrite[6] | 2048;
            }
            int offset = setStringDescriptor(eeprom.Manufacturer, dataToWrite, 80, 7, false);
            int offset2 = setStringDescriptor(eeprom.Product, dataToWrite, offset, 8, false);
            if (eeprom.SerNumEnable) {
                int offset3 = setStringDescriptor(eeprom.SerialNumber, dataToWrite, offset2, 9, false);
            }
            dataToWrite[10] = 0;
            dataToWrite[11] = 0;
            dataToWrite[12] = 0;
            int c2 = eeprom.CBus2 << 8;
            dataToWrite[12] = eeprom.CBus0 | (eeprom.CBus1 << 4) | c2 | (eeprom.CBus3 << 12);
            dataToWrite[13] = 0;
            int c6 = eeprom.CBus6 << 8;
            dataToWrite[13] = eeprom.CBus4 | (eeprom.CBus5 << 4) | c6 | (eeprom.CBus7 << 12);
            dataToWrite[14] = 0;
            dataToWrite[14] = eeprom.CBus8 | (eeprom.CBus9 << 4);
            dataToWrite[15] = this.mEepromType;
            dataToWrite[69] = 72;
            if (this.mEepromType == 70) {
                return 1;
            }
            if (dataToWrite[1] == 0 || dataToWrite[2] == 0) {
                return 2;
            }
            if (programEeprom(dataToWrite, this.mEepromSize)) {
                return 0;
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: type inference failed for: r1v52, types: [short] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ftdi.j2xx.FT_EEPROM readEeprom() {
        /*
            r22 = this;
            com.ftdi.j2xx.FT_EEPROM_232H r18 = new com.ftdi.j2xx.FT_EEPROM_232H
            r18.<init>()
            r0 = r22
            int r0 = r0.mEepromSize
            r20 = r0
            r0 = r20
            int[] r14 = new int[r0]
            r0 = r22
            boolean r0 = r0.mEepromBlank
            r20 = r0
            if (r20 == 0) goto L_0x0018
        L_0x0017:
            return r18
        L_0x0018:
            r19 = 0
        L_0x001a:
            r0 = r22
            int r0 = r0.mEepromSize     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r19
            r1 = r20
            if (r0 < r1) goto L_0x0254
            r20 = 0
            r0 = r20
            r1 = r18
            r1.UART = r0     // Catch:{ Exception -> 0x024f }
            r20 = 0
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r20 = r20 & 15
            switch(r20) {
                case 0: goto L_0x0267;
                case 1: goto L_0x0271;
                case 2: goto L_0x027b;
                case 3: goto L_0x0037;
                case 4: goto L_0x0285;
                case 5: goto L_0x0037;
                case 6: goto L_0x0037;
                case 7: goto L_0x0037;
                case 8: goto L_0x028f;
                default: goto L_0x0037;
            }     // Catch:{ Exception -> 0x024f }
        L_0x0037:
            r20 = 1
            r0 = r20
            r1 = r18
            r1.UART = r0     // Catch:{ Exception -> 0x024f }
        L_0x003f:
            r20 = 0
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r20 = r20 & 16
            if (r20 <= 0) goto L_0x0299
            r20 = 1
            r0 = r20
            r1 = r18
            r1.LoadVCP = r0     // Catch:{ Exception -> 0x024f }
            r20 = 0
            r0 = r20
            r1 = r18
            r1.LoadD2XX = r0     // Catch:{ Exception -> 0x024f }
        L_0x0057:
            r20 = 0
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r0 = r0 & 256(0x100, float:3.59E-43)
            r20 = r0
            if (r20 <= 0) goto L_0x02ab
            r20 = 1
            r0 = r20
            r1 = r18
            r1.FT1248ClockPolarity = r0     // Catch:{ Exception -> 0x024f }
        L_0x006b:
            r20 = 0
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r0 = r0 & 512(0x200, float:7.175E-43)
            r20 = r0
            if (r20 <= 0) goto L_0x02b5
            r20 = 1
            r0 = r20
            r1 = r18
            r1.FT1248LSB = r0     // Catch:{ Exception -> 0x024f }
        L_0x007f:
            r20 = 0
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r0 = r0 & 1024(0x400, float:1.435E-42)
            r20 = r0
            if (r20 <= 0) goto L_0x02bf
            r20 = 1
            r0 = r20
            r1 = r18
            r1.FT1248FlowControl = r0     // Catch:{ Exception -> 0x024f }
        L_0x0093:
            r20 = 0
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r21 = 32768(0x8000, float:4.5918E-41)
            r20 = r20 & r21
            if (r20 <= 0) goto L_0x00a6
            r20 = 1
            r0 = r20
            r1 = r18
            r1.PowerSaveEnable = r0     // Catch:{ Exception -> 0x024f }
        L_0x00a6:
            r20 = 1
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            short r0 = (short) r0     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.VendorId = r0     // Catch:{ Exception -> 0x024f }
            r20 = 2
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            short r0 = (short) r0     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.ProductId = r0     // Catch:{ Exception -> 0x024f }
            r20 = 4
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r22
            r1 = r18
            r2 = r20
            r0.getUSBConfig(r1, r2)     // Catch:{ Exception -> 0x024f }
            r20 = 5
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r22
            r1 = r18
            r2 = r20
            r0.getDeviceControl(r1, r2)     // Catch:{ Exception -> 0x024f }
            r20 = 6
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r15 = r20 & 3
            switch(r15) {
                case 0: goto L_0x02c9;
                case 1: goto L_0x02d3;
                case 2: goto L_0x02dd;
                case 3: goto L_0x02e7;
                default: goto L_0x00e7;
            }     // Catch:{ Exception -> 0x024f }
        L_0x00e7:
            r20 = 6
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r20 = r20 & 4
            if (r20 <= 0) goto L_0x02f1
            r20 = 1
            r0 = r20
            r1 = r18
            r1.AL_SlowSlew = r0     // Catch:{ Exception -> 0x024f }
        L_0x00f7:
            r20 = 6
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r20 = r20 & 8
            if (r20 <= 0) goto L_0x02fb
            r20 = 1
            r0 = r20
            r1 = r18
            r1.AL_SchmittInput = r0     // Catch:{ Exception -> 0x024f }
        L_0x0107:
            r20 = 6
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r0 = r0 & 768(0x300, float:1.076E-42)
            r20 = r0
            int r20 = r20 >> 8
            r0 = r20
            short r0 = (short) r0     // Catch:{ Exception -> 0x024f }
            r16 = r0
            switch(r16) {
                case 0: goto L_0x0305;
                case 1: goto L_0x030f;
                case 2: goto L_0x0319;
                case 3: goto L_0x0323;
                default: goto L_0x011b;
            }     // Catch:{ Exception -> 0x024f }
        L_0x011b:
            r20 = 6
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r0 = r0 & 1024(0x400, float:1.435E-42)
            r20 = r0
            if (r20 <= 0) goto L_0x032d
            r20 = 1
            r0 = r20
            r1 = r18
            r1.BL_SlowSlew = r0     // Catch:{ Exception -> 0x024f }
        L_0x012f:
            r20 = 6
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r0 = r0 & 2048(0x800, float:2.87E-42)
            r20 = r0
            if (r20 <= 0) goto L_0x0337
            r20 = 1
            r0 = r20
            r1 = r18
            r1.BL_SchmittInput = r0     // Catch:{ Exception -> 0x024f }
        L_0x0143:
            r20 = 12
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 0
            r20 = r20 & 15
            r0 = r20
            short r4 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r4     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus0 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 12
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 4
            r20 = r20 & 15
            r0 = r20
            short r5 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r5     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus1 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 12
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 8
            r20 = r20 & 15
            r0 = r20
            short r6 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r6     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus2 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 12
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 12
            r20 = r20 & 15
            r0 = r20
            short r7 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r7     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus3 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 13
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 0
            r20 = r20 & 15
            r0 = r20
            short r8 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r8     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus4 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 13
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 4
            r20 = r20 & 15
            r0 = r20
            short r9 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r9     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus5 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 13
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 8
            r20 = r20 & 15
            r0 = r20
            short r10 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r10     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus6 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 13
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 12
            r20 = r20 & 15
            r0 = r20
            short r11 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r11     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus7 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 14
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 0
            r20 = r20 & 15
            r0 = r20
            short r12 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r12     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus8 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 14
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            int r20 = r20 >> 4
            r20 = r20 & 15
            r0 = r20
            short r13 = (short) r0     // Catch:{ Exception -> 0x024f }
            byte r0 = (byte) r13     // Catch:{ Exception -> 0x024f }
            r20 = r0
            r0 = r20
            r1 = r18
            r1.CBus9 = r0     // Catch:{ Exception -> 0x024f }
            r20 = 7
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 / 2
            r0 = r22
            java.lang.String r20 = r0.getStringDescriptor(r3, r14)     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r1 = r18
            r1.Manufacturer = r0     // Catch:{ Exception -> 0x024f }
            r20 = 8
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 / 2
            r0 = r22
            java.lang.String r20 = r0.getStringDescriptor(r3, r14)     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r1 = r18
            r1.Product = r0     // Catch:{ Exception -> 0x024f }
            r20 = 9
            r20 = r14[r20]     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 / 2
            r0 = r22
            java.lang.String r20 = r0.getStringDescriptor(r3, r14)     // Catch:{ Exception -> 0x024f }
            r0 = r20
            r1 = r18
            r1.SerialNumber = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x0017
        L_0x024f:
            r17 = move-exception
            r18 = 0
            goto L_0x0017
        L_0x0254:
            r0 = r22
            r1 = r19
            int r20 = r0.readWord(r1)     // Catch:{ Exception -> 0x024f }
            r14[r19] = r20     // Catch:{ Exception -> 0x024f }
            int r20 = r19 + 1
            r0 = r20
            short r0 = (short) r0     // Catch:{ Exception -> 0x024f }
            r19 = r0
            goto L_0x001a
        L_0x0267:
            r20 = 1
            r0 = r20
            r1 = r18
            r1.UART = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x003f
        L_0x0271:
            r20 = 1
            r0 = r20
            r1 = r18
            r1.FIFO = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x003f
        L_0x027b:
            r20 = 1
            r0 = r20
            r1 = r18
            r1.FIFOTarget = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x003f
        L_0x0285:
            r20 = 1
            r0 = r20
            r1 = r18
            r1.FastSerial = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x003f
        L_0x028f:
            r20 = 1
            r0 = r20
            r1 = r18
            r1.FT1248 = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x003f
        L_0x0299:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.LoadVCP = r0     // Catch:{ Exception -> 0x024f }
            r20 = 1
            r0 = r20
            r1 = r18
            r1.LoadD2XX = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x0057
        L_0x02ab:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.FT1248ClockPolarity = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x006b
        L_0x02b5:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.FT1248LSB = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x007f
        L_0x02bf:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.FT1248FlowControl = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x0093
        L_0x02c9:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x00e7
        L_0x02d3:
            r20 = 1
            r0 = r20
            r1 = r18
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x00e7
        L_0x02dd:
            r20 = 2
            r0 = r20
            r1 = r18
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x00e7
        L_0x02e7:
            r20 = 3
            r0 = r20
            r1 = r18
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x00e7
        L_0x02f1:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.AL_SlowSlew = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x00f7
        L_0x02fb:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.AL_SchmittInput = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x0107
        L_0x0305:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x011b
        L_0x030f:
            r20 = 1
            r0 = r20
            r1 = r18
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x011b
        L_0x0319:
            r20 = 2
            r0 = r20
            r1 = r18
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x011b
        L_0x0323:
            r20 = 3
            r0 = r20
            r1 = r18
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x011b
        L_0x032d:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.BL_SlowSlew = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x012f
        L_0x0337:
            r20 = 0
            r0 = r20
            r1 = r18
            r1.BL_SchmittInput = r0     // Catch:{ Exception -> 0x024f }
            goto L_0x0143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ftdi.j2xx.FT_EE_232H_Ctrl.readEeprom():com.ftdi.j2xx.FT_EEPROM");
    }

    /* access modifiers changed from: 0000 */
    public int getUserSize() {
        int data = readWord(9);
        return ((this.mEepromSize - (((data & MotionEventCompat.ACTION_MASK) / 2) + 1)) - ((((65280 & data) >> 8) / 2) + 1)) * 2;
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
