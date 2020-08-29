package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0336c;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0414u.C0415a;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C0736eh;
import com.google.android.gms.internal.C0736eh.C0741e;
import com.google.android.gms.internal.C0756en;
import com.google.android.gms.internal.C0766er;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.internal.n */
public class C0380n extends C0736eh<C0414u> {

    /* renamed from: DA */
    private DriveId f746DA;

    /* renamed from: DB */
    final ConnectionCallbacks f747DB;

    /* renamed from: DC */
    Map<DriveId, Map<Listener<?>, C0410s<?>>> f748DC = new HashMap();

    /* renamed from: Dz */
    private DriveId f749Dz;

    /* renamed from: vi */
    private final String f750vi;

    public C0380n(Context context, Looper looper, C0732ee eeVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f750vi = (String) C0766er.m1975b(eeVar.mo5018dR(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.f747DB = connectionCallbacks;
    }

    /* access modifiers changed from: protected */
    /* renamed from: C */
    public C0414u mo3741p(IBinder iBinder) {
        return C0415a.m837D(iBinder);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <C extends DriveEvent> PendingResult<Status> mo3732a(GoogleApiClient googleApiClient, final DriveId driveId, final int i, Listener<C> listener) {
        PendingResult<Status> b;
        C0766er.m1976b(C0336c.m646a(i, driveId), (Object) "id");
        C0766er.m1975b(listener, (Object) "listener");
        C0766er.m1970a(isConnected(), "Client must be connected");
        synchronized (this.f748DC) {
            Map map = (Map) this.f748DC.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.f748DC.put(driveId, map);
            }
            if (map.containsKey(listener)) {
                b = new C0377k<>(Status.f518zQ);
            } else {
                final C0410s sVar = new C0410s(getLooper(), i, listener);
                map.put(listener, sVar);
                b = googleApiClient.mo3258b(new C0376j() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0380n nVar) throws RemoteException {
                        nVar.mo3738eT().mo3769a(new AddEventListenerRequest(driveId, i), (C0420w) sVar, (String) null, (C0417v) new C0348ak(this));
                    }
                });
            }
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3733a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f749Dz = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.f746DA = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.mo3733a(i, iBinder, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        String packageName = getContext().getPackageName();
        C0766er.m1977f(eVar);
        C0766er.m1977f(packageName);
        C0766er.m1977f(mo5038ea());
        enVar.mo5096a(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, mo5038ea(), this.f750vi, new Bundle());
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public PendingResult<Status> mo3737b(GoogleApiClient googleApiClient, final DriveId driveId, final int i, Listener<?> listener) {
        PendingResult<Status> b;
        C0766er.m1976b(C0336c.m646a(i, driveId), (Object) "id");
        C0766er.m1975b(listener, (Object) "listener");
        C0766er.m1970a(isConnected(), "Client must be connected");
        synchronized (this.f748DC) {
            Map map = (Map) this.f748DC.get(driveId);
            if (map == null) {
                b = new C0377k<>(Status.f518zQ);
            } else {
                final C0410s sVar = (C0410s) map.remove(listener);
                if (sVar == null) {
                    b = new C0377k<>(Status.f518zQ);
                } else {
                    if (map.isEmpty()) {
                        this.f748DC.remove(driveId);
                    }
                    b = googleApiClient.mo3258b(new C0376j() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a */
                        public void mo3004a(C0380n nVar) throws RemoteException {
                            nVar.mo3738eT().mo3781a(new RemoveEventListenerRequest(driveId, i), (C0420w) sVar, (String) null, (C0417v) new C0348ak(this));
                        }
                    });
                }
            }
        }
        return b;
    }

    public void disconnect() {
        C0414u uVar = (C0414u) mo5039eb();
        if (uVar != null) {
            try {
                uVar.mo3776a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.f748DC.clear();
    }

    /* renamed from: eT */
    public C0414u mo3738eT() {
        return (C0414u) mo5039eb();
    }

    /* renamed from: eU */
    public DriveId mo3739eU() {
        return this.f749Dz;
    }

    /* renamed from: eV */
    public DriveId mo3740eV() {
        return this.f746DA;
    }
}
