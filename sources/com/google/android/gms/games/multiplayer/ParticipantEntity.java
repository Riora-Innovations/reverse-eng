package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0807fm;
import com.google.android.gms.internal.C0890fy;

public final class ParticipantEntity extends C0890fy implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new C0480a();

    /* renamed from: FE */
    private final String f988FE;

    /* renamed from: FJ */
    private final Uri f989FJ;

    /* renamed from: FK */
    private final Uri f990FK;

    /* renamed from: FU */
    private final String f991FU;

    /* renamed from: FV */
    private final String f992FV;

    /* renamed from: GZ */
    private final String f993GZ;

    /* renamed from: JA */
    private final boolean f994JA;

    /* renamed from: JB */
    private final PlayerEntity f995JB;

    /* renamed from: JC */
    private final int f996JC;

    /* renamed from: JD */
    private final ParticipantResult f997JD;

    /* renamed from: Jy */
    private final int f998Jy;

    /* renamed from: Jz */
    private final String f999Jz;

    /* renamed from: wj */
    private final int f1000wj;

    /* renamed from: com.google.android.gms.games.multiplayer.ParticipantEntity$a */
    static final class C0480a extends C0483c {
        C0480a() {
        }

        /* renamed from: ao */
        public ParticipantEntity createFromParcel(Parcel parcel) {
            boolean z = true;
            if (ParticipantEntity.m2395c(ParticipantEntity.m1840dY()) || ParticipantEntity.m1838ae(ParticipantEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z2 = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z2, z ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.f1000wj = versionCode;
        this.f993GZ = participantId;
        this.f988FE = displayName;
        this.f989FJ = iconImageUri;
        this.f990FK = hiResImageUri;
        this.f998Jy = status;
        this.f999Jz = clientAddress;
        this.f994JA = connectedToRoom;
        this.f995JB = player;
        this.f996JC = capabilities;
        this.f997JD = result;
        this.f991FU = iconImageUrl;
        this.f992FV = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.f1000wj = 3;
        this.f993GZ = participant.getParticipantId();
        this.f988FE = participant.getDisplayName();
        this.f989FJ = participant.getIconImageUri();
        this.f990FK = participant.getHiResImageUri();
        this.f998Jy = participant.getStatus();
        this.f999Jz = participant.mo4168ge();
        this.f994JA = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.f995JB = player == null ? null : new PlayerEntity(player);
        this.f996JC = participant.getCapabilities();
        this.f997JD = participant.getResult();
        this.f991FU = participant.getIconImageUrl();
        this.f992FV = participant.getHiResImageUrl();
    }

    /* renamed from: a */
    static int m1072a(Participant participant) {
        return C0762ep.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.mo4168ge(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult());
    }

    /* renamed from: a */
    static boolean m1073a(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return C0762ep.equal(participant2.getPlayer(), participant.getPlayer()) && C0762ep.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && C0762ep.equal(participant2.mo4168ge(), participant.mo4168ge()) && C0762ep.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && C0762ep.equal(participant2.getDisplayName(), participant.getDisplayName()) && C0762ep.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && C0762ep.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && C0762ep.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && C0762ep.equal(participant2.getResult(), participant.getResult());
    }

    /* renamed from: b */
    static String m1075b(Participant participant) {
        return C0762ep.m1965e(participant).mo5118a("Player", participant.getPlayer()).mo5118a("Status", Integer.valueOf(participant.getStatus())).mo5118a("ClientAddress", participant.mo4168ge()).mo5118a("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).mo5118a("DisplayName", participant.getDisplayName()).mo5118a("IconImage", participant.getIconImageUri()).mo5118a("IconImageUrl", participant.getIconImageUrl()).mo5118a("HiResImage", participant.getHiResImageUri()).mo5118a("HiResImageUrl", participant.getHiResImageUrl()).mo5118a("Capabilities", Integer.valueOf(participant.getCapabilities())).mo5118a("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m1073a(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    /* renamed from: ge */
    public String mo4168ge() {
        return this.f999Jz;
    }

    public int getCapabilities() {
        return this.f996JC;
    }

    public String getDisplayName() {
        return this.f995JB == null ? this.f988FE : this.f995JB.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.f995JB == null) {
            C0807fm.m2114b(this.f988FE, dataOut);
        } else {
            this.f995JB.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.f995JB == null ? this.f990FK : this.f995JB.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.f995JB == null ? this.f992FV : this.f995JB.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.f995JB == null ? this.f989FJ : this.f995JB.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.f995JB == null ? this.f991FU : this.f995JB.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.f993GZ;
    }

    public Player getPlayer() {
        return this.f995JB;
    }

    public ParticipantResult getResult() {
        return this.f997JD;
    }

    public int getStatus() {
        return this.f998Jy;
    }

    public int getVersionCode() {
        return this.f1000wj;
    }

    public int hashCode() {
        return m1072a(this);
    }

    public boolean isConnectedToRoom() {
        return this.f994JA;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m1075b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (!mo5034dZ()) {
            C0483c.m1085a(this, dest, flags);
            return;
        }
        dest.writeString(this.f993GZ);
        dest.writeString(this.f988FE);
        dest.writeString(this.f989FJ == null ? null : this.f989FJ.toString());
        if (this.f990FK != null) {
            str = this.f990FK.toString();
        }
        dest.writeString(str);
        dest.writeInt(this.f998Jy);
        dest.writeString(this.f999Jz);
        dest.writeInt(this.f994JA ? 1 : 0);
        if (this.f995JB != null) {
            i = 1;
        }
        dest.writeInt(i);
        if (this.f995JB != null) {
            this.f995JB.writeToParcel(dest, flags);
        }
    }
}
