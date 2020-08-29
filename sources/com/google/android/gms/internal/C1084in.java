package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.util.TimeUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.in */
public class C1084in implements Creator<C1083im> {
    /* renamed from: a */
    static void m3172a(C1083im imVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = imVar.mo5951hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, imVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m607a(parcel, 2, (Parcelable) imVar.mo5952hC(), i, true);
        }
        if (hB.contains(Integer.valueOf(3))) {
            C0326b.m610a(parcel, 3, imVar.getAdditionalName(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0326b.m607a(parcel, 4, (Parcelable) imVar.mo5953hD(), i, true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0326b.m609a(parcel, 5, imVar.getAddressCountry(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0326b.m609a(parcel, 6, imVar.getAddressLocality(), true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0326b.m609a(parcel, 7, imVar.getAddressRegion(), true);
        }
        if (hB.contains(Integer.valueOf(8))) {
            C0326b.m618b(parcel, 8, imVar.mo5954hE(), true);
        }
        if (hB.contains(Integer.valueOf(9))) {
            C0326b.m619c(parcel, 9, imVar.getAttendeeCount());
        }
        if (hB.contains(Integer.valueOf(10))) {
            C0326b.m618b(parcel, 10, imVar.mo5955hF(), true);
        }
        if (hB.contains(Integer.valueOf(11))) {
            C0326b.m607a(parcel, 11, (Parcelable) imVar.mo5956hG(), i, true);
        }
        if (hB.contains(Integer.valueOf(12))) {
            C0326b.m618b(parcel, 12, imVar.mo5957hH(), true);
        }
        if (hB.contains(Integer.valueOf(13))) {
            C0326b.m609a(parcel, 13, imVar.getBestRating(), true);
        }
        if (hB.contains(Integer.valueOf(14))) {
            C0326b.m609a(parcel, 14, imVar.getBirthDate(), true);
        }
        if (hB.contains(Integer.valueOf(15))) {
            C0326b.m607a(parcel, 15, (Parcelable) imVar.mo5958hI(), i, true);
        }
        if (hB.contains(Integer.valueOf(17))) {
            C0326b.m609a(parcel, 17, imVar.getContentSize(), true);
        }
        if (hB.contains(Integer.valueOf(16))) {
            C0326b.m609a(parcel, 16, imVar.getCaption(), true);
        }
        if (hB.contains(Integer.valueOf(19))) {
            C0326b.m618b(parcel, 19, imVar.mo5959hJ(), true);
        }
        if (hB.contains(Integer.valueOf(18))) {
            C0326b.m609a(parcel, 18, imVar.getContentUrl(), true);
        }
        if (hB.contains(Integer.valueOf(21))) {
            C0326b.m609a(parcel, 21, imVar.getDateModified(), true);
        }
        if (hB.contains(Integer.valueOf(20))) {
            C0326b.m609a(parcel, 20, imVar.getDateCreated(), true);
        }
        if (hB.contains(Integer.valueOf(23))) {
            C0326b.m609a(parcel, 23, imVar.getDescription(), true);
        }
        if (hB.contains(Integer.valueOf(22))) {
            C0326b.m609a(parcel, 22, imVar.getDatePublished(), true);
        }
        if (hB.contains(Integer.valueOf(25))) {
            C0326b.m609a(parcel, 25, imVar.getEmbedUrl(), true);
        }
        if (hB.contains(Integer.valueOf(24))) {
            C0326b.m609a(parcel, 24, imVar.getDuration(), true);
        }
        if (hB.contains(Integer.valueOf(27))) {
            C0326b.m609a(parcel, 27, imVar.getFamilyName(), true);
        }
        if (hB.contains(Integer.valueOf(26))) {
            C0326b.m609a(parcel, 26, imVar.getEndDate(), true);
        }
        if (hB.contains(Integer.valueOf(29))) {
            C0326b.m607a(parcel, 29, (Parcelable) imVar.mo5960hK(), i, true);
        }
        if (hB.contains(Integer.valueOf(28))) {
            C0326b.m609a(parcel, 28, imVar.getGender(), true);
        }
        if (hB.contains(Integer.valueOf(31))) {
            C0326b.m609a(parcel, 31, imVar.getHeight(), true);
        }
        if (hB.contains(Integer.valueOf(30))) {
            C0326b.m609a(parcel, 30, imVar.getGivenName(), true);
        }
        if (hB.contains(Integer.valueOf(34))) {
            C0326b.m607a(parcel, 34, (Parcelable) imVar.mo5961hL(), i, true);
        }
        if (hB.contains(Integer.valueOf(32))) {
            C0326b.m609a(parcel, 32, imVar.getId(), true);
        }
        if (hB.contains(Integer.valueOf(33))) {
            C0326b.m609a(parcel, 33, imVar.getImage(), true);
        }
        if (hB.contains(Integer.valueOf(38))) {
            C0326b.m601a(parcel, 38, imVar.getLongitude());
        }
        if (hB.contains(Integer.valueOf(39))) {
            C0326b.m609a(parcel, 39, imVar.getName(), true);
        }
        if (hB.contains(Integer.valueOf(36))) {
            C0326b.m601a(parcel, 36, imVar.getLatitude());
        }
        if (hB.contains(Integer.valueOf(37))) {
            C0326b.m607a(parcel, 37, (Parcelable) imVar.mo5962hM(), i, true);
        }
        if (hB.contains(Integer.valueOf(42))) {
            C0326b.m609a(parcel, 42, imVar.getPlayerType(), true);
        }
        if (hB.contains(Integer.valueOf(43))) {
            C0326b.m609a(parcel, 43, imVar.getPostOfficeBoxNumber(), true);
        }
        if (hB.contains(Integer.valueOf(40))) {
            C0326b.m607a(parcel, 40, (Parcelable) imVar.mo5963hN(), i, true);
        }
        if (hB.contains(Integer.valueOf(41))) {
            C0326b.m618b(parcel, 41, imVar.mo5964hO(), true);
        }
        if (hB.contains(Integer.valueOf(46))) {
            C0326b.m607a(parcel, 46, (Parcelable) imVar.mo5965hP(), i, true);
        }
        if (hB.contains(Integer.valueOf(47))) {
            C0326b.m609a(parcel, 47, imVar.getStartDate(), true);
        }
        if (hB.contains(Integer.valueOf(44))) {
            C0326b.m609a(parcel, 44, imVar.getPostalCode(), true);
        }
        if (hB.contains(Integer.valueOf(45))) {
            C0326b.m609a(parcel, 45, imVar.getRatingValue(), true);
        }
        if (hB.contains(Integer.valueOf(51))) {
            C0326b.m609a(parcel, 51, imVar.getThumbnailUrl(), true);
        }
        if (hB.contains(Integer.valueOf(50))) {
            C0326b.m607a(parcel, 50, (Parcelable) imVar.mo5966hQ(), i, true);
        }
        if (hB.contains(Integer.valueOf(49))) {
            C0326b.m609a(parcel, 49, imVar.getText(), true);
        }
        if (hB.contains(Integer.valueOf(48))) {
            C0326b.m609a(parcel, 48, imVar.getStreetAddress(), true);
        }
        if (hB.contains(Integer.valueOf(55))) {
            C0326b.m609a(parcel, 55, imVar.getWidth(), true);
        }
        if (hB.contains(Integer.valueOf(54))) {
            C0326b.m609a(parcel, 54, imVar.getUrl(), true);
        }
        if (hB.contains(Integer.valueOf(53))) {
            C0326b.m609a(parcel, 53, imVar.getType(), true);
        }
        if (hB.contains(Integer.valueOf(52))) {
            C0326b.m609a(parcel, 52, imVar.getTickerSymbol(), true);
        }
        if (hB.contains(Integer.valueOf(56))) {
            C0326b.m609a(parcel, 56, imVar.getWorstRating(), true);
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aG */
    public C1083im createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        C1083im imVar = null;
        ArrayList arrayList = null;
        C1083im imVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        ArrayList arrayList2 = null;
        int i2 = 0;
        ArrayList arrayList3 = null;
        C1083im imVar3 = null;
        ArrayList arrayList4 = null;
        String str4 = null;
        String str5 = null;
        C1083im imVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        ArrayList arrayList5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        C1083im imVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        C1083im imVar6 = null;
        double d = 0.0d;
        C1083im imVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        C1083im imVar8 = null;
        ArrayList arrayList6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        C1083im imVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        C1083im imVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    C1083im imVar11 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    imVar = imVar11;
                    break;
                case 3:
                    arrayList = C0324a.m595y(parcel, n);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    C1083im imVar12 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    imVar2 = imVar12;
                    break;
                case 5:
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str3 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    arrayList2 = C0324a.m570c(parcel, n, C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i2 = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    arrayList3 = C0324a.m570c(parcel, n, C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    C1083im imVar13 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    imVar3 = imVar13;
                    break;
                case 12:
                    arrayList4 = C0324a.m570c(parcel, n, C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str4 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str5 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    C1083im imVar14 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    imVar4 = imVar14;
                    break;
                case 16:
                    str6 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str7 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    str8 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    arrayList5 = C0324a.m570c(parcel, n, C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case Parameter.RETRY_TIMES /*20*/:
                    str9 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    str10 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    str11 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    str12 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    str13 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    str14 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str15 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str16 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    str17 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    C1083im imVar15 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    imVar5 = imVar15;
                    break;
                case 30:
                    str18 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case 31:
                    str19 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    str20 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str21 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    C1083im imVar16 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    imVar6 = imVar16;
                    break;
                case 36:
                    d = C0324a.m579k(parcel, n);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    C1083im imVar17 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    imVar7 = imVar17;
                    break;
                case 38:
                    d2 = C0324a.m579k(parcel, n);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str22 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case 40:
                    C1083im imVar18 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    imVar8 = imVar18;
                    break;
                case 41:
                    arrayList6 = C0324a.m570c(parcel, n, C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case 42:
                    str23 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str24 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case 44:
                    str25 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str26 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case 46:
                    C1083im imVar19 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    imVar9 = imVar19;
                    break;
                case 47:
                    str27 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case 48:
                    str28 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case 49:
                    str29 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                    C1083im imVar20 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    imVar10 = imVar20;
                    break;
                case 51:
                    str30 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case 52:
                    str31 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case 53:
                    str32 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case 54:
                    str33 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case 55:
                    str34 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case 56:
                    str35 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1083im(hashSet, i, imVar, arrayList, imVar2, str, str2, str3, arrayList2, i2, arrayList3, imVar3, arrayList4, str4, str5, imVar4, str6, str7, str8, arrayList5, str9, str10, str11, str12, str13, str14, str15, str16, str17, imVar5, str18, str19, str20, str21, imVar6, d, imVar7, d2, str22, imVar8, arrayList6, str23, str24, str25, str26, imVar9, str27, str28, str29, imVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bD */
    public C1083im[] newArray(int i) {
        return new C1083im[i];
    }
}
