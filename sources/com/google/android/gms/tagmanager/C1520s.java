package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.s */
class C1520s extends C1371aj {

    /* renamed from: ID */
    private static final String f3888ID = C0502a.FUNCTION_CALL.toString();

    /* renamed from: TF */
    private static final String f3889TF = C0546b.ADDITIONAL_PARAMS.toString();

    /* renamed from: Up */
    private static final String f3890Up = C0546b.FUNCTION_CALL_NAME.toString();

    /* renamed from: Uq */
    private final C1521a f3891Uq;

    /* renamed from: com.google.android.gms.tagmanager.s$a */
    public interface C1521a {
        /* renamed from: b */
        Object mo7522b(String str, Map<String, Object> map);
    }

    public C1520s(C1521a aVar) {
        super(f3888ID, f3890Up);
        this.f3891Uq = aVar;
    }

    /* renamed from: iy */
    public boolean mo7566iy() {
        return false;
    }

    /* renamed from: u */
    public C0661a mo7567u(Map<String, C0661a> map) {
        String j = C1488di.m4370j((C0661a) map.get(f3890Up));
        HashMap hashMap = new HashMap();
        C0661a aVar = (C0661a) map.get(f3889TF);
        if (aVar != null) {
            Object o = C1488di.m4385o(aVar);
            if (!(o instanceof Map)) {
                C1401bh.m4078w("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return C1488di.m4378ku();
            }
            for (Entry entry : ((Map) o).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return C1488di.m4388r(this.f3891Uq.mo7522b(j, hashMap));
        } catch (Exception e) {
            C1401bh.m4078w("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return C1488di.m4378ku();
        }
    }
}
