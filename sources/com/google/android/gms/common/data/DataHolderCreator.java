package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

public class DataHolderCreator implements Creator<DataHolder> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m512a(DataHolder dataHolder, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m615a(parcel, 1, dataHolder.mo3337dH(), false);
        C0326b.m619c(parcel, 1000, dataHolder.getVersionCode());
        C0326b.m614a(parcel, 2, (T[]) dataHolder.mo3338dI(), i, false);
        C0326b.m619c(parcel, 3, dataHolder.getStatusCode());
        C0326b.m604a(parcel, 4, dataHolder.getMetadata(), false);
        C0326b.m599D(parcel, p);
    }

    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int o = C0324a.m584o(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    strArr = C0324a.m594x(parcel, n);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0324a.m569b(parcel, n, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 4:
                    bundle = C0324a.m585o(parcel, n);
                    break;
                case 1000:
                    i2 = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C0325a("Overread allowed size end=" + o, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.validateContents();
        return dataHolder;
    }

    public DataHolder[] newArray(int size) {
        return new DataHolder[size];
    }
}
