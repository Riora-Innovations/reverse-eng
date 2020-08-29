package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0314d;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardBuffer extends C0314d<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getEntry */
    public Leaderboard mo3384c(int rowIndex, int numChildren) {
        return new C0473b(this.f561zU, rowIndex, numChildren);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
