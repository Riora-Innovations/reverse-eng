package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.internal.C0766er;
import java.util.ArrayList;

public final class TurnBasedMatchConfig {

    /* renamed from: JN */
    private final String[] f1043JN;

    /* renamed from: JO */
    private final Bundle f1044JO;

    /* renamed from: JZ */
    private final int f1045JZ;

    /* renamed from: Jv */
    private final int f1046Jv;

    public static final class Builder {

        /* renamed from: JO */
        Bundle f1047JO;

        /* renamed from: JR */
        ArrayList<String> f1048JR;

        /* renamed from: JZ */
        int f1049JZ;

        /* renamed from: Jv */
        int f1050Jv;

        private Builder() {
            this.f1050Jv = -1;
            this.f1048JR = new ArrayList<>();
            this.f1047JO = null;
            this.f1049JZ = 2;
        }

        public Builder addInvitedPlayer(String playerId) {
            C0766er.m1977f(playerId);
            this.f1048JR.add(playerId);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> playerIds) {
            C0766er.m1977f(playerIds);
            this.f1048JR.addAll(playerIds);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.f1047JO = autoMatchCriteria;
            return this;
        }

        public Builder setMinPlayers(int minPlayers) {
            this.f1049JZ = minPlayers;
            return this;
        }

        public Builder setVariant(int variant) {
            C0766er.m1976b(variant == -1 || variant > 0, (Object) "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.f1050Jv = variant;
            return this;
        }
    }

    private TurnBasedMatchConfig(Builder builder) {
        this.f1046Jv = builder.f1050Jv;
        this.f1045JZ = builder.f1049JZ;
        this.f1044JO = builder.f1047JO;
        this.f1043JN = (String[]) builder.f1048JR.toArray(new String[builder.f1048JR.size()]);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public Bundle getAutoMatchCriteria() {
        return this.f1044JO;
    }

    public String[] getInvitedPlayerIds() {
        return this.f1043JN;
    }

    public int getMinPlayers() {
        return this.f1045JZ;
    }

    public int getVariant() {
        return this.f1046Jv;
    }
}
