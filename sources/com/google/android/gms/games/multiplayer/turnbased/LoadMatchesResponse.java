package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.internal.C0992gv;

public final class LoadMatchesResponse {

    /* renamed from: JV */
    private final InvitationBuffer f1039JV;

    /* renamed from: JW */
    private final TurnBasedMatchBuffer f1040JW;

    /* renamed from: JX */
    private final TurnBasedMatchBuffer f1041JX;

    /* renamed from: JY */
    private final TurnBasedMatchBuffer f1042JY;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder a = m1107a(matchData, 0);
        if (a != null) {
            this.f1039JV = new InvitationBuffer(a);
        } else {
            this.f1039JV = null;
        }
        DataHolder a2 = m1107a(matchData, 1);
        if (a2 != null) {
            this.f1040JW = new TurnBasedMatchBuffer(a2);
        } else {
            this.f1040JW = null;
        }
        DataHolder a3 = m1107a(matchData, 2);
        if (a3 != null) {
            this.f1041JX = new TurnBasedMatchBuffer(a3);
        } else {
            this.f1041JX = null;
        }
        DataHolder a4 = m1107a(matchData, 3);
        if (a4 != null) {
            this.f1042JY = new TurnBasedMatchBuffer(a4);
        } else {
            this.f1042JY = null;
        }
    }

    /* renamed from: a */
    private static DataHolder m1107a(Bundle bundle, int i) {
        String aW = C0992gv.m2918aW(i);
        if (!bundle.containsKey(aW)) {
            return null;
        }
        return (DataHolder) bundle.getParcelable(aW);
    }

    public void close() {
        if (this.f1039JV != null) {
            this.f1039JV.close();
        }
        if (this.f1040JW != null) {
            this.f1040JW.close();
        }
        if (this.f1041JX != null) {
            this.f1041JX.close();
        }
        if (this.f1042JY != null) {
            this.f1042JY.close();
        }
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.f1042JY;
    }

    public InvitationBuffer getInvitations() {
        return this.f1039JV;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.f1040JW;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.f1041JX;
    }

    public boolean hasData() {
        if (this.f1039JV != null && this.f1039JV.getCount() > 0) {
            return true;
        }
        if (this.f1040JW != null && this.f1040JW.getCount() > 0) {
            return true;
        }
        if (this.f1041JX == null || this.f1041JX.getCount() <= 0) {
            return this.f1042JY != null && this.f1042JY.getCount() > 0;
        }
        return true;
    }
}
