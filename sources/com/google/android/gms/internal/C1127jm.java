package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.jm */
public final class C1127jm implements SafeParcelable {
    public static final Creator<C1127jm> CREATOR = new C1128jn();

    /* renamed from: ZE */
    int f3088ZE;

    /* renamed from: ZF */
    String f3089ZF;

    /* renamed from: ZG */
    double f3090ZG;

    /* renamed from: ZH */
    String f3091ZH;

    /* renamed from: ZI */
    long f3092ZI;

    /* renamed from: ZJ */
    int f3093ZJ;

    /* renamed from: wj */
    private final int f3094wj;

    C1127jm() {
        this.f3094wj = 1;
        this.f3093ZJ = -1;
        this.f3088ZE = -1;
        this.f3090ZG = -1.0d;
    }

    C1127jm(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.f3094wj = i;
        this.f3088ZE = i2;
        this.f3089ZF = str;
        this.f3090ZG = d;
        this.f3091ZH = str2;
        this.f3092ZI = j;
        this.f3093ZJ = i3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f3094wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1128jn.m3362a(this, dest, flags);
    }
}
