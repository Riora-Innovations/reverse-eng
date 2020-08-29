package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

public abstract class CollectionMetadataField<T> extends MetadataField<Collection<T>> {
    protected CollectionMetadataField(String fieldName, int versionAdded) {
        super(fieldName, versionAdded);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Collection<T> mo3807b(DataHolder dataHolder, int i, int i2) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
