package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.bp */
public class C0585bp implements Creator<C0586bq> {
    /* renamed from: a */
    static void m1301a(C0586bq bqVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, bqVar.versionCode);
        C0326b.m607a(parcel, 2, (Parcelable) bqVar.f1537nr, i, false);
        C0326b.m605a(parcel, 3, bqVar.mo4659at(), false);
        C0326b.m605a(parcel, 4, bqVar.mo4660au(), false);
        C0326b.m605a(parcel, 5, bqVar.mo4661av(), false);
        C0326b.m605a(parcel, 6, bqVar.mo4662aw(), false);
        C0326b.m609a(parcel, 7, bqVar.f1542nw, false);
        C0326b.m612a(parcel, 8, bqVar.f1543nx);
        C0326b.m609a(parcel, 9, bqVar.f1544ny, false);
        C0326b.m605a(parcel, 10, bqVar.mo4663ax(), false);
        C0326b.m619c(parcel, 11, bqVar.orientation);
        C0326b.m619c(parcel, 12, bqVar.f1536nA);
        C0326b.m609a(parcel, 13, bqVar.f1535mZ, false);
        C0326b.m607a(parcel, 14, (Parcelable) bqVar.f1534kN, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: e */
    public C0586bq createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        C0580bn bnVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        C0663db dbVar = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    bnVar = (C0580bn) C0324a.m564a(parcel, n, (Creator<T>) C0580bn.CREATOR);
                    break;
                case 3:
                    iBinder = C0324a.m583n(parcel, n);
                    break;
                case 4:
                    iBinder2 = C0324a.m583n(parcel, n);
                    break;
                case 5:
                    iBinder3 = C0324a.m583n(parcel, n);
                    break;
                case 6:
                    iBinder4 = C0324a.m583n(parcel, n);
                    break;
                case 7:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 8:
                    z = C0324a.m571c(parcel, n);
                    break;
                case 9:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 10:
                    iBinder5 = C0324a.m583n(parcel, n);
                    break;
                case 11:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 12:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 13:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 14:
                    dbVar = (C0663db) C0324a.m564a(parcel, n, (Creator<T>) C0663db.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new C0586bq(i, bnVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, dbVar);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: j */
    public C0586bq[] newArray(int i) {
        return new C0586bq[i];
    }
}
