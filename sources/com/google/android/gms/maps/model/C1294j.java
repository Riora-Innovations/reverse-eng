package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C1294j {
    /* renamed from: a */
    static void m3763a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0326b.m605a(parcel, 2, tileOverlayOptions.mo7128hh(), false);
        C0326b.m612a(parcel, 3, tileOverlayOptions.isVisible());
        C0326b.m602a(parcel, 4, tileOverlayOptions.getZIndex());
        C0326b.m599D(parcel, p);
    }
}
