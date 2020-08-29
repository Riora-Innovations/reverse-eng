package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.internal.j */
public final class C0359j extends Metadata {

    /* renamed from: CZ */
    private final MetadataBundle f724CZ;

    public C0359j(MetadataBundle metadataBundle) {
        this.f724CZ = metadataBundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T> T mo3488a(MetadataField<T> metadataField) {
        return this.f724CZ.mo3818a(metadataField);
    }

    /* renamed from: eQ */
    public Metadata freeze() {
        return new C0359j(MetadataBundle.m897a(this.f724CZ));
    }

    public boolean isDataValid() {
        return this.f724CZ != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.f724CZ + "]";
    }
}
