package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.analytics.C0233u.C0234a;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class GoogleAnalytics extends TrackerHandler {

    /* renamed from: tB */
    private static boolean f104tB;

    /* renamed from: tI */
    private static GoogleAnalytics f105tI;
    private Context mContext;

    /* renamed from: qR */
    private String f106qR;

    /* renamed from: qS */
    private String f107qS;

    /* renamed from: rk */
    private C0202f f108rk;

    /* renamed from: tC */
    private boolean f109tC;

    /* renamed from: tD */
    private C0188af f110tD;

    /* renamed from: tE */
    private volatile Boolean f111tE;

    /* renamed from: tF */
    private Logger f112tF;

    /* renamed from: tG */
    private Set<C0174a> f113tG;

    /* renamed from: tH */
    private boolean f114tH;

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$a */
    interface C0174a {
        /* renamed from: f */
        void mo2777f(Activity activity);

        /* renamed from: g */
        void mo2778g(Activity activity);
    }

    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$b */
    class C0175b implements ActivityLifecycleCallbacks {
        C0175b() {
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.m46d(activity);
        }

        public void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.m47e(activity);
        }
    }

    protected GoogleAnalytics(Context context) {
        this(context, C0228t.m256q(context), C0216r.m202bB());
    }

    private GoogleAnalytics(Context context, C0202f thread, C0188af serviceManager) {
        this.f111tE = Boolean.valueOf(false);
        this.f114tH = false;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.f108rk = thread;
        this.f110tD = serviceManager;
        C0203g.m170n(this.mContext);
        C0187ae.m101n(this.mContext);
        C0204h.m178n(this.mContext);
        this.f112tF = new C0210l();
        this.f113tG = new HashSet();
        m45cg();
    }

    /* renamed from: D */
    private int m40D(String str) {
        String lowerCase = str.toLowerCase();
        if ("verbose".equals(lowerCase)) {
            return 0;
        }
        if ("info".equals(lowerCase)) {
            return 1;
        }
        if ("warning".equals(lowerCase)) {
            return 2;
        }
        return "error".equals(lowerCase) ? 3 : -1;
    }

    /* renamed from: a */
    private Tracker m41a(Tracker tracker) {
        if (this.f106qR != null) {
            tracker.set("&an", this.f106qR);
        }
        if (this.f107qS != null) {
            tracker.set("&av", this.f107qS);
        }
        return tracker;
    }

    /* renamed from: cf */
    static GoogleAnalytics m44cf() {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            googleAnalytics = f105tI;
        }
        return googleAnalytics;
    }

    /* renamed from: cg */
    private void m45cg() {
        ApplicationInfo applicationInfo;
        if (!f104tB) {
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 129);
            } catch (NameNotFoundException e) {
                C0181aa.m74v("PackageManager doesn't know about package: " + e);
                applicationInfo = null;
            }
            if (applicationInfo == null) {
                C0181aa.m75w("Couldn't get ApplicationInfo to load gloabl config.");
                return;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
                if (i > 0) {
                    C0237w wVar = (C0237w) new C0235v(this.mContext).mo2945p(i);
                    if (wVar != null) {
                        mo2761a(wVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m46d(Activity activity) {
        for (C0174a f : this.f113tG) {
            f.mo2777f(activity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m47e(Activity activity) {
        for (C0174a g : this.f113tG) {
            g.mo2778g(activity);
        }
    }

    public static GoogleAnalytics getInstance(Context context) {
        GoogleAnalytics googleAnalytics;
        synchronized (GoogleAnalytics.class) {
            if (f105tI == null) {
                f105tI = new GoogleAnalytics(context);
            }
            googleAnalytics = f105tI;
        }
        return googleAnalytics;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2760a(C0174a aVar) {
        this.f113tG.add(aVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2761a(C0237w wVar) {
        C0181aa.m74v("Loading global config values.");
        if (wVar.mo2974bV()) {
            this.f106qR = wVar.mo2975bW();
            C0181aa.m74v("app name loaded: " + this.f106qR);
        }
        if (wVar.mo2976bX()) {
            this.f107qS = wVar.mo2977bY();
            C0181aa.m74v("app version loaded: " + this.f107qS);
        }
        if (wVar.mo2978bZ()) {
            int D = m40D(wVar.mo2979ca());
            if (D >= 0) {
                C0181aa.m74v("log level loaded: " + D);
                getLogger().setLogLevel(D);
            }
        }
        if (wVar.mo2980cb()) {
            this.f110tD.setLocalDispatchPeriod(wVar.mo2981cc());
        }
        if (wVar.mo2982cd()) {
            setDryRun(wVar.mo2983ce());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo2762b(C0174a aVar) {
        this.f113tG.remove(aVar);
    }

    @Deprecated
    public void dispatchLocalHits() {
        this.f110tD.dispatchLocalHits();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.f114tH) {
            application.registerActivityLifecycleCallbacks(new C0175b());
            this.f114tH = true;
        }
    }

    public boolean getAppOptOut() {
        C0233u.m266bR().mo2969a(C0234a.GET_APP_OPT_OUT);
        return this.f111tE.booleanValue();
    }

    public Logger getLogger() {
        return this.f112tF;
    }

    public boolean isDryRunEnabled() {
        C0233u.m266bR().mo2969a(C0234a.GET_DRY_RUN);
        return this.f109tC;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: n */
    public void mo2768n(Map<String, String> map) {
        synchronized (this) {
            if (map == null) {
                throw new IllegalArgumentException("hit cannot be null");
            }
            C0194ak.m141a(map, "&ul", C0194ak.m140a(Locale.getDefault()));
            C0194ak.m141a(map, "&sr", C0187ae.m100cs().getValue("&sr"));
            map.put("&_u", C0233u.m266bR().mo2971bT());
            C0233u.m266bR().mo2970bS();
            this.f108rk.mo2939n(map);
        }
    }

    public Tracker newTracker(int configResId) {
        Tracker a;
        synchronized (this) {
            C0233u.m266bR().mo2969a(C0234a.GET_TRACKER);
            Tracker tracker = new Tracker(null, this);
            if (configResId > 0) {
                C0193aj ajVar = (C0193aj) new C0191ai(this.mContext).mo2945p(configResId);
                if (ajVar != null) {
                    tracker.mo2833a(this.mContext, ajVar);
                }
            }
            a = m41a(tracker);
        }
        return a;
    }

    public Tracker newTracker(String trackingId) {
        Tracker a;
        synchronized (this) {
            C0233u.m266bR().mo2969a(C0234a.GET_TRACKER);
            a = m41a(new Tracker(trackingId, this));
        }
        return a;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.f114tH) {
            m46d(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.f114tH) {
            m47e(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        C0233u.m266bR().mo2969a(C0234a.SET_APP_OPT_OUT);
        this.f111tE = Boolean.valueOf(optOut);
        if (this.f111tE.booleanValue()) {
            this.f108rk.mo2934bk();
        }
    }

    public void setDryRun(boolean dryRun) {
        C0233u.m266bR().mo2969a(C0234a.SET_DRY_RUN);
        this.f109tC = dryRun;
    }

    @Deprecated
    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        this.f110tD.setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    public void setLogger(Logger logger) {
        C0233u.m266bR().mo2969a(C0234a.SET_LOGGER);
        this.f112tF = logger;
    }
}
