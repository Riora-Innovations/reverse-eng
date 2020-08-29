package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.util.TimeUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C0804fj;
import com.google.android.gms.internal.C1124jj;
import com.google.android.gms.internal.C1126jl;
import com.google.android.gms.internal.C1130jp;
import com.google.android.gms.internal.C1132jr;
import com.google.android.gms.internal.C1134jt;
import com.google.android.gms.internal.C1136jv;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.wallet.j */
public class C1555j implements Creator<LoyaltyWalletObject> {
    /* renamed from: a */
    static void m4582a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0326b.m609a(parcel, 2, loyaltyWalletObject.f3985eN, false);
        C0326b.m609a(parcel, 3, loyaltyWalletObject.f3965YC, false);
        C0326b.m609a(parcel, 4, loyaltyWalletObject.f3966YD, false);
        C0326b.m609a(parcel, 5, loyaltyWalletObject.f3967YE, false);
        C0326b.m609a(parcel, 6, loyaltyWalletObject.f3968YF, false);
        C0326b.m609a(parcel, 7, loyaltyWalletObject.f3969YG, false);
        C0326b.m609a(parcel, 8, loyaltyWalletObject.f3970YH, false);
        C0326b.m609a(parcel, 9, loyaltyWalletObject.f3971YI, false);
        C0326b.m609a(parcel, 10, loyaltyWalletObject.f3972YJ, false);
        C0326b.m609a(parcel, 11, loyaltyWalletObject.f3973YK, false);
        C0326b.m619c(parcel, 12, loyaltyWalletObject.state);
        C0326b.m618b(parcel, 13, loyaltyWalletObject.f3974YL, false);
        C0326b.m607a(parcel, 14, (Parcelable) loyaltyWalletObject.f3975YM, i, false);
        C0326b.m618b(parcel, 15, loyaltyWalletObject.f3976YN, false);
        C0326b.m609a(parcel, 17, loyaltyWalletObject.f3978YP, false);
        C0326b.m609a(parcel, 16, loyaltyWalletObject.f3977YO, false);
        C0326b.m612a(parcel, 19, loyaltyWalletObject.f3980YR);
        C0326b.m618b(parcel, 18, loyaltyWalletObject.f3979YQ, false);
        C0326b.m618b(parcel, 21, loyaltyWalletObject.f3982YT, false);
        C0326b.m618b(parcel, 20, loyaltyWalletObject.f3981YS, false);
        C0326b.m607a(parcel, 23, (Parcelable) loyaltyWalletObject.f3984YV, i, false);
        C0326b.m618b(parcel, 22, loyaltyWalletObject.f3983YU, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: ba */
    public LoyaltyWalletObject createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList eH = C0804fj.m2111eH();
        C1132jr jrVar = null;
        ArrayList eH2 = C0804fj.m2111eH();
        String str11 = null;
        String str12 = null;
        ArrayList eH3 = C0804fj.m2111eH();
        boolean z = false;
        ArrayList eH4 = C0804fj.m2111eH();
        ArrayList eH5 = C0804fj.m2111eH();
        ArrayList eH6 = C0804fj.m2111eH();
        C1126jl jlVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    str5 = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    str6 = C0324a.m581m(parcel, n);
                    break;
                case 8:
                    str7 = C0324a.m581m(parcel, n);
                    break;
                case 9:
                    str8 = C0324a.m581m(parcel, n);
                    break;
                case 10:
                    str9 = C0324a.m581m(parcel, n);
                    break;
                case 11:
                    str10 = C0324a.m581m(parcel, n);
                    break;
                case 12:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 13:
                    eH = C0324a.m570c(parcel, n, C1136jv.CREATOR);
                    break;
                case 14:
                    jrVar = (C1132jr) C0324a.m564a(parcel, n, C1132jr.CREATOR);
                    break;
                case 15:
                    eH2 = C0324a.m570c(parcel, n, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = C0324a.m581m(parcel, n);
                    break;
                case 17:
                    str12 = C0324a.m581m(parcel, n);
                    break;
                case 18:
                    eH3 = C0324a.m570c(parcel, n, C1124jj.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0324a.m571c(parcel, n);
                    break;
                case Parameter.RETRY_TIMES /*20*/:
                    eH4 = C0324a.m570c(parcel, n, C1134jt.CREATOR);
                    break;
                case 21:
                    eH5 = C0324a.m570c(parcel, n, C1130jp.CREATOR);
                    break;
                case 22:
                    eH6 = C0324a.m570c(parcel, n, C1134jt.CREATOR);
                    break;
                case 23:
                    jlVar = (C1126jl) C0324a.m564a(parcel, n, C1126jl.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, eH, jrVar, eH2, str11, str12, eH3, z, eH4, eH5, eH6, jlVar);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cg */
    public LoyaltyWalletObject[] newArray(int i) {
        return new LoyaltyWalletObject[i];
    }
}
