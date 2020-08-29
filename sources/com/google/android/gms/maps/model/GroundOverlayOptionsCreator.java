package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

public class GroundOverlayOptionsCreator implements Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3694a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
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

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    iBinder = C0324a.m583n(parcel, n);
                    break;
                case 3:
                    latLng = (LatLng) C0324a.m564a(parcel, n, (Creator<T>) LatLng.CREATOR);
                    break;
                case 4:
                    f = C0324a.m578j(parcel, n);
                    break;
                case 5:
                    f2 = C0324a.m578j(parcel, n);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0324a.m564a(parcel, n, (Creator<T>) LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C0324a.m578j(parcel, n);
                    break;
                case 8:
                    f4 = C0324a.m578j(parcel, n);
                    break;
                case 9:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 10:
                    f5 = C0324a.m578j(parcel, n);
                    break;
                case 11:
                    f6 = C0324a.m578j(parcel, n);
                    break;
                case 12:
                    f7 = C0324a.m578j(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
