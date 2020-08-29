package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR = new C0501b();

    /* renamed from: KB */
    String f1100KB;

    /* renamed from: KC */
    String f1101KC;

    /* renamed from: KD */
    String f1102KD;

    /* renamed from: KE */
    String f1103KE;

    /* renamed from: KF */
    String f1104KF;

    /* renamed from: KG */
    String f1105KG;

    /* renamed from: KH */
    String f1106KH;

    /* renamed from: KI */
    String f1107KI;

    /* renamed from: KJ */
    String f1108KJ;

    /* renamed from: KK */
    String f1109KK;

    /* renamed from: KL */
    boolean f1110KL;

    /* renamed from: KM */
    String f1111KM;

    /* renamed from: KN */
    String f1112KN;
    String name;

    /* renamed from: oQ */
    String f1113oQ;

    /* renamed from: wj */
    private final int f1114wj;

    UserAddress() {
        this.f1114wj = 1;
    }

    UserAddress(int versionCode, String name2, String address1, String address2, String address3, String address4, String address5, String administrativeArea, String locality, String countryCode, String postalCode, String sortingCode, String phoneNumber, boolean isPostBox, String companyName, String emailAddress) {
        this.f1114wj = versionCode;
        this.name = name2;
        this.f1100KB = address1;
        this.f1101KC = address2;
        this.f1102KD = address3;
        this.f1103KE = address4;
        this.f1104KF = address5;
        this.f1105KG = administrativeArea;
        this.f1106KH = locality;
        this.f1113oQ = countryCode;
        this.f1107KI = postalCode;
        this.f1108KJ = sortingCode;
        this.f1109KK = phoneNumber;
        this.f1110KL = isPostBox;
        this.f1111KM = companyName;
        this.f1112KN = emailAddress;
    }

    public static UserAddress fromIntent(Intent data) {
        if (data == null || !data.hasExtra(Extras.EXTRA_ADDRESS)) {
            return null;
        }
        return (UserAddress) data.getParcelableExtra(Extras.EXTRA_ADDRESS);
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.f1100KB;
    }

    public String getAddress2() {
        return this.f1101KC;
    }

    public String getAddress3() {
        return this.f1102KD;
    }

    public String getAddress4() {
        return this.f1103KE;
    }

    public String getAddress5() {
        return this.f1104KF;
    }

    public String getAdministrativeArea() {
        return this.f1105KG;
    }

    public String getCompanyName() {
        return this.f1111KM;
    }

    public String getCountryCode() {
        return this.f1113oQ;
    }

    public String getEmailAddress() {
        return this.f1112KN;
    }

    public String getLocality() {
        return this.f1106KH;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.f1109KK;
    }

    public String getPostalCode() {
        return this.f1107KI;
    }

    public String getSortingCode() {
        return this.f1108KJ;
    }

    public int getVersionCode() {
        return this.f1114wj;
    }

    public boolean isPostBox() {
        return this.f1110KL;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0501b.m1145a(this, out, flags);
    }
}
