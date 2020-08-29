package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0608c.C0614f;
import com.google.android.gms.internal.C0608c.C0617i;
import com.google.android.gms.internal.C0608c.C0618j;
import com.google.android.gms.internal.C0660d.C0661a;
import com.google.android.gms.tagmanager.C1449cr.C1453c;
import com.google.android.gms.tagmanager.C1449cr.C1457g;
import com.google.android.gms.tagmanager.C1520s.C1521a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {

    /* renamed from: TM */
    private final String f3530TM;

    /* renamed from: TN */
    private final DataLayer f3531TN;

    /* renamed from: TO */
    private C1459ct f3532TO;

    /* renamed from: TP */
    private Map<String, FunctionCallMacroCallback> f3533TP = new HashMap();

    /* renamed from: TQ */
    private Map<String, FunctionCallTagCallback> f3534TQ = new HashMap();

    /* renamed from: TR */
    private volatile long f3535TR;

    /* renamed from: TS */
    private volatile String f3536TS = "";
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.Container$a */
    private class C1345a implements C1521a {
        private C1345a() {
        }

        /* renamed from: b */
        public Object mo7522b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback aY = Container.this.mo7503aY(str);
            if (aY == null) {
                return null;
            }
            return aY.getValue(str, map);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.Container$b */
    private class C1346b implements C1521a {
        private C1346b() {
        }

        /* renamed from: b */
        public Object mo7522b(String str, Map<String, Object> map) {
            FunctionCallTagCallback aZ = Container.this.mo7504aZ(str);
            if (aZ != null) {
                aZ.execute(str, map);
            }
            return C1488di.m4377kt();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0618j resource) {
        this.mContext = context;
        this.f3531TN = dataLayer;
        this.f3530TM = containerId;
        this.f3535TR = lastRefreshTime;
        m3928a(resource.f1638fV);
        if (resource.f1637fU != null) {
            m3931a(resource.f1637fU);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C1453c resource) {
        this.mContext = context;
        this.f3531TN = dataLayer;
        this.f3530TM = containerId;
        this.f3535TR = lastRefreshTime;
        m3929a(resource);
    }

    /* renamed from: a */
    private void m3928a(C0614f fVar) {
        if (fVar == null) {
            throw new NullPointerException();
        }
        try {
            m3929a(C1449cr.m4223b(fVar));
        } catch (C1457g e) {
            C1401bh.m4075t("Not loading resource: " + fVar + " because it is invalid: " + e.toString());
        }
    }

    /* renamed from: a */
    private void m3929a(C1453c cVar) {
        this.f3536TS = cVar.getVersion();
        C1453c cVar2 = cVar;
        m3930a(new C1459ct(this.mContext, cVar2, this.f3531TN, new C1345a(), new C1346b(), mo7506bb(this.f3536TS)));
    }

    /* renamed from: a */
    private synchronized void m3930a(C1459ct ctVar) {
        this.f3532TO = ctVar;
    }

    /* renamed from: a */
    private void m3931a(C0617i[] iVarArr) {
        ArrayList arrayList = new ArrayList();
        for (C0617i add : iVarArr) {
            arrayList.add(add);
        }
        m3932iE().mo7737f(arrayList);
    }

    /* renamed from: iE */
    private synchronized C1459ct m3932iE() {
        return this.f3532TO;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: aY */
    public FunctionCallMacroCallback mo7503aY(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.f3533TP) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.f3533TP.get(str);
        }
        return functionCallMacroCallback;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: aZ */
    public FunctionCallTagCallback mo7504aZ(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.f3534TQ) {
            functionCallTagCallback = (FunctionCallTagCallback) this.f3534TQ.get(str);
        }
        return functionCallTagCallback;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ba */
    public void mo7505ba(String str) {
        m3932iE().mo7735ba(str);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bb */
    public C1368ag mo7506bb(String str) {
        if (C1429ce.m4170ju().mo7668jv().equals(C1430a.CONTAINER_DEBUG)) {
        }
        return new C1410bq();
    }

    public boolean getBoolean(String key) {
        C1459ct iE = m3932iE();
        if (iE == null) {
            C1401bh.m4075t("getBoolean called for closed container.");
            return C1488di.m4375kr().booleanValue();
        }
        try {
            return C1488di.m4383n((C0661a) iE.mo7733bC(key).getObject()).booleanValue();
        } catch (Exception e) {
            C1401bh.m4075t("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return C1488di.m4375kr().booleanValue();
        }
    }

    public String getContainerId() {
        return this.f3530TM;
    }

    public double getDouble(String key) {
        C1459ct iE = m3932iE();
        if (iE == null) {
            C1401bh.m4075t("getDouble called for closed container.");
            return C1488di.m4374kq().doubleValue();
        }
        try {
            return C1488di.m4380m((C0661a) iE.mo7733bC(key).getObject()).doubleValue();
        } catch (Exception e) {
            C1401bh.m4075t("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return C1488di.m4374kq().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.f3535TR;
    }

    public long getLong(String key) {
        C1459ct iE = m3932iE();
        if (iE == null) {
            C1401bh.m4075t("getLong called for closed container.");
            return C1488di.m4373kp().longValue();
        }
        try {
            return C1488di.m4379l((C0661a) iE.mo7733bC(key).getObject()).longValue();
        } catch (Exception e) {
            C1401bh.m4075t("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return C1488di.m4373kp().longValue();
        }
    }

    public String getString(String key) {
        C1459ct iE = m3932iE();
        if (iE == null) {
            C1401bh.m4075t("getString called for closed container.");
            return C1488di.m4377kt();
        }
        try {
            return C1488di.m4370j((C0661a) iE.mo7733bC(key).getObject());
        } catch (Exception e) {
            C1401bh.m4075t("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return C1488di.m4377kt();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: iD */
    public String mo7513iD() {
        return this.f3536TS;
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.f3533TP) {
            this.f3533TP.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.f3534TQ) {
            this.f3534TQ.put(customTagName, customTagCallback);
        }
    }

    /* access modifiers changed from: 0000 */
    public void release() {
        this.f3532TO = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.f3533TP) {
            this.f3533TP.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.f3534TQ) {
            this.f3534TQ.remove(customTagName);
        }
    }
}
