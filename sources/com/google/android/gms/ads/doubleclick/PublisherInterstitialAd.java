package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.C0523al;

public final class PublisherInterstitialAd {

    /* renamed from: kE */
    private final C0523al f65kE;

    public PublisherInterstitialAd(Context context) {
        this.f65kE = new C0523al(context);
    }

    public AdListener getAdListener() {
        return this.f65kE.getAdListener();
    }

    public String getAdUnitId() {
        return this.f65kE.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.f65kE.getAppEventListener();
    }

    public boolean isLoaded() {
        return this.f65kE.isLoaded();
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.f65kE.mo4561a(publisherAdRequest.mo2654N());
    }

    public void setAdListener(AdListener adListener) {
        this.f65kE.setAdListener(adListener);
    }

    public void setAdUnitId(String adUnitId) {
        this.f65kE.setAdUnitId(adUnitId);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.f65kE.setAppEventListener(appEventListener);
    }

    public void show() {
        this.f65kE.show();
    }
}
