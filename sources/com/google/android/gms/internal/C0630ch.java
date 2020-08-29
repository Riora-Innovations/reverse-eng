package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ch */
public interface C0630ch extends IInterface {

    /* renamed from: com.google.android.gms.internal.ch$a */
    public static abstract class C0631a extends Binder implements C0630ch {

        /* renamed from: com.google.android.gms.internal.ch$a$a */
        private static class C0632a implements C0630ch {

            /* renamed from: ky */
            private IBinder f1674ky;

            C0632a(IBinder iBinder) {
                this.f1674ky = iBinder;
            }

            public IBinder asBinder() {
                return this.f1674ky;
            }

            /* renamed from: b */
            public C0628cf mo4757b(C0625cd cdVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (cdVar != null) {
                        obtain.writeInt(1);
                        cdVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f1674ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? C0628cf.CREATOR.mo4754g(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0631a() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        /* renamed from: q */
        public static C0630ch m1433q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0630ch)) ? new C0632a(iBinder) : (C0630ch) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    C0628cf b = mo4757b(data.readInt() != 0 ? C0625cd.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (b != null) {
                        reply.writeInt(1);
                        b.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: b */
    C0628cf mo4757b(C0625cd cdVar) throws RemoteException;
}
