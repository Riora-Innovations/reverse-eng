package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.gu */
public final class C0991gu {
    /* renamed from: aW */
    public static String m2917aW(int i) {
        switch (i) {
            case 0:
                return "DAILY";
            case 1:
                return "WEEKLY";
            case 2:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
