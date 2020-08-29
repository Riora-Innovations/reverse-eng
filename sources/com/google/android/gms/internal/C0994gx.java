package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.gx */
public class C0994gx implements Creator<C0995gy> {
    /* renamed from: a */
    static void m2919a(C0995gy gyVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m618b(parcel, 1, gyVar.mo5621fS(), false);
        C0326b.m619c(parcel, 1000, gyVar.getVersionCode());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aX */
    public C0995gy[] newArray(int i) {
        return new C0995gy[i];
    }

    /* renamed from: al */
    public C0995gy createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    arrayList = C0324a.m570c(parcel, n, InvitationEntity.CREATOR);
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
            return new C0995gy(i, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
