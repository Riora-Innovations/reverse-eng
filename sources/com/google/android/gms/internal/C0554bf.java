package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C0557bg.C0558a;

/* renamed from: com.google.android.gms.internal.bf */
public interface C0554bf extends IInterface {

    /* renamed from: com.google.android.gms.internal.bf$a */
    public static abstract class C0555a extends Binder implements C0554bf {

        /* renamed from: com.google.android.gms.internal.bf$a$a */
        private static class C0556a implements C0554bf {

            /* renamed from: ky */
            private IBinder f1494ky;

            C0556a(IBinder iBinder) {
                this.f1494ky = iBinder;
            }

            public IBinder asBinder() {
                return this.f1494ky;
            }

            /* renamed from: m */
            public C0557bg mo4602m(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    obtain.writeString(str);
                    this.f1494ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0558a.m1264j(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0555a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        /* renamed from: i */
        public static C0554bf m1258i(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0554bf)) ? new C0556a(iBinder) : (C0554bf) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    C0557bg m = mo4602m(data.readString());
                    reply.writeNoException();
                    reply.writeStrongBinder(m != null ? m.asBinder() : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: m */
    C0557bg mo4602m(String str) throws RemoteException;
}
