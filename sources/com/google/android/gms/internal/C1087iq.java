package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

/* renamed from: com.google.android.gms.internal.iq */
public final class C1087iq extends C0312b implements Moment {

    /* renamed from: SJ */
    private C1085io f2977SJ;

    public C1087iq(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* renamed from: hV */
    private C1085io m3187hV() {
        synchronized (this) {
            if (this.f2977SJ == null) {
                byte[] byteArray = getByteArray("momentImpl");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f2977SJ = C1085io.CREATOR.createFromParcel(obtain);
                obtain.recycle();
            }
        }
        return this.f2977SJ;
    }

    public String getId() {
        return m3187hV().getId();
    }

    public ItemScope getResult() {
        return m3187hV().getResult();
    }

    public String getStartDate() {
        return m3187hV().getStartDate();
    }

    public ItemScope getTarget() {
        return m3187hV().getTarget();
    }

    public String getType() {
        return m3187hV().getType();
    }

    /* renamed from: hU */
    public C1085io freeze() {
        return m3187hV();
    }

    public boolean hasId() {
        return m3187hV().hasId();
    }

    public boolean hasResult() {
        return m3187hV().hasId();
    }

    public boolean hasStartDate() {
        return m3187hV().hasStartDate();
    }

    public boolean hasTarget() {
        return m3187hV().hasTarget();
    }

    public boolean hasType() {
        return m3187hV().hasType();
    }
}
