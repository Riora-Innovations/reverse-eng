package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.analytics.C0233u.C0234a;
import com.google.android.gms.internal.C0766er;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Tracker {

    /* renamed from: up */
    private final TrackerHandler f118up;

    /* renamed from: uq */
    private final Map<String, String> f119uq;

    /* renamed from: ur */
    private C0186ad f120ur;

    /* renamed from: us */
    private final C0204h f121us;

    /* renamed from: ut */
    private final C0187ae f122ut;

    /* renamed from: uu */
    private final C0203g f123uu;

    /* renamed from: uv */
    private boolean f124uv;
    /* access modifiers changed from: private */

    /* renamed from: uw */
    public C0177a f125uw;
    /* access modifiers changed from: private */

    /* renamed from: ux */
    public C0193aj f126ux;

    /* renamed from: com.google.android.gms.analytics.Tracker$a */
    private class C0177a implements C0174a {

        /* renamed from: rJ */
        private C0206i f127rJ;
        /* access modifiers changed from: private */

        /* renamed from: uA */
        public boolean f128uA = false;

        /* renamed from: uB */
        private boolean f129uB = false;

        /* renamed from: uC */
        private int f130uC = 0;

        /* renamed from: uD */
        private long f131uD = -1;

        /* renamed from: uE */
        private boolean f132uE = false;

        /* renamed from: uF */
        private long f133uF;

        /* renamed from: uy */
        private Timer f135uy;

        /* renamed from: uz */
        private TimerTask f136uz;

        /* renamed from: com.google.android.gms.analytics.Tracker$a$a */
        private class C0179a extends TimerTask {
            private C0179a() {
            }

            public void run() {
                C0177a.this.f128uA = false;
            }
        }

        public C0177a() {
            this.f127rJ = new C0206i(Tracker.this) {
                public long currentTimeMillis() {
                    return System.currentTimeMillis();
                }
            };
        }

        /* renamed from: cx */
        private void m60cx() {
            GoogleAnalytics cf = GoogleAnalytics.m44cf();
            if (cf == null) {
                C0181aa.m72t("GoogleAnalytics isn't initialized for the Tracker!");
            } else if (this.f131uD >= 0 || this.f129uB) {
                cf.mo2760a((C0174a) Tracker.this.f125uw);
            } else {
                cf.mo2762b(Tracker.this.f125uw);
            }
        }

        /* renamed from: cy */
        private synchronized void m61cy() {
            if (this.f135uy != null) {
                this.f135uy.cancel();
                this.f135uy = null;
            }
        }

        /* renamed from: cu */
        public long mo2861cu() {
            return this.f131uD;
        }

        /* renamed from: cv */
        public boolean mo2862cv() {
            return this.f129uB;
        }

        /* renamed from: cw */
        public boolean mo2863cw() {
            boolean z = this.f132uE;
            this.f132uE = false;
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: cz */
        public boolean mo2864cz() {
            return this.f131uD == 0 || (this.f131uD > 0 && this.f127rJ.currentTimeMillis() > this.f133uF + this.f131uD);
        }

        public void enableAutoActivityTracking(boolean enabled) {
            this.f129uB = enabled;
            m60cx();
        }

        /* renamed from: f */
        public void mo2777f(Activity activity) {
            C0233u.m266bR().mo2969a(C0234a.EASY_TRACKER_ACTIVITY_START);
            m61cy();
            if (!this.f128uA && this.f130uC == 0 && mo2864cz()) {
                this.f132uE = true;
            }
            this.f128uA = true;
            this.f130uC++;
            if (this.f129uB) {
                HashMap hashMap = new HashMap();
                hashMap.put("&t", "appview");
                C0233u.m266bR().mo2972r(true);
                Tracker.this.set("&cd", Tracker.this.f126ux != null ? Tracker.this.f126ux.mo2921h(activity) : activity.getClass().getCanonicalName());
                Tracker.this.send(hashMap);
                C0233u.m266bR().mo2972r(false);
            }
        }

        /* renamed from: g */
        public void mo2778g(Activity activity) {
            C0233u.m266bR().mo2969a(C0234a.EASY_TRACKER_ACTIVITY_STOP);
            this.f130uC--;
            this.f130uC = Math.max(0, this.f130uC);
            this.f133uF = this.f127rJ.currentTimeMillis();
            if (this.f130uC == 0) {
                m61cy();
                this.f136uz = new C0179a();
                this.f135uy = new Timer("waitForActivityStart");
                this.f135uy.schedule(this.f136uz, 1000);
            }
        }

        public void setSessionTimeout(long sessionTimeout) {
            this.f131uD = sessionTimeout;
            m60cx();
        }
    }

    Tracker(String trackingId, TrackerHandler handler) {
        this(trackingId, handler, C0204h.m175bu(), C0187ae.m100cs(), C0203g.m169bt(), new C0240z("tracking"));
    }

    Tracker(String trackingId, TrackerHandler handler, C0204h clientIdDefaultProvider, C0187ae screenResolutionDefaultProvider, C0203g appFieldsDefaultProvider, C0186ad rateLimiter) {
        this.f119uq = new HashMap();
        this.f118up = handler;
        if (trackingId != null) {
            this.f119uq.put("&tid", trackingId);
        }
        this.f119uq.put("useSecure", "1");
        this.f121us = clientIdDefaultProvider;
        this.f122ut = screenResolutionDefaultProvider;
        this.f123uu = appFieldsDefaultProvider;
        this.f120ur = rateLimiter;
        this.f125uw = new C0177a();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo2833a(Context context, C0193aj ajVar) {
        C0181aa.m74v("Loading Tracker config values.");
        this.f126ux = ajVar;
        if (this.f126ux.mo2910cB()) {
            String cC = this.f126ux.mo2911cC();
            set("&tid", cC);
            C0181aa.m74v("[Tracker] trackingId loaded: " + cC);
        }
        if (this.f126ux.mo2912cD()) {
            String d = Double.toString(this.f126ux.mo2913cE());
            set("&sf", d);
            C0181aa.m74v("[Tracker] sample frequency loaded: " + d);
        }
        if (this.f126ux.mo2914cF()) {
            setSessionTimeout((long) this.f126ux.getSessionTimeout());
            C0181aa.m74v("[Tracker] session timeout loaded: " + mo2834cu());
        }
        if (this.f126ux.mo2915cG()) {
            enableAutoActivityTracking(this.f126ux.mo2916cH());
            C0181aa.m74v("[Tracker] auto activity tracking loaded: " + mo2835cv());
        }
        if (this.f126ux.mo2917cI()) {
            if (this.f126ux.mo2918cJ()) {
                set("&aip", "1");
                C0181aa.m74v("[Tracker] anonymize ip loaded: true");
            }
            C0181aa.m74v("[Tracker] anonymize ip loaded: false");
        }
        this.f124uv = this.f126ux.mo2919cK();
        if (this.f126ux.mo2919cK()) {
            Thread.setDefaultUncaughtExceptionHandler(new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), context));
            C0181aa.m74v("[Tracker] report uncaught exceptions loaded: " + this.f124uv);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cu */
    public long mo2834cu() {
        return this.f125uw.mo2861cu();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cv */
    public boolean mo2835cv() {
        return this.f125uw.mo2862cv();
    }

    public void enableAdvertisingIdCollection(boolean enabled) {
        if (!enabled) {
            this.f119uq.put("&ate", null);
            this.f119uq.put("&adid", null);
            return;
        }
        if (this.f119uq.containsKey("&ate")) {
            this.f119uq.remove("&ate");
        }
        if (this.f119uq.containsKey("&adid")) {
            this.f119uq.remove("&adid");
        }
    }

    public void enableAutoActivityTracking(boolean enabled) {
        this.f125uw.enableAutoActivityTracking(enabled);
    }

    public String get(String key) {
        C0233u.m266bR().mo2969a(C0234a.GET);
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        if (this.f119uq.containsKey(key)) {
            return (String) this.f119uq.get(key);
        }
        if (key.equals("&ul")) {
            return C0194ak.m140a(Locale.getDefault());
        }
        if (this.f121us != null && this.f121us.mo2943x(key)) {
            return this.f121us.getValue(key);
        }
        if (this.f122ut != null && this.f122ut.mo2888x(key)) {
            return this.f122ut.getValue(key);
        }
        if (this.f123uu == null || !this.f123uu.mo2940x(key)) {
            return null;
        }
        return this.f123uu.getValue(key);
    }

    public void send(Map<String, String> params) {
        C0233u.m266bR().mo2969a(C0234a.SEND);
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f119uq);
        if (params != null) {
            hashMap.putAll(params);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            C0181aa.m75w(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str)) {
            C0181aa.m75w(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str = "";
        }
        if (this.f125uw.mo2863cw()) {
            hashMap.put("&sc", "start");
        }
        if (str.equals("transaction") || str.equals("item") || this.f120ur.mo2886cl()) {
            this.f118up.mo2768n(hashMap);
        } else {
            C0181aa.m75w("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void set(String key, String value) {
        C0766er.m1975b(key, (Object) "Key should be non-null");
        C0233u.m266bR().mo2969a(C0234a.SET);
        this.f119uq.put(key, value);
    }

    public void setAnonymizeIp(boolean anonymize) {
        set("&aip", C0194ak.m143s(anonymize));
    }

    public void setAppId(String appId) {
        set("&aid", appId);
    }

    public void setAppInstallerId(String appInstallerId) {
        set("&aiid", appInstallerId);
    }

    public void setAppName(String appName) {
        set("&an", appName);
    }

    public void setAppVersion(String appVersion) {
        set("&av", appVersion);
    }

    public void setClientId(String clientId) {
        set("&cid", clientId);
    }

    public void setEncoding(String encoding) {
        set("&de", encoding);
    }

    public void setHostname(String hostname) {
        set("&dh", hostname);
    }

    public void setLanguage(String language) {
        set("&ul", language);
    }

    public void setLocation(String location) {
        set("&dl", location);
    }

    public void setPage(String page) {
        set("&dp", page);
    }

    public void setReferrer(String referrer) {
        set("&dr", referrer);
    }

    public void setSampleRate(double sampleRate) {
        set("&sf", Double.toHexString(sampleRate));
    }

    public void setScreenColors(String screenColors) {
        set("&sd", screenColors);
    }

    public void setScreenName(String screenName) {
        set("&cd", screenName);
    }

    public void setScreenResolution(int width, int height) {
        if (width >= 0 || height >= 0) {
            set("&sr", width + "x" + height);
        } else {
            C0181aa.m75w("Invalid width or height. The values should be non-negative.");
        }
    }

    public void setSessionTimeout(long sessionTimeout) {
        this.f125uw.setSessionTimeout(1000 * sessionTimeout);
    }

    public void setTitle(String title) {
        set("&dt", title);
    }

    public void setUseSecure(boolean useSecure) {
        set("useSecure", C0194ak.m143s(useSecure));
    }

    public void setViewportSize(String viewportSize) {
        set("&vp", viewportSize);
    }
}
