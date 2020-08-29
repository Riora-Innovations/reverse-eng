package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;

public class Query implements SafeParcelable {
    public static final Creator<Query> CREATOR = new C0436a();

    /* renamed from: EL */
    LogicalFilter f813EL;

    /* renamed from: EM */
    String f814EM;

    /* renamed from: wj */
    final int f815wj;

    public static class Builder {

        /* renamed from: EM */
        private String f816EM;

        /* renamed from: EN */
        private final List<Filter> f817EN = new ArrayList();

        public Builder addFilter(Filter filter) {
            this.f817EN.add(filter);
            return this;
        }

        public Query build() {
            return new Query(new LogicalFilter(Operator.f847Ff, this.f817EN), this.f816EM);
        }

        public Builder setPageToken(String token) {
            this.f816EM = token;
            return this;
        }
    }

    Query(int versionCode, LogicalFilter clause, String pageToken) {
        this.f815wj = versionCode;
        this.f813EL = clause;
        this.f814EM = pageToken;
    }

    Query(LogicalFilter clause, String pageToken) {
        this(1, clause, pageToken);
    }

    public int describeContents() {
        return 0;
    }

    public Filter getFilter() {
        return this.f813EL;
    }

    public String getPageToken() {
        return this.f814EM;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0436a.m957a(this, out, flags);
    }
}
