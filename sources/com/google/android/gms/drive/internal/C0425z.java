package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.z */
public class C0425z implements Creator<OnContentsResponse> {
    /* renamed from: a */
    static void m883a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, onContentsResponse.f690wj);
        C0326b.m607a(parcel, 2, (Parcelable) onContentsResponse.f689CW, i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: N */
    public OnContentsResponse createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    contents = (Contents) C0324a.m564a(parcel, n, Contents.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new OnContentsResponse(i, contents);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: as */
    public OnContentsResponse[] newArray(int i) {
        return new OnContentsResponse[i];
    }
}
