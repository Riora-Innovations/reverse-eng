package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator<AddEventListenerRequest> CREATOR = new C0337a();

    /* renamed from: CS */
    final DriveId f658CS;

    /* renamed from: Dm */
    final int f659Dm;

    /* renamed from: wj */
    final int f660wj;

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType) {
        this.f660wj = versionCode;
        this.f658CS = driveId;
        this.f659Dm = eventType;
    }

    public AddEventListenerRequest(DriveId id, int eventType) {
        this(1, id, eventType);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0337a.m655a(this, dest, flags);
    }
}
