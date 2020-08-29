package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.drive.d */
public class C0333d implements Creator<DriveId> {
    /* renamed from: a */
    static void m637a(DriveId driveId, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, driveId.f641wj);
        C0326b.m609a(parcel, 2, driveId.f637Dc, false);
        C0326b.m603a(parcel, 3, driveId.f638Dd);
        C0326b.m603a(parcel, 4, driveId.f639De);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: ae */
    public DriveId[] newArray(int i) {
        return new DriveId[i];
    }

    /* renamed from: z */
    public DriveId createFromParcel(Parcel parcel) {
        long j = 0;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 4:
                    j = C0324a.m576h(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
