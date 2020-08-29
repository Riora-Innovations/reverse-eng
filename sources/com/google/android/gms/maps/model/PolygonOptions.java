package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1259r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();

    /* renamed from: PM */
    private float f3337PM;

    /* renamed from: PN */
    private int f3338PN;

    /* renamed from: PO */
    private int f3339PO;

    /* renamed from: PP */
    private float f3340PP;

    /* renamed from: PQ */
    private boolean f3341PQ;

    /* renamed from: Qo */
    private final List<LatLng> f3342Qo;

    /* renamed from: Qp */
    private final List<List<LatLng>> f3343Qp;

    /* renamed from: Qq */
    private boolean f3344Qq;

    /* renamed from: wj */
    private final int f3345wj;

    public PolygonOptions() {
        this.f3337PM = 10.0f;
        this.f3338PN = -16777216;
        this.f3339PO = 0;
        this.f3340PP = 0.0f;
        this.f3341PQ = true;
        this.f3344Qq = false;
        this.f3345wj = 1;
        this.f3342Qo = new ArrayList();
        this.f3343Qp = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.f3337PM = 10.0f;
        this.f3338PN = -16777216;
        this.f3339PO = 0;
        this.f3340PP = 0.0f;
        this.f3341PQ = true;
        this.f3344Qq = false;
        this.f3345wj = versionCode;
        this.f3342Qo = points;
        this.f3343Qp = holes;
        this.f3337PM = strokeWidth;
        this.f3338PN = strokeColor;
        this.f3339PO = fillColor;
        this.f3340PP = zIndex;
        this.f3341PQ = visible;
        this.f3344Qq = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.f3342Qo.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.f3342Qo.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.f3342Qo.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.f3343Qp.add(arrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.f3339PO = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.f3344Qq = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.f3339PO;
    }

    public List<List<LatLng>> getHoles() {
        return this.f3343Qp;
    }

    public List<LatLng> getPoints() {
        return this.f3342Qo;
    }

    public int getStrokeColor() {
        return this.f3338PN;
    }

    public float getStrokeWidth() {
        return this.f3337PM;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3345wj;
    }

    public float getZIndex() {
        return this.f3340PP;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hg */
    public List mo7061hg() {
        return this.f3343Qp;
    }

    public boolean isGeodesic() {
        return this.f3344Qq;
    }

    public boolean isVisible() {
        return this.f3341PQ;
    }

    public PolygonOptions strokeColor(int color) {
        this.f3338PN = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.f3337PM = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.f3341PQ = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1268g.m3722a(this, out, flags);
        } else {
            PolygonOptionsCreator.m3707a(this, out, flags);
        }
    }

    public PolygonOptions zIndex(float zIndex) {
        this.f3340PP = zIndex;
        return this;
    }
}
