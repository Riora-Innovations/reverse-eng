package com.google.android.gms.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.el */
public final class C0752el {

    /* renamed from: Cd */
    private final String f2051Cd;

    public C0752el(String str) {
        this.f2051Cd = (String) C0766er.m1977f(str);
    }

    /* renamed from: Q */
    public boolean mo5081Q(int i) {
        return Log.isLoggable(this.f2051Cd, i);
    }

    /* renamed from: a */
    public void mo5082a(String str, String str2, Throwable th) {
        if (mo5081Q(6)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: f */
    public void mo5083f(String str, String str2) {
        if (mo5081Q(2)) {
            Log.v(str, str2);
        }
    }

    /* renamed from: g */
    public void mo5084g(String str, String str2) {
        if (mo5081Q(5)) {
            Log.w(str, str2);
        }
    }

    /* renamed from: h */
    public void mo5085h(String str, String str2) {
        if (mo5081Q(6)) {
            Log.e(str, str2);
        }
    }
}
