package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter implements SafeParcelable, Filter {
    public static final Creator<LogicalFilter> CREATOR = new C0442f();

    /* renamed from: EN */
    private List<Filter> f836EN;

    /* renamed from: EO */
    final Operator f837EO;

    /* renamed from: EY */
    final List<FilterHolder> f838EY;

    /* renamed from: wj */
    final int f839wj;

    LogicalFilter(int versionCode, Operator operator, List<FilterHolder> filterHolders) {
        this.f839wj = versionCode;
        this.f837EO = operator;
        this.f838EY = filterHolders;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... additionalFilters) {
        this.f839wj = 1;
        this.f837EO = operator;
        this.f838EY = new ArrayList(additionalFilters.length + 1);
        this.f838EY.add(new FilterHolder(filter));
        this.f836EN = new ArrayList(additionalFilters.length + 1);
        this.f836EN.add(filter);
        for (Filter filter2 : additionalFilters) {
            this.f838EY.add(new FilterHolder(filter2));
            this.f836EN.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> filters) {
        this.f839wj = 1;
        this.f837EO = operator;
        this.f836EN = new ArrayList();
        this.f838EY = new ArrayList();
        for (Filter filter : filters) {
            this.f836EN.add(filter);
            this.f838EY.add(new FilterHolder(filter));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0442f.m973a(this, out, flags);
    }
}
