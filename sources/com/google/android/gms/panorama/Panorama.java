package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0297a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C1058ih;

public final class Panorama {
    public static final Api API = new Api(f3377va, new Scope[0]);

    /* renamed from: va */
    static final C0294b<C1058ih> f3377va = new C0294b<C1058ih>() {
        /* renamed from: g */
        public C1058ih mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new C1058ih(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public interface PanoramaResult extends Result {
        Intent getViewerIntent();
    }

    /* renamed from: com.google.android.gms.panorama.Panorama$a */
    public interface C1299a extends PanoramaResult {
    }

    /* renamed from: com.google.android.gms.panorama.Panorama$b */
    private static abstract class C1300b extends C0297a<PanoramaResult, C1058ih> {
        public C1300b() {
            super(Panorama.f3377va);
        }

        /* renamed from: J */
        public PanoramaResult mo3009d(final Status status) {
            return new PanoramaResult() {
                public Status getStatus() {
                    return status;
                }

                public Intent getViewerIntent() {
                    return null;
                }
            };
        }
    }

    private Panorama() {
    }

    public static PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.mo3257a(new C1300b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1058ih ihVar) {
                ihVar.mo5855a(this, uri, false);
            }
        });
    }

    public static PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.mo3257a(new C1300b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1058ih ihVar) {
                ihVar.mo5855a(this, uri, true);
            }
        });
    }
}
