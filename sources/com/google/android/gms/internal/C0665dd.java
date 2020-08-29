package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* renamed from: com.google.android.gms.internal.dd */
public final class C0665dd extends WebView implements DownloadListener {

    /* renamed from: mF */
    private C0504ab f1802mF;

    /* renamed from: mG */
    private final C0663db f1803mG;

    /* renamed from: mg */
    private final Object f1804mg = new Object();

    /* renamed from: nP */
    private final C1152l f1805nP;

    /* renamed from: pY */
    private final C0667de f1806pY;

    /* renamed from: pZ */
    private final C0666a f1807pZ;

    /* renamed from: qa */
    private C0581bo f1808qa;

    /* renamed from: qb */
    private boolean f1809qb;

    /* renamed from: qc */
    private boolean f1810qc;

    /* renamed from: com.google.android.gms.internal.dd$a */
    private static class C0666a extends MutableContextWrapper {

        /* renamed from: qd */
        private Activity f1811qd;

        /* renamed from: qe */
        private Context f1812qe;

        public C0666a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public void setBaseContext(Context base) {
            this.f1812qe = base.getApplicationContext();
            this.f1811qd = base instanceof Activity ? (Activity) base : null;
            super.setBaseContext(this.f1812qe);
        }

        public void startActivity(Intent intent) {
            if (this.f1811qd != null) {
                this.f1811qd.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.f1812qe.startActivity(intent);
        }
    }

    private C0665dd(C0666a aVar, C0504ab abVar, boolean z, boolean z2, C1152l lVar, C0663db dbVar) {
        super(aVar);
        this.f1807pZ = aVar;
        this.f1802mF = abVar;
        this.f1809qb = z;
        this.f1805nP = lVar;
        this.f1803mG = dbVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        C0653cv.m1503a((Context) aVar, dbVar.f1798pU, settings);
        if (VERSION.SDK_INT >= 17) {
            C0657cx.m1531a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            C0656cw.m1525a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.f1806pY = new C0678dg(this, z2);
        } else {
            this.f1806pY = new C0667de(this, z2);
        }
        setWebViewClient(this.f1806pY);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new C0679dh(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new C0670df(this));
        }
        m1560bf();
    }

    /* renamed from: a */
    public static C0665dd m1559a(Context context, C0504ab abVar, boolean z, boolean z2, C1152l lVar, C0663db dbVar) {
        return new C0665dd(new C0666a(context), abVar, z, z2, lVar, dbVar);
    }

    /* renamed from: bf */
    private void m1560bf() {
        synchronized (this.f1804mg) {
            if (this.f1809qb || this.f1802mF.f1195lo) {
                if (VERSION.SDK_INT < 14) {
                    C0662da.m1551s("Disabling hardware acceleration on an overlay.");
                    m1561bg();
                } else {
                    C0662da.m1551s("Enabling hardware acceleration on an overlay.");
                    m1562bh();
                }
            } else if (VERSION.SDK_INT < 18) {
                C0662da.m1551s("Disabling hardware acceleration on an AdView.");
                m1561bg();
            } else {
                C0662da.m1551s("Enabling hardware acceleration on an AdView.");
                m1562bh();
            }
        }
    }

    /* renamed from: bg */
    private void m1561bg() {
        synchronized (this.f1804mg) {
            if (!this.f1810qc && VERSION.SDK_INT >= 11) {
                C0656cw.m1529c(this);
            }
            this.f1810qc = true;
        }
    }

    /* renamed from: bh */
    private void m1562bh() {
        synchronized (this.f1804mg) {
            if (this.f1810qc && VERSION.SDK_INT >= 11) {
                C0656cw.m1530d(this);
            }
            this.f1810qc = false;
        }
    }

    /* renamed from: Q */
    public C0504ab mo4804Q() {
        C0504ab abVar;
        synchronized (this.f1804mg) {
            abVar = this.f1802mF;
        }
        return abVar;
    }

    /* renamed from: a */
    public void mo4805a(Context context, C0504ab abVar) {
        synchronized (this.f1804mg) {
            this.f1807pZ.setBaseContext(context);
            this.f1808qa = null;
            this.f1802mF = abVar;
            this.f1809qb = false;
            C0653cv.m1516b(this);
            loadUrl("about:blank");
            this.f1806pY.reset();
        }
    }

    /* renamed from: a */
    public void mo4806a(C0504ab abVar) {
        synchronized (this.f1804mg) {
            this.f1802mF = abVar;
            requestLayout();
        }
    }

    /* renamed from: a */
    public void mo4807a(C0581bo boVar) {
        synchronized (this.f1804mg) {
            this.f1808qa = boVar;
        }
    }

    /* renamed from: a */
    public void mo4808a(String str, Map<String, ?> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("javascript:AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        if (map != null) {
            try {
                String jSONObject = C0653cv.m1521m(map).toString();
                sb.append(",");
                sb.append(jSONObject);
            } catch (JSONException e) {
                C0662da.m1555w("Could not convert AFMA event parameters to JSON.");
                return;
            }
        }
        sb.append(");");
        C0662da.m1554v("Dispatching AFMA event: " + sb);
        loadUrl(sb.toString());
    }

    /* renamed from: aY */
    public void mo4809aY() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.f1803mG.f1798pU);
        mo4808a("onhide", (Map<String, ?>) hashMap);
    }

    /* renamed from: aZ */
    public void mo4810aZ() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.f1803mG.f1798pU);
        mo4808a("onshow", (Map<String, ?>) hashMap);
    }

    /* renamed from: ba */
    public C0581bo mo4811ba() {
        C0581bo boVar;
        synchronized (this.f1804mg) {
            boVar = this.f1808qa;
        }
        return boVar;
    }

    /* renamed from: bb */
    public C0667de mo4812bb() {
        return this.f1806pY;
    }

    /* renamed from: bc */
    public C1152l mo4813bc() {
        return this.f1805nP;
    }

    /* renamed from: bd */
    public C0663db mo4814bd() {
        return this.f1803mG;
    }

    /* renamed from: be */
    public boolean mo4815be() {
        boolean z;
        synchronized (this.f1804mg) {
            z = this.f1809qb;
        }
        return z;
    }

    /* renamed from: n */
    public void mo4816n(boolean z) {
        synchronized (this.f1804mg) {
            this.f1809qb = z;
            m1560bf();
        }
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C0662da.m1551s("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r0 = 2147483647(0x7fffffff, float:NaN)
            r8 = 1073741824(0x40000000, float:2.0)
            r7 = 8
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.Object r4 = r9.f1804mg
            monitor-enter(r4)
            boolean r1 = r9.isInEditMode()     // Catch:{ all -> 0x0094 }
            if (r1 != 0) goto L_0x0016
            boolean r1 = r9.f1809qb     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x001b
        L_0x0016:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x0094 }
            monitor-exit(r4)     // Catch:{ all -> 0x0094 }
        L_0x001a:
            return
        L_0x001b:
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x0094 }
            int r3 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x0094 }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x0094 }
            int r1 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x0094 }
            if (r2 == r6) goto L_0x002f
            if (r2 != r8) goto L_0x00ad
        L_0x002f:
            r2 = r3
        L_0x0030:
            if (r5 == r6) goto L_0x0034
            if (r5 != r8) goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            com.google.android.gms.internal.ab r5 = r9.f1802mF     // Catch:{ all -> 0x0094 }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x0094 }
            if (r5 > r2) goto L_0x0041
            com.google.android.gms.internal.ab r2 = r9.f1802mF     // Catch:{ all -> 0x0094 }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x0094 }
            if (r2 <= r0) goto L_0x0097
        L_0x0041:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
            r0.<init>()     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = "Not enough space to show ad. Needs "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.ab r2 = r9.f1802mF     // Catch:{ all -> 0x0094 }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.ab r2 = r9.f1802mF     // Catch:{ all -> 0x0094 }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = " pixels, but only has "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0094 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = " pixels."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.C0662da.m1555w(r0)     // Catch:{ all -> 0x0094 }
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x0094 }
            if (r0 == r7) goto L_0x008d
            r0 = 4
            r9.setVisibility(r0)     // Catch:{ all -> 0x0094 }
        L_0x008d:
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x0094 }
        L_0x0092:
            monitor-exit(r4)     // Catch:{ all -> 0x0094 }
            goto L_0x001a
        L_0x0094:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0094 }
            throw r0
        L_0x0097:
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x0094 }
            if (r0 == r7) goto L_0x00a1
            r0 = 0
            r9.setVisibility(r0)     // Catch:{ all -> 0x0094 }
        L_0x00a1:
            com.google.android.gms.internal.ab r0 = r9.f1802mF     // Catch:{ all -> 0x0094 }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x0094 }
            com.google.android.gms.internal.ab r1 = r9.f1802mF     // Catch:{ all -> 0x0094 }
            int r1 = r1.heightPixels     // Catch:{ all -> 0x0094 }
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x0094 }
            goto L_0x0092
        L_0x00ad:
            r2 = r0
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0665dd.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.f1805nP != null) {
            this.f1805nP.mo6431a(event);
        }
        return super.onTouchEvent(event);
    }

    public void setContext(Context context) {
        this.f1807pZ.setBaseContext(context);
    }
}
