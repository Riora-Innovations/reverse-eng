package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0806fl;

/* renamed from: com.google.android.gms.tagmanager.bf */
class C1398bf implements C1432cg {

    /* renamed from: Ty */
    private final C0806fl f3627Ty;

    /* renamed from: Vz */
    private final long f3628Vz;

    /* renamed from: tP */
    private final long f3629tP;

    /* renamed from: tQ */
    private final int f3630tQ;

    /* renamed from: tR */
    private double f3631tR;

    /* renamed from: tS */
    private long f3632tS;

    /* renamed from: tT */
    private final Object f3633tT = new Object();

    /* renamed from: tU */
    private final String f3634tU;

    public C1398bf(int i, long j, long j2, String str, C0806fl flVar) {
        this.f3630tQ = i;
        this.f3631tR = (double) this.f3630tQ;
        this.f3629tP = j;
        this.f3628Vz = j2;
        this.f3634tU = str;
        this.f3627Ty = flVar;
    }

    /* renamed from: cl */
    public boolean mo7601cl() {
        boolean z = false;
        synchronized (this.f3633tT) {
            long currentTimeMillis = this.f3627Ty.currentTimeMillis();
            if (currentTimeMillis - this.f3632tS < this.f3628Vz) {
                C1401bh.m4078w("Excessive " + this.f3634tU + " detected; call ignored.");
            } else {
                if (this.f3631tR < ((double) this.f3630tQ)) {
                    double d = ((double) (currentTimeMillis - this.f3632tS)) / ((double) this.f3629tP);
                    if (d > 0.0d) {
                        this.f3631tR = Math.min((double) this.f3630tQ, d + this.f3631tR);
                    }
                }
                this.f3632tS = currentTimeMillis;
                if (this.f3631tR >= 1.0d) {
                    this.f3631tR -= 1.0d;
                    z = true;
                } else {
                    C1401bh.m4078w("Excessive " + this.f3634tU + " detected; call ignored.");
                }
            }
        }
        return z;
    }
}
