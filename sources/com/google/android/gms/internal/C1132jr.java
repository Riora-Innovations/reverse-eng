package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.jr */
public final class C1132jr implements SafeParcelable {
    public static final Creator<C1132jr> CREATOR = new C1133js();

    /* renamed from: ZL */
    long f3098ZL;

    /* renamed from: ZM */
    long f3099ZM;

    /* renamed from: wj */
    private final int f3100wj;

    C1132jr() {
        this.f3100wj = 1;
    }

    C1132jr(int i, long j, long j2) {
        this.f3100wj = i;
        this.f3098ZL = j;
        this.f3099ZM = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f3100wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1133js.m3371a(this, dest, flags);
    }
}
