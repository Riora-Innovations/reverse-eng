package com.google.android.gms.common.data;

import java.util.ArrayList;

/* renamed from: com.google.android.gms.common.data.d */
public abstract class C0314d<T> extends DataBuffer<T> {

    /* renamed from: Ap */
    private boolean f586Ap = false;

    /* renamed from: Aq */
    private ArrayList<Integer> f587Aq;

    protected C0314d(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* renamed from: K */
    private int m517K(int i) {
        if (i < 0 || i == this.f587Aq.size()) {
            return 0;
        }
        return i == this.f587Aq.size() + -1 ? this.f561zU.getCount() - ((Integer) this.f587Aq.get(i)).intValue() : ((Integer) this.f587Aq.get(i + 1)).intValue() - ((Integer) this.f587Aq.get(i)).intValue();
    }

    /* renamed from: dK */
    private void m518dK() {
        synchronized (this) {
            if (!this.f586Ap) {
                int count = this.f561zU.getCount();
                this.f587Aq = new ArrayList<>();
                if (count > 0) {
                    this.f587Aq.add(Integer.valueOf(0));
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.f561zU.getString(primaryDataMarkerColumn, 0, this.f561zU.mo3333I(0));
                    int i = 1;
                    while (i < count) {
                        String string2 = this.f561zU.getString(primaryDataMarkerColumn, i, this.f561zU.mo3333I(i));
                        if (!string2.equals(string)) {
                            this.f587Aq.add(Integer.valueOf(i));
                        } else {
                            string2 = string;
                        }
                        i++;
                        string = string2;
                    }
                }
                this.f586Ap = true;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: J */
    public int mo3383J(int i) {
        if (i >= 0 && i < this.f587Aq.size()) {
            return ((Integer) this.f587Aq.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract T mo3384c(int i, int i2);

    public final T get(int position) {
        m518dK();
        return mo3384c(mo3383J(position), m517K(position));
    }

    public int getCount() {
        m518dK();
        return this.f587Aq.size();
    }

    /* access modifiers changed from: protected */
    public abstract String getPrimaryDataMarkerColumn();
}
