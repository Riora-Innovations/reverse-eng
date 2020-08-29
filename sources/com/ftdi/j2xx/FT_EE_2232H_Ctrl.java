package com.ftdi.j2xx;

import android.support.p000v4.view.MotionEventCompat;
import com.ftdi.j2xx.D2xxManager.D2xxException;

class FT_EE_2232H_Ctrl extends FT_EE_Ctrl {
    private static final int AH_DRIVE_CURRENT = 48;
    private static final int AH_FAST_SLEW = 64;
    private static final int AH_SCHMITT_INPUT = 128;
    private static final int AL_DRIVE_CURRENT = 3;
    private static final int AL_FAST_SLEW = 4;
    private static final int AL_SCHMITT_INPUT = 8;
    private static final int A_245_FIFO = 1;
    private static final int A_245_FIFO_TARGET = 2;
    private static final int A_FAST_SERIAL = 4;
    private static final int A_LOAD_VCP_DRIVER = 8;
    private static final int A_UART_RS232 = 0;
    private static final int BH_DRIVE_CURRENT = 12288;
    private static final int BH_FAST_SLEW = 16384;
    private static final int BH_SCHMITT_INPUT = 32768;
    private static final int BL_DRIVE_CURRENT = 768;
    private static final int BL_FAST_SLEW = 1024;
    private static final int BL_SCHMITT_INPUT = 2048;
    private static final String DEFAULT_PID = "6010";
    private static final byte EEPROM_SIZE_LOCATION = 12;
    private static final int INVERT_CTS = 2048;
    private static final int INVERT_DCD = 16384;
    private static final int INVERT_DSR = 8192;
    private static final int INVERT_DTR = 4096;
    private static final int INVERT_RI = 32768;
    private static final int INVERT_RTS = 1024;
    private static final int INVERT_RXD = 512;
    private static final int INVERT_TXD = 256;
    private static final int TPRDRV = 24;

    FT_EE_2232H_Ctrl(FT_Device usbC) throws D2xxException {
        super(usbC);
        getEepromSize(EEPROM_SIZE_LOCATION);
    }

    /* access modifiers changed from: 0000 */
    public short programEeprom(FT_EEPROM ee) {
        int[] dataToWrite = new int[this.mEepromSize];
        if (ee.getClass() != FT_EEPROM_2232H.class) {
            return 1;
        }
        FT_EEPROM_2232H eeprom = (FT_EEPROM_2232H) ee;
        try {
            if (!eeprom.A_UART) {
                if (eeprom.A_FIFO) {
                    dataToWrite[0] = dataToWrite[0] | 1;
                } else if (eeprom.A_FIFOTarget) {
                    dataToWrite[0] = dataToWrite[0] | 2;
                } else {
                    dataToWrite[0] = dataToWrite[0] | 4;
                }
            }
            if (eeprom.A_LoadVCP) {
                dataToWrite[0] = dataToWrite[0] | 8;
            }
            if (!eeprom.B_UART) {
                if (eeprom.B_FIFO) {
                    dataToWrite[0] = dataToWrite[0] | 256;
                } else if (eeprom.B_FIFOTarget) {
                    dataToWrite[0] = dataToWrite[0] | 512;
                } else {
                    dataToWrite[0] = dataToWrite[0] | 1024;
                }
            }
            if (eeprom.B_LoadVCP) {
                dataToWrite[0] = dataToWrite[0] | 2048;
            }
            if (eeprom.PowerSaveEnable) {
                dataToWrite[0] = dataToWrite[0] | 32768;
            }
            dataToWrite[1] = eeprom.VendorId;
            dataToWrite[2] = eeprom.ProductId;
            dataToWrite[3] = 1792;
            dataToWrite[4] = setUSBConfig(ee);
            dataToWrite[5] = setDeviceControl(ee);
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
                offset3 = setStringDescriptor(eeprom.SerialNumber, dataToWrite, offset3, 9, eeprom46);
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
            clearUserDataArea(offset3, this.mEepromSize, dataToWrite);
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

    /* JADX WARNING: type inference failed for: r1v71, types: [short] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ftdi.j2xx.FT_EEPROM readEeprom() {
        /*
            r29 = this;
            com.ftdi.j2xx.FT_EEPROM_2232H r24 = new com.ftdi.j2xx.FT_EEPROM_2232H
            r24.<init>()
            r0 = r29
            int r0 = r0.mEepromSize
            r27 = r0
            r0 = r27
            int[] r4 = new int[r0]
            r0 = r29
            boolean r0 = r0.mEepromBlank
            r27 = r0
            if (r27 == 0) goto L_0x0018
        L_0x0017:
            return r24
        L_0x0018:
            r25 = 0
        L_0x001a:
            r0 = r29
            int r0 = r0.mEepromSize     // Catch:{ Exception -> 0x0271 }
            r27 = r0
            r0 = r25
            r1 = r27
            if (r0 < r1) goto L_0x0276
            r26 = 0
            r27 = 0
            r26 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r27 = r26 & 7
            r0 = r27
            short r6 = (short) r0     // Catch:{ Exception -> 0x0271 }
            switch(r6) {
                case 0: goto L_0x0289;
                case 1: goto L_0x0293;
                case 2: goto L_0x029d;
                case 3: goto L_0x0034;
                case 4: goto L_0x02a7;
                default: goto L_0x0034;
            }     // Catch:{ Exception -> 0x0271 }
        L_0x0034:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.A_UART = r0     // Catch:{ Exception -> 0x0271 }
        L_0x003c:
            r27 = r26 & 8
            int r27 = r27 >> 3
            r0 = r27
            short r15 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = 1
            r0 = r27
            if (r15 != r0) goto L_0x02b1
            r27 = 1
            r0 = r27
            r1 = r24
            r1.A_LoadVCP = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 0
            r0 = r27
            r1 = r24
            r1.A_LoadD2XX = r0     // Catch:{ Exception -> 0x0271 }
        L_0x0059:
            r0 = r26
            r0 = r0 & 1792(0x700, float:2.511E-42)
            r27 = r0
            int r27 = r27 >> 8
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r20 = r0
            switch(r20) {
                case 0: goto L_0x02c3;
                case 1: goto L_0x02cd;
                case 2: goto L_0x02d7;
                case 3: goto L_0x0069;
                case 4: goto L_0x02e1;
                default: goto L_0x0069;
            }     // Catch:{ Exception -> 0x0271 }
        L_0x0069:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.B_UART = r0     // Catch:{ Exception -> 0x0271 }
        L_0x0071:
            r0 = r26
            r0 = r0 & 2048(0x800, float:2.87E-42)
            r27 = r0
            int r27 = r27 >> 11
            r0 = r27
            short r8 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = 1
            r0 = r27
            if (r8 != r0) goto L_0x02eb
            r27 = 1
            r0 = r27
            r1 = r24
            r1.B_LoadVCP = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 0
            r0 = r27
            r1 = r24
            r1.B_LoadD2XX = r0     // Catch:{ Exception -> 0x0271 }
        L_0x0092:
            r27 = 32768(0x8000, float:4.5918E-41)
            r27 = r27 & r26
            int r27 = r27 >> 15
            r0 = r27
            short r12 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = 1
            r0 = r27
            if (r12 != r0) goto L_0x02fd
            r27 = 1
            r0 = r27
            r1 = r24
            r1.PowerSaveEnable = r0     // Catch:{ Exception -> 0x0271 }
        L_0x00aa:
            r27 = 1
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = r0
            r0 = r27
            r1 = r24
            r1.VendorId = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 2
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = r0
            r0 = r27
            r1 = r24
            r1.ProductId = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 4
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r29
            r1 = r24
            r2 = r27
            r0.getUSBConfig(r1, r2)     // Catch:{ Exception -> 0x0271 }
            r27 = 5
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r29
            r1 = r24
            r2 = r27
            r0.getDeviceControl(r1, r2)     // Catch:{ Exception -> 0x0271 }
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r27 = r27 & 3
            r0 = r27
            short r5 = (short) r0     // Catch:{ Exception -> 0x0271 }
            switch(r5) {
                case 0: goto L_0x0307;
                case 1: goto L_0x0311;
                case 2: goto L_0x031b;
                case 3: goto L_0x0325;
                default: goto L_0x00ee;
            }     // Catch:{ Exception -> 0x0271 }
        L_0x00ee:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r27 = r27 & 4
            r0 = r27
            short r14 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = 4
            r0 = r27
            if (r14 != r0) goto L_0x032f
            r27 = 1
            r0 = r27
            r1 = r24
            r1.AL_SlowSlew = r0     // Catch:{ Exception -> 0x0271 }
        L_0x0105:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r27 = r27 & 8
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r16 = r0
            r27 = 8
            r0 = r16
            r1 = r27
            if (r0 != r1) goto L_0x0339
            r27 = 1
            r0 = r27
            r1 = r24
            r1.AL_SchmittInput = r0     // Catch:{ Exception -> 0x0271 }
        L_0x0120:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r27 = r27 & 48
            int r27 = r27 >> 4
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r17 = r0
            switch(r17) {
                case 0: goto L_0x0343;
                case 1: goto L_0x034d;
                case 2: goto L_0x0357;
                case 3: goto L_0x0361;
                default: goto L_0x0130;
            }     // Catch:{ Exception -> 0x0271 }
        L_0x0130:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r27 = r27 & 64
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r18 = r0
            r27 = 64
            r0 = r18
            r1 = r27
            if (r0 != r1) goto L_0x036b
            r27 = 1
            r0 = r27
            r1 = r24
            r1.AH_SlowSlew = r0     // Catch:{ Exception -> 0x0271 }
        L_0x014b:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r0 = r0 & 128(0x80, float:1.794E-43)
            r27 = r0
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r19 = r0
            r27 = 128(0x80, float:1.794E-43)
            r0 = r19
            r1 = r27
            if (r0 != r1) goto L_0x0375
            r27 = 1
            r0 = r27
            r1 = r24
            r1.AH_SchmittInput = r0     // Catch:{ Exception -> 0x0271 }
        L_0x016a:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r0 = r0 & 768(0x300, float:1.076E-42)
            r27 = r0
            int r27 = r27 >> 8
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r21 = r0
            switch(r21) {
                case 0: goto L_0x037f;
                case 1: goto L_0x0389;
                case 2: goto L_0x0393;
                case 3: goto L_0x039d;
                default: goto L_0x017e;
            }     // Catch:{ Exception -> 0x0271 }
        L_0x017e:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r0 = r0 & 1024(0x400, float:1.435E-42)
            r27 = r0
            r0 = r27
            short r7 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = 1024(0x400, float:1.435E-42)
            r0 = r27
            if (r7 != r0) goto L_0x03a7
            r27 = 1
            r0 = r27
            r1 = r24
            r1.BL_SlowSlew = r0     // Catch:{ Exception -> 0x0271 }
        L_0x0199:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r0 = r0 & 2048(0x800, float:2.87E-42)
            r27 = r0
            r0 = r27
            short r9 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = 2048(0x800, float:2.87E-42)
            r0 = r19
            r1 = r27
            if (r0 != r1) goto L_0x03b1
            r27 = 1
            r0 = r27
            r1 = r24
            r1.BL_SchmittInput = r0     // Catch:{ Exception -> 0x0271 }
        L_0x01b6:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r0 = r0 & 12288(0x3000, float:1.7219E-41)
            r27 = r0
            int r27 = r27 >> 12
            r0 = r27
            short r10 = (short) r0     // Catch:{ Exception -> 0x0271 }
            switch(r10) {
                case 0: goto L_0x03bb;
                case 1: goto L_0x03c5;
                case 2: goto L_0x03cf;
                case 3: goto L_0x03d9;
                default: goto L_0x01c8;
            }     // Catch:{ Exception -> 0x0271 }
        L_0x01c8:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            r27 = r0
            r0 = r27
            short r11 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = 16384(0x4000, float:2.2959E-41)
            r0 = r27
            if (r11 != r0) goto L_0x03e3
            r27 = 1
            r0 = r27
            r1 = r24
            r1.BH_SlowSlew = r0     // Catch:{ Exception -> 0x0271 }
        L_0x01e3:
            r27 = 6
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r28 = 32768(0x8000, float:4.5918E-41)
            r27 = r27 & r28
            r0 = r27
            short r13 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r27 = 32768(0x8000, float:4.5918E-41)
            r0 = r27
            if (r13 != r0) goto L_0x03ed
            r27 = 1
            r0 = r27
            r1 = r24
            r1.BH_SchmittInput = r0     // Catch:{ Exception -> 0x0271 }
        L_0x01fe:
            r27 = 11
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r27 = r27 & 24
            int r27 = r27 >> 3
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r22 = r0
            r27 = 4
            r0 = r22
            r1 = r27
            if (r0 >= r1) goto L_0x03f7
            r0 = r22
            r1 = r24
            r1.TPRDRV = r0     // Catch:{ Exception -> 0x0271 }
        L_0x0219:
            r27 = 7
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r3 = r0 & 255(0xff, float:3.57E-43)
            r0 = r29
            short r0 = r0.mEepromType     // Catch:{ Exception -> 0x0271 }
            r27 = r0
            r28 = 70
            r0 = r27
            r1 = r28
            if (r0 != r1) goto L_0x0401
            int r3 = r3 + -128
            int r3 = r3 / 2
            r0 = r29
            java.lang.String r27 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r1 = r24
            r1.Manufacturer = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 8
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            int r3 = r3 / 2
            r0 = r29
            java.lang.String r27 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r1 = r24
            r1.Product = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 9
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 + -128
            int r3 = r3 / 2
            r0 = r29
            java.lang.String r27 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r1 = r24
            r1.SerialNumber = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0017
        L_0x0271:
            r23 = move-exception
            r24 = 0
            goto L_0x0017
        L_0x0276:
            r0 = r29
            r1 = r25
            int r27 = r0.readWord(r1)     // Catch:{ Exception -> 0x0271 }
            r4[r25] = r27     // Catch:{ Exception -> 0x0271 }
            int r27 = r25 + 1
            r0 = r27
            short r0 = (short) r0     // Catch:{ Exception -> 0x0271 }
            r25 = r0
            goto L_0x001a
        L_0x0289:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.A_UART = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x003c
        L_0x0293:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.A_FIFO = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x003c
        L_0x029d:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.A_FIFOTarget = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x003c
        L_0x02a7:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.A_FastSerial = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x003c
        L_0x02b1:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.A_LoadVCP = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 1
            r0 = r27
            r1 = r24
            r1.A_LoadD2XX = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0059
        L_0x02c3:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.B_UART = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0071
        L_0x02cd:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.B_FIFO = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0071
        L_0x02d7:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.B_FIFOTarget = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0071
        L_0x02e1:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.B_FastSerial = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0071
        L_0x02eb:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.B_LoadVCP = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 1
            r0 = r27
            r1 = r24
            r1.B_LoadD2XX = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0092
        L_0x02fd:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.PowerSaveEnable = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x00aa
        L_0x0307:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x00ee
        L_0x0311:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x00ee
        L_0x031b:
            r27 = 2
            r0 = r27
            r1 = r24
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x00ee
        L_0x0325:
            r27 = 3
            r0 = r27
            r1 = r24
            r1.AL_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x00ee
        L_0x032f:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.AL_SlowSlew = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0105
        L_0x0339:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.AL_SchmittInput = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0120
        L_0x0343:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.AH_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0130
        L_0x034d:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.AH_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0130
        L_0x0357:
            r27 = 2
            r0 = r27
            r1 = r24
            r1.AH_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0130
        L_0x0361:
            r27 = 3
            r0 = r27
            r1 = r24
            r1.AH_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0130
        L_0x036b:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.AH_SlowSlew = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x014b
        L_0x0375:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.AH_SchmittInput = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x016a
        L_0x037f:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x017e
        L_0x0389:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x017e
        L_0x0393:
            r27 = 2
            r0 = r27
            r1 = r24
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x017e
        L_0x039d:
            r27 = 3
            r0 = r27
            r1 = r24
            r1.BL_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x017e
        L_0x03a7:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.BL_SlowSlew = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0199
        L_0x03b1:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.BL_SchmittInput = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x01b6
        L_0x03bb:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.BH_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x01c8
        L_0x03c5:
            r27 = 1
            r0 = r27
            r1 = r24
            r1.BH_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x01c8
        L_0x03cf:
            r27 = 2
            r0 = r27
            r1 = r24
            r1.BH_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x01c8
        L_0x03d9:
            r27 = 3
            r0 = r27
            r1 = r24
            r1.BH_DriveCurrent = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x01c8
        L_0x03e3:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.BH_SlowSlew = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x01e3
        L_0x03ed:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.BH_SchmittInput = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x01fe
        L_0x03f7:
            r27 = 0
            r0 = r27
            r1 = r24
            r1.TPRDRV = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0219
        L_0x0401:
            int r3 = r3 / 2
            r0 = r29
            java.lang.String r27 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r1 = r24
            r1.Manufacturer = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 8
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 / 2
            r0 = r29
            java.lang.String r27 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r1 = r24
            r1.Product = r0     // Catch:{ Exception -> 0x0271 }
            r27 = 9
            r27 = r4[r27]     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r3 = r0 & 255(0xff, float:3.57E-43)
            int r3 = r3 / 2
            r0 = r29
            java.lang.String r27 = r0.getStringDescriptor(r3, r4)     // Catch:{ Exception -> 0x0271 }
            r0 = r27
            r1 = r24
            r1.SerialNumber = r0     // Catch:{ Exception -> 0x0271 }
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ftdi.j2xx.FT_EE_2232H_Ctrl.readEeprom():com.ftdi.j2xx.FT_EEPROM");
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
