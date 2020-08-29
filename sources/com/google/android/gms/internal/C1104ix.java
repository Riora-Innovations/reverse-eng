package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1093c;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ix */
public class C1104ix implements Creator<C1093c> {
    /* renamed from: a */
    static void m3286a(C1093c cVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = cVar.mo6168hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, cVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m609a(parcel, 2, cVar.getUrl(), true);
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aN */
    public C1093c createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1093c(hashSet, i, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bK */
    public C1093c[] newArray(int i) {
        return new C1093c[i];
    }
}
