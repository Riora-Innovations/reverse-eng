package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.internal.C0595bw.C0596a;
import com.google.android.gms.internal.C0667de.C0669a;

/* renamed from: com.google.android.gms.internal.bo */
public final class C0581bo extends C0596a {

    /* renamed from: nd */
    private final Activity f1520nd;

    /* renamed from: ne */
    private C0586bq f1521ne;

    /* renamed from: nf */
    private C0588bs f1522nf;

    /* renamed from: ng */
    private C0665dd f1523ng;

    /* renamed from: nh */
    private C0584b f1524nh;

    /* renamed from: ni */
    private C0591bt f1525ni;

    /* renamed from: nj */
    private FrameLayout f1526nj;

    /* renamed from: nk */
    private CustomViewCallback f1527nk;

    /* renamed from: nl */
    private boolean f1528nl = false;

    /* renamed from: nm */
    private boolean f1529nm = false;

    /* renamed from: nn */
    private RelativeLayout f1530nn;

    /* renamed from: com.google.android.gms.internal.bo$a */
    private static final class C0583a extends Exception {
        public C0583a(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.gms.internal.bo$b */
    private static final class C0584b {
        public final int index;

        /* renamed from: np */
        public final LayoutParams f1532np;

        /* renamed from: nq */
        public final ViewGroup f1533nq;

        public C0584b(C0665dd ddVar) throws C0583a {
            this.f1532np = ddVar.getLayoutParams();
            ViewParent parent = ddVar.getParent();
            if (parent instanceof ViewGroup) {
                this.f1533nq = (ViewGroup) parent;
                this.index = this.f1533nq.indexOfChild(ddVar);
                this.f1533nq.removeView(ddVar);
                ddVar.mo4816n(true);
                return;
            }
            throw new C0583a("Could not get the parent of the WebView for an overlay.");
        }
    }

    public C0581bo(Activity activity) {
        this.f1520nd = activity;
    }

    /* renamed from: a */
    private static RelativeLayout.LayoutParams m1288a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    /* renamed from: a */
    public static void m1289a(Context context, C0586bq bqVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", bqVar.f1534kN.f1801pX);
        C0586bq.m1305a(intent, bqVar);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        context.startActivity(intent);
    }

    /* renamed from: as */
    private void m1290as() {
        if (this.f1520nd.isFinishing() && !this.f1529nm) {
            this.f1529nm = true;
            if (this.f1520nd.isFinishing()) {
                if (this.f1523ng != null) {
                    this.f1523ng.mo4809aY();
                    this.f1530nn.removeView(this.f1523ng);
                    if (this.f1524nh != null) {
                        this.f1523ng.mo4816n(false);
                        this.f1524nh.f1533nq.addView(this.f1523ng, this.f1524nh.index, this.f1524nh.f1532np);
                    }
                }
                if (this.f1521ne != null && this.f1521ne.f1539nt != null) {
                    this.f1521ne.f1539nt.mo4666S();
                }
            }
        }
    }

    /* renamed from: h */
    private void m1291h(boolean z) throws C0583a {
        this.f1520nd.requestWindowFeature(1);
        Window window = this.f1520nd.getWindow();
        window.setFlags(1024, 1024);
        setRequestedOrientation(this.f1521ne.orientation);
        if (VERSION.SDK_INT >= 11) {
            C0662da.m1551s("Enabling hardware acceleration on the AdActivity window.");
            C0656cw.m1526a(window);
        }
        this.f1530nn = new RelativeLayout(this.f1520nd);
        this.f1530nn.setBackgroundColor(-16777216);
        this.f1520nd.setContentView(this.f1530nn);
        boolean bi = this.f1521ne.f1540nu.mo4812bb().mo4831bi();
        if (z) {
            this.f1523ng = C0665dd.m1559a(this.f1520nd, this.f1521ne.f1540nu.mo4804Q(), true, bi, null, this.f1521ne.f1534kN);
            this.f1523ng.mo4812bb().mo4825a(null, null, this.f1521ne.f1541nv, this.f1521ne.f1545nz, true);
            this.f1523ng.mo4812bb().mo4824a((C0669a) new C0669a() {
                /* renamed from: a */
                public void mo4654a(C0665dd ddVar) {
                    ddVar.mo4810aZ();
                }
            });
            if (this.f1521ne.f1535mZ != null) {
                this.f1523ng.loadUrl(this.f1521ne.f1535mZ);
            } else if (this.f1521ne.f1544ny != null) {
                this.f1523ng.loadDataWithBaseURL(this.f1521ne.f1542nw, this.f1521ne.f1544ny, "text/html", "UTF-8", null);
            } else {
                throw new C0583a("No URL or HTML to display in ad overlay.");
            }
        } else {
            this.f1523ng = this.f1521ne.f1540nu;
            this.f1523ng.setContext(this.f1520nd);
        }
        this.f1523ng.mo4807a(this);
        this.f1530nn.addView(this.f1523ng, -1, -1);
        if (!z) {
            this.f1523ng.mo4810aZ();
        }
        mo4643f(bi);
    }

    /* renamed from: a */
    public void mo4636a(View view, CustomViewCallback customViewCallback) {
        this.f1526nj = new FrameLayout(this.f1520nd);
        this.f1526nj.setBackgroundColor(-16777216);
        this.f1526nj.addView(view, -1, -1);
        this.f1520nd.setContentView(this.f1526nj);
        this.f1527nk = customViewCallback;
    }

    /* renamed from: ap */
    public C0588bs mo4637ap() {
        return this.f1522nf;
    }

    /* renamed from: aq */
    public void mo4638aq() {
        if (this.f1521ne != null) {
            setRequestedOrientation(this.f1521ne.orientation);
        }
        if (this.f1526nj != null) {
            this.f1520nd.setContentView(this.f1530nn);
            this.f1526nj.removeAllViews();
            this.f1526nj = null;
        }
        if (this.f1527nk != null) {
            this.f1527nk.onCustomViewHidden();
            this.f1527nk = null;
        }
    }

    /* renamed from: ar */
    public void mo4639ar() {
        this.f1530nn.removeView(this.f1525ni);
        mo4643f(true);
    }

    /* renamed from: b */
    public void mo4640b(int i, int i2, int i3, int i4) {
        if (this.f1522nf != null) {
            this.f1522nf.setLayoutParams(m1288a(i, i2, i3, i4));
        }
    }

    /* renamed from: c */
    public void mo4641c(int i, int i2, int i3, int i4) {
        if (this.f1522nf == null) {
            this.f1522nf = new C0588bs(this.f1520nd, this.f1523ng);
            this.f1530nn.addView(this.f1522nf, 0, m1288a(i, i2, i3, i4));
            this.f1523ng.mo4812bb().mo4832o(false);
        }
    }

    public void close() {
        this.f1520nd.finish();
    }

    /* renamed from: f */
    public void mo4643f(boolean z) {
        this.f1525ni = new C0591bt(this.f1520nd, z ? 50 : 32);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.f1525ni.mo4683g(this.f1521ne.f1543nx);
        this.f1530nn.addView(this.f1525ni, layoutParams);
    }

    /* renamed from: g */
    public void mo4644g(boolean z) {
        if (this.f1525ni != null) {
            this.f1525ni.mo4683g(z);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.f1528nl = z;
        try {
            this.f1521ne = C0586bq.m1304a(this.f1520nd.getIntent());
            if (this.f1521ne == null) {
                throw new C0583a("Could not get info for ad overlay.");
            }
            if (savedInstanceState == null) {
                if (this.f1521ne.f1539nt != null) {
                    this.f1521ne.f1539nt.mo4667T();
                }
                if (!(this.f1521ne.f1536nA == 1 || this.f1521ne.f1538ns == null)) {
                    this.f1521ne.f1538ns.mo6450O();
                }
            }
            switch (this.f1521ne.f1536nA) {
                case 1:
                    m1291h(false);
                    return;
                case 2:
                    this.f1524nh = new C0584b(this.f1521ne.f1540nu);
                    m1291h(false);
                    return;
                case 3:
                    m1291h(true);
                    return;
                case 4:
                    if (this.f1528nl) {
                        this.f1520nd.finish();
                        return;
                    } else if (!C0578bl.m1284a(this.f1520nd, this.f1521ne.f1537nr, this.f1521ne.f1545nz)) {
                        this.f1520nd.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new C0583a("Could not determine ad overlay type.");
            }
        } catch (C0583a e) {
            C0662da.m1555w(e.getMessage());
            this.f1520nd.finish();
        }
    }

    public void onDestroy() {
        if (this.f1522nf != null) {
            this.f1522nf.destroy();
        }
        if (this.f1523ng != null) {
            this.f1530nn.removeView(this.f1523ng);
        }
        m1290as();
    }

    public void onPause() {
        if (this.f1522nf != null) {
            this.f1522nf.pause();
        }
        mo4638aq();
        if (this.f1523ng != null && (!this.f1520nd.isFinishing() || this.f1524nh == null)) {
            C0653cv.m1506a((WebView) this.f1523ng);
        }
        m1290as();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.f1521ne != null && this.f1521ne.f1536nA == 4) {
            if (this.f1528nl) {
                this.f1520nd.finish();
            } else {
                this.f1528nl = true;
            }
        }
        if (this.f1523ng != null) {
            C0653cv.m1516b(this.f1523ng);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f1528nl);
    }

    public void onStart() {
    }

    public void onStop() {
        m1290as();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.f1520nd.setRequestedOrientation(requestedOrientation);
    }
}
