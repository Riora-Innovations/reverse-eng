package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.dc */
public class C0664dc implements Creator<C0663db> {
    /* renamed from: a */
    static void m1556a(C0663db dbVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, dbVar.versionCode);
        C0326b.m609a(parcel, 2, dbVar.f1798pU, false);
        C0326b.m619c(parcel, 3, dbVar.f1799pV);
        C0326b.m619c(parcel, 4, dbVar.f1800pW);
        C0326b.m612a(parcel, 5, dbVar.f1801pX);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: h */
    public C0663db createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0324a.m584o(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 4:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    z = C0324a.m571c(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0663db(i3, str, i2, i, z);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: o */
    public C0663db[] newArray(int i) {
        return new C0663db[i];
    }
}
