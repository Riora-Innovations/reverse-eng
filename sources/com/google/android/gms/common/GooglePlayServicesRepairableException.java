package com.google.android.gms.common;

import android.content.Intent;

public class GooglePlayServicesRepairableException extends UserRecoverableException {

    /* renamed from: vs */
    private final int f488vs;

    GooglePlayServicesRepairableException(int connectionStatusCode, String msg, Intent intent) {
        super(msg, intent);
        this.f488vs = connectionStatusCode;
    }

    public int getConnectionStatusCode() {
        return this.f488vs;
    }
}
