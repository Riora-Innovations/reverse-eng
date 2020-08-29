package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.ac */
public class C0505ac implements Creator<C0504ab> {
    /* renamed from: a */
    static void m1155a(C0504ab abVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, abVar.versionCode);
        C0326b.m609a(parcel, 2, abVar.f1194ln, false);
        C0326b.m619c(parcel, 3, abVar.height);
        C0326b.m619c(parcel, 4, abVar.heightPixels);
        C0326b.m612a(parcel, 5, abVar.f1195lo);
        C0326b.m619c(parcel, 6, abVar.width);
        C0326b.m619c(parcel, 7, abVar.widthPixels);
        C0326b.m614a(parcel, 8, (T[]) abVar.f1196lp, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: b */
    public C0504ab createFromParcel(Parcel parcel) {
        C0504ab[] abVarArr = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i5 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    i4 = C0324a.m575g(parcel, n);
                    break;
                case 4:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 6:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 7:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 8:
                    abVarArr = (C0504ab[]) C0324a.m569b(parcel, n, C0504ab.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0504ab(i5, str, i4, i3, z, i2, i, abVarArr);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: c */
    public C0504ab[] newArray(int i) {
        return new C0504ab[i];
    }
}
