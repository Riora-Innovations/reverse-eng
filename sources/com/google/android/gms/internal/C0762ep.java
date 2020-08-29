package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ep */
public final class C0762ep {

    /* renamed from: com.google.android.gms.internal.ep$a */
    public static final class C0764a {

        /* renamed from: Ce */
        private final List<String> f2055Ce;

        /* renamed from: Cf */
        private final Object f2056Cf;

        private C0764a(Object obj) {
            this.f2056Cf = C0766er.m1977f(obj);
            this.f2055Ce = new ArrayList();
        }

        /* renamed from: a */
        public C0764a mo5118a(String str, Object obj) {
            this.f2055Ce.add(((String) C0766er.m1977f(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.f2056Cf.getClass().getSimpleName()).append('{');
            int size = this.f2055Ce.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.f2055Ce.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    /* renamed from: e */
    public static C0764a m1965e(Object obj) {
        return new C0764a(obj);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
