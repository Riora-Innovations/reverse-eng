package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0608c.C0611c;
import com.google.android.gms.internal.C0608c.C0612d;
import com.google.android.gms.internal.C0608c.C0617i;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.Map;

/* renamed from: com.google.android.gms.tagmanager.ai */
class C1370ai {
    /* renamed from: a */
    private static void m4001a(DataLayer dataLayer, C0612d dVar) {
        for (C0661a j : dVar.f1594fd) {
            dataLayer.mo7531bg(C1488di.m4370j(j));
        }
    }

    /* renamed from: a */
    public static void m4002a(DataLayer dataLayer, C0617i iVar) {
        if (iVar.f1636fT == null) {
            C1401bh.m4078w("supplemental missing experimentSupplemental");
            return;
        }
        m4001a(dataLayer, iVar.f1636fT);
        m4003b(dataLayer, iVar.f1636fT);
        m4005c(dataLayer, iVar.f1636fT);
    }

    /* renamed from: b */
    private static void m4003b(DataLayer dataLayer, C0612d dVar) {
        for (C0661a c : dVar.f1593fc) {
            Map c2 = m4004c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    /* renamed from: c */
    private static Map<String, Object> m4004c(C0661a aVar) {
        Object o = C1488di.m4385o(aVar);
        if (o instanceof Map) {
            return (Map) o;
        }
        C1401bh.m4078w("value: " + o + " is not a map value, ignored.");
        return null;
    }

    /* renamed from: c */
    private static void m4005c(DataLayer dataLayer, C0612d dVar) {
        C0611c[] cVarArr;
        for (C0611c cVar : dVar.f1595fe) {
            if (cVar.f1588eX == null) {
                C1401bh.m4078w("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(cVar.f1588eX);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = cVar.f1589eY;
                long j2 = cVar.f1590eZ;
                if (!cVar.f1591fa || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        C1401bh.m4078w("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.mo7531bg(cVar.f1588eX);
                Map b = dataLayer.mo7530b(cVar.f1588eX, obj);
                if (cVar.f1592fb > 0) {
                    if (!b.containsKey("gtm")) {
                        b.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(cVar.f1592fb)));
                    } else {
                        Object obj2 = b.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(cVar.f1592fb));
                        } else {
                            C1401bh.m4078w("GaExperimentRandom: gtm not a map");
                        }
                    }
                }
                dataLayer.push(b);
            }
        }
    }
}
