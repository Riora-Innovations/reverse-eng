package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C0792fb.C0793a;

/* renamed from: com.google.android.gms.internal.fc */
public class C0795fc implements Creator<C0793a> {
    /* renamed from: a */
    static void m2062a(C0793a aVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, aVar.getVersionCode());
        C0326b.m619c(parcel, 2, aVar.mo5176el());
        C0326b.m612a(parcel, 3, aVar.mo5179er());
        C0326b.m619c(parcel, 4, aVar.mo5177em());
        C0326b.m612a(parcel, 5, aVar.mo5180es());
        C0326b.m609a(parcel, 6, aVar.mo5181et(), false);
        C0326b.m619c(parcel, 7, aVar.mo5182eu());
        C0326b.m609a(parcel, 8, aVar.mo5184ew(), false);
        C0326b.m607a(parcel, 9, (Parcelable) aVar.mo5186ey(), i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: W */
    public C0793a[] newArray(int i) {
        return new C0793a[i];
    }

    /* renamed from: t */
    public C0793a createFromParcel(Parcel parcel) {
        C0771ew ewVar = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i4 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 3:
                    z2 = C0324a.m571c(parcel, n);
                    break;
                case 4:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 6:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 8:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 9:
                    ewVar = (C0771ew) C0324a.m564a(parcel, n, (Creator<T>) C0771ew.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0793a(i4, i3, z2, i2, z, str2, i, str, ewVar);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
