package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.plus.internal.j */
public class C1343j implements Creator<C1341h> {
    /* renamed from: a */
    static void m3925a(C1341h hVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, hVar.getAccountName(), false);
        C0326b.m619c(parcel, 1000, hVar.getVersionCode());
        C0326b.m615a(parcel, 2, hVar.mo7422hq(), false);
        C0326b.m615a(parcel, 3, hVar.mo7423hr(), false);
        C0326b.m615a(parcel, 4, hVar.mo7424hs(), false);
        C0326b.m609a(parcel, 5, hVar.mo7425ht(), false);
        C0326b.m609a(parcel, 6, hVar.mo7426hu(), false);
        C0326b.m609a(parcel, 7, hVar.mo7427hv(), false);
        C0326b.m609a(parcel, 8, hVar.mo7428hw(), false);
        C0326b.m607a(parcel, 9, (Parcelable) hVar.mo7429hx(), i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aF */
    public C1341h createFromParcel(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str5 = C0324a.m581m(parcel, n);
                    break;
                case 2:
                    strArr3 = C0324a.m594x(parcel, n);
                    break;
                case 3:
                    strArr2 = C0324a.m594x(parcel, n);
                    break;
                case 4:
                    strArr = C0324a.m594x(parcel, n);
                    break;
                case 5:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 8:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 9:
                    plusCommonExtras = (PlusCommonExtras) C0324a.m564a(parcel, n, (Creator<T>) PlusCommonExtras.CREATOR);
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
            return new C1341h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bC */
    public C1341h[] newArray(int i) {
        return new C1341h[i];
    }
}
