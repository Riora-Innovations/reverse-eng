package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3608a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
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

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = 0;
        int o = C0324a.m584o(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        int i = 0;
        byte b7 = 0;
        byte b8 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    b8 = C0324a.m573e(parcel, n);
                    break;
                case 3:
                    b7 = C0324a.m573e(parcel, n);
                    break;
                case 4:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C0324a.m564a(parcel, n, (Creator<T>) CameraPosition.CREATOR);
                    break;
                case 6:
                    b6 = C0324a.m573e(parcel, n);
                    break;
                case 7:
                    b5 = C0324a.m573e(parcel, n);
                    break;
                case 8:
                    b4 = C0324a.m573e(parcel, n);
                    break;
                case 9:
                    b3 = C0324a.m573e(parcel, n);
                    break;
                case 10:
                    b2 = C0324a.m573e(parcel, n);
                    break;
                case 11:
                    b = C0324a.m573e(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
