package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import java.math.BigInteger;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.cs */
public final class C0647cs {

    /* renamed from: op */
    private static final Object f1769op = new Object();

    /* renamed from: pH */
    private static String f1770pH;

    /* renamed from: aR */
    public static String m1494aR() {
        String str;
        synchronized (f1769op) {
            str = f1770pH;
        }
        return str;
    }

    /* renamed from: b */
    public static String m1495b(Context context, String str, String str2) {
        String str3;
        synchronized (f1769op) {
            if (f1770pH == null && !TextUtils.isEmpty(str)) {
                m1496c(context, str, str2);
            }
            str3 = f1770pH;
        }
        return str3;
    }

    /* renamed from: c */
    private static void m1496c(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (C0653cv.m1510a(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            f1770pH = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            f1770pH = "err";
        }
    }
}
