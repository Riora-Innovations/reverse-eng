package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.C1501l.C1503a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.tagmanager.da */
class C1478da<K, V> implements C1500k<K, V> {

    /* renamed from: Xs */
    private final Map<K, V> f3800Xs = new HashMap();

    /* renamed from: Xt */
    private final int f3801Xt;

    /* renamed from: Xu */
    private final C1503a<K, V> f3802Xu;

    /* renamed from: Xv */
    private int f3803Xv;

    C1478da(int i, C1503a<K, V> aVar) {
        this.f3801Xt = i;
        this.f3802Xu = aVar;
    }

    /* renamed from: e */
    public synchronized void mo7598e(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.f3803Xv += this.f3802Xu.sizeOf(k, v);
        if (this.f3803Xv > this.f3801Xt) {
            Iterator it = this.f3800Xs.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.f3803Xv -= this.f3802Xu.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.f3803Xv <= this.f3801Xt) {
                    break;
                }
            }
        }
        this.f3800Xs.put(k, v);
    }

    public synchronized V get(K key) {
        return this.f3800Xs.get(key);
    }
}
