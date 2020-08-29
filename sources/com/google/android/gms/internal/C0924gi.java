package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0463a;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

/* renamed from: com.google.android.gms.internal.gi */
public final class C0924gi implements Invitations {

    /* renamed from: com.google.android.gms.internal.gi$a */
    private static abstract class C0926a extends C0463a<LoadInvitationsResult> {
        private C0926a() {
        }

        /* renamed from: v */
        public LoadInvitationsResult mo3009d(final Status status) {
            return new LoadInvitationsResult() {
                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.empty(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5353fu();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.mo3257a(new C0926a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5331c((C0299c<LoadInvitationsResult>) this, sortOrder);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m1012c(apiClient).mo5314a(listener);
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m1012c(apiClient).mo5354fv();
    }
}
