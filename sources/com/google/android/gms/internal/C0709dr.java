package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.dr */
public final class C0709dr {
    /* renamed from: a */
    public static <T> boolean m1723a(T t, T t2) {
        return (t == null && t2 == null) || !(t == null || t2 == null || !t.equals(t2));
    }

    /* renamed from: b */
    public static long m1724b(double d) {
        return (long) (1000.0d * d);
    }

    /* renamed from: l */
    public static double m1725l(long j) {
        return ((double) j) / 1000.0d;
    }
}
