package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1098h;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.jb */
public class C1110jb implements Creator<C1098h> {
    /* renamed from: a */
    static void m3310a(C1098h hVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = hVar.mo6234hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, hVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m619c(parcel, 3, hVar.mo6239io());
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0326b.m609a(parcel, 4, hVar.getValue(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0326b.m609a(parcel, 5, hVar.getLabel(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0326b.m619c(parcel, 6, hVar.getType());
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aR */
    public C1098h createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i3 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1098h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bO */
    public C1098h[] newArray(int i) {
        return new C1098h[i];
    }
}
