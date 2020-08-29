package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.text.TextUtils;
import com.google.android.gms.internal.C0680di;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.google.android.gms.analytics.t */
class C0228t extends Thread implements C0202f {

    /* renamed from: sd */
    private static C0228t f249sd;
    private volatile boolean mClosed = false;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: qX */
    public volatile String f250qX;

    /* renamed from: rZ */
    private final LinkedBlockingQueue<Runnable> f251rZ = new LinkedBlockingQueue<>();

    /* renamed from: sa */
    private volatile boolean f252sa = false;
    /* access modifiers changed from: private */

    /* renamed from: sb */
    public volatile List<C0680di> f253sb;
    /* access modifiers changed from: private */

    /* renamed from: sc */
    public volatile String f254sc;
    /* access modifiers changed from: private */

    /* renamed from: se */
    public volatile C0189ag f255se;

    private C0228t(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    /* renamed from: C */
    static int m242C(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = ((i << 6) & 65535) + charAt + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    private String m245a(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public String m254o(Map<String, String> map) {
        return map.containsKey("useSecure") ? C0194ak.m142d((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public boolean m255p(Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = C0194ak.m139a((String) map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (m242C((String) map.get("&cid")) % 10000)) < a * 100.0d) {
            return false;
        }
        C0181aa.m74v(String.format("%s hit sampled out", new Object[]{map.get("&t") == null ? EnvironmentCompat.MEDIA_UNKNOWN : (String) map.get("&t")}));
        return true;
    }

    /* renamed from: q */
    static C0228t m256q(Context context) {
        if (f249sd == null) {
            f249sd = new C0228t(context);
        }
        return f249sd;
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m257q(Map<String, String> map) {
        C0211m m = C0180a.m70m(this.mContext);
        C0194ak.m141a(map, "&adid", m.getValue("&adid"));
        C0194ak.m141a(map, "&ate", m.getValue("&ate"));
    }

    /* renamed from: r */
    static String m258r(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                C0181aa.m72t("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                C0181aa.m75w("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            C0181aa.m73u("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            C0181aa.m73u("No campaign data found.");
            return null;
        } catch (IOException e2) {
            C0181aa.m72t("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m259r(Map<String, String> map) {
        C0203g bt = C0203g.m169bt();
        C0194ak.m141a(map, "&an", bt.getValue("&an"));
        C0194ak.m141a(map, "&av", bt.getValue("&av"));
        C0194ak.m141a(map, "&aid", bt.getValue("&aid"));
        C0194ak.m141a(map, "&aiid", bt.getValue("&aiid"));
        map.put("&v", "1");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2962a(Runnable runnable) {
        this.f251rZ.add(runnable);
    }

    /* renamed from: bk */
    public void mo2934bk() {
        mo2962a((Runnable) new Runnable() {
            public void run() {
                C0228t.this.f255se.mo2895bk();
            }
        });
    }

    /* renamed from: bp */
    public void mo2935bp() {
        mo2962a((Runnable) new Runnable() {
            public void run() {
                C0228t.this.f255se.mo2896bp();
            }
        });
    }

    /* renamed from: br */
    public void mo2936br() {
        mo2962a((Runnable) new Runnable() {
            public void run() {
                C0228t.this.f255se.mo2897br();
            }
        });
    }

    /* renamed from: bs */
    public LinkedBlockingQueue<Runnable> mo2937bs() {
        return this.f251rZ;
    }

    public Thread getThread() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.f255se.mo2894bI();
        this.f253sb = new ArrayList();
        this.f253sb.add(new C0680di("appendVersion", "&_v".substring(1), "ma4.0.0"));
        this.f253sb.add(new C0680di("appendQueueTime", "&qt".substring(1), null));
        this.f253sb.add(new C0680di("appendCacheBuster", "&z".substring(1), null));
    }

    /* renamed from: n */
    public void mo2939n(Map<String, String> map) {
        final HashMap hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        mo2962a((Runnable) new Runnable() {
            public void run() {
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&cid"))) {
                    hashMap.put("&cid", C0228t.this.f250qX);
                }
                if (!GoogleAnalytics.getInstance(C0228t.this.mContext).getAppOptOut() && !C0228t.this.m255p(hashMap)) {
                    if (!TextUtils.isEmpty(C0228t.this.f254sc)) {
                        C0233u.m266bR().mo2972r(true);
                        hashMap.putAll(new HitBuilder().setCampaignParamsFromUrl(C0228t.this.f254sc).build());
                        C0233u.m266bR().mo2972r(false);
                        C0228t.this.f254sc = null;
                    }
                    C0228t.this.m259r(hashMap);
                    C0228t.this.m257q(hashMap);
                    C0228t.this.f255se.mo2893b(C0239y.m294s(hashMap), Long.valueOf((String) hashMap.get("&ht")).longValue(), C0228t.this.m254o(hashMap), C0228t.this.f253sb);
                }
            }
        });
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            C0181aa.m75w("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.f255se == null) {
                this.f255se = new C0219s(this.mContext, this);
            }
            init();
            this.f250qX = C0204h.m175bu().getValue("&cid");
            if (this.f250qX == null) {
                this.f252sa = true;
            }
            this.f254sc = m258r(this.mContext);
            C0181aa.m74v("Initialized GA Thread");
        } catch (Throwable th) {
            C0181aa.m72t("Error initializing the GAThread: " + m245a(th));
            C0181aa.m72t("Google Analytics will not start up.");
            this.f252sa = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.f251rZ.take();
                if (!this.f252sa) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                C0181aa.m73u(e2.toString());
            } catch (Throwable th2) {
                C0181aa.m72t("Error on GAThread: " + m245a(th2));
                C0181aa.m72t("Google Analytics is shutting down.");
                this.f252sa = true;
            }
        }
    }
}
