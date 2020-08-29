package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C1267f {
    /* renamed from: a */
    static void m3721a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, markerOptions.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) markerOptions.getPosition(), i, false);
        C0326b.m609a(parcel, 3, markerOptions.getTitle(), false);
        C0326b.m609a(parcel, 4, markerOptions.getSnippet(), false);
        C0326b.m605a(parcel, 5, markerOptions.mo7013hf(), false);
        C0326b.m602a(parcel, 6, markerOptions.getAnchorU());
        C0326b.m602a(parcel, 7, markerOptions.getAnchorV());
        C0326b.m612a(parcel, 8, markerOptions.isDraggable());
        C0326b.m612a(parcel, 9, markerOptions.isVisible());
        C0326b.m599D(parcel, p);
    }
}
