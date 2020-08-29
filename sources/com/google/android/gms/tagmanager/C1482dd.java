package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.dd */
abstract class C1482dd extends C1428cd {
    public C1482dd(String str) {
        super(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7640a(C0661a aVar, C0661a aVar2, Map<String, C0661a> map) {
        String j = C1488di.m4370j(aVar);
        String j2 = C1488di.m4370j(aVar2);
        if (j == C1488di.m4377kt() || j2 == C1488di.m4377kt()) {
            return false;
        }
        return mo7570a(j, j2, map);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo7570a(String str, String str2, Map<String, C0661a> map);
}
