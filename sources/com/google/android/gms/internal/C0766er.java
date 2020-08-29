package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.internal.er */
public final class C0766er {
    /* renamed from: a */
    public static void m1970a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    /* renamed from: a */
    public static void m1971a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    /* renamed from: ac */
    public static void m1972ac(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: ad */
    public static void m1973ad(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    /* renamed from: aj */
    public static String m1974aj(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    /* renamed from: b */
    public static <T> T m1975b(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    /* renamed from: b */
    public static void m1976b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    /* renamed from: f */
    public static <T> T m1977f(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }

    /* renamed from: v */
    public static void m1978v(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: x */
    public static void m1979x(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
