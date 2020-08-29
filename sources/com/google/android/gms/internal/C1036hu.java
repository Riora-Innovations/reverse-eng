package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.hu */
public class C1036hu implements Creator<C1035ht> {
    /* renamed from: a */
    static void m3049a(C1035ht htVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, htVar.f2820Oc, false);
        C0326b.m619c(parcel, 1000, htVar.f2821wj);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: az */
    public C1035ht createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 1000:
                    i = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1035ht(i, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bt */
    public C1035ht[] newArray(int i) {
        return new C1035ht[i];
    }
}
