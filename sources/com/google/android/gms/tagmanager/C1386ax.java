package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ax */
class C1386ax extends C1371aj {

    /* renamed from: ID */
    private static final String f3604ID = C0502a.INSTALL_REFERRER.toString();

    /* renamed from: TD */
    private static final String f3605TD = C0546b.COMPONENT.toString();

    /* renamed from: kL */
    private final Context f3606kL;

    public C1386ax(Context context) {
        super(f3604ID, new String[0]);
        this.f3606kL = context;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        String d = C1387ay.m4049d(this.f3606kL, ((C0661a) map.get(f3605TD)) != null ? C1488di.m4370j((C0661a) map.get(f3605TD)) : null);
        return d != null ? C1488di.m4388r(d) : C1488di.m4378ku();
    }
}
