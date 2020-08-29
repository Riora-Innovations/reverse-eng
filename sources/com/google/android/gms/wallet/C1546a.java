package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.wallet.a */
public class C1546a implements Creator<Address> {
    /* renamed from: a */
    static void m4558a(Address address, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, address.getVersionCode());
        C0326b.m609a(parcel, 2, address.name, false);
        C0326b.m609a(parcel, 3, address.f3921KB, false);
        C0326b.m609a(parcel, 4, address.f3922KC, false);
        C0326b.m609a(parcel, 5, address.f3923KD, false);
        C0326b.m609a(parcel, 6, address.f3930oQ, false);
        C0326b.m609a(parcel, 7, address.f3928Yd, false);
        C0326b.m609a(parcel, 8, address.f3929Ye, false);
        C0326b.m609a(parcel, 9, address.f3924KI, false);
        C0326b.m609a(parcel, 10, address.f3925KK, false);
        C0326b.m612a(parcel, 11, address.f3926KL);
        C0326b.m609a(parcel, 12, address.f3927KM, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aS */
    public Address createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        boolean z = false;
        String str10 = null;
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
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    str5 = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    str6 = C0324a.m581m(parcel, n);
                    break;
                case 8:
                    str7 = C0324a.m581m(parcel, n);
                    break;
                case 9:
                    str8 = C0324a.m581m(parcel, n);
                    break;
                case 10:
                    str9 = C0324a.m581m(parcel, n);
                    break;
                case 11:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 12:
                    str10 = C0324a.m581m(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bY */
    public Address[] newArray(int i) {
        return new Address[i];
    }
}
