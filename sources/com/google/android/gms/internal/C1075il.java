package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1305a;
import com.google.android.gms.plus.internal.C1329e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

/* renamed from: com.google.android.gms.internal.il */
public final class C1075il implements People {

    /* renamed from: Rw */
    private final C0294b<C1329e> f2900Rw;

    /* renamed from: com.google.android.gms.internal.il$a */
    private static abstract class C1081a extends C1305a<LoadPeopleResult> {
        C1081a(C0294b<C1329e> bVar) {
            super(bVar);
        }

        /* renamed from: N */
        public LoadPeopleResult mo3009d(final Status status) {
            return new LoadPeopleResult() {
                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public C1075il(C0294b<C1329e> bVar) {
        this.f2900Rw = bVar;
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m3777a(googleApiClient, this.f2900Rw).getCurrentPerson();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.mo3257a(new C1081a(this.f2900Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7397a((C0299c<LoadPeopleResult>) this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.mo3257a(new C1081a(this.f2900Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7400c(this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.mo3257a(new C1081a(this.f2900Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7406j(this);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.mo3257a(new C1081a(this.f2900Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7394a((C0299c<LoadPeopleResult>) this, orderBy, pageToken);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.mo3257a(new C1081a(this.f2900Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7405i(this, pageToken);
            }
        });
    }
}
