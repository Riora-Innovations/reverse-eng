package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new C1554i();

    /* renamed from: YA */
    int f3958YA;

    /* renamed from: Yf */
    String f3959Yf;

    /* renamed from: Yg */
    String f3960Yg;

    /* renamed from: Yy */
    String f3961Yy;

    /* renamed from: Yz */
    String f3962Yz;
    String description;

    /* renamed from: wj */
    private final int f3963wj;

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            LineItem.this.f3960Yg = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            LineItem.this.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            LineItem.this.f3961Yy = quantity;
            return this;
        }

        public Builder setRole(int role) {
            LineItem.this.f3958YA = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            LineItem.this.f3959Yf = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            LineItem.this.f3962Yz = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.f3963wj = 1;
        this.f3958YA = 0;
    }

    LineItem(int versionCode, String description2, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.f3963wj = versionCode;
        this.description = description2;
        this.f3961Yy = quantity;
        this.f3962Yz = unitPrice;
        this.f3959Yf = totalPrice;
        this.f3958YA = role;
        this.f3960Yg = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.f3960Yg;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.f3961Yy;
    }

    public int getRole() {
        return this.f3958YA;
    }

    public String getTotalPrice() {
        return this.f3959Yf;
    }

    public String getUnitPrice() {
        return this.f3962Yz;
    }

    public int getVersionCode() {
        return this.f3963wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1554i.m4579a(this, dest, flags);
    }
}
