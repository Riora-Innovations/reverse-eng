package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.AdActivity;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.cv */
public final class C0653cv {
    /* access modifiers changed from: private */

    /* renamed from: op */
    public static final Object f1778op = new Object();
    /* access modifiers changed from: private */

    /* renamed from: pO */
    public static boolean f1779pO = true;
    /* access modifiers changed from: private */

    /* renamed from: pP */
    public static String f1780pP;

    /* renamed from: pQ */
    private static boolean f1781pQ = false;

    /* renamed from: com.google.android.gms.internal.cv$a */
    private static final class C0655a extends BroadcastReceiver {
        private C0655a() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                C0653cv.f1779pO = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                C0653cv.f1779pO = false;
            }
        }
    }

    /* renamed from: a */
    public static String m1499a(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        CharBuffer allocate = CharBuffer.allocate(2048);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return sb.toString();
            }
            allocate.flip();
            sb.append(allocate, 0, read);
        }
    }

    /* renamed from: a */
    private static JSONArray m1500a(Collection<?> collection) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : collection) {
            m1507a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    static JSONArray m1501a(Object[] objArr) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object a : objArr) {
            m1507a(jSONArray, a);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static JSONObject m1502a(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            m1508a(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m1503a(Context context, String str, WebSettings webSettings) {
        webSettings.setUserAgentString(m1515b(context, str));
    }

    /* renamed from: a */
    public static void m1504a(Context context, String str, List<String> list) {
        for (String cyVar : list) {
            new C0658cy(context, str, cyVar).start();
        }
    }

    /* renamed from: a */
    public static void m1505a(Context context, String str, boolean z, HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setInstanceFollowRedirects(z);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setRequestProperty("User-Agent", m1515b(context, str));
        httpURLConnection.setUseCaches(false);
    }

    /* renamed from: a */
    public static void m1506a(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            C0656cw.m1527a(webView);
        }
    }

    /* renamed from: a */
    private static void m1507a(JSONArray jSONArray, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONArray.put(m1502a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONArray.put(m1521m((Map) obj));
        } else if (obj instanceof Collection) {
            jSONArray.put(m1500a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(m1501a((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    /* renamed from: a */
    private static void m1508a(JSONObject jSONObject, String str, Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            jSONObject.put(str, m1502a((Bundle) obj));
        } else if (obj instanceof Map) {
            jSONObject.put(str, m1521m((Map) obj));
        } else if (obj instanceof Collection) {
            if (str == null) {
                str = "null";
            }
            jSONObject.put(str, m1500a((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONObject.put(str, m1500a((Collection<?>) Arrays.asList((Object[]) obj)));
        } else {
            jSONObject.put(str, obj);
        }
    }

    /* renamed from: a */
    public static boolean m1509a(PackageManager packageManager, String str, String str2) {
        return packageManager.checkPermission(str2, str) == 0;
    }

    /* renamed from: a */
    public static boolean m1510a(ClassLoader classLoader, Class<?> cls, String str) {
        boolean z = false;
        try {
            return cls.isAssignableFrom(Class.forName(str, false, classLoader));
        } catch (Throwable th) {
            return z;
        }
    }

    /* renamed from: aS */
    public static boolean m1511aS() {
        return f1779pO;
    }

    /* renamed from: aT */
    public static int m1512aT() {
        return VERSION.SDK_INT >= 9 ? 6 : 0;
    }

    /* renamed from: aU */
    public static int m1513aU() {
        return VERSION.SDK_INT >= 9 ? 7 : 1;
    }

    /* renamed from: b */
    private static String m1515b(final Context context, String str) {
        String str2;
        synchronized (f1778op) {
            if (f1780pP != null) {
                str2 = f1780pP;
            } else {
                if (VERSION.SDK_INT >= 17) {
                    f1780pP = C0657cx.getDefaultUserAgent(context);
                } else if (!C0659cz.m1539aX()) {
                    C0659cz.f1785pT.post(new Runnable() {
                        public void run() {
                            synchronized (C0653cv.f1778op) {
                                C0653cv.f1780pP = C0653cv.m1519j(context);
                                C0653cv.f1778op.notifyAll();
                            }
                        }
                    });
                    while (f1780pP == null) {
                        try {
                            f1778op.wait();
                        } catch (InterruptedException e) {
                            str2 = f1780pP;
                        }
                    }
                } else {
                    f1780pP = m1519j(context);
                }
                f1780pP += " (Mobile; " + str + ")";
                str2 = f1780pP;
            }
        }
        return str2;
    }

    /* renamed from: b */
    public static void m1516b(WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            C0656cw.m1528b(webView);
        }
    }

    /* renamed from: h */
    public static boolean m1517h(Context context) {
        boolean z;
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
        if (resolveActivity == null || resolveActivity.activityInfo == null) {
            C0662da.m1555w("Could not find com.google.android.gms.ads.AdActivity, please make sure it is declared in AndroidManifest.xml.");
            return false;
        }
        String str = "com.google.android.gms.ads.AdActivity requires the android:configChanges value to contain \"%s\".";
        if ((resolveActivity.activityInfo.configChanges & 16) == 0) {
            C0662da.m1555w(String.format(str, new Object[]{"keyboard"}));
            z = false;
        } else {
            z = true;
        }
        if ((resolveActivity.activityInfo.configChanges & 32) == 0) {
            C0662da.m1555w(String.format(str, new Object[]{"keyboardHidden"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 128) == 0) {
            C0662da.m1555w(String.format(str, new Object[]{"orientation"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 256) == 0) {
            C0662da.m1555w(String.format(str, new Object[]{"screenLayout"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 512) == 0) {
            C0662da.m1555w(String.format(str, new Object[]{"uiMode"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 1024) == 0) {
            C0662da.m1555w(String.format(str, new Object[]{"screenSize"}));
            z = false;
        }
        if ((resolveActivity.activityInfo.configChanges & 2048) != 0) {
            return z;
        }
        C0662da.m1555w(String.format(str, new Object[]{"smallestScreenSize"}));
        return false;
    }

    /* renamed from: i */
    public static void m1518i(Context context) {
        if (!f1781pQ) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.getApplicationContext().registerReceiver(new C0655a(), intentFilter);
            f1781pQ = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static String m1519j(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }

    /* renamed from: m */
    public static JSONObject m1521m(Map<String, ?> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                m1508a(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: " + e.getMessage());
        }
    }

    /* renamed from: p */
    public static String m1523p(String str) {
        return Uri.parse(str).buildUpon().query(null).build().toString();
    }
}
