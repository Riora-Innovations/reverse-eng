package com.google.android.gms.internal;

/* renamed from: com.google.android.gms.internal.fn */
public final class C0808fn implements C0806fl {

    /* renamed from: CN */
    private static C0808fn f2305CN;

    /* renamed from: eI */
    public static synchronized C0806fl m2115eI() {
        C0808fn fnVar;
        synchronized (C0808fn.class) {
            if (f2305CN == null) {
                f2305CN = new C0808fn();
            }
            fnVar = f2305CN;
        }
        return fnVar;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
