package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ConflictEvent;

/* renamed from: com.google.android.gms.drive.internal.ac */
public class C0340ac implements Creator<OnEventResponse> {
    /* renamed from: a */
    static void m664a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, onEventResponse.f699wj);
        C0326b.m619c(parcel, 2, onEventResponse.f696Dm);
        C0326b.m607a(parcel, 3, (Parcelable) onEventResponse.f697Eb, i, false);
        C0326b.m607a(parcel, 4, (Parcelable) onEventResponse.f698Ec, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: Q */
    public OnEventResponse createFromParcel(Parcel parcel) {
        ConflictEvent conflictEvent;
        ChangeEvent changeEvent;
        int i;
        int i2;
        ConflictEvent conflictEvent2 = null;
        int i3 = 0;
        int o = C0324a.m584o(parcel);
        ChangeEvent changeEvent2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    ConflictEvent conflictEvent3 = conflictEvent2;
                    changeEvent = changeEvent2;
                    i = i3;
                    i2 = C0324a.m575g(parcel, n);
                    conflictEvent = conflictEvent3;
                    break;
                case 2:
                    i2 = i4;
                    ChangeEvent changeEvent3 = changeEvent2;
                    i = C0324a.m575g(parcel, n);
                    conflictEvent = conflictEvent2;
                    changeEvent = changeEvent3;
                    break;
                case 3:
                    i = i3;
                    i2 = i4;
                    ConflictEvent conflictEvent4 = conflictEvent2;
                    changeEvent = (ChangeEvent) C0324a.m564a(parcel, n, ChangeEvent.CREATOR);
                    conflictEvent = conflictEvent4;
                    break;
                case 4:
                    conflictEvent = (ConflictEvent) C0324a.m564a(parcel, n, ConflictEvent.CREATOR);
                    changeEvent = changeEvent2;
                    i = i3;
                    i2 = i4;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    conflictEvent = conflictEvent2;
                    changeEvent = changeEvent2;
                    i = i3;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            i3 = i;
            changeEvent2 = changeEvent;
            conflictEvent2 = conflictEvent;
        }
        if (parcel.dataPosition() == o) {
            return new OnEventResponse(i4, i3, changeEvent2, conflictEvent2);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: av */
    public OnEventResponse[] newArray(int i) {
        return new OnEventResponse[i];
    }
}
