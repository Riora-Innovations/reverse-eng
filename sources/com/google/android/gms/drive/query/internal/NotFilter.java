package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class NotFilter implements SafeParcelable, Filter {
    public static final Creator<NotFilter> CREATOR = new C0443g();

    /* renamed from: EZ */
    final FilterHolder f840EZ;

    /* renamed from: wj */
    final int f841wj;

    NotFilter(int versionCode, FilterHolder toNegate) {
        this.f841wj = versionCode;
        this.f840EZ = toNegate;
    }

    public NotFilter(Filter toNegate) {
        this(1, new FilterHolder(toNegate));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0443g.m976a(this, out, flags);
    }
}
