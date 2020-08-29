package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0314d;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.a */
public final class C0488a extends C0314d<Room> {
    public C0488a(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Room mo3384c(int i, int i2) {
        return new C0490c(this.f561zU, i, i2);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
