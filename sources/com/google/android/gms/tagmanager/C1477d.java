package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.d */
class C1477d implements C1350b {

    /* renamed from: kL */
    private final Context f3799kL;

    public C1477d(Context context) {
        this.f3799kL = context;
    }

    /* renamed from: v */
    public void mo7543v(Map<String, Object> map) {
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null) {
            Object obj3 = map.get("gtm");
            if (obj3 != null && (obj3 instanceof Map)) {
                obj = ((Map) obj3).get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (obj != null && (obj instanceof String)) {
                    String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
                    if (queryParameter != null) {
                        C1387ay.m4051e(this.f3799kL, queryParameter);
                        return;
                    }
                    return;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
        }
    }
}
