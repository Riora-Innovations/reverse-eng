package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.C1083im;
import com.google.android.gms.internal.C1085io;
import java.util.HashSet;
import java.util.Set;

public interface Moment extends Freezable<Moment> {

    public static class Builder {

        /* renamed from: Oc */
        private String f3523Oc;

        /* renamed from: RM */
        private final Set<Integer> f3524RM = new HashSet();

        /* renamed from: SH */
        private C1083im f3525SH;

        /* renamed from: SI */
        private C1083im f3526SI;

        /* renamed from: Sz */
        private String f3527Sz;

        /* renamed from: uS */
        private String f3528uS;

        public Moment build() {
            return new C1085io(this.f3524RM, this.f3528uS, this.f3525SH, this.f3527Sz, this.f3526SI, this.f3523Oc);
        }

        public Builder setId(String id) {
            this.f3528uS = id;
            this.f3524RM.add(Integer.valueOf(2));
            return this;
        }

        public Builder setResult(ItemScope result) {
            this.f3525SH = (C1083im) result;
            this.f3524RM.add(Integer.valueOf(4));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.f3527Sz = startDate;
            this.f3524RM.add(Integer.valueOf(5));
            return this;
        }

        public Builder setTarget(ItemScope target) {
            this.f3526SI = (C1083im) target;
            this.f3524RM.add(Integer.valueOf(6));
            return this;
        }

        public Builder setType(String type) {
            this.f3523Oc = type;
            this.f3524RM.add(Integer.valueOf(7));
            return this;
        }
    }

    String getId();

    ItemScope getResult();

    String getStartDate();

    ItemScope getTarget();

    String getType();

    boolean hasId();

    boolean hasResult();

    boolean hasStartDate();

    boolean hasTarget();

    boolean hasType();
}
