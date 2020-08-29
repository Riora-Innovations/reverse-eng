package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.c */
class C1421c extends C1371aj {

    /* renamed from: ID */
    private static final String f3648ID = C0502a.ADVERTISING_TRACKING_ENABLED.toString();

    /* renamed from: TC */
    private final C1358a f3649TC;

    public C1421c(Context context) {
        this(C1358a.m3977E(context));
    }

    C1421c(C1358a aVar) {
        super(f3648ID, new String[0]);
        this.f3649TC = aVar;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return false;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        return C1488di.m4388r(Boolean.valueOf(this.f3649TC.isLimitAdTrackingEnabled()));
    }
}
