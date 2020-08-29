package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.cd */
abstract class C1428cd extends C1371aj {

    /* renamed from: US */
    private static final String f3671US = C0546b.ARG0.toString();

    /* renamed from: VQ */
    private static final String f3672VQ = C0546b.ARG1.toString();

    public C1428cd(String str) {
        super(str, f3671US, f3672VQ);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo7640a(C0661a aVar, C0661a aVar2, Map<String, C0661a> map);

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        for (C0661a aVar : map.values()) {
            if (aVar == C1488di.m4378ku()) {
                return C1488di.m4388r(Boolean.valueOf(false));
            }
        }
        C0661a aVar2 = (C0661a) map.get(f3671US);
        C0661a aVar3 = (C0661a) map.get(f3672VQ);
        return C1488di.m4388r(Boolean.valueOf((aVar2 == null || aVar3 == null) ? false : mo7640a(aVar2, aVar3, map)));
    }
}
