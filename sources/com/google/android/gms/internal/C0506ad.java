package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.C0517ai.C0518a;

/* renamed from: com.google.android.gms.internal.ad */
public final class C0506ad extends C0518a {

    /* renamed from: lq */
    private final AppEventListener f1197lq;

    public C0506ad(AppEventListener appEventListener) {
        this.f1197lq = appEventListener;
    }

    public void onAppEvent(String name, String info) {
        this.f1197lq.onAppEvent(name, info);
    }
}
