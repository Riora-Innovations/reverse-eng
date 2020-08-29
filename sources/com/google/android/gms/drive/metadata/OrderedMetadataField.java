package com.google.android.gms.drive.metadata;

import java.lang.Comparable;

public abstract class OrderedMetadataField<T extends Comparable<T>> extends MetadataField<T> {
    protected OrderedMetadataField(String fieldName, int versionAdded) {
        super(fieldName, versionAdded);
    }
}
