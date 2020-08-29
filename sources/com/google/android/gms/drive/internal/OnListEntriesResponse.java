package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnListEntriesResponse implements SafeParcelable {
    public static final Creator<OnListEntriesResponse> CREATOR = new C0341ad();

    /* renamed from: Ed */
    final DataHolder f700Ed;

    /* renamed from: wj */
    final int f701wj;

    OnListEntriesResponse(int versionCode, DataHolder entries) {
        this.f701wj = versionCode;
        this.f700Ed = entries;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: fc */
    public DataHolder mo3606fc() {
        return this.f700Ed;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0341ad.m667a(this, dest, flags);
    }
}
