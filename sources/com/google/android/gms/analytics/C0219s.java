package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0196c.C0198b;
import com.google.android.gms.analytics.C0196c.C0199c;
import com.google.android.gms.internal.C0680di;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.google.android.gms.analytics.s */
class C0219s implements C0189ag, C0198b, C0199c {
    private final Context mContext;

    /* renamed from: rA */
    private final GoogleAnalytics f213rA;
    /* access modifiers changed from: private */

    /* renamed from: rB */
    public final Queue<C0226d> f214rB;

    /* renamed from: rC */
    private volatile int f215rC;

    /* renamed from: rD */
    private volatile Timer f216rD;

    /* renamed from: rE */
    private volatile Timer f217rE;
    /* access modifiers changed from: private */

    /* renamed from: rF */
    public volatile Timer f218rF;

    /* renamed from: rG */
    private boolean f219rG;

    /* renamed from: rH */
    private boolean f220rH;

    /* renamed from: rI */
    private boolean f221rI;
    /* access modifiers changed from: private */

    /* renamed from: rJ */
    public C0206i f222rJ;
    /* access modifiers changed from: private */

    /* renamed from: rK */
    public long f223rK;

    /* renamed from: rj */
    private C0200d f224rj;

    /* renamed from: rk */
    private final C0202f f225rk;

    /* renamed from: rm */
    private boolean f226rm;
    /* access modifiers changed from: private */

    /* renamed from: rw */
    public volatile long f227rw;
    /* access modifiers changed from: private */

    /* renamed from: rx */
    public volatile C0223a f228rx;

    /* renamed from: ry */
    private volatile C0195b f229ry;

    /* renamed from: rz */
    private C0200d f230rz;

    /* renamed from: com.google.android.gms.analytics.s$a */
    private enum C0223a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    /* renamed from: com.google.android.gms.analytics.s$b */
    private class C0224b extends TimerTask {
        private C0224b() {
        }

        public void run() {
            if (C0219s.this.f228rx != C0223a.CONNECTED_SERVICE || !C0219s.this.f214rB.isEmpty() || C0219s.this.f227rw + C0219s.this.f223rK >= C0219s.this.f222rJ.currentTimeMillis()) {
                C0219s.this.f218rF.schedule(new C0224b(), C0219s.this.f223rK);
                return;
            }
            C0181aa.m74v("Disconnecting due to inactivity");
            C0219s.this.m217aD();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$c */
    private class C0225c extends TimerTask {
        private C0225c() {
        }

        public void run() {
            if (C0219s.this.f228rx == C0223a.CONNECTING) {
                C0219s.this.m222bL();
            }
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$d */
    private static class C0226d {

        /* renamed from: rV */
        private final Map<String, String> f244rV;

        /* renamed from: rW */
        private final long f245rW;

        /* renamed from: rX */
        private final String f246rX;

        /* renamed from: rY */
        private final List<C0680di> f247rY;

        public C0226d(Map<String, String> map, long j, String str, List<C0680di> list) {
            this.f244rV = map;
            this.f245rW = j;
            this.f246rX = str;
            this.f247rY = list;
        }

        /* renamed from: bO */
        public Map<String, String> mo2956bO() {
            return this.f244rV;
        }

        /* renamed from: bP */
        public long mo2957bP() {
            return this.f245rW;
        }

        /* renamed from: bQ */
        public List<C0680di> mo2958bQ() {
            return this.f247rY;
        }

        public String getPath() {
            return this.f246rX;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PATH: ");
            sb.append(this.f246rX);
            if (this.f244rV != null) {
                sb.append("  PARAMS: ");
                for (Entry entry : this.f244rV.entrySet()) {
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                    sb.append(",  ");
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: com.google.android.gms.analytics.s$e */
    private class C0227e extends TimerTask {
        private C0227e() {
        }

        public void run() {
            C0219s.this.m223bM();
        }
    }

    C0219s(Context context, C0202f fVar) {
        this(context, fVar, null, GoogleAnalytics.getInstance(context));
    }

    C0219s(Context context, C0202f fVar, C0200d dVar, GoogleAnalytics googleAnalytics) {
        this.f214rB = new ConcurrentLinkedQueue();
        this.f223rK = 300000;
        this.f230rz = dVar;
        this.mContext = context;
        this.f225rk = fVar;
        this.f213rA = googleAnalytics;
        this.f222rJ = new C0206i() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.f215rC = 0;
        this.f228rx = C0223a.DISCONNECTED;
    }

    /* renamed from: a */
    private Timer m215a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: aD */
    public synchronized void m217aD() {
        if (this.f229ry != null && this.f228rx == C0223a.CONNECTED_SERVICE) {
            this.f228rx = C0223a.PENDING_DISCONNECT;
            this.f229ry.disconnect();
        }
    }

    /* renamed from: bH */
    private void m219bH() {
        this.f216rD = m215a(this.f216rD);
        this.f217rE = m215a(this.f217rE);
        this.f218rF = m215a(this.f218rF);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        if (r7.f214rB.isEmpty() != false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r6 = (com.google.android.gms.analytics.C0219s.C0226d) r7.f214rB.poll();
        com.google.android.gms.analytics.C0181aa.m74v("Sending hit to store  " + r6);
        r7.f224rj.mo2872a(r6.mo2956bO(), r6.mo2957bP(), r6.getPath(), r6.mo2958bQ());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (r7.f226rm == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        m221bK();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d0, code lost:
        r7.f227rw = r7.f222rJ.currentTimeMillis();
     */
    /* renamed from: bJ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m220bJ() {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.f r2 = r7.f225rk     // Catch:{ all -> 0x0074 }
            java.lang.Thread r2 = r2.getThread()     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x0021
            com.google.android.gms.analytics.f r1 = r7.f225rk     // Catch:{ all -> 0x0074 }
            java.util.concurrent.LinkedBlockingQueue r1 = r1.mo2937bs()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.s$2 r2 = new com.google.android.gms.analytics.s$2     // Catch:{ all -> 0x0074 }
            r2.<init>()     // Catch:{ all -> 0x0074 }
            r1.add(r2)     // Catch:{ all -> 0x0074 }
        L_0x001f:
            monitor-exit(r7)
            return
        L_0x0021:
            boolean r1 = r7.f219rG     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0028
            r7.mo2895bk()     // Catch:{ all -> 0x0074 }
        L_0x0028:
            int[] r1 = com.google.android.gms.analytics.C0219s.C02223.f233rM     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.s$a r2 = r7.f228rx     // Catch:{ all -> 0x0074 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0074 }
            r1 = r1[r2]     // Catch:{ all -> 0x0074 }
            switch(r1) {
                case 1: goto L_0x0036;
                case 2: goto L_0x007f;
                case 3: goto L_0x0035;
                case 4: goto L_0x0035;
                case 5: goto L_0x0035;
                case 6: goto L_0x00da;
                default: goto L_0x0035;
            }     // Catch:{ all -> 0x0074 }
        L_0x0035:
            goto L_0x001f
        L_0x0036:
            java.util.Queue<com.google.android.gms.analytics.s$d> r1 = r7.f214rB     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x0077
            java.util.Queue<com.google.android.gms.analytics.s$d> r1 = r7.f214rB     // Catch:{ all -> 0x0074 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0074 }
            r0 = r1
            com.google.android.gms.analytics.s$d r0 = (com.google.android.gms.analytics.C0219s.C0226d) r0     // Catch:{ all -> 0x0074 }
            r6 = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "Sending hit to store  "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.C0181aa.m74v(r1)     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.d r1 = r7.f224rj     // Catch:{ all -> 0x0074 }
            java.util.Map r2 = r6.mo2956bO()     // Catch:{ all -> 0x0074 }
            long r3 = r6.mo2957bP()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = r6.getPath()     // Catch:{ all -> 0x0074 }
            java.util.List r6 = r6.mo2958bQ()     // Catch:{ all -> 0x0074 }
            r1.mo2872a(r2, r3, r5, r6)     // Catch:{ all -> 0x0074 }
            goto L_0x0036
        L_0x0074:
            r1 = move-exception
            monitor-exit(r7)
            throw r1
        L_0x0077:
            boolean r1 = r7.f226rm     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x001f
            r7.m221bK()     // Catch:{ all -> 0x0074 }
            goto L_0x001f
        L_0x007f:
            java.util.Queue<com.google.android.gms.analytics.s$d> r1 = r7.f214rB     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x00d0
            java.util.Queue<com.google.android.gms.analytics.s$d> r1 = r7.f214rB     // Catch:{ all -> 0x0074 }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x0074 }
            r0 = r1
            com.google.android.gms.analytics.s$d r0 = (com.google.android.gms.analytics.C0219s.C0226d) r0     // Catch:{ all -> 0x0074 }
            r6 = r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r1.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "Sending hit to service   "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.C0181aa.m74v(r1)     // Catch:{ all -> 0x0074 }
            com.google.android.gms.analytics.GoogleAnalytics r1 = r7.f213rA     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.isDryRunEnabled()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x00ca
            com.google.android.gms.analytics.b r1 = r7.f229ry     // Catch:{ all -> 0x0074 }
            java.util.Map r2 = r6.mo2956bO()     // Catch:{ all -> 0x0074 }
            long r3 = r6.mo2957bP()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = r6.getPath()     // Catch:{ all -> 0x0074 }
            java.util.List r6 = r6.mo2958bQ()     // Catch:{ all -> 0x0074 }
            r1.mo2922a(r2, r3, r5, r6)     // Catch:{ all -> 0x0074 }
        L_0x00c4:
            java.util.Queue<com.google.android.gms.analytics.s$d> r1 = r7.f214rB     // Catch:{ all -> 0x0074 }
            r1.poll()     // Catch:{ all -> 0x0074 }
            goto L_0x007f
        L_0x00ca:
            java.lang.String r1 = "Dry run enabled. Hit not actually sent to service."
            com.google.android.gms.analytics.C0181aa.m74v(r1)     // Catch:{ all -> 0x0074 }
            goto L_0x00c4
        L_0x00d0:
            com.google.android.gms.analytics.i r1 = r7.f222rJ     // Catch:{ all -> 0x0074 }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x0074 }
            r7.f227rw = r1     // Catch:{ all -> 0x0074 }
            goto L_0x001f
        L_0x00da:
            java.lang.String r1 = "Need to reconnect"
            com.google.android.gms.analytics.C0181aa.m74v(r1)     // Catch:{ all -> 0x0074 }
            java.util.Queue<com.google.android.gms.analytics.s$d> r1 = r7.f214rB     // Catch:{ all -> 0x0074 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x001f
            r7.m223bM()     // Catch:{ all -> 0x0074 }
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.C0219s.m220bJ():void");
    }

    /* renamed from: bK */
    private void m221bK() {
        this.f224rj.mo2875bp();
        this.f226rm = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: bL */
    public synchronized void m222bL() {
        if (this.f228rx != C0223a.CONNECTED_LOCAL) {
            m219bH();
            C0181aa.m74v("falling back to local store");
            if (this.f230rz != null) {
                this.f224rj = this.f230rz;
            } else {
                C0216r bB = C0216r.m202bB();
                bB.mo2948a(this.mContext, this.f225rk);
                this.f224rj = bB.mo2950bE();
            }
            this.f228rx = C0223a.CONNECTED_LOCAL;
            m220bJ();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bM */
    public synchronized void m223bM() {
        if (this.f221rI || this.f229ry == null || this.f228rx == C0223a.CONNECTED_LOCAL) {
            C0181aa.m75w("client not initialized.");
            m222bL();
        } else {
            try {
                this.f215rC++;
                m215a(this.f217rE);
                this.f228rx = C0223a.CONNECTING;
                this.f217rE = new Timer("Failed Connect");
                this.f217rE.schedule(new C0225c(), 3000);
                C0181aa.m74v("connecting to Analytics service");
                this.f229ry.connect();
            } catch (SecurityException e) {
                C0181aa.m75w("security exception on connectToService");
                m222bL();
            }
        }
        return;
    }

    /* renamed from: bN */
    private void m224bN() {
        this.f216rD = m215a(this.f216rD);
        this.f216rD = new Timer("Service Reconnect");
        this.f216rD.schedule(new C0227e(), 5000);
    }

    /* renamed from: a */
    public synchronized void mo2932a(int i, Intent intent) {
        this.f228rx = C0223a.PENDING_CONNECTION;
        if (this.f215rC < 2) {
            C0181aa.m75w("Service unavailable (code=" + i + "), will retry.");
            m224bN();
        } else {
            C0181aa.m75w("Service unavailable (code=" + i + "), using local store.");
            m222bL();
        }
    }

    /* renamed from: b */
    public void mo2893b(Map<String, String> map, long j, String str, List<C0680di> list) {
        C0181aa.m74v("putHit called");
        this.f214rB.add(new C0226d(map, j, str, list));
        m220bJ();
    }

    /* renamed from: bI */
    public void mo2894bI() {
        if (this.f229ry == null) {
            this.f229ry = new C0196c(this.mContext, this, this);
            m223bM();
        }
    }

    /* renamed from: bk */
    public void mo2895bk() {
        C0181aa.m74v("clearHits called");
        this.f214rB.clear();
        switch (this.f228rx) {
            case CONNECTED_LOCAL:
                this.f224rj.mo2879i(0);
                this.f219rG = false;
                return;
            case CONNECTED_SERVICE:
                this.f229ry.mo2923bk();
                this.f219rG = false;
                return;
            default:
                this.f219rG = true;
                return;
        }
    }

    /* renamed from: bp */
    public void mo2896bp() {
        switch (this.f228rx) {
            case CONNECTED_LOCAL:
                m221bK();
                return;
            case CONNECTED_SERVICE:
                return;
            default:
                this.f226rm = true;
                return;
        }
    }

    /* renamed from: br */
    public synchronized void mo2897br() {
        if (!this.f221rI) {
            C0181aa.m74v("setForceLocalDispatch called.");
            this.f221rI = true;
            switch (this.f228rx) {
                case CONNECTED_LOCAL:
                case PENDING_CONNECTION:
                case PENDING_DISCONNECT:
                case DISCONNECTED:
                    break;
                case CONNECTED_SERVICE:
                    m217aD();
                    break;
                case CONNECTING:
                    this.f220rH = true;
                    break;
            }
        }
    }

    public synchronized void onConnected() {
        this.f217rE = m215a(this.f217rE);
        this.f215rC = 0;
        C0181aa.m74v("Connected to service");
        this.f228rx = C0223a.CONNECTED_SERVICE;
        if (this.f220rH) {
            m217aD();
            this.f220rH = false;
        } else {
            m220bJ();
            this.f218rF = m215a(this.f218rF);
            this.f218rF = new Timer("disconnect check");
            this.f218rF.schedule(new C0224b(), this.f223rK);
        }
    }

    public synchronized void onDisconnected() {
        if (this.f228rx == C0223a.PENDING_DISCONNECT) {
            C0181aa.m74v("Disconnected from service");
            m219bH();
            this.f228rx = C0223a.DISCONNECTED;
        } else {
            C0181aa.m74v("Unexpected disconnect.");
            this.f228rx = C0223a.PENDING_CONNECTION;
            if (this.f215rC < 2) {
                m224bN();
            } else {
                m222bL();
            }
        }
    }
}
