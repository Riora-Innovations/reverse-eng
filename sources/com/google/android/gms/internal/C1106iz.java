package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1096f;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.iz */
public class C1106iz implements Creator<C1096f> {
    /* renamed from: a */
    static void m3292a(C1096f fVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = fVar.mo6203hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, fVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m609a(parcel, 2, fVar.getDepartment(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m609a(parcel, 3, fVar.getDescription(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0326b.m609a(parcel, 4, fVar.getEndDate(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0326b.m609a(parcel, 5, fVar.getLocation(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0326b.m609a(parcel, 6, fVar.getName(), true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0326b.m612a(parcel, 7, fVar.isPrimary());
        }
        if (hB.contains(Integer.valueOf(8))) {
            C0326b.m609a(parcel, 8, fVar.getStartDate(), true);
        }
        if (hB.contains(Integer.valueOf(9))) {
            C0326b.m609a(parcel, 9, fVar.getTitle(), true);
        }
        if (hB.contains(Integer.valueOf(10))) {
            C0326b.m619c(parcel, 10, fVar.getType());
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aP */
    public C1096f createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = C0324a.m571c(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1096f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bM */
    public C1096f[] newArray(int i) {
        return new C1096f[i];
    }
}
