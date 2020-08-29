package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator<GetMetadataRequest> CREATOR = new C0413t();

    /* renamed from: Do */
    final DriveId f685Do;

    /* renamed from: wj */
    final int f686wj;

    GetMetadataRequest(int versionCode, DriveId id) {
        this.f686wj = versionCode;
        this.f685Do = id;
    }

    public GetMetadataRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0413t.m816a(this, dest, flags);
    }
}
