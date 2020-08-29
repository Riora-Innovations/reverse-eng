package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C0502a;
import com.google.android.gms.internal.C0546b;
import com.google.android.gms.internal.C0660d.C0661a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C1496i extends C1486dg {

    /* renamed from: ID */
    private static final String f3843ID = C0502a.ARBITRARY_PIXEL.toString();

    /* renamed from: TF */
    private static final String f3844TF = C0546b.ADDITIONAL_PARAMS.toString();

    /* renamed from: TG */
    private static final String f3845TG = C0546b.UNREPEATABLE.toString();

    /* renamed from: TH */
    static final String f3846TH = ("gtm_" + f3843ID + "_unrepeatable");

    /* renamed from: TI */
    private static final Set<String> f3847TI = new HashSet();
    private static final String URL = C0546b.URL.toString();

    /* renamed from: TJ */
    private final C1498a f3848TJ;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i$a */
    public interface C1498a {
        /* renamed from: iz */
        C1378aq mo7789iz();
    }

    public C1496i(final Context context) {
        this(context, new C1498a() {
            /* renamed from: iz */
            public C1378aq mo7789iz() {
                return C1532y.m4537F(context);
            }
        });
    }

    C1496i(Context context, C1498a aVar) {
        super(f3843ID, URL);
        this.f3848TJ = aVar;
        this.mContext = context;
    }

    /* renamed from: aU */
    private synchronized boolean m4420aU(String str) {
        boolean z = true;
        synchronized (this) {
            if (!mo7788aW(str)) {
                if (mo7787aV(str)) {
                    f3847TI.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: aV */
    public boolean mo7787aV(String str) {
        return this.mContext.getSharedPreferences(f3846TH, 0).contains(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: aW */
    public boolean mo7788aW(String str) {
        return f3847TI.contains(str);
    }

    /* renamed from: w */
    public void mo7770w(Map<String, C0661a> map) {
        String str = map.get(f3845TG) != null ? C1488di.m4370j((C0661a) map.get(f3845TG)) : null;
        if (str == null || !m4420aU(str)) {
            Builder buildUpon = Uri.parse(C1488di.m4370j((C0661a) map.get(URL))).buildUpon();
            C0661a aVar = (C0661a) map.get(f3844TF);
            if (aVar != null) {
                Object o = C1488di.m4385o(aVar);
                if (!(o instanceof List)) {
                    C1401bh.m4075t("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                    return;
                }
                for (Object next : (List) o) {
                    if (!(next instanceof Map)) {
                        C1401bh.m4075t("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                        return;
                    }
                    for (Entry entry : ((Map) next).entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.f3848TJ.mo7789iz().mo7585bk(uri);
            C1401bh.m4077v("ArbitraryPixel: url = " + uri);
            if (str != null) {
                synchronized (C1496i.class) {
                    f3847TI.add(str);
                    C1475cz.m4331a(this.mContext, f3846TH, str, "true");
                }
            }
        }
    }
}
