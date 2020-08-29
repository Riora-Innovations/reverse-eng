package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.util.TimeUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1116a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m607a(parcel, 1, (Parcelable) turnBasedMatchEntity.getGame(), i, false);
        C0326b.m609a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0326b.m609a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0326b.m603a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0326b.m609a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0326b.m603a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0326b.m609a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0326b.m619c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0326b.m619c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0326b.m619c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0326b.m613a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0326b.m618b(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0326b.m609a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0326b.m613a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0326b.m604a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0326b.m619c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0326b.m619c(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        C0326b.m612a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0326b.m619c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0326b.m609a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0326b.m609a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0326b.m599D(parcel, p);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    gameEntity = (GameEntity) C0324a.m564a(parcel, n, GameEntity.CREATOR);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 5:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 7:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 8:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 10:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 11:
                    i4 = C0324a.m575g(parcel, n);
                    break;
                case 12:
                    bArr = C0324a.m586p(parcel, n);
                    break;
                case 13:
                    arrayList = C0324a.m570c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = C0324a.m581m(parcel, n);
                    break;
                case 15:
                    bArr2 = C0324a.m586p(parcel, n);
                    break;
                case 16:
                    i5 = C0324a.m575g(parcel, n);
                    break;
                case 17:
                    bundle = C0324a.m585o(parcel, n);
                    break;
                case 18:
                    i6 = C0324a.m575g(parcel, n);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0324a.m571c(parcel, n);
                    break;
                case Parameter.RETRY_TIMES /*20*/:
                    str6 = C0324a.m581m(parcel, n);
                    break;
                case 21:
                    str7 = C0324a.m581m(parcel, n);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
