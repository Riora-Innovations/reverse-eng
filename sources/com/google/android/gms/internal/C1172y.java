package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.dynamic.C0458e;
import com.google.android.gms.dynamic.C0458e.C0459a;
import com.google.android.gms.internal.C0511ag.C0512a;
import com.google.android.gms.internal.C0514ah.C0515a;

/* renamed from: com.google.android.gms.internal.y */
public final class C1172y extends C0458e<C0514ah> {

    /* renamed from: ld */
    private static final C1172y f3157ld = new C1172y();

    private C1172y() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* renamed from: a */
    public static C0511ag m3569a(Context context, C0504ab abVar, String str, C0553be beVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            C0511ag b = f3157ld.m3570b(context, abVar, str, beVar);
            if (b != null) {
                return b;
            }
        }
        C0662da.m1551s("Using AdManager from the client jar.");
        return new C1167v(context, abVar, str, beVar, new C0663db(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    /* renamed from: b */
    private C0511ag m3570b(Context context, C0504ab abVar, String str, C0553be beVar) {
        try {
            return C0512a.m1168f(((C0514ah) mo3948z(context)).mo4518a(C0456c.m1001h(context), abVar, str, beVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (RemoteException e) {
            C0662da.m1549b("Could not create remote AdManager.", e);
            return null;
        } catch (C0459a e2) {
            C0662da.m1549b("Could not create remote AdManager.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C0514ah mo3947d(IBinder iBinder) {
        return C0515a.m1177g(iBinder);
    }
}
