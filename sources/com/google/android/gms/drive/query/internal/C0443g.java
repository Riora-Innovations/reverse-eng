package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.drive.query.internal.g */
public class C0443g implements Creator<NotFilter> {
    /* renamed from: a */
    static void m976a(NotFilter notFilter, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1000, notFilter.f841wj);
        C0326b.m607a(parcel, 1, (Parcelable) notFilter.f840EZ, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aM */
    public NotFilter[] newArray(int i) {
        return new NotFilter[i];
    }

    /* renamed from: ah */
    public NotFilter createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    filterHolder = (FilterHolder) C0324a.m564a(parcel, n, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
