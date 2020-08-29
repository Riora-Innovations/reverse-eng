package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ListParentsRequest implements SafeParcelable {
    public static final Creator<ListParentsRequest> CREATOR = new C0423x();

    /* renamed from: DT */
    final DriveId f687DT;

    /* renamed from: wj */
    final int f688wj;

    ListParentsRequest(int versionCode, DriveId driveId) {
        this.f688wj = versionCode;
        this.f687DT = driveId;
    }

    public ListParentsRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0423x.m874a(this, dest, flags);
    }
}
