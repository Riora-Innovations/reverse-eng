package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.dc */
class C1481dc extends C1482dd {

    /* renamed from: ID */
    private static final String f3808ID = C0502a.STARTS_WITH.toString();

    public C1481dc() {
        super(f3808ID);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7570a(String str, String str2, Map<String, C0661a> map) {
        return str.startsWith(str2);
    }
}
