package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ay */
public final class C0544ay {

    /* renamed from: mr */
    public final List<C0543ax> f1273mr;

    /* renamed from: ms */
    public final long f1274ms;

    /* renamed from: mt */
    public final List<String> f1275mt;

    /* renamed from: mu */
    public final List<String> f1276mu;

    /* renamed from: mv */
    public final List<String> f1277mv;

    /* renamed from: mw */
    public final String f1278mw;

    /* renamed from: mx */
    public final long f1279mx;

    /* renamed from: my */
    public int f1280my;

    /* renamed from: mz */
    public int f1281mz;

    public C0544ay(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (C0662da.m1550n(2)) {
            C0662da.m1554v("Mediation Response JSON: " + jSONObject.toString(2));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            C0543ax axVar = new C0543ax(jSONArray.getJSONObject(i2));
            arrayList.add(axVar);
            if (i < 0 && m1230a(axVar)) {
                i = i2;
            }
        }
        this.f1280my = i;
        this.f1281mz = jSONArray.length();
        this.f1273mr = Collections.unmodifiableList(arrayList);
        this.f1278mw = jSONObject.getString("qdata");
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f1274ms = optJSONObject.optLong("ad_network_timeout_millis", -1);
            this.f1275mt = C0552bd.m1252a(optJSONObject, "click_urls");
            this.f1276mu = C0552bd.m1252a(optJSONObject, "imp_urls");
            this.f1277mv = C0552bd.m1252a(optJSONObject, "nofill_urls");
            long optLong = optJSONObject.optLong("refresh", -1);
            this.f1279mx = optLong > 0 ? optLong * 1000 : -1;
            return;
        }
        this.f1274ms = -1;
        this.f1275mt = null;
        this.f1276mu = null;
        this.f1277mv = null;
        this.f1279mx = -1;
    }

    /* renamed from: a */
    private boolean m1230a(C0543ax axVar) {
        for (String equals : axVar.f1269mn) {
            if (equals.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return true;
            }
        }
        return false;
    }
}
