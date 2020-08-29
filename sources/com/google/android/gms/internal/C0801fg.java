package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C0797fe.C0798a;
import com.google.android.gms.internal.C0797fe.C0799b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.fg */
public class C0801fg implements Creator<C0798a> {
    /* renamed from: a */
    static void m2081a(C0798a aVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, aVar.versionCode);
        C0326b.m609a(parcel, 2, aVar.className, false);
        C0326b.m618b(parcel, 3, aVar.f2296CH, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: Z */
    public C0798a[] newArray(int i) {
        return new C0798a[i];
    }

    /* renamed from: w */
    public C0798a createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
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
                    arrayList = C0324a.m570c(parcel, n, C0799b.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0798a(i, str, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
