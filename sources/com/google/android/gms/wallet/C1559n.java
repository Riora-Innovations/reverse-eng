package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.wallet.n */
public class C1559n implements Creator<OfferWalletObject> {
    /* renamed from: a */
    static void m4594a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, offerWalletObject.getVersionCode());
        C0326b.m609a(parcel, 2, offerWalletObject.f4020eN, false);
        C0326b.m609a(parcel, 3, offerWalletObject.f4019Zm, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: be */
    public OfferWalletObject createFromParcel(Parcel parcel) {
        String str = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
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
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OfferWalletObject(i, str2, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ck */
    public OfferWalletObject[] newArray(int i) {
        return new OfferWalletObject[i];
    }
}
