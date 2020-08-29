package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.k */
public class C1295k {
    /* renamed from: a */
    static void m3764a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, visibleRegion.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) visibleRegion.nearLeft, i, false);
        C0326b.m607a(parcel, 3, (Parcelable) visibleRegion.nearRight, i, false);
        C0326b.m607a(parcel, 4, (Parcelable) visibleRegion.farLeft, i, false);
        C0326b.m607a(parcel, 5, (Parcelable) visibleRegion.farRight, i, false);
        C0326b.m607a(parcel, 6, (Parcelable) visibleRegion.latLngBounds, i, false);
        C0326b.m599D(parcel, p);
    }
}
