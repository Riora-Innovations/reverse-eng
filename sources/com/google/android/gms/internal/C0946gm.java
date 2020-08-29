package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0463a;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;

/* renamed from: com.google.android.gms.internal.gm */
public final class C0946gm implements Players {

    /* renamed from: com.google.android.gms.internal.gm$a */
    private static abstract class C0953a extends C0463a<LoadPlayersResult> {
        private C0953a() {
        }

        /* renamed from: A */
        public LoadPlayersResult mo3009d(final Status status) {
            return new LoadPlayersResult() {
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.empty(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5348fp();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5347fo();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5357fy();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo3257a(new C0953a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5312a((C0299c<LoadPlayersResult>) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo3257a(new C0953a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5298a((C0299c<LoadPlayersResult>) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo3257a(new C0953a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5298a((C0299c<LoadPlayersResult>) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo3257a(new C0953a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5305a((C0299c<LoadPlayersResult>) this, "playedWith", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.mo3257a(new C0953a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5302a((C0299c<LoadPlayersResult>) this, playerId);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo3257a(new C0953a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5305a((C0299c<LoadPlayersResult>) this, "playedWith", pageSize, false, forceReload);
            }
        });
    }
}
