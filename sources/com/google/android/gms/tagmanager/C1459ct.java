package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0608c.C0617i;
import com.google.android.gms.internal.C0660d.C0661a;
import com.google.android.gms.tagmanager.C1449cr.C1451a;
import com.google.android.gms.tagmanager.C1449cr.C1453c;
import com.google.android.gms.tagmanager.C1449cr.C1455e;
import com.google.android.gms.tagmanager.C1501l.C1503a;
import com.google.android.gms.tagmanager.C1520s.C1521a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.ct */
class C1459ct {

    /* renamed from: WH */
    private static final C1419by<C0661a> f3747WH = new C1419by<>(C1488di.m4378ku(), true);

    /* renamed from: TN */
    private final DataLayer f3748TN;

    /* renamed from: WI */
    private final C1453c f3749WI;

    /* renamed from: WJ */
    private final C1368ag f3750WJ;

    /* renamed from: WK */
    private final Map<String, C1371aj> f3751WK;

    /* renamed from: WL */
    private final Map<String, C1371aj> f3752WL;

    /* renamed from: WM */
    private final Map<String, C1371aj> f3753WM;

    /* renamed from: WN */
    private final C1500k<C1451a, C1419by<C0661a>> f3754WN;

    /* renamed from: WO */
    private final C1500k<String, C1465b> f3755WO;

    /* renamed from: WP */
    private final Set<C1455e> f3756WP;

    /* renamed from: WQ */
    private final Map<String, C1466c> f3757WQ;

    /* renamed from: WR */
    private volatile String f3758WR;

    /* renamed from: WS */
    private int f3759WS;

    /* renamed from: com.google.android.gms.tagmanager.ct$a */
    interface C1464a {
        /* renamed from: a */
        void mo7742a(C1455e eVar, Set<C1451a> set, Set<C1451a> set2, C1439cn cnVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$b */
    private static class C1465b {

        /* renamed from: WY */
        private C1419by<C0661a> f3768WY;

        /* renamed from: Wt */
        private C0661a f3769Wt;

        public C1465b(C1419by<C0661a> byVar, C0661a aVar) {
            this.f3768WY = byVar;
            this.f3769Wt = aVar;
        }

        public int getSize() {
            return (this.f3769Wt == null ? 0 : this.f3769Wt.mo3800eW()) + ((C0661a) this.f3768WY.getObject()).mo3800eW();
        }

        /* renamed from: jG */
        public C0661a mo7744jG() {
            return this.f3769Wt;
        }

        /* renamed from: ka */
        public C1419by<C0661a> mo7745ka() {
            return this.f3768WY;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.ct$c */
    private static class C1466c {

        /* renamed from: WP */
        private final Set<C1455e> f3770WP = new HashSet();

        /* renamed from: WZ */
        private final Map<C1455e, List<C1451a>> f3771WZ = new HashMap();

        /* renamed from: Xa */
        private final Map<C1455e, List<C1451a>> f3772Xa = new HashMap();

        /* renamed from: Xb */
        private final Map<C1455e, List<String>> f3773Xb = new HashMap();

        /* renamed from: Xc */
        private final Map<C1455e, List<String>> f3774Xc = new HashMap();

        /* renamed from: Xd */
        private C1451a f3775Xd;

        /* renamed from: a */
        public void mo7746a(C1455e eVar, C1451a aVar) {
            List list = (List) this.f3771WZ.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.f3771WZ.put(eVar, list);
            }
            list.add(aVar);
        }

        /* renamed from: a */
        public void mo7747a(C1455e eVar, String str) {
            List list = (List) this.f3773Xb.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.f3773Xb.put(eVar, list);
            }
            list.add(str);
        }

        /* renamed from: b */
        public void mo7748b(C1455e eVar) {
            this.f3770WP.add(eVar);
        }

        /* renamed from: b */
        public void mo7749b(C1455e eVar, C1451a aVar) {
            List list = (List) this.f3772Xa.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.f3772Xa.put(eVar, list);
            }
            list.add(aVar);
        }

        /* renamed from: b */
        public void mo7750b(C1455e eVar, String str) {
            List list = (List) this.f3774Xc.get(eVar);
            if (list == null) {
                list = new ArrayList();
                this.f3774Xc.put(eVar, list);
            }
            list.add(str);
        }

        /* renamed from: i */
        public void mo7751i(C1451a aVar) {
            this.f3775Xd = aVar;
        }

        /* renamed from: kb */
        public Set<C1455e> mo7752kb() {
            return this.f3770WP;
        }

        /* renamed from: kc */
        public Map<C1455e, List<C1451a>> mo7753kc() {
            return this.f3771WZ;
        }

        /* renamed from: kd */
        public Map<C1455e, List<String>> mo7754kd() {
            return this.f3773Xb;
        }

        /* renamed from: ke */
        public Map<C1455e, List<String>> mo7755ke() {
            return this.f3774Xc;
        }

        /* renamed from: kf */
        public Map<C1455e, List<C1451a>> mo7756kf() {
            return this.f3772Xa;
        }

        /* renamed from: kg */
        public C1451a mo7757kg() {
            return this.f3775Xd;
        }
    }

    public C1459ct(Context context, C1453c cVar, DataLayer dataLayer, C1521a aVar, C1521a aVar2, C1368ag agVar) {
        if (cVar == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.f3749WI = cVar;
        this.f3756WP = new HashSet(cVar.mo7697jJ());
        this.f3748TN = dataLayer;
        this.f3750WJ = agVar;
        this.f3754WN = new C1501l().mo7790a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C1503a<C1451a, C1419by<C0661a>>() {
            /* renamed from: a */
            public int sizeOf(C1451a aVar, C1419by<C0661a> byVar) {
                return ((C0661a) byVar.getObject()).mo3800eW();
            }
        });
        this.f3755WO = new C1501l().mo7790a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C1503a<String, C1465b>() {
            /* renamed from: a */
            public int sizeOf(String str, C1465b bVar) {
                return str.length() + bVar.getSize();
            }
        });
        this.f3751WK = new HashMap();
        mo7732b(new C1496i(context));
        mo7732b(new C1520s(aVar2));
        mo7732b(new C1530w(dataLayer));
        mo7732b(new C1489dj(context, dataLayer));
        this.f3752WL = new HashMap();
        mo7736c(new C1518q());
        mo7736c(new C1365ad());
        mo7736c(new C1366ae());
        mo7736c(new C1373al());
        mo7736c(new C1374am());
        mo7736c(new C1396bd());
        mo7736c(new C1397be());
        mo7736c(new C1434ci());
        mo7736c(new C1481dc());
        this.f3753WM = new HashMap();
        mo7731a(new C1391b(context));
        mo7731a(new C1421c(context));
        mo7731a(new C1492e(context));
        mo7731a(new C1493f(context));
        mo7731a(new C1494g(context));
        mo7731a(new C1495h(context));
        mo7731a(new C1504m());
        mo7731a(new C1517p(this.f3749WI.getVersion()));
        mo7731a(new C1520s(aVar));
        mo7731a(new C1523u(dataLayer));
        mo7731a(new C1533z(context));
        mo7731a(new C1362aa());
        mo7731a(new C1364ac());
        mo7731a(new C1369ah(this));
        mo7731a(new C1375an());
        mo7731a(new C1376ao());
        mo7731a(new C1386ax(context));
        mo7731a(new C1388az());
        mo7731a(new C1395bc());
        mo7731a(new C1404bk(context));
        mo7731a(new C1420bz());
        mo7731a(new C1427cc());
        mo7731a(new C1431cf());
        mo7731a(new C1433ch());
        mo7731a(new C1435cj(context));
        mo7731a(new C1467cu());
        mo7731a(new C1468cv());
        mo7731a(new C1483de());
        this.f3757WQ = new HashMap();
        for (C1455e eVar : this.f3756WP) {
            if (agVar.mo7576jb()) {
                m4272a(eVar.mo7709jR(), eVar.mo7710jS(), "add macro");
                m4272a(eVar.mo7714jW(), eVar.mo7711jT(), "remove macro");
                m4272a(eVar.mo7707jP(), eVar.mo7712jU(), "add tag");
                m4272a(eVar.mo7708jQ(), eVar.mo7713jV(), "remove tag");
            }
            for (int i = 0; i < eVar.mo7709jR().size(); i++) {
                C1451a aVar3 = (C1451a) eVar.mo7709jR().get(i);
                String str = "Unknown";
                if (agVar.mo7576jb() && i < eVar.mo7710jS().size()) {
                    str = (String) eVar.mo7710jS().get(i);
                }
                C1466c c = m4274c(this.f3757WQ, m4275h(aVar3));
                c.mo7748b(eVar);
                c.mo7746a(eVar, aVar3);
                c.mo7747a(eVar, str);
            }
            for (int i2 = 0; i2 < eVar.mo7714jW().size(); i2++) {
                C1451a aVar4 = (C1451a) eVar.mo7714jW().get(i2);
                String str2 = "Unknown";
                if (agVar.mo7576jb() && i2 < eVar.mo7711jT().size()) {
                    str2 = (String) eVar.mo7711jT().get(i2);
                }
                C1466c c2 = m4274c(this.f3757WQ, m4275h(aVar4));
                c2.mo7748b(eVar);
                c2.mo7749b(eVar, aVar4);
                c2.mo7750b(eVar, str2);
            }
        }
        for (Entry entry : this.f3749WI.mo7698jK().entrySet()) {
            for (C1451a aVar5 : (List) entry.getValue()) {
                if (!C1488di.m4383n((C0661a) aVar5.mo7690jF().get(C0546b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m4274c(this.f3757WQ, (String) entry.getKey()).mo7751i(aVar5);
                }
            }
        }
    }

    /* renamed from: a */
    private C1419by<C0661a> m4267a(C0661a aVar, Set<String> set, C1490dk dkVar) {
        if (!aVar.f1797gi) {
            return new C1419by<>(aVar, true);
        }
        switch (aVar.type) {
            case 2:
                C0661a g = C1449cr.m4226g(aVar);
                g.f1788fZ = new C0661a[aVar.f1788fZ.length];
                for (int i = 0; i < aVar.f1788fZ.length; i++) {
                    C1419by<C0661a> a = m4267a(aVar.f1788fZ[i], set, dkVar.mo7635bS(i));
                    if (a == f3747WH) {
                        return f3747WH;
                    }
                    g.f1788fZ[i] = (C0661a) a.getObject();
                }
                return new C1419by<>(g, false);
            case 3:
                C0661a g2 = C1449cr.m4226g(aVar);
                if (aVar.f1789ga.length != aVar.f1790gb.length) {
                    C1401bh.m4075t("Invalid serving value: " + aVar.toString());
                    return f3747WH;
                }
                g2.f1789ga = new C0661a[aVar.f1789ga.length];
                g2.f1790gb = new C0661a[aVar.f1789ga.length];
                for (int i2 = 0; i2 < aVar.f1789ga.length; i2++) {
                    C1419by<C0661a> a2 = m4267a(aVar.f1789ga[i2], set, dkVar.mo7636bT(i2));
                    C1419by<C0661a> a3 = m4267a(aVar.f1790gb[i2], set, dkVar.mo7637bU(i2));
                    if (a2 == f3747WH || a3 == f3747WH) {
                        return f3747WH;
                    }
                    g2.f1789ga[i2] = (C0661a) a2.getObject();
                    g2.f1790gb[i2] = (C0661a) a3.getObject();
                }
                return new C1419by<>(g2, false);
            case 4:
                if (set.contains(aVar.f1791gc)) {
                    C1401bh.m4075t("Macro cycle detected.  Current macro reference: " + aVar.f1791gc + "." + "  Previous macro references: " + set.toString() + ".");
                    return f3747WH;
                }
                set.add(aVar.f1791gc);
                C1419by<C0661a> a4 = C1491dl.m4409a(m4268a(aVar.f1791gc, set, dkVar.mo7639jq()), aVar.f1796gh);
                set.remove(aVar.f1791gc);
                return a4;
            case 7:
                C0661a g3 = C1449cr.m4226g(aVar);
                g3.f1795gg = new C0661a[aVar.f1795gg.length];
                for (int i3 = 0; i3 < aVar.f1795gg.length; i3++) {
                    C1419by<C0661a> a5 = m4267a(aVar.f1795gg[i3], set, dkVar.mo7638bV(i3));
                    if (a5 == f3747WH) {
                        return f3747WH;
                    }
                    g3.f1795gg[i3] = (C0661a) a5.getObject();
                }
                return new C1419by<>(g3, false);
            default:
                C1401bh.m4075t("Unknown type: " + aVar.type);
                return f3747WH;
        }
    }

    /* renamed from: a */
    private C1419by<C0661a> m4268a(String str, Set<String> set, C1403bj bjVar) {
        C1451a aVar;
        this.f3759WS++;
        C1465b bVar = (C1465b) this.f3755WO.get(str);
        if (bVar == null || this.f3750WJ.mo7576jb()) {
            C1466c cVar = (C1466c) this.f3757WQ.get(str);
            if (cVar == null) {
                C1401bh.m4075t(m4276jZ() + "Invalid macro: " + str);
                this.f3759WS--;
                return f3747WH;
            }
            C1419by a = mo7729a(str, cVar.mo7752kb(), cVar.mo7753kc(), cVar.mo7754kd(), cVar.mo7756kf(), cVar.mo7755ke(), set, bjVar.mo7613iS());
            if (((Set) a.getObject()).isEmpty()) {
                aVar = cVar.mo7757kg();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    C1401bh.m4078w(m4276jZ() + "Multiple macros active for macroName " + str);
                }
                aVar = (C1451a) ((Set) a.getObject()).iterator().next();
            }
            if (aVar == null) {
                this.f3759WS--;
                return f3747WH;
            }
            C1419by<C0661a> a2 = m4269a(this.f3753WM, aVar, set, bjVar.mo7614jh());
            C1419by byVar = a2 == f3747WH ? f3747WH : new C1419by(a2.getObject(), a.mo7642jr() && a2.mo7642jr());
            C0661a jG = aVar.mo7691jG();
            if (byVar.mo7642jr()) {
                this.f3755WO.mo7598e(str, new C1465b(byVar, jG));
            }
            m4271a(jG, set);
            this.f3759WS--;
            return byVar;
        }
        m4271a(bVar.mo7744jG(), set);
        this.f3759WS--;
        return bVar.mo7745ka();
    }

    /* renamed from: a */
    private C1419by<C0661a> m4269a(Map<String, C1371aj> map, C1451a aVar, Set<String> set, C1436ck ckVar) {
        boolean z;
        boolean z2 = true;
        C0661a aVar2 = (C0661a) aVar.mo7690jF().get(C0546b.FUNCTION.toString());
        if (aVar2 == null) {
            C1401bh.m4075t("No function id in properties");
            return f3747WH;
        }
        String str = aVar2.f1792gd;
        C1371aj ajVar = (C1371aj) map.get(str);
        if (ajVar == null) {
            C1401bh.m4075t(str + " has no backing implementation.");
            return f3747WH;
        }
        C1419by<C0661a> byVar = (C1419by) this.f3754WN.get(aVar);
        if (byVar != null && !this.f3750WJ.mo7576jb()) {
            return byVar;
        }
        HashMap hashMap = new HashMap();
        boolean z3 = true;
        for (Entry entry : aVar.mo7690jF().entrySet()) {
            C1419by<C0661a> a = m4267a((C0661a) entry.getValue(), set, ckVar.mo7622bs((String) entry.getKey()).mo7624e((C0661a) entry.getValue()));
            if (a == f3747WH) {
                return f3747WH;
            }
            if (a.mo7642jr()) {
                aVar.mo7689a((String) entry.getKey(), (C0661a) a.getObject());
                z = z3;
            } else {
                z = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z3 = z;
        }
        if (!ajVar.mo7577a(hashMap.keySet())) {
            C1401bh.m4075t("Incorrect keys for function " + str + " required " + ajVar.mo7579jd() + " had " + hashMap.keySet());
            return f3747WH;
        }
        if (!z3 || !ajVar.mo7566iy()) {
            z2 = false;
        }
        C1419by<C0661a> byVar2 = new C1419by<>(ajVar.mo7567u(hashMap), z2);
        if (z2) {
            this.f3754WN.mo7598e(aVar, byVar2);
        }
        ckVar.mo7623d((C0661a) byVar2.getObject());
        return byVar2;
    }

    /* renamed from: a */
    private C1419by<Set<C1451a>> m4270a(Set<C1455e> set, Set<String> set2, C1464a aVar, C1458cs csVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        boolean z = true;
        for (C1455e eVar : set) {
            C1439cn jp = csVar.mo7634jp();
            C1419by a = mo7728a(eVar, set2, jp);
            if (((Boolean) a.getObject()).booleanValue()) {
                aVar.mo7742a(eVar, hashSet, hashSet2, jp);
            }
            z = z && a.mo7642jr();
        }
        hashSet.removeAll(hashSet2);
        csVar.mo7633b(hashSet);
        return new C1419by<>(hashSet, z);
    }

    /* renamed from: a */
    private void m4271a(C0661a aVar, Set<String> set) {
        if (aVar != null) {
            C1419by<C0661a> a = m4267a(aVar, set, (C1490dk) new C1417bw());
            if (a != f3747WH) {
                Object o = C1488di.m4385o((C0661a) a.getObject());
                if (o instanceof Map) {
                    this.f3748TN.push((Map) o);
                } else if (o instanceof List) {
                    for (Object next : (List) o) {
                        if (next instanceof Map) {
                            this.f3748TN.push((Map) next);
                        } else {
                            C1401bh.m4078w("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    C1401bh.m4078w("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    /* renamed from: a */
    private static void m4272a(List<C1451a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            C1401bh.m4076u("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    /* renamed from: a */
    private static void m4273a(Map<String, C1371aj> map, C1371aj ajVar) {
        if (map.containsKey(ajVar.mo7578jc())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.mo7578jc());
        }
        map.put(ajVar.mo7578jc(), ajVar);
    }

    /* renamed from: c */
    private static C1466c m4274c(Map<String, C1466c> map, String str) {
        C1466c cVar = (C1466c) map.get(str);
        if (cVar != null) {
            return cVar;
        }
        C1466c cVar2 = new C1466c();
        map.put(str, cVar2);
        return cVar2;
    }

    /* renamed from: h */
    private static String m4275h(C1451a aVar) {
        return C1488di.m4370j((C0661a) aVar.mo7690jF().get(C0546b.INSTANCE_NAME.toString()));
    }

    /* renamed from: jZ */
    private String m4276jZ() {
        if (this.f3759WS <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.f3759WS));
        for (int i = 2; i < this.f3759WS; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1419by<Boolean> mo7727a(C1451a aVar, Set<String> set, C1436ck ckVar) {
        C1419by a = m4269a(this.f3752WL, aVar, set, ckVar);
        Boolean n = C1488di.m4383n((C0661a) a.getObject());
        ckVar.mo7623d(C1488di.m4388r(n));
        return new C1419by<>(n, a.mo7642jr());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1419by<Boolean> mo7728a(C1455e eVar, Set<String> set, C1439cn cnVar) {
        boolean z;
        boolean z2 = true;
        for (C1451a a : eVar.mo7706jO()) {
            C1419by a2 = mo7727a(a, set, cnVar.mo7626jj());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cnVar.mo7625f(C1488di.m4388r(Boolean.valueOf(false)));
                return new C1419by<>(Boolean.valueOf(false), a2.mo7642jr());
            }
            z2 = z && a2.mo7642jr();
        }
        for (C1451a a3 : eVar.mo7705jN()) {
            C1419by a4 = mo7727a(a3, set, cnVar.mo7627jk());
            if (!((Boolean) a4.getObject()).booleanValue()) {
                cnVar.mo7625f(C1488di.m4388r(Boolean.valueOf(false)));
                return new C1419by<>(Boolean.valueOf(false), a4.mo7642jr());
            }
            z = z && a4.mo7642jr();
        }
        cnVar.mo7625f(C1488di.m4388r(Boolean.valueOf(true)));
        return new C1419by<>(Boolean.valueOf(true), z);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1419by<Set<C1451a>> mo7729a(String str, Set<C1455e> set, Map<C1455e, List<C1451a>> map, Map<C1455e, List<String>> map2, Map<C1455e, List<C1451a>> map3, Map<C1455e, List<String>> map4, Set<String> set2, C1458cs csVar) {
        final Map<C1455e, List<C1451a>> map5 = map;
        final Map<C1455e, List<String>> map6 = map2;
        final Map<C1455e, List<C1451a>> map7 = map3;
        final Map<C1455e, List<String>> map8 = map4;
        return m4270a(set, set2, (C1464a) new C1464a() {
            /* renamed from: a */
            public void mo7742a(C1455e eVar, Set<C1451a> set, Set<C1451a> set2, C1439cn cnVar) {
                List list = (List) map5.get(eVar);
                List list2 = (List) map6.get(eVar);
                if (list != null) {
                    set.addAll(list);
                    cnVar.mo7628jl().mo7632b(list, list2);
                }
                List list3 = (List) map7.get(eVar);
                List list4 = (List) map8.get(eVar);
                if (list3 != null) {
                    set2.addAll(list3);
                    cnVar.mo7629jm().mo7632b(list3, list4);
                }
            }
        }, csVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C1419by<Set<C1451a>> mo7730a(Set<C1455e> set, C1458cs csVar) {
        return m4270a(set, (Set<String>) new HashSet<String>(), (C1464a) new C1464a() {
            /* renamed from: a */
            public void mo7742a(C1455e eVar, Set<C1451a> set, Set<C1451a> set2, C1439cn cnVar) {
                set.addAll(eVar.mo7707jP());
                set2.addAll(eVar.mo7708jQ());
                cnVar.mo7630jn().mo7632b(eVar.mo7707jP(), eVar.mo7712jU());
                cnVar.mo7631jo().mo7632b(eVar.mo7708jQ(), eVar.mo7713jV());
            }
        }, csVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7731a(C1371aj ajVar) {
        m4273a(this.f3753WM, ajVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo7732b(C1371aj ajVar) {
        m4273a(this.f3751WK, ajVar);
    }

    /* renamed from: bC */
    public C1419by<C0661a> mo7733bC(String str) {
        this.f3759WS = 0;
        C1367af bl = this.f3750WJ.mo7574bl(str);
        C1419by<C0661a> a = m4268a(str, (Set<String>) new HashSet<String>(), bl.mo7571iY());
        bl.mo7573ja();
        return a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bD */
    public synchronized void mo7734bD(String str) {
        this.f3758WR = str;
    }

    /* renamed from: ba */
    public synchronized void mo7735ba(String str) {
        mo7734bD(str);
        C1367af bm = this.f3750WJ.mo7575bm(str);
        C1522t iZ = bm.mo7572iZ();
        for (C1451a a : (Set) mo7730a(this.f3756WP, iZ.mo7621iS()).getObject()) {
            m4269a(this.f3751WK, a, (Set<String>) new HashSet<String>(), iZ.mo7620iR());
        }
        bm.mo7573ja();
        mo7734bD(null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo7736c(C1371aj ajVar) {
        m4273a(this.f3752WL, ajVar);
    }

    /* renamed from: f */
    public synchronized void mo7737f(List<C0617i> list) {
        for (C0617i iVar : list) {
            if (iVar.name == null || !iVar.name.startsWith("gaExperiment:")) {
                C1401bh.m4077v("Ignored supplemental: " + iVar);
            } else {
                C1370ai.m4002a(this.f3748TN, iVar);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jY */
    public synchronized String mo7738jY() {
        return this.f3758WR;
    }
}
