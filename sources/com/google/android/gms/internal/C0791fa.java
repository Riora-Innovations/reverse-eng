package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C0773ey.C0774a;

/* renamed from: com.google.android.gms.internal.fa */
public class C0791fa implements Creator<C0774a> {
    /* renamed from: a */
    static void m2021a(C0774a aVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, aVar.versionCode);
        C0326b.m609a(parcel, 2, aVar.f2071Cs, false);
        C0326b.m619c(parcel, 3, aVar.f2072Ct);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: V */
    public C0774a[] newArray(int i) {
        return new C0774a[i];
    }

    /* renamed from: s */
    public C0774a createFromParcel(Parcel parcel) {
        int i = 0;
        int o = C0324a.m584o(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    i = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0774a(i2, str, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
