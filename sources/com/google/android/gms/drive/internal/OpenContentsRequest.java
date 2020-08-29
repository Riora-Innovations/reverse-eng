package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest implements SafeParcelable {
    public static final Creator<OpenContentsRequest> CREATOR = new C0344ag();

    /* renamed from: CR */
    final int f706CR;

    /* renamed from: Do */
    final DriveId f707Do;

    /* renamed from: wj */
    final int f708wj;

    OpenContentsRequest(int versionCode, DriveId id, int mode) {
        this.f708wj = versionCode;
        this.f707Do = id;
        this.f706CR = mode;
    }

    public OpenContentsRequest(DriveId id, int mode) {
        this(1, id, mode);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0344ag.m676a(this, dest, flags);
    }
}
