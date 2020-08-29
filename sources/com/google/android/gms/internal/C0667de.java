package com.google.android.gms.internal;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.net.UrlQuerySanitizer.ParameterValuePair;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.de */
public class C0667de extends WebViewClient {

    /* renamed from: lV */
    private C0527ap f1813lV;

    /* renamed from: mg */
    private final Object f1814mg = new Object();

    /* renamed from: ng */
    protected final C0665dd f1815ng;

    /* renamed from: qf */
    private final HashMap<String, C0536ar> f1816qf = new HashMap<>();

    /* renamed from: qg */
    private C1166u f1817qg;

    /* renamed from: qh */
    private C0587br f1818qh;

    /* renamed from: qi */
    private C0669a f1819qi;

    /* renamed from: qj */
    private boolean f1820qj = false;

    /* renamed from: qk */
    private boolean f1821qk;

    /* renamed from: ql */
    private C0592bu f1822ql;

    /* renamed from: com.google.android.gms.internal.de$a */
    public interface C0669a {
        /* renamed from: a */
        void mo4654a(C0665dd ddVar);
    }

    public C0667de(C0665dd ddVar, boolean z) {
        this.f1815ng = ddVar;
        this.f1821qk = z;
    }

    /* renamed from: a */
    private void m1576a(C0586bq bqVar) {
        C0581bo.m1289a(this.f1815ng.getContext(), bqVar);
    }

    /* renamed from: b */
    private static boolean m1577b(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    /* renamed from: c */
    private void m1578c(Uri uri) {
        String path = uri.getPath();
        C0536ar arVar = (C0536ar) this.f1816qf.get(path);
        if (arVar != null) {
            HashMap hashMap = new HashMap();
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer.parseUrl(uri.toString());
            for (ParameterValuePair parameterValuePair : urlQuerySanitizer.getParameterList()) {
                hashMap.put(parameterValuePair.mParameter, parameterValuePair.mValue);
            }
            if (C0662da.m1550n(2)) {
                C0662da.m1554v("Received GMSG: " + path);
                for (String str : hashMap.keySet()) {
                    C0662da.m1554v("  " + str + ": " + ((String) hashMap.get(str)));
                }
            }
            arVar.mo4576a(this.f1815ng, hashMap);
            return;
        }
        C0662da.m1555w("No GMSG handler found for GMSG: " + uri);
    }

    /* renamed from: a */
    public final void mo4823a(C0580bn bnVar) {
        C0587br brVar = null;
        boolean be = this.f1815ng.mo4815be();
        C1166u uVar = (!be || this.f1815ng.mo4804Q().f1195lo) ? this.f1817qg : null;
        if (!be) {
            brVar = this.f1818qh;
        }
        m1576a(new C0586bq(bnVar, uVar, brVar, this.f1822ql, this.f1815ng.mo4814bd()));
    }

    /* renamed from: a */
    public final void mo4824a(C0669a aVar) {
        this.f1819qi = aVar;
    }

    /* renamed from: a */
    public void mo4825a(C1166u uVar, C0587br brVar, C0527ap apVar, C0592bu buVar, boolean z) {
        mo4826a("/appEvent", (C0536ar) new C0526ao(apVar));
        mo4826a("/canOpenURLs", C0528aq.f1251lW);
        mo4826a("/click", C0528aq.f1252lX);
        mo4826a("/close", C0528aq.f1253lY);
        mo4826a("/customClose", C0528aq.f1254lZ);
        mo4826a("/httpTrack", C0528aq.f1255ma);
        mo4826a("/log", C0528aq.f1256mb);
        mo4826a("/open", C0528aq.f1257mc);
        mo4826a("/touch", C0528aq.f1258md);
        mo4826a("/video", C0528aq.f1259me);
        this.f1817qg = uVar;
        this.f1818qh = brVar;
        this.f1813lV = apVar;
        this.f1822ql = buVar;
        mo4832o(z);
    }

    /* renamed from: a */
    public final void mo4826a(String str, C0536ar arVar) {
        this.f1816qf.put(str, arVar);
    }

    /* renamed from: a */
    public final void mo4827a(boolean z, int i) {
        m1576a(new C0586bq((!this.f1815ng.mo4815be() || this.f1815ng.mo4804Q().f1195lo) ? this.f1817qg : null, this.f1818qh, this.f1822ql, this.f1815ng, z, i, this.f1815ng.mo4814bd()));
    }

    /* renamed from: a */
    public final void mo4828a(boolean z, int i, String str) {
        C0587br brVar = null;
        boolean be = this.f1815ng.mo4815be();
        C1166u uVar = (!be || this.f1815ng.mo4804Q().f1195lo) ? this.f1817qg : null;
        if (!be) {
            brVar = this.f1818qh;
        }
        m1576a(new C0586bq(uVar, brVar, this.f1813lV, this.f1822ql, this.f1815ng, z, i, str, this.f1815ng.mo4814bd()));
    }

    /* renamed from: a */
    public final void mo4829a(boolean z, int i, String str, String str2) {
        C0587br brVar = null;
        boolean be = this.f1815ng.mo4815be();
        C1166u uVar = (!be || this.f1815ng.mo4804Q().f1195lo) ? this.f1817qg : null;
        if (!be) {
            brVar = this.f1818qh;
        }
        m1576a(new C0586bq(uVar, brVar, this.f1813lV, this.f1822ql, this.f1815ng, z, i, str, str2, this.f1815ng.mo4814bd()));
    }

    /* renamed from: ar */
    public final void mo4830ar() {
        synchronized (this.f1814mg) {
            this.f1820qj = false;
            this.f1821qk = true;
            final C0581bo ba = this.f1815ng.mo4811ba();
            if (ba != null) {
                if (!C0659cz.m1539aX()) {
                    C0659cz.f1785pT.post(new Runnable() {
                        public void run() {
                            ba.mo4639ar();
                        }
                    });
                } else {
                    ba.mo4639ar();
                }
            }
        }
    }

    /* renamed from: bi */
    public boolean mo4831bi() {
        boolean z;
        synchronized (this.f1814mg) {
            z = this.f1821qk;
        }
        return z;
    }

    /* renamed from: o */
    public final void mo4832o(boolean z) {
        this.f1820qj = z;
    }

    public final void onPageFinished(WebView webView, String url) {
        if (this.f1819qi != null) {
            this.f1819qi.mo4654a(this.f1815ng);
            this.f1819qi = null;
        }
    }

    public final void reset() {
        synchronized (this.f1814mg) {
            this.f1816qf.clear();
            this.f1817qg = null;
            this.f1818qh = null;
            this.f1819qi = null;
            this.f1813lV = null;
            this.f1820qj = false;
            this.f1821qk = false;
            this.f1822ql = null;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        Uri uri;
        C0662da.m1554v("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m1578c(parse);
        } else if (this.f1820qj && webView == this.f1815ng && m1577b(parse)) {
            return super.shouldOverrideUrlLoading(webView, url);
        } else {
            if (!this.f1815ng.willNotDraw()) {
                try {
                    C1152l bc = this.f1815ng.mo4813bc();
                    if (bc != null && bc.mo6432a(parse)) {
                        parse = bc.mo6430a(parse, this.f1815ng.getContext());
                    }
                    uri = parse;
                } catch (C1153m e) {
                    C0662da.m1555w("Unable to append parameter to URL: " + url);
                    uri = parse;
                }
                mo4823a(new C0580bn("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                C0662da.m1555w("AdWebView unable to handle URL: " + url);
            }
        }
        return true;
    }
}
