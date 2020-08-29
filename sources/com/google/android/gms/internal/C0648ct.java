package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.ct */
public abstract class C0648ct {

    /* renamed from: kW */
    private final Runnable f1771kW = new Runnable() {
        public final void run() {
            C0648ct.this.f1772pI = Thread.currentThread();
            C0648ct.this.mo4695aB();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: pI */
    public volatile Thread f1772pI;

    /* renamed from: aB */
    public abstract void mo4695aB();

    public final void cancel() {
        onStop();
        if (this.f1772pI != null) {
            this.f1772pI.interrupt();
        }
    }

    public abstract void onStop();

    public final void start() {
        C0650cu.execute(this.f1771kW);
    }
}
