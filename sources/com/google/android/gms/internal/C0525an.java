package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.an */
public class C0525an implements Creator<C0524am> {
    /* renamed from: a */
    static void m1210a(C0524am amVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, amVar.versionCode);
        C0326b.m619c(parcel, 2, amVar.f1237lI);
        C0326b.m619c(parcel, 3, amVar.backgroundColor);
        C0326b.m619c(parcel, 4, amVar.f1238lJ);
        C0326b.m619c(parcel, 5, amVar.f1239lK);
        C0326b.m619c(parcel, 6, amVar.f1240lL);
        C0326b.m619c(parcel, 7, amVar.f1241lM);
        C0326b.m619c(parcel, 8, amVar.f1242lN);
        C0326b.m619c(parcel, 9, amVar.f1243lO);
        C0326b.m609a(parcel, 10, amVar.f1244lP, false);
        C0326b.m619c(parcel, 11, amVar.f1245lQ);
        C0326b.m609a(parcel, 12, amVar.f1246lR, false);
        C0326b.m619c(parcel, 13, amVar.f1247lS);
        C0326b.m619c(parcel, 14, amVar.f1248lT);
        C0326b.m609a(parcel, 15, amVar.f1249lU, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: c */
    public C0524am createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 3:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 4:
                    i4 = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    i5 = C0324a.m575g(parcel, n);
                    break;
                case 6:
                    i6 = C0324a.m575g(parcel, n);
                    break;
                case 7:
                    i7 = C0324a.m575g(parcel, n);
                    break;
                case 8:
                    i8 = C0324a.m575g(parcel, n);
                    break;
                case 9:
                    i9 = C0324a.m575g(parcel, n);
                    break;
                case 10:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 11:
                    i10 = C0324a.m575g(parcel, n);
                    break;
                case 12:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 13:
                    i11 = C0324a.m575g(parcel, n);
                    break;
                case 14:
                    i12 = C0324a.m575g(parcel, n);
                    break;
                case 15:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0524am(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: e */
    public C0524am[] newArray(int i) {
        return new C0524am[i];
    }
}
