package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0762ep.C0764a;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C0991gu;
import java.util.HashMap;

public final class ScoreSubmissionData {

    /* renamed from: IH */
    private static final String[] f939IH = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};

    /* renamed from: Gh */
    private String f940Gh;

    /* renamed from: IJ */
    private String f941IJ;

    /* renamed from: Jp */
    private HashMap<Integer, Result> f942Jp = new HashMap<>();

    /* renamed from: yJ */
    private int f943yJ;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore2, String formattedScore2, String scoreTag2, boolean newBest2) {
            this.rawScore = rawScore2;
            this.formattedScore = formattedScore2;
            this.scoreTag = scoreTag2;
            this.newBest = newBest2;
        }

        public String toString() {
            return C0762ep.m1965e(this).mo5118a("RawScore", Long.valueOf(this.rawScore)).mo5118a("FormattedScore", this.formattedScore).mo5118a("ScoreTag", this.scoreTag).mo5118a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.f943yJ = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        C0766er.m1979x(count == 3);
        for (int i = 0; i < count; i++) {
            int I = dataHolder.mo3333I(i);
            if (i == 0) {
                this.f941IJ = dataHolder.getString("leaderboardId", i, I);
                this.f940Gh = dataHolder.getString("playerId", i, I);
            }
            if (dataHolder.getBoolean("hasResult", i, I)) {
                m1040a(new Result(dataHolder.getLong("rawScore", i, I), dataHolder.getString("formattedScore", i, I), dataHolder.getString("scoreTag", i, I), dataHolder.getBoolean("newBest", i, I)), dataHolder.getInteger("timeSpan", i, I));
            }
        }
    }

    /* renamed from: a */
    private void m1040a(Result result, int i) {
        this.f942Jp.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.f941IJ;
    }

    public String getPlayerId() {
        return this.f940Gh;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.f942Jp.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        C0764a a = C0762ep.m1965e(this).mo5118a("PlayerId", this.f940Gh).mo5118a("StatusCode", Integer.valueOf(this.f943yJ));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return a.toString();
            }
            Result result = (Result) this.f942Jp.get(Integer.valueOf(i2));
            a.mo5118a("TimesSpan", C0991gu.m2917aW(i2));
            a.mo5118a("Result", result == null ? "null" : result.toString());
            i = i2 + 1;
        }
    }
}
