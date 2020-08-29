package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1259r;
import com.google.android.gms.maps.model.internal.C1291g;
import com.google.android.gms.maps.model.internal.C1291g.C1292a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();

    /* renamed from: PP */
    private float f3356PP;

    /* renamed from: PQ */
    private boolean f3357PQ;
    /* access modifiers changed from: private */

    /* renamed from: Qt */
    public C1291g f3358Qt;

    /* renamed from: Qu */
    private TileProvider f3359Qu;

    /* renamed from: Qv */
    private boolean f3360Qv;

    /* renamed from: wj */
    private final int f3361wj;

    public TileOverlayOptions() {
        this.f3357PQ = true;
        this.f3360Qv = true;
        this.f3361wj = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.f3357PQ = true;
        this.f3360Qv = true;
        this.f3361wj = versionCode;
        this.f3358Qt = C1292a.m3762au(delegate);
        this.f3359Qu = this.f3358Qt == null ? null : new TileProvider() {

            /* renamed from: Qw */
            private final C1291g f3362Qw = TileOverlayOptions.this.f3358Qt;

            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.f3362Qw.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.f3357PQ = visible;
        this.f3356PP = zIndex;
        this.f3360Qv = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.f3360Qv = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.f3360Qv;
    }

    public TileProvider getTileProvider() {
        return this.f3359Qu;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3361wj;
    }

    public float getZIndex() {
        return this.f3356PP;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hh */
    public IBinder mo7128hh() {
        return this.f3358Qt.asBinder();
    }

    public boolean isVisible() {
        return this.f3357PQ;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.f3359Qu = tileProvider;
        this.f3358Qt = this.f3359Qu == null ? null : new C1292a() {
            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.f3357PQ = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1294j.m3763a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m3712a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.f3356PP = zIndex;
        return this;
    }
}
