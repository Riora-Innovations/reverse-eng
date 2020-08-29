package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.b */
public class C0489b implements Creator<RoomEntity> {
    /* renamed from: a */
    static void m1104a(RoomEntity roomEntity, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, roomEntity.getRoomId(), false);
        C0326b.m619c(parcel, 1000, roomEntity.getVersionCode());
        C0326b.m609a(parcel, 2, roomEntity.getCreatorId(), false);
        C0326b.m603a(parcel, 3, roomEntity.getCreationTimestamp());
        C0326b.m619c(parcel, 4, roomEntity.getStatus());
        C0326b.m609a(parcel, 5, roomEntity.getDescription(), false);
        C0326b.m619c(parcel, 6, roomEntity.getVariant());
        C0326b.m604a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0326b.m618b(parcel, 8, roomEntity.getParticipants(), false);
        C0326b.m619c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aq */
    public RoomEntity createFromParcel(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int o = C0324a.m584o(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 2:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 4:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 7:
                    bundle = C0324a.m585o(parcel, n);
                    break;
                case 8:
                    arrayList = C0324a.m570c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 1000:
                    i4 = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bd */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }
}
