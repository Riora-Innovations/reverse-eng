package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.bm */
class C1406bm {
    C1406bm() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: iA */
    public int mo7616iA() {
        return VERSION.SDK_INT;
    }

    /* renamed from: ji */
    public C1405bl mo7617ji() {
        return mo7616iA() < 8 ? new C1384av() : new C1385aw();
    }
}
