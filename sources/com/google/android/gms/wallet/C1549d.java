package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.wallet.d */
public final class C1549d implements SafeParcelable {
    public static final Creator<C1549d> CREATOR = new C1550e();

    /* renamed from: Yj */
    LoyaltyWalletObject f4040Yj;

    /* renamed from: wj */
    private final int f4041wj;

    C1549d() {
        this.f4041wj = 1;
    }

    C1549d(int i, LoyaltyWalletObject loyaltyWalletObject) {
        this.f4041wj = i;
        this.f4040Yj = loyaltyWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f4041wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1550e.m4567a(this, dest, flags);
    }
}
