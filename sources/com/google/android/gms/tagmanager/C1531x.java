package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C1531x implements C1402bi {

    /* renamed from: rc */
    private int f3913rc = 5;

    C1531x() {
    }

    /* renamed from: b */
    public void mo7605b(String str, Throwable th) {
        if (this.f3913rc <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    /* renamed from: c */
    public void mo7606c(String str, Throwable th) {
        if (this.f3913rc <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    /* renamed from: s */
    public void mo7607s(String str) {
        if (this.f3913rc <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void setLogLevel(int logLevel) {
        this.f3913rc = logLevel;
    }

    /* renamed from: t */
    public void mo7609t(String str) {
        if (this.f3913rc <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    /* renamed from: u */
    public void mo7610u(String str) {
        if (this.f3913rc <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    /* renamed from: v */
    public void mo7611v(String str) {
        if (this.f3913rc <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    /* renamed from: w */
    public void mo7612w(String str) {
        if (this.f3913rc <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }
}
