package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.maps.internal.C1218c.C1219a;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.internal.q */
public class C1258q {

    /* renamed from: PB */
    private static Context f3284PB;

    /* renamed from: PC */
    private static C1218c f3285PC;

    /* renamed from: A */
    public static C1218c m3679A(Context context) throws GooglePlayServicesNotAvailableException {
        C0766er.m1977f(context);
        if (f3285PC != null) {
            return f3285PC;
        }
        m3680B(context);
        f3285PC = m3681C(context);
        try {
            f3285PC.mo6809a(C0456c.m1001h(getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return f3285PC;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* renamed from: B */
    private static void m3680B(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    /* renamed from: C */
    private static C1218c m3681C(Context context) {
        if (!m3684ha()) {
            return C1219a.m3639U((IBinder) m3682a(getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
        Log.i(C1258q.class.getSimpleName(), "Making Creator statically");
        return (C1218c) m3683c(m3685hb());
    }

    /* renamed from: a */
    private static <T> T m3682a(ClassLoader classLoader, String str) {
        try {
            return m3683c(((ClassLoader) C0766er.m1977f(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    /* renamed from: c */
    private static <T> T m3683c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (f3284PB == null) {
            if (m3684ha()) {
                f3284PB = context;
            } else {
                f3284PB = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return f3284PB;
    }

    /* renamed from: ha */
    private static boolean m3684ha() {
        return false;
    }

    /* renamed from: hb */
    private static Class<?> m3685hb() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
