package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0470d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.leaderboard.e */
public final class C0476e extends C0312b implements LeaderboardScore {

    /* renamed from: Jc */
    private final C0470d f966Jc;

    C0476e(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.f966Jc = new C0470d(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return C0475d.m1048a(this, obj);
    }

    /* renamed from: fZ */
    public LeaderboardScore freeze() {
        return new C0475d(this);
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        mo3372a("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        mo3372a("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        if (mo3374ab("external_player_id")) {
            return null;
        }
        return this.f966Jc;
    }

    public String getScoreHolderDisplayName() {
        return mo3374ab("external_player_id") ? getString("default_display_name") : this.f966Jc.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (mo3374ab("external_player_id")) {
            mo3372a("default_display_name", dataOut);
        } else {
            this.f966Jc.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        if (mo3374ab("external_player_id")) {
            return null;
        }
        return this.f966Jc.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        if (mo3374ab("external_player_id")) {
            return null;
        }
        return this.f966Jc.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return mo3374ab("external_player_id") ? mo3373aa("default_display_image_uri") : this.f966Jc.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return mo3374ab("external_player_id") ? getString("default_display_image_url") : this.f966Jc.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return C0475d.m1047a(this);
    }

    public String toString() {
        return C0475d.m1049b(this);
    }
}
