package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequest;

/* renamed from: com.google.android.gms.internal.hr */
public final class C1033hr implements SafeParcelable {
    public static final C1034hs CREATOR = new C1034hs();

    /* renamed from: LF */
    private final LocationRequest f2692LF;

    /* renamed from: LG */
    private final C1029hn f2693LG;

    /* renamed from: wj */
    final int f2694wj;

    public C1033hr(int i, LocationRequest locationRequest, C1029hn hnVar) {
        this.f2694wj = i;
        this.f2692LF = locationRequest;
        this.f2693LG = hnVar;
    }

    public int describeContents() {
        C1034hs hsVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1033hr)) {
            return false;
        }
        C1033hr hrVar = (C1033hr) object;
        return this.f2692LF.equals(hrVar.f2692LF) && this.f2693LG.equals(hrVar.f2693LG);
    }

    /* renamed from: gu */
    public LocationRequest mo5763gu() {
        return this.f2692LF;
    }

    /* renamed from: gv */
    public C1029hn mo5764gv() {
        return this.f2693LG;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f2692LF, this.f2693LG);
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("locationRequest", this.f2692LF).mo5118a("filter", this.f2693LG).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1034hs hsVar = CREATOR;
        C1034hs.m3045a(this, parcel, flags);
    }
}
