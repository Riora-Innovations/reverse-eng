package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.drive.query.internal.h */
public class C0444h implements Creator<Operator> {
    /* renamed from: a */
    static void m979a(Operator operator, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1000, operator.f851wj);
        C0326b.m609a(parcel, 1, operator.mTag, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aN */
    public Operator[] newArray(int i) {
        return new Operator[i];
    }

    /* renamed from: ai */
    public Operator createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 1000:
                    i = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new Operator(i, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
