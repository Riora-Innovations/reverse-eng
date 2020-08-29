package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.identity.intents.model.b */
public class C0501b implements Creator<UserAddress> {
    /* renamed from: a */
    static void m1145a(UserAddress userAddress, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, userAddress.getVersionCode());
        C0326b.m609a(parcel, 2, userAddress.name, false);
        C0326b.m609a(parcel, 3, userAddress.f1100KB, false);
        C0326b.m609a(parcel, 4, userAddress.f1101KC, false);
        C0326b.m609a(parcel, 5, userAddress.f1102KD, false);
        C0326b.m609a(parcel, 6, userAddress.f1103KE, false);
        C0326b.m609a(parcel, 7, userAddress.f1104KF, false);
        C0326b.m609a(parcel, 8, userAddress.f1105KG, false);
        C0326b.m609a(parcel, 9, userAddress.f1106KH, false);
        C0326b.m609a(parcel, 10, userAddress.f1113oQ, false);
        C0326b.m609a(parcel, 11, userAddress.f1107KI, false);
        C0326b.m609a(parcel, 12, userAddress.f1108KJ, false);
        C0326b.m609a(parcel, 13, userAddress.f1109KK, false);
        C0326b.m612a(parcel, 14, userAddress.f1110KL);
        C0326b.m609a(parcel, 15, userAddress.f1111KM, false);
        C0326b.m609a(parcel, 16, userAddress.f1112KN, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: at */
    public UserAddress createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    str4 = C0324a.m581m(parcel, n);
                    break;
                case 6:
                    str5 = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    str6 = C0324a.m581m(parcel, n);
                    break;
                case 8:
                    str7 = C0324a.m581m(parcel, n);
                    break;
                case 9:
                    str8 = C0324a.m581m(parcel, n);
                    break;
                case 10:
                    str9 = C0324a.m581m(parcel, n);
                    break;
                case 11:
                    str10 = C0324a.m581m(parcel, n);
                    break;
                case 12:
                    str11 = C0324a.m581m(parcel, n);
                    break;
                case 13:
                    str12 = C0324a.m581m(parcel, n);
                    break;
                case 14:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 15:
                    str13 = C0324a.m581m(parcel, n);
                    break;
                case 16:
                    str14 = C0324a.m581m(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bg */
    public UserAddress[] newArray(int i) {
        return new UserAddress[i];
    }
}
