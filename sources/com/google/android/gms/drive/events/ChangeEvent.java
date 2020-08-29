package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<ChangeEvent> CREATOR = new C0334a();

    /* renamed from: CS */
    final DriveId f653CS;

    /* renamed from: Dl */
    final int f654Dl;

    /* renamed from: wj */
    final int f655wj;

    ChangeEvent(int versionCode, DriveId driveId, int changeFlags) {
        this.f655wj = versionCode;
        this.f653CS = driveId;
        this.f654Dl = changeFlags;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.f653CS;
    }

    public int getType() {
        return 1;
    }

    public boolean hasContentChanged() {
        return (this.f654Dl & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.f654Dl & 1) != 0;
    }

    public String toString() {
        return String.format("ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.f653CS, Integer.valueOf(this.f654Dl)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0334a.m640a(this, dest, flags);
    }
}
