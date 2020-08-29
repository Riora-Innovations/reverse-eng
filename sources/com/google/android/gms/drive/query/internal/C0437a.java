package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.query.internal.a */
public class C0437a implements Creator<ComparisonFilter> {
    /* renamed from: a */
    static void m960a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1000, comparisonFilter.f822wj);
        C0326b.m607a(parcel, 1, (Parcelable) comparisonFilter.f819EO, i, false);
        C0326b.m607a(parcel, 2, (Parcelable) comparisonFilter.f820EP, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aH */
    public ComparisonFilter[] newArray(int i) {
        return new ComparisonFilter[i];
    }

    /* renamed from: ac */
    public ComparisonFilter createFromParcel(Parcel parcel) {
        MetadataBundle metadataBundle;
        Operator operator;
        int i;
        MetadataBundle metadataBundle2 = null;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = i2;
                    Operator operator3 = (Operator) C0324a.m564a(parcel, n, Operator.CREATOR);
                    metadataBundle = metadataBundle2;
                    operator = operator3;
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0324a.m564a(parcel, n, MetadataBundle.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case 1000:
                    MetadataBundle metadataBundle3 = metadataBundle2;
                    operator = operator2;
                    i = C0324a.m575g(parcel, n);
                    metadataBundle = metadataBundle3;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    metadataBundle = metadataBundle2;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            metadataBundle2 = metadataBundle;
        }
        if (parcel.dataPosition() == o) {
            return new ComparisonFilter(i2, operator2, metadataBundle2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
