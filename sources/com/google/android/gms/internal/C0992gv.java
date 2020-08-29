package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.gv */
public final class C0992gv {
    /* renamed from: aW */
    public static String m2918aW(int i) {
        switch (i) {
            case 0:
                return "TURN_STATUS_INVITED";
            case 1:
                return "TURN_STATUS_MY_TURN";
            case 2:
                return "TURN_STATUS_THEIR_TURN";
            case 3:
                return "TURN_STATUS_COMPLETE";
            default:
                C0891fz.m2399h("MatchTurnStatus", "Unknown match turn status: " + i);
                return "TURN_STATUS_UNKNOWN";
        }
    }
}
