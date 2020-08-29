package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.location.LocationRequest;

/* renamed from: com.google.android.gms.internal.hs */
public class C1034hs implements Creator<C1033hr> {
    /* renamed from: a */
    static void m3045a(C1033hr hrVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m607a(parcel, 1, (Parcelable) hrVar.mo5763gu(), i, false);
        C0326b.m619c(parcel, 1000, hrVar.f2694wj);
        C0326b.m607a(parcel, 2, (Parcelable) hrVar.mo5764gv(), i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: ay */
    public C1033hr createFromParcel(Parcel parcel) {
        C1029hn hnVar;
        LocationRequest locationRequest;
        int i;
        C1029hn hnVar2 = null;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        LocationRequest locationRequest2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = i2;
                    LocationRequest locationRequest3 = (LocationRequest) C0324a.m564a(parcel, n, (Creator<T>) LocationRequest.CREATOR);
                    hnVar = hnVar2;
                    locationRequest = locationRequest3;
                    break;
                case 2:
                    hnVar = (C1029hn) C0324a.m564a(parcel, n, (Creator<T>) C1029hn.CREATOR);
                    locationRequest = locationRequest2;
                    i = i2;
                    break;
                case 1000:
                    C1029hn hnVar3 = hnVar2;
                    locationRequest = locationRequest2;
                    i = C0324a.m575g(parcel, n);
                    hnVar = hnVar3;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    hnVar = hnVar2;
                    locationRequest = locationRequest2;
                    i = i2;
                    break;
            }
            i2 = i;
            locationRequest2 = locationRequest;
            hnVar2 = hnVar;
        }
        if (parcel.dataPosition() == o) {
            return new C1033hr(i2, locationRequest2, hnVar2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bs */
    public C1033hr[] newArray(int i) {
        return new C1033hr[i];
    }
}
