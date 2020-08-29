package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.C0293a;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0297a;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C0745ei;
import com.google.android.gms.internal.C0745ei.C0747b;
import com.google.android.gms.internal.C0766er;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.gms.common.api.b */
final class C0300b implements GoogleApiClient {
    /* access modifiers changed from: private */

    /* renamed from: zA */
    public int f535zA;
    /* access modifiers changed from: private */

    /* renamed from: zB */
    public int f536zB = 4;
    /* access modifiers changed from: private */

    /* renamed from: zC */
    public int f537zC = 0;

    /* renamed from: zD */
    private boolean f538zD = false;

    /* renamed from: zE */
    private int f539zE;
    /* access modifiers changed from: private */

    /* renamed from: zF */
    public long f540zF = 5000;

    /* renamed from: zG */
    final Handler f541zG;
    /* access modifiers changed from: private */

    /* renamed from: zH */
    public final Bundle f542zH = new Bundle();

    /* renamed from: zI */
    private final Map<C0294b<?>, C0293a> f543zI = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: zJ */
    public boolean f544zJ;

    /* renamed from: zK */
    final Set<C0307c> f545zK = new HashSet();

    /* renamed from: zL */
    final ConnectionCallbacks f546zL = new ConnectionCallbacks() {
        public void onConnected(Bundle connectionHint) {
            C0300b.this.f549zv.lock();
            try {
                if (C0300b.this.f536zB == 1) {
                    if (connectionHint != null) {
                        C0300b.this.f542zH.putAll(connectionHint);
                    }
                    C0300b.this.m480dy();
                }
            } finally {
                C0300b.this.f549zv.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            C0300b.this.f549zv.lock();
            try {
                C0300b.this.m468G(cause);
                switch (cause) {
                    case 1:
                        if (!C0300b.this.m478dA()) {
                            C0300b.this.f537zC = 2;
                            C0300b.this.f541zG.sendMessageDelayed(C0300b.this.f541zG.obtainMessage(1), C0300b.this.f540zF);
                            break;
                        } else {
                            C0300b.this.f549zv.unlock();
                            return;
                        }
                    case 2:
                        C0300b.this.connect();
                        break;
                }
            } finally {
                C0300b.this.f549zv.unlock();
            }
        }
    };

    /* renamed from: zM */
    private final C0747b f547zM = new C0747b() {
        /* renamed from: cY */
        public Bundle mo3323cY() {
            return null;
        }

        /* renamed from: dC */
        public boolean mo3324dC() {
            return C0300b.this.f544zJ;
        }

        public boolean isConnected() {
            return C0300b.this.isConnected();
        }
    };

    /* renamed from: zm */
    private final C0305a f548zm = new C0305a() {
        /* renamed from: b */
        public void mo3322b(C0307c cVar) {
            C0300b.this.f549zv.lock();
            try {
                C0300b.this.f545zK.remove(cVar);
            } finally {
                C0300b.this.f549zv.unlock();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: zv */
    public final Lock f549zv = new ReentrantLock();

    /* renamed from: zw */
    private final Condition f550zw = this.f549zv.newCondition();

    /* renamed from: zx */
    private final C0745ei f551zx;

    /* renamed from: zy */
    final Queue<C0307c<?>> f552zy = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: zz */
    public ConnectionResult f553zz;

    /* renamed from: com.google.android.gms.common.api.b$a */
    interface C0305a {
        /* renamed from: b */
        void mo3322b(C0307c cVar);
    }

    /* renamed from: com.google.android.gms.common.api.b$b */
    class C0306b extends Handler {
        C0306b(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                C0300b.this.f549zv.lock();
                try {
                    if (!C0300b.this.isConnected() && !C0300b.this.isConnecting()) {
                        C0300b.this.connect();
                    }
                } finally {
                    C0300b.this.f549zv.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.b$c */
    interface C0307c<A extends C0293a> {
        /* renamed from: a */
        void mo3309a(C0305a aVar);

        /* renamed from: b */
        void mo3310b(A a) throws DeadObjectException;

        /* renamed from: dp */
        C0294b<A> mo3312dp();

        /* renamed from: dr */
        int mo3313dr();

        /* renamed from: du */
        void mo3315du();
    }

    public C0300b(Context context, Looper looper, C0732ee eeVar, Map<Api, ApiOptions> map, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2) {
        this.f551zx = new C0745ei(context, looper, this.f547zM);
        this.f541zG = new C0306b(looper);
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.f551zx.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.f551zx.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            final C0294b dp = api.mo3250dp();
            ApiOptions apiOptions = (ApiOptions) map.get(api);
            this.f543zI.put(dp, dp.mo2998b(context, looper, eeVar, apiOptions, this.f546zL, new OnConnectionFailedListener() {
                public void onConnectionFailed(ConnectionResult result) {
                    C0300b.this.f549zv.lock();
                    try {
                        if (C0300b.this.f553zz == null || dp.getPriority() < C0300b.this.f535zA) {
                            C0300b.this.f553zz = result;
                            C0300b.this.f535zA = dp.getPriority();
                        }
                        C0300b.this.m480dy();
                    } finally {
                        C0300b.this.f549zv.unlock();
                    }
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m468G(int i) {
        this.f549zv.lock();
        try {
            if (this.f536zB != 3) {
                if (i == -1) {
                    if (isConnecting()) {
                        Iterator it = this.f552zy.iterator();
                        while (it.hasNext()) {
                            if (((C0307c) it.next()).mo3313dr() != 1) {
                                it.remove();
                            }
                        }
                    } else {
                        this.f552zy.clear();
                    }
                    if (this.f553zz == null && !this.f552zy.isEmpty()) {
                        this.f538zD = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.f536zB = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.f553zz = null;
                    }
                    this.f550zw.signalAll();
                }
                for (C0307c du : this.f545zK) {
                    du.mo3315du();
                }
                this.f545zK.clear();
                this.f544zJ = false;
                for (C0293a aVar : this.f543zI.values()) {
                    if (aVar.isConnected()) {
                        aVar.disconnect();
                    }
                }
                this.f544zJ = true;
                this.f536zB = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.f551zx.mo5054P(i);
                    }
                    this.f544zJ = false;
                }
            }
            this.f549zv.unlock();
        } finally {
            this.f549zv.unlock();
        }
    }

    /* renamed from: a */
    private <A extends C0293a> void m471a(C0307c<A> cVar) throws DeadObjectException {
        this.f549zv.lock();
        try {
            C0766er.m1970a(isConnected(), "GoogleApiClient is not connected yet.");
            C0766er.m1970a(cVar.mo3312dp() != null, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            if (cVar instanceof Releasable) {
                this.f545zK.add(cVar);
                cVar.mo3309a(this.f548zm);
            }
            cVar.mo3310b(mo3256a(cVar.mo3312dp()));
        } finally {
            this.f549zv.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dA */
    public boolean m478dA() {
        this.f549zv.lock();
        try {
            return this.f537zC != 0;
        } finally {
            this.f549zv.unlock();
        }
    }

    /* renamed from: dB */
    private void m479dB() {
        this.f549zv.lock();
        try {
            this.f537zC = 0;
            this.f541zG.removeMessages(1);
        } finally {
            this.f549zv.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dy */
    public void m480dy() {
        this.f549zv.lock();
        try {
            this.f539zE--;
            if (this.f539zE == 0) {
                if (this.f553zz != null) {
                    this.f538zD = false;
                    m468G(3);
                    if (m478dA()) {
                        this.f537zC--;
                    }
                    if (m478dA()) {
                        this.f541zG.sendMessageDelayed(this.f541zG.obtainMessage(1), this.f540zF);
                    } else {
                        this.f551zx.mo5055a(this.f553zz);
                    }
                    this.f544zJ = false;
                } else {
                    this.f536zB = 2;
                    m479dB();
                    this.f550zw.signalAll();
                    m481dz();
                    if (this.f538zD) {
                        this.f538zD = false;
                        m468G(-1);
                    } else {
                        this.f551zx.mo5056b(this.f542zH.isEmpty() ? null : this.f542zH);
                    }
                }
            }
        } finally {
            this.f549zv.unlock();
        }
    }

    /* renamed from: dz */
    private void m481dz() {
        C0766er.m1970a(isConnected(), "GoogleApiClient is not connected yet.");
        this.f549zv.lock();
        while (!this.f552zy.isEmpty()) {
            try {
                m471a((C0307c) this.f552zy.remove());
            } catch (DeadObjectException e) {
                Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
            } catch (Throwable th) {
                this.f549zv.unlock();
                throw th;
            }
        }
        this.f549zv.unlock();
    }

    /* renamed from: a */
    public <C extends C0293a> C mo3256a(C0294b<C> bVar) {
        C c = (C0293a) this.f543zI.get(bVar);
        C0766er.m1975b(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    /* renamed from: a */
    public <A extends C0293a, T extends C0297a<? extends Result, A>> T mo3257a(T t) {
        this.f549zv.lock();
        try {
            if (isConnected()) {
                mo3258b(t);
            } else {
                this.f552zy.add(t);
            }
            return t;
        } finally {
            this.f549zv.unlock();
        }
    }

    /* renamed from: b */
    public <A extends C0293a, T extends C0297a<? extends Result, A>> T mo3258b(T t) {
        C0766er.m1970a(isConnected(), "GoogleApiClient is not connected yet.");
        m481dz();
        try {
            m471a((C0307c<A>) t);
        } catch (DeadObjectException e) {
            m468G(1);
        }
        return t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (isConnected() == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r0 = com.google.android.gms.common.ConnectionResult.f485yI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r4.f553zz == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        r0 = r4.f553zz;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        r4.f549zv.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0 = new com.google.android.gms.common.ConnectionResult(13, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        r4.f549zv.unlock();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.common.ConnectionResult blockingConnect(long r5, java.util.concurrent.TimeUnit r7) {
        /*
            r4 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x003c
            r0 = 1
        L_0x000b:
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            com.google.android.gms.internal.C0766er.m1970a(r0, r1)
            java.util.concurrent.locks.Lock r0 = r4.f549zv
            r0.lock()
            r4.connect()     // Catch:{ all -> 0x007c }
            long r0 = r7.toNanos(r5)     // Catch:{ all -> 0x007c }
        L_0x001c:
            boolean r2 = r4.isConnecting()     // Catch:{ all -> 0x007c }
            if (r2 == 0) goto L_0x0054
            java.util.concurrent.locks.Condition r2 = r4.f550zw     // Catch:{ InterruptedException -> 0x003e }
            long r0 = r2.awaitNanos(r0)     // Catch:{ InterruptedException -> 0x003e }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x001c
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ InterruptedException -> 0x003e }
            r1 = 14
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ InterruptedException -> 0x003e }
            java.util.concurrent.locks.Lock r1 = r4.f549zv
            r1.unlock()
        L_0x003b:
            return r0
        L_0x003c:
            r0 = 0
            goto L_0x000b
        L_0x003e:
            r0 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x007c }
            r0.interrupt()     // Catch:{ all -> 0x007c }
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x007c }
            r1 = 15
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r4.f549zv
            r1.unlock()
            goto L_0x003b
        L_0x0054:
            boolean r0 = r4.isConnected()     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0062
            com.google.android.gms.common.ConnectionResult r0 = com.google.android.gms.common.ConnectionResult.f485yI     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r4.f549zv
            r1.unlock()
            goto L_0x003b
        L_0x0062:
            com.google.android.gms.common.ConnectionResult r0 = r4.f553zz     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x006e
            com.google.android.gms.common.ConnectionResult r0 = r4.f553zz     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r4.f549zv
            r1.unlock()
            goto L_0x003b
        L_0x006e:
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x007c }
            r1 = 13
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r4.f549zv
            r1.unlock()
            goto L_0x003b
        L_0x007c:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r4.f549zv
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.C0300b.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    public void connect() {
        this.f549zv.lock();
        try {
            this.f538zD = false;
            if (!isConnected() && !isConnecting()) {
                this.f544zJ = true;
                this.f553zz = null;
                this.f536zB = 1;
                this.f542zH.clear();
                this.f539zE = this.f543zI.size();
                for (C0293a connect : this.f543zI.values()) {
                    connect.connect();
                }
                this.f549zv.unlock();
            }
        } finally {
            this.f549zv.unlock();
        }
    }

    public void disconnect() {
        m479dB();
        m468G(-1);
    }

    public boolean isConnected() {
        this.f549zv.lock();
        try {
            return this.f536zB == 2;
        } finally {
            this.f549zv.unlock();
        }
    }

    public boolean isConnecting() {
        boolean z = true;
        this.f549zv.lock();
        try {
            if (this.f536zB != 1) {
                z = false;
            }
            return z;
        } finally {
            this.f549zv.unlock();
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.f551zx.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.f551zx.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.f551zx.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f551zx.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.f551zx.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f551zx.unregisterConnectionFailedListener(listener);
    }
}
