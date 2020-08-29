package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0463a;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

/* renamed from: com.google.android.gms.internal.gp */
public final class C0964gp implements TurnBasedMultiplayer {

    /* renamed from: com.google.android.gms.internal.gp$a */
    private static abstract class C0975a extends C0463a<CancelMatchResult> {
        /* access modifiers changed from: private */

        /* renamed from: uS */
        public final String f2622uS;

        public C0975a(String str) {
            this.f2622uS = str;
        }

        /* renamed from: D */
        public CancelMatchResult mo3009d(final Status status) {
            return new CancelMatchResult() {
                public String getMatchId() {
                    return C0975a.this.f2622uS;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.internal.gp$b */
    private static abstract class C0977b extends C0463a<InitiateMatchResult> {
        private C0977b() {
        }

        /* renamed from: E */
        public InitiateMatchResult mo3009d(final Status status) {
            return new InitiateMatchResult() {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.internal.gp$c */
    private static abstract class C0979c extends C0463a<LeaveMatchResult> {
        private C0979c() {
        }

        /* renamed from: F */
        public LeaveMatchResult mo3009d(final Status status) {
            return new LeaveMatchResult() {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.internal.gp$d */
    private static abstract class C0981d extends C0463a<LoadMatchResult> {
        private C0981d() {
        }

        /* renamed from: G */
        public LoadMatchResult mo3009d(final Status status) {
            return new LoadMatchResult() {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.internal.gp$e */
    private static abstract class C0983e extends C0463a<LoadMatchesResult> {
        private C0983e() {
        }

        /* renamed from: H */
        public LoadMatchesResult mo3009d(final Status status) {
            return new LoadMatchesResult() {
                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.internal.gp$f */
    private static abstract class C0985f extends C0463a<UpdateMatchResult> {
        private C0985f() {
        }

        /* renamed from: I */
        public UpdateMatchResult mo3009d(final Status status) {
            return new UpdateMatchResult() {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, final String invitationId) {
        return apiClient.mo3258b(new C0977b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5337e(this, invitationId);
            }
        });
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo3258b(new C0975a(matchId) {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5360g(this, matchId);
            }
        });
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, final TurnBasedMatchConfig config) {
        return apiClient.mo3258b(new C0977b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5301a((C0299c<InitiateMatchResult>) this, config);
            }
        });
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m1012c(apiClient).mo5364m(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m1012c(apiClient).mo5363l(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.m1012c(apiClient).mo5322av(matchId);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, (byte[]) null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, final String matchId, final byte[] matchData, final ParticipantResult... results) {
        return apiClient.mo3258b(new C0985f() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5311a((C0299c<UpdateMatchResult>) this, matchId, matchData, results);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5352ft();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5341fC();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m1012c(apiClient).mo5293a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m1012c(apiClient).mo5293a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo3258b(new C0979c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5338f(this, matchId);
            }
        });
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, final String matchId, final String pendingParticipantId) {
        return apiClient.mo3258b(new C0979c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5307a((C0299c<LeaveMatchResult>) this, matchId, pendingParticipantId);
            }
        });
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo3257a(new C0981d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5361h(this, matchId);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, final int invitationSortOrder, final int[] matchTurnStatuses) {
        return apiClient.mo3257a(new C0983e() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5299a((C0299c<LoadMatchesResult>) this, invitationSortOrder, matchTurnStatuses);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.m1012c(apiClient).mo5317a(listener);
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo3258b(new C0977b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5335d((C0299c<InitiateMatchResult>) this, matchId);
            }
        });
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final String str2 = pendingParticipantId;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.mo3258b(new C0985f() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5310a((C0299c<UpdateMatchResult>) this, str, bArr, str2, participantResultArr);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.m1012c(apiClient).mo5355fw();
    }
}
