package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.ai */
public class C0346ai implements Creator<QueryRequest> {
    /* renamed from: a */
    static void m682a(QueryRequest queryRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, queryRequest.f714wj);
        C0326b.m607a(parcel, 2, (Parcelable) queryRequest.f713Ef, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: W */
    public QueryRequest createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    query = (Query) C0324a.m564a(parcel, n, Query.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new QueryRequest(i, query);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: aB */
    public QueryRequest[] newArray(int i) {
        return new QueryRequest[i];
    }
}
