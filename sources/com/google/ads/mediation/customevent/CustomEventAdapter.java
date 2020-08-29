package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.C0662da;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {

    /* renamed from: m */
    private View f28m;

    /* renamed from: n */
    private CustomEventBanner f29n;

    /* renamed from: o */
    private CustomEventInterstitial f30o;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    private static final class C0164a implements CustomEventBannerListener {

        /* renamed from: k */
        private final MediationBannerListener f31k;

        /* renamed from: p */
        private final CustomEventAdapter f32p;

        public C0164a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f32p = customEventAdapter;
            this.f31k = mediationBannerListener;
        }

        public void onClick() {
            C0662da.m1551s("Custom event adapter called onFailedToReceiveAd.");
            this.f31k.onClick(this.f32p);
        }

        public void onDismissScreen() {
            C0662da.m1551s("Custom event adapter called onFailedToReceiveAd.");
            this.f31k.onDismissScreen(this.f32p);
        }

        public void onFailedToReceiveAd() {
            C0662da.m1551s("Custom event adapter called onFailedToReceiveAd.");
            this.f31k.onFailedToReceiveAd(this.f32p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            C0662da.m1551s("Custom event adapter called onFailedToReceiveAd.");
            this.f31k.onLeaveApplication(this.f32p);
        }

        public void onPresentScreen() {
            C0662da.m1551s("Custom event adapter called onFailedToReceiveAd.");
            this.f31k.onPresentScreen(this.f32p);
        }

        public void onReceivedAd(View view) {
            C0662da.m1551s("Custom event adapter called onReceivedAd.");
            this.f32p.m6a(view);
            this.f31k.onReceivedAd(this.f32p);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    private class C0165b implements CustomEventInterstitialListener {

        /* renamed from: l */
        private final MediationInterstitialListener f33l;

        /* renamed from: p */
        private final CustomEventAdapter f34p;

        public C0165b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f34p = customEventAdapter;
            this.f33l = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            C0662da.m1551s("Custom event adapter called onDismissScreen.");
            this.f33l.onDismissScreen(this.f34p);
        }

        public void onFailedToReceiveAd() {
            C0662da.m1551s("Custom event adapter called onFailedToReceiveAd.");
            this.f33l.onFailedToReceiveAd(this.f34p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            C0662da.m1551s("Custom event adapter called onLeaveApplication.");
            this.f33l.onLeaveApplication(this.f34p);
        }

        public void onPresentScreen() {
            C0662da.m1551s("Custom event adapter called onPresentScreen.");
            this.f33l.onPresentScreen(this.f34p);
        }

        public void onReceivedAd() {
            C0662da.m1551s("Custom event adapter called onReceivedAd.");
            this.f33l.onReceivedAd(CustomEventAdapter.this);
        }
    }

    /* renamed from: a */
    private static <T> T m5a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            C0662da.m1555w("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6a(View view) {
        this.f28m = view;
    }

    public void destroy() {
        if (this.f29n != null) {
            this.f29n.destroy();
        }
        if (this.f30o != null) {
            this.f30o.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f28m;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f29n = (CustomEventBanner) m5a(serverParameters.className);
        if (this.f29n == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f29n.requestBannerAd(new C0164a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f30o = (CustomEventInterstitial) m5a(serverParameters.className);
        if (this.f30o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f30o.requestInterstitialAd(new C0165b(this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f30o.showInterstitial();
    }
}
