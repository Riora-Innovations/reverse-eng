package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ha */
public class C0998ha implements Creator<C0996gz> {
    /* renamed from: a */
    static void m2931a(C0996gz gzVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m618b(parcel, 1, gzVar.mo5627fT(), false);
        C0326b.m619c(parcel, 1000, gzVar.getVersionCode());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aY */
    public C0996gz[] newArray(int i) {
        return new C0996gz[i];
    }

    /* renamed from: am */
    public C0996gz createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    arrayList = C0324a.m570c(parcel, n, GameRequestEntity.CREATOR);
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
            return new C0996gz(i, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
