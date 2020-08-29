package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0807fm;
import com.google.android.gms.internal.C0890fy;

public final class GameEntity extends C0890fy implements Game {
    public static final Creator<GameEntity> CREATOR = new C0460a();

    /* renamed from: FE */
    private final String f881FE;

    /* renamed from: FF */
    private final String f882FF;

    /* renamed from: FG */
    private final String f883FG;

    /* renamed from: FH */
    private final String f884FH;

    /* renamed from: FI */
    private final String f885FI;

    /* renamed from: FJ */
    private final Uri f886FJ;

    /* renamed from: FK */
    private final Uri f887FK;

    /* renamed from: FL */
    private final Uri f888FL;

    /* renamed from: FM */
    private final boolean f889FM;

    /* renamed from: FN */
    private final boolean f890FN;

    /* renamed from: FO */
    private final String f891FO;

    /* renamed from: FP */
    private final int f892FP;

    /* renamed from: FQ */
    private final int f893FQ;

    /* renamed from: FR */
    private final int f894FR;

    /* renamed from: FS */
    private final boolean f895FS;

    /* renamed from: FT */
    private final boolean f896FT;

    /* renamed from: FU */
    private final String f897FU;

    /* renamed from: FV */
    private final String f898FV;

    /* renamed from: FW */
    private final String f899FW;

    /* renamed from: FX */
    private final boolean f900FX;

    /* renamed from: wj */
    private final int f901wj;

    /* renamed from: wk */
    private final String f902wk;

    /* renamed from: com.google.android.gms.games.GameEntity$a */
    static final class C0460a extends C0466a {
        C0460a() {
        }

        /* renamed from: aj */
        public GameEntity createFromParcel(Parcel parcel) {
            if (GameEntity.m2395c(GameEntity.m1840dY()) || GameEntity.m1838ae(GameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            String readString8 = parcel.readString();
            Uri parse2 = readString8 == null ? null : Uri.parse(readString8);
            String readString9 = parcel.readString();
            return new GameEntity(2, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString9 == null ? null : Uri.parse(readString9), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false);
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted) {
        this.f901wj = versionCode;
        this.f902wk = applicationId;
        this.f881FE = displayName;
        this.f882FF = primaryCategory;
        this.f883FG = secondaryCategory;
        this.f884FH = description;
        this.f885FI = developerName;
        this.f886FJ = iconImageUri;
        this.f897FU = iconImageUrl;
        this.f887FK = hiResImageUri;
        this.f898FV = hiResImageUrl;
        this.f888FL = featuredImageUri;
        this.f899FW = featuredImageUrl;
        this.f889FM = playEnabledGame;
        this.f890FN = instanceInstalled;
        this.f891FO = instancePackageName;
        this.f892FP = gameplayAclStatus;
        this.f893FQ = achievementTotalCount;
        this.f894FR = leaderboardCount;
        this.f895FS = realTimeEnabled;
        this.f896FT = turnBasedEnabled;
        this.f900FX = muted;
    }

    public GameEntity(Game game) {
        this.f901wj = 2;
        this.f902wk = game.getApplicationId();
        this.f882FF = game.getPrimaryCategory();
        this.f883FG = game.getSecondaryCategory();
        this.f884FH = game.getDescription();
        this.f885FI = game.getDeveloperName();
        this.f881FE = game.getDisplayName();
        this.f886FJ = game.getIconImageUri();
        this.f897FU = game.getIconImageUrl();
        this.f887FK = game.getHiResImageUri();
        this.f898FV = game.getHiResImageUrl();
        this.f888FL = game.getFeaturedImageUri();
        this.f899FW = game.getFeaturedImageUrl();
        this.f889FM = game.isPlayEnabledGame();
        this.f890FN = game.isInstanceInstalled();
        this.f891FO = game.getInstancePackageName();
        this.f892FP = game.getGameplayAclStatus();
        this.f893FQ = game.getAchievementTotalCount();
        this.f894FR = game.getLeaderboardCount();
        this.f895FS = game.isRealTimeMultiplayerEnabled();
        this.f896FT = game.isTurnBasedMultiplayerEnabled();
        this.f900FX = game.isMuted();
    }

    /* renamed from: a */
    static int m1005a(Game game) {
        return C0762ep.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.isPlayEnabledGame()), Boolean.valueOf(game.isInstanceInstalled()), game.getInstancePackageName(), Integer.valueOf(game.getGameplayAclStatus()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()));
    }

    /* renamed from: a */
    static boolean m1006a(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (C0762ep.equal(game2.getApplicationId(), game.getApplicationId()) && C0762ep.equal(game2.getDisplayName(), game.getDisplayName()) && C0762ep.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && C0762ep.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && C0762ep.equal(game2.getDescription(), game.getDescription()) && C0762ep.equal(game2.getDeveloperName(), game.getDeveloperName()) && C0762ep.equal(game2.getIconImageUri(), game.getIconImageUri()) && C0762ep.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && C0762ep.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && C0762ep.equal(Boolean.valueOf(game2.isPlayEnabledGame()), Boolean.valueOf(game.isPlayEnabledGame())) && C0762ep.equal(Boolean.valueOf(game2.isInstanceInstalled()), Boolean.valueOf(game.isInstanceInstalled())) && C0762ep.equal(game2.getInstancePackageName(), game.getInstancePackageName()) && C0762ep.equal(Integer.valueOf(game2.getGameplayAclStatus()), Integer.valueOf(game.getGameplayAclStatus())) && C0762ep.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && C0762ep.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && C0762ep.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            if (C0762ep.equal(Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled() && C0762ep.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted()))))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static String m1008b(Game game) {
        return C0762ep.m1965e(game).mo5118a("ApplicationId", game.getApplicationId()).mo5118a("DisplayName", game.getDisplayName()).mo5118a("PrimaryCategory", game.getPrimaryCategory()).mo5118a("SecondaryCategory", game.getSecondaryCategory()).mo5118a("Description", game.getDescription()).mo5118a("DeveloperName", game.getDeveloperName()).mo5118a("IconImageUri", game.getIconImageUri()).mo5118a("IconImageUrl", game.getIconImageUrl()).mo5118a("HiResImageUri", game.getHiResImageUri()).mo5118a("HiResImageUrl", game.getHiResImageUrl()).mo5118a("FeaturedImageUri", game.getFeaturedImageUri()).mo5118a("FeaturedImageUrl", game.getFeaturedImageUrl()).mo5118a("PlayEnabledGame", Boolean.valueOf(game.isPlayEnabledGame())).mo5118a("InstanceInstalled", Boolean.valueOf(game.isInstanceInstalled())).mo5118a("InstancePackageName", game.getInstancePackageName()).mo5118a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).mo5118a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).mo5118a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).mo5118a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m1006a(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.f893FQ;
    }

    public String getApplicationId() {
        return this.f902wk;
    }

    public String getDescription() {
        return this.f884FH;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f884FH, dataOut);
    }

    public String getDeveloperName() {
        return this.f885FI;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f885FI, dataOut);
    }

    public String getDisplayName() {
        return this.f881FE;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        C0807fm.m2114b(this.f881FE, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.f888FL;
    }

    public String getFeaturedImageUrl() {
        return this.f899FW;
    }

    public int getGameplayAclStatus() {
        return this.f892FP;
    }

    public Uri getHiResImageUri() {
        return this.f887FK;
    }

    public String getHiResImageUrl() {
        return this.f898FV;
    }

    public Uri getIconImageUri() {
        return this.f886FJ;
    }

    public String getIconImageUrl() {
        return this.f897FU;
    }

    public String getInstancePackageName() {
        return this.f891FO;
    }

    public int getLeaderboardCount() {
        return this.f894FR;
    }

    public String getPrimaryCategory() {
        return this.f882FF;
    }

    public String getSecondaryCategory() {
        return this.f883FG;
    }

    public int getVersionCode() {
        return this.f901wj;
    }

    public int hashCode() {
        return m1005a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isInstanceInstalled() {
        return this.f890FN;
    }

    public boolean isMuted() {
        return this.f900FX;
    }

    public boolean isPlayEnabledGame() {
        return this.f889FM;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.f895FS;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.f896FT;
    }

    public String toString() {
        return m1008b((Game) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (!mo5034dZ()) {
            C0466a.m1028a(this, dest, flags);
            return;
        }
        dest.writeString(this.f902wk);
        dest.writeString(this.f881FE);
        dest.writeString(this.f882FF);
        dest.writeString(this.f883FG);
        dest.writeString(this.f884FH);
        dest.writeString(this.f885FI);
        dest.writeString(this.f886FJ == null ? null : this.f886FJ.toString());
        dest.writeString(this.f887FK == null ? null : this.f887FK.toString());
        if (this.f888FL != null) {
            str = this.f888FL.toString();
        }
        dest.writeString(str);
        dest.writeInt(this.f889FM ? 1 : 0);
        if (!this.f890FN) {
            i = 0;
        }
        dest.writeInt(i);
        dest.writeString(this.f891FO);
        dest.writeInt(this.f892FP);
        dest.writeInt(this.f893FQ);
        dest.writeInt(this.f894FR);
    }
}
