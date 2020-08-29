package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

public class CameraPositionCreator implements Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3690a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, cameraPosition.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) cameraPosition.target, i, false);
        C0326b.m602a(parcel, 3, cameraPosition.zoom);
        C0326b.m602a(parcel, 4, cameraPosition.tilt);
        C0326b.m602a(parcel, 5, cameraPosition.bearing);
        C0326b.m599D(parcel, p);
    }

    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int o = C0324a.m584o(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
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
                    f3 = C0324a.m578j(parcel, n);
                    break;
                case 4:
                    f2 = C0324a.m578j(parcel, n);
                    break;
                case 5:
                    f = C0324a.m578j(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public CameraPosition[] newArray(int size) {
        return new CameraPosition[size];
    }
}
