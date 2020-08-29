package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0463a;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;

/* renamed from: com.google.android.gms.internal.gf */
public final class C0905gf implements Achievements {

    /* renamed from: com.google.android.gms.internal.gf$a */
    private static abstract class C0915a extends C0463a<LoadAchievementsResult> {
        private C0915a() {
        }

        /* renamed from: s */
        public LoadAchievementsResult mo3009d(final Status status) {
            return new LoadAchievementsResult() {
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.empty(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.internal.gf$b */
    private static abstract class C0917b extends C0463a<UpdateAchievementResult> {
        /* access modifiers changed from: private */

        /* renamed from: uS */
        public final String f2520uS;

        public C0917b(String str) {
            this.f2520uS = str;
        }

        /* renamed from: t */
        public UpdateAchievementResult mo3009d(final Status status) {
            return new UpdateAchievementResult() {
                public String getAchievementId() {
                    return C0917b.this.f2520uS;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5351fs();
    }

    public void increment(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.mo3258b(new C0917b(id) {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5303a(null, id, numSteps);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.mo3258b(new C0917b(id) {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5303a((C0299c<UpdateAchievementResult>) this, id, numSteps);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo3257a(new C0915a() {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5333c((C0299c<LoadAchievementsResult>) this, forceReload);
            }
        });
    }

    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.mo3258b(new C0917b(id) {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5325b(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo3258b(new C0917b(id) {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5325b((C0299c<UpdateAchievementResult>) this, id);
            }
        });
    }

    public void setSteps(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.mo3258b(new C0917b(id) {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5326b(null, id, numSteps);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.mo3258b(new C0917b(id) {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5326b((C0299c<UpdateAchievementResult>) this, id, numSteps);
            }
        });
    }

    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.mo3258b(new C0917b(id) {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5332c(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo3258b(new C0917b(id) {
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5332c((C0299c<UpdateAchievementResult>) this, id);
            }
        });
    }
}
