package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;
import java.util.Collections;

public class InFilter<T> implements SafeParcelable, Filter {
    public static final C0441e CREATOR = new C0441e();

    /* renamed from: EP */
    final MetadataBundle f833EP;

    /* renamed from: EX */
    private final CollectionMetadataField<T> f834EX;

    /* renamed from: wj */
    final int f835wj;

    InFilter(int versionCode, MetadataBundle value) {
        this.f835wj = versionCode;
        this.f833EP = value;
        this.f834EX = (CollectionMetadataField) C0440d.m969b(value);
    }

    public InFilter(CollectionMetadataField<T> field, T value) {
        this(1, MetadataBundle.m896a(field, Collections.singleton(value)));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0441e.m970a(this, out, flags);
    }
}
