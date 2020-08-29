package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new C1548c();

    /* renamed from: oQ */
    String f3937oQ;

    /* renamed from: wj */
    private final int f3938wj;

    CountrySpecification(int versionCode, String countryCode) {
        this.f3938wj = versionCode;
        this.f3937oQ = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.f3938wj = 1;
        this.f3937oQ = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.f3937oQ;
    }

    public int getVersionCode() {
        return this.f3938wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1548c.m4564a(this, dest, flags);
    }
}
