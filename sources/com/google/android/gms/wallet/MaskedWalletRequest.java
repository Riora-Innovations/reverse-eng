package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new C1557l();

    /* renamed from: YY */
    boolean f3999YY;

    /* renamed from: YZ */
    boolean f4000YZ;

    /* renamed from: Yg */
    String f4001Yg;

    /* renamed from: Yl */
    String f4002Yl;

    /* renamed from: Yu */
    Cart f4003Yu;

    /* renamed from: Za */
    boolean f4004Za;

    /* renamed from: Zb */
    String f4005Zb;

    /* renamed from: Zc */
    String f4006Zc;

    /* renamed from: Zd */
    boolean f4007Zd;

    /* renamed from: Ze */
    boolean f4008Ze;

    /* renamed from: Zf */
    CountrySpecification[] f4009Zf;

    /* renamed from: Zg */
    boolean f4010Zg;

    /* renamed from: Zh */
    boolean f4011Zh;

    /* renamed from: Zi */
    ArrayList<CountrySpecification> f4012Zi;

    /* renamed from: wj */
    private final int f4013wj;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.f4012Zi == null) {
                MaskedWalletRequest.this.f4012Zi = new ArrayList<>();
            }
            MaskedWalletRequest.this.f4012Zi.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (MaskedWalletRequest.this.f4012Zi == null) {
                    MaskedWalletRequest.this.f4012Zi = new ArrayList<>();
                }
                MaskedWalletRequest.this.f4012Zi.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            MaskedWalletRequest.this.f4011Zh = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            MaskedWalletRequest.this.f4010Zg = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.f4003Yu = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            MaskedWalletRequest.this.f4001Yg = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            MaskedWalletRequest.this.f4005Zb = estimatedTotalPrice;
            return this;
        }

        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            MaskedWalletRequest.this.f4008Ze = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            MaskedWalletRequest.this.f4006Zc = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            MaskedWalletRequest.this.f4002Yl = merchantTransactionId;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            MaskedWalletRequest.this.f3999YY = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            MaskedWalletRequest.this.f4000YZ = shippingAddressRequired;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean shouldRetrieveWalletObjects) {
            MaskedWalletRequest.this.f4007Zd = shouldRetrieveWalletObjects;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            MaskedWalletRequest.this.f4004Za = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.f4013wj = 3;
        this.f4010Zg = true;
        this.f4011Zh = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping) {
        this.f4013wj = versionCode;
        this.f4002Yl = merchantTransactionId;
        this.f3999YY = phoneNumberRequired;
        this.f4000YZ = shippingAddressRequired;
        this.f4004Za = useMinimalBillingAddress;
        this.f4005Zb = estimatedTotalPrice;
        this.f4001Yg = currencyCode;
        this.f4006Zc = merchantName;
        this.f4003Yu = cart;
        this.f4007Zd = shouldRetrieveWalletObjects;
        this.f4008Ze = isBillingAgreement;
        this.f4009Zf = allowedShippingCountrySpecifications;
        this.f4010Zg = allowPrepaidCard;
        this.f4011Zh = allowDebitCard;
        this.f4012Zi = allowedCountrySpecificationsForShipping;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.f4011Zh;
    }

    public boolean allowPrepaidCard() {
        return this.f4010Zg;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.f4012Zi;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.f4009Zf;
    }

    public Cart getCart() {
        return this.f4003Yu;
    }

    public String getCurrencyCode() {
        return this.f4001Yg;
    }

    public String getEstimatedTotalPrice() {
        return this.f4005Zb;
    }

    public String getMerchantName() {
        return this.f4006Zc;
    }

    public String getMerchantTransactionId() {
        return this.f4002Yl;
    }

    public int getVersionCode() {
        return this.f4013wj;
    }

    public boolean isBillingAgreement() {
        return this.f4008Ze;
    }

    public boolean isPhoneNumberRequired() {
        return this.f3999YY;
    }

    public boolean isShippingAddressRequired() {
        return this.f4000YZ;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.f4007Zd;
    }

    public boolean useMinimalBillingAddress() {
        return this.f4004Za;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1557l.m4588a(this, dest, flags);
    }
}
