package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.List;

/* renamed from: com.google.android.gms.cast.a */
public class C0290a implements Creator<ApplicationMetadata> {
    /* renamed from: a */
    static void m409a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, applicationMetadata.getVersionCode());
        C0326b.m609a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0326b.m609a(parcel, 3, applicationMetadata.getName(), false);
        C0326b.m618b(parcel, 4, applicationMetadata.getImages(), false);
        C0326b.m610a(parcel, 5, applicationMetadata.f374wm, false);
        C0326b.m609a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0326b.m607a(parcel, 7, (Parcelable) applicationMetadata.mo3038cR(), i, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: j */
    public ApplicationMetadata createFromParcel(Parcel parcel) {
        Uri uri = null;
        int o = C0324a.m584o(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    str3 = C0324a.m581m(parcel, n);
                    break;
                case 3:
                    str2 = C0324a.m581m(parcel, n);
                    break;
                case 4:
                    list2 = C0324a.m570c(parcel, n, WebImage.CREATOR);
                    break;
                case 5:
                    list = C0324a.m595y(parcel, n);
                    break;
                case 6:
                    str = C0324a.m581m(parcel, n);
                    break;
                case 7:
                    uri = (Uri) C0324a.m564a(parcel, n, Uri.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: w */
    public ApplicationMetadata[] newArray(int i) {
        return new ApplicationMetadata[i];
    }
}
