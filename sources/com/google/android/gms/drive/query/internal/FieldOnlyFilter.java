package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class FieldOnlyFilter implements SafeParcelable, Filter {
    public static final Creator<FieldOnlyFilter> CREATOR = new C0438b();

    /* renamed from: EP */
    final MetadataBundle f823EP;

    /* renamed from: EQ */
    private final MetadataField<?> f824EQ;

    /* renamed from: wj */
    final int f825wj;

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.f825wj = versionCode;
        this.f823EP = value;
        this.f824EQ = C0440d.m969b(value);
    }

    public FieldOnlyFilter(MetadataField<?> field) {
        this(1, MetadataBundle.m896a(field, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0438b.m963a(this, out, flags);
    }
}
