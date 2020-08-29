package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.g */
public class C0356g implements Creator<CreateFileIntentSenderRequest> {
    /* renamed from: a */
    static void m714a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, createFileIntentSenderRequest.f676wj);
        C0326b.m607a(parcel, 2, (Parcelable) createFileIntentSenderRequest.f675Ds, i, false);
        C0326b.m619c(parcel, 3, createFileIntentSenderRequest.f672CQ);
        C0326b.m609a(parcel, 4, createFileIntentSenderRequest.f673CX, false);
        C0326b.m607a(parcel, 5, (Parcelable) createFileIntentSenderRequest.f674CY, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: H */
    public CreateFileIntentSenderRequest createFromParcel(Parcel parcel) {
        int i = 0;
        DriveId driveId = null;
        int o = C0324a.m584o(parcel);
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0324a.m564a(parcel, n, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 4:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 5:
                    driveId = (DriveId) C0324a.m564a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: am */
    public CreateFileIntentSenderRequest[] newArray(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
