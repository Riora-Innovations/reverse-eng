package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0297a;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0686dl;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C0766er;

public final class AppStateManager {
    public static final Api API = new Api(f345va, SCOPE_APP_STATE);
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);

    /* renamed from: va */
    static final C0294b<C0686dl> f345va = new C0294b<C0686dl>() {
        /* renamed from: a */
        public C0686dl mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new C0686dl(context, looper, connectionCallbacks, onConnectionFailedListener, eeVar.mo5018dR(), (String[]) eeVar.mo5020dT().toArray(new String[0]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$a */
    public static abstract class C0251a<R extends Result> extends C0297a<R, C0686dl> implements PendingResult<R> {
        public C0251a() {
            super(AppStateManager.f345va);
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$b */
    private static abstract class C0252b extends C0251a<StateDeletedResult> {
        private C0252b() {
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$c */
    private static abstract class C0253c extends C0251a<StateListResult> {
        private C0253c() {
        }

        /* renamed from: e */
        public StateListResult mo3009d(final Status status) {
            return new StateListResult() {
                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$d */
    private static abstract class C0255d extends C0251a<Status> {
        private C0255d() {
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.appstate.AppStateManager$e */
    private static abstract class C0256e extends C0251a<StateResult> {
        private C0256e() {
        }

        /* renamed from: g */
        public StateResult mo3009d(Status status) {
            return AppStateManager.m296a(status);
        }
    }

    private AppStateManager() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static StateResult m296a(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }

    /* renamed from: a */
    public static C0686dl m297a(GoogleApiClient googleApiClient) {
        boolean z = true;
        C0766er.m1976b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        C0766er.m1970a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C0686dl dlVar = (C0686dl) googleApiClient.mo3256a(f345va);
        if (dlVar == null) {
            z = false;
        }
        C0766er.m1970a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return dlVar;
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo3258b(new C0252b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0686dl dlVar) {
                dlVar.mo4876a((C0299c<StateDeletedResult>) this, stateKey);
            }

            /* renamed from: c */
            public StateDeletedResult mo3009d(final Status status) {
                return new StateDeletedResult() {
                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m297a(googleApiClient).mo4883cO();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m297a(googleApiClient).mo4882cN();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.mo3257a(new C0253c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0686dl dlVar) {
                dlVar.mo4875a(this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo3257a(new C0256e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0686dl dlVar) {
                dlVar.mo4880b(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.mo3258b(new C0256e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0686dl dlVar) {
                dlVar.mo4877a(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.mo3258b(new C0255d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0686dl dlVar) {
                dlVar.mo4879b((C0299c<Status>) this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.mo3258b(new C0256e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0686dl dlVar) {
                dlVar.mo4878a(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.mo3258b(new C0256e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0686dl dlVar) {
                dlVar.mo4878a(this, stateKey, data);
            }
        });
    }
}
