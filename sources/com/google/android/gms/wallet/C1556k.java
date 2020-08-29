package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.k */
public class C1556k implements Creator<MaskedWallet> {
    /* renamed from: a */
    static void m4585a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, maskedWallet.getVersionCode());
        C0326b.m609a(parcel, 2, maskedWallet.f3989Yk, false);
        C0326b.m609a(parcel, 3, maskedWallet.f3990Yl, false);
        C0326b.m615a(parcel, 4, maskedWallet.f3994Yq, false);
        C0326b.m609a(parcel, 5, maskedWallet.f3991Yn, false);
        C0326b.m607a(parcel, 6, (Parcelable) maskedWallet.f3992Yo, i, false);
        C0326b.m607a(parcel, 7, (Parcelable) maskedWallet.f3993Yp, i, false);
        C0326b.m614a(parcel, 8, (T[]) maskedWallet.f3987YW, i, false);
        C0326b.m614a(parcel, 9, (T[]) maskedWallet.f3988YX, i, false);
        C0326b.m607a(parcel, 10, (Parcelable) maskedWallet.f3995Yr, i, false);
        C0326b.m607a(parcel, 11, (Parcelable) maskedWallet.f3996Ys, i, false);
        C0326b.m614a(parcel, 12, (T[]) maskedWallet.f3997Yt, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bb */
    public MaskedWallet createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    strArr = C0324a.m594x(parcel, n);
                    break;
                case 5:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    address = (Address) C0324a.m564a(parcel, n, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) C0324a.m564a(parcel, n, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0324a.m569b(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) C0324a.m569b(parcel, n, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0324a.m564a(parcel, n, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) C0324a.m564a(parcel, n, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) C0324a.m569b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ch */
    public MaskedWallet[] newArray(int i) {
        return new MaskedWallet[i];
    }
}
