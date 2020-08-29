package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.fb */
public abstract class C0792fb {

    /* renamed from: com.google.android.gms.internal.fb$a */
    public static class C0793a<I, O> implements SafeParcelable {
        public static final C0795fc CREATOR = new C0795fc();

        /* renamed from: CA */
        protected final Class<? extends C0792fb> f2281CA;

        /* renamed from: CB */
        protected final String f2282CB;

        /* renamed from: CC */
        private C0797fe f2283CC;
        /* access modifiers changed from: private */

        /* renamed from: CD */
        public C0794b<I, O> f2284CD;

        /* renamed from: Cu */
        protected final int f2285Cu;

        /* renamed from: Cv */
        protected final boolean f2286Cv;

        /* renamed from: Cw */
        protected final int f2287Cw;

        /* renamed from: Cx */
        protected final boolean f2288Cx;

        /* renamed from: Cy */
        protected final String f2289Cy;

        /* renamed from: Cz */
        protected final int f2290Cz;

        /* renamed from: wj */
        private final int f2291wj;

        C0793a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, C0771ew ewVar) {
            this.f2291wj = i;
            this.f2285Cu = i2;
            this.f2286Cv = z;
            this.f2287Cw = i3;
            this.f2288Cx = z2;
            this.f2289Cy = str;
            this.f2290Cz = i4;
            if (str2 == null) {
                this.f2281CA = null;
                this.f2282CB = null;
            } else {
                this.f2281CA = C0802fh.class;
                this.f2282CB = str2;
            }
            if (ewVar == null) {
                this.f2284CD = null;
            } else {
                this.f2284CD = ewVar.mo5135ej();
            }
        }

        protected C0793a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends C0792fb> cls, C0794b<I, O> bVar) {
            this.f2291wj = 1;
            this.f2285Cu = i;
            this.f2286Cv = z;
            this.f2287Cw = i2;
            this.f2288Cx = z2;
            this.f2289Cy = str;
            this.f2290Cz = i3;
            this.f2281CA = cls;
            if (cls == null) {
                this.f2282CB = null;
            } else {
                this.f2282CB = cls.getCanonicalName();
            }
            this.f2284CD = bVar;
        }

        /* renamed from: a */
        public static C0793a m2036a(String str, int i, C0794b<?, ?> bVar, boolean z) {
            return new C0793a(bVar.mo5145el(), z, bVar.mo5146em(), false, str, i, null, bVar);
        }

        /* renamed from: a */
        public static <T extends C0792fb> C0793a<T, T> m2037a(String str, int i, Class<T> cls) {
            return new C0793a<>(11, false, 11, false, str, i, cls, null);
        }

        /* renamed from: b */
        public static <T extends C0792fb> C0793a<ArrayList<T>, ArrayList<T>> m2038b(String str, int i, Class<T> cls) {
            return new C0793a<>(11, true, 11, true, str, i, cls, null);
        }

        /* renamed from: g */
        public static C0793a<Integer, Integer> m2040g(String str, int i) {
            return new C0793a<>(0, false, 0, false, str, i, null, null);
        }

        /* renamed from: h */
        public static C0793a<Double, Double> m2041h(String str, int i) {
            return new C0793a<>(4, false, 4, false, str, i, null, null);
        }

        /* renamed from: i */
        public static C0793a<Boolean, Boolean> m2042i(String str, int i) {
            return new C0793a<>(6, false, 6, false, str, i, null, null);
        }

        /* renamed from: j */
        public static C0793a<String, String> m2043j(String str, int i) {
            return new C0793a<>(7, false, 7, false, str, i, null, null);
        }

        /* renamed from: k */
        public static C0793a<ArrayList<String>, ArrayList<String>> m2044k(String str, int i) {
            return new C0793a<>(7, true, 7, true, str, i, null, null);
        }

        /* renamed from: a */
        public void mo5174a(C0797fe feVar) {
            this.f2283CC = feVar;
        }

        public int describeContents() {
            C0795fc fcVar = CREATOR;
            return 0;
        }

        /* renamed from: el */
        public int mo5176el() {
            return this.f2285Cu;
        }

        /* renamed from: em */
        public int mo5177em() {
            return this.f2287Cw;
        }

        /* renamed from: eq */
        public C0793a<I, O> mo5178eq() {
            return new C0793a<>(this.f2291wj, this.f2285Cu, this.f2286Cv, this.f2287Cw, this.f2288Cx, this.f2289Cy, this.f2290Cz, this.f2282CB, mo5186ey());
        }

        /* renamed from: er */
        public boolean mo5179er() {
            return this.f2286Cv;
        }

        /* renamed from: es */
        public boolean mo5180es() {
            return this.f2288Cx;
        }

        /* renamed from: et */
        public String mo5181et() {
            return this.f2289Cy;
        }

        /* renamed from: eu */
        public int mo5182eu() {
            return this.f2290Cz;
        }

        /* renamed from: ev */
        public Class<? extends C0792fb> mo5183ev() {
            return this.f2281CA;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ew */
        public String mo5184ew() {
            if (this.f2282CB == null) {
                return null;
            }
            return this.f2282CB;
        }

        /* renamed from: ex */
        public boolean mo5185ex() {
            return this.f2284CD != null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: ey */
        public C0771ew mo5186ey() {
            if (this.f2284CD == null) {
                return null;
            }
            return C0771ew.m1991a(this.f2284CD);
        }

        /* renamed from: ez */
        public HashMap<String, C0793a<?, ?>> mo5187ez() {
            C0766er.m1977f(this.f2282CB);
            C0766er.m1977f(this.f2283CC);
            return this.f2283CC.mo5201ao(this.f2282CB);
        }

        /* renamed from: g */
        public I mo5188g(O o) {
            return this.f2284CD.mo5148g(o);
        }

        public int getVersionCode() {
            return this.f2291wj;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.f2291wj).append(10);
            sb.append("                 typeIn=").append(this.f2285Cu).append(10);
            sb.append("            typeInArray=").append(this.f2286Cv).append(10);
            sb.append("                typeOut=").append(this.f2287Cw).append(10);
            sb.append("           typeOutArray=").append(this.f2288Cx).append(10);
            sb.append("        outputFieldName=").append(this.f2289Cy).append(10);
            sb.append("      safeParcelFieldId=").append(this.f2290Cz).append(10);
            sb.append("       concreteTypeName=").append(mo5184ew()).append(10);
            if (mo5183ev() != null) {
                sb.append("     concreteType.class=").append(mo5183ev().getCanonicalName()).append(10);
            }
            sb.append("          converterName=").append(this.f2284CD == null ? "null" : this.f2284CD.getClass().getCanonicalName()).append(10);
            return sb.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            C0795fc fcVar = CREATOR;
            C0795fc.m2062a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fb$b */
    public interface C0794b<I, O> {
        /* renamed from: el */
        int mo5145el();

        /* renamed from: em */
        int mo5146em();

        /* renamed from: g */
        I mo5148g(O o);
    }

    /* renamed from: a */
    private void m2024a(StringBuilder sb, C0793a aVar, Object obj) {
        if (aVar.mo5176el() == 11) {
            sb.append(((C0792fb) aVar.mo5183ev().cast(obj)).toString());
        } else if (aVar.mo5176el() == 7) {
            sb.append("\"");
            sb.append(C0810fp.m2117ap((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }

    /* renamed from: a */
    private void m2025a(StringBuilder sb, C0793a aVar, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m2024a(sb, aVar, obj);
            }
        }
        sb.append("]");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <O, I> I mo5163a(C0793a<I, O> aVar, Object obj) {
        return aVar.f2284CD != null ? aVar.mo5188g(obj) : obj;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5164a(C0793a aVar) {
        return aVar.mo5177em() == 11 ? aVar.mo5180es() ? mo5168an(aVar.mo5181et()) : mo5167am(aVar.mo5181et()) : mo5166al(aVar.mo5181et());
    }

    /* access modifiers changed from: protected */
    /* renamed from: ak */
    public abstract Object mo5165ak(String str);

    /* access modifiers changed from: protected */
    /* renamed from: al */
    public abstract boolean mo5166al(String str);

    /* access modifiers changed from: protected */
    /* renamed from: am */
    public boolean mo5167am(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    /* renamed from: an */
    public boolean mo5168an(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo5169b(C0793a aVar) {
        boolean z = true;
        String et = aVar.mo5181et();
        if (aVar.mo5183ev() == null) {
            return mo5165ak(aVar.mo5181et());
        }
        if (mo5165ak(aVar.mo5181et()) != null) {
            z = false;
        }
        C0766er.m1970a(z, "Concrete field shouldn't be value object: " + aVar.mo5181et());
        HashMap eo = aVar.mo5180es() ? mo5172ep() : mo5171eo();
        if (eo != null) {
            return eo.get(et);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(et.charAt(0)) + et.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: en */
    public abstract HashMap<String, C0793a<?, ?>> mo5170en();

    /* renamed from: eo */
    public HashMap<String, Object> mo5171eo() {
        return null;
    }

    /* renamed from: ep */
    public HashMap<String, Object> mo5172ep() {
        return null;
    }

    public String toString() {
        HashMap en = mo5170en();
        StringBuilder sb = new StringBuilder(100);
        for (String str : en.keySet()) {
            C0793a aVar = (C0793a) en.get(str);
            if (mo5164a(aVar)) {
                Object a = mo5163a(aVar, mo5169b(aVar));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (aVar.mo5177em()) {
                        case 8:
                            sb.append("\"").append(C0805fk.m2112d((byte[]) a)).append("\"");
                            break;
                        case 9:
                            sb.append("\"").append(C0805fk.m2113e((byte[]) a)).append("\"");
                            break;
                        case 10:
                            C0811fq.m2119a(sb, (HashMap) a);
                            break;
                        default:
                            if (!aVar.mo5179er()) {
                                m2024a(sb, aVar, a);
                                break;
                            } else {
                                m2025a(sb, aVar, (ArrayList) a);
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}
