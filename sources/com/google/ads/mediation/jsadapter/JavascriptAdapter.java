package com.google.ads.mediation.jsadapter;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.EmptyNetworkExtras;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.android.gms.internal.C0662da;

public final class JavascriptAdapter implements MediationBannerAdapter<EmptyNetworkExtras, JavascriptServerParameters> {

    /* renamed from: C */
    private WebView f48C;

    /* renamed from: D */
    private FrameLayout f49D;

    /* renamed from: E */
    private boolean f50E;

    /* renamed from: k */
    private MediationBannerListener f51k;

    /* renamed from: v */
    private int f52v;

    /* renamed from: w */
    private int f53w;

    public void destroy() {
        this.f50E = true;
    }

    public Class<EmptyNetworkExtras> getAdditionalParametersType() {
        return EmptyNetworkExtras.class;
    }

    public View getBannerView() {
        return this.f49D;
    }

    public Class<JavascriptServerParameters> getServerParametersType() {
        return JavascriptServerParameters.class;
    }

    public WebView getWebView() {
        return this.f48C;
    }

    public int getWebViewHeight() {
        return this.f52v;
    }

    public int getWebViewWidth() {
        return this.f53w;
    }

    public void passbackReceived() {
        C0662da.m1551s("Passback received");
        sendAdNotReceivedUpdate();
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, JavascriptServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, EmptyNetworkExtras extras) {
        this.f51k = listener;
        this.f52v = serverParameters.height != null ? serverParameters.height.intValue() : adSize.getHeightInPixels(activity);
        this.f53w = serverParameters.width != null ? serverParameters.width.intValue() : adSize.getWidthInPixels(activity);
        this.f50E = false;
        this.f48C = new WebView(activity);
        this.f48C.getSettings().setJavaScriptEnabled(true);
        this.f48C.setWebViewClient(new BannerWebViewClient(this, serverParameters.passBackUrl));
        this.f48C.setBackgroundColor(0);
        this.f49D = new FrameLayout(activity);
        this.f49D.addView(this.f48C, new LayoutParams(this.f53w, this.f52v, 17));
        this.f48C.loadDataWithBaseURL(null, serverParameters.htmlScript, "text/html", "utf-8", null);
    }

    public void sendAdNotReceivedUpdate() {
        if (!this.f50E) {
            this.f50E = true;
            this.f51k.onFailedToReceiveAd(this, ErrorCode.NO_FILL);
        }
    }

    public void sendAdReceivedUpdate() {
        if (!this.f50E) {
            this.f50E = true;
            this.f51k.onReceivedAd(this);
        }
    }

    public boolean shouldStopAdCheck() {
        return this.f50E;
    }

    public void startCheckingForAd() {
        new AdViewCheckTask(this, 200, 100).start();
    }
}
