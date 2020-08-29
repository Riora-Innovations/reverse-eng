package com.google.android.gms.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.bd */
public final class C0552bd {
    /* renamed from: a */
    public static List<String> m1252a(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: a */
    public static void m1253a(Context context, String str, C0641cn cnVar, String str2, boolean z, List<String> list) {
        String str3 = z ? "1" : "0";
        for (String replaceAll : list) {
            String replaceAll2 = replaceAll.replaceAll("@gw_adlocid@", str2).replaceAll("@gw_adnetrefresh@", str3).replaceAll("@gw_qdata@", cnVar.f1735pf.f1278mw).replaceAll("@gw_sdkver@", str).replaceAll("@gw_sessid@", C0644cp.f1753pu).replaceAll("@gw_seqnum@", cnVar.f1730of);
            if (cnVar.f1721mM != null) {
                replaceAll2 = replaceAll2.replaceAll("@gw_adnetid@", cnVar.f1721mM.f1268mm).replaceAll("@gw_allocid@", cnVar.f1721mM.f1270mo);
            }
            new C0658cy(context, str, replaceAll2).start();
        }
    }
}
