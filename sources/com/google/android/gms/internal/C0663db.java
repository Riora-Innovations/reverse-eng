package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.db */
public final class C0663db implements SafeParcelable {
    public static final C0664dc CREATOR = new C0664dc();

    /* renamed from: pU */
    public String f1798pU;

    /* renamed from: pV */
    public int f1799pV;

    /* renamed from: pW */
    public int f1800pW;

    /* renamed from: pX */
    public boolean f1801pX;
    public final int versionCode;

    public C0663db(int i, int i2, boolean z) {
        String str = "afma-sdk-a-v" + i + "." + i2 + "." + (z ? "0" : "1");
        this(1, str, i, i2, z);
    }

    C0663db(int i, String str, int i2, int i3, boolean z) {
        this.versionCode = i;
        this.f1798pU = str;
        this.f1799pV = i2;
        this.f1800pW = i3;
        this.f1801pX = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0664dc.m1556a(this, out, flags);
    }
}
