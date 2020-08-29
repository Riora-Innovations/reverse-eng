package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

/* renamed from: com.google.android.gms.tagmanager.df */
class C1484df {

    /* renamed from: XE */
    private GoogleAnalytics f3810XE;
    private Context mContext;

    /* renamed from: re */
    private Tracker f3811re;

    /* renamed from: com.google.android.gms.tagmanager.df$a */
    static class C1485a implements Logger {
        C1485a() {
        }

        /* renamed from: bX */
        private static int m4352bX(int i) {
            switch (i) {
                case 2:
                    return 0;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            C1401bh.m4073c("", exception);
        }

        public void error(String message) {
            C1401bh.m4075t(message);
        }

        public int getLogLevel() {
            return m4352bX(C1401bh.getLogLevel());
        }

        public void info(String message) {
            C1401bh.m4076u(message);
        }

        public void setLogLevel(int logLevel) {
            C1401bh.m4078w("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            C1401bh.m4077v(message);
        }

        public void warn(String message) {
            C1401bh.m4078w(message);
        }
    }

    C1484df(Context context) {
        this.mContext = context;
    }

    /* renamed from: bG */
    private synchronized void m4350bG(String str) {
        if (this.f3810XE == null) {
            this.f3810XE = GoogleAnalytics.getInstance(this.mContext);
            this.f3810XE.setLogger(new C1485a());
            this.f3811re = this.f3810XE.newTracker(str);
        }
    }

    /* renamed from: bF */
    public Tracker mo7769bF(String str) {
        m4350bG(str);
        return this.f3811re;
    }
}
