package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.internal.C0576bk;
import com.google.android.gms.internal.C0659cz;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter<AdMobExtras, AdMobServerParameters>, MediationInterstitialAdapter<AdMobExtras, AdMobServerParameters> {

    /* renamed from: h */
    private AdView f22h;

    /* renamed from: i */
    private InterstitialAd f23i;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$a */
    private static final class C0162a extends AdListener {

        /* renamed from: j */
        private final AdMobAdapter f24j;

        /* renamed from: k */
        private final MediationBannerListener f25k;

        public C0162a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f24j = adMobAdapter;
            this.f25k = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f25k.onDismissScreen(this.f24j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f25k.onFailedToReceiveAd(this.f24j, C0576bk.m1283h(errorCode));
        }

        public void onAdLeftApplication() {
            this.f25k.onLeaveApplication(this.f24j);
        }

        public void onAdLoaded() {
            this.f25k.onReceivedAd(this.f24j);
        }

        public void onAdOpened() {
            this.f25k.onClick(this.f24j);
            this.f25k.onPresentScreen(this.f24j);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$b */
    private static final class C0163b extends AdListener {

        /* renamed from: j */
        private final AdMobAdapter f26j;

        /* renamed from: l */
        private final MediationInterstitialListener f27l;

        public C0163b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f26j = adMobAdapter;
            this.f27l = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f27l.onDismissScreen(this.f26j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f27l.onFailedToReceiveAd(this.f26j, C0576bk.m1283h(errorCode));
        }

        public void onAdLeftApplication() {
            this.f27l.onLeaveApplication(this.f26j);
        }

        public void onAdLoaded() {
            this.f27l.onReceivedAd(this.f26j);
        }

        public void onAdOpened() {
            this.f27l.onPresentScreen(this.f26j);
        }
    }

    /* renamed from: a */
    private static AdRequest m4a(Context context, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras, AdMobServerParameters adMobServerParameters) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        Gender gender = mediationAdRequest.getGender();
        if (gender != null) {
            builder.setGender(C0576bk.m1279a(gender));
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(C0659cz.m1540l(context));
        }
        if (adMobServerParameters.tagForChildDirectedTreatment != -1) {
            builder.tagForChildDirectedTreatment(adMobServerParameters.tagForChildDirectedTreatment == 1);
        }
        if (adMobExtras == null) {
            adMobExtras = new AdMobExtras(new Bundle());
        }
        Bundle extras = adMobExtras.getExtras();
        extras.putInt("gw", 1);
        extras.putString("mad_hac", adMobServerParameters.allowHouseAds);
        if (!TextUtils.isEmpty(adMobServerParameters.adJson)) {
            extras.putString("_ad", adMobServerParameters.adJson);
        }
        extras.putBoolean("_noRefresh", true);
        builder.addNetworkExtras(adMobExtras);
        return builder.build();
    }

    public void destroy() {
        if (this.f22h != null) {
            this.f22h.destroy();
            this.f22h = null;
        }
        if (this.f23i != null) {
            this.f23i = null;
        }
    }

    public Class<AdMobExtras> getAdditionalParametersType() {
        return AdMobExtras.class;
    }

    public View getBannerView() {
        return this.f22h;
    }

    public Class<AdMobServerParameters> getServerParametersType() {
        return AdMobServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener bannerListener, Activity activity, AdMobServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f22h = new AdView(activity);
        this.f22h.setAdSize(new com.google.android.gms.ads.AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f22h.setAdUnitId(serverParameters.adUnitId);
        this.f22h.setAdListener(new C0162a(this, bannerListener));
        this.f22h.loadAd(m4a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(MediationInterstitialListener interstitialListener, Activity activity, AdMobServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f23i = new InterstitialAd(activity);
        this.f23i.setAdUnitId(serverParameters.adUnitId);
        this.f23i.setAdListener(new C0163b(this, interstitialListener));
        this.f23i.loadAd(m4a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f23i.show();
    }
}
