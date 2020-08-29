package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.t */
public class C0413t implements Creator<GetMetadataRequest> {
    /* renamed from: a */
    static void m816a(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, getMetadataRequest.f686wj);
        C0326b.m607a(parcel, 2, (Parcelable) getMetadataRequest.f685Do, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: L */
    public GetMetadataRequest createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    driveId = (DriveId) C0324a.m564a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new GetMetadataRequest(i, driveId);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: aq */
    public GetMetadataRequest[] newArray(int i) {
        return new GetMetadataRequest[i];
    }
}
