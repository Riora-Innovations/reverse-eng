package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;

/* renamed from: com.google.android.gms.internal.al */
public final class C0523al {

    /* renamed from: lF */
    private final C0553be f1232lF = new C0553be();

    /* renamed from: lG */
    private C0511ag f1233lG;

    /* renamed from: lc */
    private AdListener f1234lc;

    /* renamed from: lq */
    private AppEventListener f1235lq;

    /* renamed from: ls */
    private String f1236ls;
    private final Context mContext;

    public C0523al(Context context) {
        this.mContext = context;
    }

    /* renamed from: k */
    private void m1207k(String str) throws RemoteException {
        if (this.f1236ls == null) {
            m1208l(str);
        }
        this.f1233lG = C1172y.m3569a(this.mContext, new C0504ab(), this.f1236ls, this.f1232lF);
        if (this.f1234lc != null) {
            this.f1233lG.mo4506a((C0508af) new C1171x(this.f1234lc));
        }
        if (this.f1235lq != null) {
            this.f1233lG.mo4507a((C0517ai) new C0506ad(this.f1235lq));
        }
    }

    /* renamed from: l */
    private void m1208l(String str) {
        if (this.f1233lG == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    /* renamed from: a */
    public void mo4561a(C0520aj ajVar) {
        try {
            if (this.f1233lG == null) {
                m1207k("loadAd");
            }
            if (this.f1233lG.mo4508a(new C1173z(this.mContext, ajVar))) {
                this.f1232lF.mo4601c(ajVar.mo4525ak());
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to load ad.", e);
        }
    }

    public AdListener getAdListener() {
        return this.f1234lc;
    }

    public String getAdUnitId() {
        return this.f1236ls;
    }

    public AppEventListener getAppEventListener() {
        return this.f1235lq;
    }

    public boolean isLoaded() {
        try {
            if (this.f1233lG == null) {
                return false;
            }
            return this.f1233lG.isReady();
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to check if ad is ready.", e);
            return false;
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.f1234lc = adListener;
            if (this.f1233lG != null) {
                this.f1233lG.mo4506a((C0508af) adListener != null ? new C1171x(adListener) : null);
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.f1236ls != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.f1236ls = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.f1235lq = appEventListener;
            if (this.f1233lG != null) {
                this.f1233lG.mo4507a((C0517ai) appEventListener != null ? new C0506ad(appEventListener) : null);
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to set the AppEventListener.", e);
        }
    }

    public void show() {
        try {
            m1208l("show");
            this.f1233lG.showInterstitial();
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to show interstitial.", e);
        }
    }
}
