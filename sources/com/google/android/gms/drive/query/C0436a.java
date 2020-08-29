package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

/* renamed from: com.google.android.gms.drive.query.a */
public class C0436a implements Creator<Query> {
    /* renamed from: a */
    static void m957a(Query query, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1000, query.f815wj);
        C0326b.m607a(parcel, 1, (Parcelable) query.f813EL, i, false);
        C0326b.m609a(parcel, 3, query.f814EM, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aG */
    public Query[] newArray(int i) {
        return new Query[i];
    }

    /* renamed from: ab */
    public Query createFromParcel(Parcel parcel) {
        String m;
        LogicalFilter logicalFilter;
        int i;
        String str = null;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        LogicalFilter logicalFilter2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = i2;
                    LogicalFilter logicalFilter3 = (LogicalFilter) C0324a.m564a(parcel, n, LogicalFilter.CREATOR);
                    m = str;
                    logicalFilter = logicalFilter3;
                    break;
                case 3:
                    m = C0324a.m581m(parcel, n);
                    logicalFilter = logicalFilter2;
                    i = i2;
                    break;
                case 1000:
                    String str2 = str;
                    logicalFilter = logicalFilter2;
                    i = C0324a.m575g(parcel, n);
                    m = str2;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    m = str;
                    logicalFilter = logicalFilter2;
                    i = i2;
                    break;
            }
            i2 = i;
            logicalFilter2 = logicalFilter;
            str = m;
        }
        if (parcel.dataPosition() == o) {
            return new Query(i2, logicalFilter2, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
