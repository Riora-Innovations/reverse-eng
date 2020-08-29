package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator<CloseContentsRequest> CREATOR = new C0354e();

    /* renamed from: Dq */
    final Contents f668Dq;

    /* renamed from: Dr */
    final Boolean f669Dr;

    /* renamed from: wj */
    final int f670wj;

    CloseContentsRequest(int versionCode, Contents contentsReference, Boolean saveResults) {
        this.f670wj = versionCode;
        this.f668Dq = contentsReference;
        this.f669Dr = saveResults;
    }

    public CloseContentsRequest(Contents contentsReference, boolean saveResults) {
        this(1, contentsReference, Boolean.valueOf(saveResults));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0354e.m708a(this, dest, flags);
    }
}
