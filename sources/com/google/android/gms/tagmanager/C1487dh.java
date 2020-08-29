package com.google.android.gms.tagmanager;

/* renamed from: com.google.android.gms.tagmanager.dh */
class C1487dh extends Number implements Comparable<C1487dh> {

    /* renamed from: XF */
    private double f3812XF;

    /* renamed from: XG */
    private long f3813XG;

    /* renamed from: XH */
    private boolean f3814XH = false;

    private C1487dh(double d) {
        this.f3812XF = d;
    }

    private C1487dh(long j) {
        this.f3813XG = j;
    }

    /* renamed from: a */
    public static C1487dh m4356a(Double d) {
        return new C1487dh(d.doubleValue());
    }

    /* renamed from: bH */
    public static C1487dh m4357bH(String str) throws NumberFormatException {
        try {
            return new C1487dh(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new C1487dh(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    /* renamed from: v */
    public static C1487dh m4358v(long j) {
        return new C1487dh(j);
    }

    /* renamed from: a */
    public int compareTo(C1487dh dhVar) {
        return (!mo7780kk() || !dhVar.mo7780kk()) ? Double.compare(doubleValue(), dhVar.doubleValue()) : new Long(this.f3813XG).compareTo(Long.valueOf(dhVar.f3813XG));
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public double doubleValue() {
        return mo7780kk() ? (double) this.f3813XG : this.f3812XF;
    }

    public boolean equals(Object other) {
        return (other instanceof C1487dh) && compareTo((C1487dh) other) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return mo7782km();
    }

    /* renamed from: kj */
    public boolean mo7779kj() {
        return !mo7780kk();
    }

    /* renamed from: kk */
    public boolean mo7780kk() {
        return this.f3814XH;
    }

    /* renamed from: kl */
    public long mo7781kl() {
        return mo7780kk() ? this.f3813XG : (long) this.f3812XF;
    }

    /* renamed from: km */
    public int mo7782km() {
        return (int) longValue();
    }

    /* renamed from: kn */
    public short mo7783kn() {
        return (short) ((int) longValue());
    }

    public long longValue() {
        return mo7781kl();
    }

    public short shortValue() {
        return mo7783kn();
    }

    public String toString() {
        return mo7780kk() ? Long.toString(this.f3813XG) : Double.toString(this.f3812XF);
    }
}
