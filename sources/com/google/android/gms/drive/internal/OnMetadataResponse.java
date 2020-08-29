package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR = new C0343af();

    /* renamed from: Ds */
    final MetadataBundle f704Ds;

    /* renamed from: wj */
    final int f705wj;

    OnMetadataResponse(int versionCode, MetadataBundle metadata) {
        this.f705wj = versionCode;
        this.f704Ds = metadata;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: fe */
    public MetadataBundle mo3612fe() {
        return this.f704Ds;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0343af.m673a(this, dest, flags);
    }
}
