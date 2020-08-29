package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C1268g {
    /* renamed from: a */
    static void m3722a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, polygonOptions.getVersionCode());
        C0326b.m618b(parcel, 2, polygonOptions.getPoints(), false);
        C0326b.m620c(parcel, 3, polygonOptions.mo7061hg(), false);
        C0326b.m602a(parcel, 4, polygonOptions.getStrokeWidth());
        C0326b.m619c(parcel, 5, polygonOptions.getStrokeColor());
        C0326b.m619c(parcel, 6, polygonOptions.getFillColor());
        C0326b.m602a(parcel, 7, polygonOptions.getZIndex());
        C0326b.m612a(parcel, 8, polygonOptions.isVisible());
        C0326b.m612a(parcel, 9, polygonOptions.isGeodesic());
        C0326b.m599D(parcel, p);
    }
}
