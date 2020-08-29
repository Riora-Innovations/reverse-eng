package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.gms.internal.C0601by.C0602a;
import com.google.android.gms.internal.C0619ca.C0620a;
import com.google.android.gms.internal.C0625cd.C0626a;
import com.google.android.gms.internal.C0667de.C0669a;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.bz */
public final class C0603bz extends C0648ct implements C0620a, C0669a {

    /* renamed from: kH */
    private final C0554bf f1562kH;
    private final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: mg */
    public final Object f1563mg = new Object();

    /* renamed from: mh */
    private C0544ay f1564mh;
    /* access modifiers changed from: private */

    /* renamed from: nM */
    public final C0602a f1565nM;

    /* renamed from: nN */
    private final Object f1566nN = new Object();

    /* renamed from: nO */
    private final C0626a f1567nO;

    /* renamed from: nP */
    private final C1152l f1568nP;

    /* renamed from: nQ */
    private C0648ct f1569nQ;
    /* access modifiers changed from: private */

    /* renamed from: nR */
    public C0628cf f1570nR;

    /* renamed from: nS */
    private boolean f1571nS = false;

    /* renamed from: nT */
    private C0541aw f1572nT;

    /* renamed from: nU */
    private C0550bc f1573nU;
    /* access modifiers changed from: private */

    /* renamed from: ng */
    public final C0665dd f1574ng;

    /* renamed from: com.google.android.gms.internal.bz$a */
    private static final class C0607a extends Exception {

        /* renamed from: nX */
        private final int f1579nX;

        public C0607a(String str, int i) {
            super(str);
            this.f1579nX = i;
        }

        public int getErrorCode() {
            return this.f1579nX;
        }
    }

    public C0603bz(Context context, C0626a aVar, C1152l lVar, C0665dd ddVar, C0554bf bfVar, C0602a aVar2) {
        this.f1562kH = bfVar;
        this.f1565nM = aVar2;
        this.f1574ng = ddVar;
        this.mContext = context;
        this.f1567nO = aVar;
        this.f1568nP = lVar;
    }

    /* renamed from: a */
    private C0504ab m1337a(C0625cd cdVar) throws C0607a {
        if (this.f1570nR.f1672on == null) {
            throw new C0607a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.f1570nR.f1672on.split("x");
        if (split.length != 2) {
            throw new C0607a("Could not parse the ad size from the ad response: " + this.f1570nR.f1672on, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            C0504ab[] abVarArr = cdVar.f1647kQ.f1196lp;
            int length = abVarArr.length;
            for (int i = 0; i < length; i++) {
                C0504ab abVar = abVarArr[i];
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i2 = abVar.width == -1 ? (int) (((float) abVar.widthPixels) / f) : abVar.width;
                int i3 = abVar.height == -2 ? (int) (((float) abVar.heightPixels) / f) : abVar.height;
                if (parseInt == i2 && parseInt2 == i3) {
                    return new C0504ab(abVar, cdVar.f1647kQ.f1196lp);
                }
            }
            throw new C0607a("The ad size from the ad response was not one of the requested sizes: " + this.f1570nR.f1672on, 0);
        } catch (NumberFormatException e) {
            throw new C0607a("Could not parse the ad size from the ad response: " + this.f1570nR.f1672on, 0);
        }
    }

    /* renamed from: a */
    private void m1339a(C0625cd cdVar, long j) throws C0607a {
        synchronized (this.f1566nN) {
            this.f1572nT = new C0541aw(this.mContext, cdVar, this.f1562kH, this.f1564mh);
        }
        this.f1573nU = this.f1572nT.mo4580a(j, 60000);
        switch (this.f1573nU.f1488mL) {
            case 0:
                return;
            case 1:
                throw new C0607a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0607a("Unexpected mediation result: " + this.f1573nU.f1488mL, 0);
        }
    }

    /* renamed from: aC */
    private void m1340aC() throws C0607a {
        if (this.f1570nR.errorCode != -3) {
            if (TextUtils.isEmpty(this.f1570nR.f1667oi)) {
                throw new C0607a("No fill from ad server.", 3);
            } else if (this.f1570nR.f1669ok) {
                try {
                    this.f1564mh = new C0544ay(this.f1570nR.f1667oi);
                } catch (JSONException e) {
                    throw new C0607a("Could not parse mediation config: " + this.f1570nR.f1667oi, 0);
                }
            }
        }
    }

    /* renamed from: b */
    private void m1342b(long j) throws C0607a {
        C0659cz.f1785pT.post(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
                return;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    com.google.android.gms.internal.bz r0 = com.google.android.gms.internal.C0603bz.this
                    java.lang.Object r6 = r0.f1563mg
                    monitor-enter(r6)
                    com.google.android.gms.internal.bz r0 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cf r0 = r0.f1570nR     // Catch:{ all -> 0x005f }
                    int r0 = r0.errorCode     // Catch:{ all -> 0x005f }
                    r1 = -2
                    if (r0 == r1) goto L_0x0014
                    monitor-exit(r6)     // Catch:{ all -> 0x005f }
                L_0x0013:
                    return
                L_0x0014:
                    com.google.android.gms.internal.bz r0 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.dd r0 = r0.f1574ng     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.de r0 = r0.mo4812bb()     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bz r1 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    r0.mo4824a(r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bz r0 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cf r0 = r0.f1570nR     // Catch:{ all -> 0x005f }
                    int r0 = r0.errorCode     // Catch:{ all -> 0x005f }
                    r1 = -3
                    if (r0 != r1) goto L_0x0062
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
                    r0.<init>()     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = "Loading URL in WebView: "
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bz r1 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cf r1 = r1.f1570nR     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f1666nw     // Catch:{ all -> 0x005f }
                    java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x005f }
                    java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.C0662da.m1554v(r0)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bz r0 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.dd r0 = r0.f1574ng     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bz r1 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cf r1 = r1.f1570nR     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f1666nw     // Catch:{ all -> 0x005f }
                    r0.loadUrl(r1)     // Catch:{ all -> 0x005f }
                L_0x005d:
                    monitor-exit(r6)     // Catch:{ all -> 0x005f }
                    goto L_0x0013
                L_0x005f:
                    r0 = move-exception
                    monitor-exit(r6)     // Catch:{ all -> 0x005f }
                    throw r0
                L_0x0062:
                    java.lang.String r0 = "Loading HTML in WebView."
                    com.google.android.gms.internal.C0662da.m1554v(r0)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bz r0 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.dd r0 = r0.f1574ng     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bz r1 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cf r1 = r1.f1570nR     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = r1.f1666nw     // Catch:{ all -> 0x005f }
                    java.lang.String r1 = com.google.android.gms.internal.C0653cv.m1523p(r1)     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.bz r2 = com.google.android.gms.internal.C0603bz.this     // Catch:{ all -> 0x005f }
                    com.google.android.gms.internal.cf r2 = r2.f1570nR     // Catch:{ all -> 0x005f }
                    java.lang.String r2 = r2.f1667oi     // Catch:{ all -> 0x005f }
                    java.lang.String r3 = "text/html"
                    java.lang.String r4 = "UTF-8"
                    r5 = 0
                    r0.loadDataWithBaseURL(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x005f }
                    goto L_0x005d
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0603bz.C06063.run():void");
            }
        });
        m1346d(j);
    }

    /* renamed from: c */
    private void m1344c(long j) throws C0607a {
        while (m1347e(j)) {
            if (this.f1570nR != null) {
                synchronized (this.f1566nN) {
                    this.f1569nQ = null;
                }
                if (this.f1570nR.errorCode != -2 && this.f1570nR.errorCode != -3) {
                    throw new C0607a("There was a problem getting an ad response. ErrorCode: " + this.f1570nR.errorCode, this.f1570nR.errorCode);
                }
                return;
            }
        }
        throw new C0607a("Timed out waiting for ad response.", 2);
    }

    /* renamed from: d */
    private void m1346d(long j) throws C0607a {
        while (m1347e(j)) {
            if (this.f1571nS) {
                return;
            }
        }
        throw new C0607a("Timed out waiting for WebView to finish loading.", 2);
    }

    /* renamed from: e */
    private boolean m1347e(long j) throws C0607a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f1563mg.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0607a("Ad request cancelled.", -1);
        }
    }

    /* renamed from: a */
    public void mo4694a(C0628cf cfVar) {
        synchronized (this.f1563mg) {
            C0662da.m1551s("Received ad response.");
            this.f1570nR = cfVar;
            this.f1563mg.notify();
        }
    }

    /* renamed from: a */
    public void mo4654a(C0665dd ddVar) {
        synchronized (this.f1563mg) {
            C0662da.m1551s("WebView finished loading.");
            this.f1571nS = true;
            this.f1563mg.notify();
        }
    }

    /* renamed from: aB */
    public void mo4695aB() {
        long j;
        C0504ab abVar;
        synchronized (this.f1563mg) {
            C0662da.m1551s("AdLoaderBackgroundTask started.");
            C0625cd cdVar = new C0625cd(this.f1567nO, this.f1568nP.mo6433y().mo5631a(this.mContext));
            C0504ab abVar2 = null;
            int i = -2;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                C0648ct a = C0619ca.m1408a(this.mContext, cdVar, this);
                synchronized (this.f1566nN) {
                    this.f1569nQ = a;
                    if (this.f1569nQ == null) {
                        throw new C0607a("Could not start the ad request service.", 0);
                    }
                }
                m1344c(elapsedRealtime);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                m1340aC();
                if (cdVar.f1647kQ.f1196lp != null) {
                    abVar2 = m1337a(cdVar);
                }
                if (this.f1570nR.f1669ok) {
                    m1339a(cdVar, elapsedRealtime);
                } else {
                    m1342b(elapsedRealtime);
                }
                j = elapsedRealtime2;
                abVar = abVar2;
            } catch (C0607a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    C0662da.m1553u(e.getMessage());
                } else {
                    C0662da.m1555w(e.getMessage());
                }
                this.f1570nR = new C0628cf(i);
                C0659cz.f1785pT.post(new Runnable() {
                    public void run() {
                        C0603bz.this.onStop();
                    }
                });
                j = -1;
                abVar = null;
            }
            final C0641cn cnVar = new C0641cn(cdVar.f1649oc, this.f1574ng, this.f1570nR.f1663mt, i, this.f1570nR.f1664mu, this.f1570nR.f1671om, this.f1570nR.orientation, this.f1570nR.f1665mx, cdVar.f1652of, this.f1570nR.f1669ok, this.f1573nU != null ? this.f1573nU.f1489mM : null, this.f1573nU != null ? this.f1573nU.f1490mN : null, this.f1573nU != null ? this.f1573nU.f1491mO : null, this.f1564mh, this.f1573nU != null ? this.f1573nU.f1492mP : null, this.f1570nR.f1670ol, abVar, this.f1570nR.f1668oj, j, this.f1570nR.f1673oo);
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    synchronized (C0603bz.this.f1563mg) {
                        C0603bz.this.f1565nM.mo4693a(cnVar);
                    }
                }
            });
        }
    }

    public void onStop() {
        synchronized (this.f1566nN) {
            if (this.f1569nQ != null) {
                this.f1569nQ.cancel();
            }
            this.f1574ng.stopLoading();
            C0653cv.m1506a((WebView) this.f1574ng);
            if (this.f1572nT != null) {
                this.f1572nT.cancel();
            }
        }
    }
}
