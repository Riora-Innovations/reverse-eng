package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.i */
public abstract class C1046i implements C0997h {

    /* renamed from: jY */
    protected MotionEvent f2852jY;

    /* renamed from: jZ */
    protected DisplayMetrics f2853jZ;

    /* renamed from: ka */
    protected C1154n f2854ka;

    /* renamed from: kb */
    private C1155o f2855kb;

    protected C1046i(Context context, C1154n nVar, C1155o oVar) {
        this.f2854ka = nVar;
        this.f2855kb = oVar;
        try {
            this.f2853jZ = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f2853jZ = new DisplayMetrics();
            this.f2853jZ.density = 1.0f;
        }
    }

    /* renamed from: a */
    private String m3079a(Context context, String str, boolean z) {
        byte[] u;
        try {
            synchronized (this) {
                m3080t();
                if (z) {
                    mo5833c(context);
                } else {
                    mo5832b(context);
                }
                u = m3081u();
            }
            return u.length == 0 ? Integer.toString(5) : mo5828a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    /* renamed from: t */
    private void m3080t() {
        this.f2855kb.reset();
    }

    /* renamed from: u */
    private byte[] m3081u() throws IOException {
        return this.f2855kb.mo6437z();
    }

    /* renamed from: a */
    public String mo5631a(Context context) {
        return m3079a(context, (String) null, false);
    }

    /* renamed from: a */
    public String mo5632a(Context context, String str) {
        return m3079a(context, str, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo5828a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] array;
        if (bArr.length > 239) {
            m3080t();
            mo5829a(20, 1);
            bArr = m3081u();
        }
        if (bArr.length < 239) {
            byte[] bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(array);
        byte[] array2 = ByteBuffer.allocate(256).put(instance.digest()).put(array).array();
        byte[] bArr3 = new byte[256];
        new C0776f().mo5157a(array2, bArr3);
        if (str != null && str.length() > 0) {
            mo5831a(str, bArr3);
        }
        return this.f2854ka.mo4987a(bArr3, true);
    }

    /* renamed from: a */
    public void mo5633a(int i, int i2, int i3) {
        if (this.f2852jY != null) {
            this.f2852jY.recycle();
        }
        this.f2852jY = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f2853jZ.density, ((float) i2) * this.f2853jZ.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5829a(int i, long j) throws IOException {
        this.f2855kb.mo6434b(i, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5830a(int i, String str) throws IOException {
        this.f2855kb.mo6435b(i, str);
    }

    /* renamed from: a */
    public void mo5634a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f2852jY != null) {
                this.f2852jY.recycle();
            }
            this.f2852jY = MotionEvent.obtain(motionEvent);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo5831a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new C1138jx(str.getBytes("UTF-8")).mo6367m(bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo5832b(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo5833c(Context context);
}
