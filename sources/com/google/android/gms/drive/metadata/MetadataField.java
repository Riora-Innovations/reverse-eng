package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.C0766er;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class MetadataField<T> {

    /* renamed from: Eg */
    private final String f807Eg;

    /* renamed from: Eh */
    private final Set<String> f808Eh;

    /* renamed from: Ei */
    private final int f809Ei;

    protected MetadataField(String fieldName, int versionAdded) {
        this.f807Eg = (String) C0766er.m1975b(fieldName, (Object) "fieldName");
        this.f808Eh = Collections.singleton(fieldName);
        this.f809Ei = versionAdded;
    }

    protected MetadataField(String fieldName, Collection<String> dataHolderFieldNames, int versionAdded) {
        this.f807Eg = (String) C0766er.m1975b(fieldName, (Object) "fieldName");
        this.f808Eh = Collections.unmodifiableSet(new HashSet(dataHolderFieldNames));
        this.f809Ei = versionAdded;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo3808a(Bundle bundle, T t);

    /* renamed from: a */
    public final void mo3809a(DataHolder dataHolder, MetadataBundle metadataBundle, int i, int i2) {
        C0766er.m1975b(dataHolder, (Object) "dataHolder");
        C0766er.m1975b(metadataBundle, (Object) "bundle");
        metadataBundle.mo3819b(this, mo3811c(dataHolder, i, i2));
    }

    /* renamed from: a */
    public final void mo3810a(T t, Bundle bundle) {
        C0766er.m1975b(bundle, (Object) "bundle");
        if (t == null) {
            bundle.putString(getName(), null);
        } else {
            mo3808a(bundle, t);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract T mo3807b(DataHolder dataHolder, int i, int i2);

    /* renamed from: c */
    public final T mo3811c(DataHolder dataHolder, int i, int i2) {
        for (String hasNull : this.f808Eh) {
            if (dataHolder.hasNull(hasNull, i, i2)) {
                return null;
            }
        }
        return mo3807b(dataHolder, i, i2);
    }

    /* renamed from: d */
    public final T mo3812d(Bundle bundle) {
        C0766er.m1975b(bundle, (Object) "bundle");
        if (bundle.get(getName()) != null) {
            return mo3813e(bundle);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public abstract T mo3813e(Bundle bundle);

    /* renamed from: ff */
    public final Collection<String> mo3814ff() {
        return this.f808Eh;
    }

    public final String getName() {
        return this.f807Eg;
    }

    public final int getVersionAdded() {
        return this.f809Ei;
    }

    public String toString() {
        return this.f807Eg;
    }
}
