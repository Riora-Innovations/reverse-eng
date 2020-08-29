package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C0762ep;
import java.util.ArrayList;
import java.util.Arrays;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();

    /* renamed from: AI */
    private final int f1074AI;

    /* renamed from: Hh */
    private final String f1075Hh;

    /* renamed from: Jq */
    private final GameEntity f1076Jq;

    /* renamed from: Jr */
    private final long f1077Jr;

    /* renamed from: Kf */
    private final byte[] f1078Kf;

    /* renamed from: Km */
    private final PlayerEntity f1079Km;

    /* renamed from: Kn */
    private final ArrayList<PlayerEntity> f1080Kn;

    /* renamed from: Ko */
    private final long f1081Ko;

    /* renamed from: Kp */
    private final Bundle f1082Kp;

    /* renamed from: wj */
    private final int f1083wj;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses) {
        this.f1083wj = versionCode;
        this.f1076Jq = game;
        this.f1079Km = sender;
        this.f1078Kf = data;
        this.f1075Hh = requestId;
        this.f1080Kn = recipients;
        this.f1074AI = type;
        this.f1077Jr = creationTimestamp;
        this.f1081Ko = expirationTimestamp;
        this.f1082Kp = recipientStatuses;
    }

    public GameRequestEntity(GameRequest request) {
        this.f1083wj = 1;
        this.f1076Jq = new GameEntity(request.getGame());
        this.f1079Km = new PlayerEntity(request.getSender());
        this.f1075Hh = request.getRequestId();
        this.f1074AI = request.getType();
        this.f1077Jr = request.getCreationTimestamp();
        this.f1081Ko = request.getExpirationTimestamp();
        byte[] data = request.getData();
        if (data == null) {
            this.f1078Kf = null;
        } else {
            this.f1078Kf = new byte[data.length];
            System.arraycopy(data, 0, this.f1078Kf, 0, data.length);
        }
        ArrayList fU = request.mo4383fU();
        int size = fU.size();
        this.f1080Kn = new ArrayList<>(size);
        this.f1082Kp = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) fU.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.f1080Kn.add((PlayerEntity) player);
            this.f1082Kp.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    /* renamed from: a */
    static int m1119a(GameRequest gameRequest) {
        return C0762ep.hashCode(gameRequest.getGame(), gameRequest.mo4383fU(), gameRequest.getRequestId(), gameRequest.getSender(), m1121b(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    /* renamed from: a */
    static boolean m1120a(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return C0762ep.equal(gameRequest2.getGame(), gameRequest.getGame()) && C0762ep.equal(gameRequest2.mo4383fU(), gameRequest.mo4383fU()) && C0762ep.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && C0762ep.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(m1121b(gameRequest2), m1121b(gameRequest)) && C0762ep.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && C0762ep.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && C0762ep.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    /* renamed from: b */
    private static int[] m1121b(GameRequest gameRequest) {
        ArrayList fU = gameRequest.mo4383fU();
        int size = fU.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) fU.get(i)).getPlayerId());
        }
        return iArr;
    }

    /* renamed from: c */
    static String m1122c(GameRequest gameRequest) {
        return C0762ep.m1965e(gameRequest).mo5118a("Game", gameRequest.getGame()).mo5118a("Sender", gameRequest.getSender()).mo5118a("Recipients", gameRequest.mo4383fU()).mo5118a("Data", gameRequest.getData()).mo5118a("RequestId", gameRequest.getRequestId()).mo5118a("Type", Integer.valueOf(gameRequest.getType())).mo5118a("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).mo5118a("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m1120a(this, obj);
    }

    /* renamed from: fU */
    public ArrayList<Player> mo4383fU() {
        return new ArrayList<>(this.f1080Kn);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.f1077Jr;
    }

    public byte[] getData() {
        return this.f1078Kf;
    }

    public long getExpirationTimestamp() {
        return this.f1081Ko;
    }

    public Game getGame() {
        return this.f1076Jq;
    }

    public Player getRecipient() {
        if (this.f1080Kn.isEmpty()) {
            return null;
        }
        return (Player) this.f1080Kn.get(0);
    }

    public int getRecipientStatus() {
        return this.f1082Kp.getInt(((PlayerEntity) this.f1080Kn.get(0)).getPlayerId(), 0);
    }

    public int getRecipientStatus(String playerId) {
        return this.f1082Kp.getInt(playerId, 0);
    }

    public String getRequestId() {
        return this.f1075Hh;
    }

    public Player getSender() {
        return this.f1079Km;
    }

    public int getType() {
        return this.f1074AI;
    }

    public int getVersionCode() {
        return this.f1083wj;
    }

    /* renamed from: gf */
    public Bundle mo4399gf() {
        return this.f1082Kp;
    }

    public int hashCode() {
        return m1119a(this);
    }

    public boolean isConsumed() {
        return getRecipientStatus() == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m1122c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.m1125a(this, dest, flags);
    }
}
