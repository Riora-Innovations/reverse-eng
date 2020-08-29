package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest implements SafeParcelable {
    public static final Creator<UserAddressRequest> CREATOR = new C0499a();

    /* renamed from: Ky */
    List<CountrySpecification> f1095Ky;

    /* renamed from: wj */
    private final int f1096wj;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCountrySpecification(CountrySpecification countrySpecification) {
            if (UserAddressRequest.this.f1095Ky == null) {
                UserAddressRequest.this.f1095Ky = new ArrayList();
            }
            UserAddressRequest.this.f1095Ky.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> countrySpecifications) {
            if (UserAddressRequest.this.f1095Ky == null) {
                UserAddressRequest.this.f1095Ky = new ArrayList();
            }
            UserAddressRequest.this.f1095Ky.addAll(countrySpecifications);
            return this;
        }

        public UserAddressRequest build() {
            if (UserAddressRequest.this.f1095Ky != null) {
                UserAddressRequest.this.f1095Ky = Collections.unmodifiableList(UserAddressRequest.this.f1095Ky);
            }
            return UserAddressRequest.this;
        }
    }

    UserAddressRequest() {
        this.f1096wj = 1;
    }

    UserAddressRequest(int versionCode, List<CountrySpecification> allowedCountrySpecifications) {
        this.f1096wj = versionCode;
        this.f1095Ky = allowedCountrySpecifications;
    }

    public static Builder newBuilder() {
        UserAddressRequest userAddressRequest = new UserAddressRequest();
        userAddressRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.f1096wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0499a.m1139a(this, out, flags);
    }
}
