package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.cg */
public class C0629cg implements Creator<C0628cf> {
    /* renamed from: a */
    static void m1429a(C0628cf cfVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, cfVar.versionCode);
        C0326b.m609a(parcel, 2, cfVar.f1666nw, false);
        C0326b.m609a(parcel, 3, cfVar.f1667oi, false);
        C0326b.m610a(parcel, 4, cfVar.f1663mt, false);
        C0326b.m619c(parcel, 5, cfVar.errorCode);
        C0326b.m610a(parcel, 6, cfVar.f1664mu, false);
        C0326b.m603a(parcel, 7, cfVar.f1668oj);
        C0326b.m612a(parcel, 8, cfVar.f1669ok);
        C0326b.m603a(parcel, 9, cfVar.f1670ol);
        C0326b.m610a(parcel, 10, cfVar.f1671om, false);
        C0326b.m603a(parcel, 11, cfVar.f1665mx);
        C0326b.m619c(parcel, 12, cfVar.orientation);
        C0326b.m609a(parcel, 13, cfVar.f1672on, false);
        C0326b.m603a(parcel, 14, cfVar.f1673oo);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: g */
    public C0628cf createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        int i2 = 0;
        ArrayList arrayList2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        ArrayList arrayList3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    arrayList = C0324a.m595y(parcel, n);
                    break;
                case 5:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 6:
                    arrayList2 = C0324a.m595y(parcel, n);
                    break;
                case 7:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 8:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 9:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 10:
                    arrayList3 = C0324a.m595y(parcel, n);
                    break;
                case 11:
                    j3 = C0324a.m576h(parcel, n);
                    break;
                case 12:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 13:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 14:
                    j4 = C0324a.m576h(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0628cf(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: l */
    public C0628cf[] newArray(int i) {
        return new C0628cf[i];
    }
}
