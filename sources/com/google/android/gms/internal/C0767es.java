package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.dynamic.C0458e;
import com.google.android.gms.dynamic.C0458e.C0459a;
import com.google.android.gms.internal.C0759eo.C0760a;

/* renamed from: com.google.android.gms.internal.es */
public final class C0767es extends C0458e<C0759eo> {

    /* renamed from: Cg */
    private static final C0767es f2057Cg = new C0767es();

    private C0767es() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    /* renamed from: d */
    public static View m1980d(Context context, int i, int i2) throws C0459a {
        return f2057Cg.m1981e(context, i, i2);
    }

    /* renamed from: e */
    private View m1981e(Context context, int i, int i2) throws C0459a {
        try {
            return (View) C0456c.m1000b(((C0759eo) mo3948z(context)).mo5115a(C0456c.m1001h(context), i, i2));
        } catch (Exception e) {
            throw new C0459a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    /* renamed from: B */
    public C0759eo mo3947d(IBinder iBinder) {
        return C0760a.m1963A(iBinder);
    }
}
