package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0736eh.C0739c;
import com.google.android.gms.internal.C0736eh.C0741e;
import com.google.android.gms.internal.C0736eh.C0743g;
import com.google.android.gms.internal.C1052if.C1053a;
import com.google.android.gms.internal.C1055ig.C1056a;
import com.google.android.gms.panorama.Panorama.C1299a;
import com.google.android.gms.panorama.Panorama.PanoramaResult;

/* renamed from: com.google.android.gms.internal.ih */
public class C1058ih extends C0736eh<C1055ig> {

    /* renamed from: com.google.android.gms.internal.ih$a */
    final class C1059a extends C0738b<C0299c<C1299a>> implements C1299a {

        /* renamed from: QE */
        public final Status f2873QE;

        /* renamed from: QF */
        public final Intent f2874QF;
        public final int type;

        public C1059a(C0299c<C1299a> cVar, Status status, int i, Intent intent) {
            super(cVar);
            this.f2873QE = status;
            this.type = i;
            this.f2874QF = intent;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4885a(C0299c<C1299a> cVar) {
            cVar.mo3311b(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }

        public Status getStatus() {
            return this.f2873QE;
        }

        public Intent getViewerIntent() {
            return this.f2874QF;
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$b */
    final class C1060b extends C1053a {

        /* renamed from: QH */
        private final C0299c<C1299a> f2877QH;

        /* renamed from: QI */
        private final C0299c<PanoramaResult> f2878QI;

        /* renamed from: QJ */
        private final Uri f2879QJ;

        public C1060b(C0299c<C1299a> cVar, C0299c<PanoramaResult> cVar2, Uri uri) {
            this.f2877QH = cVar;
            this.f2878QI = cVar2;
            this.f2879QJ = uri;
        }

        /* renamed from: a */
        public void mo5848a(int i, Bundle bundle, int i2, Intent intent) {
            if (this.f2879QJ != null) {
                C1058ih.this.getContext().revokeUriPermission(this.f2879QJ, 1);
            }
            Status status = new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            if (this.f2878QI != null) {
                C1058ih.this.mo5036a((C0738b<?>) new C1061c<Object>(this.f2878QI, status, intent));
            } else if (this.f2877QH != null) {
                C1058ih.this.mo5036a((C0738b<?>) new C1059a<Object>(this.f2877QH, status, i2, intent));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ih$c */
    final class C1061c extends C0738b<C0299c<PanoramaResult>> implements PanoramaResult {

        /* renamed from: QE */
        private final Status f2880QE;

        /* renamed from: QF */
        private final Intent f2881QF;

        public C1061c(C0299c<PanoramaResult> cVar, Status status, Intent intent) {
            super(cVar);
            this.f2880QE = status;
            this.f2881QF = intent;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4885a(C0299c<PanoramaResult> cVar) {
            cVar.mo3311b(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }

        public Status getStatus() {
            return this.f2880QE;
        }

        public Intent getViewerIntent() {
            return this.f2881QF;
        }
    }

    public C1058ih(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, null);
    }

    @Deprecated
    public C1058ih(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, context.getMainLooper(), new C0739c(connectionCallbacks), new C0743g(onConnectionFailedListener));
    }

    /* renamed from: a */
    public void mo5855a(C0299c<PanoramaResult> cVar, Uri uri, boolean z) {
        mo5856a(new C1060b(null, cVar, z ? uri : null), uri, null, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        enVar.mo5091a(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    /* renamed from: a */
    public void mo5856a(C1060b bVar, Uri uri, Bundle bundle, boolean z) {
        mo5037bm();
        if (z) {
            getContext().grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        }
        try {
            ((C1055ig) mo5039eb()).mo5852a(bVar, uri, bundle, z);
        } catch (RemoteException e) {
            bVar.mo5848a(8, null, 0, null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.panorama.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    /* renamed from: ax */
    public C1055ig mo3741p(IBinder iBinder) {
        return C1056a.m3103aw(iBinder);
    }
}
