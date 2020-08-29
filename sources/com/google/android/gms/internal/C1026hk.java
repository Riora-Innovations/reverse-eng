package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.internal.hk */
public class C1026hk implements Creator<C1025hj> {
    /* renamed from: a */
    static void m3029a(C1025hj hjVar, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m609a(parcel, 1, hjVar.getRequestId(), false);
        C0326b.m619c(parcel, 1000, hjVar.getVersionCode());
        C0326b.m603a(parcel, 2, hjVar.getExpirationTime());
        C0326b.m611a(parcel, 3, hjVar.mo5728gn());
        C0326b.m601a(parcel, 4, hjVar.getLatitude());
        C0326b.m601a(parcel, 5, hjVar.getLongitude());
        C0326b.m602a(parcel, 6, hjVar.mo5729go());
        C0326b.m619c(parcel, 7, hjVar.mo5730gp());
        C0326b.m619c(parcel, 8, hjVar.getNotificationResponsiveness());
        C0326b.m619c(parcel, 9, hjVar.mo5731gq());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: av */
    public C1025hj createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 2:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 3:
                    s = C0324a.m574f(parcel, n);
                    break;
                case 4:
                    d = C0324a.m579k(parcel, n);
                    break;
                case 5:
                    d2 = C0324a.m579k(parcel, n);
                    break;
                case 6:
                    f = C0324a.m578j(parcel, n);
                    break;
                case 7:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 8:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 9:
                    i4 = C0324a.m575g(parcel, n);
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
            return new C1025hj(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: bp */
    public C1025hj[] newArray(int i) {
        return new C1025hj[i];
    }
}
