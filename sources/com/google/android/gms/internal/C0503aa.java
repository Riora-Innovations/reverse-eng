package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.aa */
public class C0503aa implements Creator<C1173z> {
    /* renamed from: a */
    static void m1148a(C1173z zVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, zVar.versionCode);
        C0326b.m603a(parcel, 2, zVar.f3158le);
        C0326b.m604a(parcel, 3, zVar.extras, false);
        C0326b.m619c(parcel, 4, zVar.f3159lf);
        C0326b.m610a(parcel, 5, zVar.f3160lg, false);
        C0326b.m612a(parcel, 6, zVar.f3161lh);
        C0326b.m619c(parcel, 7, zVar.tagForChildDirectedTreatment);
        C0326b.m612a(parcel, 8, zVar.f3162li);
        C0326b.m609a(parcel, 9, zVar.f3163lj, false);
        C0326b.m607a(parcel, 10, (Parcelable) zVar.f3164lk, i, false);
        C0326b.m607a(parcel, 11, (Parcelable) zVar.f3165ll, i, false);
        C0326b.m609a(parcel, 12, zVar.f3166lm, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: a */
    public C1173z createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        ArrayList arrayList = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        C0524am amVar = null;
        Location location = null;
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 3:
                    bundle = C0324a.m585o(parcel, n);
                    break;
                case 4:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    arrayList = C0324a.m595y(parcel, n);
                    break;
                case 6:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 7:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 8:
                    z2 = C0324a.m571c(parcel, n);
                    break;
                case 9:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 10:
                    amVar = (C0524am) C0324a.m564a(parcel, n, (Creator<T>) C0524am.CREATOR);
                    break;
                case 11:
                    location = (Location) C0324a.m564a(parcel, n, Location.CREATOR);
                    break;
                case 12:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1173z(i, j, bundle, i2, arrayList, z, i3, z2, str, amVar, location, str2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: b */
    public C1173z[] newArray(int i) {
        return new C1173z[i];
    }
}
