package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;

/* renamed from: com.google.android.gms.drive.metadata.internal.d */
public class C0429d extends MetadataField<Integer> {
    public C0429d(String str, int i) {
        super(str, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3808a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Integer mo3807b(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.getInteger(getName(), i, i2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public Integer mo3813e(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
