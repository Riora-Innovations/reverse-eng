package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;

/* renamed from: com.google.android.gms.internal.gb */
public interface C0896gb extends IInterface {

    /* renamed from: com.google.android.gms.internal.gb$a */
    public static abstract class C0897a extends Binder implements C0896gb {

        /* renamed from: com.google.android.gms.internal.gb$a$a */
        private static class C0898a implements C0896gb {

            /* renamed from: ky */
            private IBinder f2483ky;

            C0898a(IBinder iBinder) {
                this.f2483ky = iBinder;
            }

            /* renamed from: a */
            public int mo5401a(C0893ga gaVar, byte[] bArr, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo5402a(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.f2483ky.transact(9008, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo5403a(int i, byte[] bArr, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.f2483ky.transact(10012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo5404a(RoomEntity roomEntity, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (roomEntity != null) {
                        obtain.writeInt(1);
                        roomEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(9011, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo5405a(C0995gy gyVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gyVar != null) {
                        obtain.writeInt(1);
                        gyVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(10021, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo5406a(C0996gz gzVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (gzVar != null) {
                        obtain.writeInt(1);
                        gzVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.f2483ky.transact(10022, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public Intent mo5407a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeTypedArray(participantEntityArr, 0);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (uri2 != null) {
                        obtain.writeInt(1);
                        uri2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(9031, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5408a(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f2483ky.transact(8019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5409a(IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(5005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5410a(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5411a(C0893ga gaVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    this.f2483ky.transact(10016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5412a(C0893ga gaVar, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f2483ky.transact(10009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5413a(C0893ga gaVar, int i, int i2, boolean z, boolean z2) throws RemoteException {
                int i3 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i3 = 0;
                    }
                    obtain.writeInt(i3);
                    this.f2483ky.transact(5044, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5414a(C0893ga gaVar, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(8004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5415a(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(5015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5416a(C0893ga gaVar, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.f2483ky.transact(10018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5417a(C0893ga gaVar, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeLong(j);
                    this.f2483ky.transact(5058, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5418a(C0893ga gaVar, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f2483ky.transact(8018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5419a(C0893ga gaVar, Bundle bundle, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f2483ky.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5420a(C0893ga gaVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    this.f2483ky.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5421a(C0893ga gaVar, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    this.f2483ky.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5422a(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5423a(C0893ga gaVar, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f2483ky.transact(10011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5424a(C0893ga gaVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f2483ky.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5425a(C0893ga gaVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5426a(C0893ga gaVar, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(8023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5427a(C0893ga gaVar, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(5045, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5428a(C0893ga gaVar, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (!z4) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INACTIVE_MATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5429a(C0893ga gaVar, String str, int i, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeIntArray(iArr);
                    this.f2483ky.transact(10019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5430a(C0893ga gaVar, String str, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    this.f2483ky.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5431a(C0893ga gaVar, String str, long j, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeString(str2);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5432a(C0893ga gaVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5433a(C0893ga gaVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5434a(C0893ga gaVar, String str, String str2, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.f2483ky.transact(8001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5435a(C0893ga gaVar, String str, String str2, int i, int i2, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    this.f2483ky.transact(10010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5436a(C0893ga gaVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f2483ky.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5437a(C0893ga gaVar, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(9028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5438a(C0893ga gaVar, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5439a(C0893ga gaVar, String str, String str2, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStringArray(strArr);
                    this.f2483ky.transact(10008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5440a(C0893ga gaVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(5054, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5441a(C0893ga gaVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str2);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.f2483ky.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5442a(C0893ga gaVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeByteArray(bArr);
                    obtain.writeTypedArray(participantResultArr, 0);
                    this.f2483ky.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5443a(C0893ga gaVar, String str, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    this.f2483ky.transact(8017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5444a(C0893ga gaVar, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i2);
                    this.f2483ky.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5445a(C0893ga gaVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5446a(C0893ga gaVar, boolean z, Bundle bundle) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(5063, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5447a(C0893ga gaVar, int[] iArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeIntArray(iArr);
                    this.f2483ky.transact(8003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo5448a(C0893ga gaVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f2483ky.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aA */
            public int mo5449aA(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f2483ky.transact(5060, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aB */
            public Uri mo5450aB(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f2483ky.transact(5066, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aC */
            public void mo5451aC(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f2483ky.transact(8002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aD */
            public ParcelFileDescriptor mo5452aD(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f2483ky.transact(9030, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: aU */
            public void mo5453aU(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    this.f2483ky.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f2483ky;
            }

            /* renamed from: au */
            public Intent mo5454au(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f2483ky.transact(9004, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ax */
            public String mo5455ax(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f2483ky.transact(5064, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ay */
            public String mo5456ay(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f2483ky.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: az */
            public void mo5457az(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    this.f2483ky.transact(5050, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public int mo5458b(byte[] bArr, String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeByteArray(bArr);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.f2483ky.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public Intent mo5459b(int i, int i2, boolean z) throws RemoteException {
                int i3 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (z) {
                        i3 = 1;
                    }
                    obtain.writeInt(i3);
                    this.f2483ky.transact(9009, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5460b(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f2483ky.transact(8021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5461b(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5462b(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(5046, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5463b(C0893ga gaVar, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeLong(j);
                    this.f2483ky.transact(8012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5464b(C0893ga gaVar, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f2483ky.transact(8020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5465b(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5018, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5466b(C0893ga gaVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f2483ky.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5467b(C0893ga gaVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5468b(C0893ga gaVar, String str, int i, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(10017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5469b(C0893ga gaVar, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(5501, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5470b(C0893ga gaVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5471b(C0893ga gaVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(5041, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5472b(C0893ga gaVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
                int i4 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (z) {
                        i4 = 1;
                    }
                    obtain.writeInt(i4);
                    this.f2483ky.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5473b(C0893ga gaVar, String str, String str2, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MATCH_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5474b(C0893ga gaVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_STATE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5475b(C0893ga gaVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5476b(C0893ga gaVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f2483ky.transact(GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo5477b(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f2483ky.transact(5051, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5478c(long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f2483ky.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5479c(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5480c(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(5048, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5481c(C0893ga gaVar, long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeLong(j);
                    this.f2483ky.transact(GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5482c(C0893ga gaVar, long j, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    this.f2483ky.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5483c(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5484c(C0893ga gaVar, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(9001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5485c(C0893ga gaVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(8011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5486c(C0893ga gaVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5487c(C0893ga gaVar, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(8027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5488c(C0893ga gaVar, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeStringArray(strArr);
                    this.f2483ky.transact(10020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo5489c(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.f2483ky.transact(8026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: cY */
            public Bundle mo5490cY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(5004, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo5491d(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo5492d(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo5493d(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo5494d(C0893ga gaVar, String str, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(9020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo5495d(C0893ga gaVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(8015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo5496d(C0893ga gaVar, String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MATCH_ERROR_ALREADY_REMATCHED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public ParcelFileDescriptor mo5497e(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MATCH_ERROR_LOCALLY_MODIFIED, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo5498e(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo5499e(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException {
                int i2 = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    if (!z2) {
                        i2 = 0;
                    }
                    obtain.writeInt(i2);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo5500e(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5042, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo5501e(C0893ga gaVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(8016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo5502f(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5047, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: f */
            public void mo5503f(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5043, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fA */
            public int mo5504fA() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(9019, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fB */
            public String mo5505fB() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(5003, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fC */
            public int mo5506fC() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(8024, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fD */
            public Intent mo5507fD() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(10015, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fE */
            public int mo5508fE() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(10013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fF */
            public int mo5509fF() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(10023, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fH */
            public void mo5510fH() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(5006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fI */
            public DataHolder mo5511fI() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(5013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fJ */
            public boolean mo5512fJ() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(5067, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fK */
            public DataHolder mo5513fK() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(5502, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fL */
            public void mo5514fL() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(8022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fM */
            public Intent mo5515fM() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(9013, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fn */
            public String mo5516fn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(5007, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fo */
            public String mo5517fo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(5012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fr */
            public Intent mo5518fr() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(9003, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fs */
            public Intent mo5519fs() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(9005, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: ft */
            public Intent mo5520ft() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(9006, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fu */
            public Intent mo5521fu() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(9007, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fy */
            public Intent mo5522fy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(9010, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: fz */
            public Intent mo5523fz() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.f2483ky.transact(9012, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Intent) Intent.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo5524g(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5049, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: g */
            public void mo5525g(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5052, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public DataHolder mo5526h(C0893ga gaVar, String str) throws RemoteException {
                DataHolder dataHolder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5053, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(obtain2);
                    }
                    return dataHolder;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: h */
            public void mo5527h(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5056, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo5528i(C0893ga gaVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    this.f2483ky.transact(5062, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: i */
            public void mo5529i(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5061, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo5530j(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(5057, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: j */
            public void mo5531j(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(5065, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo5532k(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: k */
            public void mo5533k(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f2483ky.transact(8025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo5534l(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(8005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: l */
            public void mo5535l(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f2483ky.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo5536m(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: m */
            public void mo5537m(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f2483ky.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo5538n(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f2483ky.transact(5001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo5539n(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: n */
            public void mo5540n(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f2483ky.transact(5055, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo5541o(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f2483ky.transact(5059, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo5542o(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: o */
            public void mo5543o(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.f2483ky.transact(10014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo5544p(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f2483ky.transact(8013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: p */
            public void mo5545p(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(8014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo5546q(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeLong(j);
                    this.f2483ky.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: q */
            public void mo5547q(C0893ga gaVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    obtain.writeStrongBinder(gaVar != null ? gaVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f2483ky.transact(9002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: y */
            public void mo5548y(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f2483ky.transact(5068, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: J */
        public static C0896gb m2645J(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0896gb)) ? new C0898a(iBinder) : (C0896gb) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r12v0, types: [android.os.Parcel] */
        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v1, types: [com.google.android.gms.internal.gy] */
        /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.gy] */
        /* JADX WARNING: type inference failed for: r5v3, types: [com.google.android.gms.internal.gz] */
        /* JADX WARNING: type inference failed for: r5v4, types: [com.google.android.gms.internal.gz] */
        /* JADX WARNING: type inference failed for: r5v13, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v90, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r5v14 */
        /* JADX WARNING: type inference failed for: r5v20, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v209, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r5v21 */
        /* JADX WARNING: type inference failed for: r5v23, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v224, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r5v24 */
        /* JADX WARNING: type inference failed for: r5v41, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v410, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r5v42 */
        /* JADX WARNING: type inference failed for: r5v43, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v432, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r5v44 */
        /* JADX WARNING: type inference failed for: r5v47 */
        /* JADX WARNING: type inference failed for: r5v48 */
        /* JADX WARNING: Incorrect type for immutable var: ssa=android.os.Parcel, code=null, for r12v0, types: [android.os.Parcel] */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.internal.gz, com.google.android.gms.internal.gy, ?[OBJECT, ARRAY]]
          uses: [com.google.android.gms.internal.gy, com.google.android.gms.internal.gz, android.net.Uri, android.os.Bundle]
          mth insns count: 1559
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 9 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
            /*
                r10 = this;
                r5 = 0
                r7 = 0
                r9 = 1
                switch(r11) {
                    case 5001: goto L_0x0011;
                    case 5002: goto L_0x0021;
                    case 5003: goto L_0x0035;
                    case 5004: goto L_0x0045;
                    case 5005: goto L_0x005e;
                    case 5006: goto L_0x007e;
                    case 5007: goto L_0x008a;
                    case 5012: goto L_0x00c5;
                    case 5013: goto L_0x00d6;
                    case 5014: goto L_0x00f1;
                    case 5015: goto L_0x010a;
                    case 5016: goto L_0x0133;
                    case 5017: goto L_0x0150;
                    case 5018: goto L_0x0165;
                    case 5019: goto L_0x017e;
                    case 5020: goto L_0x01ad;
                    case 5021: goto L_0x01dc;
                    case 5022: goto L_0x0209;
                    case 5023: goto L_0x021e;
                    case 5024: goto L_0x024b;
                    case 5025: goto L_0x0278;
                    case 5026: goto L_0x02a9;
                    case 5027: goto L_0x02be;
                    case 5028: goto L_0x02d3;
                    case 5029: goto L_0x02e8;
                    case 5030: goto L_0x0327;
                    case 5031: goto L_0x0365;
                    case 5032: goto L_0x0390;
                    case 5033: goto L_0x03a9;
                    case 5034: goto L_0x03ce;
                    case 5035: goto L_0x03eb;
                    case 5036: goto L_0x0400;
                    case 5037: goto L_0x0411;
                    case 5038: goto L_0x042a;
                    case 5039: goto L_0x0447;
                    case 5040: goto L_0x0478;
                    case 5041: goto L_0x04a9;
                    case 5042: goto L_0x04c6;
                    case 5043: goto L_0x04df;
                    case 5044: goto L_0x04f8;
                    case 5045: goto L_0x0528;
                    case 5046: goto L_0x0558;
                    case 5047: goto L_0x0581;
                    case 5048: goto L_0x0596;
                    case 5049: goto L_0x05bf;
                    case 5050: goto L_0x05d4;
                    case 5051: goto L_0x05e5;
                    case 5052: goto L_0x05fe;
                    case 5053: goto L_0x0617;
                    case 5054: goto L_0x0653;
                    case 5055: goto L_0x068c;
                    case 5056: goto L_0x06c9;
                    case 5057: goto L_0x06de;
                    case 5058: goto L_0x02fd;
                    case 5059: goto L_0x0316;
                    case 5060: goto L_0x063e;
                    case 5061: goto L_0x0673;
                    case 5062: goto L_0x06f7;
                    case 5063: goto L_0x070c;
                    case 5064: goto L_0x009b;
                    case 5065: goto L_0x00b0;
                    case 5066: goto L_0x0738;
                    case 5067: goto L_0x06a1;
                    case 5068: goto L_0x06b5;
                    case 5501: goto L_0x0757;
                    case 5502: goto L_0x0787;
                    case 6001: goto L_0x07a2;
                    case 6002: goto L_0x07be;
                    case 6003: goto L_0x07e2;
                    case 6004: goto L_0x080b;
                    case 6501: goto L_0x0834;
                    case 6502: goto L_0x0874;
                    case 6503: goto L_0x0894;
                    case 6504: goto L_0x08b0;
                    case 6505: goto L_0x08d0;
                    case 6506: goto L_0x08f0;
                    case 6507: goto L_0x0914;
                    case 7001: goto L_0x093f;
                    case 7002: goto L_0x0958;
                    case 7003: goto L_0x097a;
                    case 8001: goto L_0x09ab;
                    case 8002: goto L_0x09d1;
                    case 8003: goto L_0x09e2;
                    case 8004: goto L_0x09fb;
                    case 8005: goto L_0x0a2c;
                    case 8006: goto L_0x0a45;
                    case 8007: goto L_0x0a5e;
                    case 8008: goto L_0x0a88;
                    case 8009: goto L_0x0aad;
                    case 8010: goto L_0x0ac6;
                    case 8011: goto L_0x0adf;
                    case 8012: goto L_0x0afc;
                    case 8013: goto L_0x0b15;
                    case 8014: goto L_0x0b26;
                    case 8015: goto L_0x0b65;
                    case 8016: goto L_0x0b82;
                    case 8017: goto L_0x0b9f;
                    case 8018: goto L_0x0bd5;
                    case 8019: goto L_0x0bf2;
                    case 8020: goto L_0x0c07;
                    case 8021: goto L_0x0c24;
                    case 8022: goto L_0x0c39;
                    case 8023: goto L_0x0c46;
                    case 8024: goto L_0x0b3f;
                    case 8025: goto L_0x0b50;
                    case 8026: goto L_0x0bbc;
                    case 8027: goto L_0x0c6a;
                    case 9001: goto L_0x0c86;
                    case 9002: goto L_0x0cb6;
                    case 9003: goto L_0x0ccf;
                    case 9004: goto L_0x0cea;
                    case 9005: goto L_0x0d09;
                    case 9006: goto L_0x0d24;
                    case 9007: goto L_0x0d3f;
                    case 9008: goto L_0x0d5a;
                    case 9009: goto L_0x0d86;
                    case 9010: goto L_0x0db2;
                    case 9011: goto L_0x0dcd;
                    case 9012: goto L_0x0dfc;
                    case 9013: goto L_0x0e17;
                    case 9019: goto L_0x0e7e;
                    case 9020: goto L_0x0e8f;
                    case 9028: goto L_0x0ebf;
                    case 9030: goto L_0x0ef3;
                    case 9031: goto L_0x0e32;
                    case 10001: goto L_0x0f12;
                    case 10002: goto L_0x0f2b;
                    case 10003: goto L_0x0f3c;
                    case 10004: goto L_0x0f59;
                    case 10005: goto L_0x0f6e;
                    case 10006: goto L_0x0f98;
                    case 10007: goto L_0x0fb1;
                    case 10008: goto L_0x0fca;
                    case 10009: goto L_0x0feb;
                    case 10010: goto L_0x100c;
                    case 10011: goto L_0x1036;
                    case 10012: goto L_0x1053;
                    case 10013: goto L_0x107e;
                    case 10014: goto L_0x10e6;
                    case 10015: goto L_0x10a0;
                    case 10016: goto L_0x10fb;
                    case 10017: goto L_0x1114;
                    case 10018: goto L_0x1167;
                    case 10019: goto L_0x1184;
                    case 10020: goto L_0x11a5;
                    case 10021: goto L_0x1138;
                    case 10022: goto L_0x10bb;
                    case 10023: goto L_0x108f;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r9 = super.onTransact(r11, r12, r13, r14)
            L_0x000a:
                return r9
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r13.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo5538n(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0021:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5410a(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0035:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.mo5505fB()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x0045:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.Bundle r0 = r10.mo5490cY()
                r13.writeNoException()
                if (r0 == 0) goto L_0x005a
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x005a:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x005e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r1 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x007c
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0075:
                r10.mo5409a(r1, r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x007c:
                r0 = r5
                goto L_0x0075
            L_0x007e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                r10.mo5510fH()
                r13.writeNoException()
                goto L_0x000a
            L_0x008a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.mo5516fn()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x009b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r0 = r10.mo5455ax(r0)
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x00b0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                r10.mo5531j(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x00c5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r10.mo5517fo()
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x00d6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                com.google.android.gms.common.data.DataHolder r0 = r10.mo5511fI()
                r13.writeNoException()
                if (r0 == 0) goto L_0x00ec
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x00ec:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x00f1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5422a(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x010a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0131
                r0 = r9
            L_0x0122:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0129
                r7 = r9
            L_0x0129:
                r10.mo5415a(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0131:
                r0 = r7
                goto L_0x0122
            L_0x0133:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                long r2 = r12.readLong()
                r10.mo5430a(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0150:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5461b(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0165:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5465b(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x017e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x01ab
                r6 = r9
            L_0x01a2:
                r0 = r10
                r0.mo5424a(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x01ab:
                r6 = r7
                goto L_0x01a2
            L_0x01ad:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x01da
                r6 = r9
            L_0x01d1:
                r0 = r10
                r0.mo5466b(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x01da:
                r6 = r7
                goto L_0x01d1
            L_0x01dc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0207
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x01f7:
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                r10.mo5419a(r1, r0, r2, r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0207:
                r0 = r5
                goto L_0x01f7
            L_0x0209:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5479c(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x021e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                android.os.IBinder r3 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0249
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0241:
                r10.mo5432a(r1, r2, r3, r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0249:
                r0 = r5
                goto L_0x0241
            L_0x024b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                android.os.IBinder r3 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0276
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x026e:
                r10.mo5470b(r1, r2, r3, r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0276:
                r0 = r5
                goto L_0x026e
            L_0x0278:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                android.os.IBinder r4 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x02a0
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x02a0:
                r0 = r10
                r0.mo5425a(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x02a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5491d(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x02be:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5498e(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x02d3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo5537m(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x02e8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo5535l(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x02fd:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                long r1 = r12.readLong()
                r10.mo5417a(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0316:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo5541o(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0327:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                android.os.IBinder r2 = r12.readStrongBinder()
                int r3 = r12.readInt()
                java.lang.String[] r4 = r12.createStringArray()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x034f
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x034f:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0363
                r6 = r9
            L_0x0356:
                long r7 = r12.readLong()
                r0 = r10
                r0.mo5420a(r1, r2, r3, r4, r5, r6, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0363:
                r6 = r7
                goto L_0x0356
            L_0x0365:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                android.os.IBinder r2 = r12.readStrongBinder()
                java.lang.String r3 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x038e
                r4 = r9
            L_0x0381:
                long r5 = r12.readLong()
                r0 = r10
                r0.mo5421a(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x038e:
                r4 = r7
                goto L_0x0381
            L_0x0390:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5483c(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x03a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                byte[] r1 = r12.createByteArray()
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r0 = r10.mo5401a(r0, r1, r2, r3)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x03ce:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                byte[] r0 = r12.createByteArray()
                java.lang.String r1 = r12.readString()
                java.lang.String[] r2 = r12.createStringArray()
                int r0 = r10.mo5458b(r0, r1, r2)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x03eb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r0 = r10.mo5456ay(r0)
                r13.writeNoException()
                r13.writeString(r0)
                goto L_0x000a
            L_0x0400:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                r10.mo5453aU(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0411:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5493d(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x042a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo5433a(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0447:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x046f
                r7 = r9
            L_0x046f:
                r0 = r10
                r0.mo5436a(r1, r2, r3, r4, r5, r6, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0478:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x04a0
                r7 = r9
            L_0x04a0:
                r0 = r10
                r0.mo5472b(r1, r2, r3, r4, r5, r6, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x04a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo5471b(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x04c6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5500e(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x04df:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5503f(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x04f8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0524
                r4 = r9
            L_0x0514:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0526
                r5 = r9
            L_0x051b:
                r0 = r10
                r0.mo5413a(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0524:
                r4 = r7
                goto L_0x0514
            L_0x0526:
                r5 = r7
                goto L_0x051b
            L_0x0528:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0554
                r4 = r9
            L_0x0544:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0556
                r5 = r9
            L_0x054b:
                r0 = r10
                r0.mo5427a(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0554:
                r4 = r7
                goto L_0x0544
            L_0x0556:
                r5 = r7
                goto L_0x054b
            L_0x0558:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x057f
                r0 = r9
            L_0x0570:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0577
                r7 = r9
            L_0x0577:
                r10.mo5462b(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x057f:
                r0 = r7
                goto L_0x0570
            L_0x0581:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5502f(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0596:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x05bd
                r0 = r9
            L_0x05ae:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x05b5
                r7 = r9
            L_0x05b5:
                r10.mo5480c(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x05bd:
                r0 = r7
                goto L_0x05ae
            L_0x05bf:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5524g(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x05d4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                r10.mo5457az(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x05e5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo5477b(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x05fe:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5525g(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0617:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                com.google.android.gms.common.data.DataHolder r0 = r10.mo5526h(r0, r1)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0639
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0639:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x063e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r0 = r10.mo5449aA(r0)
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x0653:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x066b
                r7 = r9
            L_0x066b:
                r10.mo5440a(r0, r1, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0673:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5529i(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x068c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo5540n(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x06a1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                boolean r0 = r10.mo5512fJ()
                r13.writeNoException()
                if (r0 == 0) goto L_0x06b0
                r7 = r9
            L_0x06b0:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x06b5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x06c1
                r7 = r9
            L_0x06c1:
                r10.mo5548y(r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x06c9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5527h(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x06de:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5530j(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x06f7:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                r10.mo5528i(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x070c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0720
                r7 = r9
            L_0x0720:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0736
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x072e:
                r10.mo5446a(r1, r7, r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0736:
                r0 = r5
                goto L_0x072e
            L_0x0738:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.net.Uri r0 = r10.mo5450aB(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0752
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0752:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0757:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0783
                r4 = r9
            L_0x0773:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0785
                r5 = r9
            L_0x077a:
                r0 = r10
                r0.mo5469b(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0783:
                r4 = r7
                goto L_0x0773
            L_0x0785:
                r5 = r7
                goto L_0x077a
            L_0x0787:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                com.google.android.gms.common.data.DataHolder r0 = r10.mo5513fK()
                r13.writeNoException()
                if (r0 == 0) goto L_0x079d
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x079d:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x07a2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x07b6
                r7 = r9
            L_0x07b6:
                r10.mo5445a(r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x07be:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x07da
                r7 = r9
            L_0x07da:
                r10.mo5438a(r0, r1, r2, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x07e2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0809
                r0 = r9
            L_0x07fa:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0801
                r7 = r9
            L_0x0801:
                r10.mo5492d(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0809:
                r0 = r7
                goto L_0x07fa
            L_0x080b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0832
                r0 = r9
            L_0x0823:
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x082a
                r7 = r9
            L_0x082a:
                r10.mo5499e(r1, r2, r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0832:
                r0 = r7
                goto L_0x0823
            L_0x0834:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x086e
                r4 = r9
            L_0x0850:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0870
                r5 = r9
            L_0x0857:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0872
                r6 = r9
            L_0x085e:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0865
                r7 = r9
            L_0x0865:
                r0 = r10
                r0.mo5428a(r1, r2, r3, r4, r5, r6, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x086e:
                r4 = r7
                goto L_0x0850
            L_0x0870:
                r5 = r7
                goto L_0x0857
            L_0x0872:
                r6 = r7
                goto L_0x085e
            L_0x0874:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x088c
                r7 = r9
            L_0x088c:
                r10.mo5474b(r0, r1, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0894:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x08a8
                r7 = r9
            L_0x08a8:
                r10.mo5475b(r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08b0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x08c8
                r7 = r9
            L_0x08c8:
                r10.mo5486c(r0, r1, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08d0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                if (r2 == 0) goto L_0x08e8
                r7 = r9
            L_0x08e8:
                r10.mo5496d(r0, r1, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x08f0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x090c
                r7 = r9
            L_0x090c:
                r10.mo5473b(r0, r1, r2, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0914:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0938
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0927:
                android.os.ParcelFileDescriptor r0 = r10.mo5497e(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x093a
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0938:
                r0 = r5
                goto L_0x0927
            L_0x093a:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x093f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5532k(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0958:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                long r3 = r12.readLong()
                java.lang.String r5 = r12.readString()
                r0 = r10
                r0.mo5431a(r1, r2, r3, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x097a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                android.os.IBinder r4 = r12.readStrongBinder()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x09a2
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x09a2:
                r0 = r10
                r0.mo5467b(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x09ab:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                r0 = r10
                r0.mo5434a(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x09d1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                r10.mo5451aC(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x09e2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int[] r1 = r12.createIntArray()
                r10.mo5447a(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x09fb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                java.lang.String[] r4 = r12.createStringArray()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0a23
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r5 = r0
            L_0x0a23:
                r0 = r10
                r0.mo5414a(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a2c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5534l(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a45:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5536m(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a5e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                byte[] r3 = r12.createByteArray()
                java.lang.String r4 = r12.readString()
                com.google.android.gms.games.multiplayer.ParticipantResultCreator r0 = com.google.android.gms.games.multiplayer.ParticipantResult.CREATOR
                java.lang.Object[] r5 = r12.createTypedArray(r0)
                com.google.android.gms.games.multiplayer.ParticipantResult[] r5 = (com.google.android.gms.games.multiplayer.ParticipantResult[]) r5
                r0 = r10
                r0.mo5441a(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0a88:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                byte[] r3 = r12.createByteArray()
                com.google.android.gms.games.multiplayer.ParticipantResultCreator r0 = com.google.android.gms.games.multiplayer.ParticipantResult.CREATOR
                java.lang.Object[] r0 = r12.createTypedArray(r0)
                com.google.android.gms.games.multiplayer.ParticipantResult[] r0 = (com.google.android.gms.games.multiplayer.ParticipantResult[]) r0
                r10.mo5442a(r1, r2, r3, r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0aad:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5539n(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0ac6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5542o(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0adf:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo5485c(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0afc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                long r1 = r12.readLong()
                r10.mo5463b(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b15:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo5544p(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b26:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5545p(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b3f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo5506fC()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x0b50:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                r10.mo5533k(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b65:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo5495d(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b82:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                r10.mo5501e(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0b9f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int[] r2 = r12.createIntArray()
                r10.mo5443a(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0bbc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo5489c(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0bd5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                long r1 = r12.readLong()
                java.lang.String r3 = r12.readString()
                r10.mo5418a(r0, r1, r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0bf2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                java.lang.String r2 = r12.readString()
                r10.mo5408a(r0, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c07:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                long r1 = r12.readLong()
                java.lang.String r3 = r12.readString()
                r10.mo5464b(r0, r1, r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c24:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                java.lang.String r2 = r12.readString()
                r10.mo5460b(r0, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c39:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                r10.mo5514fL()
                r13.writeNoException()
                goto L_0x000a
            L_0x0c46:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x0c62
                r7 = r9
            L_0x0c62:
                r10.mo5426a(r0, r1, r2, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c6a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r1 = r12.readInt()
                if (r1 == 0) goto L_0x0c7e
                r7 = r9
            L_0x0c7e:
                r10.mo5487c(r0, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x0c86:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0cb2
                r4 = r9
            L_0x0ca2:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0cb4
                r5 = r9
            L_0x0ca9:
                r0 = r10
                r0.mo5484c(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0cb2:
                r4 = r7
                goto L_0x0ca2
            L_0x0cb4:
                r5 = r7
                goto L_0x0ca9
            L_0x0cb6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                r10.mo5547q(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0ccf:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo5518fr()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0ce5
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0ce5:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0cea:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.content.Intent r0 = r10.mo5454au(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d04
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d04:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d09:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo5519fs()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d1f
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d1f:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d24:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo5520ft()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d3a
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d3a:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d3f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo5521fu()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d55
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d55:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d5a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r1 = r12.readInt()
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0d7f
                r0 = r9
            L_0x0d6e:
                android.content.Intent r0 = r10.mo5402a(r1, r2, r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0d81
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0d7f:
                r0 = r7
                goto L_0x0d6e
            L_0x0d81:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0d86:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r1 = r12.readInt()
                int r2 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0dab
                r0 = r9
            L_0x0d9a:
                android.content.Intent r0 = r10.mo5459b(r1, r2, r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0dad
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0dab:
                r0 = r7
                goto L_0x0d9a
            L_0x0dad:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0db2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo5522fy()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0dc8
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0dc8:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0dcd:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0df5
                android.os.Parcelable$Creator<com.google.android.gms.games.multiplayer.realtime.RoomEntity> r0 = com.google.android.gms.games.multiplayer.realtime.RoomEntity.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                com.google.android.gms.games.multiplayer.realtime.RoomEntity r0 = (com.google.android.gms.games.multiplayer.realtime.RoomEntity) r0
            L_0x0de0:
                int r1 = r12.readInt()
                android.content.Intent r0 = r10.mo5404a(r0, r1)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0df7
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0df5:
                r0 = r5
                goto L_0x0de0
            L_0x0df7:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0dfc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo5523fz()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0e12
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0e12:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0e17:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo5515fM()
                r13.writeNoException()
                if (r0 == 0) goto L_0x0e2d
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0e2d:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0e32:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.Parcelable$Creator<com.google.android.gms.games.multiplayer.ParticipantEntity> r0 = com.google.android.gms.games.multiplayer.ParticipantEntity.CREATOR
                java.lang.Object[] r1 = r12.createTypedArray(r0)
                com.google.android.gms.games.multiplayer.ParticipantEntity[] r1 = (com.google.android.gms.games.multiplayer.ParticipantEntity[]) r1
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0e77
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.net.Uri r0 = (android.net.Uri) r0
                r4 = r0
            L_0x0e56:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0e65
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r12)
                android.net.Uri r0 = (android.net.Uri) r0
                r5 = r0
            L_0x0e65:
                r0 = r10
                android.content.Intent r0 = r0.mo5407a(r1, r2, r3, r4, r5)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0e79
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0e77:
                r4 = r5
                goto L_0x0e56
            L_0x0e79:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0e7e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo5504fA()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x0e8f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                int r3 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0ebb
                r4 = r9
            L_0x0eab:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0ebd
                r5 = r9
            L_0x0eb2:
                r0 = r10
                r0.mo5494d(r1, r2, r3, r4, r5)
                r13.writeNoException()
                goto L_0x000a
            L_0x0ebb:
                r4 = r7
                goto L_0x0eab
            L_0x0ebd:
                r5 = r7
                goto L_0x0eb2
            L_0x0ebf:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0eef
                r5 = r9
            L_0x0edf:
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x0ef1
                r6 = r9
            L_0x0ee6:
                r0 = r10
                r0.mo5437a(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x0eef:
                r5 = r7
                goto L_0x0edf
            L_0x0ef1:
                r6 = r7
                goto L_0x0ee6
            L_0x0ef3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                android.os.ParcelFileDescriptor r0 = r10.mo5452aD(r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x0f0d
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x0f0d:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x0f12:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                long r1 = r12.readLong()
                r10.mo5481c(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f2b:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                r10.mo5546q(r0)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f3c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                long r1 = r12.readLong()
                java.lang.String r3 = r12.readString()
                r10.mo5482c(r0, r1, r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f59:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                long r0 = r12.readLong()
                java.lang.String r2 = r12.readString()
                r10.mo5478c(r0, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f6e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String[] r3 = r12.createStringArray()
                int r4 = r12.readInt()
                byte[] r5 = r12.createByteArray()
                int r6 = r12.readInt()
                r0 = r10
                r0.mo5444a(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x0f98:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String[] r1 = r12.createStringArray()
                r10.mo5448a(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0fb1:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String[] r1 = r12.createStringArray()
                r10.mo5476b(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x0fca:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                java.lang.String r2 = r12.readString()
                java.lang.String[] r3 = r12.createStringArray()
                r10.mo5439a(r0, r1, r2, r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x0feb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r1 = r12.readInt()
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                r10.mo5412a(r0, r1, r2, r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x100c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r1 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r2 = r12.readString()
                java.lang.String r3 = r12.readString()
                int r4 = r12.readInt()
                int r5 = r12.readInt()
                int r6 = r12.readInt()
                r0 = r10
                r0.mo5435a(r1, r2, r3, r4, r5, r6)
                r13.writeNoException()
                goto L_0x000a
            L_0x1036:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                r10.mo5423a(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x1053:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                byte[] r1 = r12.createByteArray()
                int r2 = r12.readInt()
                java.lang.String r3 = r12.readString()
                android.content.Intent r0 = r10.mo5403a(r0, r1, r2, r3)
                r13.writeNoException()
                if (r0 == 0) goto L_0x1079
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x1079:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x107e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo5508fE()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x108f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r10.mo5509fF()
                r13.writeNoException()
                r13.writeInt(r0)
                goto L_0x000a
            L_0x10a0:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.content.Intent r0 = r10.mo5507fD()
                r13.writeNoException()
                if (r0 == 0) goto L_0x10b6
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x10b6:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x10bb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x10cc
                com.google.android.gms.internal.ha r0 = com.google.android.gms.internal.C0996gz.CREATOR
                com.google.android.gms.internal.gz r5 = r0.createFromParcel(r12)
            L_0x10cc:
                java.lang.String r0 = r12.readString()
                android.content.Intent r0 = r10.mo5406a(r5, r0)
                r13.writeNoException()
                if (r0 == 0) goto L_0x10e1
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x10e1:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x10e6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                java.lang.String r0 = r12.readString()
                int r1 = r12.readInt()
                r10.mo5543o(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x10fb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r1 = r12.readInt()
                r10.mo5411a(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            L_0x1114:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                int r3 = r12.readInt()
                if (r3 == 0) goto L_0x1130
                r7 = r9
            L_0x1130:
                r10.mo5468b(r0, r1, r2, r7)
                r13.writeNoException()
                goto L_0x000a
            L_0x1138:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                int r0 = r12.readInt()
                if (r0 == 0) goto L_0x1149
                com.google.android.gms.internal.gx r0 = com.google.android.gms.internal.C0995gy.CREATOR
                com.google.android.gms.internal.gy r5 = r0.createFromParcel(r12)
            L_0x1149:
                java.lang.String r0 = r12.readString()
                java.lang.String r1 = r12.readString()
                android.content.Intent r0 = r10.mo5405a(r5, r0, r1)
                r13.writeNoException()
                if (r0 == 0) goto L_0x1162
                r13.writeInt(r9)
                r0.writeToParcel(r13, r9)
                goto L_0x000a
            L_0x1162:
                r13.writeInt(r7)
                goto L_0x000a
            L_0x1167:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                int r1 = r12.readInt()
                int[] r2 = r12.createIntArray()
                r10.mo5416a(r0, r1, r2)
                r13.writeNoException()
                goto L_0x000a
            L_0x1184:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String r1 = r12.readString()
                int r2 = r12.readInt()
                int[] r3 = r12.createIntArray()
                r10.mo5429a(r0, r1, r2, r3)
                r13.writeNoException()
                goto L_0x000a
            L_0x11a5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesService"
                r12.enforceInterface(r0)
                android.os.IBinder r0 = r12.readStrongBinder()
                com.google.android.gms.internal.ga r0 = com.google.android.gms.internal.C0893ga.C0894a.m2448I(r0)
                java.lang.String[] r1 = r12.createStringArray()
                r10.mo5488c(r0, r1)
                r13.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0896gb.C0897a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    int mo5401a(C0893ga gaVar, byte[] bArr, String str, String str2) throws RemoteException;

    /* renamed from: a */
    Intent mo5402a(int i, int i2, boolean z) throws RemoteException;

    /* renamed from: a */
    Intent mo5403a(int i, byte[] bArr, int i2, String str) throws RemoteException;

    /* renamed from: a */
    Intent mo5404a(RoomEntity roomEntity, int i) throws RemoteException;

    /* renamed from: a */
    Intent mo5405a(C0995gy gyVar, String str, String str2) throws RemoteException;

    /* renamed from: a */
    Intent mo5406a(C0996gz gzVar, String str) throws RemoteException;

    /* renamed from: a */
    Intent mo5407a(ParticipantEntity[] participantEntityArr, String str, String str2, Uri uri, Uri uri2) throws RemoteException;

    /* renamed from: a */
    void mo5408a(long j, String str) throws RemoteException;

    /* renamed from: a */
    void mo5409a(IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo5410a(C0893ga gaVar) throws RemoteException;

    /* renamed from: a */
    void mo5411a(C0893ga gaVar, int i) throws RemoteException;

    /* renamed from: a */
    void mo5412a(C0893ga gaVar, int i, int i2, int i3) throws RemoteException;

    /* renamed from: a */
    void mo5413a(C0893ga gaVar, int i, int i2, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo5414a(C0893ga gaVar, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo5415a(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo5416a(C0893ga gaVar, int i, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo5417a(C0893ga gaVar, long j) throws RemoteException;

    /* renamed from: a */
    void mo5418a(C0893ga gaVar, long j, String str) throws RemoteException;

    /* renamed from: a */
    void mo5419a(C0893ga gaVar, Bundle bundle, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo5420a(C0893ga gaVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo5421a(C0893ga gaVar, IBinder iBinder, String str, boolean z, long j) throws RemoteException;

    /* renamed from: a */
    void mo5422a(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo5423a(C0893ga gaVar, String str, int i) throws RemoteException;

    /* renamed from: a */
    void mo5424a(C0893ga gaVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo5425a(C0893ga gaVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo5426a(C0893ga gaVar, String str, int i, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo5427a(C0893ga gaVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo5428a(C0893ga gaVar, String str, int i, boolean z, boolean z2, boolean z3, boolean z4) throws RemoteException;

    /* renamed from: a */
    void mo5429a(C0893ga gaVar, String str, int i, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo5430a(C0893ga gaVar, String str, long j) throws RemoteException;

    /* renamed from: a */
    void mo5431a(C0893ga gaVar, String str, long j, String str2) throws RemoteException;

    /* renamed from: a */
    void mo5432a(C0893ga gaVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo5433a(C0893ga gaVar, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo5434a(C0893ga gaVar, String str, String str2, int i, int i2) throws RemoteException;

    /* renamed from: a */
    void mo5435a(C0893ga gaVar, String str, String str2, int i, int i2, int i3) throws RemoteException;

    /* renamed from: a */
    void mo5436a(C0893ga gaVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo5437a(C0893ga gaVar, String str, String str2, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: a */
    void mo5438a(C0893ga gaVar, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo5439a(C0893ga gaVar, String str, String str2, String[] strArr) throws RemoteException;

    /* renamed from: a */
    void mo5440a(C0893ga gaVar, String str, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo5441a(C0893ga gaVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException;

    /* renamed from: a */
    void mo5442a(C0893ga gaVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException;

    /* renamed from: a */
    void mo5443a(C0893ga gaVar, String str, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo5444a(C0893ga gaVar, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException;

    /* renamed from: a */
    void mo5445a(C0893ga gaVar, boolean z) throws RemoteException;

    /* renamed from: a */
    void mo5446a(C0893ga gaVar, boolean z, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo5447a(C0893ga gaVar, int[] iArr) throws RemoteException;

    /* renamed from: a */
    void mo5448a(C0893ga gaVar, String[] strArr) throws RemoteException;

    /* renamed from: aA */
    int mo5449aA(String str) throws RemoteException;

    /* renamed from: aB */
    Uri mo5450aB(String str) throws RemoteException;

    /* renamed from: aC */
    void mo5451aC(String str) throws RemoteException;

    /* renamed from: aD */
    ParcelFileDescriptor mo5452aD(String str) throws RemoteException;

    /* renamed from: aU */
    void mo5453aU(int i) throws RemoteException;

    /* renamed from: au */
    Intent mo5454au(String str) throws RemoteException;

    /* renamed from: ax */
    String mo5455ax(String str) throws RemoteException;

    /* renamed from: ay */
    String mo5456ay(String str) throws RemoteException;

    /* renamed from: az */
    void mo5457az(String str) throws RemoteException;

    /* renamed from: b */
    int mo5458b(byte[] bArr, String str, String[] strArr) throws RemoteException;

    /* renamed from: b */
    Intent mo5459b(int i, int i2, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo5460b(long j, String str) throws RemoteException;

    /* renamed from: b */
    void mo5461b(C0893ga gaVar) throws RemoteException;

    /* renamed from: b */
    void mo5462b(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo5463b(C0893ga gaVar, long j) throws RemoteException;

    /* renamed from: b */
    void mo5464b(C0893ga gaVar, long j, String str) throws RemoteException;

    /* renamed from: b */
    void mo5465b(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: b */
    void mo5466b(C0893ga gaVar, String str, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo5467b(C0893ga gaVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo5468b(C0893ga gaVar, String str, int i, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo5469b(C0893ga gaVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: b */
    void mo5470b(C0893ga gaVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException;

    /* renamed from: b */
    void mo5471b(C0893ga gaVar, String str, String str2) throws RemoteException;

    /* renamed from: b */
    void mo5472b(C0893ga gaVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo5473b(C0893ga gaVar, String str, String str2, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo5474b(C0893ga gaVar, String str, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo5475b(C0893ga gaVar, boolean z) throws RemoteException;

    /* renamed from: b */
    void mo5476b(C0893ga gaVar, String[] strArr) throws RemoteException;

    /* renamed from: b */
    void mo5477b(String str, String str2, int i) throws RemoteException;

    /* renamed from: c */
    void mo5478c(long j, String str) throws RemoteException;

    /* renamed from: c */
    void mo5479c(C0893ga gaVar) throws RemoteException;

    /* renamed from: c */
    void mo5480c(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: c */
    void mo5481c(C0893ga gaVar, long j) throws RemoteException;

    /* renamed from: c */
    void mo5482c(C0893ga gaVar, long j, String str) throws RemoteException;

    /* renamed from: c */
    void mo5483c(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: c */
    void mo5484c(C0893ga gaVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: c */
    void mo5485c(C0893ga gaVar, String str, String str2) throws RemoteException;

    /* renamed from: c */
    void mo5486c(C0893ga gaVar, String str, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo5487c(C0893ga gaVar, boolean z) throws RemoteException;

    /* renamed from: c */
    void mo5488c(C0893ga gaVar, String[] strArr) throws RemoteException;

    /* renamed from: c */
    void mo5489c(String str, String str2, int i) throws RemoteException;

    /* renamed from: cY */
    Bundle mo5490cY() throws RemoteException;

    /* renamed from: d */
    void mo5491d(C0893ga gaVar) throws RemoteException;

    /* renamed from: d */
    void mo5492d(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: d */
    void mo5493d(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: d */
    void mo5494d(C0893ga gaVar, String str, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: d */
    void mo5495d(C0893ga gaVar, String str, String str2) throws RemoteException;

    /* renamed from: d */
    void mo5496d(C0893ga gaVar, String str, boolean z) throws RemoteException;

    /* renamed from: e */
    ParcelFileDescriptor mo5497e(Uri uri) throws RemoteException;

    /* renamed from: e */
    void mo5498e(C0893ga gaVar) throws RemoteException;

    /* renamed from: e */
    void mo5499e(C0893ga gaVar, int i, boolean z, boolean z2) throws RemoteException;

    /* renamed from: e */
    void mo5500e(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: e */
    void mo5501e(C0893ga gaVar, String str, String str2) throws RemoteException;

    /* renamed from: f */
    void mo5502f(C0893ga gaVar) throws RemoteException;

    /* renamed from: f */
    void mo5503f(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: fA */
    int mo5504fA() throws RemoteException;

    /* renamed from: fB */
    String mo5505fB() throws RemoteException;

    /* renamed from: fC */
    int mo5506fC() throws RemoteException;

    /* renamed from: fD */
    Intent mo5507fD() throws RemoteException;

    /* renamed from: fE */
    int mo5508fE() throws RemoteException;

    /* renamed from: fF */
    int mo5509fF() throws RemoteException;

    /* renamed from: fH */
    void mo5510fH() throws RemoteException;

    /* renamed from: fI */
    DataHolder mo5511fI() throws RemoteException;

    /* renamed from: fJ */
    boolean mo5512fJ() throws RemoteException;

    /* renamed from: fK */
    DataHolder mo5513fK() throws RemoteException;

    /* renamed from: fL */
    void mo5514fL() throws RemoteException;

    /* renamed from: fM */
    Intent mo5515fM() throws RemoteException;

    /* renamed from: fn */
    String mo5516fn() throws RemoteException;

    /* renamed from: fo */
    String mo5517fo() throws RemoteException;

    /* renamed from: fr */
    Intent mo5518fr() throws RemoteException;

    /* renamed from: fs */
    Intent mo5519fs() throws RemoteException;

    /* renamed from: ft */
    Intent mo5520ft() throws RemoteException;

    /* renamed from: fu */
    Intent mo5521fu() throws RemoteException;

    /* renamed from: fy */
    Intent mo5522fy() throws RemoteException;

    /* renamed from: fz */
    Intent mo5523fz() throws RemoteException;

    /* renamed from: g */
    void mo5524g(C0893ga gaVar) throws RemoteException;

    /* renamed from: g */
    void mo5525g(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: h */
    DataHolder mo5526h(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: h */
    void mo5527h(C0893ga gaVar) throws RemoteException;

    /* renamed from: i */
    void mo5528i(C0893ga gaVar) throws RemoteException;

    /* renamed from: i */
    void mo5529i(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: j */
    void mo5530j(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: j */
    void mo5531j(String str, String str2) throws RemoteException;

    /* renamed from: k */
    void mo5532k(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: k */
    void mo5533k(String str, String str2) throws RemoteException;

    /* renamed from: l */
    void mo5534l(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: l */
    void mo5535l(String str, int i) throws RemoteException;

    /* renamed from: m */
    void mo5536m(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: m */
    void mo5537m(String str, int i) throws RemoteException;

    /* renamed from: n */
    void mo5538n(long j) throws RemoteException;

    /* renamed from: n */
    void mo5539n(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: n */
    void mo5540n(String str, int i) throws RemoteException;

    /* renamed from: o */
    void mo5541o(long j) throws RemoteException;

    /* renamed from: o */
    void mo5542o(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: o */
    void mo5543o(String str, int i) throws RemoteException;

    /* renamed from: p */
    void mo5544p(long j) throws RemoteException;

    /* renamed from: p */
    void mo5545p(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: q */
    void mo5546q(long j) throws RemoteException;

    /* renamed from: q */
    void mo5547q(C0893ga gaVar, String str) throws RemoteException;

    /* renamed from: y */
    void mo5548y(boolean z) throws RemoteException;
}
