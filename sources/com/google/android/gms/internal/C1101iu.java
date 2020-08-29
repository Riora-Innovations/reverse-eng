package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1090b;
import com.google.android.gms.internal.C1088ir.C1090b.C1091a;
import com.google.android.gms.internal.C1088ir.C1090b.C1092b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.iu */
public class C1101iu implements Creator<C1090b> {
    /* renamed from: a */
    static void m3277a(C1090b bVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = bVar.mo6131hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, bVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m607a(parcel, 2, (Parcelable) bVar.mo6136if(), i, true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m607a(parcel, 3, (Parcelable) bVar.mo6137ig(), i, true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0326b.m619c(parcel, 4, bVar.getLayout());
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aK */
    public C1090b createFromParcel(Parcel parcel) {
        C1092b bVar = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        C1091a aVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    C1091a aVar2 = (C1091a) C0324a.m564a(parcel, n, (Creator<T>) C1091a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    aVar = aVar2;
                    break;
                case 3:
                    C1092b bVar2 = (C1092b) C0324a.m564a(parcel, n, (Creator<T>) C1092b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    bVar = bVar2;
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
            return new C1090b(hashSet, i2, aVar, bVar, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bH */
    public C1090b[] newArray(int i) {
        return new C1090b[i];
    }
}
