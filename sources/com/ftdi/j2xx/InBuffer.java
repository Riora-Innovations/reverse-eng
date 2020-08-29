package com.ftdi.j2xx;

import java.nio.ByteBuffer;

/* compiled from: FT_Device */
class InBuffer {
    private boolean mAcquired;
    private int mBufId;
    private ByteBuffer mBuffer;
    private int mLength;

    public InBuffer(int size) {
        this.mBuffer = ByteBuffer.allocate(size);
        setLength(0);
    }

    /* access modifiers changed from: 0000 */
    public void setBufferId(int id) {
        this.mBufId = id;
    }

    /* access modifiers changed from: 0000 */
    public int getBufferId() {
        return this.mBufId;
    }

    /* access modifiers changed from: 0000 */
    public ByteBuffer getInputBuffer() {
        return this.mBuffer;
    }

    /* access modifiers changed from: 0000 */
    public int getLength() {
        return this.mLength;
    }

    /* access modifiers changed from: 0000 */
    public void setLength(int length) {
        this.mLength = length;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void purge() {
        this.mBuffer.clear();
        setLength(0);
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean acquired() {
        return this.mAcquired;
    }

    /* access modifiers changed from: 0000 */
    public synchronized ByteBuffer acquire(int bufId) {
        ByteBuffer buffer;
        buffer = null;
        if (!this.mAcquired) {
            this.mAcquired = true;
            this.mBufId = bufId;
            buffer = this.mBuffer;
        }
        return buffer;
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean release(int bufId) {
        boolean rc;
        rc = false;
        if (this.mAcquired && bufId == this.mBufId) {
            this.mAcquired = false;
            rc = true;
        }
        return rc;
    }
}
