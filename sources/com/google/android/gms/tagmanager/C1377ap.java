package com.google.android.gms.tagmanager;

import android.text.TextUtils;

/* renamed from: com.google.android.gms.tagmanager.ap */
class C1377ap {

    /* renamed from: UZ */
    private final long f3590UZ;

    /* renamed from: Va */
    private String f3591Va;

    /* renamed from: tL */
    private final long f3592tL;

    /* renamed from: tM */
    private final long f3593tM;

    C1377ap(long j, long j2, long j3) {
        this.f3592tL = j;
        this.f3593tM = j2;
        this.f3590UZ = j3;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: F */
    public void mo7581F(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.f3591Va = str;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ci */
    public long mo7582ci() {
        return this.f3592tL;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: je */
    public long mo7583je() {
        return this.f3590UZ;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jf */
    public String mo7584jf() {
        return this.f3591Va;
    }
}
