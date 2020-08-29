package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ad */
class C1365ad extends C1482dd {

    /* renamed from: ID */
    private static final String f3577ID = C0502a.ENDS_WITH.toString();

    public C1365ad() {
        super(f3577ID);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7570a(String str, String str2, Map<String, C0661a> map) {
        return str.endsWith(str2);
    }
}
