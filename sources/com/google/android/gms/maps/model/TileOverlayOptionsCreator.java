package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

public class TileOverlayOptionsCreator implements Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3712a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0326b.m605a(parcel, 2, tileOverlayOptions.mo7128hh(), false);
        C0326b.m612a(parcel, 3, tileOverlayOptions.isVisible());
        C0326b.m602a(parcel, 4, tileOverlayOptions.getZIndex());
        C0326b.m612a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0326b.m599D(parcel, p);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int o = C0324a.m584o(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
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
                    z = C0324a.m571c(parcel, n);
                    break;
                case 4:
                    f = C0324a.m578j(parcel, n);
                    break;
                case 5:
                    z2 = C0324a.m571c(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
