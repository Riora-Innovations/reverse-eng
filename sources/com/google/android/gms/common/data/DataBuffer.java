package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class DataBuffer<T> implements Iterable<T> {

    /* renamed from: zU */
    protected final DataHolder f561zU;

    protected DataBuffer(DataHolder dataHolder) {
        this.f561zU = dataHolder;
        if (this.f561zU != null) {
            this.f561zU.mo3334c(this);
        }
    }

    public void close() {
        if (this.f561zU != null) {
            this.f561zU.close();
        }
    }

    public int describeContents() {
        return 0;
    }

    public abstract T get(int i);

    public int getCount() {
        if (this.f561zU == null) {
            return 0;
        }
        return this.f561zU.getCount();
    }

    public Bundle getMetadata() {
        return this.f561zU.getMetadata();
    }

    public boolean isClosed() {
        if (this.f561zU == null) {
            return true;
        }
        return this.f561zU.isClosed();
    }

    public Iterator<T> iterator() {
        return new C0311a(this);
    }
}
