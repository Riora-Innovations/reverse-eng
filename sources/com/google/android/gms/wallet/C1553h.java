package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.wallet.h */
public class C1553h implements Creator<InstrumentInfo> {
    /* renamed from: a */
    static void m4576a(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, instrumentInfo.getVersionCode());
        C0326b.m609a(parcel, 2, instrumentInfo.getInstrumentType(), false);
        C0326b.m609a(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aY */
    public InstrumentInfo createFromParcel(Parcel parcel) {
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
            return new InstrumentInfo(i, str2, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ce */
    public InstrumentInfo[] newArray(int i) {
        return new InstrumentInfo[i];
    }
}
