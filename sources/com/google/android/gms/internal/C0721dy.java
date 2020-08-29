package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.dy */
public final class C0721dy {

    /* renamed from: xE */
    private static final C0715du f1964xE = new C0715du("RequestTracker");

    /* renamed from: yD */
    public static final Object f1965yD = new Object();

    /* renamed from: yA */
    private long f1966yA = -1;

    /* renamed from: yB */
    private long f1967yB = 0;

    /* renamed from: yC */
    private C0720dx f1968yC;

    /* renamed from: yz */
    private long f1969yz;

    public C0721dy(long j) {
        this.f1969yz = j;
    }

    /* renamed from: dk */
    private void m1798dk() {
        this.f1966yA = -1;
        this.f1968yC = null;
        this.f1967yB = 0;
    }

    /* renamed from: a */
    public void mo4980a(long j, C0720dx dxVar) {
        C0720dx dxVar2;
        long j2;
        synchronized (f1965yD) {
            dxVar2 = this.f1968yC;
            j2 = this.f1966yA;
            this.f1966yA = j;
            this.f1968yC = dxVar;
            this.f1967yB = SystemClock.elapsedRealtime();
        }
        if (dxVar2 != null) {
            dxVar2.mo3208k(j2);
        }
    }

    /* renamed from: b */
    public boolean mo4981b(long j, int i, JSONObject jSONObject) {
        boolean z = true;
        C0720dx dxVar = null;
        synchronized (f1965yD) {
            if (this.f1966yA == -1 || this.f1966yA != j) {
                z = false;
            } else {
                f1964xE.mo4961b("request %d completed", Long.valueOf(this.f1966yA));
                dxVar = this.f1968yC;
                m1798dk();
            }
        }
        if (dxVar != null) {
            dxVar.mo3207a(j, i, jSONObject);
        }
        return z;
    }

    /* renamed from: c */
    public boolean mo4982c(long j, int i) {
        return mo4981b(j, i, null);
    }

    public void clear() {
        synchronized (f1965yD) {
            if (this.f1966yA != -1) {
                m1798dk();
            }
        }
    }

    /* renamed from: d */
    public boolean mo4984d(long j, int i) {
        C0720dx dxVar;
        boolean z = true;
        long j2 = 0;
        synchronized (f1965yD) {
            if (this.f1966yA == -1 || j - this.f1967yB < this.f1969yz) {
                z = false;
                dxVar = null;
            } else {
                f1964xE.mo4961b("request %d timed out", Long.valueOf(this.f1966yA));
                j2 = this.f1966yA;
                dxVar = this.f1968yC;
                m1798dk();
            }
        }
        if (dxVar != null) {
            dxVar.mo3207a(j2, i, null);
        }
        return z;
    }

    /* renamed from: dl */
    public boolean mo4985dl() {
        boolean z;
        synchronized (f1965yD) {
            z = this.f1966yA != -1;
        }
        return z;
    }

    /* renamed from: m */
    public boolean mo4986m(long j) {
        boolean z;
        synchronized (f1965yD) {
            z = this.f1966yA != -1 && this.f1966yA == j;
        }
        return z;
    }
}
