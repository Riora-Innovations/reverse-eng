package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder implements SafeParcelable {
    public static final Creator<FilterHolder> CREATOR = new C0439c();

    /* renamed from: ER */
    final ComparisonFilter<?> f826ER;

    /* renamed from: ES */
    final FieldOnlyFilter f827ES;

    /* renamed from: ET */
    final LogicalFilter f828ET;

    /* renamed from: EU */
    final NotFilter f829EU;

    /* renamed from: EV */
    final InFilter<?> f830EV;

    /* renamed from: EW */
    private final Filter f831EW;

    /* renamed from: wj */
    final int f832wj;

    FilterHolder(int versionCode, ComparisonFilter<?> comparisonField, FieldOnlyFilter fieldOnlyFilter, LogicalFilter logicalFilter, NotFilter notFilter, InFilter<?> containsFilter) {
        this.f832wj = versionCode;
        this.f826ER = comparisonField;
        this.f827ES = fieldOnlyFilter;
        this.f828ET = logicalFilter;
        this.f829EU = notFilter;
        this.f830EV = containsFilter;
        if (this.f826ER != null) {
            this.f831EW = this.f826ER;
        } else if (this.f827ES != null) {
            this.f831EW = this.f827ES;
        } else if (this.f828ET != null) {
            this.f831EW = this.f828ET;
        } else if (this.f829EU != null) {
            this.f831EW = this.f829EU;
        } else if (this.f830EV != null) {
            this.f831EW = this.f830EV;
        } else {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
    }

    public FilterHolder(Filter filter) {
        this.f832wj = 1;
        this.f826ER = filter instanceof ComparisonFilter ? (ComparisonFilter) filter : null;
        this.f827ES = filter instanceof FieldOnlyFilter ? (FieldOnlyFilter) filter : null;
        this.f828ET = filter instanceof LogicalFilter ? (LogicalFilter) filter : null;
        this.f829EU = filter instanceof NotFilter ? (NotFilter) filter : null;
        this.f830EV = filter instanceof InFilter ? (InFilter) filter : null;
        if (this.f826ER == null && this.f827ES == null && this.f828ET == null && this.f829EU == null && this.f830EV == null) {
            throw new IllegalArgumentException("Invalid filter type or null filter.");
        }
        this.f831EW = filter;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0439c.m966a(this, out, flags);
    }
}
