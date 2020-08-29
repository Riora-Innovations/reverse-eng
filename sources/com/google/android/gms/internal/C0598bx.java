package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0453b;
import com.google.android.gms.dynamic.C0453b.C0454a;

/* renamed from: com.google.android.gms.internal.bx */
public interface C0598bx extends IInterface {

    /* renamed from: com.google.android.gms.internal.bx$a */
    public static abstract class C0599a extends Binder implements C0598bx {

        /* renamed from: com.google.android.gms.internal.bx$a$a */
        private static class C0600a implements C0598bx {

            /* renamed from: ky */
            private IBinder f1561ky;

            C0600a(IBinder iBinder) {
                this.f1561ky = iBinder;
            }

            /* renamed from: a */
            public IBinder mo4690a(C0453b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f1561ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1561ky;
            }
        }

        /* renamed from: n */
        public static C0598bx m1333n(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0598bx)) ? new C0600a(iBinder) : (C0598bx) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    IBinder a = mo4690a(C0454a.m999G(data.readStrongBinder()));
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IBinder mo4690a(C0453b bVar) throws RemoteException;
}
