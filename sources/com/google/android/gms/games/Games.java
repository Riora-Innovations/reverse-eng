package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
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
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C0819fx;
import com.google.android.gms.internal.C0905gf;
import com.google.android.gms.internal.C0919gg;
import com.google.android.gms.internal.C0920gh;
import com.google.android.gms.internal.C0924gi;
import com.google.android.gms.internal.C0928gj;
import com.google.android.gms.internal.C0944gk;
import com.google.android.gms.internal.C0945gl;
import com.google.android.gms.internal.C0946gm;
import com.google.android.gms.internal.C0955gn;
import com.google.android.gms.internal.C0956go;
import com.google.android.gms.internal.C0964gp;
import com.google.android.gms.internal.C0993gw;

public final class Games {
    public static final Api API = new Api(f907va, SCOPE_GAMES);
    public static final Achievements Achievements = new C0905gf();
    public static final String EXTRA_PLAYER_IDS = "players";

    /* renamed from: FY */
    public static final Scope f903FY = new Scope("https://www.googleapis.com/auth/games.firstparty");

    /* renamed from: FZ */
    public static final Api f904FZ = new Api(f907va, f903FY);

    /* renamed from: Ga */
    public static final Multiplayer f905Ga = new C0944gk();
    public static final GamesMetadata GamesMetadata = new C0920gh();

    /* renamed from: Gb */
    public static final C0993gw f906Gb = new C0919gg();
    public static final Invitations Invitations = new C0924gi();
    public static final Leaderboards Leaderboards = new C0928gj();
    public static final Notifications Notifications = new C0945gl();
    public static final Players Players = new C0946gm();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new C0955gn();
    public static final Requests Requests = new C0956go();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new C0964gp();

    /* renamed from: va */
    static final C0294b<C0819fx> f907va = new C0294b<C0819fx>() {
        /* renamed from: e */
        public C0819fx mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            GamesOptions gamesOptions;
            GamesOptions gamesOptions2 = new GamesOptions();
            if (apiOptions != null) {
                C0766er.m1976b(apiOptions instanceof GamesOptions, (Object) "Must provide valid GamesOptions!");
                gamesOptions = (GamesOptions) apiOptions;
            } else {
                gamesOptions = gamesOptions2;
            }
            return new C0819fx(context, looper, eeVar.mo5022dV(), eeVar.mo5018dR(), connectionCallbacks, onConnectionFailedListener, eeVar.mo5021dU(), eeVar.mo5019dS(), eeVar.mo5023dW(), gamesOptions.f908Gc, gamesOptions.f909Gd, gamesOptions.f910Ge, gamesOptions.f911Gf, gamesOptions.f912Gg);
        }

        public int getPriority() {
            return 1;
        }
    };

    public static final class GamesOptions implements ApiOptions {

        /* renamed from: Gc */
        final boolean f908Gc;

        /* renamed from: Gd */
        final boolean f909Gd;

        /* renamed from: Ge */
        final int f910Ge;

        /* renamed from: Gf */
        final boolean f911Gf;

        /* renamed from: Gg */
        final int f912Gg;

        public static final class Builder {

            /* renamed from: Gc */
            boolean f913Gc;

            /* renamed from: Gd */
            boolean f914Gd;

            /* renamed from: Ge */
            int f915Ge;

            /* renamed from: Gf */
            boolean f916Gf;

            /* renamed from: Gg */
            int f917Gg;

            private Builder() {
                this.f913Gc = false;
                this.f914Gd = true;
                this.f915Ge = 17;
                this.f916Gf = false;
                this.f917Gg = 4368;
            }

            public GamesOptions build() {
                return new GamesOptions(this);
            }

            public Builder setSdkVariant(int variant) {
                this.f917Gg = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.f914Gd = showConnectingPopup;
                this.f915Ge = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.f914Gd = showConnectingPopup;
                this.f915Ge = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.f908Gc = false;
            this.f909Gd = true;
            this.f910Ge = 17;
            this.f911Gf = false;
            this.f912Gg = 4368;
        }

        private GamesOptions(Builder builder) {
            this.f908Gc = builder.f913Gc;
            this.f909Gd = builder.f914Gd;
            this.f910Ge = builder.f915Ge;
            this.f911Gf = builder.f916Gf;
            this.f912Gg = builder.f917Gg;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    /* renamed from: com.google.android.gms.games.Games$a */
    public static abstract class C0463a<R extends Result> extends C0297a<R, C0819fx> implements PendingResult<R> {
        public C0463a() {
            super(Games.f907va);
        }
    }

    /* renamed from: com.google.android.gms.games.Games$b */
    private static abstract class C0464b extends C0463a<Status> {
        private C0464b() {
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    private Games() {
    }

    /* renamed from: c */
    public static C0819fx m1012c(GoogleApiClient googleApiClient) {
        boolean z = true;
        C0766er.m1976b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        C0766er.m1970a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C0819fx fxVar = (C0819fx) googleApiClient.mo3256a(f907va);
        if (fxVar == null) {
            z = false;
        }
        C0766er.m1970a(z, "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return fxVar;
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return m1012c(apiClient).mo5340fB();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return m1012c(apiClient).mo5346fn();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return m1012c(apiClient).mo5339fA();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return m1012c(apiClient).mo5358fz();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        m1012c(apiClient).mo5319aT(gravity);
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        C0766er.m1977f(gamesContentView);
        m1012c(apiClient).mo5336e(gamesContentView);
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.mo3258b(new C0464b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5324b((C0299c<Status>) this);
            }
        });
    }
}
