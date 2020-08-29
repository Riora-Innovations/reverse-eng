package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.DriveId;

/* renamed from: com.google.android.gms.drive.events.a */
public class C0334a implements Creator<ChangeEvent> {
    /* renamed from: a */
    static void m640a(ChangeEvent changeEvent, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, changeEvent.f655wj);
        C0326b.m607a(parcel, 2, (Parcelable) changeEvent.f653CS, i, false);
        C0326b.m619c(parcel, 3, changeEvent.f654Dl);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: A */
    public ChangeEvent createFromParcel(Parcel parcel) {
        int g;
        DriveId driveId;
        int i;
        int i2 = 0;
        int o = C0324a.m584o(parcel);
        DriveId driveId2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    int i4 = i2;
                    driveId = driveId2;
                    i = C0324a.m575g(parcel, n);
                    g = i4;
                    break;
                case 2:
                    i = i3;
                    DriveId driveId3 = (DriveId) C0324a.m564a(parcel, n, DriveId.CREATOR);
                    g = i2;
                    driveId = driveId3;
                    break;
                case 3:
                    g = C0324a.m575g(parcel, n);
                    driveId = driveId2;
                    i = i3;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    g = i2;
                    driveId = driveId2;
                    i = i3;
                    break;
            }
            i3 = i;
            driveId2 = driveId;
            i2 = g;
        }
        if (parcel.dataPosition() == o) {
            return new ChangeEvent(i3, driveId2, i2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: af */
    public ChangeEvent[] newArray(int i) {
        return new ChangeEvent[i];
    }
}
