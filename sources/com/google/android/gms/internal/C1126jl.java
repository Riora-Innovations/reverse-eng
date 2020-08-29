package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.jl */
public final class C1126jl implements SafeParcelable {
    public static final Creator<C1126jl> CREATOR = new C1129jo();

    /* renamed from: YM */
    C1132jr f3085YM;

    /* renamed from: ZD */
    C1127jm f3086ZD;
    String label;
    String type;

    /* renamed from: wj */
    private final int f3087wj;

    C1126jl() {
        this.f3087wj = 1;
    }

    C1126jl(int i, String str, C1127jm jmVar, String str2, C1132jr jrVar) {
        this.f3087wj = i;
        this.label = str;
        this.f3086ZD = jmVar;
        this.type = str2;
        this.f3085YM = jrVar;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f3087wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1129jo.m3365a(this, dest, flags);
    }
}
