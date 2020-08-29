package com.google.android.gms.analytics;

/* renamed from: com.google.android.gms.analytics.z */
class C0240z implements C0186ad {

    /* renamed from: tP */
    private final long f339tP;

    /* renamed from: tQ */
    private final int f340tQ;

    /* renamed from: tR */
    private double f341tR;

    /* renamed from: tS */
    private long f342tS;

    /* renamed from: tT */
    private final Object f343tT;

    /* renamed from: tU */
    private final String f344tU;

    public C0240z(int i, long j, String str) {
        this.f343tT = new Object();
        this.f340tQ = i;
        this.f341tR = (double) this.f340tQ;
        this.f339tP = j;
        this.f344tU = str;
    }

    public C0240z(String str) {
        this(60, 2000, str);
    }

    /* renamed from: cl */
    public boolean mo2886cl() {
        boolean z;
        synchronized (this.f343tT) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f341tR < ((double) this.f340tQ)) {
                double d = ((double) (currentTimeMillis - this.f342tS)) / ((double) this.f339tP);
                if (d > 0.0d) {
                    this.f341tR = Math.min((double) this.f340tQ, d + this.f341tR);
                }
            }
            this.f342tS = currentTimeMillis;
            if (this.f341tR >= 1.0d) {
                this.f341tR -= 1.0d;
                z = true;
            } else {
                C0181aa.m75w("Excessive " + this.f344tU + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
