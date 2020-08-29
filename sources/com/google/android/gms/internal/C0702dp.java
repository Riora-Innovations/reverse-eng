package com.google.android.gms.internal;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.dp */
public abstract class C0702dp {

    /* renamed from: xA */
    private static final AtomicInteger f1902xA = new AtomicInteger(0);

    /* renamed from: xB */
    protected final C0715du f1903xB;

    /* renamed from: xC */
    private final String f1904xC;

    /* renamed from: xD */
    private C0719dw f1905xD;

    protected C0702dp(String str, String str2) {
        this.f1904xC = str;
        this.f1903xB = new C0715du(str2);
        this.f1903xB.mo4958U(String.format("instance-%d", new Object[]{Integer.valueOf(f1902xA.incrementAndGet())}));
    }

    /* renamed from: P */
    public void mo4906P(String str) {
    }

    /* renamed from: a */
    public void mo4907a(long j, int i) {
    }

    /* renamed from: a */
    public final void mo4908a(C0719dw dwVar) {
        this.f1905xD = dwVar;
        if (this.f1905xD == null) {
            mo4911cX();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo4909a(String str, long j, String str2) throws IOException {
        this.f1903xB.mo4959a("Sending text message: %s to: %s", str, str2);
        this.f1905xD.mo3201a(this.f1904xC, str, j, str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: cW */
    public final long mo4910cW() {
        return this.f1905xD.mo3203cV();
    }

    /* renamed from: cX */
    public void mo4911cX() {
    }

    public final String getNamespace() {
        return this.f1904xC;
    }
}
