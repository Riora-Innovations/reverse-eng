package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C1041hx.C1042a;
import com.google.android.gms.location.C1174a;
import com.google.android.gms.location.C1177b;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

/* renamed from: com.google.android.gms.internal.hg */
public interface C1013hg extends IInterface {

    /* renamed from: com.google.android.gms.internal.hg$a */
    public static abstract class C1014a extends Binder implements C1013hg {

        /* renamed from: com.google.android.gms.internal.hg$a$a */
        private static class C1015a implements C1013hg {

            /* renamed from: ky */
            private IBinder f2652ky;

            C1015a(IBinder iBinder) {
                this.f2652ky = iBinder;
            }

            /* renamed from: a */
            public void mo5661a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2652ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5662a(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2652ky.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5663a(PendingIntent pendingIntent, C1010hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2652ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5664a(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f2652ky.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5665a(C1010hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2652ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5666a(C1029hn hnVar, C1050id idVar, C1037hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.f2652ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5667a(C1031hp hpVar, C1050id idVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hpVar != null) {
                        obtain.writeInt(1);
                        hpVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2652ky.transact(25, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5668a(C1033hr hrVar, C1050id idVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (hrVar != null) {
                        obtain.writeInt(1);
                        hrVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2652ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5669a(C1050id idVar, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2652ky.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5670a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2652ky.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5671a(LocationRequest locationRequest, C1174a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f2652ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5672a(LocationRequest locationRequest, C1174a aVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2652ky.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5673a(C1174a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f2652ky.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5674a(LatLng latLng, C1029hn hnVar, C1050id idVar, C1037hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.f2652ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5675a(LatLngBounds latLngBounds, int i, C1029hn hnVar, C1050id idVar, C1037hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (hnVar != null) {
                        obtain.writeInt(1);
                        hnVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.f2652ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5676a(String str, C1050id idVar, C1037hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.f2652ky.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5677a(List<C1042a> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    this.f2652ky.transact(24, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5678a(List<C1025hj> list, PendingIntent pendingIntent, C1010hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2652ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5679a(String[] strArr, C1010hf hfVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(hfVar != null ? hfVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2652ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aF */
            public Location mo5680aF(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.f2652ky.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aG */
            public C1177b mo5681aG(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.f2652ky.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? C1177b.CREATOR.mo6534au(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2652ky;
            }

            /* renamed from: b */
            public void mo5682b(String str, C1050id idVar, C1037hv hvVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    if (idVar != null) {
                        obtain.writeInt(1);
                        idVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hvVar != null ? hvVar.asBinder() : null);
                    this.f2652ky.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: gk */
            public Location mo5683gk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.f2652ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeActivityUpdates(PendingIntent callbackIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (callbackIntent != null) {
                        obtain.writeInt(1);
                        callbackIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2652ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockLocation(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2652ky.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMockMode(boolean isMockMode) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (isMockMode) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2652ky.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: P */
        public static C1013hg m2978P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1013hg)) ? new C1015a(iBinder) : (C1013hg) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v4, types: [android.location.Location] */
        /* JADX WARNING: type inference failed for: r0v7, types: [android.location.Location] */
        /* JADX WARNING: type inference failed for: r0v8, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v17, types: [com.google.android.gms.location.LocationRequest] */
        /* JADX WARNING: type inference failed for: r0v19, types: [com.google.android.gms.location.LocationRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v23, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v24, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v27, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v28, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v31, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v33, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v34, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v36, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v37, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v39, types: [com.google.android.gms.internal.id] */
        /* JADX WARNING: type inference failed for: r0v43, types: [android.location.Location] */
        /* JADX WARNING: type inference failed for: r0v46, types: [android.location.Location] */
        /* JADX WARNING: type inference failed for: r0v49, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v52, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v56, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v59, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v60, types: [com.google.android.gms.location.LocationRequest] */
        /* JADX WARNING: type inference failed for: r0v62, types: [com.google.android.gms.location.LocationRequest] */
        /* JADX WARNING: type inference failed for: r0v65, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v68, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v69, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v72, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v78, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v81, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v82, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v85, types: [android.app.PendingIntent] */
        /* JADX WARNING: type inference failed for: r0v87 */
        /* JADX WARNING: type inference failed for: r0v88 */
        /* JADX WARNING: type inference failed for: r0v89 */
        /* JADX WARNING: type inference failed for: r0v90 */
        /* JADX WARNING: type inference failed for: r0v91 */
        /* JADX WARNING: type inference failed for: r0v92 */
        /* JADX WARNING: type inference failed for: r0v93 */
        /* JADX WARNING: type inference failed for: r0v94 */
        /* JADX WARNING: type inference failed for: r0v95 */
        /* JADX WARNING: type inference failed for: r0v96 */
        /* JADX WARNING: type inference failed for: r0v97 */
        /* JADX WARNING: type inference failed for: r0v98 */
        /* JADX WARNING: type inference failed for: r0v99 */
        /* JADX WARNING: type inference failed for: r0v100 */
        /* JADX WARNING: type inference failed for: r0v101 */
        /* JADX WARNING: type inference failed for: r0v102 */
        /* JADX WARNING: type inference failed for: r0v103 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.id, android.location.Location, com.google.android.gms.location.LocationRequest, android.app.PendingIntent]
          uses: [android.location.Location, com.google.android.gms.internal.id, com.google.android.gms.location.LocationRequest, android.app.PendingIntent]
          mth insns count: 349
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 18 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
            /*
                r7 = this;
                r1 = 0
                r0 = 0
                r6 = 1
                switch(r8) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x003d;
                    case 3: goto L_0x0063;
                    case 4: goto L_0x007f;
                    case 5: goto L_0x0098;
                    case 6: goto L_0x00be;
                    case 7: goto L_0x00d9;
                    case 8: goto L_0x00f4;
                    case 9: goto L_0x0115;
                    case 10: goto L_0x013e;
                    case 11: goto L_0x0153;
                    case 12: goto L_0x016e;
                    case 13: goto L_0x0182;
                    case 14: goto L_0x019d;
                    case 15: goto L_0x01e1;
                    case 16: goto L_0x0206;
                    case 17: goto L_0x0243;
                    case 18: goto L_0x0297;
                    case 19: goto L_0x02ce;
                    case 20: goto L_0x02f7;
                    case 21: goto L_0x031c;
                    case 24: goto L_0x033b;
                    case 25: goto L_0x034b;
                    case 26: goto L_0x036f;
                    case 34: goto L_0x038e;
                    case 42: goto L_0x0272;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r6 = super.onTransact(r8, r9, r10, r11)
            L_0x000a:
                return r6
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r10.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                com.google.android.gms.internal.hk r1 = com.google.android.gms.internal.C1025hj.CREATOR
                java.util.ArrayList r1 = r9.createTypedArrayList(r1)
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x002a
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x002a:
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.internal.hf r2 = com.google.android.gms.internal.C1010hf.C1011a.m2954O(r2)
                java.lang.String r3 = r9.readString()
                r7.mo5678a(r1, r0, r2, r3)
                r10.writeNoException()
                goto L_0x000a
            L_0x003d:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0050
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0050:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.internal.hf r1 = com.google.android.gms.internal.C1010hf.C1011a.m2954O(r1)
                java.lang.String r2 = r9.readString()
                r7.mo5663a(r0, r1, r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x0063:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r0)
                java.lang.String[] r0 = r9.createStringArray()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.internal.hf r1 = com.google.android.gms.internal.C1010hf.C1011a.m2954O(r1)
                java.lang.String r2 = r9.readString()
                r7.mo5679a(r0, r1, r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x007f:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.internal.hf r0 = com.google.android.gms.internal.C1010hf.C1011a.m2954O(r0)
                java.lang.String r1 = r9.readString()
                r7.mo5665a(r0, r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0098:
                java.lang.String r2 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r2)
                long r2 = r9.readLong()
                int r4 = r9.readInt()
                if (r4 == 0) goto L_0x00a8
                r1 = r6
            L_0x00a8:
                int r4 = r9.readInt()
                if (r4 == 0) goto L_0x00b6
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x00b6:
                r7.mo5661a(r2, r1, r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x00be:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x00d1
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x00d1:
                r7.removeActivityUpdates(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x00d9:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r0)
                android.location.Location r0 = r7.mo5683gk()
                r10.writeNoException()
                if (r0 == 0) goto L_0x00ef
                r10.writeInt(r6)
                r0.writeToParcel(r10, r6)
                goto L_0x000a
            L_0x00ef:
                r10.writeInt(r1)
                goto L_0x000a
            L_0x00f4:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0105
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r0 = r0.createFromParcel(r9)
            L_0x0105:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.location.a r1 = com.google.android.gms.location.C1174a.C1175a.m3582N(r1)
                r7.mo5671a(r0, r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0115:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x013c
                com.google.android.gms.location.LocationRequestCreator r1 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r1 = r1.createFromParcel(r9)
            L_0x0126:
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x0134
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0134:
                r7.mo5670a(r1, r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x013c:
                r1 = r0
                goto L_0x0126
            L_0x013e:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.location.a r0 = com.google.android.gms.location.C1174a.C1175a.m3582N(r0)
                r7.mo5673a(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x0153:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0166
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0166:
                r7.mo5662a(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x016e:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x017a
                r1 = r6
            L_0x017a:
                r7.setMockMode(r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x0182:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0195
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.location.Location r0 = (android.location.Location) r0
            L_0x0195:
                r7.setMockLocation(r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x019d:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x01db
                com.google.android.gms.maps.model.LatLngBoundsCreator r1 = com.google.android.gms.maps.model.LatLngBounds.CREATOR
                com.google.android.gms.maps.model.LatLngBounds r1 = r1.createFromParcel(r9)
            L_0x01ae:
                int r2 = r9.readInt()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x01dd
                com.google.android.gms.internal.ho r3 = com.google.android.gms.internal.C1029hn.CREATOR
                com.google.android.gms.internal.hn r3 = r3.createFromParcel(r9)
            L_0x01be:
                int r4 = r9.readInt()
                if (r4 == 0) goto L_0x01df
                com.google.android.gms.internal.ie r0 = com.google.android.gms.internal.C1050id.CREATOR
                com.google.android.gms.internal.id r4 = r0.createFromParcel(r9)
            L_0x01ca:
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.internal.hv r5 = com.google.android.gms.internal.C1037hv.C1038a.m3053R(r0)
                r0 = r7
                r0.mo5675a(r1, r2, r3, r4, r5)
                r10.writeNoException()
                goto L_0x000a
            L_0x01db:
                r1 = r0
                goto L_0x01ae
            L_0x01dd:
                r3 = r0
                goto L_0x01be
            L_0x01df:
                r4 = r0
                goto L_0x01ca
            L_0x01e1:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x01f6
                com.google.android.gms.internal.ie r0 = com.google.android.gms.internal.C1050id.CREATOR
                com.google.android.gms.internal.id r0 = r0.createFromParcel(r9)
            L_0x01f6:
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.internal.hv r2 = com.google.android.gms.internal.C1037hv.C1038a.m3053R(r2)
                r7.mo5676a(r1, r0, r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x0206:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x023f
                com.google.android.gms.maps.model.LatLngCreator r1 = com.google.android.gms.maps.model.LatLng.CREATOR
                com.google.android.gms.maps.model.LatLng r1 = r1.createFromParcel(r9)
            L_0x0217:
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x0241
                com.google.android.gms.internal.ho r2 = com.google.android.gms.internal.C1029hn.CREATOR
                com.google.android.gms.internal.hn r2 = r2.createFromParcel(r9)
            L_0x0223:
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x022f
                com.google.android.gms.internal.ie r0 = com.google.android.gms.internal.C1050id.CREATOR
                com.google.android.gms.internal.id r0 = r0.createFromParcel(r9)
            L_0x022f:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.internal.hv r3 = com.google.android.gms.internal.C1037hv.C1038a.m3053R(r3)
                r7.mo5674a(r1, r2, r0, r3)
                r10.writeNoException()
                goto L_0x000a
            L_0x023f:
                r1 = r0
                goto L_0x0217
            L_0x0241:
                r2 = r0
                goto L_0x0223
            L_0x0243:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0270
                com.google.android.gms.internal.ho r1 = com.google.android.gms.internal.C1029hn.CREATOR
                com.google.android.gms.internal.hn r1 = r1.createFromParcel(r9)
            L_0x0254:
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x0260
                com.google.android.gms.internal.ie r0 = com.google.android.gms.internal.C1050id.CREATOR
                com.google.android.gms.internal.id r0 = r0.createFromParcel(r9)
            L_0x0260:
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.internal.hv r2 = com.google.android.gms.internal.C1037hv.C1038a.m3053R(r2)
                r7.mo5666a(r1, r0, r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x0270:
                r1 = r0
                goto L_0x0254
            L_0x0272:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x0287
                com.google.android.gms.internal.ie r0 = com.google.android.gms.internal.C1050id.CREATOR
                com.google.android.gms.internal.id r0 = r0.createFromParcel(r9)
            L_0x0287:
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.internal.hv r2 = com.google.android.gms.internal.C1037hv.C1038a.m3053R(r2)
                r7.mo5682b(r1, r0, r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x0297:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x02ca
                com.google.android.gms.internal.hs r1 = com.google.android.gms.internal.C1033hr.CREATOR
                com.google.android.gms.internal.hr r1 = r1.createFromParcel(r9)
            L_0x02a8:
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x02cc
                com.google.android.gms.internal.ie r2 = com.google.android.gms.internal.C1050id.CREATOR
                com.google.android.gms.internal.id r2 = r2.createFromParcel(r9)
            L_0x02b4:
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x02c2
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x02c2:
                r7.mo5668a(r1, r2, r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x02ca:
                r1 = r0
                goto L_0x02a8
            L_0x02cc:
                r2 = r0
                goto L_0x02b4
            L_0x02ce:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x02f5
                com.google.android.gms.internal.ie r1 = com.google.android.gms.internal.C1050id.CREATOR
                com.google.android.gms.internal.id r1 = r1.createFromParcel(r9)
            L_0x02df:
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x02ed
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x02ed:
                r7.mo5669a(r1, r0)
                r10.writeNoException()
                goto L_0x000a
            L_0x02f5:
                r1 = r0
                goto L_0x02df
            L_0x02f7:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0308
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r0 = r0.createFromParcel(r9)
            L_0x0308:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.location.a r1 = com.google.android.gms.location.C1174a.C1175a.m3582N(r1)
                java.lang.String r2 = r9.readString()
                r7.mo5672a(r0, r1, r2)
                r10.writeNoException()
                goto L_0x000a
            L_0x031c:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.location.Location r0 = r7.mo5680aF(r0)
                r10.writeNoException()
                if (r0 == 0) goto L_0x0336
                r10.writeInt(r6)
                r0.writeToParcel(r10, r6)
                goto L_0x000a
            L_0x0336:
                r10.writeInt(r1)
                goto L_0x000a
            L_0x033b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r0)
                com.google.android.gms.internal.hw r0 = com.google.android.gms.internal.C1041hx.C1042a.CREATOR
                java.util.ArrayList r0 = r9.createTypedArrayList(r0)
                r7.mo5677a(r0)
                goto L_0x000a
            L_0x034b:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x036d
                com.google.android.gms.internal.hq r1 = com.google.android.gms.internal.C1031hp.CREATOR
                com.google.android.gms.internal.hp r1 = r1.createFromParcel(r9)
            L_0x035c:
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x0368
                com.google.android.gms.internal.ie r0 = com.google.android.gms.internal.C1050id.CREATOR
                com.google.android.gms.internal.id r0 = r0.createFromParcel(r9)
            L_0x0368:
                r7.mo5667a(r1, r0)
                goto L_0x000a
            L_0x036d:
                r1 = r0
                goto L_0x035c
            L_0x036f:
                java.lang.String r1 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0382
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.location.Location r0 = (android.location.Location) r0
            L_0x0382:
                int r1 = r9.readInt()
                r7.mo5664a(r0, r1)
                r10.writeNoException()
                goto L_0x000a
            L_0x038e:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                com.google.android.gms.location.b r0 = r7.mo5681aG(r0)
                r10.writeNoException()
                if (r0 == 0) goto L_0x03a8
                r10.writeInt(r6)
                r0.writeToParcel(r10, r6)
                goto L_0x000a
            L_0x03a8:
                r10.writeInt(r1)
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C1013hg.C1014a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo5661a(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo5662a(PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo5663a(PendingIntent pendingIntent, C1010hf hfVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo5664a(Location location, int i) throws RemoteException;

    /* renamed from: a */
    void mo5665a(C1010hf hfVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo5666a(C1029hn hnVar, C1050id idVar, C1037hv hvVar) throws RemoteException;

    /* renamed from: a */
    void mo5667a(C1031hp hpVar, C1050id idVar) throws RemoteException;

    /* renamed from: a */
    void mo5668a(C1033hr hrVar, C1050id idVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo5669a(C1050id idVar, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo5670a(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    /* renamed from: a */
    void mo5671a(LocationRequest locationRequest, C1174a aVar) throws RemoteException;

    /* renamed from: a */
    void mo5672a(LocationRequest locationRequest, C1174a aVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo5673a(C1174a aVar) throws RemoteException;

    /* renamed from: a */
    void mo5674a(LatLng latLng, C1029hn hnVar, C1050id idVar, C1037hv hvVar) throws RemoteException;

    /* renamed from: a */
    void mo5675a(LatLngBounds latLngBounds, int i, C1029hn hnVar, C1050id idVar, C1037hv hvVar) throws RemoteException;

    /* renamed from: a */
    void mo5676a(String str, C1050id idVar, C1037hv hvVar) throws RemoteException;

    /* renamed from: a */
    void mo5677a(List<C1042a> list) throws RemoteException;

    /* renamed from: a */
    void mo5678a(List<C1025hj> list, PendingIntent pendingIntent, C1010hf hfVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo5679a(String[] strArr, C1010hf hfVar, String str) throws RemoteException;

    /* renamed from: aF */
    Location mo5680aF(String str) throws RemoteException;

    /* renamed from: aG */
    C1177b mo5681aG(String str) throws RemoteException;

    /* renamed from: b */
    void mo5682b(String str, C1050id idVar, C1037hv hvVar) throws RemoteException;

    /* renamed from: gk */
    Location mo5683gk() throws RemoteException;

    void removeActivityUpdates(PendingIntent pendingIntent) throws RemoteException;

    void setMockLocation(Location location) throws RemoteException;

    void setMockMode(boolean z) throws RemoteException;
}
