package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C1323c.C1324a;

/* renamed from: com.google.android.gms.plus.internal.g */
public final class C1339g {

    /* renamed from: PB */
    private static Context f3449PB;

    /* renamed from: Rl */
    private static C1323c f3450Rl;

    /* renamed from: com.google.android.gms.plus.internal.g$a */
    public static class C1340a extends Exception {
        public C1340a(String str) {
            super(str);
        }
    }

    /* renamed from: D */
    private static C1323c m3909D(Context context) throws C1340a {
        C0766er.m1977f(context);
        if (f3450Rl == null) {
            if (f3449PB == null) {
                f3449PB = GooglePlayServicesUtil.getRemoteContext(context);
                if (f3449PB == null) {
                    throw new C1340a("Could not get remote context.");
                }
            }
            try {
                f3450Rl = C1324a.m3838az((IBinder) f3449PB.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C1340a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C1340a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C1340a("Could not access creator.");
            }
        }
        return f3450Rl;
    }

    /* renamed from: a */
    public static View m3910a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C0456c.m1000b(m3909D(context).mo7368a(C0456c.m1001h(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }
}
