package com.google.android.gms.internal;

import android.support.p000v4.view.MotionEventCompat;

/* renamed from: com.google.android.gms.internal.jx */
public class C1138jx {

    /* renamed from: ZR */
    private final byte[] f3109ZR = new byte[256];

    /* renamed from: ZS */
    private int f3110ZS;

    /* renamed from: ZT */
    private int f3111ZT;

    public C1138jx(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f3109ZR[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = (b + this.f3109ZR[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = this.f3109ZR[i2];
            this.f3109ZR[i2] = this.f3109ZR[b];
            this.f3109ZR[b] = b2;
        }
        this.f3110ZS = 0;
        this.f3111ZT = 0;
    }

    /* renamed from: m */
    public void mo6367m(byte[] bArr) {
        int i = this.f3110ZS;
        int i2 = this.f3111ZT;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.f3109ZR[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.f3109ZR[i];
            this.f3109ZR[i] = this.f3109ZR[i2];
            this.f3109ZR[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f3109ZR[(this.f3109ZR[i] + this.f3109ZR[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.f3110ZS = i;
        this.f3111ZT = i2;
    }
}
