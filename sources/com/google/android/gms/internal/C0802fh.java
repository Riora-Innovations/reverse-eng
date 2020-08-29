package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0792fb.C0793a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.fh */
public class C0802fh extends C0792fb implements SafeParcelable {
    public static final C0803fi CREATOR = new C0803fi();

    /* renamed from: CC */
    private final C0797fe f2299CC;

    /* renamed from: CJ */
    private final Parcel f2300CJ;

    /* renamed from: CK */
    private final int f2301CK;

    /* renamed from: CL */
    private int f2302CL;

    /* renamed from: CM */
    private int f2303CM;
    private final String mClassName;

    /* renamed from: wj */
    private final int f2304wj;

    C0802fh(int i, Parcel parcel, C0797fe feVar) {
        this.f2304wj = i;
        this.f2300CJ = (Parcel) C0766er.m1977f(parcel);
        this.f2301CK = 2;
        this.f2299CC = feVar;
        if (this.f2299CC == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.f2299CC.mo5207eD();
        }
        this.f2302CL = 2;
    }

    private C0802fh(SafeParcelable safeParcelable, C0797fe feVar, String str) {
        this.f2304wj = 1;
        this.f2300CJ = Parcel.obtain();
        safeParcelable.writeToParcel(this.f2300CJ, 0);
        this.f2301CK = 1;
        this.f2299CC = (C0797fe) C0766er.m1977f(feVar);
        this.mClassName = (String) C0766er.m1977f(str);
        this.f2302CL = 2;
    }

    /* renamed from: a */
    public static <T extends C0792fb & SafeParcelable> C0802fh m2084a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new C0802fh((SafeParcelable) t, m2090b(t), canonicalName);
    }

    /* renamed from: a */
    private static void m2085a(C0797fe feVar, C0792fb fbVar) {
        Class cls = fbVar.getClass();
        if (!feVar.mo5202b(cls)) {
            HashMap en = fbVar.mo5170en();
            feVar.mo5200a(cls, fbVar.mo5170en());
            for (String str : en.keySet()) {
                C0793a aVar = (C0793a) en.get(str);
                Class ev = aVar.mo5183ev();
                if (ev != null) {
                    try {
                        m2085a(feVar, (C0792fb) ev.newInstance());
                    } catch (InstantiationException e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + aVar.mo5183ev().getCanonicalName(), e);
                    } catch (IllegalAccessException e2) {
                        throw new IllegalStateException("Could not access object of type " + aVar.mo5183ev().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m2086a(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(C0810fp.m2117ap(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(C0805fk.m2112d((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(C0805fk.m2113e((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                C0811fq.m2119a(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    /* renamed from: a */
    private void m2087a(StringBuilder sb, C0793a<?, ?> aVar, Parcel parcel, int i) {
        switch (aVar.mo5177em()) {
            case 0:
                m2092b(sb, aVar, mo5163a(aVar, Integer.valueOf(C0324a.m575g(parcel, i))));
                return;
            case 1:
                m2092b(sb, aVar, mo5163a(aVar, C0324a.m577i(parcel, i)));
                return;
            case 2:
                m2092b(sb, aVar, mo5163a(aVar, Long.valueOf(C0324a.m576h(parcel, i))));
                return;
            case 3:
                m2092b(sb, aVar, mo5163a(aVar, Float.valueOf(C0324a.m578j(parcel, i))));
                return;
            case 4:
                m2092b(sb, aVar, mo5163a(aVar, Double.valueOf(C0324a.m579k(parcel, i))));
                return;
            case 5:
                m2092b(sb, aVar, mo5163a(aVar, C0324a.m580l(parcel, i)));
                return;
            case 6:
                m2092b(sb, aVar, mo5163a(aVar, Boolean.valueOf(C0324a.m571c(parcel, i))));
                return;
            case 7:
                m2092b(sb, aVar, mo5163a(aVar, C0324a.m581m(parcel, i)));
                return;
            case 8:
            case 9:
                m2092b(sb, aVar, mo5163a(aVar, C0324a.m586p(parcel, i)));
                return;
            case 10:
                m2092b(sb, aVar, mo5163a(aVar, m2094c(C0324a.m585o(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + aVar.mo5177em());
        }
    }

    /* renamed from: a */
    private void m2088a(StringBuilder sb, String str, C0793a<?, ?> aVar, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (aVar.mo5185ex()) {
            m2087a(sb, aVar, parcel, i);
        } else {
            m2091b(sb, aVar, parcel, i);
        }
    }

    /* renamed from: a */
    private void m2089a(StringBuilder sb, HashMap<String, C0793a<?, ?>> hashMap, Parcel parcel) {
        HashMap c = m2095c(hashMap);
        sb.append('{');
        int o = C0324a.m584o(parcel);
        boolean z = false;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            Entry entry = (Entry) c.get(Integer.valueOf(C0324a.m562S(n)));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                m2088a(sb, (String) entry.getKey(), (C0793a) entry.getValue(), parcel, n);
                z = true;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C0325a("Overread allowed size end=" + o, parcel);
        }
        sb.append('}');
    }

    /* renamed from: b */
    private static C0797fe m2090b(C0792fb fbVar) {
        C0797fe feVar = new C0797fe(fbVar.getClass());
        m2085a(feVar, fbVar);
        feVar.mo5205eB();
        feVar.mo5204eA();
        return feVar;
    }

    /* renamed from: b */
    private void m2091b(StringBuilder sb, C0793a<?, ?> aVar, Parcel parcel, int i) {
        if (aVar.mo5180es()) {
            sb.append("[");
            switch (aVar.mo5177em()) {
                case 0:
                    C0804fj.m2106a(sb, C0324a.m588r(parcel, i));
                    break;
                case 1:
                    C0804fj.m2108a(sb, (T[]) C0324a.m590t(parcel, i));
                    break;
                case 2:
                    C0804fj.m2107a(sb, C0324a.m589s(parcel, i));
                    break;
                case 3:
                    C0804fj.m2105a(sb, C0324a.m591u(parcel, i));
                    break;
                case 4:
                    C0804fj.m2104a(sb, C0324a.m592v(parcel, i));
                    break;
                case 5:
                    C0804fj.m2108a(sb, (T[]) C0324a.m593w(parcel, i));
                    break;
                case 6:
                    C0804fj.m2110a(sb, C0324a.m587q(parcel, i));
                    break;
                case 7:
                    C0804fj.m2109a(sb, C0324a.m594x(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] A = C0324a.m561A(parcel, i);
                    int length = A.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        A[i2].setDataPosition(0);
                        m2089a(sb, aVar.mo5187ez(), A[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (aVar.mo5177em()) {
            case 0:
                sb.append(C0324a.m575g(parcel, i));
                return;
            case 1:
                sb.append(C0324a.m577i(parcel, i));
                return;
            case 2:
                sb.append(C0324a.m576h(parcel, i));
                return;
            case 3:
                sb.append(C0324a.m578j(parcel, i));
                return;
            case 4:
                sb.append(C0324a.m579k(parcel, i));
                return;
            case 5:
                sb.append(C0324a.m580l(parcel, i));
                return;
            case 6:
                sb.append(C0324a.m571c(parcel, i));
                return;
            case 7:
                sb.append("\"").append(C0810fp.m2117ap(C0324a.m581m(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(C0805fk.m2112d(C0324a.m586p(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(C0805fk.m2113e(C0324a.m586p(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle o = C0324a.m585o(parcel, i);
                Set<String> keySet = o.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(C0810fp.m2117ap(o.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel z2 = C0324a.m596z(parcel, i);
                z2.setDataPosition(0);
                m2089a(sb, aVar.mo5187ez(), z2);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    /* renamed from: b */
    private void m2092b(StringBuilder sb, C0793a<?, ?> aVar, Object obj) {
        if (aVar.mo5179er()) {
            m2093b(sb, aVar, (ArrayList) obj);
        } else {
            m2086a(sb, aVar.mo5176el(), obj);
        }
    }

    /* renamed from: b */
    private void m2093b(StringBuilder sb, C0793a<?, ?> aVar, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            m2086a(sb, aVar.mo5176el(), arrayList.get(i));
        }
        sb.append("]");
    }

    /* renamed from: c */
    public static HashMap<String, String> m2094c(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    /* renamed from: c */
    private static HashMap<Integer, Entry<String, C0793a<?, ?>>> m2095c(HashMap<String, C0793a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C0793a<?, ?>>> hashMap2 = new HashMap<>();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0793a) entry.getValue()).mo5182eu()), entry);
        }
        return hashMap2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ak */
    public Object mo5165ak(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: al */
    public boolean mo5166al(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        C0803fi fiVar = CREATOR;
        return 0;
    }

    /* renamed from: eF */
    public Parcel mo5225eF() {
        switch (this.f2302CL) {
            case 0:
                this.f2303CM = C0326b.m621p(this.f2300CJ);
                C0326b.m599D(this.f2300CJ, this.f2303CM);
                this.f2302CL = 2;
                break;
            case 1:
                C0326b.m599D(this.f2300CJ, this.f2303CM);
                this.f2302CL = 2;
                break;
        }
        return this.f2300CJ;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: eG */
    public C0797fe mo5226eG() {
        switch (this.f2301CK) {
            case 0:
                return null;
            case 1:
                return this.f2299CC;
            case 2:
                return this.f2299CC;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.f2301CK);
        }
    }

    /* renamed from: en */
    public HashMap<String, C0793a<?, ?>> mo5170en() {
        if (this.f2299CC == null) {
            return null;
        }
        return this.f2299CC.mo5201ao(this.mClassName);
    }

    public int getVersionCode() {
        return this.f2304wj;
    }

    public String toString() {
        C0766er.m1975b(this.f2299CC, (Object) "Cannot convert to JSON on client side.");
        Parcel eF = mo5225eF();
        eF.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        m2089a(sb, this.f2299CC.mo5201ao(this.mClassName), eF);
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0803fi fiVar = CREATOR;
        C0803fi.m2101a(this, out, flags);
    }
}
