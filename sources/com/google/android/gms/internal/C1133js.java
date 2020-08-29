package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.js */
public class C1133js implements Creator<C1132jr> {
    /* renamed from: a */
    static void m3371a(C1132jr jrVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, jrVar.getVersionCode());
        C0326b.m603a(parcel, 2, jrVar.f3098ZL);
        C0326b.m603a(parcel, 3, jrVar.f3099ZM);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bl */
    public C1132jr createFromParcel(Parcel parcel) {
        long j = 0;
        int o = C0324a.m584o(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 3:
                    j = C0324a.m576h(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1132jr(i, j2, j);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cr */
    public C1132jr[] newArray(int i) {
        return new C1132jr[i];
    }
}
