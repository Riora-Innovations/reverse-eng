package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.games.c */
public class C0469c implements Creator<PlayerEntity> {
    /* renamed from: a */
    static void m1031a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, playerEntity.getPlayerId(), false);
        C0326b.m619c(parcel, 1000, playerEntity.getVersionCode());
        C0326b.m609a(parcel, 2, playerEntity.getDisplayName(), false);
        C0326b.m607a(parcel, 3, (Parcelable) playerEntity.getIconImageUri(), i, false);
        C0326b.m607a(parcel, 4, (Parcelable) playerEntity.getHiResImageUri(), i, false);
        C0326b.m603a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0326b.m619c(parcel, 6, playerEntity.mo3993fl());
        C0326b.m603a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0326b.m609a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0326b.m609a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aQ */
    public PlayerEntity[] newArray(int i) {
        return new PlayerEntity[i];
    }

    /* renamed from: ak */
    public PlayerEntity createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
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
                    j = C0324a.m576h(parcel, n);
                    break;
                case 6:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 7:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 8:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 9:
                    str4 = C0324a.m581m(parcel, n);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
