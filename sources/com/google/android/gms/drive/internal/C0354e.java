package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.drive.Contents;

/* renamed from: com.google.android.gms.drive.internal.e */
public class C0354e implements Creator<CloseContentsRequest> {
    /* renamed from: a */
    static void m708a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, closeContentsRequest.f670wj);
        C0326b.m607a(parcel, 2, (Parcelable) closeContentsRequest.f668Dq, i, false);
        C0326b.m608a(parcel, 3, closeContentsRequest.f669Dr, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: F */
    public CloseContentsRequest createFromParcel(Parcel parcel) {
        Boolean d;
        Contents contents;
        int i;
        Boolean bool = null;
        int o = C0324a.m584o(parcel);
        int i2 = 0;
        Contents contents2 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    Boolean bool2 = bool;
                    contents = contents2;
                    i = C0324a.m575g(parcel, n);
                    d = bool2;
                    break;
                case 2:
                    i = i2;
                    Contents contents3 = (Contents) C0324a.m564a(parcel, n, Contents.CREATOR);
                    d = bool;
                    contents = contents3;
                    break;
                case 3:
                    d = C0324a.m572d(parcel, n);
                    contents = contents2;
                    i = i2;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    d = bool;
                    contents = contents2;
                    i = i2;
                    break;
            }
            i2 = i;
            contents2 = contents;
            bool = d;
        }
        if (parcel.dataPosition() == o) {
            return new CloseContentsRequest(i2, contents2, bool);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: ak */
    public CloseContentsRequest[] newArray(int i) {
        return new CloseContentsRequest[i];
    }
}
