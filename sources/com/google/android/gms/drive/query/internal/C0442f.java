package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.f */
public class C0442f implements Creator<LogicalFilter> {
    /* renamed from: a */
    static void m973a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1000, logicalFilter.f839wj);
        C0326b.m607a(parcel, 1, (Parcelable) logicalFilter.f837EO, i, false);
        C0326b.m618b(parcel, 2, logicalFilter.f838EY, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aL */
    public LogicalFilter[] newArray(int i) {
        return new LogicalFilter[i];
    }

    /* renamed from: ag */
    public LogicalFilter createFromParcel(Parcel parcel) {
        List c;
        Operator operator;
        int i;
        List list = null;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        Operator operator2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = i2;
                    Operator operator3 = (Operator) C0324a.m564a(parcel, n, Operator.CREATOR);
                    c = list;
                    operator = operator3;
                    break;
                case 2:
                    c = C0324a.m570c(parcel, n, FilterHolder.CREATOR);
                    operator = operator2;
                    i = i2;
                    break;
                case 1000:
                    List list2 = list;
                    operator = operator2;
                    i = C0324a.m575g(parcel, n);
                    c = list2;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    c = list;
                    operator = operator2;
                    i = i2;
                    break;
            }
            i2 = i;
            operator2 = operator;
            list = c;
        }
        if (parcel.dataPosition() == o) {
            return new LogicalFilter(i2, operator2, list);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
