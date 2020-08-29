package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0660d.C0661a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.di */
class C1488di {

    /* renamed from: XI */
    private static final Object f3815XI = null;

    /* renamed from: XJ */
    private static Long f3816XJ = new Long(0);

    /* renamed from: XK */
    private static Double f3817XK = new Double(0.0d);

    /* renamed from: XL */
    private static C1487dh f3818XL = C1487dh.m4358v(0);

    /* renamed from: XM */
    private static String f3819XM = new String("");

    /* renamed from: XN */
    private static Boolean f3820XN = new Boolean(false);

    /* renamed from: XO */
    private static List<Object> f3821XO = new ArrayList(0);

    /* renamed from: XP */
    private static Map<Object, Object> f3822XP = new HashMap();

    /* renamed from: XQ */
    private static C0661a f3823XQ = m4388r(f3819XM);

    /* renamed from: bI */
    public static C0661a m4365bI(String str) {
        C0661a aVar = new C0661a();
        aVar.type = 5;
        aVar.f1792gd = str;
        return aVar;
    }

    /* renamed from: bJ */
    private static C1487dh m4366bJ(String str) {
        try {
            return C1487dh.m4357bH(str);
        } catch (NumberFormatException e) {
            C1401bh.m4075t("Failed to convert '" + str + "' to a number.");
            return f3818XL;
        }
    }

    /* renamed from: bK */
    private static Long m4367bK(String str) {
        C1487dh bJ = m4366bJ(str);
        return bJ == f3818XL ? f3816XJ : Long.valueOf(bJ.longValue());
    }

    /* renamed from: bL */
    private static Double m4368bL(String str) {
        C1487dh bJ = m4366bJ(str);
        return bJ == f3818XL ? f3817XK : Double.valueOf(bJ.doubleValue());
    }

    /* renamed from: bM */
    private static Boolean m4369bM(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : f3820XN;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        C1401bh.m4075t("getDouble received non-Number");
        return 0.0d;
    }

    /* renamed from: j */
    public static String m4370j(C0661a aVar) {
        return m4381m(m4385o(aVar));
    }

    /* renamed from: k */
    public static C1487dh m4371k(C0661a aVar) {
        return m4382n(m4385o(aVar));
    }

    /* renamed from: ko */
    public static Object m4372ko() {
        return f3815XI;
    }

    /* renamed from: kp */
    public static Long m4373kp() {
        return f3816XJ;
    }

    /* renamed from: kq */
    public static Double m4374kq() {
        return f3817XK;
    }

    /* renamed from: kr */
    public static Boolean m4375kr() {
        return f3820XN;
    }

    /* renamed from: ks */
    public static C1487dh m4376ks() {
        return f3818XL;
    }

    /* renamed from: kt */
    public static String m4377kt() {
        return f3819XM;
    }

    /* renamed from: ku */
    public static C0661a m4378ku() {
        return f3823XQ;
    }

    /* renamed from: l */
    public static Long m4379l(C0661a aVar) {
        return m4384o(m4385o(aVar));
    }

    /* renamed from: m */
    public static Double m4380m(C0661a aVar) {
        return m4386p(m4385o(aVar));
    }

    /* renamed from: m */
    public static String m4381m(Object obj) {
        return obj == null ? f3819XM : obj.toString();
    }

    /* renamed from: n */
    public static C1487dh m4382n(Object obj) {
        return obj instanceof C1487dh ? (C1487dh) obj : m4390t(obj) ? C1487dh.m4358v(m4391u(obj)) : m4389s(obj) ? C1487dh.m4356a(Double.valueOf(getDouble(obj))) : m4366bJ(m4381m(obj));
    }

    /* renamed from: n */
    public static Boolean m4383n(C0661a aVar) {
        return m4387q(m4385o(aVar));
    }

    /* renamed from: o */
    public static Long m4384o(Object obj) {
        return m4390t(obj) ? Long.valueOf(m4391u(obj)) : m4367bK(m4381m(obj));
    }

    /* renamed from: o */
    public static Object m4385o(C0661a aVar) {
        int i = 0;
        if (aVar == null) {
            return f3815XI;
        }
        switch (aVar.type) {
            case 1:
                return aVar.f1787fY;
            case 2:
                ArrayList arrayList = new ArrayList(aVar.f1788fZ.length);
                C0661a[] aVarArr = aVar.f1788fZ;
                int length = aVarArr.length;
                while (i < length) {
                    Object o = m4385o(aVarArr[i]);
                    if (o == f3815XI) {
                        return f3815XI;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case 3:
                if (aVar.f1789ga.length != aVar.f1790gb.length) {
                    C1401bh.m4075t("Converting an invalid value to object: " + aVar.toString());
                    return f3815XI;
                }
                HashMap hashMap = new HashMap(aVar.f1790gb.length);
                while (i < aVar.f1789ga.length) {
                    Object o2 = m4385o(aVar.f1789ga[i]);
                    Object o3 = m4385o(aVar.f1790gb[i]);
                    if (o2 == f3815XI || o3 == f3815XI) {
                        return f3815XI;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case 4:
                C1401bh.m4075t("Trying to convert a macro reference to object");
                return f3815XI;
            case 5:
                C1401bh.m4075t("Trying to convert a function id to object");
                return f3815XI;
            case 6:
                return Long.valueOf(aVar.f1793ge);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                C0661a[] aVarArr2 = aVar.f1795gg;
                int length2 = aVarArr2.length;
                while (i < length2) {
                    String j = m4370j(aVarArr2[i]);
                    if (j == f3819XM) {
                        return f3815XI;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(aVar.f1794gf);
            default:
                C1401bh.m4075t("Failed to convert a value of type: " + aVar.type);
                return f3815XI;
        }
    }

    /* renamed from: p */
    public static Double m4386p(Object obj) {
        return m4389s(obj) ? Double.valueOf(getDouble(obj)) : m4368bL(m4381m(obj));
    }

    /* renamed from: q */
    public static Boolean m4387q(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : m4369bM(m4381m(obj));
    }

    /* renamed from: r */
    public static C0661a m4388r(Object obj) {
        boolean z = false;
        C0661a aVar = new C0661a();
        if (obj instanceof C0661a) {
            return (C0661a) obj;
        }
        if (obj instanceof String) {
            aVar.type = 1;
            aVar.f1787fY = (String) obj;
        } else if (obj instanceof List) {
            aVar.type = 2;
            List<Object> list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            boolean z2 = false;
            for (Object r : list) {
                C0661a r2 = m4388r(r);
                if (r2 == f3823XQ) {
                    return f3823XQ;
                }
                boolean z3 = z2 || r2.f1797gi;
                arrayList.add(r2);
                z2 = z3;
            }
            aVar.f1788fZ = (C0661a[]) arrayList.toArray(new C0661a[0]);
            z = z2;
        } else if (obj instanceof Map) {
            aVar.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z4 = false;
            for (Entry entry : entrySet) {
                C0661a r3 = m4388r(entry.getKey());
                C0661a r4 = m4388r(entry.getValue());
                if (r3 == f3823XQ || r4 == f3823XQ) {
                    return f3823XQ;
                }
                boolean z5 = z4 || r3.f1797gi || r4.f1797gi;
                arrayList2.add(r3);
                arrayList3.add(r4);
                z4 = z5;
            }
            aVar.f1789ga = (C0661a[]) arrayList2.toArray(new C0661a[0]);
            aVar.f1790gb = (C0661a[]) arrayList3.toArray(new C0661a[0]);
            z = z4;
        } else if (m4389s(obj)) {
            aVar.type = 1;
            aVar.f1787fY = obj.toString();
        } else if (m4390t(obj)) {
            aVar.type = 6;
            aVar.f1793ge = m4391u(obj);
        } else if (obj instanceof Boolean) {
            aVar.type = 8;
            aVar.f1794gf = ((Boolean) obj).booleanValue();
        } else {
            C1401bh.m4075t("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return f3823XQ;
        }
        aVar.f1797gi = z;
        return aVar;
    }

    /* renamed from: s */
    private static boolean m4389s(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof C1487dh) && ((C1487dh) obj).mo7779kj());
    }

    /* renamed from: t */
    private static boolean m4390t(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof C1487dh) && ((C1487dh) obj).mo7780kk());
    }

    /* renamed from: u */
    private static long m4391u(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        C1401bh.m4075t("getInt64 received non-Number");
        return 0;
    }
}
