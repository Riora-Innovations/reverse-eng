package com.google.android.gms.games.leaderboard;

import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0987gq;
import com.google.android.gms.internal.C0991gu;

/* renamed from: com.google.android.gms.games.leaderboard.f */
public final class C0477f implements LeaderboardVariant {

    /* renamed from: Jd */
    private final int f967Jd;

    /* renamed from: Je */
    private final int f968Je;

    /* renamed from: Jf */
    private final boolean f969Jf;

    /* renamed from: Jg */
    private final long f970Jg;

    /* renamed from: Jh */
    private final String f971Jh;

    /* renamed from: Ji */
    private final long f972Ji;

    /* renamed from: Jj */
    private final String f973Jj;

    /* renamed from: Jk */
    private final String f974Jk;

    /* renamed from: Jl */
    private final long f975Jl;

    /* renamed from: Jm */
    private final String f976Jm;

    /* renamed from: Jn */
    private final String f977Jn;

    /* renamed from: Jo */
    private final String f978Jo;

    public C0477f(LeaderboardVariant leaderboardVariant) {
        this.f967Jd = leaderboardVariant.getTimeSpan();
        this.f968Je = leaderboardVariant.getCollection();
        this.f969Jf = leaderboardVariant.hasPlayerInfo();
        this.f970Jg = leaderboardVariant.getRawPlayerScore();
        this.f971Jh = leaderboardVariant.getDisplayPlayerScore();
        this.f972Ji = leaderboardVariant.getPlayerRank();
        this.f973Jj = leaderboardVariant.getDisplayPlayerRank();
        this.f974Jk = leaderboardVariant.getPlayerScoreTag();
        this.f975Jl = leaderboardVariant.getNumScores();
        this.f976Jm = leaderboardVariant.mo4088ga();
        this.f977Jn = leaderboardVariant.mo4089gb();
        this.f978Jo = leaderboardVariant.mo4090gc();
    }

    /* renamed from: a */
    static int m1052a(LeaderboardVariant leaderboardVariant) {
        return C0762ep.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.mo4088ga(), leaderboardVariant.mo4090gc(), leaderboardVariant.mo4089gb());
    }

    /* renamed from: a */
    static boolean m1053a(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return C0762ep.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && C0762ep.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && C0762ep.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && C0762ep.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && C0762ep.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && C0762ep.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && C0762ep.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && C0762ep.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && C0762ep.equal(leaderboardVariant2.mo4088ga(), leaderboardVariant.mo4088ga()) && C0762ep.equal(leaderboardVariant2.mo4090gc(), leaderboardVariant.mo4090gc()) && C0762ep.equal(leaderboardVariant2.mo4089gb(), leaderboardVariant.mo4089gb());
    }

    /* renamed from: b */
    static String m1054b(LeaderboardVariant leaderboardVariant) {
        return C0762ep.m1965e(leaderboardVariant).mo5118a("TimeSpan", C0991gu.m2917aW(leaderboardVariant.getTimeSpan())).mo5118a("Collection", C0987gq.m2915aW(leaderboardVariant.getCollection())).mo5118a("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").mo5118a("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").mo5118a("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").mo5118a("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").mo5118a("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).mo5118a("TopPageNextToken", leaderboardVariant.mo4088ga()).mo5118a("WindowPageNextToken", leaderboardVariant.mo4090gc()).mo5118a("WindowPagePrevToken", leaderboardVariant.mo4089gb()).toString();
    }

    public boolean equals(Object obj) {
        return m1053a(this, obj);
    }

    /* renamed from: ga */
    public String mo4088ga() {
        return this.f976Jm;
    }

    /* renamed from: gb */
    public String mo4089gb() {
        return this.f977Jn;
    }

    /* renamed from: gc */
    public String mo4090gc() {
        return this.f978Jo;
    }

    /* renamed from: gd */
    public LeaderboardVariant freeze() {
        return this;
    }

    public int getCollection() {
        return this.f968Je;
    }

    public String getDisplayPlayerRank() {
        return this.f973Jj;
    }

    public String getDisplayPlayerScore() {
        return this.f971Jh;
    }

    public long getNumScores() {
        return this.f975Jl;
    }

    public long getPlayerRank() {
        return this.f972Ji;
    }

    public String getPlayerScoreTag() {
        return this.f974Jk;
    }

    public long getRawPlayerScore() {
        return this.f970Jg;
    }

    public int getTimeSpan() {
        return this.f967Jd;
    }

    public boolean hasPlayerInfo() {
        return this.f969Jf;
    }

    public int hashCode() {
        return m1052a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m1054b(this);
    }
}
