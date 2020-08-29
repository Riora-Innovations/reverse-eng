package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ei */
public final class C0745ei {
    /* access modifiers changed from: private */

    /* renamed from: BJ */
    public final C0747b f2030BJ;
    /* access modifiers changed from: private */

    /* renamed from: BK */
    public ArrayList<ConnectionCallbacks> f2031BK = new ArrayList<>();

    /* renamed from: BL */
    final ArrayList<ConnectionCallbacks> f2032BL = new ArrayList<>();

    /* renamed from: BM */
    private boolean f2033BM = false;

    /* renamed from: BN */
    private ArrayList<OnConnectionFailedListener> f2034BN = new ArrayList<>();

    /* renamed from: BO */
    private boolean f2035BO = false;
    private final Handler mHandler;

    /* renamed from: com.google.android.gms.internal.ei$a */
    final class C0746a extends Handler {
        public C0746a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                synchronized (C0745ei.this.f2031BK) {
                    if (C0745ei.this.f2030BJ.mo3324dC() && C0745ei.this.f2030BJ.isConnected() && C0745ei.this.f2031BK.contains(msg.obj)) {
                        ((ConnectionCallbacks) msg.obj).onConnected(C0745ei.this.f2030BJ.mo3323cY());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    /* renamed from: com.google.android.gms.internal.ei$b */
    public interface C0747b {
        /* renamed from: cY */
        Bundle mo3323cY();

        /* renamed from: dC */
        boolean mo3324dC();

        boolean isConnected();
    }

    public C0745ei(Context context, Looper looper, C0747b bVar) {
        this.f2030BJ = bVar;
        this.mHandler = new C0746a(looper);
    }

    /* renamed from: P */
    public void mo5054P(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.f2031BK) {
            this.f2033BM = true;
            ArrayList<ConnectionCallbacks> arrayList = this.f2031BK;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size && this.f2030BJ.mo3324dC(); i2++) {
                if (this.f2031BK.contains(arrayList.get(i2))) {
                    ((ConnectionCallbacks) arrayList.get(i2)).onConnectionSuspended(i);
                }
            }
            this.f2033BM = false;
        }
    }

    /* renamed from: a */
    public void mo5055a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.f2034BN) {
            this.f2035BO = true;
            ArrayList<OnConnectionFailedListener> arrayList = this.f2034BN;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (this.f2030BJ.mo3324dC()) {
                    if (this.f2034BN.contains(arrayList.get(i))) {
                        ((OnConnectionFailedListener) arrayList.get(i)).onConnectionFailed(connectionResult);
                    }
                    i++;
                } else {
                    return;
                }
            }
            this.f2035BO = false;
        }
    }

    /* renamed from: b */
    public void mo5056b(Bundle bundle) {
        boolean z = true;
        synchronized (this.f2031BK) {
            C0766er.m1978v(!this.f2033BM);
            this.mHandler.removeMessages(1);
            this.f2033BM = true;
            if (this.f2032BL.size() != 0) {
                z = false;
            }
            C0766er.m1978v(z);
            ArrayList<ConnectionCallbacks> arrayList = this.f2031BK;
            int size = arrayList.size();
            for (int i = 0; i < size && this.f2030BJ.mo3324dC() && this.f2030BJ.isConnected(); i++) {
                this.f2032BL.size();
                if (!this.f2032BL.contains(arrayList.get(i))) {
                    ((ConnectionCallbacks) arrayList.get(i)).onConnected(bundle);
                }
            }
            this.f2032BL.clear();
            this.f2033BM = false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bo */
    public void mo5057bo() {
        synchronized (this.f2031BK) {
            mo5056b(this.f2030BJ.mo3323cY());
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        C0766er.m1977f(listener);
        synchronized (this.f2031BK) {
            contains = this.f2031BK.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        C0766er.m1977f(listener);
        synchronized (this.f2034BN) {
            contains = this.f2034BN.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        C0766er.m1977f(listener);
        synchronized (this.f2031BK) {
            if (this.f2031BK.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                if (this.f2033BM) {
                    this.f2031BK = new ArrayList<>(this.f2031BK);
                }
                this.f2031BK.add(listener);
            }
        }
        if (this.f2030BJ.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        C0766er.m1977f(listener);
        synchronized (this.f2034BN) {
            if (this.f2034BN.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                if (this.f2035BO) {
                    this.f2034BN = new ArrayList<>(this.f2034BN);
                }
                this.f2034BN.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        C0766er.m1977f(listener);
        synchronized (this.f2031BK) {
            if (this.f2031BK != null) {
                if (this.f2033BM) {
                    this.f2031BK = new ArrayList<>(this.f2031BK);
                }
                if (!this.f2031BK.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.f2033BM && !this.f2032BL.contains(listener)) {
                    this.f2032BL.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        C0766er.m1977f(listener);
        synchronized (this.f2034BN) {
            if (this.f2034BN != null) {
                if (this.f2035BO) {
                    this.f2034BN = new ArrayList<>(this.f2034BN);
                }
                if (!this.f2034BN.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
                }
            }
        }
    }
}
