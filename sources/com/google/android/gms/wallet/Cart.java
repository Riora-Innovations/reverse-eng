package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new C1547b();

    /* renamed from: Yf */
    String f3932Yf;

    /* renamed from: Yg */
    String f3933Yg;

    /* renamed from: Yh */
    ArrayList<LineItem> f3934Yh;

    /* renamed from: wj */
    private final int f3935wj;

    public final class Builder {
        private Builder() {
        }

        public Builder addLineItem(LineItem lineItem) {
            Cart.this.f3934Yh.add(lineItem);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            Cart.this.f3933Yg = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            Cart.this.f3934Yh.clear();
            Cart.this.f3934Yh.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            Cart.this.f3932Yf = totalPrice;
            return this;
        }
    }

    Cart() {
        this.f3935wj = 1;
        this.f3934Yh = new ArrayList<>();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.f3935wj = versionCode;
        this.f3932Yf = totalPrice;
        this.f3933Yg = currencyCode;
        this.f3934Yh = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.f3933Yg;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.f3934Yh;
    }

    public String getTotalPrice() {
        return this.f3932Yf;
    }

    public int getVersionCode() {
        return this.f3935wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1547b.m4561a(this, dest, flags);
    }
}
