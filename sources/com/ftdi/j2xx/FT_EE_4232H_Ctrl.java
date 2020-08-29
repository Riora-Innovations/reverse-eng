package com.ftdi.j2xx;

import android.support.p000v4.view.MotionEventCompat;
import com.ftdi.j2xx.D2xxManager.D2xxException;

class FT_EE_4232H_Ctrl extends FT_EE_Ctrl {
    private static final int AH_DRIVE_CURRENT = 48;
    private static final int AH_FAST_SLEW = 64;
    private static final int AH_SCHMITT_INPUT = 128;
    private static final int AH_TXDEN = 8192;
    private static final int AL_DRIVE_CURRENT = 3;
    private static final int AL_FAST_SLEW = 4;
    private static final int AL_SCHMITT_INPUT = 8;
    private static final int AL_TXDEN = 4096;
    private static final int BH_DRIVE_CURRENT = 12288;
    private static final int BH_FAST_SLEW = 16384;
    private static final int BH_SCHMITT_INPUT = 32768;
    private static final int BH_TXDEN = 32768;
    private static final int BL_DRIVE_CURRENT = 768;
    private static final int BL_FAST_SLEW = 1024;
    private static final int BL_SCHMITT_INPUT = 2048;
    private static final int BL_TXDEN = 16384;
    private static final String DEFAULT_PID = "6011";
    private static final byte EEPROM_SIZE_LOCATION = 12;
    private static final int TPRDRV = 24;

    FT_EE_4232H_Ctrl(FT_Device usbC) throws D2xxException {
        super(usbC);
        getEepromSize(EEPROM_SIZE_LOCATION);
    }

    /* access modifiers changed from: 0000 */
    public short programEeprom(FT_EEPROM ee) {
        int[] dataToWrite = new int[this.mEepromSize];
        if (ee.getClass() != FT_EEPROM_4232H.class) {
            return 1;
        }
        FT_EEPROM_4232H eeprom = (FT_EEPROM_4232H) ee;
        try {
            dataToWrite[0] = 0;
            if (eeprom.AL_LoadVCP) {
                dataToWrite[0] = dataToWrite[0] | 8;
            }
            if (eeprom.BL_LoadVCP) {
                dataToWrite[0] = dataToWrite[0] | 128;
            }
            if (eeprom.AH_LoadVCP) {
                dataToWrite[0] = dataToWrite[0] | 2048;
            }
            if (eeprom.BH_LoadVCP) {
                dataToWrite[0] = dataToWrite[0] | 32768;
            }
            dataToWrite[1] = eeprom.VendorId;
            dataToWrite[2] = eeprom.ProductId;
            dataToWrite[3] = 2048;
            dataToWrite[4] = setUSBConfig(ee);
            dataToWrite[5] = setDeviceControl(ee);
            if (eeprom.AL_LoadRI_RS485) {
                dataToWrite[5] = (short) (dataToWrite[5] | 4096);
            }
            if (eeprom.AH_LoadRI_RS485) {
                dataToWrite[5] = (short) (dataToWrite[5] | 8192);
            }
            if (eeprom.BL_LoadRI_RS485) {
                dataToWrite[5] = (short) (dataToWrite[5] | 16384);
            }
            if (eeprom.BH_LoadRI_RS485) {
                dataToWrite[5] = (short) (dataToWrite[5] | 32768);
            }
            dataToWrite[6] = 0;
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
            short driveB = eeprom.AH_DriveCurrent;
            if (driveB == -1) {
                driveB = 0;
            }
            dataToWrite[6] = dataToWrite[6] | ((short) (driveB << 4));
            if (eeprom.AH_SlowSlew) {
                dataToWrite[6] = dataToWrite[6] | 64;
            }
            if (eeprom.AH_SchmittInput) {
                dataToWrite[6] = dataToWrite[6] | 128;
            }
            short driveC = eeprom.BL_DriveCurrent;
            if (driveC == -1) {
                driveC = 0;
            }
            dataToWrite[6] = dataToWrite[6] | ((short) (driveC << 8));
            if (eeprom.BL_SlowSlew) {
                dataToWrite[6] = dataToWrite[6] | 1024;
            }
            if (eeprom.BL_SchmittInput) {
                dataToWrite[6] = dataToWrite[6] | 2048;
            }
            dataToWrite[6] = dataToWrite[6] | ((short) (eeprom.BH_DriveCurrent << 12));
            if (eeprom.BH_SlowSlew) {
                dataToWrite[6] = dataToWrite[6] | 16384;
            }
            if (eeprom.BH_SchmittInput) {
                dataToWrite[6] = dataToWrite[6] | 32768;
            }
            boolean eeprom46 = false;
            int offset = 77;
            if (this.mEepromType == 70) {
                offset = 13;
                eeprom46 = true;
            }
            int offset2 = setStringDescriptor(eeprom.Manufacturer, dataToWrite, offset, 7, eeprom46);
            int offset3 = setStringDescriptor(eeprom.Product, dataToWrite, offset2, 8, eeprom46);
            if (eeprom.SerNumEnable) {
                int offset4 = setStringDescriptor(eeprom.SerialNumber, dataToWrite, offset3, 9, eeprom46);
            }
            switch (eeprom.TPRDRV) {
                case 0:
                    dataToWrite[11] = 0;
                    break;
                case 1:
                    dataToWrite[11] = 8;
                    break;
                case 2:
                    dataToWrite[11] = 16;
                    break;
                case 3:
                    dataToWrite[11] = TPRDRV;
                    break;
                default:
                    dataToWrite[11] = 0;
                    break;
            }
            dataToWrite[12] = this.mEepromType;
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

    /* JADX WARNING: type inference failed for: r1v74, types: [short] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ftdi.j2xx.FT_EEPROM readEeprom() {
        /*
            r27 = this;
            com.ftdi.j2xx.FT_EEPROM_4232H r23 = new com.ftdi.j2xx.FT_EEPROM_4232H
            r23.<init>()
            r0 = r27
            int r0 = r0.mEepromSize
            r25 = r0
            r0 = r25
            int[] r4 = new int[r0]
            r0 = r27
            boolean r0 = r0.mEepromBlank
            r25 = r0
            if (r25 == 0) goto L_0x0018
        L_0x0017:
            return r23
        L_0x0018:
            r24 = 0
        L_0x001a:
            r0 = r27
            int r0 = r0.mEepromSize     // Catch:{ Exception -> 0x02e2 }
            r25 = r0
            r0 = r24
            r1 = r25
            if (r0 < r1) goto L_0x02e7
            r25 = 0
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r25 = r25 & 8
            int r25 = r25 >> 3
            r0 = r25
            short r14 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 1
            r0 = r25
            if (r14 != r0) goto L_0x02fa
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AL_LoadVCP = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AL_LoadD2XX = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x0047:
            r25 = 0
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 128(0x80, float:1.794E-43)
            r25 = r0
            int r25 = r25 >> 7
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r18 = r0
            r25 = 1
            r0 = r18
            r1 = r25
            if (r0 != r1) goto L_0x030c
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BL_LoadVCP = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BL_LoadD2XX = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x0070:
            r25 = 0
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 2048(0x800, float:2.87E-42)
            r25 = r0
            int r25 = r25 >> 11
            r0 = r25
            short r7 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 1
            r0 = r25
            if (r7 != r0) goto L_0x031e
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AH_LoadVCP = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AH_LoadD2XX = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x0095:
            r25 = 0
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r26 = 32768(0x8000, float:4.5918E-41)
            r25 = r25 & r26
            int r25 = r25 >> 15
            r0 = r25
            short r11 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 1
            r0 = r25
            if (r11 != r0) goto L_0x0330
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BH_LoadVCP = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BH_LoadD2XX = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x00b9:
            r25 = 1
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = r0
            r0 = r25
            r1 = r23
            r1.VendorId = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 2
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = r0
            r0 = r25
            r1 = r23
            r1.ProductId = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 4
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r27
            r1 = r23
            r2 = r25
            r0.getUSBConfig(r1, r2)     // Catch:{ Exception -> 0x02e2 }
            r25 = 5
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r27
            r1 = r23
            r2 = r25
            r0.getDeviceControl(r1, r2)     // Catch:{ Exception -> 0x02e2 }
            r25 = 5
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            r25 = r0
            r26 = 4096(0x1000, float:5.74E-42)
            r0 = r25
            r1 = r26
            if (r0 != r1) goto L_0x010b
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AL_LoadRI_RS485 = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x010b:
            r25 = 5
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            r25 = r0
            r26 = 8192(0x2000, float:1.14794E-41)
            r0 = r25
            r1 = r26
            if (r0 != r1) goto L_0x0125
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AH_LoadRI_RS485 = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x0125:
            r25 = 5
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            r25 = r0
            r26 = 16384(0x4000, float:2.2959E-41)
            r0 = r25
            r1 = r26
            if (r0 != r1) goto L_0x013f
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AH_LoadRI_RS485 = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x013f:
            r25 = 5
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r26 = 32768(0x8000, float:4.5918E-41)
            r25 = r25 & r26
            r26 = 32768(0x8000, float:4.5918E-41)
            r0 = r25
            r1 = r26
            if (r0 != r1) goto L_0x0159
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AH_LoadRI_RS485 = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x0159:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r25 = r25 & 3
            r0 = r25
            short r5 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            switch(r5) {
                case 0: goto L_0x0342;
                case 1: goto L_0x034c;
                case 2: goto L_0x0356;
                case 3: goto L_0x0360;
                default: goto L_0x0165;
            }     // Catch:{ Exception -> 0x02e2 }
        L_0x0165:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r25 = r25 & 4
            r0 = r25
            short r13 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 4
            r0 = r25
            if (r13 != r0) goto L_0x036a
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AL_SlowSlew = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x017c:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r25 = r25 & 8
            r0 = r25
            short r15 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 8
            r0 = r25
            if (r15 != r0) goto L_0x0374
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AL_SchmittInput = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x0193:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r25 = r25 & 48
            int r25 = r25 >> 4
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r16 = r0
            switch(r16) {
                case 0: goto L_0x037e;
                case 1: goto L_0x0388;
                case 2: goto L_0x0392;
                case 3: goto L_0x039c;
                default: goto L_0x01a3;
            }     // Catch:{ Exception -> 0x02e2 }
        L_0x01a3:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r25 = r25 & 64
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r17 = r0
            r25 = 64
            r0 = r17
            r1 = r25
            if (r0 != r1) goto L_0x03a6
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AH_SlowSlew = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x01be:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 128(0x80, float:1.794E-43)
            r25 = r0
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r19 = r0
            r25 = 128(0x80, float:1.794E-43)
            r0 = r19
            r1 = r25
            if (r0 != r1) goto L_0x03b0
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AH_SchmittInput = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x01dd:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 768(0x300, float:1.076E-42)
            r25 = r0
            int r25 = r25 >> 8
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r20 = r0
            switch(r20) {
                case 0: goto L_0x03ba;
                case 1: goto L_0x03c4;
                case 2: goto L_0x03ce;
                case 3: goto L_0x03d8;
                default: goto L_0x01f1;
            }     // Catch:{ Exception -> 0x02e2 }
        L_0x01f1:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 1024(0x400, float:1.435E-42)
            r25 = r0
            r0 = r25
            short r6 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 1024(0x400, float:1.435E-42)
            r0 = r25
            if (r6 != r0) goto L_0x03e2
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BL_SlowSlew = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x020c:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 2048(0x800, float:2.87E-42)
            r25 = r0
            r0 = r25
            short r8 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 2048(0x800, float:2.87E-42)
            r0 = r25
            if (r8 != r0) goto L_0x03ec
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BL_SchmittInput = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x0227:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 12288(0x3000, float:1.7219E-41)
            r25 = r0
            int r25 = r25 >> 12
            r0 = r25
            short r9 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            switch(r9) {
                case 0: goto L_0x03f6;
                case 1: goto L_0x0400;
                case 2: goto L_0x040a;
                case 3: goto L_0x0414;
                default: goto L_0x0239;
            }     // Catch:{ Exception -> 0x02e2 }
        L_0x0239:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            r25 = r0
            r0 = r25
            short r10 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 16384(0x4000, float:2.2959E-41)
            r0 = r25
            if (r10 != r0) goto L_0x041e
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BH_SlowSlew = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x0254:
            r25 = 6
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r26 = 32768(0x8000, float:4.5918E-41)
            r25 = r25 & r26
            r0 = r25
            short r12 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 32768(0x8000, float:4.5918E-41)
            r0 = r25
            if (r12 != r0) goto L_0x0428
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BH_SchmittInput = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x026f:
            r25 = 11
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r25 = r25 & 24
            int r25 = r25 >> 3
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r21 = r0
            r25 = 4
            r0 = r21
            r1 = r25
            if (r0 >= r1) goto L_0x0432
            r0 = r21
            r1 = r23
            r1.TPRDRV = r0     // Catch:{ Exception -> 0x02e2 }
        L_0x028a:
            r25 = 7
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r3 = r0 & 255(0xff, float:3.57E-43)
            r0 = r27
            short r0 = r0.mEepromType     // Catch:{ Exception -> 0x02e2 }
            r25 = r0
            r26 = 70
            r0 = r25
            r1 = r26
            if (r0 != r1) goto L_0x043c
            int r3 = r3 + -128
            int r3 = r3 / 2
            r0 = r27
            java.lang.String r25 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r1 = r23
            r1.Manufacturer = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 8
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            int r3 = r3 / 2
            r0 = r27
            java.lang.String r25 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r1 = r23
            r1.Product = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 9
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            int r3 = r3 / 2
            r0 = r27
            java.lang.String r25 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r1 = r23
            r1.SerialNumber = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0017
        L_0x02e2:
            r22 = move-exception
            r23 = 0
            goto L_0x0017
        L_0x02e7:
            r0 = r27
            r1 = r24
            int r25 = r0.readWord(r1)     // Catch:{ Exception -> 0x02e2 }
            r4[r24] = r25     // Catch:{ Exception -> 0x02e2 }
            int r25 = r24 + 1
            r0 = r25
            short r0 = (short) r0     // Catch:{ Exception -> 0x02e2 }
            r24 = r0
            goto L_0x001a
        L_0x02fa:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AL_LoadVCP = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AL_LoadD2XX = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0047
        L_0x030c:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BL_LoadVCP = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BL_LoadD2XX = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0070
        L_0x031e:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AH_LoadVCP = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AH_LoadD2XX = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0095
        L_0x0330:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BH_LoadVCP = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BH_LoadD2XX = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x00b9
        L_0x0342:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0165
        L_0x034c:
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0165
        L_0x0356:
            r25 = 2
            r0 = r25
            r1 = r23
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0165
        L_0x0360:
            r25 = 3
            r0 = r25
            r1 = r23
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0165
        L_0x036a:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AL_SlowSlew = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x017c
        L_0x0374:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AL_SchmittInput = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0193
        L_0x037e:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AH_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01a3
        L_0x0388:
            r25 = 1
            r0 = r25
            r1 = r23
            r1.AH_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01a3
        L_0x0392:
            r25 = 2
            r0 = r25
            r1 = r23
            r1.AH_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01a3
        L_0x039c:
            r25 = 3
            r0 = r25
            r1 = r23
            r1.AH_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01a3
        L_0x03a6:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AH_SlowSlew = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01be
        L_0x03b0:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.AH_SchmittInput = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01dd
        L_0x03ba:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01f1
        L_0x03c4:
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01f1
        L_0x03ce:
            r25 = 2
            r0 = r25
            r1 = r23
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01f1
        L_0x03d8:
            r25 = 3
            r0 = r25
            r1 = r23
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x01f1
        L_0x03e2:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BL_SlowSlew = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x020c
        L_0x03ec:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BL_SchmittInput = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0227
        L_0x03f6:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BH_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0239
        L_0x0400:
            r25 = 1
            r0 = r25
            r1 = r23
            r1.BH_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0239
        L_0x040a:
            r25 = 2
            r0 = r25
            r1 = r23
            r1.BH_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0239
        L_0x0414:
            r25 = 3
            r0 = r25
            r1 = r23
            r1.BH_DriveCurrent = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0239
        L_0x041e:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BH_SlowSlew = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0254
        L_0x0428:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.BH_SchmittInput = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x026f
        L_0x0432:
            r25 = 0
            r0 = r25
            r1 = r23
            r1.TPRDRV = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x028a
        L_0x043c:
            int r3 = r3 / 2
            r0 = r27
            java.lang.String r25 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r1 = r23
            r1.Manufacturer = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 8
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 / 2
            r0 = r27
            java.lang.String r25 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r1 = r23
            r1.Product = r0     // Catch:{ Exception -> 0x02e2 }
            r25 = 9
            r25 = r4[r25]     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 / 2
            r0 = r27
            java.lang.String r25 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x02e2 }
            r0 = r25
            r1 = r23
            r1.SerialNumber = r0     // Catch:{ Exception -> 0x02e2 }
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ftdi.j2xx.FT_EE_4232H_Ctrl.readEeprom():com.ftdi.j2xx.FT_EEPROM");
    }

    /* access modifiers changed from: 0000 */
    public int getUserSize() {
        int data = readWord(9);
        return ((this.mEepromSize - 1) - ((((data & MotionEventCompat.ACTION_MASK) / 2) + (((65280 & data) >> 8) / 2)) + 1)) * 2;
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
