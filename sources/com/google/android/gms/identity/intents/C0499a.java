package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.identity.intents.a */
public class C0499a implements Creator<UserAddressRequest> {
    /* renamed from: a */
    static void m1139a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m619c(parcel, 1, userAddressRequest.getVersionCode());
        C0326b.m618b(parcel, 2, userAddressRequest.f1095Ky, false);
        C0326b.m599D(parcel, p);
    }

    /* renamed from: ar */
    public UserAddressRequest createFromParcel(Parcel parcel) {
        int o = C0324a.m584o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    i = C0324a.m575g(parcel, n);
                    break;
                case 2:
                    arrayList = C0324a.m570c(parcel, n, CountrySpecification.CREATOR);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new UserAddressRequest(i, arrayList);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    /* renamed from: be */
    public UserAddressRequest[] newArray(int i) {
        return new UserAddressRequest[i];
    }
}
