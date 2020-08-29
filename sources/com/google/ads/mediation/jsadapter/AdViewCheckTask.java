package com.google.ads.mediation.jsadapter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.internal.C0662da;

public final class AdViewCheckTask implements Runnable {
    public static final int BACKGROUND_COLOR = 0;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final JavascriptAdapter f36r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Handler f37s = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final long f38t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public long f39u;

    /* renamed from: com.google.ads.mediation.jsadapter.AdViewCheckTask$a */
    private final class C0166a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: v */
        private final int f40v;

        /* renamed from: w */
        private final int f41w;

        /* renamed from: x */
        private final WebView f42x;

        /* renamed from: y */
        private Bitmap f43y;

        public C0166a(int i, int i2, WebView webView) {
            this.f40v = i2;
            this.f41w = i;
            this.f42x = webView;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public synchronized Boolean doInBackground(Void... voidArr) {
            Boolean bool;
            int width = this.f43y.getWidth();
            int height = this.f43y.getHeight();
            if (width == 0 || height == 0) {
                bool = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.f43y.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                bool = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return bool;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            AdViewCheckTask.m8a(AdViewCheckTask.this);
            if (bool.booleanValue()) {
                AdViewCheckTask.this.f36r.sendAdReceivedUpdate();
            } else if (AdViewCheckTask.this.f39u > 0) {
                if (C0662da.m1550n(2)) {
                    C0662da.m1551s("Ad not detected, scheduling another run.");
                }
                AdViewCheckTask.this.f37s.postDelayed(AdViewCheckTask.this, AdViewCheckTask.this.f38t);
            } else {
                C0662da.m1551s("Ad not detected, Not scheduling anymore runs.");
                AdViewCheckTask.this.f36r.sendAdNotReceivedUpdate();
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onPreExecute() {
            this.f43y = Bitmap.createBitmap(this.f41w, this.f40v, Config.ARGB_8888);
            this.f42x.setVisibility(0);
            this.f42x.measure(MeasureSpec.makeMeasureSpec(this.f41w, 0), MeasureSpec.makeMeasureSpec(this.f40v, 0));
            this.f42x.layout(0, 0, this.f41w, this.f40v);
            this.f42x.draw(new Canvas(this.f43y));
            this.f42x.invalidate();
        }
    }

    public AdViewCheckTask(JavascriptAdapter adapter, long checkIntervalInMillis, long numIterations) {
        this.f36r = adapter;
        this.f38t = checkIntervalInMillis;
        this.f39u = numIterations;
    }

    /* renamed from: a */
    static /* synthetic */ long m8a(AdViewCheckTask adViewCheckTask) {
        long j = adViewCheckTask.f39u - 1;
        adViewCheckTask.f39u = j;
        return j;
    }

    public void run() {
        if (this.f36r != null && !this.f36r.shouldStopAdCheck()) {
            new C0166a(this.f36r.getWebViewWidth(), this.f36r.getWebViewHeight(), this.f36r.getWebView()).execute(new Void[0]);
        }
    }

    public void start() {
        this.f37s.postDelayed(this, this.f38t);
    }
}
