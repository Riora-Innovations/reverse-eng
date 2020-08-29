package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR = new C0351b();

    /* renamed from: CS */
    final DriveId f661CS;

    /* renamed from: Dn */
    final long f662Dn;

    /* renamed from: wj */
    final int f663wj;

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.f663wj = versionCode;
        this.f662Dn = appId;
        this.f661CS = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0351b.m695a(this, dest, flags);
    }
}
