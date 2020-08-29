package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.l */
public class C1152l {

    /* renamed from: ko */
    private String f3122ko = "googleads.g.doubleclick.net";

    /* renamed from: kp */
    private String f3123kp = "/pagead/ads";

    /* renamed from: kq */
    private String[] f3124kq = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};

    /* renamed from: kr */
    private C0997h f3125kr;

    /* renamed from: ks */
    private final C0892g f3126ks = new C0892g();

    public C1152l(C0997h hVar) {
        this.f3125kr = hVar;
    }

    /* renamed from: a */
    private Uri m3490a(Uri uri, Context context, String str, boolean z) throws C1153m {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new C1153m("Query parameter already exists: ms");
            }
            return m3491a(uri, "ms", z ? this.f3125kr.mo5632a(context, str) : this.f3125kr.mo5631a(context));
        } catch (UnsupportedOperationException e) {
            throw new C1153m("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    private Uri m3491a(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    /* renamed from: a */
    public Uri mo6430a(Uri uri, Context context) throws C1153m {
        try {
            return m3490a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C1153m("Provided Uri is not in a valid state");
        }
    }

    /* renamed from: a */
    public void mo6431a(MotionEvent motionEvent) {
        this.f3125kr.mo5634a(motionEvent);
    }

    /* renamed from: a */
    public boolean mo6432a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.f3124kq) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    /* renamed from: y */
    public C0997h mo6433y() {
        return this.f3125kr;
    }
}
