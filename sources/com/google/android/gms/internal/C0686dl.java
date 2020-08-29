package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.C0698dn.C0699a;
import com.google.android.gms.internal.C0736eh.C0740d;
import com.google.android.gms.internal.C0736eh.C0741e;

/* renamed from: com.google.android.gms.internal.dl */
public final class C0686dl extends C0736eh<C0698dn> {

    /* renamed from: vi */
    private final String f1837vi;

    /* renamed from: com.google.android.gms.internal.dl$a */
    final class C0687a extends C0685dk {

        /* renamed from: vj */
        private final C0299c<StateDeletedResult> f1838vj;

        public C0687a(C0299c<StateDeletedResult> cVar) {
            this.f1838vj = (C0299c) C0766er.m1975b(cVar, (Object) "Result holder must not be null");
        }

        /* renamed from: b */
        public void mo4872b(int i, int i2) {
            C0686dl.this.mo5036a((C0738b<?>) new C0688b<Object>(this.f1838vj, new Status(i), i2));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl$b */
    final class C0688b extends C0738b<C0299c<StateDeletedResult>> implements StateDeletedResult {

        /* renamed from: vl */
        private final Status f1841vl;

        /* renamed from: vm */
        private final int f1842vm;

        public C0688b(C0299c<StateDeletedResult> cVar, Status status, int i) {
            super(cVar);
            this.f1841vl = status;
            this.f1842vm = i;
        }

        /* renamed from: c */
        public void mo4885a(C0299c<StateDeletedResult> cVar) {
            cVar.mo3311b(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }

        public int getStateKey() {
            return this.f1842vm;
        }

        public Status getStatus() {
            return this.f1841vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.dl$c */
    final class C0689c extends C0685dk {

        /* renamed from: vj */
        private final C0299c<StateListResult> f1843vj;

        public C0689c(C0299c<StateListResult> cVar) {
            this.f1843vj = (C0299c) C0766er.m1975b(cVar, (Object) "Result holder must not be null");
        }

        /* renamed from: a */
        public void mo4871a(DataHolder dataHolder) {
            C0686dl.this.mo5036a((C0738b<?>) new C0690d<Object>(this.f1843vj, new Status(dataHolder.getStatusCode()), dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl$d */
    final class C0690d extends C0740d<C0299c<StateListResult>> implements StateListResult {

        /* renamed from: vl */
        private final Status f1846vl;

        /* renamed from: vn */
        private final AppStateBuffer f1847vn;

        public C0690d(C0299c<StateListResult> cVar, Status status, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f1846vl = status;
            this.f1847vn = new AppStateBuffer(dataHolder);
        }

        /* renamed from: a */
        public void mo4889a(C0299c<StateListResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public AppStateBuffer getStateBuffer() {
            return this.f1847vn;
        }

        public Status getStatus() {
            return this.f1846vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.dl$e */
    final class C0691e extends C0685dk {

        /* renamed from: vj */
        private final C0299c<StateResult> f1848vj;

        public C0691e(C0299c<StateResult> cVar) {
            this.f1848vj = (C0299c) C0766er.m1975b(cVar, (Object) "Result holder must not be null");
        }

        /* renamed from: a */
        public void mo4870a(int i, DataHolder dataHolder) {
            C0686dl.this.mo5036a((C0738b<?>) new C0692f<Object>(this.f1848vj, i, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl$f */
    final class C0692f extends C0740d<C0299c<StateResult>> implements StateConflictResult, StateLoadedResult, StateResult {

        /* renamed from: vl */
        private final Status f1851vl;

        /* renamed from: vm */
        private final int f1852vm;

        /* renamed from: vn */
        private final AppStateBuffer f1853vn;

        public C0692f(C0299c<StateResult> cVar, int i, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f1852vm = i;
            this.f1851vl = new Status(dataHolder.getStatusCode());
            this.f1853vn = new AppStateBuffer(dataHolder);
        }

        /* renamed from: cQ */
        private boolean m1629cQ() {
            return this.f1851vl.getStatusCode() == 2000;
        }

        /* renamed from: a */
        public void mo4889a(C0299c<StateResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public StateConflictResult getConflictResult() {
            if (m1629cQ()) {
                return this;
            }
            return null;
        }

        public StateLoadedResult getLoadedResult() {
            if (m1629cQ()) {
                return null;
            }
            return this;
        }

        public byte[] getLocalData() {
            if (this.f1853vn.getCount() == 0) {
                return null;
            }
            return this.f1853vn.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            if (this.f1853vn.getCount() == 0) {
                return null;
            }
            return this.f1853vn.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            if (this.f1853vn.getCount() == 0) {
                return null;
            }
            return this.f1853vn.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.f1852vm;
        }

        public Status getStatus() {
            return this.f1851vl;
        }

        public void release() {
            this.f1853vn.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.dl$g */
    final class C0693g extends C0685dk {

        /* renamed from: vj */
        C0299c<Status> f1854vj;

        public C0693g(C0299c<Status> cVar) {
            this.f1854vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: cM */
        public void mo4873cM() {
            C0686dl.this.mo5036a((C0738b<?>) new C0694h<Object>(this.f1854vj, new Status(0)));
        }
    }

    /* renamed from: com.google.android.gms.internal.dl$h */
    final class C0694h extends C0738b<C0299c<Status>> {

        /* renamed from: vl */
        private final Status f1857vl;

        public C0694h(C0299c<Status> cVar, Status status) {
            super(cVar);
            this.f1857vl = status;
        }

        /* renamed from: c */
        public void mo4885a(C0299c<Status> cVar) {
            cVar.mo3311b(this.f1857vl);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    public C0686dl(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f1837vi = (String) C0766er.m1977f(str);
    }

    /* renamed from: a */
    public void mo4875a(C0299c<StateListResult> cVar) {
        try {
            ((C0698dn) mo5039eb()).mo4895a(new C0689c(cVar));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4876a(C0299c<StateDeletedResult> cVar, int i) {
        try {
            ((C0698dn) mo5039eb()).mo4900b(new C0687a(cVar), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4877a(C0299c<StateResult> cVar, int i, String str, byte[] bArr) {
        try {
            ((C0698dn) mo5039eb()).mo4897a(new C0691e(cVar), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: a */
    public void mo4878a(C0299c<StateResult> cVar, int i, byte[] bArr) {
        try {
            ((C0698dn) mo5039eb()).mo4898a(cVar == null ? null : new C0691e(cVar), i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        enVar.mo5093a((C0753em) eVar, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f1837vi, mo5038ea());
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.appstate.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    /* renamed from: b */
    public void mo4879b(C0299c<Status> cVar) {
        try {
            ((C0698dn) mo5039eb()).mo4899b(new C0693g(cVar));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* renamed from: b */
    public void mo4880b(C0299c<StateResult> cVar, int i) {
        try {
            ((C0698dn) mo5039eb()).mo4896a(new C0691e(cVar), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4881b(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        C0766er.m1970a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    /* renamed from: cN */
    public int mo4882cN() {
        try {
            return ((C0698dn) mo5039eb()).mo4902cN();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    /* renamed from: cO */
    public int mo4883cO() {
        try {
            return ((C0698dn) mo5039eb()).mo4903cO();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public C0698dn mo3741p(IBinder iBinder) {
        return C0699a.m1656u(iBinder);
    }
}
