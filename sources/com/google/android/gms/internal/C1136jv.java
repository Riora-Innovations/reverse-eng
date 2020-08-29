package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.jv */
public final class C1136jv implements SafeParcelable {
    public static final Creator<C1136jv> CREATOR = new C1137jw();

    /* renamed from: ZK */
    String f3103ZK;

    /* renamed from: ZO */
    C1132jr f3104ZO;

    /* renamed from: ZP */
    C1134jt f3105ZP;

    /* renamed from: ZQ */
    C1134jt f3106ZQ;

    /* renamed from: oi */
    String f3107oi;

    /* renamed from: wj */
    private final int f3108wj;

    C1136jv() {
        this.f3108wj = 1;
    }

    C1136jv(int i, String str, String str2, C1132jr jrVar, C1134jt jtVar, C1134jt jtVar2) {
        this.f3108wj = i;
        this.f3103ZK = str;
        this.f3107oi = str2;
        this.f3104ZO = jrVar;
        this.f3105ZP = jtVar;
        this.f3106ZQ = jtVar2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f3108wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1137jw.m3377a(this, dest, flags);
    }
}
