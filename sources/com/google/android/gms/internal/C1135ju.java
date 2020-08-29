package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.ju */
public class C1135ju implements Creator<C1134jt> {
    /* renamed from: a */
    static void m3374a(C1134jt jtVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, jtVar.getVersionCode());
        C0326b.m609a(parcel, 2, jtVar.f3101ZN, false);
        C0326b.m609a(parcel, 3, jtVar.description, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bm */
    public C1134jt createFromParcel(Parcel parcel) {
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
            return new C1134jt(i, str2, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cs */
    public C1134jt[] newArray(int i) {
        return new C1134jt[i];
    }
}
