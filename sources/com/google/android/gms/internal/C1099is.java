package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.util.TimeUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.internal.C1088ir.C1089a;
import com.google.android.gms.internal.C1088ir.C1090b;
import com.google.android.gms.internal.C1088ir.C1093c;
import com.google.android.gms.internal.C1088ir.C1094d;
import com.google.android.gms.internal.C1088ir.C1096f;
import com.google.android.gms.internal.C1088ir.C1097g;
import com.google.android.gms.internal.C1088ir.C1098h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.is */
public class C1099is implements Creator<C1088ir> {
    /* renamed from: a */
    static void m3271a(C1088ir irVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = irVar.mo6077hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, irVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m609a(parcel, 2, irVar.getAboutMe(), true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m607a(parcel, 3, (Parcelable) irVar.mo6078hW(), i, true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0326b.m609a(parcel, 4, irVar.getBirthday(), true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0326b.m609a(parcel, 5, irVar.getBraggingRights(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0326b.m619c(parcel, 6, irVar.getCircledByCount());
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0326b.m607a(parcel, 7, (Parcelable) irVar.mo6079hX(), i, true);
        }
        if (hB.contains(Integer.valueOf(8))) {
            C0326b.m609a(parcel, 8, irVar.getCurrentLocation(), true);
        }
        if (hB.contains(Integer.valueOf(9))) {
            C0326b.m609a(parcel, 9, irVar.getDisplayName(), true);
        }
        if (hB.contains(Integer.valueOf(12))) {
            C0326b.m619c(parcel, 12, irVar.getGender());
        }
        if (hB.contains(Integer.valueOf(14))) {
            C0326b.m609a(parcel, 14, irVar.getId(), true);
        }
        if (hB.contains(Integer.valueOf(15))) {
            C0326b.m607a(parcel, 15, (Parcelable) irVar.mo6080hY(), i, true);
        }
        if (hB.contains(Integer.valueOf(16))) {
            C0326b.m612a(parcel, 16, irVar.isPlusUser());
        }
        if (hB.contains(Integer.valueOf(19))) {
            C0326b.m607a(parcel, 19, (Parcelable) irVar.mo6081hZ(), i, true);
        }
        if (hB.contains(Integer.valueOf(18))) {
            C0326b.m609a(parcel, 18, irVar.getLanguage(), true);
        }
        if (hB.contains(Integer.valueOf(21))) {
            C0326b.m619c(parcel, 21, irVar.getObjectType());
        }
        if (hB.contains(Integer.valueOf(20))) {
            C0326b.m609a(parcel, 20, irVar.getNickname(), true);
        }
        if (hB.contains(Integer.valueOf(23))) {
            C0326b.m618b(parcel, 23, irVar.mo6108ib(), true);
        }
        if (hB.contains(Integer.valueOf(22))) {
            C0326b.m618b(parcel, 22, irVar.mo6107ia(), true);
        }
        if (hB.contains(Integer.valueOf(25))) {
            C0326b.m619c(parcel, 25, irVar.getRelationshipStatus());
        }
        if (hB.contains(Integer.valueOf(24))) {
            C0326b.m619c(parcel, 24, irVar.getPlusOneCount());
        }
        if (hB.contains(Integer.valueOf(27))) {
            C0326b.m609a(parcel, 27, irVar.getUrl(), true);
        }
        if (hB.contains(Integer.valueOf(26))) {
            C0326b.m609a(parcel, 26, irVar.getTagline(), true);
        }
        if (hB.contains(Integer.valueOf(29))) {
            C0326b.m612a(parcel, 29, irVar.isVerified());
        }
        if (hB.contains(Integer.valueOf(28))) {
            C0326b.m618b(parcel, 28, irVar.mo6109ic(), true);
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aI */
    public C1088ir createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        C1089a aVar = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C1090b bVar = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C1093c cVar = null;
        boolean z = false;
        String str7 = null;
        C1094d dVar = null;
        String str8 = null;
        int i4 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        ArrayList arrayList3 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    C1089a aVar2 = (C1089a) C0324a.m564a(parcel, n, (Creator<T>) C1089a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    aVar = aVar2;
                    break;
                case 4:
                    str2 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    C1090b bVar2 = (C1090b) C0324a.m564a(parcel, n, (Creator<T>) C1090b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    bVar = bVar2;
                    break;
                case 8:
                    str4 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    C1093c cVar2 = (C1093c) C0324a.m564a(parcel, n, (Creator<T>) C1093c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    cVar = cVar2;
                    break;
                case 16:
                    z = C0324a.m571c(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    C1094d dVar2 = (C1094d) C0324a.m564a(parcel, n, (Creator<T>) C1094d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    dVar = dVar2;
                    break;
                case Parameter.RETRY_TIMES /*20*/:
                    str8 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    arrayList = C0324a.m570c(parcel, n, C1096f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    arrayList2 = C0324a.m570c(parcel, n, C1097g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    arrayList3 = C0324a.m570c(parcel, n, C1098h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = C0324a.m571c(parcel, n);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1088ir(hashSet, i, str, aVar, str2, str3, i2, bVar, str4, str5, i3, str6, cVar, z, str7, dVar, str8, i4, arrayList, arrayList2, i5, i6, str9, str10, arrayList3, z2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bF */
    public C1088ir[] newArray(int i) {
        return new C1088ir[i];
    }
}
