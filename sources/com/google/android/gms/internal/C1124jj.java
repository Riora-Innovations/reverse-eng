package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.jj */
public final class C1124jj implements SafeParcelable {
    public static final Creator<C1124jj> CREATOR = new C1125jk();

    /* renamed from: ZA */
    String f3081ZA;

    /* renamed from: ZB */
    String f3082ZB;

    /* renamed from: ZC */
    ArrayList<C1122jh> f3083ZC;

    /* renamed from: wj */
    private final int f3084wj;

    C1124jj() {
        this.f3084wj = 1;
        this.f3083ZC = C0804fj.m2111eH();
    }

    C1124jj(int i, String str, String str2, ArrayList<C1122jh> arrayList) {
        this.f3084wj = i;
        this.f3081ZA = str;
        this.f3082ZB = str2;
        this.f3083ZC = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f3084wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1125jk.m3359a(this, dest, flags);
    }
}
