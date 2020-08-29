package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.C0766er;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new C0357h();

    /* renamed from: Dq */
    final Contents f677Dq;

    /* renamed from: Ds */
    final MetadataBundle f678Ds;

    /* renamed from: Dt */
    final DriveId f679Dt;

    /* renamed from: wj */
    final int f680wj;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference) {
        this.f680wj = versionCode;
        this.f679Dt = (DriveId) C0766er.m1977f(parentDriveId);
        this.f678Ds = (MetadataBundle) C0766er.m1977f(metadata);
        this.f677Dq = (Contents) C0766er.m1977f(contentsReference);
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference) {
        this(1, parentDriveId, metadata, contentsReference);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0357h.m717a(this, dest, flags);
    }
}
