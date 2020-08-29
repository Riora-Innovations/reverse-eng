package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.drive.internal.ak */
public class C0348ak extends C0352c {

    /* renamed from: vj */
    private final C0299c<Status> f723vj;

    public C0348ak(C0299c<Status> cVar) {
        this.f723vj = cVar;
    }

    /* renamed from: l */
    public void mo3670l(Status status) throws RemoteException {
        this.f723vj.mo3311b(status);
    }

    public void onSuccess() throws RemoteException {
        this.f723vj.mo3311b(Status.f518zQ);
    }
}
