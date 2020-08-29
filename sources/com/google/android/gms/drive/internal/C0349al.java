package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.al */
public class C0349al implements Creator<TrashResourceRequest> {
    /* renamed from: a */
    static void m689a(TrashResourceRequest trashResourceRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, trashResourceRequest.f719wj);
        C0326b.m607a(parcel, 2, (Parcelable) trashResourceRequest.f718Do, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: Y */
    public TrashResourceRequest createFromParcel(Parcel parcel) {
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
            return new TrashResourceRequest(i, driveId);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: aD */
    public TrashResourceRequest[] newArray(int i) {
        return new TrashResourceRequest[i];
    }
}
