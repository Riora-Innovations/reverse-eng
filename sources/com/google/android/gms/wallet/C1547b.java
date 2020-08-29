package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.b */
public class C1547b implements Creator<Cart> {
    /* renamed from: a */
    static void m4561a(Cart cart, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, cart.getVersionCode());
        C0326b.m609a(parcel, 2, cart.f3932Yf, false);
        C0326b.m609a(parcel, 3, cart.f3933Yg, false);
        C0326b.m618b(parcel, 4, cart.f3934Yh, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aT */
    public Cart createFromParcel(Parcel parcel) {
        String str = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
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
                    arrayList = C0324a.m570c(parcel, n, LineItem.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bZ */
    public Cart[] newArray(int i) {
        return new Cart[i];
    }
}
