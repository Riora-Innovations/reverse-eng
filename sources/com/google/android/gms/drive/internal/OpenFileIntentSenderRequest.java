package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR = new C0345ah();

    /* renamed from: CX */
    final String f709CX;

    /* renamed from: CY */
    final DriveId f710CY;

    /* renamed from: Dk */
    final String[] f711Dk;

    /* renamed from: wj */
    final int f712wj;

    OpenFileIntentSenderRequest(int versionCode, String title, String[] mimeTypes, DriveId startFolder) {
        this.f712wj = versionCode;
        this.f709CX = title;
        this.f711Dk = mimeTypes;
        this.f710CY = startFolder;
    }

    public OpenFileIntentSenderRequest(String title, String[] mimeTypes, DriveId startFolder) {
        this(1, title, mimeTypes, startFolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0345ah.m679a(this, dest, flags);
    }
}
