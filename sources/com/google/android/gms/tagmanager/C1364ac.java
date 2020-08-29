package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ac */
class C1364ac extends C1371aj {

    /* renamed from: ID */
    private static final String f3572ID = C0502a.ENCODE.toString();

    /* renamed from: US */
    private static final String f3573US = C0546b.ARG0.toString();

    /* renamed from: UT */
    private static final String f3574UT = C0546b.NO_PADDING.toString();

    /* renamed from: UU */
    private static final String f3575UU = C0546b.INPUT_FORMAT.toString();

    /* renamed from: UV */
    private static final String f3576UV = C0546b.OUTPUT_FORMAT.toString();

    public C1364ac() {
        super(f3572ID, f3573US);
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        byte[] decode;
        String encodeToString;
        C0661a aVar = (C0661a) map.get(f3573US);
        if (aVar == null || aVar == C1488di.m4378ku()) {
            return C1488di.m4378ku();
        }
        String j = C1488di.m4370j(aVar);
        C0661a aVar2 = (C0661a) map.get(f3575UU);
        String j2 = aVar2 == null ? "text" : C1488di.m4370j(aVar2);
        C0661a aVar3 = (C0661a) map.get(f3576UV);
        String j3 = aVar3 == null ? "base16" : C1488di.m4370j(aVar3);
        C0661a aVar4 = (C0661a) map.get(f3574UT);
        int i = (aVar4 == null || !C1488di.m4383n(aVar4).booleanValue()) ? 2 : 3;
        try {
            if ("text".equals(j2)) {
                decode = j.getBytes();
            } else if ("base16".equals(j2)) {
                decode = C1499j.m4426aX(j);
            } else if ("base64".equals(j2)) {
                decode = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                decode = Base64.decode(j, i | 8);
            } else {
                C1401bh.m4075t("Encode: unknown input format: " + j2);
                return C1488di.m4378ku();
            }
            if ("base16".equals(j3)) {
                encodeToString = C1499j.m4427d(decode);
            } else if ("base64".equals(j3)) {
                encodeToString = Base64.encodeToString(decode, i);
            } else if ("base64url".equals(j3)) {
                encodeToString = Base64.encodeToString(decode, i | 8);
            } else {
                C1401bh.m4075t("Encode: unknown output format: " + j3);
                return C1488di.m4378ku();
            }
            return C1488di.m4388r(encodeToString);
        } catch (IllegalArgumentException e) {
            C1401bh.m4075t("Encode: invalid input:");
            return C1488di.m4378ku();
        }
    }
}
