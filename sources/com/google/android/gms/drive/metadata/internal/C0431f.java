package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.drive.metadata.internal.f */
public class C0431f implements Creator<MetadataBundle> {
    /* renamed from: a */
    static void m929a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, metadataBundle.f811wj);
        C0326b.m604a(parcel, 2, metadataBundle.f810Ek, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: aF */
    public MetadataBundle[] newArray(int i) {
        return new MetadataBundle[i];
    }

    /* renamed from: aa */
    public MetadataBundle createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    bundle = C0324a.m585o(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
