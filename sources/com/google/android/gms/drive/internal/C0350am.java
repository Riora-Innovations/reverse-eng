package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.am */
public class C0350am implements Creator<UpdateMetadataRequest> {
    /* renamed from: a */
    static void m692a(UpdateMetadataRequest updateMetadataRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, updateMetadataRequest.f722wj);
        C0326b.m607a(parcel, 2, (Parcelable) updateMetadataRequest.f720Do, i, false);
        C0326b.m607a(parcel, 3, (Parcelable) updateMetadataRequest.f721Dp, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: Z */
    public UpdateMetadataRequest createFromParcel(Parcel parcel) {
        MetadataBundle metadataBundle;
        DriveId driveId;
        int i;
        MetadataBundle metadataBundle2 = null;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle2;
                    driveId = driveId2;
                    i = C0324a.m575g(parcel, n);
                    metadataBundle = metadataBundle3;
                    break;
                case 2:
                    i = i2;
                    DriveId driveId3 = (DriveId) C0324a.m564a(parcel, n, DriveId.CREATOR);
                    metadataBundle = metadataBundle2;
                    driveId = driveId3;
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) C0324a.m564a(parcel, n, MetadataBundle.CREATOR);
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    metadataBundle = metadataBundle2;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            metadataBundle2 = metadataBundle;
        }
        if (parcel.dataPosition() == o) {
            return new UpdateMetadataRequest(i2, driveId2, metadataBundle2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: aE */
    public UpdateMetadataRequest[] newArray(int i) {
        return new UpdateMetadataRequest[i];
    }
}
