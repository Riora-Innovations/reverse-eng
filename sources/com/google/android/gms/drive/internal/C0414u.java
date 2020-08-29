package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.drive.internal.u */
public interface C0414u extends IInterface {

    /* renamed from: com.google.android.gms.drive.internal.u$a */
    public static abstract class C0415a extends Binder implements C0414u {

        /* renamed from: com.google.android.gms.drive.internal.u$a$a */
        private static class C0416a implements C0414u {

            /* renamed from: ky */
            private IBinder f799ky;

            C0416a(IBinder iBinder) {
                this.f799ky = iBinder;
            }

            /* renamed from: a */
            public IntentSender mo3767a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f799ky.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public IntentSender mo3768a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f799ky.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3769a(AddEventListenerRequest addEventListenerRequest, C0420w wVar, String str, C0417v vVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(wVar != null ? wVar.asBinder() : null);
                    obtain.writeString(str);
                    if (vVar != null) {
                        iBinder = vVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f799ky.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3770a(AuthorizeAccessRequest authorizeAccessRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3771a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3772a(CloseContentsRequest closeContentsRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3773a(CreateContentsRequest createContentsRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3774a(CreateFileRequest createFileRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3775a(CreateFolderRequest createFolderRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3776a(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f799ky.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3777a(GetMetadataRequest getMetadataRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3778a(ListParentsRequest listParentsRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3779a(OpenContentsRequest openContentsRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3780a(QueryRequest queryRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3781a(RemoveEventListenerRequest removeEventListenerRequest, C0420w wVar, String str, C0417v vVar) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(wVar != null ? wVar.asBinder() : null);
                    obtain.writeString(str);
                    if (vVar != null) {
                        iBinder = vVar.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f799ky.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3782a(TrashResourceRequest trashResourceRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3783a(UpdateMetadataRequest updateMetadataRequest, C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* renamed from: a */
            public void mo3784a(C0417v vVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(vVar != null ? vVar.asBinder() : null);
                    this.f799ky.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f799ky;
            }
        }

        /* renamed from: D */
        public static C0414u m837D(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof C0414u)) ? new C0416a(iBinder) : (C0414u) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.drive.internal.TrashResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.drive.internal.TrashResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.drive.internal.DisconnectRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.drive.internal.DisconnectRequest] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.drive.internal.RemoveEventListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.drive.internal.RemoveEventListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.android.gms.drive.internal.AddEventListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.drive.internal.AddEventListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v26, types: [com.google.android.gms.drive.internal.ListParentsRequest] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.drive.internal.ListParentsRequest] */
        /* JADX WARNING: type inference failed for: r0v31, types: [com.google.android.gms.drive.internal.AuthorizeAccessRequest] */
        /* JADX WARNING: type inference failed for: r0v35, types: [com.google.android.gms.drive.internal.AuthorizeAccessRequest] */
        /* JADX WARNING: type inference failed for: r0v36, types: [com.google.android.gms.drive.internal.CreateFileIntentSenderRequest] */
        /* JADX WARNING: type inference failed for: r0v41, types: [com.google.android.gms.drive.internal.CreateFileIntentSenderRequest] */
        /* JADX WARNING: type inference failed for: r0v42, types: [com.google.android.gms.drive.internal.OpenFileIntentSenderRequest] */
        /* JADX WARNING: type inference failed for: r0v47, types: [com.google.android.gms.drive.internal.OpenFileIntentSenderRequest] */
        /* JADX WARNING: type inference failed for: r0v52, types: [com.google.android.gms.drive.internal.CloseContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v56, types: [com.google.android.gms.drive.internal.CloseContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v57, types: [com.google.android.gms.drive.internal.OpenContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v61, types: [com.google.android.gms.drive.internal.OpenContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v62, types: [com.google.android.gms.drive.internal.CreateFolderRequest] */
        /* JADX WARNING: type inference failed for: r0v66, types: [com.google.android.gms.drive.internal.CreateFolderRequest] */
        /* JADX WARNING: type inference failed for: r0v67, types: [com.google.android.gms.drive.internal.CreateFileRequest] */
        /* JADX WARNING: type inference failed for: r0v71, types: [com.google.android.gms.drive.internal.CreateFileRequest] */
        /* JADX WARNING: type inference failed for: r0v72, types: [com.google.android.gms.drive.internal.CreateContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v76, types: [com.google.android.gms.drive.internal.CreateContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v77, types: [com.google.android.gms.drive.internal.UpdateMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v81, types: [com.google.android.gms.drive.internal.UpdateMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v82, types: [com.google.android.gms.drive.internal.QueryRequest] */
        /* JADX WARNING: type inference failed for: r0v86, types: [com.google.android.gms.drive.internal.QueryRequest] */
        /* JADX WARNING: type inference failed for: r0v87, types: [com.google.android.gms.drive.internal.GetMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v91, types: [com.google.android.gms.drive.internal.GetMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v95 */
        /* JADX WARNING: type inference failed for: r0v96 */
        /* JADX WARNING: type inference failed for: r0v97 */
        /* JADX WARNING: type inference failed for: r0v98 */
        /* JADX WARNING: type inference failed for: r0v99 */
        /* JADX WARNING: type inference failed for: r0v100 */
        /* JADX WARNING: type inference failed for: r0v101 */
        /* JADX WARNING: type inference failed for: r0v102 */
        /* JADX WARNING: type inference failed for: r0v103 */
        /* JADX WARNING: type inference failed for: r0v104 */
        /* JADX WARNING: type inference failed for: r0v105 */
        /* JADX WARNING: type inference failed for: r0v106 */
        /* JADX WARNING: type inference failed for: r0v107 */
        /* JADX WARNING: type inference failed for: r0v108 */
        /* JADX WARNING: type inference failed for: r0v109 */
        /* JADX WARNING: type inference failed for: r0v110 */
        /* JADX WARNING: type inference failed for: r0v111 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.DisconnectRequest, com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.CreateFileIntentSenderRequest, com.google.android.gms.drive.internal.OpenFileIntentSenderRequest, com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.GetMetadataRequest]
          uses: [com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.DisconnectRequest, com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.CreateFileIntentSenderRequest, com.google.android.gms.drive.internal.OpenFileIntentSenderRequest, com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.GetMetadataRequest]
          mth insns count: 243
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
        /* JADX WARNING: Unknown variable types count: 18 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r3 = 0
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 1: goto L_0x0012;
                    case 2: goto L_0x0035;
                    case 3: goto L_0x0058;
                    case 4: goto L_0x007b;
                    case 5: goto L_0x009f;
                    case 6: goto L_0x00c3;
                    case 7: goto L_0x00e7;
                    case 8: goto L_0x010b;
                    case 9: goto L_0x012f;
                    case 10: goto L_0x0145;
                    case 11: goto L_0x016e;
                    case 12: goto L_0x0197;
                    case 13: goto L_0x01bb;
                    case 14: goto L_0x01df;
                    case 15: goto L_0x020f;
                    case 16: goto L_0x023f;
                    case 17: goto L_0x025b;
                    case 18: goto L_0x027f;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x000a:
                return r0
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r8.writeString(r0)
                r0 = r1
                goto L_0x000a
            L_0x0012:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0025
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetMetadataRequest> r0 = com.google.android.gms.drive.internal.GetMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetMetadataRequest r0 = (com.google.android.gms.drive.internal.GetMetadataRequest) r0
            L_0x0025:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3777a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0035:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0048
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x0048:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3780a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0058:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x006b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.UpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UpdateMetadataRequest r0 = (com.google.android.gms.drive.internal.UpdateMetadataRequest) r0
            L_0x006b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3783a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x007b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x008e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateContentsRequest> r0 = com.google.android.gms.drive.internal.CreateContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateContentsRequest r0 = (com.google.android.gms.drive.internal.CreateContentsRequest) r0
            L_0x008e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3773a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x009f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00b2
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileRequest> r0 = com.google.android.gms.drive.internal.CreateFileRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileRequest r0 = (com.google.android.gms.drive.internal.CreateFileRequest) r0
            L_0x00b2:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3774a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x00c3:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00d6
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFolderRequest> r0 = com.google.android.gms.drive.internal.CreateFolderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFolderRequest r0 = (com.google.android.gms.drive.internal.CreateFolderRequest) r0
            L_0x00d6:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3775a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x00e7:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00fa
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenContentsRequest> r0 = com.google.android.gms.drive.internal.OpenContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenContentsRequest r0 = (com.google.android.gms.drive.internal.OpenContentsRequest) r0
            L_0x00fa:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3779a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x010b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x011e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsRequest> r0 = com.google.android.gms.drive.internal.CloseContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CloseContentsRequest r0 = (com.google.android.gms.drive.internal.CloseContentsRequest) r0
            L_0x011e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3772a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x012f:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r0 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r0)
                r5.mo3784a(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0145:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0158
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenFileIntentSenderRequest> r0 = com.google.android.gms.drive.internal.OpenFileIntentSenderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenFileIntentSenderRequest r0 = (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) r0
            L_0x0158:
                android.content.IntentSender r0 = r5.mo3768a(r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x016a
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0167:
                r0 = r1
                goto L_0x000a
            L_0x016a:
                r8.writeInt(r3)
                goto L_0x0167
            L_0x016e:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0181
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileIntentSenderRequest> r0 = com.google.android.gms.drive.internal.CreateFileIntentSenderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileIntentSenderRequest r0 = (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) r0
            L_0x0181:
                android.content.IntentSender r0 = r5.mo3767a(r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x0193
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0190:
                r0 = r1
                goto L_0x000a
            L_0x0193:
                r8.writeInt(r3)
                goto L_0x0190
            L_0x0197:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01aa
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AuthorizeAccessRequest> r0 = com.google.android.gms.drive.internal.AuthorizeAccessRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AuthorizeAccessRequest r0 = (com.google.android.gms.drive.internal.AuthorizeAccessRequest) r0
            L_0x01aa:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3770a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01bb:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01ce
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ListParentsRequest> r0 = com.google.android.gms.drive.internal.ListParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.ListParentsRequest r0 = (com.google.android.gms.drive.internal.ListParentsRequest) r0
            L_0x01ce:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3778a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01df:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01f2
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AddEventListenerRequest> r0 = com.google.android.gms.drive.internal.AddEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AddEventListenerRequest r0 = (com.google.android.gms.drive.internal.AddEventListenerRequest) r0
            L_0x01f2:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.w r2 = com.google.android.gms.drive.internal.C0420w.C0421a.m872F(r2)
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r4 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r4)
                r5.mo3769a(r0, r2, r3, r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x020f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0222
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.RemoveEventListenerRequest> r0 = com.google.android.gms.drive.internal.RemoveEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.RemoveEventListenerRequest r0 = (com.google.android.gms.drive.internal.RemoveEventListenerRequest) r0
            L_0x0222:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.w r2 = com.google.android.gms.drive.internal.C0420w.C0421a.m872F(r2)
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r4 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r4)
                r5.mo3781a(r0, r2, r3, r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x023f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0252
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DisconnectRequest> r0 = com.google.android.gms.drive.internal.DisconnectRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.DisconnectRequest r0 = (com.google.android.gms.drive.internal.DisconnectRequest) r0
            L_0x0252:
                r5.mo3776a(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x025b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x026e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.TrashResourceRequest> r0 = com.google.android.gms.drive.internal.TrashResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.TrashResourceRequest r0 = (com.google.android.gms.drive.internal.TrashResourceRequest) r0
            L_0x026e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3782a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x027f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0292
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest r0 = (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest) r0
            L_0x0292:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.v r2 = com.google.android.gms.drive.internal.C0417v.C0418a.m863E(r2)
                r5.mo3771a(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.C0414u.C0415a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    /* renamed from: a */
    IntentSender mo3767a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    /* renamed from: a */
    IntentSender mo3768a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    /* renamed from: a */
    void mo3769a(AddEventListenerRequest addEventListenerRequest, C0420w wVar, String str, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3770a(AuthorizeAccessRequest authorizeAccessRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3771a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3772a(CloseContentsRequest closeContentsRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3773a(CreateContentsRequest createContentsRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3774a(CreateFileRequest createFileRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3775a(CreateFolderRequest createFolderRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3776a(DisconnectRequest disconnectRequest) throws RemoteException;

    /* renamed from: a */
    void mo3777a(GetMetadataRequest getMetadataRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3778a(ListParentsRequest listParentsRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3779a(OpenContentsRequest openContentsRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3780a(QueryRequest queryRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3781a(RemoveEventListenerRequest removeEventListenerRequest, C0420w wVar, String str, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3782a(TrashResourceRequest trashResourceRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3783a(UpdateMetadataRequest updateMetadataRequest, C0417v vVar) throws RemoteException;

    /* renamed from: a */
    void mo3784a(C0417v vVar) throws RemoteException;
}
