package com.google.android.gms.internal;

import android.content.Context;

/* renamed from: com.google.android.gms.internal.aw */
public final class C0541aw {

    /* renamed from: kH */
    private final C0554bf f1260kH;
    private final Context mContext;

    /* renamed from: mf */
    private final C0625cd f1261mf;

    /* renamed from: mg */
    private final Object f1262mg = new Object();

    /* renamed from: mh */
    private final C0544ay f1263mh;

    /* renamed from: mi */
    private boolean f1264mi = false;

    /* renamed from: mj */
    private C0548bb f1265mj;

    public C0541aw(Context context, C0625cd cdVar, C0554bf bfVar, C0544ay ayVar) {
        this.mContext = context;
        this.f1261mf = cdVar;
        this.f1260kH = bfVar;
        this.f1263mh = ayVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0080, code lost:
        r4 = r16.f1265mj.mo4597b(r17, r19);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008e, code lost:
        if (r4.f1488mL != 0) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
        com.google.android.gms.internal.C0662da.m1551s("Adapter succeeded.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009b, code lost:
        if (r4.f1490mN == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009d, code lost:
        com.google.android.gms.internal.C0659cz.f1785pT.post(new com.google.android.gms.internal.C0541aw.C05421(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return r4;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.C0550bc mo4580a(long r17, long r19) {
        /*
            r16 = this;
            java.lang.String r4 = "Starting mediation."
            com.google.android.gms.internal.C0662da.m1551s(r4)
            r0 = r16
            com.google.android.gms.internal.ay r4 = r0.f1263mh
            java.util.List<com.google.android.gms.internal.ax> r4 = r4.f1273mr
            java.util.Iterator r13 = r4.iterator()
        L_0x000f:
            boolean r4 = r13.hasNext()
            if (r4 == 0) goto L_0x00aa
            java.lang.Object r9 = r13.next()
            com.google.android.gms.internal.ax r9 = (com.google.android.gms.internal.C0543ax) r9
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Trying mediation network: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r9.f1268mm
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.C0662da.m1553u(r4)
            java.util.List<java.lang.String> r4 = r9.f1269mn
            java.util.Iterator r14 = r4.iterator()
        L_0x0039:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x000f
            java.lang.Object r6 = r14.next()
            java.lang.String r6 = (java.lang.String) r6
            r0 = r16
            java.lang.Object r15 = r0.f1262mg
            monitor-enter(r15)
            r0 = r16
            boolean r4 = r0.f1264mi     // Catch:{ all -> 0x0096 }
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.internal.bc r4 = new com.google.android.gms.internal.bc     // Catch:{ all -> 0x0096 }
            r5 = -1
            r4.<init>(r5)     // Catch:{ all -> 0x0096 }
            monitor-exit(r15)     // Catch:{ all -> 0x0096 }
        L_0x0057:
            return r4
        L_0x0058:
            com.google.android.gms.internal.bb r4 = new com.google.android.gms.internal.bb     // Catch:{ all -> 0x0096 }
            r0 = r16
            android.content.Context r5 = r0.mContext     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.bf r7 = r0.f1260kH     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.ay r8 = r0.f1263mh     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.cd r10 = r0.f1261mf     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.z r10 = r10.f1649oc     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.cd r11 = r0.f1261mf     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.ab r11 = r11.f1647kQ     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.cd r12 = r0.f1261mf     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.db r12 = r12.f1646kN     // Catch:{ all -> 0x0096 }
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0096 }
            r0 = r16
            r0.f1265mj = r4     // Catch:{ all -> 0x0096 }
            monitor-exit(r15)     // Catch:{ all -> 0x0096 }
            r0 = r16
            com.google.android.gms.internal.bb r4 = r0.f1265mj
            r0 = r17
            r2 = r19
            com.google.android.gms.internal.bc r4 = r4.mo4597b(r0, r2)
            int r5 = r4.f1488mL
            if (r5 != 0) goto L_0x0099
            java.lang.String r5 = "Adapter succeeded."
            com.google.android.gms.internal.C0662da.m1551s(r5)
            goto L_0x0057
        L_0x0096:
            r4 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0096 }
            throw r4
        L_0x0099:
            com.google.android.gms.internal.bg r5 = r4.f1490mN
            if (r5 == 0) goto L_0x0039
            android.os.Handler r5 = com.google.android.gms.internal.C0659cz.f1785pT
            com.google.android.gms.internal.aw$1 r6 = new com.google.android.gms.internal.aw$1
            r0 = r16
            r6.<init>(r4)
            r5.post(r6)
            goto L_0x0039
        L_0x00aa:
            com.google.android.gms.internal.bc r4 = new com.google.android.gms.internal.bc
            r5 = 1
            r4.<init>(r5)
            goto L_0x0057
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.C0541aw.mo4580a(long, long):com.google.android.gms.internal.bc");
    }

    public void cancel() {
        synchronized (this.f1262mg) {
            this.f1264mi = true;
            if (this.f1265mj != null) {
                this.f1265mj.cancel();
            }
        }
    }
}
