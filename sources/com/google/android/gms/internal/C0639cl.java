package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.cl */
public final class C0639cl {
    private int mOrientation = -1;

    /* renamed from: oC */
    private String f1692oC;

    /* renamed from: oD */
    private String f1693oD;

    /* renamed from: oE */
    private String f1694oE;

    /* renamed from: oF */
    private List<String> f1695oF;

    /* renamed from: oG */
    private List<String> f1696oG;

    /* renamed from: oH */
    private long f1697oH = -1;

    /* renamed from: oI */
    private boolean f1698oI = false;

    /* renamed from: oJ */
    private final long f1699oJ = -1;

    /* renamed from: oK */
    private List<String> f1700oK;

    /* renamed from: oL */
    private long f1701oL = -1;

    /* renamed from: a */
    private static long m1456a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                C0662da.m1555w("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    /* renamed from: b */
    private static List<String> m1457b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    /* renamed from: e */
    private void m1458e(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Ad-Size");
        if (list != null && !list.isEmpty()) {
            this.f1692oC = (String) list.get(0);
        }
    }

    /* renamed from: f */
    private void m1459f(Map<String, List<String>> map) {
        List<String> b = m1457b(map, "X-Afma-Click-Tracking-Urls");
        if (b != null) {
            this.f1695oF = b;
        }
    }

    /* renamed from: g */
    private void m1460g(Map<String, List<String>> map) {
        List<String> b = m1457b(map, "X-Afma-Tracking-Urls");
        if (b != null) {
            this.f1696oG = b;
        }
    }

    /* renamed from: h */
    private void m1461h(Map<String, List<String>> map) {
        long a = m1456a(map, "X-Afma-Interstitial-Timeout");
        if (a != -1) {
            this.f1697oH = a;
        }
    }

    /* renamed from: i */
    private void m1462i(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.f1698oI = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    /* renamed from: j */
    private void m1463j(Map<String, List<String>> map) {
        List<String> b = m1457b(map, "X-Afma-Manual-Tracking-Urls");
        if (b != null) {
            this.f1700oK = b;
        }
    }

    /* renamed from: k */
    private void m1464k(Map<String, List<String>> map) {
        long a = m1456a(map, "X-Afma-Refresh-Rate");
        if (a != -1) {
            this.f1701oL = a;
        }
    }

    /* renamed from: l */
    private void m1465l(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = C0653cv.m1513aU();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = C0653cv.m1512aT();
            }
        }
    }

    /* renamed from: a */
    public void mo4765a(String str, Map<String, List<String>> map, String str2) {
        this.f1693oD = str;
        this.f1694oE = str2;
        mo4766d(map);
    }

    /* renamed from: d */
    public void mo4766d(Map<String, List<String>> map) {
        m1458e(map);
        m1459f(map);
        m1460g(map);
        m1461h(map);
        m1462i(map);
        m1463j(map);
        m1464k(map);
        m1465l(map);
    }

    /* renamed from: f */
    public C0628cf mo4767f(long j) {
        return new C0628cf(this.f1693oD, this.f1694oE, this.f1695oF, this.f1696oG, this.f1697oH, this.f1698oI, -1, this.f1700oK, this.f1701oL, this.mOrientation, this.f1692oC, j);
    }
}
