package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0766er;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new C0431f();

    /* renamed from: Ek */
    final Bundle f810Ek;

    /* renamed from: wj */
    final int f811wj;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.f811wj = versionCode;
        this.f810Ek = (Bundle) C0766er.m1977f(valueBundle);
        this.f810Ek.setClassLoader(getClass().getClassLoader());
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.f810Ek.keySet()) {
            if (C0428c.m914ar(str) == null) {
                arrayList.add(str);
                Log.w("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String remove : arrayList) {
            this.f810Ek.remove(remove);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    /* renamed from: a */
    public static <T> MetadataBundle m896a(MetadataField<T> metadataField, T t) {
        MetadataBundle fh = m898fh();
        fh.mo3819b(metadataField, t);
        return fh;
    }

    /* renamed from: a */
    public static MetadataBundle m897a(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.f810Ek));
    }

    /* renamed from: fh */
    public static MetadataBundle m898fh() {
        return new MetadataBundle(new Bundle());
    }

    /* renamed from: a */
    public <T> T mo3818a(MetadataField<T> metadataField) {
        return metadataField.mo3812d(this.f810Ek);
    }

    /* renamed from: b */
    public <T> void mo3819b(MetadataField<T> metadataField, T t) {
        if (C0428c.m914ar(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.mo3810a(t, this.f810Ek);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.f810Ek.keySet();
        if (!keySet.equals(metadataBundle.f810Ek.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!C0762ep.equal(this.f810Ek.get(str), metadataBundle.f810Ek.get(str))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: fi */
    public Set<MetadataField<?>> mo3822fi() {
        HashSet hashSet = new HashSet();
        for (String ar : this.f810Ek.keySet()) {
            hashSet.add(C0428c.m914ar(ar));
        }
        return hashSet;
    }

    public int hashCode() {
        int i = 1;
        Iterator it = this.f810Ek.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            int i3 = i2 * 31;
            i = this.f810Ek.get((String) it.next()).hashCode() + i3;
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.f810Ek + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0431f.m929a(this, dest, flags);
    }
}
