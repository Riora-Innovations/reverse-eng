package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new C0338aa();

    /* renamed from: DZ */
    final long f691DZ;

    /* renamed from: Ea */
    final long f692Ea;

    /* renamed from: wj */
    final int f693wj;

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected) {
        this.f693wj = versionCode;
        this.f691DZ = bytesLoaded;
        this.f692Ea = bytesExpected;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: eY */
    public long mo3594eY() {
        return this.f691DZ;
    }

    /* renamed from: eZ */
    public long mo3595eZ() {
        return this.f692Ea;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0338aa.m658a(this, dest, flags);
    }
}
