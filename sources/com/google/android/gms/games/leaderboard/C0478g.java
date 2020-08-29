package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.games.leaderboard.g */
public final class C0478g extends C0312b implements LeaderboardVariant {
    C0478g(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return C0477f.m1053a(this, obj);
    }

    /* renamed from: ga */
    public String mo4088ga() {
        return getString("top_page_token_next");
    }

    /* renamed from: gb */
    public String mo4089gb() {
        return getString("window_page_token_prev");
    }

    /* renamed from: gc */
    public String mo4090gc() {
        return getString("window_page_token_next");
    }

    /* renamed from: gd */
    public LeaderboardVariant freeze() {
        return new C0477f(this);
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        if (mo3374ab("total_scores")) {
            return -1;
        }
        return getLong("total_scores");
    }

    public long getPlayerRank() {
        if (mo3374ab("player_rank")) {
            return -1;
        }
        return getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        if (mo3374ab("player_raw_score")) {
            return -1;
        }
        return getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !mo3374ab("player_raw_score");
    }

    public int hashCode() {
        return C0477f.m1052a(this);
    }

    public String toString() {
        return C0477f.m1054b(this);
    }
}
