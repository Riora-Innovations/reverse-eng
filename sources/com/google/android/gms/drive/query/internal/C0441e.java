package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.e */
public class C0441e implements Creator<InFilter> {
    /* renamed from: a */
    static void m970a(InFilter inFilter, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1000, inFilter.f835wj);
        C0326b.m607a(parcel, 1, (Parcelable) inFilter.f833EP, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aK */
    public InFilter[] newArray(int i) {
        return new InFilter[i];
    }

    /* renamed from: af */
    public InFilter createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    metadataBundle = (MetadataBundle) C0324a.m564a(parcel, n, MetadataBundle.CREATOR);
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
            return new InFilter(i, metadataBundle);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
