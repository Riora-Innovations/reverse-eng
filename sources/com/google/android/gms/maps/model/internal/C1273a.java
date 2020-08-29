package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0453b;
import com.google.android.gms.dynamic.C0453b.C0454a;

/* renamed from: com.google.android.gms.maps.model.internal.a */
public interface C1273a extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.a$a */
    public static abstract class C1274a extends Binder implements C1273a {

        /* renamed from: com.google.android.gms.maps.model.internal.a$a$a */
        private static class C1275a implements C1273a {

            /* renamed from: ky */
            private IBinder f3370ky;

            C1275a(IBinder iBinder) {
                this.f3370ky = iBinder;
            }

            /* renamed from: aL */
            public C0453b mo7165aL(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.f3370ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aM */
            public C0453b mo7166aM(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.f3370ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aN */
            public C0453b mo7167aN(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.f3370ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3370ky;
            }

            /* renamed from: b */
            public C0453b mo7168b(Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3370ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: bz */
            public C0453b mo7169bz(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeInt(i);
                    this.f3370ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public C0453b mo7170c(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeFloat(f);
                    this.f3370ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: hi */
            public C0453b mo7171hi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.f3370ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: an */
        public static C1273a m3733an(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1273a)) ? new C1275a(iBinder) : (C1273a) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0453b bz = mo7169bz(data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(bz != null ? bz.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0453b aL = mo7165aL(data.readString());
                    reply.writeNoException();
                    if (aL != null) {
                        iBinder = aL.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0453b aM = mo7166aM(data.readString());
                    reply.writeNoException();
                    if (aM != null) {
                        iBinder = aM.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0453b hi = mo7171hi();
                    reply.writeNoException();
                    if (hi != null) {
                        iBinder = hi.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0453b c = mo7170c(data.readFloat());
                    reply.writeNoException();
                    if (c != null) {
                        iBinder = c.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0453b b = mo7168b(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (b != null) {
                        iBinder = b.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    C0453b aN = mo7167aN(data.readString());
                    reply.writeNoException();
                    if (aN != null) {
                        iBinder = aN.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: aL */
    C0453b mo7165aL(String str) throws RemoteException;

    /* renamed from: aM */
    C0453b mo7166aM(String str) throws RemoteException;

    /* renamed from: aN */
    C0453b mo7167aN(String str) throws RemoteException;

    /* renamed from: b */
    C0453b mo7168b(Bitmap bitmap) throws RemoteException;

    /* renamed from: bz */
    C0453b mo7169bz(int i) throws RemoteException;

    /* renamed from: c */
    C0453b mo7170c(float f) throws RemoteException;

    /* renamed from: hi */
    C0453b mo7171hi() throws RemoteException;
}
