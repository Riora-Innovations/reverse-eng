package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.C0314d;
import com.google.android.gms.common.data.DataHolder;

public final class TurnBasedMatchBuffer extends C0314d<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getEntry */
    public TurnBasedMatch mo3384c(int rowIndex, int numChildren) {
        return new C0492a(this.f561zU, rowIndex, numChildren);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
