package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.l */
public class C1557l implements Creator<MaskedWalletRequest> {
    /* renamed from: a */
    static void m4588a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0326b.m609a(parcel, 2, maskedWalletRequest.f4002Yl, false);
        C0326b.m612a(parcel, 3, maskedWalletRequest.f3999YY);
        C0326b.m612a(parcel, 4, maskedWalletRequest.f4000YZ);
        C0326b.m612a(parcel, 5, maskedWalletRequest.f4004Za);
        C0326b.m609a(parcel, 6, maskedWalletRequest.f4005Zb, false);
        C0326b.m609a(parcel, 7, maskedWalletRequest.f4001Yg, false);
        C0326b.m609a(parcel, 8, maskedWalletRequest.f4006Zc, false);
        C0326b.m607a(parcel, 9, (Parcelable) maskedWalletRequest.f4003Yu, i, false);
        C0326b.m612a(parcel, 10, maskedWalletRequest.f4007Zd);
        C0326b.m612a(parcel, 11, maskedWalletRequest.f4008Ze);
        C0326b.m614a(parcel, 12, (T[]) maskedWalletRequest.f4009Zf, i, false);
        C0326b.m612a(parcel, 13, maskedWalletRequest.f4010Zg);
        C0326b.m612a(parcel, 14, maskedWalletRequest.f4011Zh);
        C0326b.m618b(parcel, 15, maskedWalletRequest.f4012Zi, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bc */
    public MaskedWalletRequest createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
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
                    z = C0324a.m571c(parcel, n);
                    break;
                case 4:
                    z2 = C0324a.m571c(parcel, n);
                    break;
                case 5:
                    z3 = C0324a.m571c(parcel, n);
                    break;
                case 6:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 8:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 9:
                    cart = (Cart) C0324a.m564a(parcel, n, Cart.CREATOR);
                    break;
                case 10:
                    z4 = C0324a.m571c(parcel, n);
                    break;
                case 11:
                    z5 = C0324a.m571c(parcel, n);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) C0324a.m569b(parcel, n, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = C0324a.m571c(parcel, n);
                    break;
                case 14:
                    z7 = C0324a.m571c(parcel, n);
                    break;
                case 15:
                    arrayList = C0324a.m570c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ci */
    public MaskedWalletRequest[] newArray(int i) {
        return new MaskedWalletRequest[i];
    }
}
