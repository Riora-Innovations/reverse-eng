package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.google.android.gms.tagmanager.ch */
class C1433ch extends C1371aj {

    /* renamed from: ID */
    private static final String f3685ID = C0502a.REGEX_GROUP.toString();

    /* renamed from: Wc */
    private static final String f3686Wc = C0546b.ARG0.toString();

    /* renamed from: Wd */
    private static final String f3687Wd = C0546b.ARG1.toString();

    /* renamed from: We */
    private static final String f3688We = C0546b.IGNORE_CASE.toString();

    /* renamed from: Wf */
    private static final String f3689Wf = C0546b.GROUP.toString();

    public C1433ch() {
        super(f3685ID, f3686Wc, f3687Wd);
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        int i;
        C0661a aVar = (C0661a) map.get(f3686Wc);
        C0661a aVar2 = (C0661a) map.get(f3687Wd);
        if (aVar == null || aVar == C1488di.m4378ku() || aVar2 == null || aVar2 == C1488di.m4378ku()) {
            return C1488di.m4378ku();
        }
        int i2 = 64;
        if (C1488di.m4383n((C0661a) map.get(f3688We)).booleanValue()) {
            i2 = 66;
        }
        C0661a aVar3 = (C0661a) map.get(f3689Wf);
        if (aVar3 != null) {
            Long l = C1488di.m4379l(aVar3);
            if (l == C1488di.m4373kp()) {
                return C1488di.m4378ku();
            }
            i = l.intValue();
            if (i < 0) {
                return C1488di.m4378ku();
            }
        } else {
            i = 1;
        }
        try {
            String j = C1488di.m4370j(aVar);
            String str = null;
            Matcher matcher = Pattern.compile(C1488di.m4370j(aVar2), i2).matcher(j);
            if (matcher.find() && matcher.groupCount() >= i) {
                str = matcher.group(i);
            }
            return str == null ? C1488di.m4378ku() : C1488di.m4388r(str);
        } catch (PatternSyntaxException e) {
            return C1488di.m4378ku();
        }
    }
}
