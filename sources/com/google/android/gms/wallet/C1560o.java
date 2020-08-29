package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.wallet.o */
public class C1560o implements Creator<ProxyCard> {
    /* renamed from: a */
    static void m4597a(ProxyCard proxyCard, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, proxyCard.getVersionCode());
        C0326b.m609a(parcel, 2, proxyCard.f4022Zn, false);
        C0326b.m609a(parcel, 3, proxyCard.f4023Zo, false);
        C0326b.m619c(parcel, 4, proxyCard.f4024Zp);
        C0326b.m619c(parcel, 5, proxyCard.f4025Zq);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bf */
    public ProxyCard createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    i = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cl */
    public ProxyCard[] newArray(int i) {
        return new ProxyCard[i];
    }
}
