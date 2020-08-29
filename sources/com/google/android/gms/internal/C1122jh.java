package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.jh */
public final class C1122jh implements SafeParcelable {
    public static final Creator<C1122jh> CREATOR = new C1123ji();
    String label;
    String value;

    /* renamed from: wj */
    private final int f3080wj;

    C1122jh() {
        this.f3080wj = 1;
    }

    C1122jh(int i, String str, String str2) {
        this.f3080wj = i;
        this.label = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f3080wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1123ji.m3356a(this, dest, flags);
    }
}
