package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.hn */
public final class C1029hn implements SafeParcelable {
    public static final C1030ho CREATOR = new C1030ho();

    /* renamed from: LA */
    final List<C1035ht> f2685LA;

    /* renamed from: LB */
    private final String f2686LB;

    /* renamed from: LC */
    private final boolean f2687LC;

    /* renamed from: LD */
    private final Set<C1035ht> f2688LD;

    /* renamed from: wj */
    final int f2689wj;

    C1029hn(int i, List<C1035ht> list, String str, boolean z) {
        this.f2689wj = i;
        this.f2685LA = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        if (str == null) {
            str = "";
        }
        this.f2686LB = str;
        this.f2687LC = z;
        if (this.f2685LA.isEmpty()) {
            this.f2688LD = Collections.emptySet();
        } else {
            this.f2688LD = Collections.unmodifiableSet(new HashSet(this.f2685LA));
        }
    }

    public int describeContents() {
        C1030ho hoVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1029hn)) {
            return false;
        }
        C1029hn hnVar = (C1029hn) object;
        return this.f2688LD.equals(hnVar.f2688LD) && this.f2686LB == hnVar.f2686LB && this.f2687LC == hnVar.f2687LC;
    }

    /* renamed from: gr */
    public String mo5741gr() {
        return this.f2686LB;
    }

    /* renamed from: gs */
    public boolean mo5742gs() {
        return this.f2687LC;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f2688LD, this.f2686LB, Boolean.valueOf(this.f2687LC));
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("types", this.f2688LD).mo5118a("textQuery", this.f2686LB).mo5118a("isOpenNowRequired", Boolean.valueOf(this.f2687LC)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1030ho hoVar = CREATOR;
        C1030ho.m3036a(this, parcel, flags);
    }
}
