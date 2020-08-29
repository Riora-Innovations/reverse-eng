package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0297a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C1062ii;
import com.google.android.gms.internal.C1065ij;
import com.google.android.gms.internal.C1066ik;
import com.google.android.gms.internal.C1075il;
import com.google.android.gms.plus.internal.C1329e;
import com.google.android.gms.plus.internal.C1341h;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api API = new Api(f3388va, new Scope[0]);
    public static final Account AccountApi = new C1062ii(f3388va);
    public static final Moments MomentsApi = new C1066ik(f3388va);
    public static final People PeopleApi = new C1075il(f3388va);

    /* renamed from: QK */
    public static final C1318a f3387QK = new C1065ij(f3388va);
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);

    /* renamed from: va */
    static final C0294b<C1329e> f3388va = new C0294b<C1329e>() {
        public int getPriority() {
            return 2;
        }

        /* renamed from: h */
        public C1329e mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            PlusOptions plusOptions;
            PlusOptions plusOptions2 = new PlusOptions();
            if (apiOptions != null) {
                C0766er.m1976b(apiOptions instanceof PlusOptions, (Object) "Must provide valid PlusOptions!");
                plusOptions = (PlusOptions) apiOptions;
            } else {
                plusOptions = plusOptions2;
            }
            C1329e eVar = new C1329e(context, looper, connectionCallbacks, onConnectionFailedListener, new C1341h(eeVar.mo5018dR(), eeVar.mo5021dU(), (String[]) plusOptions.f3390QM.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
            return eVar;
        }
    };

    public static final class PlusOptions implements ApiOptions {

        /* renamed from: QL */
        final String f3389QL;

        /* renamed from: QM */
        final Set<String> f3390QM;

        public static final class Builder {

            /* renamed from: QL */
            String f3391QL;

            /* renamed from: QM */
            final Set<String> f3392QM = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                C0766er.m1975b(activityTypes, (Object) "activityTypes may not be null.");
                for (String add : activityTypes) {
                    this.f3392QM.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions(this);
            }

            public Builder setServerClientId(String clientId) {
                this.f3391QL = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.f3389QL = null;
            this.f3390QM = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.f3389QL = builder.f3391QL;
            this.f3390QM = builder.f3392QM;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.plus.Plus$a */
    public static abstract class C1305a<R extends Result> extends C0297a<R, C1329e> {
        public C1305a(C0294b<C1329e> bVar) {
            super(bVar);
        }
    }

    private Plus() {
    }

    /* renamed from: a */
    public static C1329e m3777a(GoogleApiClient googleApiClient, C0294b<C1329e> bVar) {
        boolean z = true;
        C0766er.m1976b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        C0766er.m1970a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1329e eVar = (C1329e) googleApiClient.mo3256a(bVar);
        if (eVar == null) {
            z = false;
        }
        C0766er.m1970a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return eVar;
    }
}
