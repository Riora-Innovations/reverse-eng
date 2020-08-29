package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m1125a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m607a(parcel, 1, (Parcelable) gameRequestEntity.getGame(), i, false);
        C0326b.m619c(parcel, 1000, gameRequestEntity.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) gameRequestEntity.getSender(), i, false);
        C0326b.m613a(parcel, 3, gameRequestEntity.getData(), false);
        C0326b.m609a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0326b.m618b(parcel, 5, gameRequestEntity.mo4383fU(), false);
        C0326b.m619c(parcel, 7, gameRequestEntity.getType());
        C0326b.m603a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0326b.m603a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0326b.m604a(parcel, 11, gameRequestEntity.mo4399gf(), false);
        C0326b.m599D(parcel, p);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    gameEntity = (GameEntity) C0324a.m564a(parcel, n, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) C0324a.m564a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = C0324a.m586p(parcel, n);
                    break;
                case 4:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    arrayList = C0324a.m570c(parcel, n, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 9:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 10:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 11:
                    bundle = C0324a.m585o(parcel, n);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
