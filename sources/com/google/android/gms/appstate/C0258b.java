package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.appstate.b */
public final class C0258b extends C0312b implements AppState {
    C0258b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* renamed from: cL */
    public AppState freeze() {
        return new C0257a(this);
    }

    public boolean equals(Object obj) {
        return C0257a.m324a(this, obj);
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !mo3374ab("conflict_version");
    }

    public int hashCode() {
        return C0257a.m323a(this);
    }

    public String toString() {
        return C0257a.m325b(this);
    }
}
