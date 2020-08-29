package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0766er;

/* renamed from: com.google.android.gms.dynamic.e */
public abstract class C0458e<T> {

    /* renamed from: FC */
    private final String f879FC;

    /* renamed from: FD */
    private T f880FD;

    /* renamed from: com.google.android.gms.dynamic.e$a */
    public static class C0459a extends Exception {
        public C0459a(String str) {
            super(str);
        }

        public C0459a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0458e(String str) {
        this.f879FC = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract T mo3947d(IBinder iBinder);

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public final T mo3948z(Context context) throws C0459a {
        if (this.f880FD == null) {
            C0766er.m1977f(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0459a("Could not get remote context.");
            }
            try {
                this.f880FD = mo3947d((IBinder) remoteContext.getClassLoader().loadClass(this.f879FC).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0459a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0459a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0459a("Could not access creator.");
            }
        }
        return this.f880FD;
    }
}
