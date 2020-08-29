package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C0233u.C0234a;

/* renamed from: com.google.android.gms.analytics.r */
class C0216r extends C0188af {
    /* access modifiers changed from: private */

    /* renamed from: ri */
    public static final Object f198ri = new Object();

    /* renamed from: ru */
    private static C0216r f199ru;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    /* renamed from: rj */
    private C0200d f200rj;

    /* renamed from: rk */
    private volatile C0202f f201rk;
    /* access modifiers changed from: private */

    /* renamed from: rl */
    public int f202rl = 1800;

    /* renamed from: rm */
    private boolean f203rm = true;

    /* renamed from: rn */
    private boolean f204rn;

    /* renamed from: ro */
    private String f205ro;
    /* access modifiers changed from: private */

    /* renamed from: rp */
    public boolean f206rp = true;

    /* renamed from: rq */
    private boolean f207rq = true;

    /* renamed from: rr */
    private C0201e f208rr = new C0201e() {
        /* renamed from: p */
        public void mo2933p(boolean z) {
            C0216r.this.mo2949a(z, C0216r.this.f206rp);
        }
    };

    /* renamed from: rs */
    private C0215q f209rs;
    /* access modifiers changed from: private */

    /* renamed from: rt */
    public boolean f210rt = false;

    private C0216r() {
    }

    /* renamed from: bB */
    public static C0216r m202bB() {
        if (f199ru == null) {
            f199ru = new C0216r();
        }
        return f199ru;
    }

    /* renamed from: bC */
    private void m203bC() {
        this.f209rs = new C0215q(this);
        this.f209rs.mo2946o(this.mContext);
    }

    /* renamed from: bD */
    private void m204bD() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new Callback() {
            public boolean handleMessage(Message msg) {
                if (1 == msg.what && C0216r.f198ri.equals(msg.obj)) {
                    C0233u.m266bR().mo2972r(true);
                    C0216r.this.dispatchLocalHits();
                    C0233u.m266bR().mo2972r(false);
                    if (C0216r.this.f202rl > 0 && !C0216r.this.f210rt) {
                        C0216r.this.mHandler.sendMessageDelayed(C0216r.this.mHandler.obtainMessage(1, C0216r.f198ri), (long) (C0216r.this.f202rl * 1000));
                    }
                }
                return true;
            }
        });
        if (this.f202rl > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, f198ri), (long) (this.f202rl * 1000));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo2948a(Context context, C0202f fVar) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.f201rk == null) {
                this.f201rk = fVar;
                if (this.f203rm) {
                    dispatchLocalHits();
                    this.f203rm = false;
                }
                if (this.f204rn) {
                    mo2951br();
                    this.f204rn = false;
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo2949a(boolean z, boolean z2) {
        if (!(this.f210rt == z && this.f206rp == z2)) {
            if (z || !z2) {
                if (this.f202rl > 0) {
                    this.mHandler.removeMessages(1, f198ri);
                }
            }
            if (!z && z2 && this.f202rl > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, f198ri), (long) (this.f202rl * 1000));
            }
            C0181aa.m74v("PowerSaveMode " + ((z || !z2) ? "initiated." : "terminated."));
            this.f210rt = z;
            this.f206rp = z2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bE */
    public synchronized C0200d mo2950bE() {
        if (this.f200rj == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.f200rj = new C0183ac(this.f208rr, this.mContext);
            if (this.f205ro != null) {
                this.f200rj.mo2876bq().mo2898A(this.f205ro);
                this.f205ro = null;
            }
        }
        if (this.mHandler == null) {
            m204bD();
        }
        if (this.f209rs == null && this.f207rq) {
            m203bC();
        }
        return this.f200rj;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bF */
    public synchronized void mo2889bF() {
        if (!this.f210rt && this.f206rp && this.f202rl > 0) {
            this.mHandler.removeMessages(1, f198ri);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, f198ri));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: br */
    public void mo2951br() {
        if (this.f201rk == null) {
            C0181aa.m74v("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.f204rn = true;
            return;
        }
        C0233u.m266bR().mo2969a(C0234a.SET_FORCE_LOCAL_DISPATCH);
        this.f201rk.mo2936br();
    }

    /* access modifiers changed from: 0000 */
    public synchronized void dispatchLocalHits() {
        if (this.f201rk == null) {
            C0181aa.m74v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f203rm = true;
        } else {
            C0233u.m266bR().mo2969a(C0234a.DISPATCH);
            this.f201rk.mo2935bp();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public synchronized void mo2891q(boolean z) {
        mo2949a(this.f210rt, z);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            C0181aa.m74v("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.f202rl = dispatchPeriodInSeconds;
        } else {
            C0233u.m266bR().mo2969a(C0234a.SET_DISPATCH_PERIOD);
            if (!this.f210rt && this.f206rp && this.f202rl > 0) {
                this.mHandler.removeMessages(1, f198ri);
            }
            this.f202rl = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.f210rt && this.f206rp) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, f198ri), (long) (dispatchPeriodInSeconds * 1000));
            }
        }
    }
}
