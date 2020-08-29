package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1259r;

public final class CircleOptions implements SafeParcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();

    /* renamed from: PK */
    private LatLng f3295PK;

    /* renamed from: PL */
    private double f3296PL;

    /* renamed from: PM */
    private float f3297PM;

    /* renamed from: PN */
    private int f3298PN;

    /* renamed from: PO */
    private int f3299PO;

    /* renamed from: PP */
    private float f3300PP;

    /* renamed from: PQ */
    private boolean f3301PQ;

    /* renamed from: wj */
    private final int f3302wj;

    public CircleOptions() {
        this.f3295PK = null;
        this.f3296PL = 0.0d;
        this.f3297PM = 10.0f;
        this.f3298PN = -16777216;
        this.f3299PO = 0;
        this.f3300PP = 0.0f;
        this.f3301PQ = true;
        this.f3302wj = 1;
    }

    CircleOptions(int versionCode, LatLng center, double radius, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible) {
        this.f3295PK = null;
        this.f3296PL = 0.0d;
        this.f3297PM = 10.0f;
        this.f3298PN = -16777216;
        this.f3299PO = 0;
        this.f3300PP = 0.0f;
        this.f3301PQ = true;
        this.f3302wj = versionCode;
        this.f3295PK = center;
        this.f3296PL = radius;
        this.f3297PM = strokeWidth;
        this.f3298PN = strokeColor;
        this.f3299PO = fillColor;
        this.f3300PP = zIndex;
        this.f3301PQ = visible;
    }

    public CircleOptions center(LatLng center) {
        this.f3295PK = center;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int color) {
        this.f3299PO = color;
        return this;
    }

    public LatLng getCenter() {
        return this.f3295PK;
    }

    public int getFillColor() {
        return this.f3299PO;
    }

    public double getRadius() {
        return this.f3296PL;
    }

    public int getStrokeColor() {
        return this.f3298PN;
    }

    public float getStrokeWidth() {
        return this.f3297PM;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3302wj;
    }

    public float getZIndex() {
        return this.f3300PP;
    }

    public boolean isVisible() {
        return this.f3301PQ;
    }

    public CircleOptions radius(double radius) {
        this.f3296PL = radius;
        return this;
    }

    public CircleOptions strokeColor(int color) {
        this.f3298PN = color;
        return this;
    }

    public CircleOptions strokeWidth(float width) {
        this.f3297PM = width;
        return this;
    }

    public CircleOptions visible(boolean visible) {
        this.f3301PQ = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1263b.m3717a(this, out, flags);
        } else {
            CircleOptionsCreator.m3691a(this, out, flags);
        }
    }

    public CircleOptions zIndex(float zIndex) {
        this.f3300PP = zIndex;
        return this;
    }
}
