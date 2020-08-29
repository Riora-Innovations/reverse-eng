package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ay */
class C1387ay {

    /* renamed from: Vm */
    private static String f3607Vm;

    /* renamed from: Vn */
    static Map<String, String> f3608Vn = new HashMap();

    C1387ay() {
    }

    /* renamed from: bq */
    static void m4047bq(String str) {
        synchronized (C1387ay.class) {
            f3607Vm = str;
        }
    }

    /* renamed from: c */
    static void m4048c(Context context, String str) {
        C1475cz.m4331a(context, "gtm_install_referrer", "referrer", str);
        m4051e(context, str);
    }

    /* renamed from: d */
    static String m4049d(Context context, String str) {
        if (f3607Vm == null) {
            synchronized (C1387ay.class) {
                if (f3607Vm == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        f3607Vm = sharedPreferences.getString("referrer", "");
                    } else {
                        f3607Vm = "";
                    }
                }
            }
        }
        return m4052l(f3607Vm, str);
    }

    /* renamed from: e */
    static String m4050e(Context context, String str, String str2) {
        String str3 = (String) f3608Vn.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            f3608Vn.put(str, str3);
        }
        return m4052l(str3, str2);
    }

    /* renamed from: e */
    static void m4051e(Context context, String str) {
        String l = m4052l(str, "conv");
        if (l != null && l.length() > 0) {
            f3608Vn.put(l, str);
            C1475cz.m4331a(context, "gtm_click_referrers", l, str);
        }
    }

    /* renamed from: l */
    static String m4052l(String str, String str2) {
        if (str2 != null) {
            return Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }
}
