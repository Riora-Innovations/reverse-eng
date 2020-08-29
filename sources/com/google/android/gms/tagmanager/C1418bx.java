package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.bx */
abstract class C1418bx extends C1428cd {
    public C1418bx(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7640a(C0661a aVar, C0661a aVar2, Map<String, C0661a> map) {
        C1487dh k = C1488di.m4371k(aVar);
        C1487dh k2 = C1488di.m4371k(aVar2);
        if (k == C1488di.m4376ks() || k2 == C1488di.m4376ks()) {
            return false;
        }
        return mo7580a(k, k2, map);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo7580a(C1487dh dhVar, C1487dh dhVar2, Map<String, C0661a> map);
}
