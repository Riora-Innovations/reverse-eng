package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ConflictEvent;

public class OnEventResponse implements SafeParcelable {
    public static final Creator<OnEventResponse> CREATOR = new C0340ac();

    /* renamed from: Dm */
    final int f696Dm;

    /* renamed from: Eb */
    final ChangeEvent f697Eb;

    /* renamed from: Ec */
    final ConflictEvent f698Ec;

    /* renamed from: wj */
    final int f699wj;

    OnEventResponse(int versionCode, int eventType, ChangeEvent changeEvent, ConflictEvent conflictEvent) {
        this.f699wj = versionCode;
        this.f696Dm = eventType;
        this.f697Eb = changeEvent;
        this.f698Ec = conflictEvent;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: fa */
    public ChangeEvent mo3601fa() {
        return this.f697Eb;
    }

    /* renamed from: fb */
    public ConflictEvent mo3602fb() {
        return this.f698Ec;
    }

    public int getEventType() {
        return this.f696Dm;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0340ac.m664a(this, dest, flags);
    }
}
