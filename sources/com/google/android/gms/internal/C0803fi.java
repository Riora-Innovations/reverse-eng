package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.fi */
public class C0803fi implements Creator<C0802fh> {
    /* renamed from: a */
    static void m2101a(C0802fh fhVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, fhVar.getVersionCode());
        C0326b.m606a(parcel, 2, fhVar.mo5225eF(), false);
        C0326b.m607a(parcel, 3, (Parcelable) fhVar.mo5226eG(), i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aa */
    public C0802fh[] newArray(int i) {
        return new C0802fh[i];
    }

    /* renamed from: x */
    public C0802fh createFromParcel(Parcel parcel) {
        C0797fe feVar = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    parcel2 = C0324a.m596z(parcel, n);
                    break;
                case 3:
                    feVar = (C0797fe) C0324a.m564a(parcel, n, (Creator<T>) C0797fe.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0802fh(i, parcel2, feVar);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
