package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1094d;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.iy */
public class C1105iy implements Creator<C1094d> {
    /* renamed from: a */
    static void m3289a(C1094d dVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = dVar.mo6182hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, dVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m609a(parcel, 2, dVar.getFamilyName(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m609a(parcel, 3, dVar.getFormatted(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0326b.m609a(parcel, 4, dVar.getGivenName(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0326b.m609a(parcel, 5, dVar.getHonorificPrefix(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0326b.m609a(parcel, 6, dVar.getHonorificSuffix(), true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0326b.m609a(parcel, 7, dVar.getMiddleName(), true);
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aO */
    public C1094d createFromParcel(Parcel parcel) {
        String str = null;
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1094d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bL */
    public C1094d[] newArray(int i) {
        return new C1094d[i];
    }
}
