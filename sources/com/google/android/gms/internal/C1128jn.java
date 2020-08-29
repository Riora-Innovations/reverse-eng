package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.jn */
public class C1128jn implements Creator<C1127jm> {
    /* renamed from: a */
    static void m3362a(C1127jm jmVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, jmVar.getVersionCode());
        C0326b.m619c(parcel, 2, jmVar.f3088ZE);
        C0326b.m609a(parcel, 3, jmVar.f3089ZF, false);
        C0326b.m601a(parcel, 4, jmVar.f3090ZG);
        C0326b.m609a(parcel, 5, jmVar.f3091ZH, false);
        C0326b.m603a(parcel, 6, jmVar.f3092ZI);
        C0326b.m619c(parcel, 7, jmVar.f3093ZJ);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bi */
    public C1127jm createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
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
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    d = C0324a.m579k(parcel, n);
                    break;
                case 5:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 7:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1127jm(i3, i, str2, d, str, j, i2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: co */
    public C1127jm[] newArray(int i) {
        return new C1127jm[i];
    }
}
