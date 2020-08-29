package com.google.android.gms.analytics;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.analytics.x */
class C0238x {

    /* renamed from: tK */
    private String f335tK;

    /* renamed from: tL */
    private final long f336tL;

    /* renamed from: tM */
    private final long f337tM;

    /* renamed from: tN */
    private String f338tN = "https:";

    C0238x(String str, long j, long j2) {
        this.f335tK = str;
        this.f336tL = j;
        this.f337tM = j2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: E */
    public void mo2984E(String str) {
        this.f335tK = str;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: F */
    public void mo2985F(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.f338tN = "http:";
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ch */
    public String mo2986ch() {
        return this.f335tK;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ci */
    public long mo2987ci() {
        return this.f336tL;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cj */
    public long mo2988cj() {
        return this.f337tM;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ck */
    public String mo2989ck() {
        return this.f338tN;
    }
}
