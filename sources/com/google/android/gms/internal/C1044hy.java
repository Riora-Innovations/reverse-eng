package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.hy */
public class C1044hy implements Creator<C1041hx> {
    /* renamed from: a */
    static void m3076a(C1041hx hxVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, hxVar.getId(), false);
        C0326b.m604a(parcel, 2, hxVar.mo5795gE(), false);
        C0326b.m607a(parcel, 3, (Parcelable) hxVar.mo5796gF(), i, false);
        C0326b.m607a(parcel, 4, (Parcelable) hxVar.mo5801gx(), i, false);
        C0326b.m602a(parcel, 5, hxVar.mo5802gy());
        C0326b.m607a(parcel, 6, (Parcelable) hxVar.mo5803gz(), i, false);
        C0326b.m609a(parcel, 7, hxVar.mo5797gG(), false);
        C0326b.m607a(parcel, 8, (Parcelable) hxVar.mo5791gA(), i, false);
        C0326b.m612a(parcel, 9, hxVar.mo5792gB());
        C0326b.m602a(parcel, 10, hxVar.getRating());
        C0326b.m619c(parcel, 11, hxVar.mo5793gC());
        C0326b.m603a(parcel, 12, hxVar.mo5794gD());
        C0326b.m618b(parcel, 13, hxVar.mo5800gw(), false);
        C0326b.m619c(parcel, 1000, hxVar.f2840wj);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aB */
    public C1041hx createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        ArrayList arrayList = null;
        Bundle bundle = null;
        C1045hz hzVar = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str2 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 2:
                    bundle = C0324a.m585o(parcel, n);
                    break;
                case 3:
                    hzVar = (C1045hz) C0324a.m564a(parcel, n, (Creator<T>) C1045hz.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) C0324a.m564a(parcel, n, (Creator<T>) LatLng.CREATOR);
                    break;
                case 5:
                    f = C0324a.m578j(parcel, n);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0324a.m564a(parcel, n, (Creator<T>) LatLngBounds.CREATOR);
                    break;
                case 7:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 8:
                    uri = (Uri) C0324a.m564a(parcel, n, Uri.CREATOR);
                    break;
                case 9:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 10:
                    f2 = C0324a.m578j(parcel, n);
                    break;
                case 11:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 12:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 13:
                    arrayList = C0324a.m570c(parcel, n, C1035ht.CREATOR);
                    break;
                case 1000:
                    i = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1041hx(i, str, arrayList, bundle, hzVar, latLng, f, latLngBounds, str2, uri, z, f2, i2, j);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bw */
    public C1041hx[] newArray(int i) {
        return new C1041hx[i];
    }
}
