package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.dynamic.C0453b;
import com.google.android.gms.dynamic.C0456c;

/* renamed from: com.google.android.gms.internal.ak */
public final class C0522ak {

    /* renamed from: lF */
    private final C0553be f1225lF = new C0553be();

    /* renamed from: lG */
    private C0511ag f1226lG;

    /* renamed from: lH */
    private ViewGroup f1227lH;

    /* renamed from: lc */
    private AdListener f1228lc;

    /* renamed from: lq */
    private AppEventListener f1229lq;

    /* renamed from: lr */
    private AdSize[] f1230lr;

    /* renamed from: ls */
    private String f1231ls;

    public C0522ak(ViewGroup viewGroup) {
        this.f1227lH = viewGroup;
    }

    public C0522ak(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this.f1227lH = viewGroup;
        Context context = viewGroup.getContext();
        try {
            C0507ae aeVar = new C0507ae(context, attributeSet);
            this.f1230lr = aeVar.mo4492c(z);
            this.f1231ls = aeVar.getAdUnitId();
            if (viewGroup.isInEditMode()) {
                C0659cz.m1535a(viewGroup, new C0504ab(context, this.f1230lr[0]), "Ads by Google");
            }
        } catch (IllegalArgumentException e) {
            C0659cz.m1537a(viewGroup, new C0504ab(context, AdSize.BANNER), e.getMessage(), e.getMessage());
        }
    }

    /* renamed from: am */
    private void m1203am() {
        try {
            C0453b P = this.f1226lG.mo4502P();
            if (P != null) {
                this.f1227lH.addView((View) C0456c.m1000b(P));
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to get an ad frame.", e);
        }
    }

    /* renamed from: an */
    private void m1204an() throws RemoteException {
        if ((this.f1230lr == null || this.f1231ls == null) && this.f1226lG == null) {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        Context context = this.f1227lH.getContext();
        this.f1226lG = C1172y.m3569a(context, new C0504ab(context, this.f1230lr), this.f1231ls, this.f1225lF);
        if (this.f1228lc != null) {
            this.f1226lG.mo4506a((C0508af) new C1171x(this.f1228lc));
        }
        if (this.f1229lq != null) {
            this.f1226lG.mo4507a((C0517ai) new C0506ad(this.f1229lq));
        }
        m1203am();
    }

    /* renamed from: a */
    public void mo4546a(C0520aj ajVar) {
        try {
            if (this.f1226lG == null) {
                m1204an();
            }
            if (this.f1226lG.mo4508a(new C1173z(this.f1227lH.getContext(), ajVar))) {
                this.f1225lF.mo4601c(ajVar.mo4525ak());
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to load ad.", e);
        }
    }

    /* renamed from: a */
    public void mo4547a(AdSize... adSizeArr) {
        this.f1230lr = adSizeArr;
        try {
            if (this.f1226lG != null) {
                this.f1226lG.mo4505a(new C0504ab(this.f1227lH.getContext(), this.f1230lr));
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to set the ad size.", e);
        }
        this.f1227lH.requestLayout();
    }

    public void destroy() {
        try {
            if (this.f1226lG != null) {
                this.f1226lG.destroy();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to destroy AdView.", e);
        }
    }

    public AdListener getAdListener() {
        return this.f1228lc;
    }

    public AdSize getAdSize() {
        try {
            if (this.f1226lG != null) {
                return this.f1226lG.mo4503Q().mo4484ai();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to get the current AdSize.", e);
        }
        if (this.f1230lr != null) {
            return this.f1230lr[0];
        }
        return null;
    }

    public AdSize[] getAdSizes() {
        return this.f1230lr;
    }

    public String getAdUnitId() {
        return this.f1231ls;
    }

    public AppEventListener getAppEventListener() {
        return this.f1229lq;
    }

    public void pause() {
        try {
            if (this.f1226lG != null) {
                this.f1226lG.pause();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to call pause.", e);
        }
    }

    public void recordManualImpression() {
        try {
            this.f1226lG.mo4504Z();
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to record impression.", e);
        }
    }

    public void resume() {
        try {
            if (this.f1226lG != null) {
                this.f1226lG.resume();
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to call resume.", e);
        }
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.f1228lc = adListener;
            if (this.f1226lG != null) {
                this.f1226lG.mo4506a((C0508af) adListener != null ? new C1171x(adListener) : null);
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to set the AdListener.", e);
        }
    }

    public void setAdSizes(AdSize... adSizes) {
        if (this.f1230lr != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        mo4547a(adSizes);
    }

    public void setAdUnitId(String adUnitId) {
        if (this.f1231ls != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f1231ls = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.f1229lq = appEventListener;
            if (this.f1226lG != null) {
                this.f1226lG.mo4507a((C0517ai) appEventListener != null ? new C0506ad(appEventListener) : null);
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Failed to set the AppEventListener.", e);
        }
    }
}
