package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.kh */
public final class C1151kh {
    public static final int[] aaj = new int[0];
    public static final long[] aak = new long[0];
    public static final float[] aal = new float[0];
    public static final double[] aam = new double[0];
    public static final boolean[] aan = new boolean[0];
    public static final String[] aao = new String[0];
    public static final byte[][] aap = new byte[0][];
    public static final byte[] aaq = new byte[0];

    /* renamed from: b */
    public static boolean m3485b(C1139jy jyVar, int i) throws IOException {
        return jyVar.mo6372cv(i);
    }

    /* renamed from: c */
    public static final int m3486c(C1139jy jyVar, int i) throws IOException {
        int i2 = 1;
        int position = jyVar.getPosition();
        jyVar.mo6372cv(i);
        while (jyVar.mo6387kJ() > 0 && jyVar.mo6390ky() == i) {
            jyVar.mo6372cv(i);
            i2++;
        }
        jyVar.mo6375cy(position);
        return i2;
    }

    /* renamed from: cJ */
    static int m3487cJ(int i) {
        return i & 7;
    }

    /* renamed from: cK */
    public static int m3488cK(int i) {
        return i >>> 3;
    }

    /* renamed from: i */
    static int m3489i(int i, int i2) {
        return (i << 3) | i2;
    }
}
