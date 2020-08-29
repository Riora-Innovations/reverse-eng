package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.cast.b */
public class C0291b implements Creator<CastDevice> {
    /* renamed from: a */
    static void m412a(CastDevice castDevice, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, castDevice.getVersionCode());
        C0326b.m609a(parcel, 2, castDevice.getDeviceId(), false);
        C0326b.m609a(parcel, 3, castDevice.f405wD, false);
        C0326b.m609a(parcel, 4, castDevice.getFriendlyName(), false);
        C0326b.m609a(parcel, 5, castDevice.getModelName(), false);
        C0326b.m609a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0326b.m619c(parcel, 7, castDevice.getServicePort());
        C0326b.m618b(parcel, 8, castDevice.getIcons(), false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: k */
    public CastDevice createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int o = C0324a.m584o(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str5 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 8:
                    arrayList = C0324a.m570c(parcel, n, WebImage.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CastDevice(i2, str5, str4, str3, str2, str, i, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: y */
    public CastDevice[] newArray(int i) {
        return new CastDevice[i];
    }
}
