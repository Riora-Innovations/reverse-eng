package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;

/* renamed from: com.google.android.gms.common.images.b */
public class C0323b implements Creator<WebImage> {
    /* renamed from: a */
    static void m558a(WebImage webImage, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, webImage.getVersionCode());
        C0326b.m607a(parcel, 2, (Parcelable) webImage.getUrl(), i, false);
        C0326b.m619c(parcel, 3, webImage.getWidth());
        C0326b.m619c(parcel, 4, webImage.getHeight());
        C0326b.m599D(parcel, p);
    }

    /* renamed from: M */
    public WebImage[] newArray(int i) {
        return new WebImage[i];
    }

    /* renamed from: l */
    public WebImage createFromParcel(Parcel parcel) {
        int g;
        int i;
        Uri uri;
        int i2;
        int i3 = 0;
        int o = C0324a.m584o(parcel);
        Uri uri2 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    int i6 = i3;
                    i = i4;
                    uri = uri2;
                    i2 = C0324a.m575g(parcel, n);
                    g = i6;
                    break;
                case 2:
                    i2 = i5;
                    int i7 = i4;
                    uri = (Uri) C0324a.m564a(parcel, n, Uri.CREATOR);
                    g = i3;
                    i = i7;
                    break;
                case 3:
                    uri = uri2;
                    i2 = i5;
                    int i8 = i3;
                    i = C0324a.m575g(parcel, n);
                    g = i8;
                    break;
                case 4:
                    g = C0324a.m575g(parcel, n);
                    i = i4;
                    uri = uri2;
                    i2 = i5;
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    g = i3;
                    i = i4;
                    uri = uri2;
                    i2 = i5;
                    break;
            }
            i5 = i2;
            uri2 = uri;
            i4 = i;
            i3 = g;
        }
        if (parcel.dataPosition() == o) {
            return new WebImage(i5, uri2, i4, i3);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }
}
