package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.dynamic.b */
public interface C0453b extends IInterface {

    /* renamed from: com.google.android.gms.dynamic.b$a */
    public static abstract class C0454a extends Binder implements C0453b {

        /* renamed from: com.google.android.gms.dynamic.b$a$a */
        private static class C0455a implements C0453b {

            /* renamed from: ky */
            private IBinder f877ky;

            C0455a(IBinder iBinder) {
                this.f877ky = iBinder;
            }

            public IBinder asBinder() {
                return this.f877ky;
            }
        }

        public C0454a() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* renamed from: G */
        public static C0453b m999G(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0453b)) ? new C0455a(iBinder) : (C0453b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
