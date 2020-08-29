package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR = new C1556k();

    /* renamed from: YW */
    LoyaltyWalletObject[] f3987YW;

    /* renamed from: YX */
    OfferWalletObject[] f3988YX;

    /* renamed from: Yk */
    String f3989Yk;

    /* renamed from: Yl */
    String f3990Yl;

    /* renamed from: Yn */
    String f3991Yn;

    /* renamed from: Yo */
    Address f3992Yo;

    /* renamed from: Yp */
    Address f3993Yp;

    /* renamed from: Yq */
    String[] f3994Yq;

    /* renamed from: Yr */
    UserAddress f3995Yr;

    /* renamed from: Ys */
    UserAddress f3996Ys;

    /* renamed from: Yt */
    InstrumentInfo[] f3997Yt;

    /* renamed from: wj */
    private final int f3998wj;

    private MaskedWallet() {
        this.f3998wj = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.f3998wj = versionCode;
        this.f3989Yk = googleTransactionId;
        this.f3990Yl = merchantTransactionId;
        this.f3994Yq = paymentDescriptions;
        this.f3991Yn = email;
        this.f3992Yo = billingAddress;
        this.f3993Yp = shippingAddress;
        this.f3987YW = loyaltyWalletObjects;
        this.f3988YX = offerWalletObjects;
        this.f3995Yr = buyerBillingAddress;
        this.f3996Ys = buyerShippingAddress;
        this.f3997Yt = instrumentInfos;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.f3992Yo;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.f3995Yr;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.f3996Ys;
    }

    public String getEmail() {
        return this.f3991Yn;
    }

    public String getGoogleTransactionId() {
        return this.f3989Yk;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.f3997Yt;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.f3987YW;
    }

    public String getMerchantTransactionId() {
        return this.f3990Yl;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.f3988YX;
    }

    public String[] getPaymentDescriptions() {
        return this.f3994Yq;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.f3993Yp;
    }

    public int getVersionCode() {
        return this.f3998wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1556k.m4585a(this, dest, flags);
    }
}
