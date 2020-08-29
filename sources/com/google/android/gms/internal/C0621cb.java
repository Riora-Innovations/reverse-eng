package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.C0619ca.C0620a;

/* renamed from: com.google.android.gms.internal.cb */
public abstract class C0621cb extends C0648ct {

    /* renamed from: mf */
    private final C0625cd f1640mf;

    /* renamed from: nY */
    private final C0620a f1641nY;

    /* renamed from: com.google.android.gms.internal.cb$a */
    public static final class C0622a extends C0621cb {
        private final Context mContext;

        public C0622a(Context context, C0625cd cdVar, C0620a aVar) {
            super(cdVar, aVar);
            this.mContext = context;
        }

        /* renamed from: aD */
        public void mo4741aD() {
        }

        /* renamed from: aE */
        public C0630ch mo4742aE() {
            return C0633ci.m1437a(this.mContext, new C0540av());
        }
    }

    /* renamed from: com.google.android.gms.internal.cb$b */
    public static final class C0623b extends C0621cb implements ConnectionCallbacks, OnConnectionFailedListener {

        /* renamed from: mg */
        private final Object f1642mg = new Object();

        /* renamed from: nY */
        private final C0620a f1643nY;

        /* renamed from: nZ */
        private final C0624cc f1644nZ;

        public C0623b(Context context, C0625cd cdVar, C0620a aVar) {
            super(cdVar, aVar);
            this.f1643nY = aVar;
            this.f1644nZ = new C0624cc(context, this, this, cdVar.f1646kN.f1800pW);
            this.f1644nZ.connect();
        }

        /* renamed from: aD */
        public void mo4741aD() {
            synchronized (this.f1642mg) {
                if (this.f1644nZ.isConnected() || this.f1644nZ.isConnecting()) {
                    this.f1644nZ.disconnect();
                }
            }
        }

        /* renamed from: aE */
        public C0630ch mo4742aE() {
            C0630ch chVar;
            synchronized (this.f1642mg) {
                try {
                    chVar = this.f1644nZ.mo4743aH();
                } catch (IllegalStateException e) {
                    chVar = null;
                }
            }
            return chVar;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.f1643nY.mo4694a(new C0628cf(0));
        }

        public void onDisconnected() {
            C0662da.m1551s("Disconnected from remote ad request service.");
        }
    }

    public C0621cb(C0625cd cdVar, C0620a aVar) {
        this.f1640mf = cdVar;
        this.f1641nY = aVar;
    }

    /* renamed from: a */
    private static C0628cf m1412a(C0630ch chVar, C0625cd cdVar) {
        try {
            return chVar.mo4757b(cdVar);
        } catch (RemoteException e) {
            C0662da.m1549b("Could not fetch ad response from ad request service.", e);
            return null;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: aB */
    public final void mo4695aB() {
        C0628cf a;
        try {
            C0630ch aE = mo4742aE();
            if (aE == null) {
                a = new C0628cf(0);
            } else {
                a = m1412a(aE, this.f1640mf);
                if (a == null) {
                    a = new C0628cf(0);
                }
            }
            mo4741aD();
            this.f1641nY.mo4694a(a);
        } catch (Throwable th) {
            mo4741aD();
            throw th;
        }
    }

    /* renamed from: aD */
    public abstract void mo4741aD();

    /* renamed from: aE */
    public abstract C0630ch mo4742aE();

    public final void onStop() {
        mo4741aD();
    }
}
