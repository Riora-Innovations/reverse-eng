package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C0792fb.C0793a;
import com.google.android.gms.internal.C0797fe.C0799b;

/* renamed from: com.google.android.gms.internal.fd */
public class C0796fd implements Creator<C0799b> {
    /* renamed from: a */
    static void m2065a(C0799b bVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, bVar.versionCode);
        C0326b.m609a(parcel, 2, bVar.f2298eX, false);
        C0326b.m607a(parcel, 3, (Parcelable) bVar.f2297CI, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: X */
    public C0799b[] newArray(int i) {
        return new C0799b[i];
    }

    /* renamed from: u */
    public C0799b createFromParcel(Parcel parcel) {
        C0793a aVar = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    aVar = (C0793a) C0324a.m564a(parcel, n, (Creator<T>) C0793a.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0799b(i, str, aVar);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
