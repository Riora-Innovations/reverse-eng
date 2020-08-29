package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.games.PlayerEntity;

/* renamed from: com.google.android.gms.games.multiplayer.c */
public class C0483c implements Creator<ParticipantEntity> {
    /* renamed from: a */
    static void m1085a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, participantEntity.getParticipantId(), false);
        C0326b.m609a(parcel, 2, participantEntity.getDisplayName(), false);
        C0326b.m607a(parcel, 3, (Parcelable) participantEntity.getIconImageUri(), i, false);
        C0326b.m607a(parcel, 4, (Parcelable) participantEntity.getHiResImageUri(), i, false);
        C0326b.m619c(parcel, 5, participantEntity.getStatus());
        C0326b.m609a(parcel, 6, participantEntity.mo4168ge(), false);
        C0326b.m612a(parcel, 7, participantEntity.isConnectedToRoom());
        C0326b.m607a(parcel, 8, (Parcelable) participantEntity.getPlayer(), i, false);
        C0326b.m619c(parcel, 9, participantEntity.getCapabilities());
        C0326b.m607a(parcel, 10, (Parcelable) participantEntity.getResult(), i, false);
        C0326b.m609a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0326b.m609a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0326b.m619c(parcel, 1000, participantEntity.getVersionCode());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: ao */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    uri = (Uri) C0324a.m564a(parcel, n, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) C0324a.m564a(parcel, n, Uri.CREATOR);
                    break;
                case 5:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 6:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) C0324a.m564a(parcel, n, PlayerEntity.CREATOR);
                    break;
                case 9:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 10:
                    participantResult = (ParticipantResult) C0324a.m564a(parcel, n, (Creator<T>) ParticipantResult.CREATOR);
                    break;
                case 11:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 12:
                    str5 = C0324a.m581m(parcel, n);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bb */
    public ParticipantEntity[] newArray(int i) {
        return new ParticipantEntity[i];
    }
}
