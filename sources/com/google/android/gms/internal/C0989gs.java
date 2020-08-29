package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.gs */
public final class C0989gs {
    /* renamed from: aW */
    public static String m2916aW(int i) {
        switch (i) {
            case 1:
                return "GIFT";
            case 2:
                return "WISH";
            default:
                C0891fz.m2399h("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
