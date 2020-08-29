package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.C0453b;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.internal.C0511ag.C0512a;
import com.google.android.gms.internal.C0601by.C0602a;
import com.google.android.gms.internal.C0625cd.C0626a;
import java.util.HashSet;

/* renamed from: com.google.android.gms.internal.v */
public final class C1167v extends C0512a implements C0527ap, C0545az, C0587br, C0592bu, C0602a, C1166u {

    /* renamed from: kH */
    private final C0554bf f3135kH;

    /* renamed from: kI */
    private final C1168a f3136kI;

    /* renamed from: kJ */
    private final C1169w f3137kJ = new C1169w(this);

    /* renamed from: com.google.android.gms.internal.v$a */
    public static final class C1168a {
        public final String adUnitId;

        /* renamed from: kK */
        public final ViewSwitcher f3138kK;

        /* renamed from: kL */
        public final Context f3139kL;

        /* renamed from: kM */
        public final C1152l f3140kM;

        /* renamed from: kN */
        public final C0663db f3141kN;

        /* renamed from: kO */
        public C0508af f3142kO;

        /* renamed from: kP */
        public C0648ct f3143kP;

        /* renamed from: kQ */
        public C0504ab f3144kQ;

        /* renamed from: kR */
        public C0641cn f3145kR;

        /* renamed from: kS */
        public C0642co f3146kS;

        /* renamed from: kT */
        public C0517ai f3147kT;

        /* renamed from: kU */
        public C0646cr f3148kU = null;

        /* renamed from: kV */
        private HashSet<C0642co> f3149kV = null;

        public C1168a(Context context, C0504ab abVar, String str, C0663db dbVar) {
            if (abVar.f1195lo) {
                this.f3138kK = null;
            } else {
                this.f3138kK = new ViewSwitcher(context);
                this.f3138kK.setMinimumWidth(abVar.widthPixels);
                this.f3138kK.setMinimumHeight(abVar.heightPixels);
                this.f3138kK.setVisibility(4);
            }
            this.f3144kQ = abVar;
            this.adUnitId = str;
            this.f3139kL = context;
            this.f3140kM = new C1152l(C1142k.m3452a(dbVar.f1798pU, context));
            this.f3141kN = dbVar;
        }

        /* renamed from: a */
        public void mo6452a(HashSet<C0642co> hashSet) {
            this.f3149kV = hashSet;
        }

        /* renamed from: ah */
        public HashSet<C0642co> mo6453ah() {
            return this.f3149kV;
        }
    }

    public C1167v(Context context, C0504ab abVar, String str, C0554bf bfVar, C0663db dbVar) {
        this.f3136kI = new C1168a(context, abVar, str, dbVar);
        this.f3135kH = bfVar;
        C0662da.m1553u("Use AdRequest.Builder.addTestDevice(\"" + C0659cz.m1540l(context) + "\") to get test ads on this device.");
        C0653cv.m1518i(context);
    }

    /* renamed from: a */
    private void m3533a(int i) {
        C0662da.m1555w("Failed to load ad: " + i);
        if (this.f3136kI.f3142kO != null) {
            try {
                this.f3136kI.f3142kO.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                C0662da.m1549b("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    /* renamed from: aa */
    private void m3534aa() {
        C0662da.m1553u("Ad closing.");
        if (this.f3136kI.f3142kO != null) {
            try {
                this.f3136kI.f3142kO.onAdClosed();
            } catch (RemoteException e) {
                C0662da.m1549b("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    /* renamed from: ab */
    private void m3535ab() {
        C0662da.m1553u("Ad leaving application.");
        if (this.f3136kI.f3142kO != null) {
            try {
                this.f3136kI.f3142kO.onAdLeftApplication();
            } catch (RemoteException e) {
                C0662da.m1549b("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    /* renamed from: ac */
    private void m3536ac() {
        C0662da.m1553u("Ad opening.");
        if (this.f3136kI.f3142kO != null) {
            try {
                this.f3136kI.f3142kO.onAdOpened();
            } catch (RemoteException e) {
                C0662da.m1549b("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    /* renamed from: ad */
    private void m3537ad() {
        C0662da.m1553u("Ad finished loading.");
        if (this.f3136kI.f3142kO != null) {
            try {
                this.f3136kI.f3142kO.onAdLoaded();
            } catch (RemoteException e) {
                C0662da.m1549b("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    /* renamed from: ae */
    private boolean m3538ae() {
        boolean z = true;
        if (!C0653cv.m1509a(this.f3136kI.f3139kL.getPackageManager(), this.f3136kI.f3139kL.getPackageName(), "android.permission.INTERNET")) {
            if (!this.f3136kI.f3144kQ.f1195lo) {
                C0659cz.m1537a(this.f3136kI.f3138kK, this.f3136kI.f3144kQ, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            }
            z = false;
        }
        if (!C0653cv.m1517h(this.f3136kI.f3139kL)) {
            if (!this.f3136kI.f3144kQ.f1195lo) {
                C0659cz.m1537a(this.f3136kI.f3138kK, this.f3136kI.f3144kQ, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            }
            z = false;
        }
        if (!z && !this.f3136kI.f3144kQ.f1195lo) {
            this.f3136kI.f3138kK.setVisibility(0);
        }
        return z;
    }

    /* renamed from: af */
    private void m3539af() {
        if (this.f3136kI.f3145kR == null) {
            C0662da.m1555w("Ad state was null when trying to ping click URLs.");
            return;
        }
        C0662da.m1551s("Pinging click URLs.");
        this.f3136kI.f3146kS.mo4769aK();
        if (this.f3136kI.f3145kR.f1725mt != null) {
            C0653cv.m1504a(this.f3136kI.f3139kL, this.f3136kI.f3141kN.f1798pU, this.f3136kI.f3145kR.f1725mt);
        }
        if (this.f3136kI.f3145kR.f1735pf != null && this.f3136kI.f3145kR.f1735pf.f1275mt != null) {
            C0552bd.m1253a(this.f3136kI.f3139kL, this.f3136kI.f3141kN.f1798pU, this.f3136kI.f3145kR, this.f3136kI.adUnitId, false, this.f3136kI.f3145kR.f1735pf.f1275mt);
        }
    }

    /* renamed from: ag */
    private void m3540ag() {
        if (this.f3136kI.f3145kR != null) {
            this.f3136kI.f3145kR.f1728nu.destroy();
            this.f3136kI.f3145kR = null;
        }
    }

    /* renamed from: b */
    private void m3541b(View view) {
        this.f3136kI.f3138kK.addView(view, new LayoutParams(-2, -2));
    }

    /* renamed from: b */
    private void m3542b(boolean z) {
        if (this.f3136kI.f3145kR == null) {
            C0662da.m1555w("Ad state was null when trying to ping impression URLs.");
            return;
        }
        C0662da.m1551s("Pinging Impression URLs.");
        this.f3136kI.f3146kS.mo4768aJ();
        if (this.f3136kI.f3145kR.f1726mu != null) {
            C0653cv.m1504a(this.f3136kI.f3139kL, this.f3136kI.f3141kN.f1798pU, this.f3136kI.f3145kR.f1726mu);
        }
        if (!(this.f3136kI.f3145kR.f1735pf == null || this.f3136kI.f3145kR.f1735pf.f1276mu == null)) {
            C0552bd.m1253a(this.f3136kI.f3139kL, this.f3136kI.f3141kN.f1798pU, this.f3136kI.f3145kR, this.f3136kI.adUnitId, z, this.f3136kI.f3145kR.f1735pf.f1276mu);
        }
        if (this.f3136kI.f3145kR.f1721mM != null && this.f3136kI.f3145kR.f1721mM.f1271mp != null) {
            C0552bd.m1253a(this.f3136kI.f3139kL, this.f3136kI.f3141kN.f1798pU, this.f3136kI.f3145kR, this.f3136kI.adUnitId, z, this.f3136kI.f3145kR.f1721mM.f1271mp);
        }
    }

    /* renamed from: b */
    private boolean m3543b(C0641cn cnVar) {
        if (cnVar.f1732ok) {
            try {
                View view = (View) C0456c.m1000b(cnVar.f1722mN.getView());
                View nextView = this.f3136kI.f3138kK.getNextView();
                if (nextView != null) {
                    this.f3136kI.f3138kK.removeView(nextView);
                }
                try {
                    m3541b(view);
                } catch (Throwable th) {
                    C0662da.m1549b("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (RemoteException e) {
                C0662da.m1549b("Could not get View from mediation adapter.", e);
                return false;
            }
        } else if (cnVar.f1736pg != null) {
            cnVar.f1728nu.mo4806a(cnVar.f1736pg);
            this.f3136kI.f3138kK.removeAllViews();
            this.f3136kI.f3138kK.setMinimumWidth(cnVar.f1736pg.widthPixels);
            this.f3136kI.f3138kK.setMinimumHeight(cnVar.f1736pg.heightPixels);
            m3541b((View) cnVar.f1728nu);
        }
        if (this.f3136kI.f3138kK.getChildCount() > 1) {
            this.f3136kI.f3138kK.showNext();
        }
        if (this.f3136kI.f3145kR != null) {
            View nextView2 = this.f3136kI.f3138kK.getNextView();
            if (nextView2 instanceof C0665dd) {
                ((C0665dd) nextView2).mo4805a(this.f3136kI.f3139kL, this.f3136kI.f3144kQ);
            } else if (nextView2 != null) {
                this.f3136kI.f3138kK.removeView(nextView2);
            }
            if (this.f3136kI.f3145kR.f1722mN != null) {
                try {
                    this.f3136kI.f3145kR.f1722mN.destroy();
                } catch (RemoteException e2) {
                    C0662da.m1555w("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.f3136kI.f3138kK.setVisibility(0);
        return true;
    }

    /* renamed from: c */
    private C0626a m3544c(C1173z zVar) {
        PackageInfo packageInfo;
        Bundle bundle;
        ApplicationInfo applicationInfo = this.f3136kI.f3139kL.getApplicationInfo();
        try {
            packageInfo = this.f3136kI.f3139kL.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (this.f3136kI.f3144kQ.f1195lo || this.f3136kI.f3138kK.getParent() == null) {
            bundle = null;
        } else {
            int[] iArr = new int[2];
            this.f3136kI.f3138kK.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.f3136kI.f3139kL.getResources().getDisplayMetrics();
            int width = this.f3136kI.f3138kK.getWidth();
            int height = this.f3136kI.f3138kK.getHeight();
            int i3 = (!this.f3136kI.f3138kK.isShown() || i + width <= 0 || i2 + height <= 0 || i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) ? 0 : 1;
            bundle = new Bundle(5);
            bundle.putInt("x", i);
            bundle.putInt("y", i2);
            bundle.putInt("width", width);
            bundle.putInt("height", height);
            bundle.putInt("visible", i3);
        }
        String aP = C0644cp.m1487aP();
        this.f3136kI.f3146kS = new C0642co(aP, this.f3136kI.adUnitId);
        this.f3136kI.f3146kS.mo4771f(zVar);
        return new C0626a(bundle, zVar, this.f3136kI.f3144kQ, this.f3136kI.adUnitId, applicationInfo, packageInfo, aP, C0644cp.f1753pu, this.f3136kI.f3141kN, C0644cp.m1483a(this.f3136kI, aP, this.f3136kI.f3139kL));
    }

    /* renamed from: O */
    public void mo6450O() {
        m3539af();
    }

    /* renamed from: P */
    public C0453b mo4502P() {
        C0766er.m1972ac("getAdFrame must be called on the main UI thread.");
        return C0456c.m1001h(this.f3136kI.f3138kK);
    }

    /* renamed from: Q */
    public C0504ab mo4503Q() {
        C0766er.m1972ac("getAdSize must be called on the main UI thread.");
        return this.f3136kI.f3144kQ;
    }

    /* renamed from: R */
    public void mo4685R() {
        m3535ab();
    }

    /* renamed from: S */
    public void mo4666S() {
        if (this.f3136kI.f3144kQ.f1195lo) {
            m3540ag();
        }
        m3534aa();
        this.f3136kI.f3146kS.mo4770aL();
    }

    /* renamed from: T */
    public void mo4667T() {
        if (this.f3136kI.f3144kQ.f1195lo) {
            m3542b(false);
        }
        m3536ac();
    }

    /* renamed from: U */
    public void mo4583U() {
        mo6450O();
    }

    /* renamed from: V */
    public void mo4584V() {
        mo4666S();
    }

    /* renamed from: W */
    public void mo4585W() {
        mo4685R();
    }

    /* renamed from: X */
    public void mo4586X() {
        mo4667T();
    }

    /* renamed from: Y */
    public void mo4587Y() {
        if (this.f3136kI.f3145kR != null) {
            C0662da.m1555w("Mediation adapter " + this.f3136kI.f3145kR.f1723mO + " refreshed, but mediation adapters should never refresh.");
        }
        m3542b(true);
        m3537ad();
    }

    /* renamed from: Z */
    public void mo4504Z() {
        C0766er.m1972ac("recordManualImpression must be called on the main UI thread.");
        if (this.f3136kI.f3145kR == null) {
            C0662da.m1555w("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        C0662da.m1551s("Pinging manual tracking URLs.");
        if (this.f3136kI.f3145kR.f1734om != null) {
            C0653cv.m1504a(this.f3136kI.f3139kL, this.f3136kI.f3141kN.f1798pU, this.f3136kI.f3145kR.f1734om);
        }
    }

    /* renamed from: a */
    public void mo4505a(C0504ab abVar) {
        C0766er.m1972ac("setAdSize must be called on the main UI thread.");
        this.f3136kI.f3144kQ = abVar;
        if (this.f3136kI.f3145kR != null) {
            this.f3136kI.f3145kR.f1728nu.mo4806a(abVar);
        }
        if (this.f3136kI.f3138kK.getChildCount() > 1) {
            this.f3136kI.f3138kK.removeView(this.f3136kI.f3138kK.getNextView());
        }
        this.f3136kI.f3138kK.setMinimumWidth(abVar.widthPixels);
        this.f3136kI.f3138kK.setMinimumHeight(abVar.heightPixels);
        this.f3136kI.f3138kK.requestLayout();
    }

    /* renamed from: a */
    public void mo4506a(C0508af afVar) {
        C0766er.m1972ac("setAdListener must be called on the main UI thread.");
        this.f3136kI.f3142kO = afVar;
    }

    /* renamed from: a */
    public void mo4507a(C0517ai aiVar) {
        C0766er.m1972ac("setAppEventListener must be called on the main UI thread.");
        this.f3136kI.f3147kT = aiVar;
    }

    /* renamed from: a */
    public void mo4693a(C0641cn cnVar) {
        int i;
        int i2 = 0;
        this.f3136kI.f3143kP = null;
        if (!(cnVar.errorCode == -2 || cnVar.errorCode == 3)) {
            C0644cp.m1485a(this.f3136kI);
        }
        if (cnVar.errorCode != -1) {
            boolean z = cnVar.f1729oc.extras != null ? cnVar.f1729oc.extras.getBoolean("_noRefresh", false) : false;
            if (this.f3136kI.f3144kQ.f1195lo) {
                C0653cv.m1506a((WebView) cnVar.f1728nu);
            } else if (!z) {
                if (cnVar.f1727mx > 0) {
                    this.f3137kJ.mo6454a(cnVar.f1729oc, cnVar.f1727mx);
                } else if (cnVar.f1735pf != null && cnVar.f1735pf.f1279mx > 0) {
                    this.f3137kJ.mo6454a(cnVar.f1729oc, cnVar.f1735pf.f1279mx);
                } else if (!cnVar.f1732ok && cnVar.errorCode == 2) {
                    this.f3137kJ.mo6456d(cnVar.f1729oc);
                }
            }
            if (!(cnVar.errorCode != 3 || cnVar.f1735pf == null || cnVar.f1735pf.f1277mv == null)) {
                C0662da.m1551s("Pinging no fill URLs.");
                C0552bd.m1253a(this.f3136kI.f3139kL, this.f3136kI.f3141kN.f1798pU, cnVar, this.f3136kI.adUnitId, false, cnVar.f1735pf.f1277mv);
            }
            if (cnVar.errorCode != -2) {
                m3533a(cnVar.errorCode);
            } else if (this.f3136kI.f3144kQ.f1195lo || m3543b(cnVar)) {
                if (!(this.f3136kI.f3145kR == null || this.f3136kI.f3145kR.f1724mP == null)) {
                    this.f3136kI.f3145kR.f1724mP.mo4590a((C0545az) null);
                }
                if (cnVar.f1724mP != null) {
                    cnVar.f1724mP.mo4590a((C0545az) this);
                }
                this.f3136kI.f3145kR = cnVar;
                if (cnVar.f1736pg != null) {
                    this.f3136kI.f3144kQ = cnVar.f1736pg;
                }
                this.f3136kI.f3146kS.mo4772g(cnVar.f1737ph);
                this.f3136kI.f3146kS.mo4773h(cnVar.f1738pi);
                this.f3136kI.f3146kS.mo4774k(this.f3136kI.f3144kQ.f1195lo);
                this.f3136kI.f3146kS.mo4775l(cnVar.f1732ok);
                if (!this.f3136kI.f3144kQ.f1195lo) {
                    m3542b(false);
                }
                if (this.f3136kI.f3148kU == null) {
                    this.f3136kI.f3148kU = new C0646cr(this.f3136kI.adUnitId);
                }
                if (cnVar.f1735pf != null) {
                    i = cnVar.f1735pf.f1280my;
                    i2 = cnVar.f1735pf.f1281mz;
                } else {
                    i = 0;
                }
                this.f3136kI.f3148kU.mo4785a(i, i2);
                m3537ad();
            } else {
                m3533a(0);
            }
        }
    }

    /* renamed from: a */
    public boolean mo4508a(C1173z zVar) {
        C0665dd a;
        C0665dd ddVar;
        C0766er.m1972ac("loadAd must be called on the main UI thread.");
        if (this.f3136kI.f3143kP != null) {
            C0662da.m1555w("An ad request is already in progress. Aborting.");
            return false;
        } else if (this.f3136kI.f3144kQ.f1195lo && this.f3136kI.f3145kR != null) {
            C0662da.m1555w("An interstitial is already loading. Aborting.");
            return false;
        } else if (!m3538ae()) {
            return false;
        } else {
            C0662da.m1553u("Starting ad request.");
            this.f3137kJ.cancel();
            C0626a c = m3544c(zVar);
            if (this.f3136kI.f3144kQ.f1195lo) {
                C0665dd a2 = C0665dd.m1559a(this.f3136kI.f3139kL, this.f3136kI.f3144kQ, false, false, this.f3136kI.f3140kM, this.f3136kI.f3141kN);
                a2.mo4812bb().mo4825a(this, null, this, this, true);
                ddVar = a2;
            } else {
                View nextView = this.f3136kI.f3138kK.getNextView();
                if (nextView instanceof C0665dd) {
                    a = (C0665dd) nextView;
                    a.mo4805a(this.f3136kI.f3139kL, this.f3136kI.f3144kQ);
                } else {
                    if (nextView != null) {
                        this.f3136kI.f3138kK.removeView(nextView);
                    }
                    a = C0665dd.m1559a(this.f3136kI.f3139kL, this.f3136kI.f3144kQ, false, false, this.f3136kI.f3140kM, this.f3136kI.f3141kN);
                    if (this.f3136kI.f3144kQ.f1196lp == null) {
                        m3541b((View) a);
                    }
                }
                a.mo4812bb().mo4825a(this, this, this, this, false);
                ddVar = a;
            }
            this.f3136kI.f3143kP = C0601by.m1335a(this.f3136kI.f3139kL, c, this.f3136kI.f3140kM, ddVar, this.f3135kH, this);
            return true;
        }
    }

    /* renamed from: b */
    public void mo6451b(C1173z zVar) {
        ViewParent parent = this.f3136kI.f3138kK.getParent();
        if (!(parent instanceof View) || !((View) parent).isShown() || !C0653cv.m1511aS()) {
            C0662da.m1553u("Ad is not visible. Not refreshing ad.");
            this.f3137kJ.mo6456d(zVar);
            return;
        }
        mo4508a(zVar);
    }

    public void destroy() {
        C0766er.m1972ac("destroy must be called on the main UI thread.");
        this.f3136kI.f3142kO = null;
        this.f3136kI.f3147kT = null;
        this.f3137kJ.cancel();
        stopLoading();
        if (this.f3136kI.f3138kK != null) {
            this.f3136kI.f3138kK.removeAllViews();
        }
        if (this.f3136kI.f3145kR != null && this.f3136kI.f3145kR.f1728nu != null) {
            this.f3136kI.f3145kR.f1728nu.destroy();
        }
    }

    public boolean isReady() {
        C0766er.m1972ac("isLoaded must be called on the main UI thread.");
        return this.f3136kI.f3143kP == null && this.f3136kI.f3145kR != null;
    }

    public void onAppEvent(String name, String info) {
        if (this.f3136kI.f3147kT != null) {
            try {
                this.f3136kI.f3147kT.onAppEvent(name, info);
            } catch (RemoteException e) {
                C0662da.m1549b("Could not call the AppEventListener.", e);
            }
        }
    }

    public void pause() {
        C0766er.m1972ac("pause must be called on the main UI thread.");
        if (this.f3136kI.f3145kR != null) {
            C0653cv.m1506a((WebView) this.f3136kI.f3145kR.f1728nu);
        }
    }

    public void resume() {
        C0766er.m1972ac("resume must be called on the main UI thread.");
        if (this.f3136kI.f3145kR != null) {
            C0653cv.m1516b(this.f3136kI.f3145kR.f1728nu);
        }
    }

    public void showInterstitial() {
        C0766er.m1972ac("showInterstitial must be called on the main UI thread.");
        if (!this.f3136kI.f3144kQ.f1195lo) {
            C0662da.m1555w("Cannot call showInterstitial on a banner ad.");
        } else if (this.f3136kI.f3145kR == null) {
            C0662da.m1555w("The interstitial has not loaded.");
        } else if (this.f3136kI.f3145kR.f1728nu.mo4815be()) {
            C0662da.m1555w("The interstitial is already showing.");
        } else {
            this.f3136kI.f3145kR.f1728nu.mo4816n(true);
            if (this.f3136kI.f3145kR.f1732ok) {
                try {
                    this.f3136kI.f3145kR.f1722mN.showInterstitial();
                } catch (RemoteException e) {
                    C0662da.m1549b("Could not show interstitial.", e);
                    m3540ag();
                }
            } else {
                C0581bo.m1289a(this.f3136kI.f3139kL, new C0586bq(this, this, this, this.f3136kI.f3145kR.f1728nu, this.f3136kI.f3145kR.orientation, this.f3136kI.f3141kN));
            }
        }
    }

    public void stopLoading() {
        C0766er.m1972ac("stopLoading must be called on the main UI thread.");
        if (this.f3136kI.f3145kR != null) {
            this.f3136kI.f3145kR.f1728nu.stopLoading();
            this.f3136kI.f3145kR = null;
        }
        if (this.f3136kI.f3143kP != null) {
            this.f3136kI.f3143kP.cancel();
        }
    }
}
