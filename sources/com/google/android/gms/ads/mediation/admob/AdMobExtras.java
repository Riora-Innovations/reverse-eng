package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

public final class AdMobExtras implements NetworkExtras {

    /* renamed from: qs */
    private final Bundle f68qs;

    public AdMobExtras(Bundle extras) {
        this.f68qs = extras != null ? new Bundle(extras) : null;
    }

    public Bundle getExtras() {
        return this.f68qs;
    }
}
