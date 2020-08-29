package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0762ep;

/* renamed from: com.google.android.gms.location.b */
public class C1177b implements SafeParcelable {
    public static final C1178c CREATOR = new C1178c();

    /* renamed from: Lh */
    int f3193Lh;

    /* renamed from: Li */
    int f3194Li;

    /* renamed from: Lj */
    long f3195Lj;

    /* renamed from: wj */
    private final int f3196wj;

    C1177b(int i, int i2, int i3, long j) {
        this.f3196wj = i;
        this.f3193Lh = i2;
        this.f3194Li = i3;
        this.f3195Lj = j;
    }

    /* renamed from: bk */
    private String m3583bk(int i) {
        switch (i) {
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
            case 8:
                return "STATUS_IN_PROGRESS";
            default:
                return "STATUS_UNKNOWN";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C1177b)) {
            return false;
        }
        C1177b bVar = (C1177b) other;
        return this.f3193Lh == bVar.f3193Lh && this.f3194Li == bVar.f3194Li && this.f3195Lj == bVar.f3195Lj;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3196wj;
    }

    public int hashCode() {
        return C0762ep.hashCode(Integer.valueOf(this.f3193Lh), Integer.valueOf(this.f3194Li), Long.valueOf(this.f3195Lj));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocationStatus[cell status: ").append(m3583bk(this.f3193Lh));
        sb.append(", wifi status: ").append(m3583bk(this.f3194Li));
        sb.append(", elapsed realtime ns: ").append(this.f3195Lj);
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1178c.m3584a(this, parcel, flags);
    }
}
