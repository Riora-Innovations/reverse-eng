package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public final class ConflictEvent implements SafeParcelable, DriveEvent {
    public static final Creator<ConflictEvent> CREATOR = new C0335b();

    /* renamed from: CS */
    final DriveId f656CS;

    /* renamed from: wj */
    final int f657wj;

    ConflictEvent(int versionCode, DriveId driveId) {
        this.f657wj = versionCode;
        this.f656CS = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return 1;
    }

    public String toString() {
        return String.format("ConflictEvent [id=%s]", new Object[]{this.f656CS});
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0335b.m643a(this, dest, flags);
    }
}
