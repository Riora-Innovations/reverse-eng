package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR = new C0425z();

    /* renamed from: CW */
    final Contents f689CW;

    /* renamed from: wj */
    final int f690wj;

    OnContentsResponse(int versionCode, Contents contents) {
        this.f690wj = versionCode;
        this.f689CW = contents;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: eX */
    public Contents mo3591eX() {
        return this.f689CW;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0425z.m883a(this, dest, flags);
    }
}
