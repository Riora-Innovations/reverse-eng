package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.maps.internal.C1259r;

public final class LatLngBounds implements SafeParcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    public final LatLng northeast;
    public final LatLng southwest;

    /* renamed from: wj */
    private final int f3317wj;

    public static final class Builder {

        /* renamed from: Qa */
        private double f3318Qa = Double.POSITIVE_INFINITY;

        /* renamed from: Qb */
        private double f3319Qb = Double.NEGATIVE_INFINITY;

        /* renamed from: Qc */
        private double f3320Qc = Double.NaN;

        /* renamed from: Qd */
        private double f3321Qd = Double.NaN;

        /* renamed from: d */
        private boolean m3701d(double d) {
            boolean z = false;
            if (this.f3320Qc <= this.f3321Qd) {
                return this.f3320Qc <= d && d <= this.f3321Qd;
            }
            if (this.f3320Qc <= d || d <= this.f3321Qd) {
                z = true;
            }
            return z;
        }

        public LatLngBounds build() {
            C0766er.m1970a(!Double.isNaN(this.f3320Qc), "no included points");
            return new LatLngBounds(new LatLng(this.f3318Qa, this.f3320Qc), new LatLng(this.f3319Qb, this.f3321Qd));
        }

        public Builder include(LatLng point) {
            this.f3318Qa = Math.min(this.f3318Qa, point.latitude);
            this.f3319Qb = Math.max(this.f3319Qb, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.f3320Qc)) {
                this.f3320Qc = d;
                this.f3321Qd = d;
            } else if (!m3701d(d)) {
                if (LatLngBounds.m3695b(this.f3320Qc, d) < LatLngBounds.m3696c(this.f3321Qd, d)) {
                    this.f3320Qc = d;
                } else {
                    this.f3321Qd = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest2, LatLng northeast2) {
        C0766er.m1975b(southwest2, (Object) "null southwest");
        C0766er.m1975b(northeast2, (Object) "null northeast");
        C0766er.m1971a(northeast2.latitude >= southwest2.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest2.latitude), Double.valueOf(northeast2.latitude));
        this.f3317wj = versionCode;
        this.southwest = southwest2;
        this.northeast = northeast2;
    }

    public LatLngBounds(LatLng southwest2, LatLng northeast2) {
        this(1, southwest2, northeast2);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static double m3695b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static double m3696c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    /* renamed from: c */
    private boolean m3697c(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    /* renamed from: d */
    private boolean m3699d(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        }
        if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
            z = true;
        }
        return z;
    }

    public boolean contains(LatLng point) {
        return m3697c(point.latitude) && m3699d(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3317wj;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double d;
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = point.longitude;
        if (m3699d(d4)) {
            d4 = d3;
            d = d2;
        } else if (m3695b(d3, d4) < m3696c(d2, d4)) {
            d = d2;
        } else {
            double d5 = d3;
            d = d4;
            d4 = d5;
        }
        return new LatLngBounds(new LatLng(min, d4), new LatLng(max, d));
    }

    public String toString() {
        return C0762ep.m1965e(this).mo5118a("southwest", this.southwest).mo5118a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1265d.m3719a(this, out, flags);
        } else {
            LatLngBoundsCreator.m3702a(this, out, flags);
        }
    }
}
