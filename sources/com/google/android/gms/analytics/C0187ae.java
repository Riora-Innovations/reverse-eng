package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;

/* renamed from: com.google.android.gms.analytics.ae */
class C0187ae implements C0211m {

    /* renamed from: qI */
    private static Object f162qI = new Object();

    /* renamed from: uk */
    private static C0187ae f163uk;
    private final Context mContext;

    protected C0187ae(Context context) {
        this.mContext = context;
    }

    /* renamed from: cs */
    public static C0187ae m100cs() {
        C0187ae aeVar;
        synchronized (f162qI) {
            aeVar = f163uk;
        }
        return aeVar;
    }

    /* renamed from: n */
    public static void m101n(Context context) {
        synchronized (f162qI) {
            if (f163uk == null) {
                f163uk = new C0187ae(context);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ct */
    public String mo2887ct() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public String getValue(String field) {
        if (field != null && field.equals("&sr")) {
            return mo2887ct();
        }
        return null;
    }

    /* renamed from: x */
    public boolean mo2888x(String str) {
        return "&sr".equals(str);
    }
}
