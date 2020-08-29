package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.internal.ah */
public class C0345ah implements Creator<OpenFileIntentSenderRequest> {
    /* renamed from: a */
    static void m679a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, openFileIntentSenderRequest.f712wj);
        C0326b.m609a(parcel, 2, openFileIntentSenderRequest.f709CX, false);
        C0326b.m615a(parcel, 3, openFileIntentSenderRequest.f711Dk, false);
        C0326b.m607a(parcel, 4, (Parcelable) openFileIntentSenderRequest.f710CY, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: V */
    public OpenFileIntentSenderRequest createFromParcel(Parcel parcel) {
        DriveId driveId = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
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
                    strArr = C0324a.m594x(parcel, n);
                    break;
                case 4:
                    driveId = (DriveId) C0324a.m564a(parcel, n, DriveId.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: aA */
    public OpenFileIntentSenderRequest[] newArray(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
