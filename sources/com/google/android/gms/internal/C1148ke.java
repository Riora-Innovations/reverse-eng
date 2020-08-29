package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ke */
public abstract class C1148ke {

    /* renamed from: DY */
    protected int f3121DY = -1;

    /* renamed from: a */
    public static final <T extends C1148ke> T m3471a(T t, byte[] bArr) throws C1147kd {
        return m3473b(t, bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static final void m3472a(C1148ke keVar, byte[] bArr, int i, int i2) {
        try {
            C1140jz b = C1140jz.m3415b(bArr, i, i2);
            keVar.mo3797a(b);
            b.mo6414kN();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* renamed from: b */
    public static final <T extends C1148ke> T m3473b(T t, byte[] bArr, int i, int i2) throws C1147kd {
        try {
            C1139jy a = C1139jy.m3381a(bArr, i, i2);
            t.mo3798b(a);
            a.mo6371cu(0);
            return t;
        } catch (C1147kd e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: d */
    public static final byte[] m3474d(C1148ke keVar) {
        byte[] bArr = new byte[keVar.mo3799c()];
        m3472a(keVar, bArr, 0, bArr.length);
        return bArr;
    }

    /* renamed from: a */
    public void mo3797a(C1140jz jzVar) throws IOException {
    }

    /* renamed from: b */
    public abstract C1148ke mo3798b(C1139jy jyVar) throws IOException;

    /* renamed from: c */
    public int mo3799c() {
        this.f3121DY = 0;
        return 0;
    }

    /* renamed from: eW */
    public int mo3800eW() {
        if (this.f3121DY < 0) {
            mo3799c();
        }
        return this.f3121DY;
    }

    public String toString() {
        return C1149kf.m3484e(this);
    }
}
