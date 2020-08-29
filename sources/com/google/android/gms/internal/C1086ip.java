package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ip */
public class C1086ip implements Creator<C1085io> {
    /* renamed from: a */
    static void m3184a(C1085io ioVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        Set hB = ioVar.mo6036hB();
        if (hB.contains(Integer.valueOf(1))) {
            C0326b.m619c(parcel, 1, ioVar.getVersionCode());
        }
        if (hB.contains(Integer.valueOf(2))) {
            C0326b.m609a(parcel, 2, ioVar.getId(), true);
        }
        if (hB.contains(Integer.valueOf(4))) {
            C0326b.m607a(parcel, 4, (Parcelable) ioVar.mo6037hS(), i, true);
        }
        if (hB.contains(Integer.valueOf(5))) {
            C0326b.m609a(parcel, 5, ioVar.getStartDate(), true);
        }
        if (hB.contains(Integer.valueOf(6))) {
            C0326b.m607a(parcel, 6, (Parcelable) ioVar.mo6038hT(), i, true);
        }
        if (hB.contains(Integer.valueOf(7))) {
            C0326b.m609a(parcel, 7, ioVar.getType(), true);
        }
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aH */
    public C1085io createFromParcel(Parcel parcel) {
        String str = null;
        int o = C0324a.m584o(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        C1083im imVar = null;
        String str2 = null;
        C1083im imVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    C1083im imVar3 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    imVar2 = imVar3;
                    break;
                case 5:
                    str2 = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    C1083im imVar4 = (C1083im) C0324a.m564a(parcel, n, (Creator<T>) C1083im.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    imVar = imVar4;
                    break;
                case 7:
                    str = C0324a.m581m(parcel, n);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C1085io(hashSet, i, str3, imVar2, str2, imVar, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bE */
    public C1085io[] newArray(int i) {
        return new C1085io[i];
    }
}
