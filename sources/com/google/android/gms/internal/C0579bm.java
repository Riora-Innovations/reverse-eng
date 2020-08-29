package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.bm */
public class C0579bm implements Creator<C0580bn> {
    /* renamed from: a */
    static void m1285a(C0580bn bnVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, bnVar.versionCode);
        C0326b.m609a(parcel, 2, bnVar.f1515mY, false);
        C0326b.m609a(parcel, 3, bnVar.f1516mZ, false);
        C0326b.m609a(parcel, 4, bnVar.mimeType, false);
        C0326b.m609a(parcel, 5, bnVar.packageName, false);
        C0326b.m609a(parcel, 6, bnVar.f1517na, false);
        C0326b.m609a(parcel, 7, bnVar.f1518nb, false);
        C0326b.m609a(parcel, 8, bnVar.f1519nc, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: d */
    public C0580bn createFromParcel(Parcel parcel) {
        String str = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str7 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str6 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    str5 = C0324a.m581m(parcel, n);
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
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0580bn(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: i */
    public C0580bn[] newArray(int i) {
        return new C0580bn[i];
    }
}
