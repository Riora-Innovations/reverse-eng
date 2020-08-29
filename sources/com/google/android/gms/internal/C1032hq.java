package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.hq */
public class C1032hq implements Creator<C1031hp> {
    /* renamed from: a */
    static void m3040a(C1031hp hpVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, hpVar.f2691wj);
        C0326b.m609a(parcel, 2, hpVar.mo5753gt(), false);
        C0326b.m609a(parcel, 3, hpVar.getTag(), false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: ax */
    public C1031hp createFromParcel(Parcel parcel) {
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
            return new C1031hp(i, str2, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: br */
    public C1031hp[] newArray(int i) {
        return new C1031hp[i];
    }
}
