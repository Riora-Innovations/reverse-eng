package com.google.android.gms.auth;

import android.content.Intent;

public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {

    /* renamed from: vs */
    private final int f370vs;

    GooglePlayServicesAvailabilityException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.f370vs = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.f370vs;
    }
}
