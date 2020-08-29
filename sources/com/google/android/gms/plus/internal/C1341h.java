package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0762ep;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.h */
public class C1341h implements SafeParcelable {
    public static final C1343j CREATOR = new C1343j();

    /* renamed from: Rm */
    private final String[] f3451Rm;

    /* renamed from: Rn */
    private final String[] f3452Rn;

    /* renamed from: Ro */
    private final String[] f3453Ro;

    /* renamed from: Rp */
    private final String f3454Rp;

    /* renamed from: Rq */
    private final String f3455Rq;

    /* renamed from: Rr */
    private final String f3456Rr;

    /* renamed from: Rs */
    private final String f3457Rs;

    /* renamed from: Rt */
    private final PlusCommonExtras f3458Rt;

    /* renamed from: vi */
    private final String f3459vi;

    /* renamed from: wj */
    private final int f3460wj;

    C1341h(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, String str5, PlusCommonExtras plusCommonExtras) {
        this.f3460wj = i;
        this.f3459vi = str;
        this.f3451Rm = strArr;
        this.f3452Rn = strArr2;
        this.f3453Ro = strArr3;
        this.f3454Rp = str2;
        this.f3455Rq = str3;
        this.f3456Rr = str4;
        this.f3457Rs = str5;
        this.f3458Rt = plusCommonExtras;
    }

    public C1341h(String str, String[] strArr, String[] strArr2, String[] strArr3, String str2, String str3, String str4, PlusCommonExtras plusCommonExtras) {
        this.f3460wj = 1;
        this.f3459vi = str;
        this.f3451Rm = strArr;
        this.f3452Rn = strArr2;
        this.f3453Ro = strArr3;
        this.f3454Rp = str2;
        this.f3455Rq = str3;
        this.f3456Rr = str4;
        this.f3457Rs = null;
        this.f3458Rt = plusCommonExtras;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1341h)) {
            return false;
        }
        C1341h hVar = (C1341h) obj;
        return this.f3460wj == hVar.f3460wj && C0762ep.equal(this.f3459vi, hVar.f3459vi) && Arrays.equals(this.f3451Rm, hVar.f3451Rm) && Arrays.equals(this.f3452Rn, hVar.f3452Rn) && Arrays.equals(this.f3453Ro, hVar.f3453Ro) && C0762ep.equal(this.f3454Rp, hVar.f3454Rp) && C0762ep.equal(this.f3455Rq, hVar.f3455Rq) && C0762ep.equal(this.f3456Rr, hVar.f3456Rr) && C0762ep.equal(this.f3457Rs, hVar.f3457Rs) && C0762ep.equal(this.f3458Rt, hVar.f3458Rt);
    }

    public String getAccountName() {
        return this.f3459vi;
    }

    public int getVersionCode() {
        return this.f3460wj;
    }

    public int hashCode() {
        return C0762ep.hashCode(Integer.valueOf(this.f3460wj), this.f3459vi, this.f3451Rm, this.f3452Rn, this.f3453Ro, this.f3454Rp, this.f3455Rq, this.f3456Rr, this.f3457Rs, this.f3458Rt);
    }

    /* renamed from: hq */
    public String[] mo7422hq() {
        return this.f3451Rm;
    }

    /* renamed from: hr */
    public String[] mo7423hr() {
        return this.f3452Rn;
    }

    /* renamed from: hs */
    public String[] mo7424hs() {
        return this.f3453Ro;
    }

    /* renamed from: ht */
    public String mo7425ht() {
        return this.f3454Rp;
    }

    /* renamed from: hu */
    public String mo7426hu() {
        return this.f3455Rq;
    }

    /* renamed from: hv */
    public String mo7427hv() {
        return this.f3456Rr;
    }

    /* renamed from: hw */
    public String mo7428hw() {
        return this.f3457Rs;
    }

    /* renamed from: hx */
    public PlusCommonExtras mo7429hx() {
        return this.f3458Rt;
    }

    /* renamed from: hy */
    public Bundle mo7430hy() {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        this.f3458Rt.mo7352m(bundle);
        return bundle;
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("versionCode", Integer.valueOf(this.f3460wj)).mo5118a("accountName", this.f3459vi).mo5118a("requestedScopes", this.f3451Rm).mo5118a("visibleActivities", this.f3452Rn).mo5118a("requiredFeatures", this.f3453Ro).mo5118a("packageNameForAuth", this.f3454Rp).mo5118a("callingPackageName", this.f3455Rq).mo5118a("applicationName", this.f3456Rr).mo5118a("extra", this.f3458Rt.toString()).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1343j.m3925a(this, out, flags);
    }
}
