package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.aj */
public final class C0520aj {
    public static final String DEVICE_ID_EMULATOR = C0659cz.m1541r("emulator");

    /* renamed from: d */
    private final Date f1204d;

    /* renamed from: f */
    private final Set<String> f1205f;

    /* renamed from: lA */
    private final int f1206lA;

    /* renamed from: lB */
    private final Set<String> f1207lB;

    /* renamed from: lt */
    private final String f1208lt;

    /* renamed from: lu */
    private final int f1209lu;

    /* renamed from: lv */
    private final Location f1210lv;

    /* renamed from: lw */
    private final boolean f1211lw;

    /* renamed from: lx */
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> f1212lx;

    /* renamed from: ly */
    private final String f1213ly;

    /* renamed from: lz */
    private final SearchAdRequest f1214lz;

    /* renamed from: com.google.android.gms.internal.aj$a */
    public static final class C0521a {
        /* access modifiers changed from: private */

        /* renamed from: d */
        public Date f1215d;
        /* access modifiers changed from: private */

        /* renamed from: lA */
        public int f1216lA = -1;
        /* access modifiers changed from: private */

        /* renamed from: lC */
        public final HashSet<String> f1217lC = new HashSet<>();
        /* access modifiers changed from: private */

        /* renamed from: lD */
        public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> f1218lD = new HashMap<>();
        /* access modifiers changed from: private */

        /* renamed from: lE */
        public final HashSet<String> f1219lE = new HashSet<>();
        /* access modifiers changed from: private */

        /* renamed from: lt */
        public String f1220lt;
        /* access modifiers changed from: private */

        /* renamed from: lu */
        public int f1221lu = -1;
        /* access modifiers changed from: private */

        /* renamed from: lv */
        public Location f1222lv;
        /* access modifiers changed from: private */

        /* renamed from: lw */
        public boolean f1223lw = false;
        /* access modifiers changed from: private */

        /* renamed from: ly */
        public String f1224ly;

        /* renamed from: a */
        public void mo4536a(Location location) {
            this.f1222lv = location;
        }

        /* renamed from: a */
        public void mo4537a(NetworkExtras networkExtras) {
            this.f1218lD.put(networkExtras.getClass(), networkExtras);
        }

        /* renamed from: a */
        public void mo4538a(Date date) {
            this.f1215d = date;
        }

        /* renamed from: d */
        public void mo4539d(int i) {
            this.f1221lu = i;
        }

        /* renamed from: d */
        public void mo4540d(boolean z) {
            this.f1223lw = z;
        }

        /* renamed from: e */
        public void mo4541e(boolean z) {
            this.f1216lA = z ? 1 : 0;
        }

        /* renamed from: g */
        public void mo4542g(String str) {
            this.f1217lC.add(str);
        }

        /* renamed from: h */
        public void mo4543h(String str) {
            this.f1219lE.add(str);
        }

        /* renamed from: i */
        public void mo4544i(String str) {
            this.f1220lt = str;
        }

        /* renamed from: j */
        public void mo4545j(String str) {
            this.f1224ly = str;
        }
    }

    public C0520aj(C0521a aVar) {
        this(aVar, null);
    }

    public C0520aj(C0521a aVar, SearchAdRequest searchAdRequest) {
        this.f1204d = aVar.f1215d;
        this.f1208lt = aVar.f1220lt;
        this.f1209lu = aVar.f1221lu;
        this.f1205f = Collections.unmodifiableSet(aVar.f1217lC);
        this.f1210lv = aVar.f1222lv;
        this.f1211lw = aVar.f1223lw;
        this.f1212lx = Collections.unmodifiableMap(aVar.f1218lD);
        this.f1213ly = aVar.f1224ly;
        this.f1214lz = searchAdRequest;
        this.f1206lA = aVar.f1216lA;
        this.f1207lB = Collections.unmodifiableSet(aVar.f1219lE);
    }

    /* renamed from: aj */
    public SearchAdRequest mo4524aj() {
        return this.f1214lz;
    }

    /* renamed from: ak */
    public Map<Class<? extends NetworkExtras>, NetworkExtras> mo4525ak() {
        return this.f1212lx;
    }

    /* renamed from: al */
    public int mo4526al() {
        return this.f1206lA;
    }

    public Date getBirthday() {
        return this.f1204d;
    }

    public String getContentUrl() {
        return this.f1208lt;
    }

    public int getGender() {
        return this.f1209lu;
    }

    public Set<String> getKeywords() {
        return this.f1205f;
    }

    public Location getLocation() {
        return this.f1210lv;
    }

    public boolean getManualImpressionsEnabled() {
        return this.f1211lw;
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return (NetworkExtras) this.f1212lx.get(networkExtrasClass);
    }

    public String getPublisherProvidedId() {
        return this.f1213ly;
    }

    public boolean isTestDevice(Context context) {
        return this.f1207lB.contains(C0659cz.m1540l(context));
    }
}
