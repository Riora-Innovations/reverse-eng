package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api.C0293a;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.PendingResult.C0295a;
import com.google.android.gms.internal.C0766er;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.common.api.a */
public class C0296a {

    /* renamed from: com.google.android.gms.common.api.a$a */
    public static abstract class C0297a<R extends Result, A extends C0293a> implements PendingResult<R>, C0299c<R>, C0307c<A> {

        /* renamed from: zc */
        private final C0294b<A> f524zc;

        /* renamed from: zd */
        private final Object f525zd;

        /* renamed from: ze */
        private C0298b<R> f526ze;

        /* renamed from: zf */
        private final CountDownLatch f527zf;

        /* renamed from: zg */
        private final ArrayList<C0295a> f528zg;

        /* renamed from: zh */
        private ResultCallback<R> f529zh;

        /* renamed from: zi */
        private volatile R f530zi;

        /* renamed from: zj */
        private volatile boolean f531zj;

        /* renamed from: zk */
        private boolean f532zk;

        /* renamed from: zl */
        private boolean f533zl;

        /* renamed from: zm */
        private C0305a f534zm;

        protected C0297a() {
            this(null);
        }

        protected C0297a(C0294b<A> bVar) {
            this.f525zd = new Object();
            this.f527zf = new CountDownLatch(1);
            this.f528zg = new ArrayList<>();
            this.f524zc = bVar;
        }

        /* renamed from: a */
        private void m450a(RemoteException remoteException) {
            mo3311b((R) mo3009d(new Status(8, remoteException.getLocalizedMessage(), null)));
        }

        /* renamed from: ds */
        private R m451ds() {
            R r;
            synchronized (this.f525zd) {
                C0766er.m1970a(!this.f531zj, "Result has already been consumed.");
                C0766er.m1970a(isReady(), "Result is not ready.");
                r = this.f530zi;
                mo3314dt();
            }
            return r;
        }

        /* renamed from: dv */
        private void m452dv() {
            if (this.f530zi != null && (this instanceof Releasable)) {
                try {
                    ((Releasable) this).release();
                } catch (Exception e) {
                    Log.w("GoogleApi", "Unable to release " + this, e);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo3004a(A a) throws RemoteException;

        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void mo3311b(R r6) {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
                java.lang.Object r3 = r5.f525zd
                monitor-enter(r3)
                boolean r2 = r5.f533zl     // Catch:{ all -> 0x0034 }
                if (r2 == 0) goto L_0x0014
                boolean r0 = r6 instanceof com.google.android.gms.common.api.Releasable     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0012
                com.google.android.gms.common.api.Releasable r6 = (com.google.android.gms.common.api.Releasable) r6     // Catch:{ all -> 0x0034 }
                r6.release()     // Catch:{ all -> 0x0034 }
            L_0x0012:
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            L_0x0013:
                return
            L_0x0014:
                boolean r2 = r5.isReady()     // Catch:{ all -> 0x0034 }
                if (r2 != 0) goto L_0x0037
                r2 = r0
            L_0x001b:
                java.lang.String r4 = "Results have already been set"
                com.google.android.gms.internal.C0766er.m1970a(r2, r4)     // Catch:{ all -> 0x0034 }
                boolean r2 = r5.f531zj     // Catch:{ all -> 0x0034 }
                if (r2 != 0) goto L_0x0039
            L_0x0024:
                java.lang.String r1 = "Result has already been consumed"
                com.google.android.gms.internal.C0766er.m1970a(r0, r1)     // Catch:{ all -> 0x0034 }
                r5.f530zi = r6     // Catch:{ all -> 0x0034 }
                boolean r0 = r5.f532zk     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x003b
                r5.m452dv()     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                goto L_0x0013
            L_0x0034:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                throw r0
            L_0x0037:
                r2 = r1
                goto L_0x001b
            L_0x0039:
                r0 = r1
                goto L_0x0024
            L_0x003b:
                java.util.concurrent.CountDownLatch r0 = r5.f527zf     // Catch:{ all -> 0x0034 }
                r0.countDown()     // Catch:{ all -> 0x0034 }
                R r0 = r5.f530zi     // Catch:{ all -> 0x0034 }
                com.google.android.gms.common.api.Status r1 = r0.getStatus()     // Catch:{ all -> 0x0034 }
                com.google.android.gms.common.api.ResultCallback<R> r0 = r5.f529zh     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x005a
                com.google.android.gms.common.api.a$b<R> r0 = r5.f526ze     // Catch:{ all -> 0x0034 }
                r0.mo3320dw()     // Catch:{ all -> 0x0034 }
                com.google.android.gms.common.api.a$b<R> r0 = r5.f526ze     // Catch:{ all -> 0x0034 }
                com.google.android.gms.common.api.ResultCallback<R> r2 = r5.f529zh     // Catch:{ all -> 0x0034 }
                com.google.android.gms.common.api.Result r4 = r5.m451ds()     // Catch:{ all -> 0x0034 }
                r0.mo3317a(r2, r4)     // Catch:{ all -> 0x0034 }
            L_0x005a:
                java.util.ArrayList<com.google.android.gms.common.api.PendingResult$a> r0 = r5.f528zg     // Catch:{ all -> 0x0034 }
                java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x0034 }
            L_0x0060:
                boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0034 }
                if (r0 == 0) goto L_0x0070
                java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0034 }
                com.google.android.gms.common.api.PendingResult$a r0 = (com.google.android.gms.common.api.PendingResult.C0295a) r0     // Catch:{ all -> 0x0034 }
                r0.mo3289k(r1)     // Catch:{ all -> 0x0034 }
                goto L_0x0060
            L_0x0070:
                java.util.ArrayList<com.google.android.gms.common.api.PendingResult$a> r0 = r5.f528zg     // Catch:{ all -> 0x0034 }
                r0.clear()     // Catch:{ all -> 0x0034 }
                monitor-exit(r3)     // Catch:{ all -> 0x0034 }
                goto L_0x0013
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.C0296a.C0297a.mo3311b(com.google.android.gms.common.api.Result):void");
        }

        /* renamed from: a */
        public void mo3309a(C0305a aVar) {
            this.f534zm = aVar;
        }

        public final R await() {
            boolean z = false;
            C0766er.m1970a(!this.f531zj, "Results has already been consumed");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            C0766er.m1970a(z, "await must not be called on the UI thread");
            try {
                this.f527zf.await();
            } catch (InterruptedException e) {
                synchronized (this.f525zd) {
                    mo3311b((R) mo3009d(Status.f519zR));
                    this.f533zl = true;
                }
            }
            C0766er.m1970a(isReady(), "Result is not ready.");
            return m451ds();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = false;
            C0766er.m1970a(!this.f531zj, "Result has already been consumed.");
            if (isReady() || Looper.myLooper() != Looper.getMainLooper()) {
                z = true;
            }
            C0766er.m1970a(z, "await must not be called on the UI thread");
            try {
                if (!this.f527zf.await(time, units)) {
                    synchronized (this.f525zd) {
                        mo3311b((R) mo3009d(Status.f520zS));
                        this.f533zl = true;
                    }
                }
            } catch (InterruptedException e) {
                synchronized (this.f525zd) {
                    mo3311b((R) mo3009d(Status.f519zR));
                    this.f533zl = true;
                }
            }
            C0766er.m1970a(isReady(), "Result is not ready.");
            return m451ds();
        }

        /* renamed from: b */
        public final void mo3310b(A a) throws DeadObjectException {
            this.f526ze = new C0298b<>(a.getLooper());
            try {
                mo3004a(a);
            } catch (DeadObjectException e) {
                m450a((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                m450a(e2);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public abstract R mo3009d(Status status);

        /* renamed from: dp */
        public final C0294b<A> mo3312dp() {
            return this.f524zc;
        }

        /* renamed from: dr */
        public int mo3313dr() {
            return 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: dt */
        public void mo3314dt() {
            this.f531zj = true;
            this.f530zi = null;
            if (this.f534zm != null) {
                this.f534zm.mo3322b(this);
            }
        }

        /* renamed from: du */
        public void mo3315du() {
            m452dv();
            this.f532zk = true;
        }

        public final boolean isReady() {
            return this.f527zf.getCount() == 0;
        }

        public final void setResultCallback(ResultCallback<R> callback) {
            C0766er.m1970a(!this.f531zj, "Result has already been consumed.");
            synchronized (this.f525zd) {
                if (isReady()) {
                    this.f526ze.mo3317a(callback, m451ds());
                } else {
                    this.f529zh = callback;
                }
            }
        }

        public final void setResultCallback(ResultCallback<R> callback, long time, TimeUnit units) {
            C0766er.m1970a(!this.f531zj, "Result has already been consumed.");
            synchronized (this.f525zd) {
                if (isReady()) {
                    this.f526ze.mo3317a(callback, m451ds());
                } else {
                    this.f529zh = callback;
                    this.f526ze.mo3318a(this, units.toMillis(time));
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a$b */
    public static class C0298b<R extends Result> extends Handler {
        public C0298b() {
            this(Looper.getMainLooper());
        }

        public C0298b(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void mo3317a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* renamed from: a */
        public void mo3318a(C0297a<R, ?> aVar, long j) {
            sendMessageDelayed(obtainMessage(2, aVar), j);
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo3319b(ResultCallback<R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        /* renamed from: dw */
        public void mo3320dw() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    mo3319b((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    C0297a aVar = (C0297a) msg.obj;
                    aVar.mo3311b(aVar.mo3009d(Status.f520zS));
                    return;
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
                    return;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.a$c */
    public interface C0299c<R> {
        /* renamed from: b */
        void mo3311b(R r);
    }
}
