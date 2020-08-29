package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.e */
class C1492e extends C1371aj {

    /* renamed from: ID */
    private static final String f3836ID = C0502a.ADWORDS_CLICK_REFERRER.toString();

    /* renamed from: TD */
    private static final String f3837TD = C0546b.COMPONENT.toString();

    /* renamed from: TE */
    private static final String f3838TE = C0546b.CONVERSION_ID.toString();

    /* renamed from: kL */
    private final Context f3839kL;

    public C1492e(Context context) {
        super(f3836ID, f3838TE);
        this.f3839kL = context;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        C0661a aVar = (C0661a) map.get(f3838TE);
        if (aVar == null) {
            return C1488di.m4378ku();
        }
        String j = C1488di.m4370j(aVar);
        C0661a aVar2 = (C0661a) map.get(f3837TD);
        String e = C1387ay.m4050e(this.f3839kL, j, aVar2 != null ? C1488di.m4370j(aVar2) : null);
        return e != null ? C1488di.m4388r(e) : C1488di.m4378ku();
    }
}
