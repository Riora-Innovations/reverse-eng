package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C0807fm;

/* renamed from: com.google.android.gms.games.leaderboard.d */
public final class C0475d implements LeaderboardScore {

    /* renamed from: IQ */
    private final long f954IQ;

    /* renamed from: IR */
    private final String f955IR;

    /* renamed from: IS */
    private final String f956IS;

    /* renamed from: IT */
    private final long f957IT;

    /* renamed from: IU */
    private final long f958IU;

    /* renamed from: IV */
    private final String f959IV;

    /* renamed from: IW */
    private final Uri f960IW;

    /* renamed from: IX */
    private final Uri f961IX;

    /* renamed from: IY */
    private final PlayerEntity f962IY;

    /* renamed from: IZ */
    private final String f963IZ;

    /* renamed from: Ja */
    private final String f964Ja;

    /* renamed from: Jb */
    private final String f965Jb;

    public C0475d(LeaderboardScore leaderboardScore) {
        this.f954IQ = leaderboardScore.getRank();
        this.f955IR = (String) C0766er.m1977f(leaderboardScore.getDisplayRank());
        this.f956IS = (String) C0766er.m1977f(leaderboardScore.getDisplayScore());
        this.f957IT = leaderboardScore.getRawScore();
        this.f958IU = leaderboardScore.getTimestampMillis();
        this.f959IV = leaderboardScore.getScoreHolderDisplayName();
        this.f960IW = leaderboardScore.getScoreHolderIconImageUri();
        this.f961IX = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.f962IY = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.f963IZ = leaderboardScore.getScoreTag();
        this.f964Ja = leaderboardScore.getScoreHolderIconImageUrl();
        this.f965Jb = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    /* renamed from: a */
    static int m1047a(LeaderboardScore leaderboardScore) {
        return C0762ep.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    /* renamed from: a */
    static boolean m1048a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return C0762ep.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && C0762ep.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && C0762ep.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && C0762ep.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && C0762ep.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && C0762ep.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && C0762ep.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && C0762ep.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && C0762ep.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && C0762ep.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    /* renamed from: b */
    static String m1049b(LeaderboardScore leaderboardScore) {
        return C0762ep.m1965e(leaderboardScore).mo5118a("Rank", Long.valueOf(leaderboardScore.getRank())).mo5118a("DisplayRank", leaderboardScore.getDisplayRank()).mo5118a("Score", Long.valueOf(leaderboardScore.getRawScore())).mo5118a("DisplayScore", leaderboardScore.getDisplayScore()).mo5118a("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).mo5118a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).mo5118a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).mo5118a("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).mo5118a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).mo5118a("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).mo5118a("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).mo5118a("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return m1048a(this, obj);
    }

    /* renamed from: fZ */
    public LeaderboardScore freeze() {
        return this;
    }

    public String getDisplayRank() {
        return this.f955IR;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f955IR, dataOut);
    }

    public String getDisplayScore() {
        return this.f956IS;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f956IS, dataOut);
    }

    public long getRank() {
        return this.f954IQ;
    }

    public long getRawScore() {
        return this.f957IT;
    }

    public Player getScoreHolder() {
        return this.f962IY;
    }

    public String getScoreHolderDisplayName() {
        return this.f962IY == null ? this.f959IV : this.f962IY.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.f962IY == null) {
            C0807fm.m2114b(this.f959IV, dataOut);
        } else {
            this.f962IY.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.f962IY == null ? this.f961IX : this.f962IY.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.f962IY == null ? this.f965Jb : this.f962IY.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.f962IY == null ? this.f960IW : this.f962IY.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.f962IY == null ? this.f964Ja : this.f962IY.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.f963IZ;
    }

    public long getTimestampMillis() {
        return this.f958IU;
    }

    public int hashCode() {
        return m1047a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m1049b(this);
    }
}
