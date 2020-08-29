package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C1270i {
    /* renamed from: a */
    static void m3724a(Tile tile, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, tile.getVersionCode());
        C0326b.m619c(parcel, 2, tile.width);
        C0326b.m619c(parcel, 3, tile.height);
        C0326b.m613a(parcel, 4, tile.data, false);
        C0326b.m599D(parcel, p);
    }
}
