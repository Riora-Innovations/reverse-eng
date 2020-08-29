package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0660d.C0661a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.dl */
class C1491dl {
    /* renamed from: a */
    private static C1419by<C0661a> m4407a(C1419by<C0661a> byVar) {
        try {
            return new C1419by(C1488di.m4388r(m4410bO(C1488di.m4370j((C0661a) byVar.getObject()))), byVar.mo7642jr());
        } catch (UnsupportedEncodingException e) {
            C1401bh.m4073c("Escape URI: unsupported encoding", e);
            return byVar;
        }
    }

    /* renamed from: a */
    private static C1419by<C0661a> m4408a(C1419by<C0661a> byVar, int i) {
        if (!m4411q((C0661a) byVar.getObject())) {
            C1401bh.m4075t("Escaping can only be applied to strings.");
            return byVar;
        }
        switch (i) {
            case 12:
                return m4407a(byVar);
            default:
                C1401bh.m4075t("Unsupported Value Escaping: " + i);
                return byVar;
        }
    }

    /* renamed from: a */
    static C1419by<C0661a> m4409a(C1419by<C0661a> byVar, int... iArr) {
        for (int a : iArr) {
            byVar = m4408a(byVar, a);
        }
        return byVar;
    }

    /* renamed from: bO */
    static String m4410bO(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    /* renamed from: q */
    private static boolean m4411q(C0661a aVar) {
        return C1488di.m4385o(aVar) instanceof String;
    }
}
