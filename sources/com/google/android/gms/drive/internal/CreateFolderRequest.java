package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.C0766er;

public class CreateFolderRequest implements SafeParcelable {
    public static final Creator<CreateFolderRequest> CREATOR = new C0358i();

    /* renamed from: Ds */
    final MetadataBundle f681Ds;

    /* renamed from: Dt */
    final DriveId f682Dt;

    /* renamed from: wj */
    final int f683wj;

    CreateFolderRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata) {
        this.f683wj = versionCode;
        this.f682Dt = (DriveId) C0766er.m1977f(parentDriveId);
        this.f681Ds = (MetadataBundle) C0766er.m1977f(metadata);
    }

    public CreateFolderRequest(DriveId parentDriveId, MetadataBundle metadata) {
        this(1, parentDriveId, metadata);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0358i.m720a(this, dest, flags);
    }
}
