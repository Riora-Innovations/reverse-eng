package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C1501l.C1503a;

/* renamed from: com.google.android.gms.tagmanager.bb */
class C1393bb<K, V> implements C1500k<K, V> {

    /* renamed from: Vw */
    private LruCache<K, V> f3621Vw;

    C1393bb(int i, final C1503a<K, V> aVar) {
        this.f3621Vw = new LruCache<K, V>(i) {
            /* access modifiers changed from: protected */
            public int sizeOf(K key, V value) {
                return aVar.sizeOf(key, value);
            }
        };
    }

    /* renamed from: e */
    public void mo7598e(K k, V v) {
        this.f3621Vw.put(k, v);
    }

    public V get(K key) {
        return this.f3621Vw.get(key);
    }
}
