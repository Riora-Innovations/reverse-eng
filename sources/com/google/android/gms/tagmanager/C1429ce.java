package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.google.android.gms.tagmanager.ce */
class C1429ce {

    /* renamed from: VS */
    private static C1429ce f3673VS;

    /* renamed from: TM */
    private volatile String f3674TM;

    /* renamed from: VT */
    private volatile C1430a f3675VT;

    /* renamed from: VU */
    private volatile String f3676VU;

    /* renamed from: VV */
    private volatile String f3677VV;

    /* renamed from: com.google.android.gms.tagmanager.ce$a */
    enum C1430a {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    C1429ce() {
        clear();
    }

    /* renamed from: bt */
    private String m4168bt(String str) {
        return str.split("&")[0].split("=")[1];
    }

    /* renamed from: g */
    private String m4169g(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    /* renamed from: ju */
    static C1429ce m4170ju() {
        C1429ce ceVar;
        synchronized (C1429ce.class) {
            if (f3673VS == null) {
                f3673VS = new C1429ce();
            }
            ceVar = f3673VS;
        }
        return ceVar;
    }

    /* access modifiers changed from: 0000 */
    public void clear() {
        this.f3675VT = C1430a.NONE;
        this.f3676VU = null;
        this.f3674TM = null;
        this.f3677VV = null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public synchronized boolean mo7666f(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    C1401bh.m4077v("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.f3675VT = C1430a.CONTAINER_DEBUG;
                    } else {
                        this.f3675VT = C1430a.CONTAINER;
                    }
                    this.f3677VV = m4169g(uri);
                    if (this.f3675VT == C1430a.CONTAINER || this.f3675VT == C1430a.CONTAINER_DEBUG) {
                        this.f3676VU = "/r?" + this.f3677VV;
                    }
                    this.f3674TM = m4168bt(this.f3677VV);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    C1401bh.m4078w("Invalid preview uri: " + decode);
                    z = false;
                } else if (m4168bt(uri.getQuery()).equals(this.f3674TM)) {
                    C1401bh.m4077v("Exit preview mode for container: " + this.f3674TM);
                    this.f3675VT = C1430a.NONE;
                    this.f3676VU = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public String getContainerId() {
        return this.f3674TM;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jv */
    public C1430a mo7668jv() {
        return this.f3675VT;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jw */
    public String mo7669jw() {
        return this.f3676VU;
    }
}
