package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0463a;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;

/* renamed from: com.google.android.gms.internal.gh */
public final class C0920gh implements GamesMetadata {

    /* renamed from: com.google.android.gms.internal.gh$a */
    private static abstract class C0922a extends C0463a<LoadGamesResult> {
        private C0922a() {
        }

        /* renamed from: u */
        public LoadGamesResult mo3009d(final Status status) {
            return new LoadGamesResult() {
                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.empty(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5349fq();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.mo3257a(new C0922a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5359g(this);
            }
        });
    }
}
