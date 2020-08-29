package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.google.android.gms.tagmanager.cy */
class C1471cy extends C1470cx {

    /* renamed from: Xp */
    private static C1471cy f3783Xp;
    /* access modifiers changed from: private */

    /* renamed from: ri */
    public static final Object f3784ri = new Object();

    /* renamed from: Xf */
    private Context f3785Xf;
    /* access modifiers changed from: private */

    /* renamed from: Xg */
    public C1382at f3786Xg;

    /* renamed from: Xh */
    private volatile C1379ar f3787Xh;
    /* access modifiers changed from: private */

    /* renamed from: Xi */
    public int f3788Xi = 1800000;

    /* renamed from: Xj */
    private boolean f3789Xj = true;

    /* renamed from: Xk */
    private boolean f3790Xk = false;

    /* renamed from: Xl */
    private boolean f3791Xl = true;

    /* renamed from: Xm */
    private C1383au f3792Xm = new C1383au() {
        /* renamed from: p */
        public void mo7593p(boolean z) {
            C1471cy.this.mo7761a(z, C1471cy.this.connected);
        }
    };

    /* renamed from: Xn */
    private C1407bn f3793Xn;
    /* access modifiers changed from: private */

    /* renamed from: Xo */
    public boolean f3794Xo = false;
    /* access modifiers changed from: private */
    public boolean connected = true;
    /* access modifiers changed from: private */
    public Handler handler;

    private C1471cy() {
    }

    /* renamed from: bC */
    private void m4317bC() {
        this.f3793Xn = new C1407bn(this);
        this.f3793Xn.mo7618o(this.f3785Xf);
    }

    /* renamed from: bD */
    private void m4318bD() {
        this.handler = new Handler(this.f3785Xf.getMainLooper(), new Callback() {
            public boolean handleMessage(Message msg) {
                if (1 == msg.what && C1471cy.f3784ri.equals(msg.obj)) {
                    C1471cy.this.mo7762bp();
                    if (C1471cy.this.f3788Xi > 0 && !C1471cy.this.f3794Xo) {
                        C1471cy.this.handler.sendMessageDelayed(C1471cy.this.handler.obtainMessage(1, C1471cy.f3784ri), (long) C1471cy.this.f3788Xi);
                    }
                }
                return true;
            }
        });
        if (this.f3788Xi > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, f3784ri), (long) this.f3788Xi);
        }
    }

    /* renamed from: kh */
    public static C1471cy m4323kh() {
        if (f3783Xp == null) {
            f3783Xp = new C1471cy();
        }
        return f3783Xp;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo7760a(Context context, C1379ar arVar) {
        if (this.f3785Xf == null) {
            this.f3785Xf = context.getApplicationContext();
            if (this.f3787Xh == null) {
                this.f3787Xh = arVar;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public synchronized void mo7761a(boolean z, boolean z2) {
        if (!(this.f3794Xo == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.f3788Xi > 0) {
                    this.handler.removeMessages(1, f3784ri);
                }
            }
            if (!z && z2 && this.f3788Xi > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, f3784ri), (long) this.f3788Xi);
            }
            C1401bh.m4077v("PowerSaveMode " + ((z || !z2) ? "initiated." : "terminated."));
            this.f3794Xo = z;
            this.connected = z2;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bF */
    public synchronized void mo7758bF() {
        if (!this.f3794Xo && this.connected && this.f3788Xi > 0) {
            this.handler.removeMessages(1, f3784ri);
            this.handler.sendMessage(this.handler.obtainMessage(1, f3784ri));
        }
    }

    /* renamed from: bp */
    public synchronized void mo7762bp() {
        if (!this.f3790Xk) {
            C1401bh.m4077v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f3789Xj = true;
        } else {
            this.f3787Xh.mo7586a(new Runnable() {
                public void run() {
                    C1471cy.this.f3786Xg.mo7591bp();
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ki */
    public synchronized C1382at mo7763ki() {
        if (this.f3786Xg == null) {
            if (this.f3785Xf == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.f3786Xg = new C1424cb(this.f3792Xm, this.f3785Xf);
        }
        if (this.handler == null) {
            m4318bD();
        }
        this.f3790Xk = true;
        if (this.f3789Xj) {
            mo7762bp();
            this.f3789Xj = false;
        }
        if (this.f3793Xn == null && this.f3791Xl) {
            m4317bC();
        }
        return this.f3786Xg;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: q */
    public synchronized void mo7759q(boolean z) {
        mo7761a(this.f3794Xo, z);
    }
}
