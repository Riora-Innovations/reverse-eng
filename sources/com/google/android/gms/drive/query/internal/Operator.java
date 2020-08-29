package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator implements SafeParcelable {
    public static final Creator<Operator> CREATOR = new C0444h();

    /* renamed from: Fa */
    public static final Operator f842Fa = new Operator("=");

    /* renamed from: Fb */
    public static final Operator f843Fb = new Operator("<");

    /* renamed from: Fc */
    public static final Operator f844Fc = new Operator("<=");

    /* renamed from: Fd */
    public static final Operator f845Fd = new Operator(">");

    /* renamed from: Fe */
    public static final Operator f846Fe = new Operator(">=");

    /* renamed from: Ff */
    public static final Operator f847Ff = new Operator("and");

    /* renamed from: Fg */
    public static final Operator f848Fg = new Operator("or");

    /* renamed from: Fh */
    public static final Operator f849Fh = new Operator("not");

    /* renamed from: Fi */
    public static final Operator f850Fi = new Operator("contains");
    final String mTag;

    /* renamed from: wj */
    final int f851wj;

    Operator(int versionCode, String tag) {
        this.f851wj = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return this.mTag == null ? operator.mTag == null : this.mTag.equals(operator.mTag);
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0444h.m979a(this, out, flags);
    }
}
