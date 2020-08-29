package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR = new C1553h();

    /* renamed from: Yw */
    private String f3955Yw;

    /* renamed from: Yx */
    private String f3956Yx;

    /* renamed from: wj */
    private final int f3957wj;

    InstrumentInfo(int versionCode, String instrumentType, String instrumentDetails) {
        this.f3957wj = versionCode;
        this.f3955Yw = instrumentType;
        this.f3956Yx = instrumentDetails;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.f3956Yx;
    }

    public String getInstrumentType() {
        return this.f3955Yw;
    }

    public int getVersionCode() {
        return this.f3957wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1553h.m4576a(this, out, flags);
    }
}
