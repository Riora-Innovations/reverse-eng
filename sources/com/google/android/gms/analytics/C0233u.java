package com.google.android.gms.analytics;

import java.util.SortedSet;
import java.util.TreeSet;

/* renamed from: com.google.android.gms.analytics.u */
class C0233u {

    /* renamed from: sk */
    private static final C0233u f261sk = new C0233u();

    /* renamed from: sh */
    private SortedSet<C0234a> f262sh = new TreeSet();

    /* renamed from: si */
    private StringBuilder f263si = new StringBuilder();

    /* renamed from: sj */
    private boolean f264sj = false;

    /* renamed from: com.google.android.gms.analytics.u$a */
    public enum C0234a {
        MAP_BUILDER_SET,
        MAP_BUILDER_SET_ALL,
        MAP_BUILDER_GET,
        MAP_BUILDER_SET_CAMPAIGN_PARAMS,
        BLANK_04,
        BLANK_05,
        BLANK_06,
        BLANK_07,
        BLANK_08,
        GET,
        SET,
        SEND,
        BLANK_12,
        BLANK_13,
        BLANK_14,
        BLANK_15,
        BLANK_16,
        BLANK_17,
        BLANK_18,
        BLANK_19,
        BLANK_20,
        BLANK_21,
        BLANK_22,
        BLANK_23,
        BLANK_24,
        BLANK_25,
        BLANK_26,
        BLANK_27,
        BLANK_28,
        BLANK_29,
        SET_EXCEPTION_PARSER,
        GET_EXCEPTION_PARSER,
        CONSTRUCT_TRANSACTION,
        CONSTRUCT_EXCEPTION,
        CONSTRUCT_RAW_EXCEPTION,
        CONSTRUCT_TIMING,
        CONSTRUCT_SOCIAL,
        BLANK_37,
        BLANK_38,
        GET_TRACKER,
        GET_DEFAULT_TRACKER,
        SET_DEFAULT_TRACKER,
        SET_APP_OPT_OUT,
        GET_APP_OPT_OUT,
        DISPATCH,
        SET_DISPATCH_PERIOD,
        BLANK_46,
        REPORT_UNCAUGHT_EXCEPTIONS,
        SET_AUTO_ACTIVITY_TRACKING,
        SET_SESSION_TIMEOUT,
        CONSTRUCT_EVENT,
        CONSTRUCT_ITEM,
        BLANK_52,
        BLANK_53,
        SET_DRY_RUN,
        GET_DRY_RUN,
        SET_LOGGER,
        SET_FORCE_LOCAL_DISPATCH,
        GET_TRACKER_NAME,
        CLOSE_TRACKER,
        EASY_TRACKER_ACTIVITY_START,
        EASY_TRACKER_ACTIVITY_STOP,
        CONSTRUCT_APP_VIEW
    }

    private C0233u() {
    }

    /* renamed from: bR */
    public static C0233u m266bR() {
        return f261sk;
    }

    /* renamed from: a */
    public synchronized void mo2969a(C0234a aVar) {
        if (!this.f264sj) {
            this.f262sh.add(aVar);
            this.f263si.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(aVar.ordinal()));
        }
    }

    /* renamed from: bS */
    public synchronized String mo2970bS() {
        StringBuilder sb;
        sb = new StringBuilder();
        int i = 6;
        int i2 = 0;
        while (this.f262sh.size() > 0) {
            C0234a aVar = (C0234a) this.f262sh.first();
            this.f262sh.remove(aVar);
            int ordinal = aVar.ordinal();
            while (ordinal >= i) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
                i += 6;
                i2 = 0;
            }
            i2 += 1 << (aVar.ordinal() % 6);
        }
        if (i2 > 0 || sb.length() == 0) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i2));
        }
        this.f262sh.clear();
        return sb.toString();
    }

    /* renamed from: bT */
    public synchronized String mo2971bT() {
        String sb;
        if (this.f263si.length() > 0) {
            this.f263si.insert(0, ".");
        }
        sb = this.f263si.toString();
        this.f263si = new StringBuilder();
        return sb;
    }

    /* renamed from: r */
    public synchronized void mo2972r(boolean z) {
        this.f264sj = z;
    }
}
