package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.internal.hv */
public interface C1037hv extends IInterface {

    /* renamed from: com.google.android.gms.internal.hv$a */
    public static abstract class C1038a extends Binder implements C1037hv {

        /* renamed from: com.google.android.gms.internal.hv$a$a */
        private static class C1039a implements C1037hv {

            /* renamed from: ky */
            private IBinder f2822ky;

            C1039a(IBinder iBinder) {
                this.f2822ky = iBinder;
            }

            /* renamed from: I */
            public void mo5781I(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2822ky.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2822ky;
            }
        }

        /* renamed from: R */
        public static C1037hv m3053R(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1037hv)) ? new C1039a(iBinder) : (C1037hv) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    mo5781I(data.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    /* renamed from: I */
    void mo5781I(DataHolder dataHolder) throws RemoteException;
}
