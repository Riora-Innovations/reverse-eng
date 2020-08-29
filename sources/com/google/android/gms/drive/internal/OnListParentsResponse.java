package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListParentsResponse implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR = new C0342ae();

    /* renamed from: Ee */
    final DataHolder f702Ee;

    /* renamed from: wj */
    final int f703wj;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.f703wj = versionCode;
        this.f702Ee = parents;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: fd */
    public DataHolder mo3609fd() {
        return this.f702Ee;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0342ae.m670a(this, dest, flags);
    }
}
