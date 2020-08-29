package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.maps.a */
public class C1199a {
    /* renamed from: a */
    static void m3622a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, googleMapOptions.getVersionCode());
        C0326b.m600a(parcel, 2, googleMapOptions.mo6621gN());
        C0326b.m600a(parcel, 3, googleMapOptions.mo6622gO());
        C0326b.m619c(parcel, 4, googleMapOptions.getMapType());
        C0326b.m607a(parcel, 5, (Parcelable) googleMapOptions.getCamera(), i, false);
        C0326b.m600a(parcel, 6, googleMapOptions.mo6623gP());
        C0326b.m600a(parcel, 7, googleMapOptions.mo6624gQ());
        C0326b.m600a(parcel, 8, googleMapOptions.mo6625gR());
        C0326b.m600a(parcel, 9, googleMapOptions.mo6626gS());
        C0326b.m600a(parcel, 10, googleMapOptions.mo6627gT());
        C0326b.m600a(parcel, 11, googleMapOptions.mo6628gU());
        C0326b.m599D(parcel, p);
    }
}
