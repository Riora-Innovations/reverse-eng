package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.aa */
public class C0181aa {

    /* renamed from: tV */
    private static GoogleAnalytics f144tV;

    /* renamed from: cm */
    public static boolean m71cm() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }

    private static Logger getLogger() {
        if (f144tV == null) {
            f144tV = GoogleAnalytics.m44cf();
        }
        if (f144tV != null) {
            return f144tV.getLogger();
        }
        return null;
    }

    /* renamed from: t */
    public static void m72t(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    /* renamed from: u */
    public static void m73u(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    /* renamed from: v */
    public static void m74v(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    /* renamed from: w */
    public static void m75w(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }
}
