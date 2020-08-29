package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C1265d {
    /* renamed from: a */
    static void m3719a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, latLngBounds.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) latLngBounds.southwest, i, false);
        C0326b.m607a(parcel, 3, (Parcelable) latLngBounds.northeast, i, false);
        C0326b.m599D(parcel, p);
    }
}
