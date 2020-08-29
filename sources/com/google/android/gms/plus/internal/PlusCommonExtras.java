package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0762ep;

public class PlusCommonExtras implements SafeParcelable {
    public static final C1338f CREATOR = new C1338f();
    public static String TAG = "PlusCommonExtras";

    /* renamed from: Rj */
    private String f3420Rj;

    /* renamed from: Rk */
    private String f3421Rk;

    /* renamed from: wj */
    private final int f3422wj;

    public PlusCommonExtras() {
        this.f3422wj = 1;
        this.f3420Rj = "";
        this.f3421Rk = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.f3422wj = versionCode;
        this.f3420Rj = gpsrc;
        this.f3421Rk = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.f3422wj == plusCommonExtras.f3422wj && C0762ep.equal(this.f3420Rj, plusCommonExtras.f3420Rj) && C0762ep.equal(this.f3421Rk, plusCommonExtras.f3421Rk);
    }

    public int getVersionCode() {
        return this.f3422wj;
    }

    public int hashCode() {
        return C0762ep.hashCode(Integer.valueOf(this.f3422wj), this.f3420Rj, this.f3421Rk);
    }

    /* renamed from: ho */
    public String mo7350ho() {
        return this.f3420Rj;
    }

    /* renamed from: hp */
    public String mo7351hp() {
        return this.f3421Rk;
    }

    /* renamed from: m */
    public void mo7352m(Bundle bundle) {
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("versionCode", Integer.valueOf(this.f3422wj)).mo5118a("Gpsrc", this.f3420Rj).mo5118a("ClientCallingPackage", this.f3421Rk).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1338f.m3906a(this, out, flags);
    }
}
