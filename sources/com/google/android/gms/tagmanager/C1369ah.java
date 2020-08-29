package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ah */
class C1369ah extends C1371aj {

    /* renamed from: ID */
    private static final String f3579ID = C0502a.EVENT.toString();

    /* renamed from: TO */
    private final C1459ct f3580TO;

    public C1369ah(C1459ct ctVar) {
        super(f3579ID, new String[0]);
        this.f3580TO = ctVar;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return false;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        String jY = this.f3580TO.mo7738jY();
        return jY == null ? C1488di.m4378ku() : C1488di.m4388r(jY);
    }
}
