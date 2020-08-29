package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.C0295a;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0766er;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.tagmanager.ca */
abstract class C1422ca<R extends Result> implements PendingResult<R> {

    /* renamed from: VK */
    private C1423a<R> f3650VK;

    /* renamed from: zd */
    private final Object f3651zd = new Object();

    /* renamed from: zf */
    private final CountDownLatch f3652zf = new CountDownLatch(1);

    /* renamed from: zg */
    private final ArrayList<C0295a> f3653zg = new ArrayList<>();

    /* renamed from: zh */
    private ResultCallback<R> f3654zh;

    /* renamed from: zi */
    private volatile R f3655zi;

    /* renamed from: zj */
    private volatile boolean f3656zj;

    /* renamed from: com.google.android.gms.tagmanager.ca$a */
    public static class C1423a<R extends Result> extends Handler {
        public C1423a() {
            this(Looper.getMainLooper());
        }

        public C1423a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void mo7647a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* renamed from: a */
        public void mo7648a(C1422ca<R> caVar, long j) {
            sendMessageDelayed(obtainMessage(2, caVar), j);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo7649b(ResultCallback<R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        /* renamed from: dw */
        public void mo7650dw() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    mo7649b((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    C1422ca caVar = (C1422ca) msg.obj;
                    caVar.mo7643a(caVar.mo7644d(Status.f520zS));
                    return;
                default:
                    C1401bh.m4075t("Don't know how to handle this message.");
                    return;
            }
        }
    }

    public C1422ca(Looper looper) {
        this.f3650VK = new C1423a<>(looper);
    }

    /* renamed from: ds */
    private R m4131ds() {
        R r;
        synchronized (this.f3651zd) {
            C0766er.m1970a(!this.f3656zj, "Result has already been consumed.");
            C0766er.m1970a(isReady(), "Result is not ready.");
            r = this.f3655zi;
            mo7645dt();
        }
        return r;
    }

    /* renamed from: a */
    public final void mo7643a(R r) {
        synchronized (this.f3651zd) {
            if (!isReady()) {
                C0766er.m1970a(!this.f3656zj, "Result has already been consumed");
                this.f3655zi = r;
                this.f3652zf.countDown();
                Status status = this.f3655zi.getStatus();
                if (this.f3654zh != null) {
                    this.f3650VK.mo7650dw();
                    this.f3650VK.mo7647a(this.f3654zh, m4131ds());
                }
                Iterator it = this.f3653zg.iterator();
                while (it.hasNext()) {
                    ((C0295a) it.next()).mo3289k(status);
                }
                this.f3653zg.clear();
            }
        }
    }

    public R await() {
        C0766er.m1970a(!this.f3656zj, "Results has already been consumed");
        try {
            this.f3652zf.await();
        } catch (InterruptedException e) {
            mo7643a(mo7644d(Status.f519zR));
        }
        C0766er.m1970a(isReady(), "Result is not ready.");
        return m4131ds();
    }

    public R await(long time, TimeUnit units) {
        C0766er.m1970a(!this.f3656zj, "Result has already been consumed.");
        try {
            if (!this.f3652zf.await(time, units)) {
                mo7643a(mo7644d(Status.f520zS));
            }
        } catch (InterruptedException e) {
            mo7643a(mo7644d(Status.f519zR));
        }
        C0766er.m1970a(isReady(), "Result is not ready.");
        return m4131ds();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract R mo7644d(Status status);

    /* access modifiers changed from: 0000 */
    /* renamed from: dt */
    public void mo7645dt() {
        this.f3656zj = true;
        this.f3655zi = null;
    }

    public boolean isReady() {
        return this.f3652zf.getCount() == 0;
    }

    public final void setResultCallback(ResultCallback<R> callback) {
        C0766er.m1970a(!this.f3656zj, "Result has already been consumed.");
        synchronized (this.f3651zd) {
            if (isReady()) {
                this.f3650VK.mo7647a(callback, m4131ds());
            } else {
                this.f3654zh = callback;
            }
        }
    }

    public final void setResultCallback(ResultCallback<R> callback, long time, TimeUnit units) {
        C0766er.m1970a(!this.f3656zj, "Result has already been consumed.");
        synchronized (this.f3651zd) {
            if (isReady()) {
                this.f3650VK.mo7647a(callback, m4131ds());
            } else {
                this.f3654zh = callback;
                this.f3650VK.mo7648a(this, units.toMillis(time));
            }
        }
    }
}
