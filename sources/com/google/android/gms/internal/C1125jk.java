package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.jk */
public class C1125jk implements Creator<C1124jj> {
    /* renamed from: a */
    static void m3359a(C1124jj jjVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, jjVar.getVersionCode());
        C0326b.m609a(parcel, 2, jjVar.f3081ZA, false);
        C0326b.m609a(parcel, 3, jjVar.f3082ZB, false);
        C0326b.m618b(parcel, 4, jjVar.f3083ZC, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bh */
    public C1124jj createFromParcel(Parcel parcel) {
        String str = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        ArrayList eH = C0804fj.m2111eH();
        String str2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    eH = C0324a.m570c(parcel, n, C1122jh.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1124jj(i, str2, str, eH);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cn */
    public C1124jj[] newArray(int i) {
        return new C1124jj[i];
    }
}
