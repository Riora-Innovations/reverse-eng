package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.hb */
public final class C0999hb {

    /* renamed from: IH */
    private static final String[] f2639IH = {"requestId", "outcome"};

    /* renamed from: II */
    private final HashMap<String, Integer> f2640II;

    /* renamed from: yJ */
    private final int f2641yJ;

    /* renamed from: com.google.android.gms.internal.hb$a */
    public static final class C1001a {

        /* renamed from: II */
        private HashMap<String, Integer> f2642II = new HashMap<>();

        /* renamed from: yJ */
        private int f2643yJ = 0;

        /* renamed from: aZ */
        public C1001a mo5641aZ(int i) {
            this.f2643yJ = i;
            return this;
        }

        /* renamed from: fV */
        public C0999hb mo5642fV() {
            return new C0999hb(this.f2643yJ, this.f2642II);
        }

        /* renamed from: p */
        public C1001a mo5643p(String str, int i) {
            if (C0990gt.isValid(i)) {
                this.f2642II.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    private C0999hb(int i, HashMap<String, Integer> hashMap) {
        this.f2641yJ = i;
        this.f2640II = hashMap;
    }

    /* renamed from: H */
    public static C0999hb m2934H(DataHolder dataHolder) {
        C1001a aVar = new C1001a();
        aVar.mo5641aZ(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int I = dataHolder.mo3333I(i);
            aVar.mo5643p(dataHolder.getString("requestId", i, I), dataHolder.getInteger("outcome", i, I));
        }
        return aVar.mo5642fV();
    }

    public Set<String> getRequestIds() {
        return this.f2640II.keySet();
    }

    public int getRequestOutcome(String requestId) {
        C0766er.m1976b(this.f2640II.containsKey(requestId), (Object) "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.f2640II.get(requestId)).intValue();
    }
}
