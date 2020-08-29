package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.analytics.aj */
class C0193aj implements C0207j {

    /* renamed from: uK */
    String f169uK;

    /* renamed from: uL */
    double f170uL = -1.0d;

    /* renamed from: uM */
    int f171uM = -1;

    /* renamed from: uN */
    int f172uN = -1;

    /* renamed from: uO */
    int f173uO = -1;

    /* renamed from: uP */
    int f174uP = -1;

    /* renamed from: uQ */
    Map<String, String> f175uQ = new HashMap();

    C0193aj() {
    }

    /* renamed from: H */
    public String mo2909H(String str) {
        String str2 = (String) this.f175uQ.get(str);
        return str2 != null ? str2 : str;
    }

    /* renamed from: cB */
    public boolean mo2910cB() {
        return this.f169uK != null;
    }

    /* renamed from: cC */
    public String mo2911cC() {
        return this.f169uK;
    }

    /* renamed from: cD */
    public boolean mo2912cD() {
        return this.f170uL >= 0.0d;
    }

    /* renamed from: cE */
    public double mo2913cE() {
        return this.f170uL;
    }

    /* renamed from: cF */
    public boolean mo2914cF() {
        return this.f171uM >= 0;
    }

    /* renamed from: cG */
    public boolean mo2915cG() {
        return this.f172uN != -1;
    }

    /* renamed from: cH */
    public boolean mo2916cH() {
        return this.f172uN == 1;
    }

    /* renamed from: cI */
    public boolean mo2917cI() {
        return this.f173uO != -1;
    }

    /* renamed from: cJ */
    public boolean mo2918cJ() {
        return this.f173uO == 1;
    }

    /* renamed from: cK */
    public boolean mo2919cK() {
        return this.f174uP == 1;
    }

    public int getSessionTimeout() {
        return this.f171uM;
    }

    /* renamed from: h */
    public String mo2921h(Activity activity) {
        return mo2909H(activity.getClass().getCanonicalName());
    }
}
