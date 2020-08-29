package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1041hx.C1042a;

/* renamed from: com.google.android.gms.internal.hw */
public class C1040hw implements Creator<C1042a> {
    /* renamed from: a */
    static void m3055a(C1042a aVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, aVar.mo5812gt(), false);
        C0326b.m619c(parcel, 1000, aVar.f2844wj);
        C0326b.m609a(parcel, 2, aVar.getTag(), false);
        C0326b.m609a(parcel, 3, aVar.mo5809gH(), false);
        C0326b.m619c(parcel, 4, aVar.mo5810gI());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aA */
    public C1042a createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0324a.m584o(parcel);
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 2:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 1000:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1042a(i2, str3, str2, str, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bu */
    public C1042a[] newArray(int i) {
        return new C1042a[i];
    }
}
