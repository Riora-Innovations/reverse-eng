package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C0890fy;
import java.util.ArrayList;

public final class InvitationEntity extends C0890fy implements Invitation {
    public static final Creator<InvitationEntity> CREATOR = new C0479a();

    /* renamed from: GP */
    private final String f979GP;

    /* renamed from: Jq */
    private final GameEntity f980Jq;

    /* renamed from: Jr */
    private final long f981Jr;

    /* renamed from: Js */
    private final int f982Js;

    /* renamed from: Jt */
    private final ParticipantEntity f983Jt;

    /* renamed from: Ju */
    private final ArrayList<ParticipantEntity> f984Ju;

    /* renamed from: Jv */
    private final int f985Jv;

    /* renamed from: Jw */
    private final int f986Jw;

    /* renamed from: wj */
    private final int f987wj;

    /* renamed from: com.google.android.gms.games.multiplayer.InvitationEntity$a */
    static final class C0479a extends C0481a {
        C0479a() {
        }

        /* renamed from: an */
        public InvitationEntity createFromParcel(Parcel parcel) {
            if (InvitationEntity.m2395c(InvitationEntity.m1840dY()) || InvitationEntity.m1838ae(InvitationEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant, int availableAutoMatchSlots) {
        this.f987wj = versionCode;
        this.f980Jq = game;
        this.f979GP = invitationId;
        this.f981Jr = creationTimestamp;
        this.f982Js = invitationType;
        this.f983Jt = inviter;
        this.f984Ju = participants;
        this.f985Jv = variant;
        this.f986Jw = availableAutoMatchSlots;
    }

    InvitationEntity(Invitation invitation) {
        this.f987wj = 2;
        this.f980Jq = new GameEntity(invitation.getGame());
        this.f979GP = invitation.getInvitationId();
        this.f981Jr = invitation.getCreationTimestamp();
        this.f982Js = invitation.getInvitationType();
        this.f985Jv = invitation.getVariant();
        this.f986Jw = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Participant participant = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.f984Ju = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Participant participant2 = (Participant) participants.get(i);
            if (participant2.getParticipantId().equals(participantId)) {
                participant = participant2;
            }
            this.f984Ju.add((ParticipantEntity) participant2.freeze());
        }
        C0766er.m1975b(participant, (Object) "Must have a valid inviter!");
        this.f983Jt = (ParticipantEntity) participant.freeze();
    }

    /* renamed from: a */
    static int m1064a(Invitation invitation) {
        return C0762ep.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    /* renamed from: a */
    static boolean m1065a(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return C0762ep.equal(invitation2.getGame(), invitation.getGame()) && C0762ep.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && C0762ep.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && C0762ep.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && C0762ep.equal(invitation2.getInviter(), invitation.getInviter()) && C0762ep.equal(invitation2.getParticipants(), invitation.getParticipants()) && C0762ep.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && C0762ep.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    /* renamed from: b */
    static String m1067b(Invitation invitation) {
        return C0762ep.m1965e(invitation).mo5118a("Game", invitation.getGame()).mo5118a("InvitationId", invitation.getInvitationId()).mo5118a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).mo5118a("InvitationType", Integer.valueOf(invitation.getInvitationType())).mo5118a("Inviter", invitation.getInviter()).mo5118a("Participants", invitation.getParticipants()).mo5118a("Variant", Integer.valueOf(invitation.getVariant())).mo5118a("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m1065a(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.f986Jw;
    }

    public long getCreationTimestamp() {
        return this.f981Jr;
    }

    public Game getGame() {
        return this.f980Jq;
    }

    public String getInvitationId() {
        return this.f979GP;
    }

    public int getInvitationType() {
        return this.f982Js;
    }

    public Participant getInviter() {
        return this.f983Jt;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.f984Ju);
    }

    public int getVariant() {
        return this.f985Jv;
    }

    public int getVersionCode() {
        return this.f987wj;
    }

    public int hashCode() {
        return m1064a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m1067b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo5034dZ()) {
            C0481a.m1082a(this, dest, flags);
            return;
        }
        this.f980Jq.writeToParcel(dest, flags);
        dest.writeString(this.f979GP);
        dest.writeLong(this.f981Jr);
        dest.writeInt(this.f982Js);
        this.f983Jt.writeToParcel(dest, flags);
        int size = this.f984Ju.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            ((ParticipantEntity) this.f984Ju.get(i)).writeToParcel(dest, flags);
        }
    }
}
