package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus.C1305a;
import com.google.android.gms.plus.internal.C1329e;

/* renamed from: com.google.android.gms.internal.ii */
public final class C1062ii implements Account {

    /* renamed from: Rw */
    private final C0294b<C1329e> f2883Rw;

    /* renamed from: com.google.android.gms.internal.ii$a */
    private static abstract class C1064a extends C1305a<Status> {
        C1064a(C0294b<C1329e> bVar) {
            super(bVar);
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    public C1062ii(C0294b<C1329e> bVar) {
        this.f2883Rw = bVar;
    }

    /* renamed from: a */
    private static C1329e m3119a(GoogleApiClient googleApiClient, C0294b<C1329e> bVar) {
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

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m3119a(googleApiClient, this.f2883Rw).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return m3119a(googleApiClient, this.f2883Rw).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.mo3258b(new C1064a(this.f2883Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7407k(this);
            }
        });
    }
}
