package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0468b;
import com.google.android.gms.games.C0470d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.request.a */
public final class C0493a extends C0312b implements GameRequest {

    /* renamed from: IN */
    private final int f1084IN;

    public C0493a(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.f1084IN = i2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameRequestEntity.m1120a(this, obj);
    }

    /* renamed from: fU */
    public ArrayList<Player> mo4383fU() {
        ArrayList<Player> arrayList = new ArrayList<>(this.f1084IN);
        for (int i = 0; i < this.f1084IN; i++) {
            arrayList.add(new C0470d(this.f581zU, this.f582zW + i, "recipient_"));
        }
        return arrayList;
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new C0468b(this.f581zU, this.f582zW);
    }

    public Player getRecipient() {
        return new C0470d(this.f581zU, this.f582zW, "recipient_");
    }

    public int getRecipientStatus() {
        return getInteger("recipient_status");
    }

    public int getRecipientStatus(String playerId) {
        for (int i = this.f582zW; i < this.f582zW + this.f1084IN; i++) {
            int I = this.f581zU.mo3333I(i);
            if (this.f581zU.getString("recipient_external_player_id", i, I).equals(playerId)) {
                return this.f581zU.getInteger("recipient_status", i, I);
            }
        }
        return -1;
    }

    public String getRequestId() {
        return getString("external_request_id");
    }

    public Player getSender() {
        return new C0470d(this.f581zU, this.f582zW, "sender_");
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return GameRequestEntity.m1119a(this);
    }

    public boolean isConsumed() {
        return getRecipientStatus() == 1;
    }

    public String toString() {
        return GameRequestEntity.m1122c(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameRequestEntity) freeze()).writeToParcel(dest, flags);
    }
}
