package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1089a;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.it */
public class C1100it implements Creator<C1089a> {
    /* renamed from: a */
    static void m3274a(C1089a aVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = aVar.mo6119hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, aVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m619c(parcel, 2, aVar.getMax());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m619c(parcel, 3, aVar.getMin());
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aJ */
    public C1089a createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i3 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1089a(hashSet, i3, i2, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bG */
    public C1089a[] newArray(int i) {
        return new C1089a[i];
    }
}
