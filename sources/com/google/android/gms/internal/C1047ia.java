package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ia */
public class C1047ia implements Creator<C1045hz> {
    /* renamed from: a */
    static void m3092a(C1045hz hzVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, hzVar.name, false);
        C0326b.m619c(parcel, 1000, hzVar.versionCode);
        C0326b.m609a(parcel, 2, hzVar.f2848Ov, false);
        C0326b.m609a(parcel, 3, hzVar.f2849Ow, false);
        C0326b.m609a(parcel, 4, hzVar.f2850Ox, false);
        C0326b.m610a(parcel, 5, hzVar.f2851Oy, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aC */
    public C1045hz createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 2:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    arrayList = C0324a.m595y(parcel, n);
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
            return new C1045hz(i, str4, str3, str2, str, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bx */
    public C1045hz[] newArray(int i) {
        return new C1045hz[i];
    }
}
