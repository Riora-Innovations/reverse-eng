package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C1263b {
    /* renamed from: a */
    static void m3717a(CircleOptions circleOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, circleOptions.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) circleOptions.getCenter(), i, false);
        C0326b.m601a(parcel, 3, circleOptions.getRadius());
        C0326b.m602a(parcel, 4, circleOptions.getStrokeWidth());
        C0326b.m619c(parcel, 5, circleOptions.getStrokeColor());
        C0326b.m619c(parcel, 6, circleOptions.getFillColor());
        C0326b.m602a(parcel, 7, circleOptions.getZIndex());
        C0326b.m612a(parcel, 8, circleOptions.isVisible());
        C0326b.m599D(parcel, p);
    }
}
