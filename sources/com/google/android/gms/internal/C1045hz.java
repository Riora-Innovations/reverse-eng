package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import org.achartengine.chartdemo.demo.chart.IDemoChart;

/* renamed from: com.google.android.gms.internal.hz */
public final class C1045hz implements SafeParcelable {
    public static final C1047ia CREATOR = new C1047ia();

    /* renamed from: Ov */
    public final String f2848Ov;

    /* renamed from: Ow */
    public final String f2849Ow;

    /* renamed from: Ox */
    public final String f2850Ox;

    /* renamed from: Oy */
    public final List<String> f2851Oy;
    public final String name;
    public final int versionCode;

    public C1045hz(int i, String str, String str2, String str3, String str4, List<String> list) {
        this.versionCode = i;
        this.name = str;
        this.f2848Ov = str2;
        this.f2849Ow = str3;
        this.f2850Ox = str4;
        this.f2851Oy = list;
    }

    public int describeContents() {
        C1047ia iaVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof C1045hz)) {
            return false;
        }
        C1045hz hzVar = (C1045hz) object;
        return C0762ep.equal(this.name, hzVar.name) && C0762ep.equal(this.f2848Ov, hzVar.f2848Ov) && C0762ep.equal(this.f2849Ow, hzVar.f2849Ow) && C0762ep.equal(this.f2850Ox, hzVar.f2850Ox) && C0762ep.equal(this.f2851Oy, hzVar.f2851Oy);
    }

    public int hashCode() {
        return C0762ep.hashCode(this.name, this.f2848Ov, this.f2849Ow, this.f2850Ox);
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a(IDemoChart.NAME, this.name).mo5118a("address", this.f2848Ov).mo5118a("internationalPhoneNumber", this.f2849Ow).mo5118a("regularOpenHours", this.f2850Ox).mo5118a("attributions", this.f2851Oy).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        C1047ia iaVar = CREATOR;
        C1047ia.m3092a(this, parcel, flags);
    }
}
