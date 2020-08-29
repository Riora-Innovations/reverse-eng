package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.jp */
public final class C1130jp implements SafeParcelable {
    public static final Creator<C1130jp> CREATOR = new C1131jq();

    /* renamed from: ZK */
    String f3095ZK;

    /* renamed from: oi */
    String f3096oi;

    /* renamed from: wj */
    private final int f3097wj;

    C1130jp() {
        this.f3097wj = 1;
    }

    C1130jp(int i, String str, String str2) {
        this.f3097wj = i;
        this.f3095ZK = str;
        this.f3096oi = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f3097wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1131jq.m3368a(this, dest, flags);
    }
}
