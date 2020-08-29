package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.location.c */
public class C1178c implements Creator<C1177b> {
    /* renamed from: a */
    static void m3584a(C1177b bVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, bVar.f3193Lh);
        C0326b.m619c(parcel, 1000, bVar.getVersionCode());
        C0326b.m619c(parcel, 2, bVar.f3194Li);
        C0326b.m603a(parcel, 3, bVar.f3195Lj);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: au */
    public C1177b createFromParcel(Parcel parcel) {
        int i = 1;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 3:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 1000:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1177b(i2, i3, i, j);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bm */
    public C1177b[] newArray(int i) {
        return new C1177b[i];
    }
}
