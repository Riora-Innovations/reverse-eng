package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

/* renamed from: com.google.android.gms.tagmanager.l */
class C1501l<K, V> {

    /* renamed from: TK */
    final C1503a<K, V> f3850TK = new C1503a<K, V>() {
        public int sizeOf(K k, V v) {
            return 1;
        }
    };

    /* renamed from: com.google.android.gms.tagmanager.l$a */
    public interface C1503a<K, V> {
        int sizeOf(K k, V v);
    }

    /* renamed from: a */
    public C1500k<K, V> mo7790a(int i, C1503a<K, V> aVar) {
        if (i > 0) {
            return mo7791iA() < 12 ? new C1478da(i, aVar) : new C1393bb(i, aVar);
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: iA */
    public int mo7791iA() {
        return VERSION.SDK_INT;
    }
}
