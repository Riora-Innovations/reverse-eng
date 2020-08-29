package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C1264c {
    /* renamed from: a */
    static void m3718a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0326b.m605a(parcel, 2, groundOverlayOptions.mo6938he(), false);
        C0326b.m607a(parcel, 3, (Parcelable) groundOverlayOptions.getLocation(), i, false);
        C0326b.m602a(parcel, 4, groundOverlayOptions.getWidth());
        C0326b.m602a(parcel, 5, groundOverlayOptions.getHeight());
        C0326b.m607a(parcel, 6, (Parcelable) groundOverlayOptions.getBounds(), i, false);
        C0326b.m602a(parcel, 7, groundOverlayOptions.getBearing());
        C0326b.m602a(parcel, 8, groundOverlayOptions.getZIndex());
        C0326b.m612a(parcel, 9, groundOverlayOptions.isVisible());
        C0326b.m602a(parcel, 10, groundOverlayOptions.getTransparency());
        C0326b.m602a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0326b.m602a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0326b.m599D(parcel, p);
    }
}
