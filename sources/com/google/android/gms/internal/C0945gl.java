package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;

/* renamed from: com.google.android.gms.internal.gl */
public final class C0945gl implements Notifications {
    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.m1012c(apiClient).mo5320aU(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 7);
    }
}
