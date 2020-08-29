package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR = new C1560o();

    /* renamed from: Zn */
    String f4022Zn;

    /* renamed from: Zo */
    String f4023Zo;

    /* renamed from: Zp */
    int f4024Zp;

    /* renamed from: Zq */
    int f4025Zq;

    /* renamed from: wj */
    private final int f4026wj;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.f4026wj = versionCode;
        this.f4022Zn = pan;
        this.f4023Zo = cvn;
        this.f4024Zp = expirationMonth;
        this.f4025Zq = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.f4023Zo;
    }

    public int getExpirationMonth() {
        return this.f4024Zp;
    }

    public int getExpirationYear() {
        return this.f4025Zq;
    }

    public String getPan() {
        return this.f4022Zn;
    }

    public int getVersionCode() {
        return this.f4026wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1560o.m4597a(this, out, flags);
    }
}
