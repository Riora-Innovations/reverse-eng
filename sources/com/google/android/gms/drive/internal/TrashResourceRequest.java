package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class TrashResourceRequest implements SafeParcelable {
    public static final Creator<TrashResourceRequest> CREATOR = new C0349al();

    /* renamed from: Do */
    final DriveId f718Do;

    /* renamed from: wj */
    final int f719wj;

    TrashResourceRequest(int versionCode, DriveId id) {
        this.f719wj = versionCode;
        this.f718Do = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0349al.m689a(this, dest, flags);
    }
}
