package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.internal.C0766er;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomConfig {

    /* renamed from: GP */
    private final String f1012GP;

    /* renamed from: JK */
    private final RoomUpdateListener f1013JK;

    /* renamed from: JL */
    private final RoomStatusUpdateListener f1014JL;

    /* renamed from: JM */
    private final RealTimeMessageReceivedListener f1015JM;

    /* renamed from: JN */
    private final String[] f1016JN;

    /* renamed from: JO */
    private final Bundle f1017JO;

    /* renamed from: JP */
    private final boolean f1018JP;

    /* renamed from: Jv */
    private final int f1019Jv;

    public static final class Builder {

        /* renamed from: JK */
        final RoomUpdateListener f1020JK;

        /* renamed from: JL */
        RoomStatusUpdateListener f1021JL;

        /* renamed from: JM */
        RealTimeMessageReceivedListener f1022JM;

        /* renamed from: JO */
        Bundle f1023JO;

        /* renamed from: JP */
        boolean f1024JP;

        /* renamed from: JQ */
        String f1025JQ;

        /* renamed from: JR */
        ArrayList<String> f1026JR;

        /* renamed from: Jv */
        int f1027Jv;

        private Builder(RoomUpdateListener updateListener) {
            this.f1025JQ = null;
            this.f1027Jv = -1;
            this.f1026JR = new ArrayList<>();
            this.f1024JP = false;
            this.f1020JK = (RoomUpdateListener) C0766er.m1975b(updateListener, (Object) "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> playerIds) {
            C0766er.m1977f(playerIds);
            this.f1026JR.addAll(playerIds);
            return this;
        }

        public Builder addPlayersToInvite(String... playerIds) {
            C0766er.m1977f(playerIds);
            this.f1026JR.addAll(Arrays.asList(playerIds));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.f1023JO = autoMatchCriteria;
            return this;
        }

        public Builder setInvitationIdToAccept(String invitationId) {
            C0766er.m1977f(invitationId);
            this.f1025JQ = invitationId;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener listener) {
            this.f1022JM = listener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener listener) {
            this.f1021JL = listener;
            return this;
        }

        public Builder setSocketCommunicationEnabled(boolean enableSockets) {
            this.f1024JP = enableSockets;
            return this;
        }

        public Builder setVariant(int variant) {
            C0766er.m1976b(variant == -1 || variant > 0, (Object) "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.f1027Jv = variant;
            return this;
        }
    }

    private RoomConfig(Builder builder) {
        this.f1013JK = builder.f1020JK;
        this.f1014JL = builder.f1021JL;
        this.f1015JM = builder.f1022JM;
        this.f1012GP = builder.f1025JQ;
        this.f1019Jv = builder.f1027Jv;
        this.f1017JO = builder.f1023JO;
        this.f1018JP = builder.f1024JP;
        this.f1016JN = (String[]) builder.f1026JR.toArray(new String[builder.f1026JR.size()]);
        if (this.f1015JM == null) {
            C0766er.m1970a(this.f1018JP, "Must either enable sockets OR specify a message listener");
        }
    }

    public static Builder builder(RoomUpdateListener listener) {
        return new Builder(listener);
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public Bundle getAutoMatchCriteria() {
        return this.f1017JO;
    }

    public String getInvitationId() {
        return this.f1012GP;
    }

    public String[] getInvitedPlayerIds() {
        return this.f1016JN;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.f1015JM;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.f1014JL;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.f1013JK;
    }

    public int getVariant() {
        return this.f1019Jv;
    }

    public boolean isSocketEnabled() {
        return this.f1018JP;
    }
}
