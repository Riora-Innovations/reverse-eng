package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C0453b;
import com.google.android.gms.dynamic.C0453b.C0454a;

/* renamed from: com.google.android.gms.internal.bg */
public interface C0557bg extends IInterface {

    /* renamed from: com.google.android.gms.internal.bg$a */
    public static abstract class C0558a extends Binder implements C0557bg {

        /* renamed from: com.google.android.gms.internal.bg$a$a */
        private static class C0559a implements C0557bg {

            /* renamed from: ky */
            private IBinder f1495ky;

            C0559a(IBinder iBinder) {
                this.f1495ky = iBinder;
            }

            /* renamed from: a */
            public void mo4606a(C0453b bVar, C0504ab abVar, C1173z zVar, String str, C0560bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zVar != null) {
                        obtain.writeInt(1);
                        zVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f1495ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4607a(C0453b bVar, C0504ab abVar, C1173z zVar, String str, String str2, C0560bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (abVar != null) {
                        obtain.writeInt(1);
                        abVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zVar != null) {
                        obtain.writeInt(1);
                        zVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f1495ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4608a(C0453b bVar, C1173z zVar, String str, C0560bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (zVar != null) {
                        obtain.writeInt(1);
                        zVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f1495ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo4609a(C0453b bVar, C1173z zVar, String str, String str2, C0560bh bhVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    if (zVar != null) {
                        obtain.writeInt(1);
                        zVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bhVar != null) {
                        iBinder = bhVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f1495ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f1495ky;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1495ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public C0453b getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1495ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return C0454a.m999G(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.f1495ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C0558a() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        /* renamed from: j */
        public static C0557bg m1264j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0557bg)) ? new C0559a(iBinder) : (C0557bg) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.internal.z] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.internal.z] */
        /* JADX WARNING: type inference failed for: r0v17, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v19, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v27 */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.os.IBinder, com.google.android.gms.internal.z]
          uses: [com.google.android.gms.internal.z, android.os.IBinder]
          mth insns count: 101
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
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
            /*
                r8 = this;
                r0 = 0
                r7 = 1
                switch(r9) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x004f;
                    case 3: goto L_0x0066;
                    case 4: goto L_0x0094;
                    case 5: goto L_0x00a2;
                    case 6: goto L_0x00b0;
                    case 7: goto L_0x00f3;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r9, r10, r11, r12)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.writeString(r0)
                r0 = r7
                goto L_0x0009
            L_0x0011:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.dynamic.b r1 = com.google.android.gms.dynamic.C0453b.C0454a.m999G(r1)
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x004b
                com.google.android.gms.internal.ac r2 = com.google.android.gms.internal.C0504ab.CREATOR
                com.google.android.gms.internal.ab r2 = r2.createFromParcel(r10)
            L_0x002a:
                int r3 = r10.readInt()
                if (r3 == 0) goto L_0x004d
                com.google.android.gms.internal.aa r0 = com.google.android.gms.internal.C1173z.CREATOR
                com.google.android.gms.internal.z r3 = r0.createFromParcel(r10)
            L_0x0036:
                java.lang.String r4 = r10.readString()
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bh r5 = com.google.android.gms.internal.C0560bh.C0561a.m1270k(r0)
                r0 = r8
                r0.mo4606a(r1, r2, r3, r4, r5)
                r11.writeNoException()
                r0 = r7
                goto L_0x0009
            L_0x004b:
                r2 = r0
                goto L_0x002a
            L_0x004d:
                r3 = r0
                goto L_0x0036
            L_0x004f:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r10.enforceInterface(r1)
                com.google.android.gms.dynamic.b r1 = r8.getView()
                r11.writeNoException()
                if (r1 == 0) goto L_0x0061
                android.os.IBinder r0 = r1.asBinder()
            L_0x0061:
                r11.writeStrongBinder(r0)
                r0 = r7
                goto L_0x0009
            L_0x0066:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.dynamic.b r1 = com.google.android.gms.dynamic.C0453b.C0454a.m999G(r1)
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x007f
                com.google.android.gms.internal.aa r0 = com.google.android.gms.internal.C1173z.CREATOR
                com.google.android.gms.internal.z r0 = r0.createFromParcel(r10)
            L_0x007f:
                java.lang.String r2 = r10.readString()
                android.os.IBinder r3 = r10.readStrongBinder()
                com.google.android.gms.internal.bh r3 = com.google.android.gms.internal.C0560bh.C0561a.m1270k(r3)
                r8.mo4608a(r1, r0, r2, r3)
                r11.writeNoException()
                r0 = r7
                goto L_0x0009
            L_0x0094:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r10.enforceInterface(r0)
                r8.showInterstitial()
                r11.writeNoException()
                r0 = r7
                goto L_0x0009
            L_0x00a2:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r10.enforceInterface(r0)
                r8.destroy()
                r11.writeNoException()
                r0 = r7
                goto L_0x0009
            L_0x00b0:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.dynamic.b r1 = com.google.android.gms.dynamic.C0453b.C0454a.m999G(r1)
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x00ef
                com.google.android.gms.internal.ac r2 = com.google.android.gms.internal.C0504ab.CREATOR
                com.google.android.gms.internal.ab r2 = r2.createFromParcel(r10)
            L_0x00c9:
                int r3 = r10.readInt()
                if (r3 == 0) goto L_0x00f1
                com.google.android.gms.internal.aa r0 = com.google.android.gms.internal.C1173z.CREATOR
                com.google.android.gms.internal.z r3 = r0.createFromParcel(r10)
            L_0x00d5:
                java.lang.String r4 = r10.readString()
                java.lang.String r5 = r10.readString()
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bh r6 = com.google.android.gms.internal.C0560bh.C0561a.m1270k(r0)
                r0 = r8
                r0.mo4607a(r1, r2, r3, r4, r5, r6)
                r11.writeNoException()
                r0 = r7
                goto L_0x0009
            L_0x00ef:
                r2 = r0
                goto L_0x00c9
            L_0x00f1:
                r3 = r0
                goto L_0x00d5
            L_0x00f3:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r10.enforceInterface(r1)
                android.os.IBinder r1 = r10.readStrongBinder()
                com.google.android.gms.dynamic.b r1 = com.google.android.gms.dynamic.C0453b.C0454a.m999G(r1)
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x0126
                com.google.android.gms.internal.aa r0 = com.google.android.gms.internal.C1173z.CREATOR
                com.google.android.gms.internal.z r2 = r0.createFromParcel(r10)
            L_0x010c:
                java.lang.String r3 = r10.readString()
                java.lang.String r4 = r10.readString()
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.internal.bh r5 = com.google.android.gms.internal.C0560bh.C0561a.m1270k(r0)
                r0 = r8
                r0.mo4609a(r1, r2, r3, r4, r5)
                r11.writeNoException()
                r0 = r7
                goto L_0x0009
            L_0x0126:
                r2 = r0
                goto L_0x010c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0557bg.C0558a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    void mo4606a(C0453b bVar, C0504ab abVar, C1173z zVar, String str, C0560bh bhVar) throws RemoteException;

    /* renamed from: a */
    void mo4607a(C0453b bVar, C0504ab abVar, C1173z zVar, String str, String str2, C0560bh bhVar) throws RemoteException;

    /* renamed from: a */
    void mo4608a(C0453b bVar, C1173z zVar, String str, C0560bh bhVar) throws RemoteException;

    /* renamed from: a */
    void mo4609a(C0453b bVar, C1173z zVar, String str, String str2, C0560bh bhVar) throws RemoteException;

    void destroy() throws RemoteException;

    C0453b getView() throws RemoteException;

    void showInterstitial() throws RemoteException;
}
