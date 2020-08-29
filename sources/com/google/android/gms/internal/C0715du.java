package com.google.android.gms.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.du */
public class C0715du {

    /* renamed from: ye */
    private static boolean f1943ye = false;
    private final String mTag;

    /* renamed from: yf */
    private boolean f1944yf;

    /* renamed from: yg */
    private boolean f1945yg;

    /* renamed from: yh */
    private String f1946yh;

    public C0715du(String str) {
        this(str, m1759di());
    }

    public C0715du(String str, boolean z) {
        this.mTag = str;
        this.f1944yf = z;
        this.f1945yg = false;
    }

    /* renamed from: di */
    public static boolean m1759di() {
        return f1943ye;
    }

    /* renamed from: e */
    private String m1760e(String str, Object... objArr) {
        String format = String.format(str, objArr);
        return this.f1946yh != null ? this.f1946yh + format : format;
    }

    /* renamed from: U */
    public void mo4958U(String str) {
        this.f1946yh = String.format("[%s] ", new Object[]{str});
    }

    /* renamed from: a */
    public void mo4959a(String str, Object... objArr) {
        if (mo4965dh()) {
            Log.v(this.mTag, m1760e(str, objArr));
        }
    }

    /* renamed from: a */
    public void mo4960a(Throwable th, String str, Object... objArr) {
        if (mo4964dg() || f1943ye) {
            Log.d(this.mTag, m1760e(str, objArr), th);
        }
    }

    /* renamed from: b */
    public void mo4961b(String str, Object... objArr) {
        if (mo4964dg() || f1943ye) {
            Log.d(this.mTag, m1760e(str, objArr));
        }
    }

    /* renamed from: c */
    public void mo4962c(String str, Object... objArr) {
        Log.i(this.mTag, m1760e(str, objArr));
    }

    /* renamed from: d */
    public void mo4963d(String str, Object... objArr) {
        Log.w(this.mTag, m1760e(str, objArr));
    }

    /* renamed from: dg */
    public boolean mo4964dg() {
        return this.f1944yf;
    }

    /* renamed from: dh */
    public boolean mo4965dh() {
        return this.f1945yg;
    }
}
