package com.google.android.gms.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.C0463a;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.go */
public final class C0956go implements Requests {

    /* renamed from: com.google.android.gms.internal.go$a */
    private static abstract class C0960a extends C0463a<LoadRequestsResult> {
        private C0960a() {
        }

        /* renamed from: B */
        public LoadRequestsResult mo3009d(final Status status) {
            return new LoadRequestsResult() {
                public GameRequestBuffer getRequests(int type) {
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

    /* renamed from: com.google.android.gms.internal.go$b */
    private static abstract class C0962b extends C0463a<UpdateRequestsResult> {
        private C0962b() {
        }

        /* renamed from: C */
        public UpdateRequestsResult mo3009d(final Status status) {
            return new UpdateRequestsResult() {
                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.mo3258b(new C0962b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5313a((C0299c<UpdateRequestsResult>) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.mo3258b(new C0962b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5329b((C0299c<UpdateRequestsResult>) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList<>();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList<>() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5342fD();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5344fF();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.m1012c(apiClient).mo5343fE();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.m1012c(apiClient).mo5294a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, final int requestDirection, final int types, final int sortOrder) {
        return apiClient.mo3257a(new C0960a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0819fx fxVar) {
                fxVar.mo5297a((C0299c<LoadRequestsResult>) this, requestDirection, types, sortOrder);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.m1012c(apiClient).mo5318a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.m1012c(apiClient).mo5356fx();
    }
}
