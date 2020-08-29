package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0792fb.C0794b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.ey */
public final class C0773ey implements SafeParcelable, C0794b<String, Integer> {
    public static final C0775ez CREATOR = new C0775ez();

    /* renamed from: Cp */
    private final HashMap<String, Integer> f2067Cp;

    /* renamed from: Cq */
    private final HashMap<Integer, String> f2068Cq;

    /* renamed from: Cr */
    private final ArrayList<C0774a> f2069Cr;

    /* renamed from: wj */
    private final int f2070wj;

    /* renamed from: com.google.android.gms.internal.ey$a */
    public static final class C0774a implements SafeParcelable {
        public static final C0791fa CREATOR = new C0791fa();

        /* renamed from: Cs */
        final String f2071Cs;

        /* renamed from: Ct */
        final int f2072Ct;
        final int versionCode;

        C0774a(int i, String str, int i2) {
            this.versionCode = i;
            this.f2071Cs = str;
            this.f2072Ct = i2;
        }

        C0774a(String str, int i) {
            this.versionCode = 1;
            this.f2071Cs = str;
            this.f2072Ct = i;
        }

        public int describeContents() {
            C0791fa faVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            C0791fa faVar = CREATOR;
            C0791fa.m2021a(this, out, flags);
        }
    }

    public C0773ey() {
        this.f2070wj = 1;
        this.f2067Cp = new HashMap<>();
        this.f2068Cq = new HashMap<>();
        this.f2069Cr = null;
    }

    C0773ey(int i, ArrayList<C0774a> arrayList) {
        this.f2070wj = i;
        this.f2067Cp = new HashMap<>();
        this.f2068Cq = new HashMap<>();
        this.f2069Cr = null;
        m1997a(arrayList);
    }

    /* renamed from: a */
    private void m1997a(ArrayList<C0774a> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0774a aVar = (C0774a) it.next();
            mo5147f(aVar.f2071Cs, aVar.f2072Ct);
        }
    }

    /* renamed from: a */
    public String mo5148g(Integer num) {
        String str = (String) this.f2068Cq.get(num);
        return (str != null || !this.f2067Cp.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public int describeContents() {
        C0775ez ezVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ek */
    public ArrayList<C0774a> mo5144ek() {
        ArrayList<C0774a> arrayList = new ArrayList<>();
        for (String str : this.f2067Cp.keySet()) {
            arrayList.add(new C0774a(str, ((Integer) this.f2067Cp.get(str)).intValue()));
        }
        return arrayList;
    }

    /* renamed from: el */
    public int mo5145el() {
        return 7;
    }

    /* renamed from: em */
    public int mo5146em() {
        return 0;
    }

    /* renamed from: f */
    public C0773ey mo5147f(String str, int i) {
        this.f2067Cp.put(str, Integer.valueOf(i));
        this.f2068Cq.put(Integer.valueOf(i), str);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f2070wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0775ez ezVar = CREATOR;
        C0775ez.m2004a(this, out, flags);
    }
}
