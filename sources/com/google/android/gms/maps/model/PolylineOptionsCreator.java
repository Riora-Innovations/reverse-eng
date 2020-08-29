package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3708a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, polylineOptions.getVersionCode());
        C0326b.m618b(parcel, 2, polylineOptions.getPoints(), false);
        C0326b.m602a(parcel, 3, polylineOptions.getWidth());
        C0326b.m619c(parcel, 4, polylineOptions.getColor());
        C0326b.m602a(parcel, 5, polylineOptions.getZIndex());
        C0326b.m612a(parcel, 6, polylineOptions.isVisible());
        C0326b.m612a(parcel, 7, polylineOptions.isGeodesic());
        C0326b.m599D(parcel, p);
    }

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0324a.m584o(parcel);
        ArrayList arrayList = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    arrayList = C0324a.m570c(parcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C0324a.m578j(parcel, n);
                    break;
                case 4:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    f = C0324a.m578j(parcel, n);
                    break;
                case 6:
                    z2 = C0324a.m571c(parcel, n);
                    break;
                case 7:
                    z = C0324a.m571c(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolylineOptions(i2, arrayList, f2, i, f, z2, z);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
