package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.wallet.g */
public class C1552g implements Creator<FullWalletRequest> {
    /* renamed from: a */
    static void m4573a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, fullWalletRequest.getVersionCode());
        C0326b.m609a(parcel, 2, fullWalletRequest.f3950Yk, false);
        C0326b.m609a(parcel, 3, fullWalletRequest.f3951Yl, false);
        C0326b.m607a(parcel, 4, (Parcelable) fullWalletRequest.f3952Yu, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aX */
    public FullWalletRequest createFromParcel(Parcel parcel) {
        Cart cart = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    cart = (Cart) C0324a.m564a(parcel, n, Cart.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cd */
    public FullWalletRequest[] newArray(int i) {
        return new FullWalletRequest[i];
    }
}
