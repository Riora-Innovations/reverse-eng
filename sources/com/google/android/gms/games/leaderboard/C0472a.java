package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0807fm;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.leaderboard.a */
public final class C0472a implements Leaderboard {

    /* renamed from: FE */
    private final String f944FE;

    /* renamed from: FJ */
    private final Uri f945FJ;

    /* renamed from: FU */
    private final String f946FU;

    /* renamed from: IJ */
    private final String f947IJ;

    /* renamed from: IK */
    private final int f948IK;

    /* renamed from: IL */
    private final ArrayList<C0477f> f949IL;

    /* renamed from: IM */
    private final Game f950IM;

    public C0472a(Leaderboard leaderboard) {
        this.f947IJ = leaderboard.getLeaderboardId();
        this.f944FE = leaderboard.getDisplayName();
        this.f945FJ = leaderboard.getIconImageUri();
        this.f946FU = leaderboard.getIconImageUrl();
        this.f948IK = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.f950IM = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.f949IL = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.f949IL.add((C0477f) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    /* renamed from: a */
    static int m1041a(Leaderboard leaderboard) {
        return C0762ep.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    /* renamed from: a */
    static boolean m1042a(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return C0762ep.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && C0762ep.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && C0762ep.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && C0762ep.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && C0762ep.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    /* renamed from: b */
    static String m1043b(Leaderboard leaderboard) {
        return C0762ep.m1965e(leaderboard).mo5118a("LeaderboardId", leaderboard.getLeaderboardId()).mo5118a("DisplayName", leaderboard.getDisplayName()).mo5118a("IconImageUri", leaderboard.getIconImageUri()).mo5118a("IconImageUrl", leaderboard.getIconImageUrl()).mo5118a("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).mo5118a("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return m1042a(this, obj);
    }

    /* renamed from: fW */
    public Leaderboard freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.f944FE;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f944FE, dataOut);
    }

    public Game getGame() {
        return this.f950IM;
    }

    public Uri getIconImageUri() {
        return this.f945FJ;
    }

    public String getIconImageUrl() {
        return this.f946FU;
    }

    public String getLeaderboardId() {
        return this.f947IJ;
    }

    public int getScoreOrder() {
        return this.f948IK;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.f949IL);
    }

    public int hashCode() {
        return m1041a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m1043b(this);
    }
}
