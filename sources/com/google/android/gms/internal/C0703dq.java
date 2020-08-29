package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0710ds.C0711a;
import com.google.android.gms.internal.C0713dt.C0714a;
import com.google.android.gms.internal.C0736eh.C0741e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.google.android.gms.internal.dq */
public final class C0703dq extends C0736eh<C0710ds> {
    /* access modifiers changed from: private */

    /* renamed from: xE */
    public static final C0715du f1906xE = new C0715du("CastClientImpl");
    /* access modifiers changed from: private */

    /* renamed from: xU */
    public static final Object f1907xU = new Object();
    /* access modifiers changed from: private */

    /* renamed from: xV */
    public static final Object f1908xV = new Object();
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */

    /* renamed from: wz */
    public final Listener f1909wz;
    /* access modifiers changed from: private */

    /* renamed from: xF */
    public ApplicationMetadata f1910xF = null;
    /* access modifiers changed from: private */

    /* renamed from: xG */
    public final CastDevice f1911xG;

    /* renamed from: xH */
    private final C0713dt f1912xH = new C0714a() {
        /* renamed from: D */
        private boolean m1711D(int i) {
            synchronized (C0703dq.f1908xV) {
                if (C0703dq.this.f1924xT == null) {
                    return false;
                }
                C0703dq.this.f1924xT.mo3311b(new Status(i));
                C0703dq.this.f1924xT = null;
                return true;
            }
        }

        /* renamed from: b */
        private void m1712b(long j, int i) {
            C0299c cVar;
            synchronized (C0703dq.this.f1922xR) {
                cVar = (C0299c) C0703dq.this.f1922xR.remove(Long.valueOf(j));
            }
            if (cVar != null) {
                cVar.mo3311b(new Status(i));
            }
        }

        /* renamed from: A */
        public void mo4928A(int i) {
            synchronized (C0703dq.f1907xU) {
                if (C0703dq.this.f1923xS != null) {
                    C0703dq.this.f1923xS.mo3311b(new C0708a(new Status(i)));
                    C0703dq.this.f1923xS = null;
                }
            }
        }

        /* renamed from: B */
        public void mo4929B(int i) {
            m1711D(i);
        }

        /* renamed from: C */
        public void mo4930C(int i) {
            m1711D(i);
        }

        /* renamed from: a */
        public void mo4931a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            C0703dq.this.f1910xF = applicationMetadata;
            C0703dq.this.f1919xO = applicationMetadata.getApplicationId();
            C0703dq.this.f1920xP = str2;
            synchronized (C0703dq.f1907xU) {
                if (C0703dq.this.f1923xS != null) {
                    C0703dq.this.f1923xS.mo3311b(new C0708a(new Status(0), applicationMetadata, str, str2, z));
                    C0703dq.this.f1923xS = null;
                }
            }
        }

        /* renamed from: a */
        public void mo4932a(String str, long j) {
            m1712b(j, 0);
        }

        /* renamed from: a */
        public void mo4933a(String str, long j, int i) {
            m1712b(j, i);
        }

        /* renamed from: b */
        public void mo4934b(String str, double d, boolean z) {
            final String str2 = str;
            final double d2 = d;
            final boolean z2 = z;
            C0703dq.this.mHandler.post(new Runnable() {
                public void run() {
                    C0703dq.this.m1676a(str2, d2, z2);
                }
            });
        }

        /* renamed from: b */
        public void mo4935b(String str, byte[] bArr) {
            C0703dq.f1906xE.mo4961b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }

        /* renamed from: d */
        public void mo4936d(final String str, final String str2) {
            C0703dq.f1906xE.mo4961b("Receive (type=text, ns=%s) %s", str, str2);
            C0703dq.this.mHandler.post(new Runnable() {
                public void run() {
                    MessageReceivedCallback messageReceivedCallback;
                    synchronized (C0703dq.this.f1913xI) {
                        messageReceivedCallback = (MessageReceivedCallback) C0703dq.this.f1913xI.get(str);
                    }
                    if (messageReceivedCallback != null) {
                        messageReceivedCallback.onMessageReceived(C0703dq.this.f1911xG, str, str2);
                        return;
                    }
                    C0703dq.f1906xE.mo4961b("Discarded message for unknown namespace '%s'", str);
                }
            });
        }

        public void onApplicationDisconnected(final int statusCode) {
            C0703dq.this.f1919xO = null;
            C0703dq.this.f1920xP = null;
            if (!m1711D(statusCode) && C0703dq.this.f1909wz != null) {
                C0703dq.this.mHandler.post(new Runnable() {
                    public void run() {
                        if (C0703dq.this.f1909wz != null) {
                            C0703dq.this.f1909wz.onApplicationDisconnected(statusCode);
                        }
                    }
                });
            }
        }

        /* renamed from: z */
        public void mo4938z(int i) {
            C0703dq.f1906xE.mo4961b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            C0703dq.this.f1917xM = false;
            C0703dq.this.f1910xF = null;
            if (i != 0) {
                C0703dq.this.mo5035O(2);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: xI */
    public final Map<String, MessageReceivedCallback> f1913xI = new HashMap();

    /* renamed from: xJ */
    private final long f1914xJ;

    /* renamed from: xK */
    private String f1915xK = null;

    /* renamed from: xL */
    private boolean f1916xL;
    /* access modifiers changed from: private */

    /* renamed from: xM */
    public boolean f1917xM = false;

    /* renamed from: xN */
    private final AtomicLong f1918xN = new AtomicLong(0);
    /* access modifiers changed from: private */

    /* renamed from: xO */
    public String f1919xO;
    /* access modifiers changed from: private */

    /* renamed from: xP */
    public String f1920xP;

    /* renamed from: xQ */
    private Bundle f1921xQ;
    /* access modifiers changed from: private */

    /* renamed from: xR */
    public Map<Long, C0299c<Status>> f1922xR = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: xS */
    public C0299c<ApplicationConnectionResult> f1923xS;
    /* access modifiers changed from: private */

    /* renamed from: xT */
    public C0299c<Status> f1924xT;

    /* renamed from: xe */
    private double f1925xe = 0.0d;

    /* renamed from: xf */
    private boolean f1926xf = false;

    /* renamed from: com.google.android.gms.internal.dq$a */
    private static final class C0708a implements ApplicationConnectionResult {

        /* renamed from: pz */
        private final String f1937pz;

        /* renamed from: vl */
        private final Status f1938vl;

        /* renamed from: yb */
        private final ApplicationMetadata f1939yb;

        /* renamed from: yc */
        private final String f1940yc;

        /* renamed from: yd */
        private final boolean f1941yd;

        public C0708a(Status status) {
            this(status, null, null, null, false);
        }

        public C0708a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.f1938vl = status;
            this.f1939yb = applicationMetadata;
            this.f1940yc = str;
            this.f1937pz = str2;
            this.f1941yd = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.f1939yb;
        }

        public String getApplicationStatus() {
            return this.f1940yc;
        }

        public String getSessionId() {
            return this.f1937pz;
        }

        public Status getStatus() {
            return this.f1938vl;
        }

        public boolean getWasLaunched() {
            return this.f1941yd;
        }
    }

    public C0703dq(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, null);
        this.f1911xG = castDevice;
        this.f1909wz = listener;
        this.f1914xJ = j;
        this.mHandler = new Handler(looper);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1676a(String str, double d, boolean z) {
        boolean z2;
        boolean z3;
        if (!C0709dr.m1723a(str, this.f1915xK)) {
            this.f1915xK = str;
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f1909wz != null && (z2 || this.f1916xL)) {
            this.f1909wz.onApplicationStatusChanged();
        }
        if (d != this.f1925xe) {
            this.f1925xe = d;
            z3 = true;
        } else {
            z3 = false;
        }
        if (z != this.f1926xf) {
            this.f1926xf = z;
            z3 = true;
        }
        f1906xE.mo4961b("hasChange=%b, mFirstStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(this.f1916xL));
        if (this.f1909wz != null && (z3 || this.f1916xL)) {
            this.f1909wz.onVolumeChanged();
        }
        this.f1916xL = false;
    }

    /* renamed from: d */
    private void m1683d(C0299c<ApplicationConnectionResult> cVar) {
        synchronized (f1907xU) {
            if (this.f1923xS != null) {
                this.f1923xS.mo3311b(new C0708a(new Status(2002)));
            }
            this.f1923xS = cVar;
        }
    }

    /* renamed from: db */
    private void m1684db() throws IllegalStateException {
        if (!this.f1917xM) {
            throw new IllegalStateException("not connected to a device");
        }
    }

    /* renamed from: f */
    private void m1690f(C0299c<Status> cVar) {
        synchronized (f1908xV) {
            if (this.f1924xT != null) {
                cVar.mo3311b(new Status(2001));
            } else {
                this.f1924xT = cVar;
            }
        }
    }

    /* renamed from: Q */
    public void mo4913Q(String str) throws IllegalArgumentException, RemoteException {
        MessageReceivedCallback messageReceivedCallback;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.f1913xI) {
            messageReceivedCallback = (MessageReceivedCallback) this.f1913xI.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((C0710ds) mo5039eb()).mo4944T(str);
            } catch (IllegalStateException e) {
                f1906xE.mo4960a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    /* renamed from: a */
    public void mo4914a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((C0710ds) mo5039eb()).mo4945a(d, this.f1925xe, this.f1926xf);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3733a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 || i == 1001) {
            this.f1917xM = true;
            this.f1916xL = true;
        } else {
            this.f1917xM = false;
        }
        if (i == 1001) {
            this.f1921xQ = new Bundle();
            this.f1921xQ.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.mo3733a(i, iBinder, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        Bundle bundle = new Bundle();
        f1906xE.mo4961b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.f1919xO, this.f1920xP);
        this.f1911xG.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.f1914xJ);
        if (this.f1919xO != null) {
            bundle.putString("last_application_id", this.f1919xO);
            if (this.f1920xP != null) {
                bundle.putString("last_session_id", this.f1920xP);
            }
        }
        enVar.mo5092a((C0753em) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f1912xH.asBinder(), bundle);
    }

    /* renamed from: a */
    public void mo4915a(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        mo4913Q(str);
        if (messageReceivedCallback != null) {
            synchronized (this.f1913xI) {
                this.f1913xI.put(str, messageReceivedCallback);
            }
            ((C0710ds) mo5039eb()).mo4943S(str);
        }
    }

    /* renamed from: a */
    public void mo4916a(String str, C0299c<Status> cVar) throws IllegalStateException, RemoteException {
        m1690f(cVar);
        ((C0710ds) mo5039eb()).mo4942R(str);
    }

    /* renamed from: a */
    public void mo4917a(String str, String str2, C0299c<Status> cVar) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str == null || str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            m1684db();
            long incrementAndGet = this.f1918xN.incrementAndGet();
            ((C0710ds) mo5039eb()).mo4946a(str, str2, incrementAndGet);
            this.f1922xR.put(Long.valueOf(incrementAndGet), cVar);
        }
    }

    /* renamed from: a */
    public void mo4918a(String str, boolean z, C0299c<ApplicationConnectionResult> cVar) throws IllegalStateException, RemoteException {
        m1683d(cVar);
        ((C0710ds) mo5039eb()).mo4953e(str, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    /* renamed from: b */
    public void mo4919b(String str, String str2, C0299c<ApplicationConnectionResult> cVar) throws IllegalStateException, RemoteException {
        m1683d(cVar);
        ((C0710ds) mo5039eb()).mo4952e(str, str2);
    }

    /* renamed from: cY */
    public Bundle mo3323cY() {
        if (this.f1921xQ == null) {
            return super.mo3323cY();
        }
        Bundle bundle = this.f1921xQ;
        this.f1921xQ = null;
        return bundle;
    }

    /* renamed from: cZ */
    public void mo4920cZ() throws IllegalStateException, RemoteException {
        ((C0710ds) mo5039eb()).mo4949cZ();
    }

    /* renamed from: da */
    public double mo4921da() throws IllegalStateException {
        m1684db();
        return this.f1925xe;
    }

    public void disconnect() {
        try {
            if (isConnected()) {
                synchronized (this.f1913xI) {
                    this.f1913xI.clear();
                }
                ((C0710ds) mo5039eb()).disconnect();
            }
        } catch (RemoteException e) {
            try {
                f1906xE.mo4961b("Error while disconnecting the controller interface: %s", e.getMessage());
            } catch (Throwable th) {
                super.disconnect();
                throw th;
            }
        }
        super.disconnect();
    }

    /* renamed from: e */
    public void mo4922e(C0299c<Status> cVar) throws IllegalStateException, RemoteException {
        m1690f(cVar);
        ((C0710ds) mo5039eb()).mo4950df();
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        m1684db();
        return this.f1910xF;
    }

    public String getApplicationStatus() throws IllegalStateException {
        m1684db();
        return this.f1915xK;
    }

    public boolean isMute() throws IllegalStateException {
        m1684db();
        return this.f1926xf;
    }

    /* renamed from: t */
    public void mo4926t(boolean z) throws IllegalStateException, RemoteException {
        ((C0710ds) mo5039eb()).mo4948a(z, this.f1925xe, this.f1926xf);
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public C0710ds mo3741p(IBinder iBinder) {
        return C0711a.m1737w(iBinder);
    }
}
