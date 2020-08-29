package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new C0500a();

    /* renamed from: oQ */
    String f1098oQ;

    /* renamed from: wj */
    private final int f1099wj;

    CountrySpecification(int versionCode, String countryCode) {
        this.f1099wj = versionCode;
        this.f1098oQ = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.f1099wj = 1;
        this.f1098oQ = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.f1098oQ;
    }

    public int getVersionCode() {
        return this.f1099wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0500a.m1142a(this, dest, flags);
    }
}
