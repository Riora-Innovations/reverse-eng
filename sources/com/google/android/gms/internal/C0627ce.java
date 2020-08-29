package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.ce */
public class C0627ce implements Creator<C0625cd> {
    /* renamed from: a */
    static void m1426a(C0625cd cdVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, cdVar.versionCode);
        C0326b.m604a(parcel, 2, cdVar.f1648ob, false);
        C0326b.m607a(parcel, 3, (Parcelable) cdVar.f1649oc, i, false);
        C0326b.m607a(parcel, 4, (Parcelable) cdVar.f1647kQ, i, false);
        C0326b.m609a(parcel, 5, cdVar.adUnitId, false);
        C0326b.m607a(parcel, 6, (Parcelable) cdVar.applicationInfo, i, false);
        C0326b.m607a(parcel, 7, (Parcelable) cdVar.f1650od, i, false);
        C0326b.m609a(parcel, 8, cdVar.f1651oe, false);
        C0326b.m609a(parcel, 9, cdVar.f1652of, false);
        C0326b.m609a(parcel, 10, cdVar.f1653og, false);
        C0326b.m607a(parcel, 11, (Parcelable) cdVar.f1646kN, i, false);
        C0326b.m604a(parcel, 12, cdVar.f1654oh, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: f */
    public C0625cd createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        Bundle bundle = null;
        C1173z zVar = null;
        C0504ab abVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        C0663db dbVar = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    bundle = C0324a.m585o(parcel, n);
                    break;
                case 3:
                    zVar = (C1173z) C0324a.m564a(parcel, n, (Creator<T>) C1173z.CREATOR);
                    break;
                case 4:
                    abVar = (C0504ab) C0324a.m564a(parcel, n, (Creator<T>) C0504ab.CREATOR);
                    break;
                case 5:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C0324a.m564a(parcel, n, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C0324a.m564a(parcel, n, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 9:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 10:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 11:
                    dbVar = (C0663db) C0324a.m564a(parcel, n, (Creator<T>) C0663db.CREATOR);
                    break;
                case 12:
                    bundle2 = C0324a.m585o(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0625cd(i, bundle, zVar, abVar, str, applicationInfo, packageInfo, str2, str3, str4, dbVar, bundle2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: k */
    public C0625cd[] newArray(int i) {
        return new C0625cd[i];
    }
}
