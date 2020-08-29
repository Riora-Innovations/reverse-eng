package com.google.android.gms.internal;

import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.cr */
public class C0646cr {

    /* renamed from: mg */
    private final Object f1765mg = new Object();

    /* renamed from: pF */
    private int f1766pF;

    /* renamed from: pG */
    private int f1767pG;

    /* renamed from: pl */
    private final String f1768pl;

    public C0646cr(String str) {
        this.f1768pl = str;
    }

    /* renamed from: a */
    public void mo4785a(int i, int i2) {
        synchronized (this.f1765mg) {
            this.f1766pF = i;
            this.f1767pG = i2;
            C0644cp.m1486a(this.f1768pl, this);
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.f1765mg) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.f1766pF);
            bundle.putInt("pmnll", this.f1767pG);
        }
        return bundle;
    }
}
