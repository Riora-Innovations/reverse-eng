package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.drive.internal.ae */
public class C0342ae implements Creator<OnListParentsResponse> {
    /* renamed from: a */
    static void m670a(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, onListParentsResponse.f703wj);
        C0326b.m607a(parcel, 2, (Parcelable) onListParentsResponse.f702Ee, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: S */
    public OnListParentsResponse createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    dataHolder = (DataHolder) C0324a.m564a(parcel, n, (Creator<T>) DataHolder.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ax */
    public OnListParentsResponse[] newArray(int i) {
        return new OnListParentsResponse[i];
    }
}
