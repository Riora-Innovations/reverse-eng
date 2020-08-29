package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.ex */
public class C0772ex implements Creator<C0771ew> {
    /* renamed from: a */
    static void m1994a(C0771ew ewVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, ewVar.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) ewVar.mo5134ei(), i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: T */
    public C0771ew[] newArray(int i) {
        return new C0771ew[i];
    }

    /* renamed from: q */
    public C0771ew createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        C0773ey eyVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    eyVar = (C0773ey) C0324a.m564a(parcel, n, (Creator<T>) C0773ey.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0771ew(i, eyVar);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
