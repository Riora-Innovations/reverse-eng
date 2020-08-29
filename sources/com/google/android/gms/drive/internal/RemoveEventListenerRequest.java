package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest implements SafeParcelable {
    public static final Creator<RemoveEventListenerRequest> CREATOR = new C0347aj();

    /* renamed from: CS */
    final DriveId f715CS;

    /* renamed from: Dm */
    final int f716Dm;

    /* renamed from: wj */
    final int f717wj;

    RemoveEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.f717wj = versionCode;
        this.f715CS = driveId;
        this.f716Dm = eventType;
    }

    public RemoveEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0347aj.m685a(this, dest, flags);
    }
}
