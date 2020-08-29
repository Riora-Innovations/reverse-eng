package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C0773ey.C0774a;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ez */
public class C0775ez implements Creator<C0773ey> {
    /* renamed from: a */
    static void m2004a(C0773ey eyVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, eyVar.getVersionCode());
        C0326b.m618b(parcel, 2, eyVar.mo5144ek(), false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: U */
    public C0773ey[] newArray(int i) {
        return new C0773ey[i];
    }

    /* renamed from: r */
    public C0773ey createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    arrayList = C0324a.m570c(parcel, n, C0774a.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0773ey(i, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
