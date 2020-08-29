package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR = new C0339ab();

    /* renamed from: Do */
    DriveId f694Do;

    /* renamed from: wj */
    final int f695wj;

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.f695wj = versionCode;
        this.f694Do = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.f694Do;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0339ab.m661a(this, dest, flags);
    }
}
