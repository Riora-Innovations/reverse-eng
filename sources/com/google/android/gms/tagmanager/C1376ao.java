package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ao */
class C1376ao extends C1371aj {

    /* renamed from: ID */
    private static final String f3586ID = C0502a.HASH.toString();

    /* renamed from: US */
    private static final String f3587US = C0546b.ARG0.toString();

    /* renamed from: UU */
    private static final String f3588UU = C0546b.INPUT_FORMAT.toString();

    /* renamed from: UY */
    private static final String f3589UY = C0546b.ALGORITHM.toString();

    public C1376ao() {
        super(f3586ID, f3587US);
    }

    /* renamed from: c */
    private byte[] m4016c(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        byte[] aX;
        C0661a aVar = (C0661a) map.get(f3587US);
        if (aVar == null || aVar == C1488di.m4378ku()) {
            return C1488di.m4378ku();
        }
        String j = C1488di.m4370j(aVar);
        C0661a aVar2 = (C0661a) map.get(f3589UY);
        String j2 = aVar2 == null ? "MD5" : C1488di.m4370j(aVar2);
        C0661a aVar3 = (C0661a) map.get(f3588UU);
        String j3 = aVar3 == null ? "text" : C1488di.m4370j(aVar3);
        if ("text".equals(j3)) {
            aX = j.getBytes();
        } else if ("base16".equals(j3)) {
            aX = C1499j.m4426aX(j);
        } else {
            C1401bh.m4075t("Hash: unknown input format: " + j3);
            return C1488di.m4378ku();
        }
        try {
            return C1488di.m4388r(C1499j.m4427d(m4016c(j2, aX)));
        } catch (NoSuchAlgorithmException e) {
            C1401bh.m4075t("Hash: unknown algorithm: " + j2);
            return C1488di.m4378ku();
        }
    }
}
