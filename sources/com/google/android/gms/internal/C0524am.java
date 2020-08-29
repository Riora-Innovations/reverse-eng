package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.internal.am */
public final class C0524am implements SafeParcelable {
    public static final C0525an CREATOR = new C0525an();
    public final int backgroundColor;

    /* renamed from: lI */
    public final int f1237lI;

    /* renamed from: lJ */
    public final int f1238lJ;

    /* renamed from: lK */
    public final int f1239lK;

    /* renamed from: lL */
    public final int f1240lL;

    /* renamed from: lM */
    public final int f1241lM;

    /* renamed from: lN */
    public final int f1242lN;

    /* renamed from: lO */
    public final int f1243lO;

    /* renamed from: lP */
    public final String f1244lP;

    /* renamed from: lQ */
    public final int f1245lQ;

    /* renamed from: lR */
    public final String f1246lR;

    /* renamed from: lS */
    public final int f1247lS;

    /* renamed from: lT */
    public final int f1248lT;

    /* renamed from: lU */
    public final String f1249lU;
    public final int versionCode;

    C0524am(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.f1237lI = i2;
        this.backgroundColor = i3;
        this.f1238lJ = i4;
        this.f1239lK = i5;
        this.f1240lL = i6;
        this.f1241lM = i7;
        this.f1242lN = i8;
        this.f1243lO = i9;
        this.f1244lP = str;
        this.f1245lQ = i10;
        this.f1246lR = str2;
        this.f1247lS = i11;
        this.f1248lT = i12;
        this.f1249lU = str3;
    }

    public C0524am(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.f1237lI = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.f1238lJ = searchAdRequest.getBackgroundGradientBottom();
        this.f1239lK = searchAdRequest.getBackgroundGradientTop();
        this.f1240lL = searchAdRequest.getBorderColor();
        this.f1241lM = searchAdRequest.getBorderThickness();
        this.f1242lN = searchAdRequest.getBorderType();
        this.f1243lO = searchAdRequest.getCallButtonColor();
        this.f1244lP = searchAdRequest.getCustomChannels();
        this.f1245lQ = searchAdRequest.getDescriptionTextColor();
        this.f1246lR = searchAdRequest.getFontFace();
        this.f1247lS = searchAdRequest.getHeaderTextColor();
        this.f1248lT = searchAdRequest.getHeaderTextSize();
        this.f1249lU = searchAdRequest.getQuery();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0525an.m1210a(this, out, flags);
    }
}
