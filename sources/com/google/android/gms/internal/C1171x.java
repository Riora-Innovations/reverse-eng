package com.google.android.gms.internal;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.C0508af.C0509a;

/* renamed from: com.google.android.gms.internal.x */
public final class C1171x extends C0509a {

    /* renamed from: lc */
    private final AdListener f3156lc;

    public C1171x(AdListener adListener) {
        this.f3156lc = adListener;
    }

    public void onAdClosed() {
        this.f3156lc.onAdClosed();
    }

    public void onAdFailedToLoad(int errorCode) {
        this.f3156lc.onAdFailedToLoad(errorCode);
    }

    public void onAdLeftApplication() {
        this.f3156lc.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.f3156lc.onAdLoaded();
    }

    public void onAdOpened() {
        this.f3156lc.onAdOpened();
    }
}
