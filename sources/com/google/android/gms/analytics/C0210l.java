package com.google.android.gms.analytics;

import android.util.Log;

/* renamed from: com.google.android.gms.analytics.l */
class C0210l implements Logger {

    /* renamed from: rc */
    private int f195rc = 1;

    C0210l() {
    }

    /* renamed from: z */
    private String m190z(String str) {
        return Thread.currentThread().toString() + ": " + str;
    }

    public void error(Exception exception) {
        if (this.f195rc <= 3) {
            Log.e("GAV3", null, exception);
        }
    }

    public void error(String msg) {
        if (this.f195rc <= 3) {
            Log.e("GAV3", m190z(msg));
        }
    }

    public int getLogLevel() {
        return this.f195rc;
    }

    public void info(String msg) {
        if (this.f195rc <= 1) {
            Log.i("GAV3", m190z(msg));
        }
    }

    public void setLogLevel(int level) {
        this.f195rc = level;
    }

    public void verbose(String msg) {
        if (this.f195rc <= 0) {
            Log.v("GAV3", m190z(msg));
        }
    }

    public void warn(String msg) {
        if (this.f195rc <= 2) {
            Log.w("GAV3", m190z(msg));
        }
    }
}
