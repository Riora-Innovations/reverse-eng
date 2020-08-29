package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0470d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.multiplayer.d */
public final class C0484d extends C0312b implements Participant {

    /* renamed from: JE */
    private final C0470d f1008JE;

    public C0484d(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.f1008JE = new C0470d(dataHolder, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.m1073a(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    /* renamed from: ge */
    public String mo4168ge() {
        return getString("client_address");
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return mo3374ab("external_player_id") ? getString("default_display_name") : this.f1008JE.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (mo3374ab("external_player_id")) {
            mo3372a("default_display_name", dataOut);
        } else {
            this.f1008JE.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return mo3374ab("external_player_id") ? mo3373aa("default_display_hi_res_image_uri") : this.f1008JE.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return mo3374ab("external_player_id") ? getString("default_display_hi_res_image_url") : this.f1008JE.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return mo3374ab("external_player_id") ? mo3373aa("default_display_image_uri") : this.f1008JE.getIconImageUri();
    }

    public String getIconImageUrl() {
        return mo3374ab("external_player_id") ? getString("default_display_image_url") : this.f1008JE.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        if (mo3374ab("external_player_id")) {
            return null;
        }
        return this.f1008JE;
    }

    public ParticipantResult getResult() {
        if (mo3374ab("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.m1072a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.m1075b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }
}
