package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0807fm;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();

    /* renamed from: FH */
    private final String f1051FH;

    /* renamed from: GV */
    private final String f1052GV;

    /* renamed from: JO */
    private final Bundle f1053JO;

    /* renamed from: JS */
    private final String f1054JS;

    /* renamed from: Jq */
    private final GameEntity f1055Jq;

    /* renamed from: Jr */
    private final long f1056Jr;

    /* renamed from: Ju */
    private final ArrayList<ParticipantEntity> f1057Ju;

    /* renamed from: Jv */
    private final int f1058Jv;

    /* renamed from: Ka */
    private final String f1059Ka;

    /* renamed from: Kb */
    private final long f1060Kb;

    /* renamed from: Kc */
    private final String f1061Kc;

    /* renamed from: Kd */
    private final int f1062Kd;

    /* renamed from: Ke */
    private final int f1063Ke;

    /* renamed from: Kf */
    private final byte[] f1064Kf;

    /* renamed from: Kg */
    private final String f1065Kg;

    /* renamed from: Kh */
    private final byte[] f1066Kh;

    /* renamed from: Ki */
    private final int f1067Ki;

    /* renamed from: Kj */
    private final int f1068Kj;

    /* renamed from: Kk */
    private final boolean f1069Kk;

    /* renamed from: Kl */
    private final String f1070Kl;

    /* renamed from: wj */
    private final int f1071wj;

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.f1071wj = versionCode;
        this.f1055Jq = game;
        this.f1052GV = matchId;
        this.f1054JS = creatorId;
        this.f1056Jr = creationTimestamp;
        this.f1059Ka = lastUpdaterId;
        this.f1060Kb = lastUpdatedTimestamp;
        this.f1061Kc = pendingParticipantId;
        this.f1062Kd = matchStatus;
        this.f1068Kj = turnStatus;
        this.f1058Jv = variant;
        this.f1063Ke = version;
        this.f1064Kf = data;
        this.f1057Ju = participants;
        this.f1065Kg = rematchId;
        this.f1066Kh = previousData;
        this.f1067Ki = matchNumber;
        this.f1053JO = autoMatchCriteria;
        this.f1069Kk = isLocallyModified;
        this.f1051FH = description;
        this.f1070Kl = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.f1071wj = 2;
        this.f1055Jq = new GameEntity(match.getGame());
        this.f1052GV = match.getMatchId();
        this.f1054JS = match.getCreatorId();
        this.f1056Jr = match.getCreationTimestamp();
        this.f1059Ka = match.getLastUpdaterId();
        this.f1060Kb = match.getLastUpdatedTimestamp();
        this.f1061Kc = match.getPendingParticipantId();
        this.f1062Kd = match.getStatus();
        this.f1068Kj = match.getTurnStatus();
        this.f1058Jv = match.getVariant();
        this.f1063Ke = match.getVersion();
        this.f1065Kg = match.getRematchId();
        this.f1067Ki = match.getMatchNumber();
        this.f1053JO = match.getAutoMatchCriteria();
        this.f1069Kk = match.isLocallyModified();
        this.f1051FH = match.getDescription();
        this.f1070Kl = match.getDescriptionParticipantId();
        byte[] data = match.getData();
        if (data == null) {
            this.f1064Kf = null;
        } else {
            this.f1064Kf = new byte[data.length];
            System.arraycopy(data, 0, this.f1064Kf, 0, data.length);
        }
        byte[] previousMatchData = match.getPreviousMatchData();
        if (previousMatchData == null) {
            this.f1066Kh = null;
        } else {
            this.f1066Kh = new byte[previousMatchData.length];
            System.arraycopy(previousMatchData, 0, this.f1066Kh, 0, previousMatchData.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.f1057Ju = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.f1057Ju.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    /* renamed from: a */
    static int m1109a(TurnBasedMatch turnBasedMatch) {
        return C0762ep.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    /* renamed from: a */
    static int m1110a(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    /* renamed from: a */
    static boolean m1111a(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return C0762ep.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && C0762ep.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && C0762ep.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && C0762ep.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && C0762ep.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && C0762ep.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && C0762ep.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && C0762ep.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && C0762ep.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && C0762ep.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && C0762ep.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && C0762ep.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && C0762ep.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && C0762ep.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && C0762ep.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && C0762ep.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && C0762ep.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && C0762ep.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    /* renamed from: b */
    static String m1112b(TurnBasedMatch turnBasedMatch) {
        return C0762ep.m1965e(turnBasedMatch).mo5118a("Game", turnBasedMatch.getGame()).mo5118a("MatchId", turnBasedMatch.getMatchId()).mo5118a("CreatorId", turnBasedMatch.getCreatorId()).mo5118a("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).mo5118a("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).mo5118a("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).mo5118a("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).mo5118a("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).mo5118a("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).mo5118a("Description", turnBasedMatch.getDescription()).mo5118a("Variant", Integer.valueOf(turnBasedMatch.getVariant())).mo5118a("Data", turnBasedMatch.getData()).mo5118a("Version", Integer.valueOf(turnBasedMatch.getVersion())).mo5118a("Participants", turnBasedMatch.getParticipants()).mo5118a("RematchId", turnBasedMatch.getRematchId()).mo5118a("PreviousData", turnBasedMatch.getPreviousMatchData()).mo5118a("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).mo5118a("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).mo5118a("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).mo5118a("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).mo5118a("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    /* renamed from: b */
    static String m1113b(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    /* renamed from: c */
    static Participant m1114c(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    /* renamed from: c */
    static ArrayList<String> m1115c(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.f1062Kd == 2 && this.f1065Kg == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m1111a((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.f1053JO;
    }

    public int getAvailableAutoMatchSlots() {
        if (this.f1053JO == null) {
            return 0;
        }
        return this.f1053JO.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.f1056Jr;
    }

    public String getCreatorId() {
        return this.f1054JS;
    }

    public byte[] getData() {
        return this.f1064Kf;
    }

    public String getDescription() {
        return this.f1051FH;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f1051FH, dataOut);
    }

    public Participant getDescriptionParticipant() {
        return getParticipant(getDescriptionParticipantId());
    }

    public String getDescriptionParticipantId() {
        return this.f1070Kl;
    }

    public Game getGame() {
        return this.f1055Jq;
    }

    public long getLastUpdatedTimestamp() {
        return this.f1060Kb;
    }

    public String getLastUpdaterId() {
        return this.f1059Ka;
    }

    public String getMatchId() {
        return this.f1052GV;
    }

    public int getMatchNumber() {
        return this.f1067Ki;
    }

    public Participant getParticipant(String participantId) {
        return m1114c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m1113b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m1115c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m1110a((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.f1057Ju);
    }

    public String getPendingParticipantId() {
        return this.f1061Kc;
    }

    public byte[] getPreviousMatchData() {
        return this.f1066Kh;
    }

    public String getRematchId() {
        return this.f1065Kg;
    }

    public int getStatus() {
        return this.f1062Kd;
    }

    public int getTurnStatus() {
        return this.f1068Kj;
    }

    public int getVariant() {
        return this.f1058Jv;
    }

    public int getVersion() {
        return this.f1063Ke;
    }

    public int getVersionCode() {
        return this.f1071wj;
    }

    public int hashCode() {
        return m1109a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.f1069Kk;
    }

    public String toString() {
        return m1112b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.m1116a(this, out, flags);
    }
}
