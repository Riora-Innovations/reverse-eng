package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p004au.com.bytecode.opencsv.CSVParser;

/* renamed from: com.google.android.gms.tagmanager.az */
class C1388az extends C1371aj {

    /* renamed from: ID */
    private static final String f3609ID = C0502a.JOINER.toString();

    /* renamed from: US */
    private static final String f3610US = C0546b.ARG0.toString();

    /* renamed from: Vo */
    private static final String f3611Vo = C0546b.ITEM_SEPARATOR.toString();

    /* renamed from: Vp */
    private static final String f3612Vp = C0546b.KEY_VALUE_SEPARATOR.toString();

    /* renamed from: Vq */
    private static final String f3613Vq = C0546b.ESCAPE.toString();

    /* renamed from: com.google.android.gms.tagmanager.az$a */
    private enum C1390a {
        NONE,
        URL,
        BACKSLASH
    }

    public C1388az() {
        super(f3609ID, f3610US);
    }

    /* renamed from: a */
    private String m4053a(String str, C1390a aVar, Set<Character> set) {
        switch (aVar) {
            case URL:
                try {
                    return C1491dl.m4410bO(str);
                } catch (UnsupportedEncodingException e) {
                    C1401bh.m4073c("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                Iterator it = set.iterator();
                while (true) {
                    String str2 = replace;
                    if (!it.hasNext()) {
                        return str2;
                    }
                    String ch = ((Character) it.next()).toString();
                    replace = str2.replace(ch, "\\" + ch);
                }
            default:
                return str;
        }
    }

    /* renamed from: a */
    private void m4054a(StringBuilder sb, String str, C1390a aVar, Set<Character> set) {
        sb.append(m4053a(str, aVar, set));
    }

    /* renamed from: a */
    private void m4055a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return true;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        HashSet hashSet;
        C1390a aVar;
        C0661a aVar2 = (C0661a) map.get(f3610US);
        if (aVar2 == null) {
            return C1488di.m4378ku();
        }
        C0661a aVar3 = (C0661a) map.get(f3611Vo);
        String str = aVar3 != null ? C1488di.m4370j(aVar3) : "";
        C0661a aVar4 = (C0661a) map.get(f3612Vp);
        String str2 = aVar4 != null ? C1488di.m4370j(aVar4) : "=";
        C1390a aVar5 = C1390a.NONE;
        C0661a aVar6 = (C0661a) map.get(f3613Vq);
        if (aVar6 != null) {
            String j = C1488di.m4370j(aVar6);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j)) {
                aVar = C1390a.URL;
                hashSet = null;
            } else if ("backslash".equals(j)) {
                aVar = C1390a.BACKSLASH;
                hashSet = new HashSet();
                m4055a(hashSet, str);
                m4055a(hashSet, str2);
                hashSet.remove(Character.valueOf(CSVParser.DEFAULT_ESCAPE_CHARACTER));
            } else {
                C1401bh.m4075t("Joiner: unsupported escape type: " + j);
                return C1488di.m4378ku();
            }
        } else {
            hashSet = null;
            aVar = aVar5;
        }
        StringBuilder sb = new StringBuilder();
        switch (aVar2.type) {
            case 2:
                boolean z = true;
                C0661a[] aVarArr = aVar2.f1788fZ;
                int length = aVarArr.length;
                int i = 0;
                while (i < length) {
                    C0661a aVar7 = aVarArr[i];
                    if (!z) {
                        sb.append(str);
                    }
                    m4054a(sb, C1488di.m4370j(aVar7), aVar, hashSet);
                    i++;
                    z = false;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < aVar2.f1789ga.length; i2++) {
                    if (i2 > 0) {
                        sb.append(str);
                    }
                    String j2 = C1488di.m4370j(aVar2.f1789ga[i2]);
                    String j3 = C1488di.m4370j(aVar2.f1790gb[i2]);
                    m4054a(sb, j2, aVar, hashSet);
                    sb.append(str2);
                    m4054a(sb, j3, aVar, hashSet);
                }
                break;
            default:
                m4054a(sb, C1488di.m4370j(aVar2), aVar, hashSet);
                break;
        }
        return C1488di.m4388r(sb.toString());
    }
}
