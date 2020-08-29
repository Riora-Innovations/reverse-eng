package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.b */
public class C0335b implements Creator<ConflictEvent> {
    /* renamed from: a */
    static void m643a(ConflictEvent conflictEvent, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, conflictEvent.f657wj);
        C0326b.m607a(parcel, 2, (Parcelable) conflictEvent.f656CS, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: B */
    public ConflictEvent createFromParcel(Parcel parcel) {
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
            return new ConflictEvent(i, driveId);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ag */
    public ConflictEvent[] newArray(int i) {
        return new ConflictEvent[i];
    }
}
