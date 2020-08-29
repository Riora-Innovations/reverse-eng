package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.internal.C0550bc.C0551a;

/* renamed from: com.google.android.gms.internal.bb */
public final class C0548bb implements C0551a {

    /* renamed from: kH */
    private final C0554bf f1476kH;

    /* renamed from: kX */
    private final C1173z f1477kX;

    /* renamed from: mC */
    private final String f1478mC;
    private final Context mContext;

    /* renamed from: mD */
    private final long f1479mD;

    /* renamed from: mE */
    private final C0543ax f1480mE;

    /* renamed from: mF */
    private final C0504ab f1481mF;

    /* renamed from: mG */
    private final C0663db f1482mG;
    /* access modifiers changed from: private */

    /* renamed from: mH */
    public C0557bg f1483mH;
    /* access modifiers changed from: private */

    /* renamed from: mI */
    public int f1484mI = -2;
    /* access modifiers changed from: private */

    /* renamed from: mg */
    public final Object f1485mg = new Object();

    public C0548bb(Context context, String str, C0554bf bfVar, C0544ay ayVar, C0543ax axVar, C1173z zVar, C0504ab abVar, C0663db dbVar) {
        this.mContext = context;
        this.f1478mC = str;
        this.f1476kH = bfVar;
        this.f1479mD = ayVar.f1274ms != -1 ? ayVar.f1274ms : 10000;
        this.f1480mE = axVar;
        this.f1477kX = zVar;
        this.f1481mF = abVar;
        this.f1482mG = dbVar;
    }

    /* renamed from: a */
    private void m1241a(long j, long j2, long j3, long j4) {
        while (this.f1484mI == -2) {
            m1246b(j, j2, j3, j4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1242a(C0547ba baVar) {
        try {
            if (this.f1482mG.f1800pW < 4100000) {
                if (this.f1481mF.f1195lo) {
                    this.f1483mH.mo4608a(C0456c.m1001h(this.mContext), this.f1477kX, this.f1480mE.f1272mq, baVar);
                } else {
                    this.f1483mH.mo4606a(C0456c.m1001h(this.mContext), this.f1481mF, this.f1477kX, this.f1480mE.f1272mq, (C0560bh) baVar);
                }
            } else if (this.f1481mF.f1195lo) {
                this.f1483mH.mo4609a(C0456c.m1001h(this.mContext), this.f1477kX, this.f1480mE.f1272mq, this.f1480mE.adJson, (C0560bh) baVar);
            } else {
                this.f1483mH.mo4607a(C0456c.m1001h(this.mContext), this.f1481mF, this.f1477kX, this.f1480mE.f1272mq, this.f1480mE.adJson, baVar);
            }
        } catch (RemoteException e) {
            C0662da.m1549b("Could not request ad from mediation adapter.", e);
            mo4599f(5);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ao */
    public C0557bg m1244ao() {
        C0662da.m1553u("Instantiating mediation adapter: " + this.f1478mC);
        try {
            return this.f1476kH.mo4602m(this.f1478mC);
        } catch (RemoteException e) {
            C0662da.m1548a("Could not instantiate mediation adapter: " + this.f1478mC, e);
            return null;
        }
    }

    /* renamed from: b */
    private void m1246b(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        long j6 = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || j6 <= 0) {
            C0662da.m1553u("Timed out waiting for adapter.");
            this.f1484mI = 3;
            return;
        }
        try {
            this.f1485mg.wait(Math.min(j5, j6));
        } catch (InterruptedException e) {
            this.f1484mI = -1;
        }
    }

    /* renamed from: b */
    public C0550bc mo4597b(long j, long j2) {
        C0550bc bcVar;
        synchronized (this.f1485mg) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final C0547ba baVar = new C0547ba();
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    synchronized (C0548bb.this.f1485mg) {
                        if (C0548bb.this.f1484mI == -2) {
                            C0548bb.this.f1483mH = C0548bb.this.m1244ao();
                            if (C0548bb.this.f1483mH == null) {
                                C0548bb.this.mo4599f(4);
                                return;
                            }
                            baVar.mo4591a((C0551a) C0548bb.this);
                            C0548bb.this.m1242a(baVar);
                        }
                    }
                }
            });
            m1241a(elapsedRealtime, this.f1479mD, j, j2);
            bcVar = new C0550bc(this.f1480mE, this.f1483mH, this.f1478mC, baVar, this.f1484mI);
        }
        return bcVar;
    }

    public void cancel() {
        synchronized (this.f1485mg) {
            try {
                if (this.f1483mH != null) {
                    this.f1483mH.destroy();
                }
            } catch (RemoteException e) {
                C0662da.m1549b("Could not destroy mediation adapter.", e);
            }
            this.f1484mI = -1;
            this.f1485mg.notify();
        }
    }

    /* renamed from: f */
    public void mo4599f(int i) {
        synchronized (this.f1485mg) {
            this.f1484mI = i;
            this.f1485mg.notify();
        }
    }
}
