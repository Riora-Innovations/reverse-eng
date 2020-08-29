package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.drive.internal.aa */
public class C0338aa implements Creator<OnDownloadProgressResponse> {
    /* renamed from: a */
    static void m658a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, onDownloadProgressResponse.f693wj);
        C0326b.m603a(parcel, 2, onDownloadProgressResponse.f691DZ);
        C0326b.m603a(parcel, 3, onDownloadProgressResponse.f692Ea);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: O */
    public OnDownloadProgressResponse createFromParcel(Parcel parcel) {
        long j = 0;
        int o = C0324a.m584o(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 3:
                    j = C0324a.m576h(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: at */
    public OnDownloadProgressResponse[] newArray(int i) {
        return new OnDownloadProgressResponse[i];
    }
}
