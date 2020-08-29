package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0792fb.C0794b;

/* renamed from: com.google.android.gms.internal.ew */
public class C0771ew implements SafeParcelable {
    public static final C0772ex CREATOR = new C0772ex();

    /* renamed from: Co */
    private final C0773ey f2065Co;

    /* renamed from: wj */
    private final int f2066wj;

    C0771ew(int i, C0773ey eyVar) {
        this.f2066wj = i;
        this.f2065Co = eyVar;
    }

    private C0771ew(C0773ey eyVar) {
        this.f2066wj = 1;
        this.f2065Co = eyVar;
    }

    /* renamed from: a */
    public static C0771ew m1991a(C0794b<?, ?> bVar) {
        if (bVar instanceof C0773ey) {
            return new C0771ew((C0773ey) bVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public int describeContents() {
        C0772ex exVar = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ei */
    public C0773ey mo5134ei() {
        return this.f2065Co;
    }

    /* renamed from: ej */
    public C0794b<?, ?> mo5135ej() {
        if (this.f2065Co != null) {
            return this.f2065Co;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f2066wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0772ex exVar = CREATOR;
        C0772ex.m1994a(this, out, flags);
    }
}
