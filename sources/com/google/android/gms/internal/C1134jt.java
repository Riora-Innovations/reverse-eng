package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.jt */
public final class C1134jt implements SafeParcelable {
    public static final Creator<C1134jt> CREATOR = new C1135ju();

    /* renamed from: ZN */
    String f3101ZN;
    String description;

    /* renamed from: wj */
    private final int f3102wj;

    C1134jt() {
        this.f3102wj = 1;
    }

    C1134jt(int i, String str, String str2) {
        this.f3102wj = i;
        this.f3101ZN = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f3102wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1135ju.m3374a(this, dest, flags);
    }
}
