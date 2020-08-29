package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0804fj;
import com.google.android.gms.internal.C1124jj;
import com.google.android.gms.internal.C1126jl;
import com.google.android.gms.internal.C1130jp;
import com.google.android.gms.internal.C1132jr;
import com.google.android.gms.internal.C1134jt;
import com.google.android.gms.internal.C1136jv;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator<LoyaltyWalletObject> CREATOR = new C1555j();

    /* renamed from: YC */
    String f3965YC;

    /* renamed from: YD */
    String f3966YD;

    /* renamed from: YE */
    String f3967YE;

    /* renamed from: YF */
    String f3968YF;

    /* renamed from: YG */
    String f3969YG;

    /* renamed from: YH */
    String f3970YH;

    /* renamed from: YI */
    String f3971YI;

    /* renamed from: YJ */
    String f3972YJ;

    /* renamed from: YK */
    String f3973YK;

    /* renamed from: YL */
    ArrayList<C1136jv> f3974YL;

    /* renamed from: YM */
    C1132jr f3975YM;

    /* renamed from: YN */
    ArrayList<LatLng> f3976YN;

    /* renamed from: YO */
    String f3977YO;

    /* renamed from: YP */
    String f3978YP;

    /* renamed from: YQ */
    ArrayList<C1124jj> f3979YQ;

    /* renamed from: YR */
    boolean f3980YR;

    /* renamed from: YS */
    ArrayList<C1134jt> f3981YS;

    /* renamed from: YT */
    ArrayList<C1130jp> f3982YT;

    /* renamed from: YU */
    ArrayList<C1134jt> f3983YU;

    /* renamed from: YV */
    C1126jl f3984YV;

    /* renamed from: eN */
    String f3985eN;
    int state;

    /* renamed from: wj */
    private final int f3986wj;

    LoyaltyWalletObject() {
        this.f3986wj = 4;
        this.f3974YL = C0804fj.m2111eH();
        this.f3976YN = C0804fj.m2111eH();
        this.f3979YQ = C0804fj.m2111eH();
        this.f3981YS = C0804fj.m2111eH();
        this.f3982YT = C0804fj.m2111eH();
        this.f3983YU = C0804fj.m2111eH();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state2, ArrayList<C1136jv> messages, C1132jr validTimeInterval, ArrayList<LatLng> locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList<C1124jj> infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList<C1134jt> imageModuleDataMainImageUris, ArrayList<C1130jp> textModulesData, ArrayList<C1134jt> linksModuleDataUris, C1126jl loyaltyPoints) {
        this.f3986wj = versionCode;
        this.f3985eN = id;
        this.f3965YC = accountId;
        this.f3966YD = issuerName;
        this.f3967YE = programName;
        this.f3968YF = accountName;
        this.f3969YG = barcodeAlternateText;
        this.f3970YH = barcodeType;
        this.f3971YI = barcodeValue;
        this.f3972YJ = barcodeLabel;
        this.f3973YK = classId;
        this.state = state2;
        this.f3974YL = messages;
        this.f3975YM = validTimeInterval;
        this.f3976YN = locations;
        this.f3977YO = infoModuleDataHexFontColor;
        this.f3978YP = infoModuleDataHexBackgroundColor;
        this.f3979YQ = infoModuleDataLabelValueRows;
        this.f3980YR = infoModuleDataShowLastUpdateTime;
        this.f3981YS = imageModuleDataMainImageUris;
        this.f3982YT = textModulesData;
        this.f3983YU = linksModuleDataUris;
        this.f3984YV = loyaltyPoints;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.f3965YC;
    }

    public String getAccountName() {
        return this.f3968YF;
    }

    public String getBarcodeAlternateText() {
        return this.f3969YG;
    }

    public String getBarcodeType() {
        return this.f3970YH;
    }

    public String getBarcodeValue() {
        return this.f3971YI;
    }

    public String getId() {
        return this.f3985eN;
    }

    public String getIssuerName() {
        return this.f3966YD;
    }

    public String getProgramName() {
        return this.f3967YE;
    }

    public int getVersionCode() {
        return this.f3986wj;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C1555j.m4582a(this, dest, flags);
    }
}
