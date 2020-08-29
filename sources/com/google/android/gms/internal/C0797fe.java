package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0792fb.C0793a;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.fe */
public class C0797fe implements SafeParcelable {
    public static final C0800ff CREATOR = new C0800ff();

    /* renamed from: CE */
    private final HashMap<String, HashMap<String, C0793a<?, ?>>> f2292CE;

    /* renamed from: CF */
    private final ArrayList<C0798a> f2293CF;

    /* renamed from: CG */
    private final String f2294CG;

    /* renamed from: wj */
    private final int f2295wj;

    /* renamed from: com.google.android.gms.internal.fe$a */
    public static class C0798a implements SafeParcelable {
        public static final C0801fg CREATOR = new C0801fg();

        /* renamed from: CH */
        final ArrayList<C0799b> f2296CH;
        final String className;
        final int versionCode;

        C0798a(int i, String str, ArrayList<C0799b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.f2296CH = arrayList;
        }

        C0798a(String str, HashMap<String, C0793a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.f2296CH = m2076b(hashMap);
        }

        /* renamed from: b */
        private static ArrayList<C0799b> m2076b(HashMap<String, C0793a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C0799b(str, (C0793a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            C0801fg fgVar = CREATOR;
            return 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: eE */
        public HashMap<String, C0793a<?, ?>> mo5212eE() {
            HashMap<String, C0793a<?, ?>> hashMap = new HashMap<>();
            int size = this.f2296CH.size();
            for (int i = 0; i < size; i++) {
                C0799b bVar = (C0799b) this.f2296CH.get(i);
                hashMap.put(bVar.f2298eX, bVar.f2297CI);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0801fg fgVar = CREATOR;
            C0801fg.m2081a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.fe$b */
    public static class C0799b implements SafeParcelable {
        public static final C0796fd CREATOR = new C0796fd();

        /* renamed from: CI */
        final C0793a<?, ?> f2297CI;

        /* renamed from: eX */
        final String f2298eX;
        final int versionCode;

        C0799b(int i, String str, C0793a<?, ?> aVar) {
            this.versionCode = i;
            this.f2298eX = str;
            this.f2297CI = aVar;
        }

        C0799b(String str, C0793a<?, ?> aVar) {
            this.versionCode = 1;
            this.f2298eX = str;
            this.f2297CI = aVar;
        }

        public int describeContents() {
            C0796fd fdVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0796fd fdVar = CREATOR;
            C0796fd.m2065a(this, out, flags);
        }
    }

    C0797fe(int i, ArrayList<C0798a> arrayList, String str) {
        this.f2295wj = i;
        this.f2293CF = null;
        this.f2292CE = m2068b(arrayList);
        this.f2294CG = (String) C0766er.m1977f(str);
        mo5204eA();
    }

    public C0797fe(Class<? extends C0792fb> cls) {
        this.f2295wj = 1;
        this.f2293CF = null;
        this.f2292CE = new HashMap<>();
        this.f2294CG = cls.getCanonicalName();
    }

    /* renamed from: b */
    private static HashMap<String, HashMap<String, C0793a<?, ?>>> m2068b(ArrayList<C0798a> arrayList) {
        HashMap<String, HashMap<String, C0793a<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0798a aVar = (C0798a) arrayList.get(i);
            hashMap.put(aVar.className, aVar.mo5212eE());
        }
        return hashMap;
    }

    /* renamed from: a */
    public void mo5200a(Class<? extends C0792fb> cls, HashMap<String, C0793a<?, ?>> hashMap) {
        this.f2292CE.put(cls.getCanonicalName(), hashMap);
    }

    /* renamed from: ao */
    public HashMap<String, C0793a<?, ?>> mo5201ao(String str) {
        return (HashMap) this.f2292CE.get(str);
    }

    /* renamed from: b */
    public boolean mo5202b(Class<? extends C0792fb> cls) {
        return this.f2292CE.containsKey(cls.getCanonicalName());
    }

    public int describeContents() {
        C0800ff ffVar = CREATOR;
        return 0;
    }

    /* renamed from: eA */
    public void mo5204eA() {
        for (String str : this.f2292CE.keySet()) {
            HashMap hashMap = (HashMap) this.f2292CE.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C0793a) hashMap.get(str2)).mo5174a(this);
            }
        }
    }

    /* renamed from: eB */
    public void mo5205eB() {
        for (String str : this.f2292CE.keySet()) {
            HashMap hashMap = (HashMap) this.f2292CE.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C0793a) hashMap.get(str2)).mo5178eq());
            }
            this.f2292CE.put(str, hashMap2);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: eC */
    public ArrayList<C0798a> mo5206eC() {
        ArrayList<C0798a> arrayList = new ArrayList<>();
        for (String str : this.f2292CE.keySet()) {
            arrayList.add(new C0798a(str, (HashMap) this.f2292CE.get(str)));
        }
        return arrayList;
    }

    /* renamed from: eD */
    public String mo5207eD() {
        return this.f2294CG;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f2295wj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f2292CE.keySet()) {
            sb.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.f2292CE.get(str);
            for (String str2 : hashMap.keySet()) {
                sb.append("  ").append(str2).append(": ");
                sb.append(hashMap.get(str2));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0800ff ffVar = CREATOR;
        C0800ff.m2078a(this, out, flags);
    }
}
