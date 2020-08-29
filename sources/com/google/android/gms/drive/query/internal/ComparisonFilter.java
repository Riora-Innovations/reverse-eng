package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class ComparisonFilter<T> implements SafeParcelable, Filter {
    public static final C0437a CREATOR = new C0437a();

    /* renamed from: EO */
    final Operator f819EO;

    /* renamed from: EP */
    final MetadataBundle f820EP;

    /* renamed from: EQ */
    final MetadataField<T> f821EQ;

    /* renamed from: wj */
    final int f822wj;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.f822wj = versionCode;
        this.f819EO = operator;
        this.f820EP = value;
        this.f821EQ = C0440d.m969b(value);
    }

    public ComparisonFilter(Operator operator, MetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.m896a(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0437a.m960a(this, out, flags);
    }
}
