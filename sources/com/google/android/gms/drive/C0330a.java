package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.drive.a */
public class C0330a implements Creator<Contents> {
    /* renamed from: a */
    static void m632a(Contents contents, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, contents.f629wj);
        C0326b.m607a(parcel, 2, (Parcelable) contents.f623AC, i, false);
        C0326b.m619c(parcel, 3, contents.f624CQ);
        C0326b.m619c(parcel, 4, contents.f625CR);
        C0326b.m607a(parcel, 5, (Parcelable) contents.f626CS, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: ad */
    public Contents[] newArray(int i) {
        return new Contents[i];
    }

    /* renamed from: y */
    public Contents createFromParcel(Parcel parcel) {
        DriveId driveId = null;
        int i = 0;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i3 = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0324a.m564a(parcel, n, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                case 4:
                    i = C0324a.m575g(parcel, n);
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
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
