package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.h */
public class C0357h implements Creator<CreateFileRequest> {
    /* renamed from: a */
    static void m717a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, createFileRequest.f680wj);
        C0326b.m607a(parcel, 2, (Parcelable) createFileRequest.f679Dt, i, false);
        C0326b.m607a(parcel, 3, (Parcelable) createFileRequest.f678Ds, i, false);
        C0326b.m607a(parcel, 4, (Parcelable) createFileRequest.f677Dq, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: I */
    public CreateFileRequest createFromParcel(Parcel parcel) {
        Contents contents;
        MetadataBundle metadataBundle;
        DriveId driveId;
        int i;
        Contents contents2 = null;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        MetadataBundle metadataBundle2 = null;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    Contents contents3 = contents2;
                    metadataBundle = metadataBundle2;
                    driveId = driveId2;
                    i = C0324a.m575g(parcel, n);
                    contents = contents3;
                    break;
                case 2:
                    i = i2;
                    MetadataBundle metadataBundle3 = metadataBundle2;
                    driveId = (DriveId) C0324a.m564a(parcel, n, DriveId.CREATOR);
                    contents = contents2;
                    metadataBundle = metadataBundle3;
                    break;
                case 3:
                    driveId = driveId2;
                    i = i2;
                    Contents contents4 = contents2;
                    metadataBundle = (MetadataBundle) C0324a.m564a(parcel, n, MetadataBundle.CREATOR);
                    contents = contents4;
                    break;
                case 4:
                    contents = (Contents) C0324a.m564a(parcel, n, Contents.CREATOR);
                    metadataBundle = metadataBundle2;
                    driveId = driveId2;
                    i = i2;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    contents = contents2;
                    metadataBundle = metadataBundle2;
                    driveId = driveId2;
                    i = i2;
                    break;
            }
            i2 = i;
            driveId2 = driveId;
            metadataBundle2 = metadataBundle;
            contents2 = contents;
        }
        if (parcel.dataPosition() == o) {
            return new CreateFileRequest(i2, driveId2, metadataBundle2, contents2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: an */
    public CreateFileRequest[] newArray(int i) {
        return new CreateFileRequest[i];
    }
}