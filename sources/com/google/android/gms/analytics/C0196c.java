package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0680di;
import com.google.android.gms.internal.C0682dj;
import com.google.android.gms.internal.C0682dj.C0683a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.c */
class C0196c implements C0195b {
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: qM */
    public ServiceConnection f177qM;
    /* access modifiers changed from: private */

    /* renamed from: qN */
    public C0198b f178qN;
    /* access modifiers changed from: private */

    /* renamed from: qO */
    public C0199c f179qO;
    /* access modifiers changed from: private */

    /* renamed from: qP */
    public C0682dj f180qP;

    /* renamed from: com.google.android.gms.analytics.c$a */
    final class C0197a implements ServiceConnection {
        C0197a() {
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            C0181aa.m74v("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    C0181aa.m74v("bound to service");
                    C0196c.this.f180qP = C0683a.m1599r(binder);
                    C0196c.this.m151bn();
                    return;
                }
            } catch (RemoteException e) {
            }
            C0196c.this.mContext.unbindService(this);
            C0196c.this.f177qM = null;
            C0196c.this.f179qO.mo2932a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            C0181aa.m74v("service disconnected: " + component);
            C0196c.this.f177qM = null;
            C0196c.this.f178qN.onDisconnected();
        }
    }

    /* renamed from: com.google.android.gms.analytics.c$b */
    public interface C0198b {
        void onConnected();

        void onDisconnected();
    }

    /* renamed from: com.google.android.gms.analytics.c$c */
    public interface C0199c {
        /* renamed from: a */
        void mo2932a(int i, Intent intent);
    }

    public C0196c(Context context, C0198b bVar, C0199c cVar) {
        this.mContext = context;
        if (bVar == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.f178qN = bVar;
        if (cVar == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.f179qO = cVar;
    }

    /* renamed from: bl */
    private C0682dj m150bl() {
        mo2926bm();
        return this.f180qP;
    }

    /* access modifiers changed from: private */
    /* renamed from: bn */
    public void m151bn() {
        m152bo();
    }

    /* renamed from: bo */
    private void m152bo() {
        this.f178qN.onConnected();
    }

    /* renamed from: a */
    public void mo2922a(Map<String, String> map, long j, String str, List<C0680di> list) {
        try {
            m150bl().mo4865a(map, j, str, list);
        } catch (RemoteException e) {
            C0181aa.m72t("sendHit failed: " + e);
        }
    }

    /* renamed from: bk */
    public void mo2923bk() {
        try {
            m150bl().mo4866bk();
        } catch (RemoteException e) {
            C0181aa.m72t("clear hits failed: " + e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: bm */
    public void mo2926bm() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.f177qM != null) {
            C0181aa.m72t("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.f177qM = new C0197a();
        boolean bindService = this.mContext.bindService(intent, this.f177qM, 129);
        C0181aa.m74v("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.f177qM = null;
            this.f179qO.mo2932a(1, null);
        }
    }

    public void disconnect() {
        this.f180qP = null;
        if (this.f177qM != null) {
            try {
                this.mContext.unbindService(this.f177qM);
            } catch (IllegalArgumentException | IllegalStateException e) {
            }
            this.f177qM = null;
            this.f178qN.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.f180qP != null;
    }
}
