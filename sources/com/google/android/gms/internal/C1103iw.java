package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1090b.C1092b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.iw */
public class C1103iw implements Creator<C1092b> {
    /* renamed from: a */
    static void m3283a(C1092b bVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = bVar.mo6157hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, bVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m619c(parcel, 2, bVar.getHeight());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m609a(parcel, 3, bVar.getUrl(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0326b.m619c(parcel, 4, bVar.getWidth());
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aM */
    public C1092b createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        String str = null;
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
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1092b(hashSet, i3, i2, str, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bJ */
    public C1092b[] newArray(int i) {
        return new C1092b[i];
    }
}
