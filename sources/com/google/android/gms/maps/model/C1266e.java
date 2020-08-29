package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C1266e {
    /* renamed from: a */
    static void m3720a(LatLng latLng, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, latLng.getVersionCode());
        C0326b.m601a(parcel, 2, latLng.latitude);
        C0326b.m601a(parcel, 3, latLng.longitude);
        C0326b.m599D(parcel, p);
    }
}
