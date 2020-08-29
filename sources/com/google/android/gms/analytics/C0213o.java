package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.o */
final class C0213o {
    /* renamed from: b */
    private static String m194b(String str, int i) {
        if (i >= 1) {
            return str + i;
        }
        C0181aa.m72t("index out of range for " + str + " (" + i + ")");
        return "";
    }

    /* renamed from: q */
    static String m195q(int i) {
        return m194b("&cd", i);
    }

    /* renamed from: r */
    static String m196r(int i) {
        return m194b("&cm", i);
    }
}
