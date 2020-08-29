package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

/* renamed from: com.google.android.gms.internal.da */
public final class C0662da {
    /* renamed from: a */
    public static void m1548a(String str, Throwable th) {
        if (m1550n(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: b */
    public static void m1549b(String str, Throwable th) {
        if (m1550n(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    /* renamed from: n */
    public static boolean m1550n(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }

    /* renamed from: s */
    public static void m1551s(String str) {
        if (m1550n(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: t */
    public static void m1552t(String str) {
        if (m1550n(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: u */
    public static void m1553u(String str) {
        if (m1550n(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: v */
    public static void m1554v(String str) {
        if (m1550n(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    /* renamed from: w */
    public static void m1555w(String str) {
        if (m1550n(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }
}
