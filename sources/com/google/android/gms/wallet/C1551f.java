package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.identity.intents.model.UserAddress;

/* renamed from: com.google.android.gms.wallet.f */
public class C1551f implements Creator<FullWallet> {
    /* renamed from: a */
    static void m4570a(FullWallet fullWallet, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, fullWallet.getVersionCode());
        C0326b.m609a(parcel, 2, fullWallet.f3939Yk, false);
        C0326b.m609a(parcel, 3, fullWallet.f3940Yl, false);
        C0326b.m607a(parcel, 4, (Parcelable) fullWallet.f3941Ym, i, false);
        C0326b.m609a(parcel, 5, fullWallet.f3942Yn, false);
        C0326b.m607a(parcel, 6, (Parcelable) fullWallet.f3943Yo, i, false);
        C0326b.m607a(parcel, 7, (Parcelable) fullWallet.f3944Yp, i, false);
        C0326b.m615a(parcel, 8, fullWallet.f3945Yq, false);
        C0326b.m607a(parcel, 9, (Parcelable) fullWallet.f3946Yr, i, false);
        C0326b.m607a(parcel, 10, (Parcelable) fullWallet.f3947Ys, i, false);
        C0326b.m614a(parcel, 11, (T[]) fullWallet.f3948Yt, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aW */
    public FullWallet createFromParcel(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    proxyCard = (ProxyCard) C0324a.m564a(parcel, n, ProxyCard.CREATOR);
                    break;
                case 5:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    address2 = (Address) C0324a.m564a(parcel, n, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) C0324a.m564a(parcel, n, Address.CREATOR);
                    break;
                case 8:
                    strArr = C0324a.m594x(parcel, n);
                    break;
                case 9:
                    userAddress2 = (UserAddress) C0324a.m564a(parcel, n, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0324a.m564a(parcel, n, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) C0324a.m569b(parcel, n, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cc */
    public FullWallet[] newArray(int i) {
        return new FullWallet[i];
    }
}
