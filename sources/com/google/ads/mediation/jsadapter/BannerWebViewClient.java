package com.google.ads.mediation.jsadapter;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.C0662da;
import java.net.URI;
import java.net.URISyntaxException;

public final class BannerWebViewClient extends WebViewClient {

    /* renamed from: A */
    private final String f45A;

    /* renamed from: B */
    private boolean f46B = false;

    /* renamed from: r */
    private final JavascriptAdapter f47r;

    public BannerWebViewClient(JavascriptAdapter adapter, String passbackUrl) {
        this.f45A = m16c(passbackUrl);
        this.f47r = adapter;
    }

    /* renamed from: b */
    private boolean m15b(String str) {
        String c = m16c(str);
        if (TextUtils.isEmpty(c)) {
            return false;
        }
        try {
            URI uri = new URI(c);
            if ("passback".equals(uri.getScheme())) {
                C0662da.m1551s("Passback received");
                this.f47r.sendAdNotReceivedUpdate();
                return true;
            } else if (TextUtils.isEmpty(this.f45A)) {
                return false;
            } else {
                URI uri2 = new URI(this.f45A);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!equals(host, host2) || !equals(path, path2)) {
                    return false;
                }
                C0662da.m1551s("Passback received");
                this.f47r.sendAdNotReceivedUpdate();
                return true;
            }
        } catch (URISyntaxException e) {
            C0662da.m1552t(e.getMessage());
            return false;
        }
    }

    /* renamed from: c */
    private String m16c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        } catch (IndexOutOfBoundsException e) {
            C0662da.m1552t(e.getMessage());
            return str;
        }
    }

    private static boolean equals(Object obj1, Object obj2) {
        return obj1 == obj2 || (obj1 != null && obj1.equals(obj2));
    }

    public void onLoadResource(WebView view, String url) {
        C0662da.m1554v("onLoadResource: " + url);
        if (!m15b(url)) {
            super.onLoadResource(view, url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        C0662da.m1554v("onPageFinished: " + url);
        super.onPageFinished(view, url);
        if (!this.f46B) {
            this.f47r.startCheckingForAd();
            this.f46B = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        C0662da.m1554v("shouldOverrideUrlLoading: " + url);
        if (!m15b(url)) {
            return false;
        }
        C0662da.m1551s("shouldOverrideUrlLoading: received passback url");
        return true;
    }
}
