package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.b */
public class C0438b implements Creator<FieldOnlyFilter> {
    /* renamed from: a */
    static void m963a(FieldOnlyFilter fieldOnlyFilter, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1000, fieldOnlyFilter.f825wj);
        C0326b.m607a(parcel, 1, (Parcelable) fieldOnlyFilter.f823EP, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aI */
    public FieldOnlyFilter[] newArray(int i) {
        return new FieldOnlyFilter[i];
    }

    /* renamed from: ad */
    public FieldOnlyFilter createFromParcel(Parcel parcel) {
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
            return new FieldOnlyFilter(i, metadataBundle);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
