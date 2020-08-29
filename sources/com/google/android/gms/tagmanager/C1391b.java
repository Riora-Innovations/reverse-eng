package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.b */
class C1391b extends C1371aj {

    /* renamed from: ID */
    private static final String f3619ID = C0502a.ADVERTISER_ID.toString();

    /* renamed from: TC */
    private final C1358a f3620TC;

    public C1391b(Context context) {
        this(C1358a.m3977E(context));
    }

    C1391b(C1358a aVar) {
        super(f3619ID, new String[0]);
        this.f3620TC = aVar;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return false;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        String iu = this.f3620TC.mo7562iu();
        return iu == null ? C1488di.m4378ku() : C1488di.m4388r(iu);
    }
}
