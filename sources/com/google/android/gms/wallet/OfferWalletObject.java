package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR = new C1559n();

    /* renamed from: Zm */
    String f4019Zm;

    /* renamed from: eN */
    String f4020eN;

    /* renamed from: wj */
    private final int f4021wj;

    OfferWalletObject() {
        this.f4021wj = 2;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode) {
        this.f4021wj = versionCode;
        this.f4020eN = id;
        this.f4019Zm = redemptionCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f4020eN;
    }

    public String getRedemptionCode() {
        return this.f4019Zm;
    }

    public int getVersionCode() {
        return this.f4021wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1559n.m4594a(this, dest, flags);
    }
}
