package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3580a(LocationRequest locationRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, locationRequest.mPriority);
        C0326b.m619c(parcel, 1000, locationRequest.getVersionCode());
        C0326b.m603a(parcel, 2, locationRequest.f3186Lc);
        C0326b.m603a(parcel, 3, locationRequest.f3187Ld);
        C0326b.m612a(parcel, 4, locationRequest.f3188Le);
        C0326b.m603a(parcel, 5, locationRequest.f3185KV);
        C0326b.m619c(parcel, 6, locationRequest.f3189Lf);
        C0326b.m602a(parcel, 7, locationRequest.f3190Lg);
        C0326b.m599D(parcel, p);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0324a.m584o(parcel);
        int i = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 3:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 4:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 5:
                    j3 = C0324a.m576h(parcel, n);
                    break;
                case 6:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 7:
                    f = C0324a.m578j(parcel, n);
                    break;
                case 1000:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
