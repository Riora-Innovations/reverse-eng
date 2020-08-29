package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.b */
public class C0351b implements Creator<AuthorizeAccessRequest> {
    /* renamed from: a */
    static void m695a(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, authorizeAccessRequest.f663wj);
        C0326b.m603a(parcel, 2, authorizeAccessRequest.f662Dn);
        C0326b.m607a(parcel, 3, (Parcelable) authorizeAccessRequest.f661CS, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: D */
    public AuthorizeAccessRequest createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 3:
                    driveId = (DriveId) C0324a.m564a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ai */
    public AuthorizeAccessRequest[] newArray(int i) {
        return new AuthorizeAccessRequest[i];
    }
}
