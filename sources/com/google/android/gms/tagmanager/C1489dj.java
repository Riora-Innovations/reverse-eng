package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.achartengine.chartdemo.demo.chart.IDemoChart;

/* renamed from: com.google.android.gms.tagmanager.dj */
class C1489dj extends C1486dg {

    /* renamed from: ID */
    private static final String f3824ID = C0502a.UNIVERSAL_ANALYTICS.toString();

    /* renamed from: XR */
    private static final String f3825XR = C0546b.ACCOUNT.toString();

    /* renamed from: XS */
    private static final String f3826XS = C0546b.ANALYTICS_PASS_THROUGH.toString();

    /* renamed from: XT */
    private static final String f3827XT = C0546b.ANALYTICS_FIELDS.toString();

    /* renamed from: XU */
    private static final String f3828XU = C0546b.TRACK_TRANSACTION.toString();

    /* renamed from: XV */
    private static final String f3829XV = C0546b.TRANSACTION_DATALAYER_MAP.toString();

    /* renamed from: XW */
    private static final String f3830XW = C0546b.TRANSACTION_ITEM_DATALAYER_MAP.toString();

    /* renamed from: XX */
    private static Map<String, String> f3831XX;

    /* renamed from: XY */
    private static Map<String, String> f3832XY;

    /* renamed from: TN */
    private final DataLayer f3833TN;

    /* renamed from: XZ */
    private final Set<String> f3834XZ;

    /* renamed from: Ya */
    private final C1484df f3835Ya;

    public C1489dj(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new C1484df(context));
    }

    C1489dj(Context context, DataLayer dataLayer, C1484df dfVar) {
        super(f3824ID, new String[0]);
        this.f3833TN = dataLayer;
        this.f3835Ya = dfVar;
        this.f3834XZ = new HashSet();
        this.f3834XZ.add("");
        this.f3834XZ.add("0");
        this.f3834XZ.add("false");
    }

    /* renamed from: E */
    private Map<String, String> m4392E(Map<String, C0661a> map) {
        C0661a aVar = (C0661a) map.get(f3829XV);
        if (aVar != null) {
            return m4397c(aVar);
        }
        if (f3831XX == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            f3831XX = hashMap;
        }
        return f3831XX;
    }

    /* renamed from: F */
    private Map<String, String> m4393F(Map<String, C0661a> map) {
        C0661a aVar = (C0661a) map.get(f3830XW);
        if (aVar != null) {
            return m4397c(aVar);
        }
        if (f3832XY == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(IDemoChart.NAME, "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            f3832XY = hashMap;
        }
        return f3832XY;
    }

    /* renamed from: a */
    private void m4394a(Tracker tracker, Map<String, C0661a> map) {
        String bN = m4396bN("transactionId");
        if (bN == null) {
            C1401bh.m4075t("Cannot find transactionId in data layer.");
            return;
        }
        LinkedList<Map> linkedList = new LinkedList<>();
        try {
            Map p = m4400p((C0661a) map.get(f3827XT));
            p.put("&t", "transaction");
            for (Entry entry : m4392E(map).entrySet()) {
                m4395b(p, (String) entry.getValue(), m4396bN((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> kv = m4399kv();
            if (kv != null) {
                for (Map map2 : kv) {
                    if (map2.get(IDemoChart.NAME) == null) {
                        C1401bh.m4075t("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p2 = m4400p((C0661a) map.get(f3827XT));
                    p2.put("&t", "item");
                    p2.put("&ti", bN);
                    for (Entry entry2 : m4393F(map).entrySet()) {
                        m4395b(p2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map send : linkedList) {
                tracker.send(send);
            }
        } catch (IllegalArgumentException e) {
            C1401bh.m4073c("Unable to send transaction", e);
        }
    }

    /* renamed from: b */
    private void m4395b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    /* renamed from: bN */
    private String m4396bN(String str) {
        Object obj = this.f3833TN.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    /* renamed from: c */
    private Map<String, String> m4397c(C0661a aVar) {
        Object o = C1488di.m4385o(aVar);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    /* renamed from: d */
    private boolean m4398d(Map<String, C0661a> map, String str) {
        C0661a aVar = (C0661a) map.get(str);
        if (aVar == null) {
            return false;
        }
        return C1488di.m4383n(aVar).booleanValue();
    }

    /* renamed from: kv */
    private List<Map<String, String>> m4399kv() {
        Object obj = this.f3833TN.get("transactionProducts");
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        for (Object obj2 : (List) obj) {
            if (!(obj2 instanceof Map)) {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }
        return (List) obj;
    }

    /* renamed from: p */
    private Map<String, String> m4400p(C0661a aVar) {
        if (aVar == null) {
            return new HashMap();
        }
        Map c = m4397c(aVar);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get("&aip");
        if (str != null && this.f3834XZ.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    /* renamed from: w */
    public void mo7770w(Map<String, C0661a> map) {
        Tracker bF = this.f3835Ya.mo7769bF("_GTM_DEFAULT_TRACKER_");
        if (m4398d(map, f3826XS)) {
            bF.send(m4400p((C0661a) map.get(f3827XT)));
        } else if (m4398d(map, f3828XU)) {
            m4394a(bF, map);
        } else {
            C1401bh.m4078w("Ignoring unknown tag.");
        }
    }
}
