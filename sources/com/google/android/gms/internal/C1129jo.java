package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.jo */
public class C1129jo implements Creator<C1126jl> {
    /* renamed from: a */
    static void m3365a(C1126jl jlVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, jlVar.getVersionCode());
        C0326b.m609a(parcel, 2, jlVar.label, false);
        C0326b.m607a(parcel, 3, (Parcelable) jlVar.f3086ZD, i, false);
        C0326b.m609a(parcel, 4, jlVar.type, false);
        C0326b.m607a(parcel, 5, (Parcelable) jlVar.f3085YM, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bj */
    public C1126jl createFromParcel(Parcel parcel) {
        C1132jr jrVar = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        C1127jm jmVar = null;
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
                    jmVar = (C1127jm) C0324a.m564a(parcel, n, C1127jm.CREATOR);
                    break;
                case 4:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    jrVar = (C1132jr) C0324a.m564a(parcel, n, C1132jr.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1126jl(i, str2, jmVar, str, jrVar);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cp */
    public C1126jl[] newArray(int i) {
        return new C1126jl[i];
    }
}
