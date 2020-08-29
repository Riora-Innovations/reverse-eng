package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Query;

public class QueryRequest implements SafeParcelable {
    public static final Creator<QueryRequest> CREATOR = new C0346ai();

    /* renamed from: Ef */
    final Query f713Ef;

    /* renamed from: wj */
    final int f714wj;

    QueryRequest(int versionCode, Query query) {
        this.f714wj = versionCode;
        this.f713Ef = query;
    }

    public QueryRequest(Query query) {
        this(1, query);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0346ai.m682a(this, dest, flags);
    }
}
