package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.internal.C0523al;

public final class InterstitialAd {

    /* renamed from: kE */
    private final C0523al f61kE;

    public InterstitialAd(Context context) {
        this.f61kE = new C0523al(context);
    }

    public AdListener getAdListener() {
        return this.f61kE.getAdListener();
    }

    public String getAdUnitId() {
        return this.f61kE.getAdUnitId();
    }

    public boolean isLoaded() {
        return this.f61kE.isLoaded();
    }

    public void loadAd(AdRequest adRequest) {
        this.f61kE.mo4561a(adRequest.mo2610N());
    }

    public void setAdListener(AdListener adListener) {
        this.f61kE.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.f61kE.setAdUnitId(adUnitId);
    }

    public void show() {
        this.f61kE.show();
    }
}
