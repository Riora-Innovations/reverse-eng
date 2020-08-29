package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.bn */
public final class C0580bn implements SafeParcelable {
    public static final C0579bm CREATOR = new C0579bm();

    /* renamed from: mY */
    public final String f1515mY;

    /* renamed from: mZ */
    public final String f1516mZ;
    public final String mimeType;

    /* renamed from: na */
    public final String f1517na;

    /* renamed from: nb */
    public final String f1518nb;

    /* renamed from: nc */
    public final String f1519nc;
    public final String packageName;
    public final int versionCode;

    public C0580bn(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.versionCode = i;
        this.f1515mY = str;
        this.f1516mZ = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.f1517na = str5;
        this.f1518nb = str6;
        this.f1519nc = str7;
    }

    public C0580bn(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(1, str, str2, str3, str4, str5, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0579bm.m1285a(this, out, flags);
    }
}
