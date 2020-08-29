package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.ab */
class C0182ab {

    /* renamed from: tW */
    private final Map<String, Integer> f145tW = new HashMap();

    /* renamed from: tX */
    private final Map<String, String> f146tX = new HashMap();

    /* renamed from: tY */
    private final boolean f147tY;

    /* renamed from: tZ */
    private final String f148tZ;

    C0182ab(String str, boolean z) {
        this.f147tY = z;
        this.f148tZ = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo2870c(String str, int i) {
        if (this.f147tY) {
            Integer num = (Integer) this.f145tW.get(str);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.f145tW.put(str, Integer.valueOf(num.intValue() + i));
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cn */
    public String mo2871cn() {
        if (!this.f147tY) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f148tZ);
        for (String str : this.f145tW.keySet()) {
            sb.append("&").append(str).append("=").append(this.f145tW.get(str));
        }
        for (String str2 : this.f146tX.keySet()) {
            sb.append("&").append(str2).append("=").append((String) this.f146tX.get(str2));
        }
        return sb.toString();
    }
}
