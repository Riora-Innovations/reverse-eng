package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.C0731ed;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0807fm;
import com.google.android.gms.internal.C0890fy;

public final class PlayerEntity extends C0890fy implements Player {
    public static final Creator<PlayerEntity> CREATOR = new C0465a();

    /* renamed from: FE */
    private final String f918FE;

    /* renamed from: FJ */
    private final Uri f919FJ;

    /* renamed from: FK */
    private final Uri f920FK;

    /* renamed from: FU */
    private final String f921FU;

    /* renamed from: FV */
    private final String f922FV;

    /* renamed from: Gh */
    private final String f923Gh;

    /* renamed from: Gi */
    private final long f924Gi;

    /* renamed from: Gj */
    private final int f925Gj;

    /* renamed from: Gk */
    private final long f926Gk;

    /* renamed from: wj */
    private final int f927wj;

    /* renamed from: com.google.android.gms.games.PlayerEntity$a */
    static final class C0465a extends C0469c {
        C0465a() {
        }

        /* renamed from: ak */
        public PlayerEntity createFromParcel(Parcel parcel) {
            if (PlayerEntity.m2395c(PlayerEntity.m1840dY()) || PlayerEntity.m1838ae(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(4, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null);
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl) {
        this.f927wj = versionCode;
        this.f923Gh = playerId;
        this.f918FE = displayName;
        this.f919FJ = iconImageUri;
        this.f921FU = iconImageUrl;
        this.f920FK = hiResImageUri;
        this.f922FV = hiResImageUrl;
        this.f924Gi = retrievedTimestamp;
        this.f925Gj = isInCircles;
        this.f926Gk = lastPlayedWithTimestamp;
    }

    public PlayerEntity(Player player) {
        this.f927wj = 4;
        this.f923Gh = player.getPlayerId();
        this.f918FE = player.getDisplayName();
        this.f919FJ = player.getIconImageUri();
        this.f921FU = player.getIconImageUrl();
        this.f920FK = player.getHiResImageUri();
        this.f922FV = player.getHiResImageUrl();
        this.f924Gi = player.getRetrievedTimestamp();
        this.f925Gj = player.mo3993fl();
        this.f926Gk = player.getLastPlayedWithTimestamp();
        C0731ed.m1825d(this.f923Gh);
        C0731ed.m1825d(this.f918FE);
        C0731ed.m1826v(this.f924Gi > 0);
    }

    /* renamed from: a */
    static int m1020a(Player player) {
        return C0762ep.hashCode(player.getPlayerId(), player.getDisplayName(), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()));
    }

    /* renamed from: a */
    static boolean m1021a(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return C0762ep.equal(player2.getPlayerId(), player.getPlayerId()) && C0762ep.equal(player2.getDisplayName(), player.getDisplayName()) && C0762ep.equal(player2.getIconImageUri(), player.getIconImageUri()) && C0762ep.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && C0762ep.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp()));
    }

    /* renamed from: b */
    static String m1023b(Player player) {
        return C0762ep.m1965e(player).mo5118a("PlayerId", player.getPlayerId()).mo5118a("DisplayName", player.getDisplayName()).mo5118a("IconImageUri", player.getIconImageUri()).mo5118a("IconImageUrl", player.getIconImageUrl()).mo5118a("HiResImageUri", player.getHiResImageUri()).mo5118a("HiResImageUrl", player.getHiResImageUrl()).mo5118a("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m1021a(this, obj);
    }

    /* renamed from: fl */
    public int mo3993fl() {
        return this.f925Gj;
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.f918FE;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f918FE, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.f920FK;
    }

    public String getHiResImageUrl() {
        return this.f922FV;
    }

    public Uri getIconImageUri() {
        return this.f919FJ;
    }

    public String getIconImageUrl() {
        return this.f921FU;
    }

    public long getLastPlayedWithTimestamp() {
        return this.f926Gk;
    }

    public String getPlayerId() {
        return this.f923Gh;
    }

    public long getRetrievedTimestamp() {
        return this.f924Gi;
    }

    public int getVersionCode() {
        return this.f927wj;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return m1020a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m1023b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (!mo5034dZ()) {
            C0469c.m1031a(this, dest, flags);
            return;
        }
        dest.writeString(this.f923Gh);
        dest.writeString(this.f918FE);
        dest.writeString(this.f919FJ == null ? null : this.f919FJ.toString());
        if (this.f920FK != null) {
            str = this.f920FK.toString();
        }
        dest.writeString(str);
        dest.writeLong(this.f924Gi);
    }
}
