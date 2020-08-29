package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0468b;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.C0766er;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.b */
public final class C0482b extends C0312b implements Invitation {

    /* renamed from: IM */
    private final Game f1005IM;

    /* renamed from: Ju */
    private final ArrayList<Participant> f1006Ju;

    /* renamed from: Jx */
    private final C0484d f1007Jx;

    C0482b(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.f1005IM = new C0468b(dataHolder, i);
        this.f1006Ju = new ArrayList<>(i2);
        String string = getString("external_inviter_id");
        C0484d dVar = null;
        for (int i3 = 0; i3 < i2; i3++) {
            C0484d dVar2 = new C0484d(this.f581zU, this.f582zW + i3);
            if (dVar2.getParticipantId().equals(string)) {
                dVar = dVar2;
            }
            this.f1006Ju.add(dVar2);
        }
        this.f1007Jx = (C0484d) C0766er.m1975b(dVar, (Object) "Must have a valid inviter!");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.m1065a(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public int getAvailableAutoMatchSlots() {
        if (!getBoolean("has_automatch_criteria")) {
            return 0;
        }
        return getInteger("automatch_max_players");
    }

    public long getCreationTimestamp() {
        return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
    }

    public Game getGame() {
        return this.f1005IM;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public int getInvitationType() {
        return getInteger("type");
    }

    public Participant getInviter() {
        return this.f1007Jx;
    }

    public ArrayList<Participant> getParticipants() {
        return this.f1006Ju;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.m1064a(this);
    }

    public String toString() {
        return InvitationEntity.m1067b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((InvitationEntity) freeze()).writeToParcel(dest, flags);
    }
}
