package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.u */
class C1523u extends C1371aj {

    /* renamed from: ID */
    private static final String f3892ID = C0502a.CUSTOM_VAR.toString();
    private static final String NAME = C0546b.NAME.toString();

    /* renamed from: UC */
    private static final String f3893UC = C0546b.DEFAULT_VALUE.toString();

    /* renamed from: TN */
    private final DataLayer f3894TN;

    public C1523u(DataLayer dataLayer) {
        super(f3892ID, NAME);
        this.f3894TN = dataLayer;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return false;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        Object obj = this.f3894TN.get(C1488di.m4370j((C0661a) map.get(NAME)));
        if (obj != null) {
            return C1488di.m4388r(obj);
        }
        C0661a aVar = (C0661a) map.get(f3893UC);
        return aVar != null ? aVar : C1488di.m4378ku();
    }
}
