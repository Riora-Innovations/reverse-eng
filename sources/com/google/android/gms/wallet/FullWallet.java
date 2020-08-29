package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet implements SafeParcelable {
    public static final Creator<FullWallet> CREATOR = new C1551f();

    /* renamed from: Yk */
    String f3939Yk;

    /* renamed from: Yl */
    String f3940Yl;

    /* renamed from: Ym */
    ProxyCard f3941Ym;

    /* renamed from: Yn */
    String f3942Yn;

    /* renamed from: Yo */
    Address f3943Yo;

    /* renamed from: Yp */
    Address f3944Yp;

    /* renamed from: Yq */
    String[] f3945Yq;

    /* renamed from: Yr */
    UserAddress f3946Yr;

    /* renamed from: Ys */
    UserAddress f3947Ys;

    /* renamed from: Yt */
    InstrumentInfo[] f3948Yt;

    /* renamed from: wj */
    private final int f3949wj;

    private FullWallet() {
        this.f3949wj = 1;
    }

    FullWallet(int versionCode, String googleTransactionId, String merchantTransactionId, ProxyCard proxyCard, String email, Address billingAddress, Address shippingAddress, String[] paymentDescriptions, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.f3949wj = versionCode;
        this.f3939Yk = googleTransactionId;
        this.f3940Yl = merchantTransactionId;
        this.f3941Ym = proxyCard;
        this.f3942Yn = email;
        this.f3943Yo = billingAddress;
        this.f3944Yp = shippingAddress;
        this.f3945Yq = paymentDescriptions;
        this.f3946Yr = buyerBillingAddress;
        this.f3947Ys = buyerShippingAddress;
        this.f3948Yt = instrumentInfos;
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.f3943Yo;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.f3946Yr;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.f3947Ys;
    }

    public String getEmail() {
        return this.f3942Yn;
    }

    public String getGoogleTransactionId() {
        return this.f3939Yk;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.f3948Yt;
    }

    public String getMerchantTransactionId() {
        return this.f3940Yl;
    }

    public String[] getPaymentDescriptions() {
        return this.f3945Yq;
    }

    public ProxyCard getProxyCard() {
        return this.f3941Ym;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.f3944Yp;
    }

    public int getVersionCode() {
        return this.f3949wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1551f.m4570a(this, out, flags);
    }
}
