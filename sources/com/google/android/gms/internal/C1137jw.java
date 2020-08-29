package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.jw */
public class C1137jw implements Creator<C1136jv> {
    /* renamed from: a */
    static void m3377a(C1136jv jvVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, jvVar.getVersionCode());
        C0326b.m609a(parcel, 2, jvVar.f3103ZK, false);
        C0326b.m609a(parcel, 3, jvVar.f3107oi, false);
        C0326b.m607a(parcel, 4, (Parcelable) jvVar.f3104ZO, i, false);
        C0326b.m607a(parcel, 5, (Parcelable) jvVar.f3105ZP, i, false);
        C0326b.m607a(parcel, 6, (Parcelable) jvVar.f3106ZQ, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bn */
    public C1136jv createFromParcel(Parcel parcel) {
        C1134jt jtVar = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        C1134jt jtVar2 = null;
        C1132jr jrVar = null;
        String str = null;
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
                    jrVar = (C1132jr) C0324a.m564a(parcel, n, C1132jr.CREATOR);
                    break;
                case 5:
                    jtVar2 = (C1134jt) C0324a.m564a(parcel, n, C1134jt.CREATOR);
                    break;
                case 6:
                    jtVar = (C1134jt) C0324a.m564a(parcel, n, C1134jt.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1136jv(i, str2, str, jrVar, jtVar2, jtVar);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ct */
    public C1136jv[] newArray(int i) {
        return new C1136jv[i];
    }
}
