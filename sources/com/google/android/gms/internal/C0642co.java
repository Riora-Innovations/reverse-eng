package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.android.gms.internal.co */
public class C0642co {

    /* renamed from: mg */
    private final Object f1739mg = new Object();

    /* renamed from: oI */
    private boolean f1740oI = false;

    /* renamed from: pj */
    private final LinkedList<C0643a> f1741pj;

    /* renamed from: pk */
    private final String f1742pk;

    /* renamed from: pl */
    private final String f1743pl;

    /* renamed from: pm */
    private long f1744pm = -1;

    /* renamed from: pn */
    private long f1745pn = -1;

    /* renamed from: po */
    private long f1746po = -1;

    /* renamed from: pp */
    private long f1747pp = 0;

    /* renamed from: pq */
    private long f1748pq = -1;

    /* renamed from: pr */
    private long f1749pr = -1;

    /* renamed from: com.google.android.gms.internal.co$a */
    private static final class C0643a {

        /* renamed from: ps */
        private long f1750ps = -1;

        /* renamed from: pt */
        private long f1751pt = -1;

        /* renamed from: aM */
        public long mo4777aM() {
            return this.f1751pt;
        }

        /* renamed from: aN */
        public void mo4778aN() {
            this.f1751pt = SystemClock.elapsedRealtime();
        }

        /* renamed from: aO */
        public void mo4779aO() {
            this.f1750ps = SystemClock.elapsedRealtime();
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.f1750ps);
            bundle.putLong("tclose", this.f1751pt);
            return bundle;
        }
    }

    public C0642co(String str, String str2) {
        this.f1742pk = str;
        this.f1743pl = str2;
        this.f1741pj = new LinkedList<>();
    }

    /* renamed from: aJ */
    public void mo4768aJ() {
        synchronized (this.f1739mg) {
            if (!(this.f1749pr == -1 || this.f1745pn == -1)) {
                this.f1745pn = SystemClock.elapsedRealtime();
                C0644cp.m1488aQ().mo4781aJ();
                C0644cp.m1484a(this);
            }
        }
    }

    /* renamed from: aK */
    public void mo4769aK() {
        synchronized (this.f1739mg) {
            if (this.f1749pr != -1) {
                C0643a aVar = new C0643a();
                aVar.mo4779aO();
                this.f1741pj.add(aVar);
                this.f1747pp++;
                C0644cp.m1488aQ().mo4782aK();
                C0644cp.m1484a(this);
            }
        }
    }

    /* renamed from: aL */
    public void mo4770aL() {
        synchronized (this.f1739mg) {
            if (this.f1749pr != -1 && !this.f1741pj.isEmpty()) {
                C0643a aVar = (C0643a) this.f1741pj.getLast();
                if (aVar.mo4777aM() == -1) {
                    aVar.mo4778aN();
                    C0644cp.m1484a(this);
                }
            }
        }
    }

    /* renamed from: f */
    public void mo4771f(C1173z zVar) {
        synchronized (this.f1739mg) {
            this.f1748pq = SystemClock.elapsedRealtime();
            C0644cp.m1488aQ().mo4784b(zVar, this.f1748pq);
        }
    }

    /* renamed from: g */
    public void mo4772g(long j) {
        synchronized (this.f1739mg) {
            this.f1749pr = j;
            if (this.f1749pr != -1) {
                C0644cp.m1484a(this);
            }
        }
    }

    /* renamed from: h */
    public void mo4773h(long j) {
        synchronized (this.f1739mg) {
            if (this.f1749pr != -1) {
                this.f1744pm = j;
                C0644cp.m1484a(this);
            }
        }
    }

    /* renamed from: k */
    public void mo4774k(boolean z) {
        synchronized (this.f1739mg) {
            if (this.f1749pr != -1) {
                this.f1746po = SystemClock.elapsedRealtime();
                if (!z) {
                    this.f1745pn = this.f1746po;
                    C0644cp.m1484a(this);
                }
            }
        }
    }

    /* renamed from: l */
    public void mo4775l(boolean z) {
        synchronized (this.f1739mg) {
            if (this.f1749pr != -1) {
                this.f1740oI = z;
                C0644cp.m1484a(this);
            }
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.f1739mg) {
            bundle = new Bundle();
            bundle.putString("seqnum", this.f1742pk);
            bundle.putString("slotid", this.f1743pl);
            bundle.putBoolean("ismediation", this.f1740oI);
            bundle.putLong("treq", this.f1748pq);
            bundle.putLong("tresponse", this.f1749pr);
            bundle.putLong("timp", this.f1745pn);
            bundle.putLong("tload", this.f1746po);
            bundle.putLong("pcc", this.f1747pp);
            bundle.putLong("tfetch", this.f1744pm);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f1741pj.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0643a) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
