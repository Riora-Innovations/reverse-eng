package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.q */
class C1158q implements C1155o {

    /* renamed from: kv */
    private C1140jz f3130kv;

    /* renamed from: kw */
    private byte[] f3131kw;

    /* renamed from: kx */
    private final int f3132kx;

    public C1158q(int i) {
        this.f3132kx = i;
        reset();
    }

    /* renamed from: b */
    public void mo6434b(int i, long j) throws IOException {
        this.f3130kv.mo6400b(i, j);
    }

    /* renamed from: b */
    public void mo6435b(int i, String str) throws IOException {
        this.f3130kv.mo6401b(i, str);
    }

    public void reset() {
        this.f3131kw = new byte[this.f3132kx];
        this.f3130kv = C1140jz.m3426o(this.f3131kw);
    }

    /* renamed from: z */
    public byte[] mo6437z() throws IOException {
        int kM = this.f3130kv.mo6413kM();
        if (kM < 0) {
            throw new IOException();
        } else if (kM == 0) {
            return this.f3131kw;
        } else {
            byte[] bArr = new byte[(this.f3131kw.length - kM)];
            System.arraycopy(this.f3131kw, 0, bArr, 0, bArr.length);
            return bArr;
        }
    }
}
