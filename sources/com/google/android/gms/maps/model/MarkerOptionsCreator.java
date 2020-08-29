package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

public class MarkerOptionsCreator implements Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3705a(MarkerOptions markerOptions, Parcel parcel, int i) {
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
        C0326b.m612a(parcel, 10, markerOptions.isFlat());
        C0326b.m602a(parcel, 11, markerOptions.getRotation());
        C0326b.m602a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0326b.m602a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0326b.m602a(parcel, 14, markerOptions.getAlpha());
        C0326b.m599D(parcel, p);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = 1.0f;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    latLng = (LatLng) C0324a.m564a(parcel, n, (Creator<T>) LatLng.CREATOR);
                    break;
                case 3:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    iBinder = C0324a.m583n(parcel, n);
                    break;
                case 6:
                    f = C0324a.m578j(parcel, n);
                    break;
                case 7:
                    f2 = C0324a.m578j(parcel, n);
                    break;
                case 8:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 9:
                    z2 = C0324a.m571c(parcel, n);
                    break;
                case 10:
                    z3 = C0324a.m571c(parcel, n);
                    break;
                case 11:
                    f3 = C0324a.m578j(parcel, n);
                    break;
                case 12:
                    f4 = C0324a.m578j(parcel, n);
                    break;
                case 13:
                    f5 = C0324a.m578j(parcel, n);
                    break;
                case 14:
                    f6 = C0324a.m578j(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
