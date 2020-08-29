package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0324a;
import com.google.android.gms.common.internal.safeparcel.C0324a.C0325a;
import com.google.android.gms.common.internal.safeparcel.C0326b;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* renamed from: a */
    static void m3573a(ActivityRecognitionResult activityRecognitionResult, Parcel parcel, int i) {
        int p = C0326b.m621p(parcel);
        C0326b.m618b(parcel, 1, activityRecognitionResult.f3168KP, false);
        C0326b.m619c(parcel, 1000, activityRecognitionResult.getVersionCode());
        C0326b.m603a(parcel, 2, activityRecognitionResult.f3169KQ);
        C0326b.m603a(parcel, 3, activityRecognitionResult.f3170KR);
        C0326b.m599D(parcel, p);
    }

    public ActivityRecognitionResult createFromParcel(Parcel parcel) {
        long j = 0;
        int o = C0324a.m584o(parcel);
        int i = 0;
        ArrayList arrayList = null;
        long j2 = 0;
        while (parcel.dataPosition() < o) {
            int n = C0324a.m582n(parcel);
            switch (C0324a.m562S(n)) {
                case 1:
                    arrayList = C0324a.m570c(parcel, n, DetectedActivity.CREATOR);
                    break;
                case 2:
                    j2 = C0324a.m576h(parcel, n);
                    break;
                case 3:
                    j = C0324a.m576h(parcel, n);
                    break;
                case 1000:
                    i = C0324a.m575g(parcel, n);
                    break;
                default:
                    C0324a.m568b(parcel, n);
                    break;
            }
        }
        if (parcel.dataPosition() == o) {
            return new ActivityRecognitionResult(i, arrayList, j2, j);
        }
        throw new C0325a("Overread allowed size end=" + o, parcel);
    }

    public ActivityRecognitionResult[] newArray(int size) {
        return new ActivityRecognitionResult[size];
    }
}
