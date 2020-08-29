package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.e */
public class C0430e extends MetadataField<Long> {
    public C0430e(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3808a(Bundle bundle, Long l) {
        bundle.putLong(getName(), l.longValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Long mo3807b(DataHolder dataHolder, int i, int i2) {
        return Long.valueOf(dataHolder.getLong(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public Long mo3813e(Bundle bundle) {
        return Long.valueOf(bundle.getLong(getName()));
    }
}
