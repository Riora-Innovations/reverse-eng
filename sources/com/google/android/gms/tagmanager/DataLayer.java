package com.google.android.gms.tagmanager;

import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer {
    public static final String EVENT_KEY = "event";
    public static final Object OBJECT_NOT_PRESENT = new Object();

    /* renamed from: Ur */
    static final String[] f3539Ur = "gtm.lifetime".toString().split("\\.");

    /* renamed from: Us */
    private static final Pattern f3540Us = Pattern.compile("(\\d+)\\s*([smhd]?)");

    /* renamed from: Ut */
    private final ConcurrentHashMap<C1350b, Integer> f3541Ut;

    /* renamed from: Uu */
    private final Map<String, Object> f3542Uu;

    /* renamed from: Uv */
    private final ReentrantLock f3543Uv;

    /* renamed from: Uw */
    private final LinkedList<Map<String, Object>> f3544Uw;

    /* renamed from: Ux */
    private final C1351c f3545Ux;
    /* access modifiers changed from: private */

    /* renamed from: Uy */
    public final CountDownLatch f3546Uy;

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$a */
    static final class C1349a {

        /* renamed from: UA */
        public final String f3548UA;

        /* renamed from: UB */
        public final Object f3549UB;

        C1349a(String str, Object obj) {
            this.f3548UA = str;
            this.f3549UB = obj;
        }

        public boolean equals(Object o) {
            if (!(o instanceof C1349a)) {
                return false;
            }
            C1349a aVar = (C1349a) o;
            return this.f3548UA.equals(aVar.f3548UA) && this.f3549UB.equals(aVar.f3549UB);
        }

        public int hashCode() {
            return Arrays.hashCode(new Integer[]{Integer.valueOf(this.f3548UA.hashCode()), Integer.valueOf(this.f3549UB.hashCode())});
        }

        public String toString() {
            return "Key: " + this.f3548UA + " value: " + this.f3549UB.toString();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$b */
    interface C1350b {
        /* renamed from: v */
        void mo7543v(Map<String, Object> map);
    }

    /* renamed from: com.google.android.gms.tagmanager.DataLayer$c */
    interface C1351c {

        /* renamed from: com.google.android.gms.tagmanager.DataLayer$c$a */
        public interface C1352a {
            /* renamed from: b */
            void mo7539b(List<C1349a> list);
        }

        /* renamed from: a */
        void mo7536a(C1352a aVar);

        /* renamed from: a */
        void mo7537a(List<C1349a> list, long j);

        /* renamed from: bi */
        void mo7538bi(String str);
    }

    DataLayer() {
        this(new C1351c() {
            /* renamed from: a */
            public void mo7536a(C1352a aVar) {
                aVar.mo7539b(new ArrayList());
            }

            /* renamed from: a */
            public void mo7537a(List<C1349a> list, long j) {
            }

            /* renamed from: bi */
            public void mo7538bi(String str) {
            }
        });
    }

    DataLayer(C1351c persistentStore) {
        this.f3545Ux = persistentStore;
        this.f3541Ut = new ConcurrentHashMap<>();
        this.f3542Uu = new HashMap();
        this.f3543Uv = new ReentrantLock();
        this.f3544Uw = new LinkedList<>();
        this.f3546Uy = new CountDownLatch(1);
        m3948iP();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.Map<java.lang.String, java.lang.Object>, code=java.lang.Object, for r7v0, types: [java.util.Map<java.lang.String, java.lang.Object>, java.lang.Object] */
    /* renamed from: A */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object m3940A(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.String[] r2 = f3539Ur
            int r3 = r2.length
            r0 = 0
            r1 = r0
            r0 = r7
        L_0x0006:
            if (r1 >= r3) goto L_0x000f
            r4 = r2[r1]
            boolean r5 = r0 instanceof java.util.Map
            if (r5 != 0) goto L_0x0010
            r0 = 0
        L_0x000f:
            return r0
        L_0x0010:
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r7 = r0.get(r4)
            int r0 = r1 + 1
            r1 = r0
            r0 = r7
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.DataLayer.m3940A(java.util.Map):java.lang.Object");
    }

    /* renamed from: B */
    private List<C1349a> m3941B(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        m3946a(map, "", arrayList);
        return arrayList;
    }

    /* renamed from: C */
    private void m3942C(Map<String, Object> map) {
        synchronized (this.f3542Uu) {
            for (String str : map.keySet()) {
                mo7529a(mo7530b(str, map.get(str)), this.f3542Uu);
            }
        }
        m3943D(map);
    }

    /* renamed from: D */
    private void m3943D(Map<String, Object> map) {
        for (C1350b v : this.f3541Ut.keySet()) {
            v.mo7543v(map);
        }
    }

    /* renamed from: a */
    private void m3946a(Map<String, Object> map, String str, Collection<C1349a> collection) {
        for (Entry entry : map.entrySet()) {
            String str2 = str + (str.length() == 0 ? "" : ".") + ((String) entry.getKey());
            if (entry.getValue() instanceof Map) {
                m3946a((Map) entry.getValue(), str2, collection);
            } else if (!str2.equals("gtm.lifetime")) {
                collection.add(new C1349a(str2, entry.getValue()));
            }
        }
    }

    /* renamed from: bh */
    static Long m3947bh(String str) {
        long j;
        Matcher matcher = f3540Us.matcher(str);
        if (!matcher.matches()) {
            C1401bh.m4076u("unknown _lifetime: " + str);
            return null;
        }
        try {
            j = Long.parseLong(matcher.group(1));
        } catch (NumberFormatException e) {
            C1401bh.m4078w("illegal number in _lifetime value: " + str);
            j = 0;
        }
        if (j <= 0) {
            C1401bh.m4076u("non-positive _lifetime: " + str);
            return null;
        }
        String group = matcher.group(2);
        if (group.length() == 0) {
            return Long.valueOf(j);
        }
        switch (group.charAt(0)) {
            case 'd':
                return Long.valueOf(j * 1000 * 60 * 60 * 24);
            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                return Long.valueOf(j * 1000 * 60 * 60);
            case 'm':
                return Long.valueOf(j * 1000 * 60);
            case 's':
                return Long.valueOf(j * 1000);
            default:
                C1401bh.m4078w("unknown units in _lifetime: " + str);
                return null;
        }
    }

    /* renamed from: iP */
    private void m3948iP() {
        this.f3545Ux.mo7536a(new C1352a() {
            /* renamed from: b */
            public void mo7539b(List<C1349a> list) {
                for (C1349a aVar : list) {
                    DataLayer.this.m3950x(DataLayer.this.mo7530b(aVar.f3548UA, aVar.f3549UB));
                }
                DataLayer.this.f3546Uy.countDown();
            }
        });
    }

    /* renamed from: iQ */
    private void m3949iQ() {
        int i = 0;
        while (true) {
            int i2 = i;
            Map map = (Map) this.f3544Uw.poll();
            if (map != null) {
                m3942C(map);
                i = i2 + 1;
                if (i > 500) {
                    this.f3544Uw.clear();
                    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                }
            } else {
                return;
            }
        }
    }

    public static List<Object> listOf(Object... objects) {
        ArrayList arrayList = new ArrayList();
        for (Object add : objects) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static Map<String, Object> mapOf(Object... objects) {
        if (objects.length % 2 != 0) {
            throw new IllegalArgumentException("expected even number of key-value pairs");
        }
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objects.length) {
                return hashMap;
            }
            if (!(objects[i2] instanceof String)) {
                throw new IllegalArgumentException("key is not a string: " + objects[i2]);
            }
            hashMap.put(objects[i2], objects[i2 + 1]);
            i = i2 + 2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public void m3950x(Map<String, Object> map) {
        this.f3543Uv.lock();
        try {
            this.f3544Uw.offer(map);
            if (this.f3543Uv.getHoldCount() == 1) {
                m3949iQ();
            }
            m3951y(map);
        } finally {
            this.f3543Uv.unlock();
        }
    }

    /* renamed from: y */
    private void m3951y(Map<String, Object> map) {
        Long z = m3952z(map);
        if (z != null) {
            List B = m3941B(map);
            B.remove("gtm.lifetime");
            this.f3545Ux.mo7537a(B, z.longValue());
        }
    }

    /* renamed from: z */
    private Long m3952z(Map<String, Object> map) {
        Object A = m3940A(map);
        if (A == null) {
            return null;
        }
        return m3947bh(A.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7527a(C1350b bVar) {
        this.f3541Ut.put(bVar, Integer.valueOf(0));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7528a(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add(null);
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                Object obj = list.get(i2);
                if (obj instanceof List) {
                    if (!(list2.get(i2) instanceof List)) {
                        list2.set(i2, new ArrayList());
                    }
                    mo7528a((List) obj, (List) list2.get(i2));
                } else if (obj instanceof Map) {
                    if (!(list2.get(i2) instanceof Map)) {
                        list2.set(i2, new HashMap());
                    }
                    mo7529a((Map) obj, (Map) list2.get(i2));
                } else if (obj != OBJECT_NOT_PRESENT) {
                    list2.set(i2, obj);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo7529a(Map<String, Object> map, Map<String, Object> map2) {
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof List) {
                if (!(map2.get(str) instanceof List)) {
                    map2.put(str, new ArrayList());
                }
                mo7528a((List) obj, (List) map2.get(str));
            } else if (obj instanceof Map) {
                if (!(map2.get(str) instanceof Map)) {
                    map2.put(str, new HashMap());
                }
                mo7529a((Map) obj, (Map) map2.get(str));
            } else {
                map2.put(str, obj);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public Map<String, Object> mo7530b(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i = 0;
        HashMap hashMap2 = hashMap;
        while (i < split.length - 1) {
            HashMap hashMap3 = new HashMap();
            hashMap2.put(split[i], hashMap3);
            i++;
            hashMap2 = hashMap3;
        }
        hashMap2.put(split[split.length - 1], obj);
        return hashMap;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bg */
    public void mo7531bg(String str) {
        push(str, null);
        this.f3545Ux.mo7538bi(str);
    }

    public Object get(String key) {
        synchronized (this.f3542Uu) {
            Object obj = this.f3542Uu;
            String[] split = key.split("\\.");
            int length = split.length;
            Object obj2 = obj;
            int i = 0;
            while (i < length) {
                String str = split[i];
                if (!(obj2 instanceof Map)) {
                    return null;
                }
                Object obj3 = ((Map) obj2).get(str);
                if (obj3 == null) {
                    return null;
                }
                i++;
                obj2 = obj3;
            }
            return obj2;
        }
    }

    public void push(String key, Object value) {
        push(mo7530b(key, value));
    }

    public void push(Map<String, Object> update) {
        try {
            this.f3546Uy.await();
        } catch (InterruptedException e) {
            C1401bh.m4078w("DataLayer.push: unexpected InterruptedException");
        }
        m3950x(update);
    }

    public void pushEvent(String eventName, Map<String, Object> update) {
        HashMap hashMap = new HashMap(update);
        hashMap.put(EVENT_KEY, eventName);
        push(hashMap);
    }
}
