package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import com.google.android.gms.tagmanager.C1449cr.C1451a;
import com.google.android.gms.tagmanager.C1449cr.C1453c;
import com.google.android.gms.tagmanager.C1449cr.C1454d;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.tagmanager.ba */
class C1392ba {
    /* renamed from: br */
    public static C1453c m4060br(String str) throws JSONException {
        C0661a k = m4061k(new JSONObject(str));
        C1454d jI = C1453c.m4235jI();
        for (int i = 0; i < k.f1789ga.length; i++) {
            jI.mo7700a(C1451a.m4228jE().mo7693b(C0546b.INSTANCE_NAME.toString(), k.f1789ga[i]).mo7693b(C0546b.FUNCTION.toString(), C1488di.m4365bI(C1504m.m4431iB())).mo7693b(C1504m.m4432iC(), k.f1790gb[i]).mo7695jH());
        }
        return jI.mo7704jL();
    }

    /* renamed from: k */
    private static C0661a m4061k(Object obj) throws JSONException {
        return C1488di.m4388r(m4062l(obj));
    }

    /* renamed from: l */
    static Object m4062l(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            HashMap hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m4062l(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
