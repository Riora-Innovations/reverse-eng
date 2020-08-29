package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

/* renamed from: com.google.android.gms.drive.query.internal.d */
class C0440d {
    /* renamed from: b */
    static MetadataField<?> m969b(MetadataBundle metadataBundle) {
        Set fi = metadataBundle.mo3822fi();
        if (fi.size() == 1) {
            return (MetadataField) fi.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
