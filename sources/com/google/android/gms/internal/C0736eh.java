package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.C0293a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.C0745ei.C0747b;
import com.google.android.gms.internal.C0753em.C0754a;
import com.google.android.gms.internal.C0756en.C0757a;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.eh */
public abstract class C0736eh<T extends IInterface> implements GooglePlayServicesClient, C0293a, C0747b {

    /* renamed from: BB */
    public static final String[] f2009BB = {"service_esmobile", "service_googleme"};

    /* renamed from: BA */
    boolean f2010BA;
    /* access modifiers changed from: private */

    /* renamed from: Bv */
    public T f2011Bv;
    /* access modifiers changed from: private */

    /* renamed from: Bw */
    public final ArrayList<C0738b<?>> f2012Bw;
    /* access modifiers changed from: private */

    /* renamed from: Bx */
    public C0742f f2013Bx;
    /* access modifiers changed from: private */

    /* renamed from: By */
    public volatile int f2014By;

    /* renamed from: Bz */
    private final String[] f2015Bz;
    /* access modifiers changed from: private */
    public final Context mContext;
    final Handler mHandler;

    /* renamed from: zs */
    private final Looper f2016zs;
    /* access modifiers changed from: private */

    /* renamed from: zx */
    public final C0745ei f2017zx;

    /* renamed from: com.google.android.gms.internal.eh$a */
    final class C0737a extends Handler {
        public C0737a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1 && !C0736eh.this.isConnecting()) {
                C0738b bVar = (C0738b) msg.obj;
                bVar.mo4887cP();
                bVar.unregister();
            } else if (msg.what == 3) {
                C0736eh.this.f2017zx.mo5055a(new ConnectionResult(((Integer) msg.obj).intValue(), null));
            } else if (msg.what == 4) {
                C0736eh.this.f2014By = 1;
                C0736eh.this.f2011Bv = null;
                C0736eh.this.f2017zx.mo5054P(((Integer) msg.obj).intValue());
            } else if (msg.what == 2 && !C0736eh.this.isConnected()) {
                C0738b bVar2 = (C0738b) msg.obj;
                bVar2.mo4887cP();
                bVar2.unregister();
            } else if (msg.what == 2 || msg.what == 1) {
                ((C0738b) msg.obj).mo5045ec();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.eh$b */
    protected abstract class C0738b<TListener> {

        /* renamed from: BD */
        private boolean f2020BD = false;
        private TListener mListener;

        public C0738b(TListener tlistener) {
            this.mListener = tlistener;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4885a(TListener tlistener);

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public abstract void mo4887cP();

        /* renamed from: ec */
        public void mo5045ec() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.f2020BD) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    mo4885a(tlistener);
                } catch (RuntimeException e) {
                    mo4887cP();
                    throw e;
                }
            } else {
                mo4887cP();
            }
            synchronized (this) {
                this.f2020BD = true;
            }
            unregister();
        }

        /* renamed from: ed */
        public void mo5046ed() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            mo5046ed();
            synchronized (C0736eh.this.f2012Bw) {
                C0736eh.this.f2012Bw.remove(this);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.eh$c */
    public static final class C0739c implements ConnectionCallbacks {

        /* renamed from: BE */
        private final GooglePlayServicesClient.ConnectionCallbacks f2021BE;

        public C0739c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.f2021BE = connectionCallbacks;
        }

        public boolean equals(Object other) {
            return other instanceof C0739c ? this.f2021BE.equals(((C0739c) other).f2021BE) : this.f2021BE.equals(other);
        }

        public void onConnected(Bundle connectionHint) {
            this.f2021BE.onConnected(connectionHint);
        }

        public void onConnectionSuspended(int cause) {
            this.f2021BE.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.internal.eh$d */
    public abstract class C0740d<TListener> extends C0738b<TListener> {

        /* renamed from: zU */
        private final DataHolder f2023zU;

        public C0740d(TListener tlistener, DataHolder dataHolder) {
            super(tlistener);
            this.f2023zU = dataHolder;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo4885a(TListener tlistener) {
            mo4889a(tlistener, this.f2023zU);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo4889a(TListener tlistener, DataHolder dataHolder);

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
            if (this.f2023zU != null) {
                this.f2023zU.close();
            }
        }

        /* renamed from: ec */
        public /* bridge */ /* synthetic */ void mo5045ec() {
            super.mo5045ec();
        }

        /* renamed from: ed */
        public /* bridge */ /* synthetic */ void mo5046ed() {
            super.mo5046ed();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    /* renamed from: com.google.android.gms.internal.eh$e */
    public static final class C0741e extends C0754a {

        /* renamed from: BF */
        private C0736eh f2024BF;

        public C0741e(C0736eh ehVar) {
            this.f2024BF = ehVar;
        }

        /* renamed from: b */
        public void mo5049b(int i, IBinder iBinder, Bundle bundle) {
            C0766er.m1975b("onPostInitComplete can be called only once per call to getServiceFromBroker", (Object) this.f2024BF);
            this.f2024BF.mo3733a(i, iBinder, bundle);
            this.f2024BF = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.eh$f */
    final class C0742f implements ServiceConnection {
        C0742f() {
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            C0736eh.this.mo5043x(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            C0736eh.this.mHandler.sendMessage(C0736eh.this.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    /* renamed from: com.google.android.gms.internal.eh$g */
    public static final class C0743g implements OnConnectionFailedListener {

        /* renamed from: BG */
        private final GooglePlayServicesClient.OnConnectionFailedListener f2026BG;

        public C0743g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f2026BG = onConnectionFailedListener;
        }

        public boolean equals(Object other) {
            return other instanceof C0743g ? this.f2026BG.equals(((C0743g) other).f2026BG) : this.f2026BG.equals(other);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.f2026BG.onConnectionFailed(result);
        }
    }

    /* renamed from: com.google.android.gms.internal.eh$h */
    protected final class C0744h extends C0738b<Boolean> {

        /* renamed from: BH */
        public final Bundle f2028BH;

        /* renamed from: BI */
        public final IBinder f2029BI;
        public final int statusCode;

        public C0744h(int i, IBinder iBinder, Bundle bundle) {
            super(Boolean.valueOf(true));
            this.statusCode = i;
            this.f2029BI = iBinder;
            this.f2028BH = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4885a(Boolean bool) {
            if (bool == null) {
                C0736eh.this.f2014By = 1;
                return;
            }
            switch (this.statusCode) {
                case 0:
                    try {
                        if (C0736eh.this.mo3736aG().equals(this.f2029BI.getInterfaceDescriptor())) {
                            C0736eh.this.f2011Bv = C0736eh.this.mo3741p(this.f2029BI);
                            if (C0736eh.this.f2011Bv != null) {
                                C0736eh.this.f2014By = 3;
                                C0736eh.this.f2017zx.mo5057bo();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    C0748ej.m1886y(C0736eh.this.mContext).mo5066b(C0736eh.this.mo3735aF(), C0736eh.this.f2013Bx);
                    C0736eh.this.f2013Bx = null;
                    C0736eh.this.f2014By = 1;
                    C0736eh.this.f2011Bv = null;
                    C0736eh.this.f2017zx.mo5055a(new ConnectionResult(8, null));
                    return;
                case 10:
                    C0736eh.this.f2014By = 1;
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.f2028BH != null ? (PendingIntent) this.f2028BH.getParcelable("pendingIntent") : null;
                    if (C0736eh.this.f2013Bx != null) {
                        C0748ej.m1886y(C0736eh.this.mContext).mo5066b(C0736eh.this.mo3735aF(), C0736eh.this.f2013Bx);
                        C0736eh.this.f2013Bx = null;
                    }
                    C0736eh.this.f2014By = 1;
                    C0736eh.this.f2011Bv = null;
                    C0736eh.this.f2017zx.mo5055a(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    protected C0736eh(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.f2012Bw = new ArrayList<>();
        this.f2014By = 1;
        this.f2010BA = false;
        this.mContext = (Context) C0766er.m1977f(context);
        this.f2016zs = (Looper) C0766er.m1975b(looper, (Object) "Looper must not be null");
        this.f2017zx = new C0745ei(context, looper, this);
        this.mHandler = new C0737a(looper);
        mo4881b(strArr);
        this.f2015Bz = strArr;
        registerConnectionCallbacks((ConnectionCallbacks) C0766er.m1977f(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) C0766er.m1977f(onConnectionFailedListener));
    }

    protected C0736eh(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new C0739c(connectionCallbacks), new C0743g(onConnectionFailedListener), strArr);
    }

    /* renamed from: O */
    public void mo5035O(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3733a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C0744h(i, iBinder, bundle)));
    }

    /* renamed from: a */
    public final void mo5036a(C0738b<?> bVar) {
        synchronized (this.f2012Bw) {
            this.f2012Bw.add(bVar);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, bVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException;

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public abstract String mo3735aF();

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public abstract String mo3736aG();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4881b(String... strArr) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: bm */
    public final void mo5037bm() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* renamed from: cY */
    public Bundle mo3323cY() {
        return null;
    }

    public void connect() {
        this.f2010BA = true;
        this.f2014By = 2;
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            this.f2014By = 1;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.f2013Bx != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.f2011Bv = null;
            C0748ej.m1886y(this.mContext).mo5066b(mo3735aF(), this.f2013Bx);
        }
        this.f2013Bx = new C0742f<>();
        if (!C0748ej.m1886y(this.mContext).mo5065a(mo3735aF(), this.f2013Bx)) {
            Log.e("GmsClient", "unable to connect to service: " + mo3735aF());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    /* renamed from: dC */
    public boolean mo3324dC() {
        return this.f2010BA;
    }

    public void disconnect() {
        this.f2010BA = false;
        synchronized (this.f2012Bw) {
            int size = this.f2012Bw.size();
            for (int i = 0; i < size; i++) {
                ((C0738b) this.f2012Bw.get(i)).mo5046ed();
            }
            this.f2012Bw.clear();
        }
        this.f2014By = 1;
        this.f2011Bv = null;
        if (this.f2013Bx != null) {
            C0748ej.m1886y(this.mContext).mo5066b(mo3735aF(), this.f2013Bx);
            this.f2013Bx = null;
        }
    }

    /* renamed from: ea */
    public final String[] mo5038ea() {
        return this.f2015Bz;
    }

    /* access modifiers changed from: protected */
    /* renamed from: eb */
    public final T mo5039eb() {
        mo5037bm();
        return this.f2011Bv;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.f2016zs;
    }

    public boolean isConnected() {
        return this.f2014By == 3;
    }

    public boolean isConnecting() {
        return this.f2014By == 2;
    }

    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.f2017zx.isConnectionCallbacksRegistered(new C0739c(listener));
    }

    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.f2017zx.isConnectionFailedListenerRegistered(listener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public abstract T mo3741p(IBinder iBinder);

    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f2017zx.registerConnectionCallbacks(new C0739c(listener));
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.f2017zx.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f2017zx.registerConnectionFailedListener(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f2017zx.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.f2017zx.unregisterConnectionCallbacks(new C0739c(listener));
    }

    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.f2017zx.unregisterConnectionFailedListener(listener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public final void mo5043x(IBinder iBinder) {
        try {
            mo3734a(C0757a.m1937z(iBinder), new C0741e(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }
}
