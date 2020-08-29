package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1259r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements SafeParcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();

    /* renamed from: PP */
    private float f3347PP;

    /* renamed from: PQ */
    private boolean f3348PQ;

    /* renamed from: PU */
    private float f3349PU;

    /* renamed from: Qo */
    private final List<LatLng> f3350Qo;

    /* renamed from: Qq */
    private boolean f3351Qq;

    /* renamed from: wj */
    private final int f3352wj;

    /* renamed from: yX */
    private int f3353yX;

    public PolylineOptions() {
        this.f3349PU = 10.0f;
        this.f3353yX = -16777216;
        this.f3347PP = 0.0f;
        this.f3348PQ = true;
        this.f3351Qq = false;
        this.f3352wj = 1;
        this.f3350Qo = new ArrayList();
    }

    PolylineOptions(int versionCode, List points, float width, int color, float zIndex, boolean visible, boolean geodesic) {
        this.f3349PU = 10.0f;
        this.f3353yX = -16777216;
        this.f3347PP = 0.0f;
        this.f3348PQ = true;
        this.f3351Qq = false;
        this.f3352wj = versionCode;
        this.f3350Qo = points;
        this.f3349PU = width;
        this.f3353yX = color;
        this.f3347PP = zIndex;
        this.f3348PQ = visible;
        this.f3351Qq = geodesic;
    }

    public PolylineOptions add(LatLng point) {
        this.f3350Qo.add(point);
        return this;
    }

    public PolylineOptions add(LatLng... points) {
        this.f3350Qo.addAll(Arrays.asList(points));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.f3350Qo.add(add);
        }
        return this;
    }

    public PolylineOptions color(int color) {
        this.f3353yX = color;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolylineOptions geodesic(boolean geodesic) {
        this.f3351Qq = geodesic;
        return this;
    }

    public int getColor() {
        return this.f3353yX;
    }

    public List<LatLng> getPoints() {
        return this.f3350Qo;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3352wj;
    }

    public float getWidth() {
        return this.f3349PU;
    }

    public float getZIndex() {
        return this.f3347PP;
    }

    public boolean isGeodesic() {
        return this.f3351Qq;
    }

    public boolean isVisible() {
        return this.f3348PQ;
    }

    public PolylineOptions visible(boolean visible) {
        this.f3348PQ = visible;
        return this;
    }

    public PolylineOptions width(float width) {
        this.f3349PU = width;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1269h.m3723a(this, out, flags);
        } else {
            PolylineOptionsCreator.m3708a(this, out, flags);
        }
    }

    public PolylineOptions zIndex(float zIndex) {
        this.f3347PP = zIndex;
        return this;
    }
}
