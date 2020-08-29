package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

/* renamed from: com.google.android.gms.analytics.g */
class C0203g implements C0211m {

    /* renamed from: qI */
    private static Object f182qI = new Object();

    /* renamed from: qV */
    private static C0203g f183qV;

    /* renamed from: qR */
    protected String f184qR;

    /* renamed from: qS */
    protected String f185qS;

    /* renamed from: qT */
    protected String f186qT;

    /* renamed from: qU */
    protected String f187qU;

    protected C0203g() {
    }

    private C0203g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.f186qT = context.getPackageName();
        this.f187qU = packageManager.getInstallerPackageName(this.f186qT);
        String str = this.f186qT;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            C0181aa.m72t("Error retrieving package info: appName set to " + str);
        }
        this.f184qR = str;
        this.f185qS = str2;
    }

    /* renamed from: bt */
    public static C0203g m169bt() {
        return f183qV;
    }

    /* renamed from: n */
    public static void m170n(Context context) {
        synchronized (f182qI) {
            if (f183qV == null) {
                f183qV = new C0203g(context);
            }
        }
    }

    public String getValue(String field) {
        if (field == null) {
            return null;
        }
        if (field.equals("&an")) {
            return this.f184qR;
        }
        if (field.equals("&av")) {
            return this.f185qS;
        }
        if (field.equals("&aid")) {
            return this.f186qT;
        }
        if (field.equals("&aiid")) {
            return this.f187qU;
        }
        return null;
    }

    /* renamed from: x */
    public boolean mo2940x(String str) {
        return "&an".equals(str) || "&av".equals(str) || "&aid".equals(str) || "&aiid".equals(str);
    }
}
