package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0807fm;
import com.google.android.gms.internal.C0890fy;
import java.util.ArrayList;

public final class RoomEntity extends C0890fy implements Room {
    public static final Creator<RoomEntity> CREATOR = new C0487a();

    /* renamed from: FH */
    private final String f1028FH;

    /* renamed from: GU */
    private final String f1029GU;

    /* renamed from: JO */
    private final Bundle f1030JO;

    /* renamed from: JS */
    private final String f1031JS;

    /* renamed from: JT */
    private final int f1032JT;

    /* renamed from: JU */
    private final int f1033JU;

    /* renamed from: Jr */
    private final long f1034Jr;

    /* renamed from: Ju */
    private final ArrayList<ParticipantEntity> f1035Ju;

    /* renamed from: Jv */
    private final int f1036Jv;

    /* renamed from: wj */
    private final int f1037wj;

    /* renamed from: com.google.android.gms.games.multiplayer.realtime.RoomEntity$a */
    static final class C0487a extends C0489b {
        C0487a() {
        }

        /* renamed from: aq */
        public RoomEntity createFromParcel(Parcel parcel) {
            if (RoomEntity.m2395c(RoomEntity.m1840dY()) || RoomEntity.m1838ae(RoomEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    RoomEntity(int versionCode, String roomId, String creatorId, long creationTimestamp, int roomStatus, String description, int variant, Bundle autoMatchCriteria, ArrayList<ParticipantEntity> participants, int autoMatchWaitEstimateSeconds) {
        this.f1037wj = versionCode;
        this.f1029GU = roomId;
        this.f1031JS = creatorId;
        this.f1034Jr = creationTimestamp;
        this.f1032JT = roomStatus;
        this.f1028FH = description;
        this.f1036Jv = variant;
        this.f1030JO = autoMatchCriteria;
        this.f1035Ju = participants;
        this.f1033JU = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.f1037wj = 2;
        this.f1029GU = room.getRoomId();
        this.f1031JS = room.getCreatorId();
        this.f1034Jr = room.getCreationTimestamp();
        this.f1032JT = room.getStatus();
        this.f1028FH = room.getDescription();
        this.f1036Jv = room.getVariant();
        this.f1030JO = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.f1035Ju = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.f1035Ju.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.f1033JU = room.getAutoMatchWaitEstimateSeconds();
    }

    /* renamed from: a */
    static int m1091a(Room room) {
        return C0762ep.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: a */
    static int m1092a(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    /* renamed from: a */
    static boolean m1093a(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return C0762ep.equal(room2.getRoomId(), room.getRoomId()) && C0762ep.equal(room2.getCreatorId(), room.getCreatorId()) && C0762ep.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && C0762ep.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && C0762ep.equal(room2.getDescription(), room.getDescription()) && C0762ep.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && C0762ep.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && C0762ep.equal(room2.getParticipants(), room.getParticipants()) && C0762ep.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    /* renamed from: b */
    static String m1095b(Room room) {
        return C0762ep.m1965e(room).mo5118a("RoomId", room.getRoomId()).mo5118a("CreatorId", room.getCreatorId()).mo5118a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).mo5118a("RoomStatus", Integer.valueOf(room.getStatus())).mo5118a("Description", room.getDescription()).mo5118a("Variant", Integer.valueOf(room.getVariant())).mo5118a("AutoMatchCriteria", room.getAutoMatchCriteria()).mo5118a("Participants", room.getParticipants()).mo5118a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    /* renamed from: b */
    static String m1096b(Room room, String str) {
        ArrayList participants = room.getParticipants();
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
    static Participant m1098c(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    /* renamed from: c */
    static ArrayList<String> m1099c(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m1093a((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.f1030JO;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.f1033JU;
    }

    public long getCreationTimestamp() {
        return this.f1034Jr;
    }

    public String getCreatorId() {
        return this.f1031JS;
    }

    public String getDescription() {
        return this.f1028FH;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f1028FH, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return m1098c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m1096b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m1099c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m1092a((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(this.f1035Ju);
    }

    public String getRoomId() {
        return this.f1029GU;
    }

    public int getStatus() {
        return this.f1032JT;
    }

    public int getVariant() {
        return this.f1036Jv;
    }

    public int getVersionCode() {
        return this.f1037wj;
    }

    public int hashCode() {
        return m1091a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m1095b((Room) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (!mo5034dZ()) {
            C0489b.m1104a(this, dest, flags);
            return;
        }
        dest.writeString(this.f1029GU);
        dest.writeString(this.f1031JS);
        dest.writeLong(this.f1034Jr);
        dest.writeInt(this.f1032JT);
        dest.writeString(this.f1028FH);
        dest.writeInt(this.f1036Jv);
        dest.writeBundle(this.f1030JO);
        int size = this.f1035Ju.size();
        dest.writeInt(size);
        for (int i = 0; i < size; i++) {
            ((ParticipantEntity) this.f1035Ju.get(i)).writeToParcel(dest, flags);
        }
    }
}
