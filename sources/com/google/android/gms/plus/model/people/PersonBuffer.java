package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.C0313c;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.C1088ir;
import com.google.android.gms.internal.C1111jc;

public final class PersonBuffer extends DataBuffer<Person> {

    /* renamed from: Tu */
    private final C0313c<C1088ir> f3529Tu;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.getMetadata() == null || !dataHolder.getMetadata().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.f3529Tu = null;
        } else {
            this.f3529Tu = new C0313c<>(dataHolder, C1088ir.CREATOR);
        }
    }

    public Person get(int position) {
        return this.f3529Tu != null ? (Person) this.f3529Tu.get(position) : new C1111jc(this.f561zU, position);
    }
}
