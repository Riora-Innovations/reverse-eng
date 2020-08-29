package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.y */
class C0239y {
    /* renamed from: a */
    static String m293a(C0238x xVar, long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(xVar.mo2986ch());
        if (xVar.mo2988cj() > 0) {
            long cj = j - xVar.mo2988cj();
            if (cj >= 0) {
                sb.append("&qt").append("=").append(cj);
            }
        }
        sb.append("&z").append("=").append(xVar.mo2987ci());
        return sb.toString();
    }

    static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }

    /* renamed from: s */
    static Map<String, String> m294s(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                String substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }
}
