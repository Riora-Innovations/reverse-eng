package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0453b;
import com.google.android.gms.dynamic.C0453b.C0454a;
import com.google.android.gms.internal.C0554bf.C0555a;

/* renamed from: com.google.android.gms.internal.ah */
public interface C0514ah extends IInterface {

    /* renamed from: com.google.android.gms.internal.ah$a */
    public static abstract class C0515a extends Binder implements C0514ah {

        /* renamed from: com.google.android.gms.internal.ah$a$a */
        private static class C0516a implements C0514ah {

            /* renamed from: ky */
            private IBinder f1202ky;

            C0516a(IBinder iBinder) {
                this.f1202ky = iBinder;
            }

            /* renamed from: a */
            public IBinder mo4518a(C0453b bVar, C0504ab abVar, String str, C0554bf bfVar, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bfVar != null) {
                        iBinder = bfVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.f1202ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1202ky;
            }
        }

        /* renamed from: g */
        public static C0514ah m1177g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0514ah)) ? new C0516a(iBinder) : (C0514ah) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    IBinder a = mo4518a(C0454a.m999G(data.readStrongBinder()), data.readInt() != 0 ? C0504ab.CREATOR.createFromParcel(data) : null, data.readString(), C0555a.m1258i(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(a);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: a */
    IBinder mo4518a(C0453b bVar, C0504ab abVar, String str, C0554bf bfVar, int i) throws RemoteException;
}
