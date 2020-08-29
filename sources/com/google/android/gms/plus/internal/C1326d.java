package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.C0802fh;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.d */
public interface C1326d extends IInterface {

    /* renamed from: com.google.android.gms.plus.internal.d$a */
    public static abstract class C1327a extends Binder implements C1326d {

        /* renamed from: com.google.android.gms.plus.internal.d$a$a */
        private static class C1328a implements C1326d {

            /* renamed from: ky */
            private IBinder f3425ky;

            C1328a(IBinder iBinder) {
                this.f3425ky = iBinder;
            }

            /* renamed from: a */
            public void mo7372a(C0802fh fhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (fhVar != null) {
                        obtain.writeInt(1);
                        fhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3425ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7373a(C1320b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f3425ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7374a(C1320b bVar, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.f3425ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7375a(C1320b bVar, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f3425ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7376a(C1320b bVar, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3425ky.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7377a(C1320b bVar, C0802fh fhVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (fhVar != null) {
                        obtain.writeInt(1);
                        fhVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f3425ky.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7378a(C1320b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f3425ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7379a(C1320b bVar, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f3425ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo7380a(C1320b bVar, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeStringList(list);
                    this.f3425ky.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f3425ky;
            }

            /* renamed from: b */
            public void mo7381b(C1320b bVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.f3425ky.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: b */
            public void mo7382b(C1320b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f3425ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: c */
            public void mo7383c(C1320b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f3425ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearDefaultAccount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f3425ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: d */
            public void mo7385d(C1320b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f3425ky.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: e */
            public void mo7386e(C1320b bVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    obtain.writeString(str);
                    this.f3425ky.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f3425ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: hl */
            public String mo7388hl() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f3425ky.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: hm */
            public boolean mo7389hm() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f3425ky.transact(42, obtain, obtain2, 0);
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

            /* renamed from: hn */
            public String mo7390hn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.f3425ky.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void removeMoment(String momentId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(momentId);
                    this.f3425ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: aA */
        public static C1326d m3858aA(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C1326d)) ? new C1328a(iBinder) : (C1326d) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r4v0 */
        /* JADX WARNING: type inference failed for: r4v1, types: [com.google.android.gms.internal.fh] */
        /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.fh] */
        /* JADX WARNING: type inference failed for: r4v4, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v38, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r4v5 */
        /* JADX WARNING: type inference failed for: r4v6 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r4v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], ?[OBJECT, ARRAY], com.google.android.gms.internal.fh]
          uses: [com.google.android.gms.internal.fh, android.net.Uri]
          mth insns count: 188
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
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
            /*
                r8 = this;
                r4 = 0
                r7 = 1
                switch(r9) {
                    case 1: goto L_0x0010;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x0044;
                    case 4: goto L_0x005c;
                    case 5: goto L_0x0076;
                    case 6: goto L_0x0086;
                    case 8: goto L_0x0093;
                    case 9: goto L_0x00a8;
                    case 14: goto L_0x00de;
                    case 16: goto L_0x0113;
                    case 17: goto L_0x0139;
                    case 18: goto L_0x014a;
                    case 19: goto L_0x0163;
                    case 34: goto L_0x0178;
                    case 40: goto L_0x0191;
                    case 41: goto L_0x01aa;
                    case 42: goto L_0x01bb;
                    case 43: goto L_0x01d1;
                    case 44: goto L_0x01e2;
                    case 45: goto L_0x01fb;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r7 = super.onTransact(r9, r10, r11, r12)
            L_0x0009:
                return r7
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r11.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                java.lang.String r1 = r10.readString()
                r8.mo7378a(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x0028:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                java.lang.String r1 = r10.readString()
                java.lang.String r2 = r10.readString()
                r8.mo7379a(r0, r1, r2)
                r11.writeNoException()
                goto L_0x0009
            L_0x0044:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                java.lang.String r1 = r10.readString()
                r8.mo7382b(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x005c:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0074
                com.google.android.gms.internal.fi r0 = com.google.android.gms.internal.C0802fh.CREATOR
                com.google.android.gms.internal.fh r0 = r0.createFromParcel(r10)
            L_0x006d:
                r8.mo7372a(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x0074:
                r0 = r4
                goto L_0x006d
            L_0x0076:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.getAccountName()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x0086:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                r8.clearDefaultAccount()
                r11.writeNoException()
                goto L_0x0009
            L_0x0093:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                r8.mo7373a(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x00a8:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r2 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00da
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r1 = r0
            L_0x00c4:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00dc
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00d2:
                r8.mo7376a(r2, r1, r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x00da:
                r1 = r4
                goto L_0x00c4
            L_0x00dc:
                r0 = r4
                goto L_0x00d2
            L_0x00de:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r1 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0102
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r4 = r0
            L_0x0102:
                java.lang.String r5 = r10.readString()
                java.lang.String r6 = r10.readString()
                r0 = r8
                r0.mo7375a(r1, r2, r3, r4, r5, r6)
                r11.writeNoException()
                goto L_0x0009
            L_0x0113:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r1 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                int r2 = r10.readInt()
                int r3 = r10.readInt()
                int r4 = r10.readInt()
                java.lang.String r5 = r10.readString()
                r0 = r8
                r0.mo7374a(r1, r2, r3, r4, r5)
                r11.writeNoException()
                goto L_0x0009
            L_0x0139:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r10.readString()
                r8.removeMoment(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x014a:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                java.lang.String r1 = r10.readString()
                r8.mo7383c(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x0163:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                r8.mo7381b(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x0178:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                java.util.ArrayList r1 = r10.createStringArrayList()
                r8.mo7380a(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x0191:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                java.lang.String r1 = r10.readString()
                r8.mo7385d(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x01aa:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.mo7388hl()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x01bb:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                boolean r0 = r8.mo7389hm()
                r11.writeNoException()
                if (r0 == 0) goto L_0x01cf
                r0 = r7
            L_0x01ca:
                r11.writeInt(r0)
                goto L_0x0009
            L_0x01cf:
                r0 = 0
                goto L_0x01ca
            L_0x01d1:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.mo7390hn()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x01e2:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                java.lang.String r1 = r10.readString()
                r8.mo7386e(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x01fb:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.b r0 = com.google.android.gms.plus.internal.C1320b.C1321a.m3825ay(r0)
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x0214
                com.google.android.gms.internal.fi r1 = com.google.android.gms.internal.C0802fh.CREATOR
                com.google.android.gms.internal.fh r4 = r1.createFromParcel(r10)
            L_0x0214:
                r8.mo7377a(r0, r4)
                r11.writeNoException()
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.plus.internal.C1326d.C1327a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo7372a(C0802fh fhVar) throws RemoteException;

    /* renamed from: a */
    void mo7373a(C1320b bVar) throws RemoteException;

    /* renamed from: a */
    void mo7374a(C1320b bVar, int i, int i2, int i3, String str) throws RemoteException;

    /* renamed from: a */
    void mo7375a(C1320b bVar, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    /* renamed from: a */
    void mo7376a(C1320b bVar, Uri uri, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo7377a(C1320b bVar, C0802fh fhVar) throws RemoteException;

    /* renamed from: a */
    void mo7378a(C1320b bVar, String str) throws RemoteException;

    /* renamed from: a */
    void mo7379a(C1320b bVar, String str, String str2) throws RemoteException;

    /* renamed from: a */
    void mo7380a(C1320b bVar, List<String> list) throws RemoteException;

    /* renamed from: b */
    void mo7381b(C1320b bVar) throws RemoteException;

    /* renamed from: b */
    void mo7382b(C1320b bVar, String str) throws RemoteException;

    /* renamed from: c */
    void mo7383c(C1320b bVar, String str) throws RemoteException;

    void clearDefaultAccount() throws RemoteException;

    /* renamed from: d */
    void mo7385d(C1320b bVar, String str) throws RemoteException;

    /* renamed from: e */
    void mo7386e(C1320b bVar, String str) throws RemoteException;

    String getAccountName() throws RemoteException;

    /* renamed from: hl */
    String mo7388hl() throws RemoteException;

    /* renamed from: hm */
    boolean mo7389hm() throws RemoteException;

    /* renamed from: hn */
    String mo7390hn() throws RemoteException;

    void removeMoment(String str) throws RemoteException;
}
