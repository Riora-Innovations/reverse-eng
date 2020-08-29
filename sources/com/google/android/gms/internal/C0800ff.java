package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C0797fe.C0798a;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ff */
public class C0800ff implements Creator<C0797fe> {
    /* renamed from: a */
    static void m2078a(C0797fe feVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, feVar.getVersionCode());
        C0326b.m618b(parcel, 2, feVar.mo5206eC(), false);
        C0326b.m609a(parcel, 3, feVar.mo5207eD(), false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: Y */
    public C0797fe[] newArray(int i) {
        return new C0797fe[i];
    }

    /* renamed from: v */
    public C0797fe createFromParcel(Parcel parcel) {
        String str = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    arrayList = C0324a.m570c(parcel, n, C0798a.CREATOR);
                    break;
                case 3:
                    str = C0324a.m581m(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0797fe(i, arrayList, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
