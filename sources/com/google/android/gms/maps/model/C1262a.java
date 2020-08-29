package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C1262a {
    /* renamed from: a */
    static void m3716a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, cameraPosition.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C0326b.m602a(parcel, 3, cameraPosition.zoom);
        C0326b.m602a(parcel, 4, cameraPosition.tilt);
        C0326b.m602a(parcel, 5, cameraPosition.bearing);
        C0326b.m599D(parcel, p);
    }
}
