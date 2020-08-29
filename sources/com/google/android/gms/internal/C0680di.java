package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: com.google.android.gms.internal.di */
public class C0680di implements Parcelable {
    @Deprecated
    public static final Creator<C0680di> CREATOR = new Creator<C0680di>() {
        @Deprecated
        /* renamed from: i */
        public C0680di createFromParcel(Parcel parcel) {
            return new C0680di(parcel);
        }

        @Deprecated
        /* renamed from: u */
        public C0680di[] newArray(int i) {
            return new C0680di[i];
        }
    };
    private String mValue;

    /* renamed from: uS */
    private String f1834uS;

    /* renamed from: uT */
    private String f1835uT;

    @Deprecated
    public C0680di() {
    }

    @Deprecated
    C0680di(Parcel parcel) {
        readFromParcel(parcel);
    }

    public C0680di(String str, String str2, String str3) {
        this.f1834uS = str;
        this.f1835uT = str2;
        this.mValue = str3;
    }

    @Deprecated
    private void readFromParcel(Parcel in) {
        this.f1834uS = in.readString();
        this.f1835uT = in.readString();
        this.mValue = in.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.f1834uS;
    }

    public String getValue() {
        return this.mValue;
    }

    @Deprecated
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.f1834uS);
        out.writeString(this.f1835uT);
        out.writeString(this.mValue);
    }
}
