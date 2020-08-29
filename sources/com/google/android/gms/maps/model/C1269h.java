package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C1269h {
    /* renamed from: a */
    static void m3723a(PolylineOptions polylineOptions, Parcel parcel, int i) {
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
}
