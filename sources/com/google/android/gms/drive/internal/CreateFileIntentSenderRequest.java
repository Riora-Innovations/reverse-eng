package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<CreateFileIntentSenderRequest> CREATOR = new C0356g();

    /* renamed from: CQ */
    final int f672CQ;

    /* renamed from: CX */
    final String f673CX;

    /* renamed from: CY */
    final DriveId f674CY;

    /* renamed from: Ds */
    final MetadataBundle f675Ds;

    /* renamed from: wj */
    final int f676wj;

    CreateFileIntentSenderRequest(int versionCode, MetadataBundle metadata, int requestId, String title, DriveId startFolder) {
        this.f676wj = versionCode;
        this.f675Ds = metadata;
        this.f672CQ = requestId;
        this.f673CX = title;
        this.f674CY = startFolder;
    }

    public CreateFileIntentSenderRequest(MetadataBundle metadata, int requestId, String title, DriveId startFolder) {
        this(1, metadata, requestId, title, startFolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0356g.m714a(this, dest, flags);
    }
}
