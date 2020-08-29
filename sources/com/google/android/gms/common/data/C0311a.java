package com.google.android.gms.common.data;

import com.google.android.gms.internal.C0766er;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.a */
public final class C0311a<T> implements Iterator<T> {
    private final DataBuffer<T> mDataBuffer;

    /* renamed from: zV */
    private int f580zV = -1;

    public C0311a(DataBuffer<T> dataBuffer) {
        this.mDataBuffer = (DataBuffer) C0766er.m1977f(dataBuffer);
    }

    public boolean hasNext() {
        return this.f580zV < this.mDataBuffer.getCount() + -1;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f580zV);
        }
        DataBuffer<T> dataBuffer = this.mDataBuffer;
        int i = this.f580zV + 1;
        this.f580zV = i;
        return dataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
