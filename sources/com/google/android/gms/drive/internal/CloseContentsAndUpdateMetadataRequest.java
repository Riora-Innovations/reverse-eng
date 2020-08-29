package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new C0353d();

    /* renamed from: Do */
    final DriveId f664Do;

    /* renamed from: Dp */
    final MetadataBundle f665Dp;

    /* renamed from: Dq */
    final Contents f666Dq;

    /* renamed from: wj */
    final int f667wj;

    CloseContentsAndUpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference) {
        this.f667wj = versionCode;
        this.f664Do = id;
        this.f665Dp = metadataChangeSet;
        this.f666Dq = contentsReference;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference) {
        this(1, id, metadataChangeSet, contentsReference);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0353d.m705a(this, dest, flags);
    }
}
