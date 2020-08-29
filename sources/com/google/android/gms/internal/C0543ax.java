package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ax */
public final class C0543ax {
    public final String adJson;

    /* renamed from: mm */
    public final String f1268mm;

    /* renamed from: mn */
    public final List<String> f1269mn;

    /* renamed from: mo */
    public final String f1270mo;

    /* renamed from: mp */
    public final List<String> f1271mp;

    /* renamed from: mq */
    public final String f1272mq;

    public C0543ax(JSONObject jSONObject) throws JSONException {
        String str = null;
        this.f1268mm = jSONObject.getString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.f1269mn = Collections.unmodifiableList(arrayList);
        this.f1270mo = jSONObject.optString("allocation_id", null);
        this.f1271mp = C0552bd.m1252a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        this.adJson = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 != null) {
            str = optJSONObject2.toString();
        }
        this.f1272mq = str;
    }
}
