package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.hp */
public class C1031hp implements SafeParcelable {
    public static final C1032hq CREATOR = new C1032hq();

    /* renamed from: LE */
    private final String f2690LE;
    private final String mTag;

    /* renamed from: wj */
    final int f2691wj;

    C1031hp(int i, String str, String str2) {
        this.f2691wj = i;
        this.f2690LE = str;
        this.mTag = str2;
    }

    public int describeContents() {
        C1032hq hqVar = CREATOR;
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof C1031hp)) {
            return false;
        }
        C1031hp hpVar = (C1031hp) that;
        return C0762ep.equal(this.f2690LE, hpVar.f2690LE) && C0762ep.equal(this.mTag, hpVar.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    /* renamed from: gt */
    public String mo5753gt() {
        return this.f2690LE;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f2690LE, this.mTag);
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("mPlaceId", this.f2690LE).mo5118a("mTag", this.mTag).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C1032hq hqVar = CREATOR;
        C1032hq.m3040a(this, out, flags);
    }
}
