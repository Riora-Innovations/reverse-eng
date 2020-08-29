package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.Collection;

/* renamed from: com.google.android.gms.drive.metadata.internal.h */
public abstract class C0433h<T extends Parcelable> extends MetadataField<T> {
    public C0433h(String str, Collection<String> collection, int i) {
        super(str, collection, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3808a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public T mo3813e(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
