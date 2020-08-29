package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import java.util.Date;

/* renamed from: com.google.android.gms.drive.metadata.internal.b */
public class C0427b extends OrderedMetadataField<Date> {
    public C0427b(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3808a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Date mo3807b(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.getLong(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Date mo3813e(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
