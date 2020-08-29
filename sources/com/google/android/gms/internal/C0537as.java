package com.google.android.gms.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.as */
public final class C0537as implements C0536ar {
    /* renamed from: a */
    private static boolean m1222a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    /* renamed from: b */
    private static int m1223b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return C0653cv.m1513aU();
            }
            if ("l".equalsIgnoreCase(str)) {
                return C0653cv.m1512aT();
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo4576a(C0665dd ddVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            C0662da.m1555w("Action missing from an open GMSG.");
            return;
        }
        C0667de bb = ddVar.mo4812bb();
        if ("expand".equalsIgnoreCase(str)) {
            if (ddVar.mo4815be()) {
                C0662da.m1555w("Cannot expand WebView that is already expanded.");
            } else {
                bb.mo4827a(m1222a(map), m1223b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            String str2 = (String) map.get("u");
            if (str2 != null) {
                bb.mo4828a(m1222a(map), m1223b(map), str2);
            } else {
                bb.mo4829a(m1222a(map), m1223b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else {
            bb.mo4823a(new C0580bn((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
