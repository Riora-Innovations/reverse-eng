package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C1305a;
import com.google.android.gms.plus.internal.C1329e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

/* renamed from: com.google.android.gms.internal.ik */
public final class C1066ik implements Moments {

    /* renamed from: Rw */
    private final C0294b<C1329e> f2886Rw;

    /* renamed from: com.google.android.gms.internal.ik$a */
    private static abstract class C1071a extends C1305a<LoadMomentsResult> {
        C1071a(C0294b<C1329e> bVar) {
            super(bVar);
        }

        /* renamed from: M */
        public LoadMomentsResult mo3009d(final Status status) {
            return new LoadMomentsResult() {
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.internal.ik$b */
    private static abstract class C1073b extends C1305a<Status> {
        C1073b(C0294b<C1329e> bVar) {
            super(bVar);
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.internal.ik$c */
    private static abstract class C1074c extends C1305a<Status> {
        C1074c(C0294b<C1329e> bVar) {
            super(bVar);
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    public C1066ik(C0294b<C1329e> bVar) {
        this.f2886Rw = bVar;
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.mo3257a(new C1071a(this.f2886Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7404i(this);
            }
        });
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        final int i = maxResults;
        final String str = pageToken;
        final Uri uri = targetUrl;
        final String str2 = type;
        final String str3 = userId;
        return googleApiClient.mo3257a(new C1071a(this.f2886Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7395a(this, i, str, uri, str2, str3);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.mo3258b(new C1073b(this.f2886Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.removeMoment(momentId);
                mo3311b(Status.f518zQ);
            }
        });
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.mo3258b(new C1074c(this.f2886Rw) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1329e eVar) {
                eVar.mo7396a((C0299c<Status>) this, moment);
            }
        });
    }
}
