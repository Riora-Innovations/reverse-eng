package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3715a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, visibleRegion.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C0326b.m607a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C0326b.m607a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C0326b.m607a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C0326b.m607a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C0326b.m599D(parcel, p);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    latLng4 = (LatLng) C0324a.m564a(parcel, n, (Creator<T>) LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C0324a.m564a(parcel, n, (Creator<T>) LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C0324a.m564a(parcel, n, (Creator<T>) LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C0324a.m564a(parcel, n, (Creator<T>) LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0324a.m564a(parcel, n, (Creator<T>) LatLngBounds.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
