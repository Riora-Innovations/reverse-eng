package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
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
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.C0736eh;
import com.google.android.gms.internal.C0736eh.C0739c;
import com.google.android.gms.internal.C0736eh.C0740d;
import com.google.android.gms.internal.C0736eh.C0741e;
import com.google.android.gms.internal.C0736eh.C0743g;
import com.google.android.gms.internal.C0756en;
import com.google.android.gms.internal.C0802fh;
import com.google.android.gms.internal.C1085io;
import com.google.android.gms.internal.C1088ir;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C1326d.C1327a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.plus.internal.e */
public class C1329e extends C0736eh<C1326d> implements GooglePlayServicesClient {

    /* renamed from: Rd */
    private Person f3426Rd;

    /* renamed from: Re */
    private final C1341h f3427Re;

    /* renamed from: com.google.android.gms.plus.internal.e$a */
    final class C1330a extends C1319a {

        /* renamed from: QI */
        private final C0299c<Status> f3428QI;

        public C1330a(C0299c<Status> cVar) {
            this.f3428QI = cVar;
        }

        /* renamed from: L */
        public void mo7355L(Status status) {
            C1329e.this.mo5036a((C0738b<?>) new C1333d<Object>(this.f3428QI, status));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$b */
    final class C1331b extends C1319a {

        /* renamed from: QI */
        private final C0299c<LoadMomentsResult> f3430QI;

        public C1331b(C0299c<LoadMomentsResult> cVar) {
            this.f3430QI = cVar;
        }

        /* renamed from: a */
        public void mo7361a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            C1329e.this.mo5036a((C0738b<?>) new C1332c<Object>(this.f3430QI, status, dataHolder2, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$c */
    final class C1332c extends C0740d<C0299c<LoadMomentsResult>> implements LoadMomentsResult {

        /* renamed from: Dh */
        private final String f3432Dh;

        /* renamed from: Rg */
        private final String f3434Rg;

        /* renamed from: Rh */
        private MomentBuffer f3435Rh;

        /* renamed from: vl */
        private final Status f3436vl;

        public C1332c(C0299c<LoadMomentsResult> cVar, Status status, DataHolder dataHolder, String str, String str2) {
            super(cVar, dataHolder);
            this.f3436vl = status;
            this.f3432Dh = str;
            this.f3434Rg = str2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LoadMomentsResult> cVar, DataHolder dataHolder) {
            this.f3435Rh = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            cVar.mo3311b(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.f3435Rh;
        }

        public String getNextPageToken() {
            return this.f3432Dh;
        }

        public Status getStatus() {
            return this.f3436vl;
        }

        public String getUpdated() {
            return this.f3434Rg;
        }

        public void release() {
            if (this.f3435Rh != null) {
                this.f3435Rh.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$d */
    final class C1333d extends C0738b<C0299c<Status>> {

        /* renamed from: vl */
        private final Status f3438vl;

        public C1333d(C0299c<Status> cVar, Status status) {
            super(cVar);
            this.f3438vl = status;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4885a(C0299c<Status> cVar) {
            if (cVar != null) {
                cVar.mo3311b(this.f3438vl);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$e */
    final class C1334e extends C1319a {

        /* renamed from: QI */
        private final C0299c<LoadPeopleResult> f3439QI;

        public C1334e(C0299c<LoadPeopleResult> cVar) {
            this.f3439QI = cVar;
        }

        /* renamed from: a */
        public void mo7360a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.getMetadata() != null ? (PendingIntent) dataHolder.getMetadata().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            C1329e.this.mo5036a((C0738b<?>) new C1335f<Object>(this.f3439QI, status, dataHolder2, str));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$f */
    final class C1335f extends C0740d<C0299c<LoadPeopleResult>> implements LoadPeopleResult {

        /* renamed from: Dh */
        private final String f3441Dh;

        /* renamed from: Ri */
        private PersonBuffer f3443Ri;

        /* renamed from: vl */
        private final Status f3444vl;

        public C1335f(C0299c<LoadPeopleResult> cVar, Status status, DataHolder dataHolder, String str) {
            super(cVar, dataHolder);
            this.f3444vl = status;
            this.f3441Dh = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LoadPeopleResult> cVar, DataHolder dataHolder) {
            this.f3443Ri = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            cVar.mo3311b(this);
        }

        public String getNextPageToken() {
            return this.f3441Dh;
        }

        public PersonBuffer getPersonBuffer() {
            return this.f3443Ri;
        }

        public Status getStatus() {
            return this.f3444vl;
        }

        public void release() {
            if (this.f3443Ri != null) {
                this.f3443Ri.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$g */
    final class C1336g extends C1319a {

        /* renamed from: QI */
        private final C0299c<Status> f3445QI;

        public C1336g(C0299c<Status> cVar) {
            this.f3445QI = cVar;
        }

        /* renamed from: d */
        public void mo7364d(int i, Bundle bundle) {
            C1329e.this.mo5036a((C0738b<?>) new C1337h<Object>(this.f3445QI, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.e$h */
    final class C1337h extends C0738b<C0299c<Status>> {

        /* renamed from: vl */
        private final Status f3448vl;

        public C1337h(C0299c<Status> cVar, Status status) {
            super(cVar);
            this.f3448vl = status;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4885a(C0299c<Status> cVar) {
            C1329e.this.disconnect();
            if (cVar != null) {
                cVar.mo3311b(this.f3448vl);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    public C1329e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C1341h hVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, hVar.mo7422hq());
        this.f3427Re = hVar;
    }

    @Deprecated
    public C1329e(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, C1341h hVar) {
        this(context, context.getMainLooper(), new C0739c(connectionCallbacks), new C0743g(onConnectionFailedListener), hVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3733a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.f3426Rd = C1088ir.m3189i(bundle.getByteArray("loaded_person"));
        }
        super.mo3733a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void mo7394a(C0299c<LoadPeopleResult> cVar, int i, String str) {
        mo5037bm();
        C1334e eVar = new C1334e(cVar);
        try {
            ((C1326d) mo5039eb()).mo7374a(eVar, 1, i, -1, str);
        } catch (RemoteException e) {
            eVar.mo7360a(DataHolder.empty(8), null);
        }
    }

    /* renamed from: a */
    public void mo7395a(C0299c<LoadMomentsResult> cVar, int i, String str, Uri uri, String str2, String str3) {
        mo5037bm();
        C1331b bVar = cVar != null ? new C1331b(cVar) : null;
        try {
            ((C1326d) mo5039eb()).mo7375a(bVar, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            bVar.mo7361a(DataHolder.empty(8), null, null);
        }
    }

    /* renamed from: a */
    public void mo7396a(C0299c<Status> cVar, Moment moment) {
        mo5037bm();
        C1330a aVar = cVar != null ? new C1330a(cVar) : null;
        try {
            ((C1326d) mo5039eb()).mo7377a((C1320b) aVar, C0802fh.m2084a((C1085io) moment));
        } catch (RemoteException e) {
            if (aVar == null) {
                throw new IllegalStateException(e);
            }
            aVar.mo7355L(new Status(8, null, null));
        }
    }

    /* renamed from: a */
    public void mo7397a(C0299c<LoadPeopleResult> cVar, Collection<String> collection) {
        mo5037bm();
        C1334e eVar = new C1334e(cVar);
        try {
            ((C1326d) mo5039eb()).mo7380a((C1320b) eVar, (List<String>) new ArrayList<String>(collection));
        } catch (RemoteException e) {
            eVar.mo7360a(DataHolder.empty(8), null);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        Bundle hy = this.f3427Re.mo7430hy();
        hy.putStringArray("request_visible_actions", this.f3427Re.mo7423hr());
        enVar.mo5094a(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.f3427Re.mo7426hu(), this.f3427Re.mo7425ht(), mo5038ea(), this.f3427Re.getAccountName(), hy);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aB */
    public C1326d mo3741p(IBinder iBinder) {
        return C1327a.m3858aA(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.plus.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    /* renamed from: aR */
    public boolean mo7399aR(String str) {
        return Arrays.asList(mo5038ea()).contains(str);
    }

    /* renamed from: c */
    public void mo7400c(C0299c<LoadPeopleResult> cVar, String[] strArr) {
        mo7397a(cVar, (Collection<String>) Arrays.asList(strArr));
    }

    public void clearDefaultAccount() {
        mo5037bm();
        try {
            this.f3426Rd = null;
            ((C1326d) mo5039eb()).clearDefaultAccount();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public String getAccountName() {
        mo5037bm();
        try {
            return ((C1326d) mo5039eb()).getAccountName();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        mo5037bm();
        return this.f3426Rd;
    }

    /* renamed from: i */
    public void mo7404i(C0299c<LoadMomentsResult> cVar) {
        mo7395a(cVar, 20, null, null, null, "me");
    }

    /* renamed from: i */
    public void mo7405i(C0299c<LoadPeopleResult> cVar, String str) {
        mo7394a(cVar, 0, str);
    }

    /* renamed from: j */
    public void mo7406j(C0299c<LoadPeopleResult> cVar) {
        mo5037bm();
        C1334e eVar = new C1334e(cVar);
        try {
            ((C1326d) mo5039eb()).mo7374a(eVar, 2, 1, -1, null);
        } catch (RemoteException e) {
            eVar.mo7360a(DataHolder.empty(8), null);
        }
    }

    /* renamed from: k */
    public void mo7407k(C0299c<Status> cVar) {
        mo5037bm();
        clearDefaultAccount();
        C1336g gVar = new C1336g(cVar);
        try {
            ((C1326d) mo5039eb()).mo7381b(gVar);
        } catch (RemoteException e) {
            gVar.mo7364d(8, null);
        }
    }

    public void removeMoment(String momentId) {
        mo5037bm();
        try {
            ((C1326d) mo5039eb()).removeMoment(momentId);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
