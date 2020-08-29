package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.C0630ch.C0631a;
import com.google.android.gms.internal.C0736eh.C0741e;

/* renamed from: com.google.android.gms.internal.cc */
public class C0624cc extends C0736eh<C0630ch> {

    /* renamed from: oa */
    private final int f1645oa;

    public C0624cc(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f1645oa = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        enVar.mo5105g(eVar, this.f1645oa, getContext().getPackageName(), new Bundle());
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.ads.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    /* renamed from: aH */
    public C0630ch mo4743aH() {
        return (C0630ch) super.mo5039eb();
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public C0630ch mo3741p(IBinder iBinder) {
        return C0631a.m1433q(iBinder);
    }
}
