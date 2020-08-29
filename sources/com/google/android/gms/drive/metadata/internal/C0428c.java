package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.C0813fs;
import com.google.android.gms.internal.C0815ft;
import com.google.android.gms.internal.C0817fv;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public final class C0428c {

    /* renamed from: Ej */
    private static Map<String, MetadataField<?>> f812Ej = new HashMap();

    static {
        m915b(C0813fs.f2312El);
        m915b(C0813fs.TITLE);
        m915b(C0813fs.MIME_TYPE);
        m915b(C0813fs.STARRED);
        m915b(C0813fs.TRASHED);
        m915b(C0813fs.f2313Em);
        m915b(C0813fs.IS_PINNED);
        m915b(C0813fs.f2314En);
        m915b(C0813fs.f2315Eo);
        m915b(C0813fs.PARENTS);
        m915b(C0813fs.f2316Ep);
        m915b(C0813fs.f2317Eq);
        m915b(C0813fs.f2318Er);
        m915b(C0813fs.f2319Es);
        m915b(C0813fs.f2320Et);
        m915b(C0813fs.f2321Eu);
        m915b(C0813fs.f2322Ev);
        m915b(C0813fs.f2323Ew);
        m915b(C0813fs.f2324Ex);
        m915b(C0813fs.f2325Ey);
        m915b(C0813fs.f2326Ez);
        m915b(C0813fs.f2308EA);
        m915b(C0813fs.f2309EB);
        m915b(C0813fs.f2310EC);
        m915b(C0813fs.f2311ED);
        m915b(C0815ft.f2329EG);
        m915b(C0815ft.f2327EE);
        m915b(C0815ft.f2328EF);
        m915b(C0815ft.f2330EH);
        m915b(C0815ft.LAST_VIEWED_BY_ME);
        m915b(C0817fv.f2332EJ);
        m915b(C0817fv.f2333EK);
    }

    /* renamed from: ar */
    public static MetadataField<?> m914ar(String str) {
        return (MetadataField) f812Ej.get(str);
    }

    /* renamed from: b */
    private static void m915b(MetadataField<?> metadataField) {
        if (f812Ej.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        f812Ej.put(metadataField.getName(), metadataField);
    }

    /* renamed from: fg */
    public static Collection<MetadataField<?>> m916fg() {
        return Collections.unmodifiableCollection(f812Ej.values());
    }
}
