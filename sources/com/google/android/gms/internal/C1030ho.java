package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ho */
public class C1030ho implements Creator<C1029hn> {
    /* renamed from: a */
    static void m3036a(C1029hn hnVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m618b(parcel, 1, hnVar.f2685LA, false);
        C0326b.m619c(parcel, 1000, hnVar.f2689wj);
        C0326b.m609a(parcel, 2, hnVar.mo5741gr(), false);
        C0326b.m612a(parcel, 3, hnVar.mo5742gs());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aw */
    public C1029hn createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int o = C0324a.m584o(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    list = C0324a.m570c(parcel, n, C1035ht.CREATOR);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    z = C0324a.m571c(parcel, n);
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
            return new C1029hn(i, list, str, z);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bq */
    public C1029hn[] newArray(int i) {
        return new C1029hn[i];
    }
}
