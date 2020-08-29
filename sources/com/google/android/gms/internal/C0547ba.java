package com.google.android.gms.internal;

import com.google.android.gms.internal.C0550bc.C0551a;
import com.google.android.gms.internal.C0560bh.C0561a;

/* renamed from: com.google.android.gms.internal.ba */
public final class C0547ba extends C0561a {

    /* renamed from: mA */
    private C0551a f1473mA;

    /* renamed from: mB */
    private C0545az f1474mB;

    /* renamed from: mg */
    private final Object f1475mg = new Object();

    /* renamed from: O */
    public void mo4589O() {
        synchronized (this.f1475mg) {
            if (this.f1474mB != null) {
                this.f1474mB.mo4583U();
            }
        }
    }

    /* renamed from: a */
    public void mo4590a(C0545az azVar) {
        synchronized (this.f1475mg) {
            this.f1474mB = azVar;
        }
    }

    /* renamed from: a */
    public void mo4591a(C0551a aVar) {
        synchronized (this.f1475mg) {
            this.f1473mA = aVar;
        }
    }

    public void onAdClosed() {
        synchronized (this.f1475mg) {
            if (this.f1474mB != null) {
                this.f1474mB.mo4584V();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.f1475mg) {
            if (this.f1473mA != null) {
                this.f1473mA.mo4599f(error == 3 ? 1 : 2);
                this.f1473mA = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.f1475mg) {
            if (this.f1474mB != null) {
                this.f1474mB.mo4585W();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
            r3 = this;
            java.lang.Object r1 = r3.f1475mg
            monitor-enter(r1)
            com.google.android.gms.internal.bc$a r0 = r3.f1473mA     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.bc$a r0 = r3.f1473mA     // Catch:{ all -> 0x001d }
            r2 = 0
            r0.mo4599f(r2)     // Catch:{ all -> 0x001d }
            r0 = 0
            r3.f1473mA = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x0011:
            return
        L_0x0012:
            com.google.android.gms.internal.az r0 = r3.f1474mB     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.az r0 = r3.f1474mB     // Catch:{ all -> 0x001d }
            r0.mo4587Y()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x0011
        L_0x001d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0547ba.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.f1475mg) {
            if (this.f1474mB != null) {
                this.f1474mB.mo4586X();
            }
        }
    }
}
