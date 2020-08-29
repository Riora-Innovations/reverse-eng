package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0608c.C0610b;
import com.google.android.gms.internal.C0608c.C0613e;
import com.google.android.gms.internal.C0608c.C0614f;
import com.google.android.gms.internal.C0608c.C0615g;
import com.google.android.gms.internal.C0608c.C0616h;
import com.google.android.gms.internal.C0660d.C0661a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.cr */
class C1449cr {

    /* renamed from: com.google.android.gms.tagmanager.cr$a */
    public static class C1451a {

        /* renamed from: Ws */
        private final Map<String, C0661a> f3715Ws;

        /* renamed from: Wt */
        private final C0661a f3716Wt;

        private C1451a(Map<String, C0661a> map, C0661a aVar) {
            this.f3715Ws = map;
            this.f3716Wt = aVar;
        }

        /* renamed from: jE */
        public static C1452b m4228jE() {
            return new C1452b();
        }

        /* renamed from: a */
        public void mo7689a(String str, C0661a aVar) {
            this.f3715Ws.put(str, aVar);
        }

        /* renamed from: jF */
        public Map<String, C0661a> mo7690jF() {
            return Collections.unmodifiableMap(this.f3715Ws);
        }

        /* renamed from: jG */
        public C0661a mo7691jG() {
            return this.f3716Wt;
        }

        public String toString() {
            return "Properties: " + mo7690jF() + " pushAfterEvaluate: " + this.f3716Wt;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$b */
    public static class C1452b {

        /* renamed from: Ws */
        private final Map<String, C0661a> f3717Ws;

        /* renamed from: Wt */
        private C0661a f3718Wt;

        private C1452b() {
            this.f3717Ws = new HashMap();
        }

        /* renamed from: b */
        public C1452b mo7693b(String str, C0661a aVar) {
            this.f3717Ws.put(str, aVar);
            return this;
        }

        /* renamed from: i */
        public C1452b mo7694i(C0661a aVar) {
            this.f3718Wt = aVar;
            return this;
        }

        /* renamed from: jH */
        public C1451a mo7695jH() {
            return new C1451a(this.f3717Ws, this.f3718Wt);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$c */
    public static class C1453c {

        /* renamed from: Un */
        private final String f3719Un;

        /* renamed from: Wu */
        private final List<C1455e> f3720Wu;

        /* renamed from: Wv */
        private final Map<String, List<C1451a>> f3721Wv;

        /* renamed from: Ww */
        private final int f3722Ww;

        private C1453c(List<C1455e> list, Map<String, List<C1451a>> map, String str, int i) {
            this.f3720Wu = Collections.unmodifiableList(list);
            this.f3721Wv = Collections.unmodifiableMap(map);
            this.f3719Un = str;
            this.f3722Ww = i;
        }

        /* renamed from: jI */
        public static C1454d m4235jI() {
            return new C1454d();
        }

        public String getVersion() {
            return this.f3719Un;
        }

        /* renamed from: jJ */
        public List<C1455e> mo7697jJ() {
            return this.f3720Wu;
        }

        /* renamed from: jK */
        public Map<String, List<C1451a>> mo7698jK() {
            return this.f3721Wv;
        }

        public String toString() {
            return "Rules: " + mo7697jJ() + "  Macros: " + this.f3721Wv;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$d */
    public static class C1454d {

        /* renamed from: Un */
        private String f3723Un;

        /* renamed from: Wu */
        private final List<C1455e> f3724Wu;

        /* renamed from: Wv */
        private final Map<String, List<C1451a>> f3725Wv;

        /* renamed from: Ww */
        private int f3726Ww;

        private C1454d() {
            this.f3724Wu = new ArrayList();
            this.f3725Wv = new HashMap();
            this.f3723Un = "";
            this.f3726Ww = 0;
        }

        /* renamed from: a */
        public C1454d mo7700a(C1451a aVar) {
            String j = C1488di.m4370j((C0661a) aVar.mo7690jF().get(C0546b.INSTANCE_NAME.toString()));
            List list = (List) this.f3725Wv.get(j);
            if (list == null) {
                list = new ArrayList();
                this.f3725Wv.put(j, list);
            }
            list.add(aVar);
            return this;
        }

        /* renamed from: a */
        public C1454d mo7701a(C1455e eVar) {
            this.f3724Wu.add(eVar);
            return this;
        }

        /* renamed from: bW */
        public C1454d mo7702bW(int i) {
            this.f3726Ww = i;
            return this;
        }

        /* renamed from: bx */
        public C1454d mo7703bx(String str) {
            this.f3723Un = str;
            return this;
        }

        /* renamed from: jL */
        public C1453c mo7704jL() {
            return new C1453c(this.f3724Wu, this.f3725Wv, this.f3723Un, this.f3726Ww);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$e */
    public static class C1455e {

        /* renamed from: WA */
        private final List<C1451a> f3727WA;

        /* renamed from: WB */
        private final List<C1451a> f3728WB;

        /* renamed from: WC */
        private final List<C1451a> f3729WC;

        /* renamed from: WD */
        private final List<String> f3730WD;

        /* renamed from: WE */
        private final List<String> f3731WE;

        /* renamed from: WF */
        private final List<String> f3732WF;

        /* renamed from: WG */
        private final List<String> f3733WG;

        /* renamed from: Wx */
        private final List<C1451a> f3734Wx;

        /* renamed from: Wy */
        private final List<C1451a> f3735Wy;

        /* renamed from: Wz */
        private final List<C1451a> f3736Wz;

        private C1455e(List<C1451a> list, List<C1451a> list2, List<C1451a> list3, List<C1451a> list4, List<C1451a> list5, List<C1451a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.f3734Wx = Collections.unmodifiableList(list);
            this.f3735Wy = Collections.unmodifiableList(list2);
            this.f3736Wz = Collections.unmodifiableList(list3);
            this.f3727WA = Collections.unmodifiableList(list4);
            this.f3728WB = Collections.unmodifiableList(list5);
            this.f3729WC = Collections.unmodifiableList(list6);
            this.f3730WD = Collections.unmodifiableList(list7);
            this.f3731WE = Collections.unmodifiableList(list8);
            this.f3732WF = Collections.unmodifiableList(list9);
            this.f3733WG = Collections.unmodifiableList(list10);
        }

        /* renamed from: jM */
        public static C1456f m4243jM() {
            return new C1456f();
        }

        /* renamed from: jN */
        public List<C1451a> mo7705jN() {
            return this.f3734Wx;
        }

        /* renamed from: jO */
        public List<C1451a> mo7706jO() {
            return this.f3735Wy;
        }

        /* renamed from: jP */
        public List<C1451a> mo7707jP() {
            return this.f3736Wz;
        }

        /* renamed from: jQ */
        public List<C1451a> mo7708jQ() {
            return this.f3727WA;
        }

        /* renamed from: jR */
        public List<C1451a> mo7709jR() {
            return this.f3728WB;
        }

        /* renamed from: jS */
        public List<String> mo7710jS() {
            return this.f3730WD;
        }

        /* renamed from: jT */
        public List<String> mo7711jT() {
            return this.f3731WE;
        }

        /* renamed from: jU */
        public List<String> mo7712jU() {
            return this.f3732WF;
        }

        /* renamed from: jV */
        public List<String> mo7713jV() {
            return this.f3733WG;
        }

        /* renamed from: jW */
        public List<C1451a> mo7714jW() {
            return this.f3729WC;
        }

        public String toString() {
            return "Positive predicates: " + mo7705jN() + "  Negative predicates: " + mo7706jO() + "  Add tags: " + mo7707jP() + "  Remove tags: " + mo7708jQ() + "  Add macros: " + mo7709jR() + "  Remove macros: " + mo7714jW();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$f */
    public static class C1456f {

        /* renamed from: WA */
        private final List<C1451a> f3737WA;

        /* renamed from: WB */
        private final List<C1451a> f3738WB;

        /* renamed from: WC */
        private final List<C1451a> f3739WC;

        /* renamed from: WD */
        private final List<String> f3740WD;

        /* renamed from: WE */
        private final List<String> f3741WE;

        /* renamed from: WF */
        private final List<String> f3742WF;

        /* renamed from: WG */
        private final List<String> f3743WG;

        /* renamed from: Wx */
        private final List<C1451a> f3744Wx;

        /* renamed from: Wy */
        private final List<C1451a> f3745Wy;

        /* renamed from: Wz */
        private final List<C1451a> f3746Wz;

        private C1456f() {
            this.f3744Wx = new ArrayList();
            this.f3745Wy = new ArrayList();
            this.f3746Wz = new ArrayList();
            this.f3737WA = new ArrayList();
            this.f3738WB = new ArrayList();
            this.f3739WC = new ArrayList();
            this.f3740WD = new ArrayList();
            this.f3741WE = new ArrayList();
            this.f3742WF = new ArrayList();
            this.f3743WG = new ArrayList();
        }

        /* renamed from: b */
        public C1456f mo7716b(C1451a aVar) {
            this.f3744Wx.add(aVar);
            return this;
        }

        /* renamed from: bA */
        public C1456f mo7717bA(String str) {
            this.f3740WD.add(str);
            return this;
        }

        /* renamed from: bB */
        public C1456f mo7718bB(String str) {
            this.f3741WE.add(str);
            return this;
        }

        /* renamed from: by */
        public C1456f mo7719by(String str) {
            this.f3742WF.add(str);
            return this;
        }

        /* renamed from: bz */
        public C1456f mo7720bz(String str) {
            this.f3743WG.add(str);
            return this;
        }

        /* renamed from: c */
        public C1456f mo7721c(C1451a aVar) {
            this.f3745Wy.add(aVar);
            return this;
        }

        /* renamed from: d */
        public C1456f mo7722d(C1451a aVar) {
            this.f3746Wz.add(aVar);
            return this;
        }

        /* renamed from: e */
        public C1456f mo7723e(C1451a aVar) {
            this.f3737WA.add(aVar);
            return this;
        }

        /* renamed from: f */
        public C1456f mo7724f(C1451a aVar) {
            this.f3738WB.add(aVar);
            return this;
        }

        /* renamed from: g */
        public C1456f mo7725g(C1451a aVar) {
            this.f3739WC.add(aVar);
            return this;
        }

        /* renamed from: jX */
        public C1455e mo7726jX() {
            return new C1455e(this.f3744Wx, this.f3745Wy, this.f3746Wz, this.f3737WA, this.f3738WB, this.f3739WC, this.f3740WD, this.f3741WE, this.f3742WF, this.f3743WG);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cr$g */
    public static class C1457g extends Exception {
        public C1457g(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static C0661a m4219a(int i, C0614f fVar, C0661a[] aVarArr, Set<Integer> set) throws C1457g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            m4225bw("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C0661a aVar = (C0661a) m4222a(fVar.f1599fi, i, "values");
        if (aVarArr[i] != null) {
            return aVarArr[i];
        }
        C0661a aVar2 = null;
        set.add(Integer.valueOf(i));
        switch (aVar.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                aVar2 = aVar;
                break;
            case 2:
                C0616h h = m4227h(aVar);
                aVar2 = m4226g(aVar);
                aVar2.f1788fZ = new C0661a[h.f1627fK.length];
                int[] iArr = h.f1627fK;
                int length = iArr.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = i3 + 1;
                    aVar2.f1788fZ[i3] = m4219a(iArr[i2], fVar, aVarArr, set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                aVar2 = m4226g(aVar);
                C0616h h2 = m4227h(aVar);
                if (h2.f1628fL.length != h2.f1629fM.length) {
                    m4225bw("Uneven map keys (" + h2.f1628fL.length + ") and map values (" + h2.f1629fM.length + ")");
                }
                aVar2.f1789ga = new C0661a[h2.f1628fL.length];
                aVar2.f1790gb = new C0661a[h2.f1628fL.length];
                int[] iArr2 = h2.f1628fL;
                int length2 = iArr2.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length2) {
                    int i7 = i6 + 1;
                    aVar2.f1789ga[i6] = m4219a(iArr2[i5], fVar, aVarArr, set);
                    i5++;
                    i6 = i7;
                }
                int[] iArr3 = h2.f1629fM;
                int length3 = iArr3.length;
                int i8 = 0;
                while (i2 < length3) {
                    int i9 = i8 + 1;
                    aVar2.f1790gb[i8] = m4219a(iArr3[i2], fVar, aVarArr, set);
                    i2++;
                    i8 = i9;
                }
                break;
            case 4:
                aVar2 = m4226g(aVar);
                aVar2.f1791gc = C1488di.m4370j(m4219a(m4227h(aVar).f1632fP, fVar, aVarArr, set));
                break;
            case 7:
                aVar2 = m4226g(aVar);
                C0616h h3 = m4227h(aVar);
                aVar2.f1795gg = new C0661a[h3.f1631fO.length];
                int[] iArr4 = h3.f1631fO;
                int length4 = iArr4.length;
                int i10 = 0;
                while (i2 < length4) {
                    int i11 = i10 + 1;
                    aVar2.f1795gg[i10] = m4219a(iArr4[i2], fVar, aVarArr, set);
                    i2++;
                    i10 = i11;
                }
                break;
        }
        if (aVar2 == null) {
            m4225bw("Invalid value: " + aVar);
        }
        aVarArr[i] = aVar2;
        set.remove(Integer.valueOf(i));
        return aVar2;
    }

    /* renamed from: a */
    private static C1451a m4220a(C0610b bVar, C0614f fVar, C0661a[] aVarArr, int i) throws C1457g {
        C1452b jE = C1451a.m4228jE();
        for (int valueOf : bVar.f1583eS) {
            C0613e eVar = (C0613e) m4222a(fVar.f1600fj, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m4222a(fVar.f1598fh, eVar.key, "keys");
            C0661a aVar = (C0661a) m4222a(aVarArr, eVar.value, "values");
            if (C0546b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                jE.mo7694i(aVar);
            } else {
                jE.mo7693b(str, aVar);
            }
        }
        return jE.mo7695jH();
    }

    /* renamed from: a */
    private static C1455e m4221a(C0615g gVar, List<C1451a> list, List<C1451a> list2, List<C1451a> list3, C0614f fVar) {
        C1456f jM = C1455e.m4243jM();
        for (int valueOf : gVar.f1623fy) {
            jM.mo7716b((C1451a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : gVar.f1624fz) {
            jM.mo7721c((C1451a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf3 : gVar.f1615fA) {
            jM.mo7722d((C1451a) list.get(Integer.valueOf(valueOf3).intValue()));
        }
        for (int valueOf4 : gVar.f1617fC) {
            jM.mo7719by(fVar.f1599fi[Integer.valueOf(valueOf4).intValue()].f1787fY);
        }
        for (int valueOf5 : gVar.f1616fB) {
            jM.mo7723e((C1451a) list.get(Integer.valueOf(valueOf5).intValue()));
        }
        for (int valueOf6 : gVar.f1618fD) {
            jM.mo7720bz(fVar.f1599fi[Integer.valueOf(valueOf6).intValue()].f1787fY);
        }
        for (int valueOf7 : gVar.f1619fE) {
            jM.mo7724f((C1451a) list2.get(Integer.valueOf(valueOf7).intValue()));
        }
        for (int valueOf8 : gVar.f1621fG) {
            jM.mo7717bA(fVar.f1599fi[Integer.valueOf(valueOf8).intValue()].f1787fY);
        }
        for (int valueOf9 : gVar.f1620fF) {
            jM.mo7725g((C1451a) list2.get(Integer.valueOf(valueOf9).intValue()));
        }
        for (int valueOf10 : gVar.f1622fH) {
            jM.mo7718bB(fVar.f1599fi[Integer.valueOf(valueOf10).intValue()].f1787fY);
        }
        return jM.mo7726jX();
    }

    /* renamed from: a */
    private static <T> T m4222a(T[] tArr, int i, String str) throws C1457g {
        if (i < 0 || i >= tArr.length) {
            m4225bw("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    /* renamed from: b */
    public static C1453c m4223b(C0614f fVar) throws C1457g {
        C0661a[] aVarArr = new C0661a[fVar.f1599fi.length];
        for (int i = 0; i < fVar.f1599fi.length; i++) {
            m4219a(i, fVar, aVarArr, (Set<Integer>) new HashSet<Integer>(0));
        }
        C1454d jI = C1453c.m4235jI();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < fVar.f1602fl.length; i2++) {
            arrayList.add(m4220a(fVar.f1602fl[i2], fVar, aVarArr, i2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < fVar.f1603fm.length; i3++) {
            arrayList2.add(m4220a(fVar.f1603fm[i3], fVar, aVarArr, i3));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < fVar.f1601fk.length; i4++) {
            C1451a a = m4220a(fVar.f1601fk[i4], fVar, aVarArr, i4);
            jI.mo7700a(a);
            arrayList3.add(a);
        }
        for (C0615g a2 : fVar.f1604fn) {
            jI.mo7701a(m4221a(a2, arrayList, arrayList3, arrayList2, fVar));
        }
        jI.mo7703bx(fVar.f1608fr);
        jI.mo7702bW(fVar.f1613fw);
        return jI.mo7704jL();
    }

    /* renamed from: b */
    public static void m4224b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    /* renamed from: bw */
    private static void m4225bw(String str) throws C1457g {
        C1401bh.m4075t(str);
        throw new C1457g(str);
    }

    /* renamed from: g */
    public static C0661a m4226g(C0661a aVar) {
        C0661a aVar2 = new C0661a();
        aVar2.type = aVar.type;
        aVar2.f1796gh = (int[]) aVar.f1796gh.clone();
        if (aVar.f1797gi) {
            aVar2.f1797gi = aVar.f1797gi;
        }
        return aVar2;
    }

    /* renamed from: h */
    private static C0616h m4227h(C0661a aVar) throws C1457g {
        if (((C0616h) aVar.mo6421a(C0616h.f1625fI)) == null) {
            m4225bw("Expected a ServingValue and didn't get one. Value is: " + aVar);
        }
        return (C0616h) aVar.mo6421a(C0616h.f1625fI);
    }
}
