package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.ej */
public final class C0748ej implements Callback {

    /* renamed from: BQ */
    private static final Object f2037BQ = new Object();

    /* renamed from: BR */
    private static C0748ej f2038BR;
    /* access modifiers changed from: private */

    /* renamed from: BS */
    public final HashMap<String, C0749a> f2039BS = new HashMap<>();
    private final Handler mHandler;

    /* renamed from: qe */
    private final Context f2040qe;

    /* renamed from: com.google.android.gms.internal.ej$a */
    final class C0749a {

        /* renamed from: BT */
        private final String f2041BT;

        /* renamed from: BU */
        private final C0750a f2042BU = new C0750a();
        /* access modifiers changed from: private */

        /* renamed from: BV */
        public final HashSet<C0742f> f2043BV = new HashSet<>();

        /* renamed from: BW */
        private boolean f2044BW;
        /* access modifiers changed from: private */

        /* renamed from: BX */
        public IBinder f2045BX;
        /* access modifiers changed from: private */

        /* renamed from: BY */
        public ComponentName f2046BY;
        /* access modifiers changed from: private */
        public int mState = 0;

        /* renamed from: com.google.android.gms.internal.ej$a$a */
        public class C0750a implements ServiceConnection {
            public C0750a() {
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (C0748ej.this.f2039BS) {
                    C0749a.this.f2045BX = binder;
                    C0749a.this.f2046BY = component;
                    Iterator it = C0749a.this.f2043BV.iterator();
                    while (it.hasNext()) {
                        ((C0742f) it.next()).onServiceConnected(component, binder);
                    }
                    C0749a.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (C0748ej.this.f2039BS) {
                    C0749a.this.f2045BX = null;
                    C0749a.this.f2046BY = component;
                    Iterator it = C0749a.this.f2043BV.iterator();
                    while (it.hasNext()) {
                        ((C0742f) it.next()).onServiceDisconnected(component);
                    }
                    C0749a.this.mState = 2;
                }
            }
        }

        public C0749a(String str) {
            this.f2041BT = str;
        }

        /* renamed from: a */
        public void mo5068a(C0742f fVar) {
            this.f2043BV.add(fVar);
        }

        /* renamed from: b */
        public void mo5069b(C0742f fVar) {
            this.f2043BV.remove(fVar);
        }

        /* renamed from: c */
        public boolean mo5070c(C0742f fVar) {
            return this.f2043BV.contains(fVar);
        }

        /* renamed from: ee */
        public C0750a mo5071ee() {
            return this.f2042BU;
        }

        /* renamed from: ef */
        public String mo5072ef() {
            return this.f2041BT;
        }

        /* renamed from: eg */
        public boolean mo5073eg() {
            return this.f2043BV.isEmpty();
        }

        public IBinder getBinder() {
            return this.f2045BX;
        }

        public ComponentName getComponentName() {
            return this.f2046BY;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.f2044BW;
        }

        /* renamed from: w */
        public void mo5078w(boolean z) {
            this.f2044BW = z;
        }
    }

    private C0748ej(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.f2040qe = context.getApplicationContext();
    }

    /* renamed from: y */
    public static C0748ej m1886y(Context context) {
        synchronized (f2037BQ) {
            if (f2038BR == null) {
                f2038BR = new C0748ej(context.getApplicationContext());
            }
        }
        return f2038BR;
    }

    /* renamed from: a */
    public boolean mo5065a(String str, C0742f fVar) {
        boolean isBound;
        synchronized (this.f2039BS) {
            C0749a aVar = (C0749a) this.f2039BS.get(str);
            if (aVar != null) {
                this.mHandler.removeMessages(0, aVar);
                if (!aVar.mo5070c(fVar)) {
                    aVar.mo5068a(fVar);
                    switch (aVar.getState()) {
                        case 1:
                            fVar.onServiceConnected(aVar.getComponentName(), aVar.getBinder());
                            break;
                        case 2:
                            aVar.mo5078w(this.f2040qe.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.mo5071ee(), 129));
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
                }
            } else {
                aVar = new C0749a(str);
                aVar.mo5068a(fVar);
                aVar.mo5078w(this.f2040qe.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), aVar.mo5071ee(), 129));
                this.f2039BS.put(str, aVar);
            }
            isBound = aVar.isBound();
        }
        return isBound;
    }

    /* renamed from: b */
    public void mo5066b(String str, C0742f fVar) {
        synchronized (this.f2039BS) {
            C0749a aVar = (C0749a) this.f2039BS.get(str);
            if (aVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (!aVar.mo5070c(fVar)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            } else {
                aVar.mo5069b(fVar);
                if (aVar.mo5073eg()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, aVar), 5000);
                }
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                C0749a aVar = (C0749a) msg.obj;
                synchronized (this.f2039BS) {
                    if (aVar.mo5073eg()) {
                        this.f2040qe.unbindService(aVar.mo5071ee());
                        this.f2039BS.remove(aVar.mo5072ef());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
