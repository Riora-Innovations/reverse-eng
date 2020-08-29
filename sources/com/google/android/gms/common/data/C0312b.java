package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0766er;

/* renamed from: com.google.android.gms.common.data.b */
public abstract class C0312b {

    /* renamed from: zU */
    protected final DataHolder f581zU;

    /* renamed from: zW */
    protected final int f582zW;

    /* renamed from: zX */
    private final int f583zX;

    public C0312b(DataHolder dataHolder, int i) {
        this.f581zU = (DataHolder) C0766er.m1977f(dataHolder);
        C0766er.m1978v(i >= 0 && i < dataHolder.getCount());
        this.f582zW = i;
        this.f583zX = dataHolder.mo3333I(this.f582zW);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3372a(String str, CharArrayBuffer charArrayBuffer) {
        this.f581zU.copyToBuffer(str, this.f582zW, this.f583zX, charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aa */
    public Uri mo3373aa(String str) {
        return this.f581zU.parseUri(str, this.f582zW, this.f583zX);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ab */
    public boolean mo3374ab(String str) {
        return this.f581zU.hasNull(str, this.f582zW, this.f583zX);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0312b)) {
            return false;
        }
        C0312b bVar = (C0312b) obj;
        return C0762ep.equal(Integer.valueOf(bVar.f582zW), Integer.valueOf(this.f582zW)) && C0762ep.equal(Integer.valueOf(bVar.f583zX), Integer.valueOf(this.f583zX)) && bVar.f581zU == this.f581zU;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String column) {
        return this.f581zU.getBoolean(column, this.f582zW, this.f583zX);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String column) {
        return this.f581zU.getByteArray(column, this.f582zW, this.f583zX);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String column) {
        return this.f581zU.getInteger(column, this.f582zW, this.f583zX);
    }

    /* access modifiers changed from: protected */
    public long getLong(String column) {
        return this.f581zU.getLong(column, this.f582zW, this.f583zX);
    }

    /* access modifiers changed from: protected */
    public String getString(String column) {
        return this.f581zU.getString(column, this.f582zW, this.f583zX);
    }

    public boolean hasColumn(String column) {
        return this.f581zU.hasColumn(column);
    }

    public int hashCode() {
        return C0762ep.hashCode(Integer.valueOf(this.f582zW), Integer.valueOf(this.f583zX), this.f581zU);
    }

    public boolean isDataValid() {
        return !this.f581zU.isClosed();
    }
}
