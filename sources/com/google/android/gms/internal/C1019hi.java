package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0736eh.C0741e;
import com.google.android.gms.internal.C1010hf.C1011a;
import com.google.android.gms.internal.C1013hg.C1014a;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.hi */
public class C1019hi extends C0736eh<C1013hg> {

    /* renamed from: Lk */
    private final C1027hl<C1013hg> f2659Lk = new C1023c();

    /* renamed from: Lq */
    private final C1016hh f2660Lq;

    /* renamed from: Lr */
    private final C1048ib f2661Lr;

    /* renamed from: Ls */
    private final String f2662Ls;

    /* renamed from: vi */
    private final String f2663vi;

    /* renamed from: com.google.android.gms.internal.hi$a */
    private final class C1021a extends C0738b<OnAddGeofencesResultListener> {

        /* renamed from: Lt */
        private final String[] f2664Lt;

        /* renamed from: yJ */
        private final int f2666yJ;

        public C1021a(OnAddGeofencesResultListener onAddGeofencesResultListener, int i, String[] strArr) {
            super(onAddGeofencesResultListener);
            this.f2666yJ = LocationStatusCodes.m3581bl(i);
            this.f2664Lt = strArr;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4885a(OnAddGeofencesResultListener onAddGeofencesResultListener) {
            if (onAddGeofencesResultListener != null) {
                onAddGeofencesResultListener.onAddGeofencesResult(this.f2666yJ, this.f2664Lt);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.hi$b */
    private static final class C1022b extends C1011a {

        /* renamed from: Lv */
        private OnAddGeofencesResultListener f2667Lv;

        /* renamed from: Lw */
        private OnRemoveGeofencesResultListener f2668Lw;

        /* renamed from: Lx */
        private C1019hi f2669Lx;

        public C1022b(OnAddGeofencesResultListener onAddGeofencesResultListener, C1019hi hiVar) {
            this.f2667Lv = onAddGeofencesResultListener;
            this.f2668Lw = null;
            this.f2669Lx = hiVar;
        }

        public C1022b(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, C1019hi hiVar) {
            this.f2668Lw = onRemoveGeofencesResultListener;
            this.f2667Lv = null;
            this.f2669Lx = hiVar;
        }

        public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) throws RemoteException {
            if (this.f2669Lx == null) {
                Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
                return;
            }
            C1019hi hiVar = this.f2669Lx;
            C1019hi hiVar2 = this.f2669Lx;
            hiVar2.getClass();
            hiVar.mo5036a((C0738b<?>) new C1021a<Object>(this.f2667Lv, statusCode, geofenceRequestIds));
            this.f2669Lx = null;
            this.f2667Lv = null;
            this.f2668Lw = null;
        }

        public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
            if (this.f2669Lx == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByPendingIntentResult called multiple times");
                return;
            }
            C1019hi hiVar = this.f2669Lx;
            C1019hi hiVar2 = this.f2669Lx;
            hiVar2.getClass();
            hiVar.mo5036a((C0738b<?>) new C1024d<Object>(hiVar2, 1, this.f2668Lw, statusCode, pendingIntent));
            this.f2669Lx = null;
            this.f2667Lv = null;
            this.f2668Lw = null;
        }

        public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
            if (this.f2669Lx == null) {
                Log.wtf("LocationClientImpl", "onRemoveGeofencesByRequestIdsResult called multiple times");
                return;
            }
            C1019hi hiVar = this.f2669Lx;
            C1019hi hiVar2 = this.f2669Lx;
            hiVar2.getClass();
            hiVar.mo5036a((C0738b<?>) new C1024d<Object>(2, this.f2668Lw, statusCode, geofenceRequestIds));
            this.f2669Lx = null;
            this.f2667Lv = null;
            this.f2668Lw = null;
        }
    }

    /* renamed from: com.google.android.gms.internal.hi$c */
    private final class C1023c implements C1027hl<C1013hg> {
        private C1023c() {
        }

        /* renamed from: bm */
        public void mo5716bm() {
            C1019hi.this.mo5037bm();
        }

        /* renamed from: gm */
        public C1013hg mo5717eb() {
            return (C1013hg) C1019hi.this.mo5039eb();
        }
    }

    /* renamed from: com.google.android.gms.internal.hi$d */
    private final class C1024d extends C0738b<OnRemoveGeofencesResultListener> {

        /* renamed from: Lt */
        private final String[] f2671Lt;

        /* renamed from: Ly */
        private final int f2673Ly;
        private final PendingIntent mPendingIntent;

        /* renamed from: yJ */
        private final int f2674yJ;

        public C1024d(C1019hi hiVar, int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, PendingIntent pendingIntent) {
            boolean z = true;
            C1019hi.this = hiVar;
            super(onRemoveGeofencesResultListener);
            if (i != 1) {
                z = false;
            }
            C0731ed.m1826v(z);
            this.f2673Ly = i;
            this.f2674yJ = LocationStatusCodes.m3581bl(i2);
            this.mPendingIntent = pendingIntent;
            this.f2671Lt = null;
        }

        public C1024d(int i, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener, int i2, String[] strArr) {
            super(onRemoveGeofencesResultListener);
            C0731ed.m1826v(i == 2);
            this.f2673Ly = i;
            this.f2674yJ = LocationStatusCodes.m3581bl(i2);
            this.f2671Lt = strArr;
            this.mPendingIntent = null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4885a(OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
            if (onRemoveGeofencesResultListener != null) {
                switch (this.f2673Ly) {
                    case 1:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByPendingIntentResult(this.f2674yJ, this.mPendingIntent);
                        return;
                    case 2:
                        onRemoveGeofencesResultListener.onRemoveGeofencesByRequestIdsResult(this.f2674yJ, this.f2671Lt);
                        return;
                    default:
                        Log.wtf("LocationClientImpl", "Unsupported action: " + this.f2673Ly);
                        return;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    public C1019hi(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f2660Lq = new C1016hh(context, this.f2659Lk);
        this.f2662Ls = str;
        this.f2663vi = null;
        this.f2661Lr = new C1048ib(getContext(), Locale.getDefault(), this.f2659Lk);
    }

    /* access modifiers changed from: protected */
    /* renamed from: Q */
    public C1013hg mo3741p(IBinder iBinder) {
        return C1014a.m2978P(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f2662Ls);
        enVar.mo5103e(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    public void addGeofences(List<C1025hj> geofences, PendingIntent pendingIntent, OnAddGeofencesResultListener listener) {
        mo5037bm();
        C0766er.m1976b(geofences != null && geofences.size() > 0, (Object) "At least one geofence must be specified.");
        C0766er.m1975b(pendingIntent, (Object) "PendingIntent must be specified.");
        C0766er.m1975b(listener, (Object) "OnAddGeofencesResultListener not provided.");
        try {
            ((C1013hg) mo5039eb()).mo5678a(geofences, pendingIntent, (C1010hf) listener == null ? null : new C1022b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void disconnect() {
        synchronized (this.f2660Lq) {
            if (isConnected()) {
                this.f2660Lq.removeAllListeners();
                this.f2660Lq.mo5690gl();
            }
            super.disconnect();
        }
    }

    public Location getLastLocation() {
        return this.f2660Lq.getLastLocation();
    }

    public void removeActivityUpdates(PendingIntent callbackIntent) {
        mo5037bm();
        C0766er.m1977f(callbackIntent);
        try {
            ((C1013hg) mo5039eb()).removeActivityUpdates(callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(PendingIntent pendingIntent, OnRemoveGeofencesResultListener listener) {
        mo5037bm();
        C0766er.m1975b(pendingIntent, (Object) "PendingIntent must be specified.");
        C0766er.m1975b(listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        try {
            ((C1013hg) mo5039eb()).mo5663a(pendingIntent, (C1010hf) listener == null ? null : new C1022b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeGeofences(List<String> geofenceRequestIds, OnRemoveGeofencesResultListener listener) {
        mo5037bm();
        C0766er.m1976b(geofenceRequestIds != null && geofenceRequestIds.size() > 0, (Object) "geofenceRequestIds can't be null nor empty.");
        C0766er.m1975b(listener, (Object) "OnRemoveGeofencesResultListener not provided.");
        try {
            ((C1013hg) mo5039eb()).mo5679a((String[]) geofenceRequestIds.toArray(new String[0]), (C1010hf) listener == null ? null : new C1022b(listener, this), getContext().getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.f2660Lq.removeLocationUpdates(callbackIntent);
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.f2660Lq.removeLocationUpdates(listener);
    }

    public void requestActivityUpdates(long detectionIntervalMillis, PendingIntent callbackIntent) {
        boolean z = true;
        mo5037bm();
        C0766er.m1977f(callbackIntent);
        if (detectionIntervalMillis < 0) {
            z = false;
        }
        C0766er.m1976b(z, (Object) "detectionIntervalMillis must be >= 0");
        try {
            ((C1013hg) mo5039eb()).mo5661a(detectionIntervalMillis, true, callbackIntent);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.f2660Lq.requestLocationUpdates(request, callbackIntent);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener) {
        requestLocationUpdates(request, listener, null);
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        synchronized (this.f2660Lq) {
            this.f2660Lq.requestLocationUpdates(request, listener, looper);
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.f2660Lq.setMockLocation(mockLocation);
    }

    public void setMockMode(boolean isMockMode) {
        this.f2660Lq.setMockMode(isMockMode);
    }
}
