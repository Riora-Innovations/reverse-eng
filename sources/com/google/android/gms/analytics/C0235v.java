package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0208k.C0209a;

/* renamed from: com.google.android.gms.analytics.v */
class C0235v extends C0208k<C0237w> {

    /* renamed from: com.google.android.gms.analytics.v$a */
    private static class C0236a implements C0209a<C0237w> {

        /* renamed from: tx */
        private final C0237w f329tx = new C0237w();

        /* renamed from: a */
        public void mo2903a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.f329tx.f334tz = i;
            } else {
                C0181aa.m75w("int configuration name not recognized:  " + str);
            }
        }

        /* renamed from: a */
        public void mo2904a(String str, String str2) {
        }

        /* renamed from: b */
        public void mo2905b(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.f329tx.f330qR = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.f329tx.f331qS = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.f329tx.f333ty = str2;
            } else {
                C0181aa.m75w("string configuration name not recognized:  " + str);
            }
        }

        /* renamed from: bU */
        public C0237w mo2906bz() {
            return this.f329tx;
        }

        /* renamed from: c */
        public void mo2907c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.f329tx.f332tA = z ? 1 : 0;
                return;
            }
            C0181aa.m75w("bool configuration name not recognized:  " + str);
        }
    }

    public C0235v(Context context) {
        super(context, new C0236a());
    }
}
