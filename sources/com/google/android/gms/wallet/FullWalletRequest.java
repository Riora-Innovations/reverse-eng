package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR = new C1552g();

    /* renamed from: Yk */
    String f3950Yk;

    /* renamed from: Yl */
    String f3951Yl;

    /* renamed from: Yu */
    Cart f3952Yu;

    /* renamed from: wj */
    private final int f3953wj;

    public final class Builder {
        private Builder() {
        }

        public FullWalletRequest build() {
            return FullWalletRequest.this;
        }

        public Builder setCart(Cart cart) {
            FullWalletRequest.this.f3952Yu = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            FullWalletRequest.this.f3950Yk = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            FullWalletRequest.this.f3951Yl = merchantTransactionId;
            return this;
        }
    }

    FullWalletRequest() {
        this.f3953wj = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.f3953wj = versionCode;
        this.f3950Yk = googleTransactionId;
        this.f3951Yl = merchantTransactionId;
        this.f3952Yu = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.f3952Yu;
    }

    public String getGoogleTransactionId() {
        return this.f3950Yk;
    }

    public String getMerchantTransactionId() {
        return this.f3951Yl;
    }

    public int getVersionCode() {
        return this.f3953wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1552g.m4573a(this, dest, flags);
    }
}
