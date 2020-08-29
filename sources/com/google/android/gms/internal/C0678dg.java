package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.internal.dg */
public final class C0678dg extends C0667de {
    public C0678dg(C0665dd ddVar, boolean z) {
        super(ddVar, z);
    }

    /* renamed from: d */
    private static WebResourceResponse m1594d(Context context, String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
        try {
            C0653cv.m1505a(context, str, true, httpURLConnection);
            httpURLConnection.connect();
            return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(C0653cv.m1499a((Readable) new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (!(webView instanceof C0665dd)) {
                C0662da.m1555w("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webView, url);
            }
            C0665dd ddVar = (C0665dd) webView;
            ddVar.mo4812bb().mo4830ar();
            if (ddVar.mo4804Q().f1195lo) {
                C0662da.m1554v("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                return m1594d(ddVar.getContext(), this.f1815ng.mo4814bd().f1798pU, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            } else if (ddVar.mo4815be()) {
                C0662da.m1554v("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                return m1594d(ddVar.getContext(), this.f1815ng.mo4814bd().f1798pU, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            } else {
                C0662da.m1554v("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
                return m1594d(ddVar.getContext(), this.f1815ng.mo4814bd().f1798pU, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
            }
        } catch (IOException e) {
            C0662da.m1555w("Could not fetching MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }
}
