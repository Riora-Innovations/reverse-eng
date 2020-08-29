package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.w */
class C1530w extends C1486dg {

    /* renamed from: ID */
    private static final String f3910ID = C0502a.DATA_LAYER_WRITE.toString();

    /* renamed from: UN */
    private static final String f3911UN = C0546b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private static final String VALUE = C0546b.VALUE.toString();

    /* renamed from: TN */
    private final DataLayer f3912TN;

    public C1530w(DataLayer dataLayer) {
        super(f3910ID, VALUE);
        this.f3912TN = dataLayer;
    }

    /* renamed from: a */
    private void m4527a(C0661a aVar) {
        if (aVar != null && aVar != C1488di.m4372ko()) {
            String j = C1488di.m4370j(aVar);
            if (j != C1488di.m4377kt()) {
                this.f3912TN.mo7531bg(j);
            }
        }
    }

    /* renamed from: b */
    private void m4528b(C0661a aVar) {
        if (aVar != null && aVar != C1488di.m4372ko()) {
            Object o = C1488di.m4385o(aVar);
            if (o instanceof List) {
                for (Object next : (List) o) {
                    if (next instanceof Map) {
                        this.f3912TN.push((Map) next);
                    }
                }
            }
        }
    }

    /* renamed from: w */
    public void mo7770w(Map<String, C0661a> map) {
        m4528b((C0661a) map.get(VALUE));
        m4527a((C0661a) map.get(f3911UN));
    }
}
