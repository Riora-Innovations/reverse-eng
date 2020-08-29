package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {

    /* renamed from: IO */
    private final C0474c f938IO;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.f938IO = new C0474c(dataHolder.getMetadata());
    }

    /* renamed from: fX */
    public C0474c mo4087fX() {
        return this.f938IO;
    }

    public LeaderboardScore get(int position) {
        return new C0476e(this.f561zU, position);
    }
}
