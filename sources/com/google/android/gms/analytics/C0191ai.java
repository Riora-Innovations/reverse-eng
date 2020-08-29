package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C0208k.C0209a;

/* renamed from: com.google.android.gms.analytics.ai */
class C0191ai extends C0208k<C0193aj> {

    /* renamed from: com.google.android.gms.analytics.ai$a */
    private static class C0192a implements C0209a<C0193aj> {

        /* renamed from: uJ */
        private final C0193aj f168uJ = new C0193aj();

        /* renamed from: a */
        public void mo2903a(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.f168uJ.f171uM = i;
            } else {
                C0181aa.m75w("int configuration name not recognized:  " + str);
            }
        }

        /* renamed from: a */
        public void mo2904a(String str, String str2) {
            this.f168uJ.f175uQ.put(str, str2);
        }

        /* renamed from: b */
        public void mo2905b(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.f168uJ.f169uK = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.f168uJ.f170uL = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    C0181aa.m72t("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                C0181aa.m75w("string configuration name not recognized:  " + str);
            }
        }

        /* renamed from: c */
        public void mo2907c(String str, boolean z) {
            int i = 1;
            if ("ga_autoActivityTracking".equals(str)) {
                C0193aj ajVar = this.f168uJ;
                if (!z) {
                    i = 0;
                }
                ajVar.f172uN = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                C0193aj ajVar2 = this.f168uJ;
                if (!z) {
                    i = 0;
                }
                ajVar2.f173uO = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                C0193aj ajVar3 = this.f168uJ;
                if (!z) {
                    i = 0;
                }
                ajVar3.f174uP = i;
            } else {
                C0181aa.m75w("bool configuration name not recognized:  " + str);
            }
        }

        /* renamed from: cA */
        public C0193aj mo2906bz() {
            return this.f168uJ;
        }
    }

    public C0191ai(Context context) {
        super(context, new C0192a());
    }
}
