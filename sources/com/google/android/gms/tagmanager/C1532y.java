package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.google.android.gms.tagmanager.y */
class C1532y implements C1378aq {

    /* renamed from: UO */
    private static C1532y f3914UO;

    /* renamed from: qI */
    private static final Object f3915qI = new Object();

    /* renamed from: UP */
    private String f3916UP;

    /* renamed from: UQ */
    private String f3917UQ;

    /* renamed from: UR */
    private C1379ar f3918UR;

    /* renamed from: Uc */
    private C1432cg f3919Uc;

    private C1532y(Context context) {
        this(C1380as.m4026H(context), new C1469cw());
    }

    C1532y(C1379ar arVar, C1432cg cgVar) {
        this.f3918UR = arVar;
        this.f3919Uc = cgVar;
    }

    /* renamed from: F */
    public static C1378aq m4537F(Context context) {
        C1532y yVar;
        synchronized (f3915qI) {
            if (f3914UO == null) {
                f3914UO = new C1532y(context);
            }
            yVar = f3914UO;
        }
        return yVar;
    }

    /* renamed from: bk */
    public boolean mo7585bk(String str) {
        if (!this.f3919Uc.mo7601cl()) {
            C1401bh.m4078w("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        if (!(this.f3916UP == null || this.f3917UQ == null)) {
            try {
                str = this.f3916UP + "?" + this.f3917UQ + "=" + URLEncoder.encode(str, "UTF-8");
                C1401bh.m4077v("Sending wrapped url hit: " + str);
            } catch (UnsupportedEncodingException e) {
                C1401bh.m4072b("Error wrapping URL for testing.", e);
                return false;
            }
        }
        this.f3918UR.mo7587bn(str);
        return true;
    }
}
