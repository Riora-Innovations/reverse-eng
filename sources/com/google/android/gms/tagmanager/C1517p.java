package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.p */
class C1517p extends C1371aj {

    /* renamed from: ID */
    private static final String f3884ID = C0502a.CONTAINER_VERSION.toString();

    /* renamed from: Un */
    private final String f3885Un;

    public C1517p(String str) {
        super(f3884ID, new String[0]);
        this.f3885Un = str;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        return this.f3885Un == null ? C1488di.m4378ku() : C1488di.m4388r(this.f3885Un);
    }
}
