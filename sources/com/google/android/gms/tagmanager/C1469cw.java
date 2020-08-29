package com.google.android.gms.tagmanager;

/* renamed from: com.google.android.gms.tagmanager.cw */
class C1469cw implements C1432cg {

    /* renamed from: Xe */
    private long f3778Xe;

    /* renamed from: tP */
    private final long f3779tP;

    /* renamed from: tQ */
    private final int f3780tQ;

    /* renamed from: tR */
    private double f3781tR;

    /* renamed from: tT */
    private final Object f3782tT;

    public C1469cw() {
        this(60, 2000);
    }

    public C1469cw(int i, long j) {
        this.f3782tT = new Object();
        this.f3780tQ = i;
        this.f3781tR = (double) this.f3780tQ;
        this.f3779tP = j;
    }

    /* renamed from: cl */
    public boolean mo7601cl() {
        boolean z;
        synchronized (this.f3782tT) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f3781tR < ((double) this.f3780tQ)) {
                double d = ((double) (currentTimeMillis - this.f3778Xe)) / ((double) this.f3779tP);
                if (d > 0.0d) {
                    this.f3781tR = Math.min((double) this.f3780tQ, d + this.f3781tR);
                }
            }
            this.f3778Xe = currentTimeMillis;
            if (this.f3781tR >= 1.0d) {
                this.f3781tR -= 1.0d;
                z = true;
            } else {
                C1401bh.m4078w("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
