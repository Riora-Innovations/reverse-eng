package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0608c.C0614f;
import com.google.android.gms.internal.C0608c.C0618j;
import com.google.android.gms.internal.C0806fl;
import com.google.android.gms.internal.C0808fn;
import com.google.android.gms.internal.C1112jd.C1113a;
import com.google.android.gms.tagmanager.C1399bg.C1400a;
import com.google.android.gms.tagmanager.C1449cr.C1453c;
import com.google.android.gms.tagmanager.C1505n.C1506a;

/* renamed from: com.google.android.gms.tagmanager.o */
class C1508o extends C1422ca<ContainerHolder> {

    /* renamed from: TM */
    private final String f3863TM;
    /* access modifiers changed from: private */

    /* renamed from: TR */
    public long f3864TR;

    /* renamed from: TY */
    private final TagManager f3865TY;
    /* access modifiers changed from: private */

    /* renamed from: Ty */
    public final C0806fl f3866Ty;

    /* renamed from: Ub */
    private final C1514d f3867Ub;
    /* access modifiers changed from: private */

    /* renamed from: Uc */
    public final C1432cg f3868Uc;

    /* renamed from: Ud */
    private final int f3869Ud;

    /* renamed from: Ue */
    private C1516f f3870Ue;
    /* access modifiers changed from: private */

    /* renamed from: Uf */
    public volatile C1505n f3871Uf;
    /* access modifiers changed from: private */

    /* renamed from: Ug */
    public volatile boolean f3872Ug;
    /* access modifiers changed from: private */

    /* renamed from: Uh */
    public C0618j f3873Uh;

    /* renamed from: Ui */
    private String f3874Ui;

    /* renamed from: Uj */
    private C1515e f3875Uj;

    /* renamed from: Uk */
    private C1511a f3876Uk;
    private final Context mContext;

    /* renamed from: zs */
    private final Looper f3877zs;

    /* renamed from: com.google.android.gms.tagmanager.o$a */
    interface C1511a {
        /* renamed from: b */
        boolean mo7809b(Container container);
    }

    /* renamed from: com.google.android.gms.tagmanager.o$b */
    private class C1512b implements C1399bg<C1113a> {
        private C1512b() {
        }

        /* renamed from: a */
        public void mo7603i(C1113a aVar) {
            C0618j jVar;
            if (aVar.f3071Yc != null) {
                jVar = aVar.f3071Yc;
            } else {
                C0614f fVar = aVar.f3072fV;
                jVar = new C0618j();
                jVar.f1638fV = fVar;
                jVar.f1637fU = null;
                jVar.f1639fW = fVar.f1608fr;
            }
            C1508o.this.m4447a(jVar, aVar.f3070Yb, true);
        }

        /* renamed from: a */
        public void mo7602a(C1400a aVar) {
            if (!C1508o.this.f3872Ug) {
                C1508o.this.m4458s(0);
            }
        }

        /* renamed from: iM */
        public void mo7604iM() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$c */
    private class C1513c implements C1399bg<C0618j> {
        private C1513c() {
        }

        /* renamed from: a */
        public void mo7602a(C1400a aVar) {
            if (C1508o.this.f3871Uf != null) {
                C1508o.this.mo7643a(C1508o.this.f3871Uf);
            } else {
                C1508o.this.mo7643a(C1508o.this.mo7644d(Status.f520zS));
            }
            C1508o.this.m4458s(3600000);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo7603i(com.google.android.gms.internal.C0608c.C0618j r6) {
            /*
                r5 = this;
                com.google.android.gms.tagmanager.o r1 = com.google.android.gms.tagmanager.C1508o.this
                monitor-enter(r1)
                com.google.android.gms.internal.c$f r0 = r6.f1638fV     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x002a
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C1508o.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.c$j r0 = r0.f3873Uh     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.c$f r0 = r0.f1638fV     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0020
                java.lang.String r0 = "Current resource is null; network resource is also null"
                com.google.android.gms.tagmanager.C1401bh.m4075t(r0)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C1508o.this     // Catch:{ all -> 0x0065 }
                r2 = 3600000(0x36ee80, double:1.7786363E-317)
                r0.m4458s(r2)     // Catch:{ all -> 0x0065 }
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
            L_0x001f:
                return
            L_0x0020:
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C1508o.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.c$j r0 = r0.f3873Uh     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.c$f r0 = r0.f1638fV     // Catch:{ all -> 0x0065 }
                r6.f1638fV = r0     // Catch:{ all -> 0x0065 }
            L_0x002a:
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C1508o.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.o r2 = com.google.android.gms.tagmanager.C1508o.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.fl r2 = r2.f3866Ty     // Catch:{ all -> 0x0065 }
                long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x0065 }
                r4 = 0
                r0.m4447a(r6, r2, r4)     // Catch:{ all -> 0x0065 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
                r0.<init>()     // Catch:{ all -> 0x0065 }
                java.lang.String r2 = "setting refresh time to current time: "
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.o r2 = com.google.android.gms.tagmanager.C1508o.this     // Catch:{ all -> 0x0065 }
                long r2 = r2.f3864TR     // Catch:{ all -> 0x0065 }
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0065 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.C1401bh.m4077v(r0)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C1508o.this     // Catch:{ all -> 0x0065 }
                boolean r0 = r0.m4457iL()     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0063
                com.google.android.gms.tagmanager.o r0 = com.google.android.gms.tagmanager.C1508o.this     // Catch:{ all -> 0x0065 }
                r0.m4446a(r6)     // Catch:{ all -> 0x0065 }
            L_0x0063:
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
                goto L_0x001f
            L_0x0065:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1508o.C1513c.mo7603i(com.google.android.gms.internal.c$j):void");
        }

        /* renamed from: iM */
        public void mo7604iM() {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$d */
    private class C1514d implements C1506a {
        private C1514d() {
        }

        /* renamed from: bc */
        public void mo7797bc(String str) {
            C1508o.this.mo7804bc(str);
        }

        /* renamed from: iF */
        public String mo7798iF() {
            return C1508o.this.mo7805iF();
        }

        /* renamed from: iH */
        public void mo7799iH() {
            if (C1508o.this.f3868Uc.mo7601cl()) {
                C1508o.this.m4458s(0);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.o$e */
    interface C1515e extends Releasable {
        /* renamed from: a */
        void mo7675a(C1399bg<C0618j> bgVar);

        /* renamed from: bf */
        void mo7676bf(String str);

        /* renamed from: d */
        void mo7677d(long j, String str);
    }

    /* renamed from: com.google.android.gms.tagmanager.o$f */
    interface C1516f extends Releasable {
        /* renamed from: a */
        void mo7680a(C1399bg<C1113a> bgVar);

        /* renamed from: b */
        void mo7681b(C1113a aVar);

        /* renamed from: bP */
        C1453c mo7682bP(int i);

        /* renamed from: iN */
        void mo7684iN();
    }

    C1508o(Context context, TagManager tagManager, Looper looper, String str, int i, C1516f fVar, C1515e eVar, C0806fl flVar, C1432cg cgVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.f3865TY = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.f3877zs = looper;
        this.f3863TM = str;
        this.f3869Ud = i;
        this.f3870Ue = fVar;
        this.f3875Uj = eVar;
        this.f3867Ub = new C1514d();
        this.f3873Uh = new C0618j();
        this.f3866Ty = flVar;
        this.f3868Uc = cgVar;
        if (m4457iL()) {
            mo7804bc(C1429ce.m4170ju().mo7669jw());
        }
    }

    public C1508o(Context context, TagManager tagManager, Looper looper, String str, int i, C1519r rVar) {
        this(context, tagManager, looper, str, i, new C1446cq(context, str), new C1441cp(context, str, rVar), C0808fn.m2115eI(), new C1398bf(30, 900000, 5000, "refreshing", C0808fn.m2115eI()));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m4446a(C0618j jVar) {
        if (this.f3870Ue != null) {
            C1113a aVar = new C1113a();
            aVar.f3070Yb = this.f3864TR;
            aVar.f3072fV = new C0614f();
            aVar.f3071Yc = jVar;
            this.f3870Ue.mo7681b(aVar);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r8.f3872Ug != false) goto L_0x000a;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m4447a(com.google.android.gms.internal.C0608c.C0618j r9, long r10, boolean r12) {
        /*
            r8 = this;
            r6 = 43200000(0x2932e00, double:2.1343636E-316)
            monitor-enter(r8)
            if (r12 == 0) goto L_0x000c
            boolean r0 = r8.f3872Ug     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x000c
        L_0x000a:
            monitor-exit(r8)
            return
        L_0x000c:
            boolean r0 = r8.isReady()     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.tagmanager.n r0 = r8.f3871Uf     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0016
        L_0x0016:
            r8.f3873Uh = r9     // Catch:{ all -> 0x006a }
            r8.f3864TR = r10     // Catch:{ all -> 0x006a }
            r0 = 0
            r2 = 43200000(0x2932e00, double:2.1343636E-316)
            long r4 = r8.f3864TR     // Catch:{ all -> 0x006a }
            long r4 = r4 + r6
            com.google.android.gms.internal.fl r6 = r8.f3866Ty     // Catch:{ all -> 0x006a }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x006a }
            long r4 = r4 - r6
            long r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x006a }
            long r0 = java.lang.Math.max(r0, r2)     // Catch:{ all -> 0x006a }
            r8.m4458s(r0)     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.Container r0 = new com.google.android.gms.tagmanager.Container     // Catch:{ all -> 0x006a }
            android.content.Context r1 = r8.mContext     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.TagManager r2 = r8.f3865TY     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.DataLayer r2 = r2.getDataLayer()     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r8.f3863TM     // Catch:{ all -> 0x006a }
            r4 = r10
            r6 = r9
            r0.<init>(r1, r2, r3, r4, r6)     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.n r1 = r8.f3871Uf     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x006d
            com.google.android.gms.tagmanager.n r1 = new com.google.android.gms.tagmanager.n     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.TagManager r2 = r8.f3865TY     // Catch:{ all -> 0x006a }
            android.os.Looper r3 = r8.f3877zs     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.o$d r4 = r8.f3867Ub     // Catch:{ all -> 0x006a }
            r1.<init>(r2, r3, r0, r4)     // Catch:{ all -> 0x006a }
            r8.f3871Uf = r1     // Catch:{ all -> 0x006a }
        L_0x0056:
            boolean r1 = r8.isReady()     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x000a
            com.google.android.gms.tagmanager.o$a r1 = r8.f3876Uk     // Catch:{ all -> 0x006a }
            boolean r0 = r1.mo7809b(r0)     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x000a
            com.google.android.gms.tagmanager.n r0 = r8.f3871Uf     // Catch:{ all -> 0x006a }
            r8.mo7643a(r0)     // Catch:{ all -> 0x006a }
            goto L_0x000a
        L_0x006a:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x006d:
            com.google.android.gms.tagmanager.n r1 = r8.f3871Uf     // Catch:{ all -> 0x006a }
            r1.mo7792a(r0)     // Catch:{ all -> 0x006a }
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.C1508o.m4447a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: iL */
    public boolean m4457iL() {
        C1429ce ju = C1429ce.m4170ju();
        return (ju.mo7668jv() == C1430a.CONTAINER || ju.mo7668jv() == C1430a.CONTAINER_DEBUG) && this.f3863TM.equals(ju.getContainerId());
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public synchronized void m4458s(long j) {
        if (this.f3875Uj == null) {
            C1401bh.m4078w("Refresh requested, but no network load scheduler.");
        } else {
            this.f3875Uj.mo7677d(j, this.f3873Uh.f1639fW);
        }
    }

    /* renamed from: z */
    private void m4459z(final boolean z) {
        this.f3870Ue.mo7680a(new C1512b());
        this.f3875Uj.mo7675a(new C1513c());
        C1453c bP = this.f3870Ue.mo7682bP(this.f3869Ud);
        if (bP != null) {
            this.f3871Uf = new C1505n(this.f3865TY, this.f3877zs, new Container(this.mContext, this.f3865TY.getDataLayer(), this.f3863TM, 0, bP), this.f3867Ub);
        }
        this.f3876Uk = new C1511a() {
            /* renamed from: b */
            public boolean mo7809b(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= C1508o.this.f3866Ty.currentTimeMillis() : !container.isDefault();
            }
        };
        if (m4457iL()) {
            this.f3875Uj.mo7677d(0, "");
        } else {
            this.f3870Ue.mo7684iN();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: O */
    public ContainerHolder mo7644d(Status status) {
        if (this.f3871Uf != null) {
            return this.f3871Uf;
        }
        if (status == Status.f520zS) {
            C1401bh.m4075t("timer expired: setting result to failure");
        }
        return new C1505n(status);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bc */
    public synchronized void mo7804bc(String str) {
        this.f3874Ui = str;
        if (this.f3875Uj != null) {
            this.f3875Uj.mo7676bf(str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: iF */
    public synchronized String mo7805iF() {
        return this.f3874Ui;
    }

    /* renamed from: iI */
    public void mo7806iI() {
        C1453c bP = this.f3870Ue.mo7682bP(this.f3869Ud);
        if (bP != null) {
            mo7643a(new C1505n(this.f3865TY, this.f3877zs, new Container(this.mContext, this.f3865TY.getDataLayer(), this.f3863TM, 0, bP), new C1506a() {
                /* renamed from: bc */
                public void mo7797bc(String str) {
                    C1508o.this.mo7804bc(str);
                }

                /* renamed from: iF */
                public String mo7798iF() {
                    return C1508o.this.mo7805iF();
                }

                /* renamed from: iH */
                public void mo7799iH() {
                    C1401bh.m4078w("Refresh ignored: container loaded as default only.");
                }
            }));
        } else {
            String str = "Default was requested, but no default container was found";
            C1401bh.m4075t(str);
            mo7643a(mo7644d(new Status(10, str, null)));
        }
        this.f3875Uj = null;
        this.f3870Ue = null;
    }

    /* renamed from: iJ */
    public void mo7807iJ() {
        m4459z(false);
    }

    /* renamed from: iK */
    public void mo7808iK() {
        m4459z(true);
    }
}
