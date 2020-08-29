package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.wallet.m */
public class C1558m implements Creator<NotifyTransactionStatusRequest> {
    /* renamed from: a */
    static void m4591a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, notifyTransactionStatusRequest.f4017wj);
        C0326b.m609a(parcel, 2, notifyTransactionStatusRequest.f4015Yk, false);
        C0326b.m619c(parcel, 3, notifyTransactionStatusRequest.status);
        C0326b.m609a(parcel, 4, notifyTransactionStatusRequest.f4016Zk, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: bd */
    public NotifyTransactionStatusRequest createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 4:
                    str = C0324a.m581m(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: cj */
    public NotifyTransactionStatusRequest[] newArray(int i) {
        return new NotifyTransactionStatusRequest[i];
    }
}
