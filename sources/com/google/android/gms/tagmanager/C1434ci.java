package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.google.android.gms.tagmanager.ci */
class C1434ci extends C1482dd {

    /* renamed from: ID */
    private static final String f3690ID = C0502a.REGEX.toString();

    /* renamed from: We */
    private static final String f3691We = C0546b.IGNORE_CASE.toString();

    public C1434ci() {
        super(f3690ID);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7570a(String str, String str2, Map<String, C0661a> map) {
        try {
            return Pattern.compile(str2, C1488di.m4383n((C0661a) map.get(f3691We)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
