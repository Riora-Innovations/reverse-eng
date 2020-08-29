package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/* renamed from: com.google.android.gms.internal.jz */
public final class C1140jz {
    private final int aad;
    private final byte[] buffer;
    private int position;

    /* renamed from: com.google.android.gms.internal.jz$a */
    public static class C1141a extends IOException {
        C1141a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    private C1140jz(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.position = i;
        this.aad = i + i2;
    }

    /* renamed from: A */
    public static int m3408A(long j) {
        return m3410C(m3411D(j));
    }

    /* renamed from: B */
    public static int m3409B(boolean z) {
        return 1;
    }

    /* renamed from: C */
    public static int m3410C(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    /* renamed from: D */
    public static long m3411D(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* renamed from: b */
    public static int m3412b(int i, float f) {
        return m3419cE(i) + m3422e(f);
    }

    /* renamed from: b */
    public static int m3413b(int i, C1148ke keVar) {
        return m3419cE(i) + m3417c(keVar);
    }

    /* renamed from: b */
    public static int m3414b(int i, boolean z) {
        return m3419cE(i) + m3409B(z);
    }

    /* renamed from: b */
    public static C1140jz m3415b(byte[] bArr, int i, int i2) {
        return new C1140jz(bArr, i, i2);
    }

    /* renamed from: bQ */
    public static int m3416bQ(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + m3420cG(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    /* renamed from: c */
    public static int m3417c(C1148ke keVar) {
        int c = keVar.mo3799c();
        return c + m3420cG(c);
    }

    /* renamed from: cC */
    public static int m3418cC(int i) {
        if (i >= 0) {
            return m3420cG(i);
        }
        return 10;
    }

    /* renamed from: cE */
    public static int m3419cE(int i) {
        return m3420cG(C1151kh.m3489i(i, 0));
    }

    /* renamed from: cG */
    public static int m3420cG(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    /* renamed from: d */
    public static int m3421d(int i, long j) {
        return m3419cE(i) + m3427z(j);
    }

    /* renamed from: e */
    public static int m3422e(float f) {
        return 4;
    }

    /* renamed from: e */
    public static int m3423e(int i, long j) {
        return m3419cE(i) + m3408A(j);
    }

    /* renamed from: g */
    public static int m3424g(int i, int i2) {
        return m3419cE(i) + m3418cC(i2);
    }

    /* renamed from: g */
    public static int m3425g(int i, String str) {
        return m3419cE(i) + m3416bQ(str);
    }

    /* renamed from: o */
    public static C1140jz m3426o(byte[] bArr) {
        return m3415b(bArr, 0, bArr.length);
    }

    /* renamed from: z */
    public static int m3427z(long j) {
        return m3410C(j);
    }

    /* renamed from: A */
    public void mo6394A(boolean z) throws IOException {
        mo6407cD(z ? 1 : 0);
    }

    /* renamed from: B */
    public void mo6395B(long j) throws IOException {
        while ((-128 & j) != 0) {
            mo6407cD((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        mo6407cD((int) j);
    }

    /* renamed from: a */
    public void mo6396a(int i, float f) throws IOException {
        mo6412h(i, 5);
        mo6410d(f);
    }

    /* renamed from: a */
    public void mo6397a(int i, C1148ke keVar) throws IOException {
        mo6412h(i, 2);
        mo6402b(keVar);
    }

    /* renamed from: a */
    public void mo6398a(int i, boolean z) throws IOException {
        mo6412h(i, 0);
        mo6394A(z);
    }

    /* renamed from: b */
    public void mo6399b(byte b) throws IOException {
        if (this.position == this.aad) {
            throw new C1141a(this.position, this.aad);
        }
        byte[] bArr = this.buffer;
        int i = this.position;
        this.position = i + 1;
        bArr[i] = b;
    }

    /* renamed from: b */
    public void mo6400b(int i, long j) throws IOException {
        mo6412h(i, 0);
        mo6416x(j);
    }

    /* renamed from: b */
    public void mo6401b(int i, String str) throws IOException {
        mo6412h(i, 2);
        mo6403bP(str);
    }

    /* renamed from: b */
    public void mo6402b(C1148ke keVar) throws IOException {
        mo6408cF(keVar.mo3800eW());
        keVar.mo3797a(this);
    }

    /* renamed from: bP */
    public void mo6403bP(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        mo6408cF(bytes.length);
        mo6415p(bytes);
    }

    /* renamed from: c */
    public void mo6404c(int i, long j) throws IOException {
        mo6412h(i, 0);
        mo6417y(j);
    }

    /* renamed from: c */
    public void mo6405c(byte[] bArr, int i, int i2) throws IOException {
        if (this.aad - this.position >= i2) {
            System.arraycopy(bArr, i, this.buffer, this.position, i2);
            this.position += i2;
            return;
        }
        throw new C1141a(this.position, this.aad);
    }

    /* renamed from: cB */
    public void mo6406cB(int i) throws IOException {
        if (i >= 0) {
            mo6408cF(i);
        } else {
            mo6395B((long) i);
        }
    }

    /* renamed from: cD */
    public void mo6407cD(int i) throws IOException {
        mo6399b((byte) i);
    }

    /* renamed from: cF */
    public void mo6408cF(int i) throws IOException {
        while ((i & -128) != 0) {
            mo6407cD((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        mo6407cD(i);
    }

    /* renamed from: cH */
    public void mo6409cH(int i) throws IOException {
        mo6407cD(i & MotionEventCompat.ACTION_MASK);
        mo6407cD((i >> 8) & MotionEventCompat.ACTION_MASK);
        mo6407cD((i >> 16) & MotionEventCompat.ACTION_MASK);
        mo6407cD((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: d */
    public void mo6410d(float f) throws IOException {
        mo6409cH(Float.floatToIntBits(f));
    }

    /* renamed from: f */
    public void mo6411f(int i, int i2) throws IOException {
        mo6412h(i, 0);
        mo6406cB(i2);
    }

    /* renamed from: h */
    public void mo6412h(int i, int i2) throws IOException {
        mo6408cF(C1151kh.m3489i(i, i2));
    }

    /* renamed from: kM */
    public int mo6413kM() {
        return this.aad - this.position;
    }

    /* renamed from: kN */
    public void mo6414kN() {
        if (mo6413kM() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: p */
    public void mo6415p(byte[] bArr) throws IOException {
        mo6405c(bArr, 0, bArr.length);
    }

    /* renamed from: x */
    public void mo6416x(long j) throws IOException {
        mo6395B(j);
    }

    /* renamed from: y */
    public void mo6417y(long j) throws IOException {
        mo6395B(m3411D(j));
    }
}
