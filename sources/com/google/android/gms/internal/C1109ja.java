package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1097g;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ja */
public class C1109ja implements Creator<C1097g> {
    /* renamed from: a */
    static void m3307a(C1097g gVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = gVar.mo6221hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, gVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m612a(parcel, 2, gVar.isPrimary());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m609a(parcel, 3, gVar.getValue(), true);
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aQ */
    public C1097g createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = C0324a.m571c(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1097g(hashSet, i, z, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bN */
    public C1097g[] newArray(int i) {
        return new C1097g[i];
    }
}
