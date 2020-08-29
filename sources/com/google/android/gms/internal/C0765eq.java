package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C0732ee.C0733a;
import java.util.List;

/* renamed from: com.google.android.gms.internal.eq */
public class C0765eq implements Creator<C0733a> {
    /* renamed from: a */
    static void m1967a(C0733a aVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, aVar.getAccountName(), false);
        C0326b.m619c(parcel, 1000, aVar.getVersionCode());
        C0326b.m610a(parcel, 2, aVar.mo5027dT(), false);
        C0326b.m619c(parcel, 3, aVar.mo5026dS());
        C0326b.m609a(parcel, 4, aVar.mo5028dV(), false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: R */
    public C0733a[] newArray(int i) {
        return new C0733a[i];
    }

    /* renamed from: m */
    public C0733a createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0324a.m584o(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 2:
                    list = C0324a.m595y(parcel, n);
                    break;
                case 3:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 4:
                    str = C0324a.m581m(parcel, n);
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
            return new C0733a(i2, str2, list, i, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
