package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.cd */
public final class C0625cd implements SafeParcelable {
    public static final C0627ce CREATOR = new C0627ce();
    public final String adUnitId;
    public final ApplicationInfo applicationInfo;

    /* renamed from: kN */
    public final C0663db f1646kN;

    /* renamed from: kQ */
    public final C0504ab f1647kQ;

    /* renamed from: ob */
    public final Bundle f1648ob;

    /* renamed from: oc */
    public final C1173z f1649oc;

    /* renamed from: od */
    public final PackageInfo f1650od;

    /* renamed from: oe */
    public final String f1651oe;

    /* renamed from: of */
    public final String f1652of;

    /* renamed from: og */
    public final String f1653og;

    /* renamed from: oh */
    public final Bundle f1654oh;
    public final int versionCode;

    /* renamed from: com.google.android.gms.internal.cd$a */
    public static final class C0626a {
        public final String adUnitId;
        public final ApplicationInfo applicationInfo;

        /* renamed from: kN */
        public final C0663db f1655kN;

        /* renamed from: kQ */
        public final C0504ab f1656kQ;

        /* renamed from: ob */
        public final Bundle f1657ob;

        /* renamed from: oc */
        public final C1173z f1658oc;

        /* renamed from: od */
        public final PackageInfo f1659od;

        /* renamed from: of */
        public final String f1660of;

        /* renamed from: og */
        public final String f1661og;

        /* renamed from: oh */
        public final Bundle f1662oh;

        public C0626a(Bundle bundle, C1173z zVar, C0504ab abVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, C0663db dbVar, Bundle bundle2) {
            this.f1657ob = bundle;
            this.f1658oc = zVar;
            this.f1656kQ = abVar;
            this.adUnitId = str;
            this.applicationInfo = applicationInfo2;
            this.f1659od = packageInfo;
            this.f1660of = str2;
            this.f1661og = str3;
            this.f1655kN = dbVar;
            this.f1662oh = bundle2;
        }
    }

    C0625cd(int i, Bundle bundle, C1173z zVar, C0504ab abVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, C0663db dbVar, Bundle bundle2) {
        this.versionCode = i;
        this.f1648ob = bundle;
        this.f1649oc = zVar;
        this.f1647kQ = abVar;
        this.adUnitId = str;
        this.applicationInfo = applicationInfo2;
        this.f1650od = packageInfo;
        this.f1651oe = str2;
        this.f1652of = str3;
        this.f1653og = str4;
        this.f1646kN = dbVar;
        this.f1654oh = bundle2;
    }

    public C0625cd(Bundle bundle, C1173z zVar, C0504ab abVar, String str, ApplicationInfo applicationInfo2, PackageInfo packageInfo, String str2, String str3, String str4, C0663db dbVar, Bundle bundle2) {
        this(2, bundle, zVar, abVar, str, applicationInfo2, packageInfo, str2, str3, str4, dbVar, bundle2);
    }

    public C0625cd(C0626a aVar, String str) {
        this(aVar.f1657ob, aVar.f1658oc, aVar.f1656kQ, aVar.adUnitId, aVar.applicationInfo, aVar.f1659od, str, aVar.f1660of, aVar.f1661og, aVar.f1655kN, aVar.f1662oh);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0627ce.m1426a(this, out, flags);
    }
}
