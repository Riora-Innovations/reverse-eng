package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0453b.C0454a;
import com.google.android.gms.maps.internal.C1259r;

public final class MarkerOptions implements SafeParcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();

    /* renamed from: CX */
    private String f3323CX;

    /* renamed from: PQ */
    private boolean f3324PQ;

    /* renamed from: PY */
    private float f3325PY;

    /* renamed from: PZ */
    private float f3326PZ;

    /* renamed from: Qf */
    private LatLng f3327Qf;

    /* renamed from: Qg */
    private String f3328Qg;

    /* renamed from: Qh */
    private BitmapDescriptor f3329Qh;

    /* renamed from: Qi */
    private boolean f3330Qi;

    /* renamed from: Qj */
    private boolean f3331Qj;

    /* renamed from: Qk */
    private float f3332Qk;

    /* renamed from: Ql */
    private float f3333Ql;

    /* renamed from: Qm */
    private float f3334Qm;
    private float mAlpha;

    /* renamed from: wj */
    private final int f3335wj;

    public MarkerOptions() {
        this.f3325PY = 0.5f;
        this.f3326PZ = 1.0f;
        this.f3324PQ = true;
        this.f3331Qj = false;
        this.f3332Qk = 0.0f;
        this.f3333Ql = 0.5f;
        this.f3334Qm = 0.0f;
        this.mAlpha = 1.0f;
        this.f3335wj = 1;
    }

    MarkerOptions(int versionCode, LatLng position, String title, String snippet, IBinder wrappedIcon, float anchorU, float anchorV, boolean draggable, boolean visible, boolean flat, float rotation, float infoWindowAnchorU, float infoWindowAnchorV, float alpha) {
        this.f3325PY = 0.5f;
        this.f3326PZ = 1.0f;
        this.f3324PQ = true;
        this.f3331Qj = false;
        this.f3332Qk = 0.0f;
        this.f3333Ql = 0.5f;
        this.f3334Qm = 0.0f;
        this.mAlpha = 1.0f;
        this.f3335wj = versionCode;
        this.f3327Qf = position;
        this.f3323CX = title;
        this.f3328Qg = snippet;
        this.f3329Qh = wrappedIcon == null ? null : new BitmapDescriptor(C0454a.m999G(wrappedIcon));
        this.f3325PY = anchorU;
        this.f3326PZ = anchorV;
        this.f3330Qi = draggable;
        this.f3324PQ = visible;
        this.f3331Qj = flat;
        this.f3332Qk = rotation;
        this.f3333Ql = infoWindowAnchorU;
        this.f3334Qm = infoWindowAnchorV;
        this.mAlpha = alpha;
    }

    public MarkerOptions alpha(float alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public MarkerOptions anchor(float u, float v) {
        this.f3325PY = u;
        this.f3326PZ = v;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public MarkerOptions draggable(boolean draggable) {
        this.f3330Qi = draggable;
        return this;
    }

    public MarkerOptions flat(boolean flat) {
        this.f3331Qj = flat;
        return this;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public float getAnchorU() {
        return this.f3325PY;
    }

    public float getAnchorV() {
        return this.f3326PZ;
    }

    public BitmapDescriptor getIcon() {
        return this.f3329Qh;
    }

    public float getInfoWindowAnchorU() {
        return this.f3333Ql;
    }

    public float getInfoWindowAnchorV() {
        return this.f3334Qm;
    }

    public LatLng getPosition() {
        return this.f3327Qf;
    }

    public float getRotation() {
        return this.f3332Qk;
    }

    public String getSnippet() {
        return this.f3328Qg;
    }

    public String getTitle() {
        return this.f3323CX;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3335wj;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hf */
    public IBinder mo7013hf() {
        if (this.f3329Qh == null) {
            return null;
        }
        return this.f3329Qh.mo6852gK().asBinder();
    }

    public MarkerOptions icon(BitmapDescriptor icon) {
        this.f3329Qh = icon;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float u, float v) {
        this.f3333Ql = u;
        this.f3334Qm = v;
        return this;
    }

    public boolean isDraggable() {
        return this.f3330Qi;
    }

    public boolean isFlat() {
        return this.f3331Qj;
    }

    public boolean isVisible() {
        return this.f3324PQ;
    }

    public MarkerOptions position(LatLng position) {
        this.f3327Qf = position;
        return this;
    }

    public MarkerOptions rotation(float rotation) {
        this.f3332Qk = rotation;
        return this;
    }

    public MarkerOptions snippet(String snippet) {
        this.f3328Qg = snippet;
        return this;
    }

    public MarkerOptions title(String title) {
        this.f3323CX = title;
        return this;
    }

    public MarkerOptions visible(boolean visible) {
        this.f3324PQ = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1267f.m3721a(this, out, flags);
        } else {
            MarkerOptionsCreator.m3705a(this, out, flags);
        }
    }
}
