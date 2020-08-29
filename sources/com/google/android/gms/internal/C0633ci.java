package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.internal.C0630ch.C0631a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ci */
public final class C0633ci extends C0631a {

    /* renamed from: op */
    private static final Object f1675op = new Object();

    /* renamed from: oq */
    private static C0633ci f1676oq;
    private final Context mContext;

    /* renamed from: or */
    private final C0539au f1677or;

    private C0633ci(Context context, C0539au auVar) {
        this.mContext = context;
        this.f1677or = auVar;
    }

    /* renamed from: a */
    private static C0628cf m1435a(final Context context, C0539au auVar, final C0625cd cdVar) {
        C0662da.m1551s("Starting ad request from service.");
        auVar.init();
        C0640cm cmVar = new C0640cm(context);
        if (cmVar.f1713oX == -1) {
            C0662da.m1551s("Device is offline.");
            return new C0628cf(2);
        }
        final C0636ck ckVar = new C0636ck(cdVar.applicationInfo.packageName);
        if (cdVar.f1649oc.extras != null) {
            String string = cdVar.f1649oc.extras.getString("_ad");
            if (string != null) {
                return C0635cj.m1440a(context, cdVar, string);
            }
        }
        final String a = C0635cj.m1441a(cdVar, cmVar, auVar.mo4578a(250));
        if (a == null) {
            return new C0628cf(0);
        }
        C0659cz.f1785pT.post(new Runnable() {
            public void run() {
                C0665dd a = C0665dd.m1559a(context, new C0504ab(), false, false, null, cdVar.f1646kN);
                a.setWillNotDraw(true);
                ckVar.mo4763b(a);
                C0667de bb = a.mo4812bb();
                bb.mo4826a("/invalidRequest", ckVar.f1689oz);
                bb.mo4826a("/loadAdURL", ckVar.f1686oA);
                bb.mo4826a("/log", C0528aq.f1256mb);
                C0662da.m1551s("Getting the ad request URL.");
                a.loadDataWithBaseURL("http://googleads.g.doubleclick.net", "<!DOCTYPE html><html><head><script src=\"http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.js\"></script><script>AFMA_buildAdURL(" + a + ");</script></head><body></body></html>", "text/html", "UTF-8", null);
            }
        });
        String aI = ckVar.mo4762aI();
        return TextUtils.isEmpty(aI) ? new C0628cf(ckVar.getErrorCode()) : m1436a(context, cdVar.f1646kN.f1798pU, aI);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        com.google.android.gms.internal.C0662da.m1555w("Received error HTTP response code: " + r6);
        r1 = new com.google.android.gms.internal.C0628cf(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r0.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.C0628cf m1436a(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = 300(0x12c, float:4.2E-43)
            r0 = 0
            com.google.android.gms.internal.cl r3 = new com.google.android.gms.internal.cl     // Catch:{ IOException -> 0x00b8 }
            r3.<init>()     // Catch:{ IOException -> 0x00b8 }
            java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00b8 }
            r1.<init>(r12)     // Catch:{ IOException -> 0x00b8 }
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00b8 }
            r2 = r1
            r1 = r0
        L_0x0013:
            java.net.URLConnection r0 = r2.openConnection()     // Catch:{ IOException -> 0x00b8 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x00b8 }
            r6 = 0
            com.google.android.gms.internal.C0653cv.m1505a(r10, r11, r6, r0)     // Catch:{ all -> 0x00db }
            int r6 = r0.getResponseCode()     // Catch:{ all -> 0x00db }
            java.util.Map r7 = r0.getHeaderFields()     // Catch:{ all -> 0x00db }
            r8 = 200(0xc8, float:2.8E-43)
            if (r6 < r8) goto L_0x004b
            if (r6 >= r9) goto L_0x004b
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00db }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x00db }
            java.io.InputStream r8 = r0.getInputStream()     // Catch:{ all -> 0x00db }
            r2.<init>(r8)     // Catch:{ all -> 0x00db }
            java.lang.String r2 = com.google.android.gms.internal.C0653cv.m1499a(r2)     // Catch:{ all -> 0x00db }
            m1438a(r1, r7, r2, r6)     // Catch:{ all -> 0x00db }
            r3.mo4765a(r1, r7, r2)     // Catch:{ all -> 0x00db }
            com.google.android.gms.internal.cf r1 = r3.mo4767f(r4)     // Catch:{ all -> 0x00db }
            r0.disconnect()     // Catch:{ IOException -> 0x00b8 }
            r0 = r1
        L_0x004a:
            return r0
        L_0x004b:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00db }
            r8 = 0
            m1438a(r2, r7, r8, r6)     // Catch:{ all -> 0x00db }
            if (r6 < r9) goto L_0x008f
            r2 = 400(0x190, float:5.6E-43)
            if (r6 >= r2) goto L_0x008f
            java.lang.String r2 = "Location"
            java.lang.String r6 = r0.getHeaderField(r2)     // Catch:{ all -> 0x00db }
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00db }
            if (r2 == 0) goto L_0x0075
            java.lang.String r1 = "No location header to follow redirect."
            com.google.android.gms.internal.C0662da.m1555w(r1)     // Catch:{ all -> 0x00db }
            com.google.android.gms.internal.cf r1 = new com.google.android.gms.internal.cf     // Catch:{ all -> 0x00db }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x00db }
            r0.disconnect()     // Catch:{ IOException -> 0x00b8 }
            r0 = r1
            goto L_0x004a
        L_0x0075:
            java.net.URL r2 = new java.net.URL     // Catch:{ all -> 0x00db }
            r2.<init>(r6)     // Catch:{ all -> 0x00db }
            int r1 = r1 + 1
            r6 = 5
            if (r1 <= r6) goto L_0x00b0
            java.lang.String r1 = "Too many redirects."
            com.google.android.gms.internal.C0662da.m1555w(r1)     // Catch:{ all -> 0x00db }
            com.google.android.gms.internal.cf r1 = new com.google.android.gms.internal.cf     // Catch:{ all -> 0x00db }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x00db }
            r0.disconnect()     // Catch:{ IOException -> 0x00b8 }
            r0 = r1
            goto L_0x004a
        L_0x008f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00db }
            r1.<init>()     // Catch:{ all -> 0x00db }
            java.lang.String r2 = "Received error HTTP response code: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x00db }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00db }
            com.google.android.gms.internal.C0662da.m1555w(r1)     // Catch:{ all -> 0x00db }
            com.google.android.gms.internal.cf r1 = new com.google.android.gms.internal.cf     // Catch:{ all -> 0x00db }
            r2 = 0
            r1.<init>(r2)     // Catch:{ all -> 0x00db }
            r0.disconnect()     // Catch:{ IOException -> 0x00b8 }
            r0 = r1
            goto L_0x004a
        L_0x00b0:
            r3.mo4766d(r7)     // Catch:{ all -> 0x00db }
            r0.disconnect()     // Catch:{ IOException -> 0x00b8 }
            goto L_0x0013
        L_0x00b8:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error while connecting to ad server: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.C0662da.m1555w(r0)
            com.google.android.gms.internal.cf r0 = new com.google.android.gms.internal.cf
            r1 = 2
            r0.<init>(r1)
            goto L_0x004a
        L_0x00db:
            r1 = move-exception
            r0.disconnect()     // Catch:{ IOException -> 0x00b8 }
            throw r1     // Catch:{ IOException -> 0x00b8 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0633ci.m1436a(android.content.Context, java.lang.String, java.lang.String):com.google.android.gms.internal.cf");
    }

    /* renamed from: a */
    public static C0633ci m1437a(Context context, C0539au auVar) {
        C0633ci ciVar;
        synchronized (f1675op) {
            if (f1676oq == null) {
                f1676oq = new C0633ci(context.getApplicationContext(), auVar);
            }
            ciVar = f1676oq;
        }
        return ciVar;
    }

    /* renamed from: a */
    private static void m1438a(String str, Map<String, List<String>> map, String str2, int i) {
        if (C0662da.m1550n(2)) {
            C0662da.m1554v("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    C0662da.m1554v("    " + str3 + ":");
                    for (String str4 : (List) map.get(str3)) {
                        C0662da.m1554v("      " + str4);
                    }
                }
            }
            C0662da.m1554v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    C0662da.m1554v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                C0662da.m1554v("    null");
            }
            C0662da.m1554v("  Response Code:\n    " + i + "\n}");
        }
    }

    /* renamed from: b */
    public C0628cf mo4757b(C0625cd cdVar) {
        return m1435a(this.mContext, this.f1677or, cdVar);
    }
}
