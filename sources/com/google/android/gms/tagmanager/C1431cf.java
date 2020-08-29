package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.cf */
class C1431cf extends C1371aj {

    /* renamed from: ID */
    private static final String f3682ID = C0502a.RANDOM.toString();

    /* renamed from: Wa */
    private static final String f3683Wa = C0546b.MIN.toString();

    /* renamed from: Wb */
    private static final String f3684Wb = C0546b.MAX.toString();

    public C1431cf() {
        super(f3682ID, new String[0]);
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return false;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        double d;
        double d2;
        C0661a aVar = (C0661a) map.get(f3683Wa);
        C0661a aVar2 = (C0661a) map.get(f3684Wb);
        if (!(aVar == null || aVar == C1488di.m4378ku() || aVar2 == null || aVar2 == C1488di.m4378ku())) {
            C1487dh k = C1488di.m4371k(aVar);
            C1487dh k2 = C1488di.m4371k(aVar2);
            if (!(k == C1488di.m4376ks() || k2 == C1488di.m4376ks())) {
                double doubleValue = k.doubleValue();
                d = k2.doubleValue();
                if (doubleValue <= d) {
                    d2 = doubleValue;
                    return C1488di.m4388r(Long.valueOf(Math.round(((d - d2) * Math.random()) + d2)));
                }
            }
        }
        d = 2.147483647E9d;
        d2 = 0.0d;
        return C1488di.m4388r(Long.valueOf(Math.round(((d - d2) * Math.random()) + d2)));
    }
}
