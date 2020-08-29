package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.util.TimeUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.games.a */
public class C0466a implements Creator<GameEntity> {
    /* renamed from: a */
    static void m1028a(GameEntity gameEntity, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, gameEntity.getApplicationId(), false);
        C0326b.m609a(parcel, 2, gameEntity.getDisplayName(), false);
        C0326b.m609a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0326b.m609a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0326b.m609a(parcel, 5, gameEntity.getDescription(), false);
        C0326b.m609a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0326b.m607a(parcel, 7, (Parcelable) gameEntity.getIconImageUri(), i, false);
        C0326b.m607a(parcel, 8, (Parcelable) gameEntity.getHiResImageUri(), i, false);
        C0326b.m607a(parcel, 9, (Parcelable) gameEntity.getFeaturedImageUri(), i, false);
        C0326b.m612a(parcel, 10, gameEntity.isPlayEnabledGame());
        C0326b.m612a(parcel, 11, gameEntity.isInstanceInstalled());
        C0326b.m609a(parcel, 12, gameEntity.getInstancePackageName(), false);
        C0326b.m619c(parcel, 13, gameEntity.getGameplayAclStatus());
        C0326b.m619c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0326b.m619c(parcel, 15, gameEntity.getLeaderboardCount());
        C0326b.m612a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0326b.m612a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0326b.m619c(parcel, 1000, gameEntity.getVersionCode());
        C0326b.m609a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0326b.m609a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0326b.m612a(parcel, 21, gameEntity.isMuted());
        C0326b.m609a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aP */
    public GameEntity[] newArray(int i) {
        return new GameEntity[i];
    }

    /* renamed from: aj */
    public GameEntity createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 2:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    str5 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    str6 = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    uri = (Uri) C0324a.m564a(parcel, n, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) C0324a.m564a(parcel, n, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) C0324a.m564a(parcel, n, Uri.CREATOR);
                    break;
                case 10:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 11:
                    z2 = C0324a.m571c(parcel, n);
                    break;
                case 12:
                    str7 = C0324a.m581m(parcel, n);
                    break;
                case 13:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 14:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 15:
                    i4 = C0324a.m575g(parcel, n);
                    break;
                case 16:
                    z3 = C0324a.m571c(parcel, n);
                    break;
                case 17:
                    z4 = C0324a.m571c(parcel, n);
                    break;
                case 18:
                    str8 = C0324a.m581m(parcel, n);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str9 = C0324a.m581m(parcel, n);
                    break;
                case Parameter.RETRY_TIMES /*20*/:
                    str10 = C0324a.m581m(parcel, n);
                    break;
                case 21:
                    z5 = C0324a.m571c(parcel, n);
                    break;
                case 1000:
                    i = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
