package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;

/* renamed from: com.google.android.gms.internal.cx */
public final class C0657cx {
    /* renamed from: a */
    public static void m1531a(Context context, WebSettings webSettings) {
        C0656cw.m1525a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    public static String getDefaultUserAgent(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }
}
