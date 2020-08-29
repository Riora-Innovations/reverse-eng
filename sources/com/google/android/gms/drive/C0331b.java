package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* renamed from: com.google.android.gms.drive.b */
public final class C0331b extends Metadata {

    /* renamed from: CZ */
    private final MetadataBundle f652CZ;

    public C0331b(MetadataBundle metadataBundle) {
        this.f652CZ = metadataBundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public <T> T mo3488a(MetadataField<T> metadataField) {
        return this.f652CZ.mo3818a(metadataField);
    }

    /* renamed from: eQ */
    public Metadata freeze() {
        return new C0331b(MetadataBundle.m897a(this.f652CZ));
    }

    public boolean isDataValid() {
        return this.f652CZ != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.f652CZ + "]";
    }
}
