package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.dynamic.C0458e;
import com.google.android.gms.dynamic.C0458e.C0459a;
import com.google.android.gms.internal.C0595bw.C0596a;
import com.google.android.gms.internal.C0598bx.C0599a;

/* renamed from: com.google.android.gms.internal.bv */
public final class C0593bv extends C0458e<C0598bx> {

    /* renamed from: nL */
    private static final C0593bv f1559nL = new C0593bv();

    /* renamed from: com.google.android.gms.internal.bv$a */
    private static final class C0594a extends Exception {
        public C0594a(String str) {
            super(str);
        }
    }

    private C0593bv() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* renamed from: a */
    public static C0595bw m1326a(Activity activity) {
        try {
            if (!m1327b(activity)) {
                return f1559nL.m1328c(activity);
            }
            C0662da.m1551s("Using AdOverlay from the client jar.");
            return new C0581bo(activity);
        } catch (C0594a e) {
            C0662da.m1555w(e.getMessage());
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m1327b(Activity activity) throws C0594a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0594a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    /* renamed from: c */
    private C0595bw m1328c(Activity activity) {
        try {
            return C0596a.m1331m(((C0598bx) mo3948z(activity)).mo4690a(C0456c.m1001h(activity)));
        } catch (RemoteException e) {
            C0662da.m1549b("Could not create remote AdOverlay.", e);
            return null;
        } catch (C0459a e2) {
            C0662da.m1549b("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public C0598bx mo3947d(IBinder iBinder) {
        return C0599a.m1333n(iBinder);
    }
}
