package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0453b;
import com.google.android.gms.dynamic.C0453b.C0454a;
import com.google.android.gms.maps.model.internal.C1282d;
import com.google.android.gms.maps.model.internal.C1282d.C1283a;

/* renamed from: com.google.android.gms.maps.internal.d */
public interface C1221d extends IInterface {

    /* renamed from: com.google.android.gms.maps.internal.d$a */
    public static abstract class C1222a extends Binder implements C1221d {

        /* renamed from: com.google.android.gms.maps.internal.d$a$a */
        private static class C1223a implements C1221d {

            /* renamed from: ky */
            private IBinder f3272ky;

            C1223a(IBinder iBinder) {
                this.f3272ky = iBinder;
            }

            public IBinder asBinder() {
                return this.f3272ky;
            }

            /* renamed from: f */
            public C0453b mo6586f(C1282d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f3272ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public C0453b mo6587g(C1282d dVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(dVar != null ? dVar.asBinder() : null);
                    this.f3272ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1222a() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        /* renamed from: W */
        public static C1221d m3648W(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1221d)) ? new C1223a(iBinder) : (C1221d) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    C0453b f = mo6586f(C1283a.m3753aq(data.readStrongBinder()));
                    reply.writeNoException();
                    if (f != null) {
                        iBinder = f.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    C0453b g = mo6587g(C1283a.m3753aq(data.readStrongBinder()));
                    reply.writeNoException();
                    if (g != null) {
                        iBinder = g.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: f */
    C0453b mo6586f(C1282d dVar) throws RemoteException;

    /* renamed from: g */
    C0453b mo6587g(C1282d dVar) throws RemoteException;
}
