package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C1259r;

public final class Tile implements SafeParcelable {
    public static final TileCreator CREATOR = new TileCreator();
    public final byte[] data;
    public final int height;
    public final int width;

    /* renamed from: wj */
    private final int f3354wj;

    Tile(int versionCode, int width2, int height2, byte[] data2) {
        this.f3354wj = versionCode;
        this.width = width2;
        this.height = height2;
        this.data = data2;
    }

    public Tile(int width2, int height2, byte[] data2) {
        this(1, width2, height2, data2);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f3354wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C1259r.m3686hc()) {
            C1270i.m3724a(this, out, flags);
        } else {
            TileCreator.m3709a(this, out, flags);
        }
    }
}
