package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.drive.query.internal.c */
public class C0439c implements Creator<FilterHolder> {
    /* renamed from: a */
    static void m966a(FilterHolder filterHolder, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m607a(parcel, 1, (Parcelable) filterHolder.f826ER, i, false);
        C0326b.m619c(parcel, 1000, filterHolder.f832wj);
        C0326b.m607a(parcel, 2, (Parcelable) filterHolder.f827ES, i, false);
        C0326b.m607a(parcel, 3, (Parcelable) filterHolder.f828ET, i, false);
        C0326b.m607a(parcel, 4, (Parcelable) filterHolder.f829EU, i, false);
        C0326b.m607a(parcel, 5, (Parcelable) filterHolder.f830EV, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aJ */
    public FilterHolder[] newArray(int i) {
        return new FilterHolder[i];
    }

    /* renamed from: ae */
    public FilterHolder createFromParcel(Parcel parcel) {
        InFilter inFilter = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) C0324a.m564a(parcel, n, (Creator<T>) ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) C0324a.m564a(parcel, n, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) C0324a.m564a(parcel, n, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) C0324a.m564a(parcel, n, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) C0324a.m564a(parcel, n, (Creator<T>) InFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
