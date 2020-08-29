package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.a */
public class C0481a implements Creator<InvitationEntity> {
    /* renamed from: a */
    static void m1082a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m607a(parcel, 1, (Parcelable) invitationEntity.getGame(), i, false);
        C0326b.m619c(parcel, 1000, invitationEntity.getVersionCode());
        C0326b.m609a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0326b.m603a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0326b.m619c(parcel, 4, invitationEntity.getInvitationType());
        C0326b.m607a(parcel, 5, (Parcelable) invitationEntity.getInviter(), i, false);
        C0326b.m618b(parcel, 6, invitationEntity.getParticipants(), false);
        C0326b.m619c(parcel, 7, invitationEntity.getVariant());
        C0326b.m619c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: an */
    public InvitationEntity createFromParcel(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    j = C0324a.m576h(parcel, n);
                    break;
                case 4:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) C0324a.m564a(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = C0324a.m570c(parcel, n, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 8:
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ba */
    public InvitationEntity[] newArray(int i) {
        return new InvitationEntity[i];
    }
}
