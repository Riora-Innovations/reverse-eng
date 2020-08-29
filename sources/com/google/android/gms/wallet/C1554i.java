package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.wallet.i */
public class C1554i implements Creator<LineItem> {
    /* renamed from: a */
    static void m4579a(LineItem lineItem, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, lineItem.getVersionCode());
        C0326b.m609a(parcel, 2, lineItem.description, false);
        C0326b.m609a(parcel, 3, lineItem.f3961Yy, false);
        C0326b.m609a(parcel, 4, lineItem.f3962Yz, false);
        C0326b.m609a(parcel, 5, lineItem.f3959Yf, false);
        C0326b.m619c(parcel, 6, lineItem.f3958YA);
        C0326b.m609a(parcel, 7, lineItem.f3960Yg, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aZ */
    public LineItem createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int o = C0324a.m584o(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str5 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 7:
                    str = C0324a.m581m(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cf */
    public LineItem[] newArray(int i) {
        return new LineItem[i];
    }
}
