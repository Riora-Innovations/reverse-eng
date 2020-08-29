package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0608c.C0618j;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.tagmanager.cp */
class C1441cp implements C1515e {
    /* access modifiers changed from: private */

    /* renamed from: TM */
    public final String f3700TM;

    /* renamed from: Ui */
    private String f3701Ui;

    /* renamed from: Wi */
    private C1399bg<C0618j> f3702Wi;

    /* renamed from: Wj */
    private C1519r f3703Wj;

    /* renamed from: Wl */
    private final ScheduledExecutorService f3704Wl;

    /* renamed from: Wm */
    private final C1444a f3705Wm;

    /* renamed from: Wn */
    private ScheduledFuture<?> f3706Wn;
    private boolean mClosed;
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.cp$a */
    interface C1444a {
        /* renamed from: a */
        C1440co mo7679a(C1519r rVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.cp$b */
    interface C1445b {
        /* renamed from: jB */
        ScheduledExecutorService mo7678jB();
    }

    public C1441cp(Context context, String str, C1519r rVar) {
        this(context, str, rVar, null, null);
    }

    C1441cp(Context context, String str, C1519r rVar, C1445b bVar, C1444a aVar) {
        this.f3703Wj = rVar;
        this.mContext = context;
        this.f3700TM = str;
        if (bVar == null) {
            bVar = new C1445b() {
                /* renamed from: jB */
                public ScheduledExecutorService mo7678jB() {
                    return Executors.newSingleThreadScheduledExecutor();
                }
            };
        }
        this.f3704Wl = bVar.mo7678jB();
        if (aVar == null) {
            this.f3705Wm = new C1444a() {
                /* renamed from: a */
                public C1440co mo7679a(C1519r rVar) {
                    return new C1440co(C1441cp.this.mContext, C1441cp.this.f3700TM, rVar);
                }
            };
        } else {
            this.f3705Wm = aVar;
        }
    }

    /* renamed from: bv */
    private C1440co m4201bv(String str) {
        C1440co a = this.f3705Wm.mo7679a(this.f3703Wj);
        a.mo7670a(this.f3702Wi);
        a.mo7671bf(this.f3701Ui);
        a.mo7672bu(str);
        return a;
    }

    /* renamed from: jA */
    private synchronized void m4202jA() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    /* renamed from: a */
    public synchronized void mo7675a(C1399bg<C0618j> bgVar) {
        m4202jA();
        this.f3702Wi = bgVar;
    }

    /* renamed from: bf */
    public synchronized void mo7676bf(String str) {
        m4202jA();
        this.f3701Ui = str;
    }

    /* renamed from: d */
    public synchronized void mo7677d(long j, String str) {
        C1401bh.m4077v("loadAfterDelay: containerId=" + this.f3700TM + " delay=" + j);
        m4202jA();
        if (this.f3702Wi == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.f3706Wn != null) {
            this.f3706Wn.cancel(false);
        }
        this.f3706Wn = this.f3704Wl.schedule(m4201bv(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        m4202jA();
        if (this.f3706Wn != null) {
            this.f3706Wn.cancel(false);
        }
        this.f3704Wl.shutdown();
        this.mClosed = true;
    }
}
