package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.w */
public final class C1169w {

    /* renamed from: kW */
    private final Runnable f3150kW;
    /* access modifiers changed from: private */

    /* renamed from: kX */
    public C1173z f3151kX;
    /* access modifiers changed from: private */

    /* renamed from: kY */
    public boolean f3152kY = false;

    public C1169w(final C1167v vVar) {
        this.f3150kW = new Runnable() {

            /* renamed from: kZ */
            private final WeakReference<C1167v> f3153kZ = new WeakReference<>(vVar);

            public void run() {
                C1169w.this.f3152kY = false;
                C1167v vVar = (C1167v) this.f3153kZ.get();
                if (vVar != null) {
                    vVar.mo6451b(C1169w.this.f3151kX);
                }
            }
        };
    }

    /* renamed from: a */
    public void mo6454a(C1173z zVar, long j) {
        if (this.f3152kY) {
            C0662da.m1555w("An ad refresh is already scheduled.");
            return;
        }
        C0662da.m1553u("Scheduling ad refresh " + j + " milliseconds from now.");
        this.f3151kX = zVar;
        this.f3152kY = true;
        C0659cz.f1785pT.postDelayed(this.f3150kW, j);
    }

    public void cancel() {
        C0659cz.f1785pT.removeCallbacks(this.f3150kW);
    }

    /* renamed from: d */
    public void mo6456d(C1173z zVar) {
        mo6454a(zVar, 60000);
    }
}
