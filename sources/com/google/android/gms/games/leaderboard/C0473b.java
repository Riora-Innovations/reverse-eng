package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0468b;
import com.google.android.gms.games.Game;
import java.util.ArrayList;
import org.achartengine.chartdemo.demo.chart.IDemoChart;

/* renamed from: com.google.android.gms.games.leaderboard.b */
public final class C0473b extends C0312b implements Leaderboard {

    /* renamed from: IM */
    private final Game f951IM;

    /* renamed from: IN */
    private final int f952IN;

    C0473b(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.f952IN = i2;
        this.f951IM = new C0468b(dataHolder, i);
    }

    public boolean equals(Object obj) {
        return C0472a.m1042a(this, obj);
    }

    /* renamed from: fW */
    public Leaderboard freeze() {
        return new C0472a(this);
    }

    public String getDisplayName() {
        return getString(IDemoChart.NAME);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo3372a(IDemoChart.NAME, dataOut);
    }

    public Game getGame() {
        return this.f951IM;
    }

    public Uri getIconImageUri() {
        return mo3373aa("board_icon_image_uri");
    }

    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder() {
        return getInteger("score_order");
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(this.f952IN);
        for (int i = 0; i < this.f952IN; i++) {
            arrayList.add(new C0478g(this.f581zU, this.f582zW + i));
        }
        return arrayList;
    }

    public int hashCode() {
        return C0472a.m1041a(this);
    }

    public String toString() {
        return C0472a.m1043b(this);
    }
}
