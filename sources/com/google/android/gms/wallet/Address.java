package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR = new C1546a();

    /* renamed from: KB */
    String f3921KB;

    /* renamed from: KC */
    String f3922KC;

    /* renamed from: KD */
    String f3923KD;

    /* renamed from: KI */
    String f3924KI;

    /* renamed from: KK */
    String f3925KK;

    /* renamed from: KL */
    boolean f3926KL;

    /* renamed from: KM */
    String f3927KM;

    /* renamed from: Yd */
    String f3928Yd;

    /* renamed from: Ye */
    String f3929Ye;
    String name;

    /* renamed from: oQ */
    String f3930oQ;

    /* renamed from: wj */
    private final int f3931wj;

    Address() {
        this.f3931wj = 1;
    }

    Address(int versionCode, String name2, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.f3931wj = versionCode;
        this.name = name2;
        this.f3921KB = address1;
        this.f3922KC = address2;
        this.f3923KD = address3;
        this.f3930oQ = countryCode;
        this.f3928Yd = city;
        this.f3929Ye = state;
        this.f3924KI = postalCode;
        this.f3925KK = phoneNumber;
        this.f3926KL = isPostBox;
        this.f3927KM = companyName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.f3921KB;
    }

    public String getAddress2() {
        return this.f3922KC;
    }

    public String getAddress3() {
        return this.f3923KD;
    }

    public String getCity() {
        return this.f3928Yd;
    }

    public String getCompanyName() {
        return this.f3927KM;
    }

    public String getCountryCode() {
        return this.f3930oQ;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.f3925KK;
    }

    public String getPostalCode() {
        return this.f3924KI;
    }

    public String getState() {
        return this.f3929Ye;
    }

    public int getVersionCode() {
        return this.f3931wj;
    }

    public boolean isPostBox() {
        return this.f3926KL;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1546a.m4558a(this, out, flags);
    }
}
