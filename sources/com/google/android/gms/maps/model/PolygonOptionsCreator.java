package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3707a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, polygonOptions.getVersionCode());
        C0326b.m618b(parcel, 2, polygonOptions.getPoints(), false);
        C0326b.m620c(parcel, 3, polygonOptions.mo7061hg(), false);
        C0326b.m602a(parcel, 4, polygonOptions.getStrokeWidth());
        C0326b.m619c(parcel, 5, polygonOptions.getStrokeColor());
        C0326b.m619c(parcel, 6, polygonOptions.getFillColor());
        C0326b.m602a(parcel, 7, polygonOptions.getZIndex());
        C0326b.m612a(parcel, 8, polygonOptions.isVisible());
        C0326b.m612a(parcel, 9, polygonOptions.isGeodesic());
        C0326b.m599D(parcel, p);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int o = C0324a.m584o(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    arrayList = C0324a.m570c(parcel, n, LatLng.CREATOR);
                    break;
                case 3:
                    C0324a.m567a(parcel, n, (List) arrayList2, getClass().getClassLoader());
                    break;
                case 4:
                    f2 = C0324a.m578j(parcel, n);
                    break;
                case 5:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 6:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 7:
                    f = C0324a.m578j(parcel, n);
                    break;
                case 8:
                    z2 = C0324a.m571c(parcel, n);
                    break;
                case 9:
                    z = C0324a.m571c(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new PolygonOptions(i3, arrayList, arrayList2, f2, i2, i, f, z2, z);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
