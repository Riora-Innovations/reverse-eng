package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.wallet.e */
public class C1550e implements Creator<C1549d> {
    /* renamed from: a */
    static void m4567a(C1549d dVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, dVar.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) dVar.f4040Yj, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aV */
    public C1549d createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    loyaltyWalletObject = (LoyaltyWalletObject) C0324a.m564a(parcel, n, LoyaltyWalletObject.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1549d(i, loyaltyWalletObject);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cb */
    public C1549d[] newArray(int i) {
        return new C1549d[i];
    }
}
