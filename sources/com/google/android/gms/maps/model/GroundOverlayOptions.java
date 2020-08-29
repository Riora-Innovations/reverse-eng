package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0453b.C0454a;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.maps.internal.C1259r;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;

    /* renamed from: PI */
    private float f3304PI;

    /* renamed from: PP */
    private float f3305PP;

    /* renamed from: PQ */
    private boolean f3306PQ;

    /* renamed from: PS */
    private BitmapDescriptor f3307PS;

    /* renamed from: PT */
    private LatLng f3308PT;

    /* renamed from: PU */
    private float f3309PU;

    /* renamed from: PV */
    private float f3310PV;

    /* renamed from: PW */
    private LatLngBounds f3311PW;

    /* renamed from: PX */
    private float f3312PX;

    /* renamed from: PY */
    private float f3313PY;

    /* renamed from: PZ */
    private float f3314PZ;

    /* renamed from: wj */
    private final int f3315wj;

    public GroundOverlayOptions() {
        this.f3306PQ = true;
        this.f3312PX = 0.0f;
        this.f3313PY = 0.5f;
        this.f3314PZ = 0.5f;
        this.f3315wj = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.f3306PQ = true;
        this.f3312PX = 0.0f;
        this.f3313PY = 0.5f;
        this.f3314PZ = 0.5f;
        this.f3315wj = versionCode;
        this.f3307PS = new BitmapDescriptor(C0454a.m999G(wrappedImage));
        this.f3308PT = location;
        this.f3309PU = width;
        this.f3310PV = height;
        this.f3311PW = bounds;
        this.f3304PI = bearing;
        this.f3305PP = zIndex;
        this.f3306PQ = visible;
        this.f3312PX = transparency;
        this.f3313PY = anchorU;
        this.f3314PZ = anchorV;
    }

    /* renamed from: a */
    private GroundOverlayOptions m3692a(LatLng latLng, float f, float f2) {
        this.f3308PT = latLng;
        this.f3309PU = f;
        this.f3310PV = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.f3313PY = u;
        this.f3314PZ = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.f3304PI = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f3313PY;
    }

    public float getAnchorV() {
        return this.f3314PZ;
    }

    public float getBearing() {
        return this.f3304PI;
    }

    public LatLngBounds getBounds() {
        return this.f3311PW;
    }

    public float getHeight() {
        return this.f3310PV;
    }

    public BitmapDescriptor getImage() {
        return this.f3307PS;
    }

    public LatLng getLocation() {
        return this.f3308PT;
    }

    public float getTransparency() {
        return this.f3312PX;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3315wj;
    }

    public float getWidth() {
        return this.f3309PU;
    }

    public float getZIndex() {
        return this.f3305PP;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: he */
    public IBinder mo6938he() {
        return this.f3307PS.mo6852gK().asBinder();
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.f3307PS = image;
        return this;
    }

    public boolean isVisible() {
        return this.f3306PQ;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        C0766er.m1970a(this.f3311PW == null, "Position has already been set using positionFromBounds");
        C0766er.m1976b(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        C0766er.m1976b(z, (Object) "Width must be non-negative");
        return m3692a(location, width, -1.0f);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        C0766er.m1970a(this.f3311PW == null, "Position has already been set using positionFromBounds");
        C0766er.m1976b(location != null, (Object) "Location must be specified");
        C0766er.m1976b(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        C0766er.m1976b(z, (Object) "Height must be non-negative");
        return m3692a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        C0766er.m1970a(this.f3308PT == null, "Position has already been set using position: " + this.f3308PT);
        this.f3311PW = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        C0766er.m1976b(transparency >= 0.0f && transparency <= 1.0f, (Object) "Transparency must be in the range [0..1]");
        this.f3312PX = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.f3306PQ = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1264c.m3718a(this, out, flags);
        } else {
            GroundOverlayOptionsCreator.m3694a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.f3305PP = zIndex;
        return this;
    }
}
