package com.google.android.gms.internal;

import android.os.Parcel;
import android.support.p000v4.util.TimeUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0792fb.C0793a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.achartengine.chartdemo.demo.chart.IDemoChart;

/* renamed from: com.google.android.gms.internal.im */
public final class C1083im extends C0792fb implements SafeParcelable, ItemScope {
    public static final C1084in CREATOR = new C1084in();

    /* renamed from: RL */
    private static final HashMap<String, C0793a<?, ?>> f2913RL = new HashMap<>();

    /* renamed from: FH */
    private String f2914FH;

    /* renamed from: KX */
    private double f2915KX;

    /* renamed from: KY */
    private double f2916KY;

    /* renamed from: Oc */
    private String f2917Oc;

    /* renamed from: RM */
    private final Set<Integer> f2918RM;

    /* renamed from: RN */
    private C1083im f2919RN;

    /* renamed from: RO */
    private List<String> f2920RO;

    /* renamed from: RP */
    private C1083im f2921RP;

    /* renamed from: RQ */
    private String f2922RQ;

    /* renamed from: RR */
    private String f2923RR;

    /* renamed from: RS */
    private String f2924RS;

    /* renamed from: RT */
    private List<C1083im> f2925RT;

    /* renamed from: RU */
    private int f2926RU;

    /* renamed from: RV */
    private List<C1083im> f2927RV;

    /* renamed from: RW */
    private C1083im f2928RW;

    /* renamed from: RX */
    private List<C1083im> f2929RX;

    /* renamed from: RY */
    private String f2930RY;

    /* renamed from: RZ */
    private String f2931RZ;

    /* renamed from: SA */
    private String f2932SA;

    /* renamed from: SB */
    private String f2933SB;

    /* renamed from: SC */
    private C1083im f2934SC;

    /* renamed from: SD */
    private String f2935SD;

    /* renamed from: SE */
    private String f2936SE;

    /* renamed from: SF */
    private String f2937SF;

    /* renamed from: SG */
    private String f2938SG;

    /* renamed from: Sa */
    private C1083im f2939Sa;

    /* renamed from: Sb */
    private String f2940Sb;

    /* renamed from: Sc */
    private String f2941Sc;

    /* renamed from: Sd */
    private List<C1083im> f2942Sd;

    /* renamed from: Se */
    private String f2943Se;

    /* renamed from: Sf */
    private String f2944Sf;

    /* renamed from: Sg */
    private String f2945Sg;

    /* renamed from: Sh */
    private String f2946Sh;

    /* renamed from: Si */
    private String f2947Si;

    /* renamed from: Sj */
    private String f2948Sj;

    /* renamed from: Sk */
    private String f2949Sk;

    /* renamed from: Sl */
    private String f2950Sl;

    /* renamed from: Sm */
    private C1083im f2951Sm;

    /* renamed from: Sn */
    private String f2952Sn;

    /* renamed from: So */
    private String f2953So;

    /* renamed from: Sp */
    private String f2954Sp;

    /* renamed from: Sq */
    private C1083im f2955Sq;

    /* renamed from: Sr */
    private C1083im f2956Sr;

    /* renamed from: Ss */
    private C1083im f2957Ss;

    /* renamed from: St */
    private List<C1083im> f2958St;

    /* renamed from: Su */
    private String f2959Su;

    /* renamed from: Sv */
    private String f2960Sv;

    /* renamed from: Sw */
    private String f2961Sw;

    /* renamed from: Sx */
    private String f2962Sx;

    /* renamed from: Sy */
    private C1083im f2963Sy;

    /* renamed from: Sz */
    private String f2964Sz;

    /* renamed from: lt */
    private String f2965lt;
    private String mName;

    /* renamed from: pS */
    private String f2966pS;

    /* renamed from: uS */
    private String f2967uS;

    /* renamed from: wj */
    private final int f2968wj;

    static {
        f2913RL.put("about", C0793a.m2037a("about", 2, C1083im.class));
        f2913RL.put("additionalName", C0793a.m2044k("additionalName", 3));
        f2913RL.put("address", C0793a.m2037a("address", 4, C1083im.class));
        f2913RL.put("addressCountry", C0793a.m2043j("addressCountry", 5));
        f2913RL.put("addressLocality", C0793a.m2043j("addressLocality", 6));
        f2913RL.put("addressRegion", C0793a.m2043j("addressRegion", 7));
        f2913RL.put("associated_media", C0793a.m2038b("associated_media", 8, C1083im.class));
        f2913RL.put("attendeeCount", C0793a.m2040g("attendeeCount", 9));
        f2913RL.put("attendees", C0793a.m2038b("attendees", 10, C1083im.class));
        f2913RL.put("audio", C0793a.m2037a("audio", 11, C1083im.class));
        f2913RL.put("author", C0793a.m2038b("author", 12, C1083im.class));
        f2913RL.put("bestRating", C0793a.m2043j("bestRating", 13));
        f2913RL.put("birthDate", C0793a.m2043j("birthDate", 14));
        f2913RL.put("byArtist", C0793a.m2037a("byArtist", 15, C1083im.class));
        f2913RL.put("caption", C0793a.m2043j("caption", 16));
        f2913RL.put("contentSize", C0793a.m2043j("contentSize", 17));
        f2913RL.put("contentUrl", C0793a.m2043j("contentUrl", 18));
        f2913RL.put("contributor", C0793a.m2038b("contributor", 19, C1083im.class));
        f2913RL.put("dateCreated", C0793a.m2043j("dateCreated", 20));
        f2913RL.put("dateModified", C0793a.m2043j("dateModified", 21));
        f2913RL.put("datePublished", C0793a.m2043j("datePublished", 22));
        f2913RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C0793a.m2043j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        f2913RL.put("duration", C0793a.m2043j("duration", 24));
        f2913RL.put("embedUrl", C0793a.m2043j("embedUrl", 25));
        f2913RL.put("endDate", C0793a.m2043j("endDate", 26));
        f2913RL.put("familyName", C0793a.m2043j("familyName", 27));
        f2913RL.put("gender", C0793a.m2043j("gender", 28));
        f2913RL.put("geo", C0793a.m2037a("geo", 29, C1083im.class));
        f2913RL.put("givenName", C0793a.m2043j("givenName", 30));
        f2913RL.put("height", C0793a.m2043j("height", 31));
        f2913RL.put("id", C0793a.m2043j("id", 32));
        f2913RL.put("image", C0793a.m2043j("image", 33));
        f2913RL.put("inAlbum", C0793a.m2037a("inAlbum", 34, C1083im.class));
        f2913RL.put("latitude", C0793a.m2041h("latitude", 36));
        f2913RL.put("location", C0793a.m2037a("location", 37, C1083im.class));
        f2913RL.put("longitude", C0793a.m2041h("longitude", 38));
        f2913RL.put(IDemoChart.NAME, C0793a.m2043j(IDemoChart.NAME, 39));
        f2913RL.put("partOfTVSeries", C0793a.m2037a("partOfTVSeries", 40, C1083im.class));
        f2913RL.put("performers", C0793a.m2038b("performers", 41, C1083im.class));
        f2913RL.put("playerType", C0793a.m2043j("playerType", 42));
        f2913RL.put("postOfficeBoxNumber", C0793a.m2043j("postOfficeBoxNumber", 43));
        f2913RL.put("postalCode", C0793a.m2043j("postalCode", 44));
        f2913RL.put("ratingValue", C0793a.m2043j("ratingValue", 45));
        f2913RL.put("reviewRating", C0793a.m2037a("reviewRating", 46, C1083im.class));
        f2913RL.put("startDate", C0793a.m2043j("startDate", 47));
        f2913RL.put("streetAddress", C0793a.m2043j("streetAddress", 48));
        f2913RL.put("text", C0793a.m2043j("text", 49));
        f2913RL.put("thumbnail", C0793a.m2037a("thumbnail", 50, C1083im.class));
        f2913RL.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, C0793a.m2043j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        f2913RL.put("tickerSymbol", C0793a.m2043j("tickerSymbol", 52));
        f2913RL.put("type", C0793a.m2043j("type", 53));
        f2913RL.put(PlusShare.KEY_CALL_TO_ACTION_URL, C0793a.m2043j(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        f2913RL.put("width", C0793a.m2043j("width", 55));
        f2913RL.put("worstRating", C0793a.m2043j("worstRating", 56));
    }

    public C1083im() {
        this.f2968wj = 1;
        this.f2918RM = new HashSet();
    }

    C1083im(Set<Integer> set, int i, C1083im imVar, List<String> list, C1083im imVar2, String str, String str2, String str3, List<C1083im> list2, int i2, List<C1083im> list3, C1083im imVar3, List<C1083im> list4, String str4, String str5, C1083im imVar4, String str6, String str7, String str8, List<C1083im> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, C1083im imVar5, String str18, String str19, String str20, String str21, C1083im imVar6, double d, C1083im imVar7, double d2, String str22, C1083im imVar8, List<C1083im> list6, String str23, String str24, String str25, String str26, C1083im imVar9, String str27, String str28, String str29, C1083im imVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.f2918RM = set;
        this.f2968wj = i;
        this.f2919RN = imVar;
        this.f2920RO = list;
        this.f2921RP = imVar2;
        this.f2922RQ = str;
        this.f2923RR = str2;
        this.f2924RS = str3;
        this.f2925RT = list2;
        this.f2926RU = i2;
        this.f2927RV = list3;
        this.f2928RW = imVar3;
        this.f2929RX = list4;
        this.f2930RY = str4;
        this.f2931RZ = str5;
        this.f2939Sa = imVar4;
        this.f2940Sb = str6;
        this.f2941Sc = str7;
        this.f2965lt = str8;
        this.f2942Sd = list5;
        this.f2943Se = str9;
        this.f2944Sf = str10;
        this.f2945Sg = str11;
        this.f2914FH = str12;
        this.f2946Sh = str13;
        this.f2947Si = str14;
        this.f2948Sj = str15;
        this.f2949Sk = str16;
        this.f2950Sl = str17;
        this.f2951Sm = imVar5;
        this.f2952Sn = str18;
        this.f2953So = str19;
        this.f2967uS = str20;
        this.f2954Sp = str21;
        this.f2955Sq = imVar6;
        this.f2915KX = d;
        this.f2956Sr = imVar7;
        this.f2916KY = d2;
        this.mName = str22;
        this.f2957Ss = imVar8;
        this.f2958St = list6;
        this.f2959Su = str23;
        this.f2960Sv = str24;
        this.f2961Sw = str25;
        this.f2962Sx = str26;
        this.f2963Sy = imVar9;
        this.f2964Sz = str27;
        this.f2932SA = str28;
        this.f2933SB = str29;
        this.f2934SC = imVar10;
        this.f2935SD = str30;
        this.f2936SE = str31;
        this.f2917Oc = str32;
        this.f2966pS = str33;
        this.f2937SF = str34;
        this.f2938SG = str35;
    }

    public C1083im(Set<Integer> set, C1083im imVar, List<String> list, C1083im imVar2, String str, String str2, String str3, List<C1083im> list2, int i, List<C1083im> list3, C1083im imVar3, List<C1083im> list4, String str4, String str5, C1083im imVar4, String str6, String str7, String str8, List<C1083im> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, C1083im imVar5, String str18, String str19, String str20, String str21, C1083im imVar6, double d, C1083im imVar7, double d2, String str22, C1083im imVar8, List<C1083im> list6, String str23, String str24, String str25, String str26, C1083im imVar9, String str27, String str28, String str29, C1083im imVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.f2918RM = set;
        this.f2968wj = 1;
        this.f2919RN = imVar;
        this.f2920RO = list;
        this.f2921RP = imVar2;
        this.f2922RQ = str;
        this.f2923RR = str2;
        this.f2924RS = str3;
        this.f2925RT = list2;
        this.f2926RU = i;
        this.f2927RV = list3;
        this.f2928RW = imVar3;
        this.f2929RX = list4;
        this.f2930RY = str4;
        this.f2931RZ = str5;
        this.f2939Sa = imVar4;
        this.f2940Sb = str6;
        this.f2941Sc = str7;
        this.f2965lt = str8;
        this.f2942Sd = list5;
        this.f2943Se = str9;
        this.f2944Sf = str10;
        this.f2945Sg = str11;
        this.f2914FH = str12;
        this.f2946Sh = str13;
        this.f2947Si = str14;
        this.f2948Sj = str15;
        this.f2949Sk = str16;
        this.f2950Sl = str17;
        this.f2951Sm = imVar5;
        this.f2952Sn = str18;
        this.f2953So = str19;
        this.f2967uS = str20;
        this.f2954Sp = str21;
        this.f2955Sq = imVar6;
        this.f2915KX = d;
        this.f2956Sr = imVar7;
        this.f2916KY = d2;
        this.mName = str22;
        this.f2957Ss = imVar8;
        this.f2958St = list6;
        this.f2959Su = str23;
        this.f2960Sv = str24;
        this.f2961Sw = str25;
        this.f2962Sx = str26;
        this.f2963Sy = imVar9;
        this.f2964Sz = str27;
        this.f2932SA = str28;
        this.f2933SB = str29;
        this.f2934SC = imVar10;
        this.f2935SD = str30;
        this.f2936SE = str31;
        this.f2917Oc = str32;
        this.f2966pS = str33;
        this.f2937SF = str34;
        this.f2938SG = str35;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5164a(C0793a aVar) {
        return this.f2918RM.contains(Integer.valueOf(aVar.mo5182eu()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ak */
    public Object mo5165ak(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: al */
    public boolean mo5166al(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo5169b(C0793a aVar) {
        switch (aVar.mo5182eu()) {
            case 2:
                return this.f2919RN;
            case 3:
                return this.f2920RO;
            case 4:
                return this.f2921RP;
            case 5:
                return this.f2922RQ;
            case 6:
                return this.f2923RR;
            case 7:
                return this.f2924RS;
            case 8:
                return this.f2925RT;
            case 9:
                return Integer.valueOf(this.f2926RU);
            case 10:
                return this.f2927RV;
            case 11:
                return this.f2928RW;
            case 12:
                return this.f2929RX;
            case 13:
                return this.f2930RY;
            case 14:
                return this.f2931RZ;
            case 15:
                return this.f2939Sa;
            case 16:
                return this.f2940Sb;
            case 17:
                return this.f2941Sc;
            case 18:
                return this.f2965lt;
            case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                return this.f2942Sd;
            case Parameter.RETRY_TIMES /*20*/:
                return this.f2943Se;
            case 21:
                return this.f2944Sf;
            case 22:
                return this.f2945Sg;
            case 23:
                return this.f2914FH;
            case 24:
                return this.f2946Sh;
            case 25:
                return this.f2947Si;
            case 26:
                return this.f2948Sj;
            case 27:
                return this.f2949Sk;
            case 28:
                return this.f2950Sl;
            case 29:
                return this.f2951Sm;
            case 30:
                return this.f2952Sn;
            case 31:
                return this.f2953So;
            case 32:
                return this.f2967uS;
            case 33:
                return this.f2954Sp;
            case 34:
                return this.f2955Sq;
            case 36:
                return Double.valueOf(this.f2915KX);
            case 37:
                return this.f2956Sr;
            case 38:
                return Double.valueOf(this.f2916KY);
            case 39:
                return this.mName;
            case 40:
                return this.f2957Ss;
            case 41:
                return this.f2958St;
            case 42:
                return this.f2959Su;
            case 43:
                return this.f2960Sv;
            case 44:
                return this.f2961Sw;
            case 45:
                return this.f2962Sx;
            case 46:
                return this.f2963Sy;
            case 47:
                return this.f2964Sz;
            case 48:
                return this.f2932SA;
            case 49:
                return this.f2933SB;
            case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                return this.f2934SC;
            case 51:
                return this.f2935SD;
            case 52:
                return this.f2936SE;
            case 53:
                return this.f2917Oc;
            case 54:
                return this.f2966pS;
            case 55:
                return this.f2937SF;
            case 56:
                return this.f2938SG;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
        }
    }

    public int describeContents() {
        C1084in inVar = CREATOR;
        return 0;
    }

    /* renamed from: en */
    public HashMap<String, C0793a<?, ?>> mo5170en() {
        return f2913RL;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1083im)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C1083im imVar = (C1083im) obj;
        for (C0793a aVar : f2913RL.values()) {
            if (mo5164a(aVar)) {
                if (!imVar.mo5164a(aVar)) {
                    return false;
                }
                if (!mo5169b(aVar).equals(imVar.mo5169b(aVar))) {
                    return false;
                }
            } else if (imVar.mo5164a(aVar)) {
                return false;
            }
        }
        return true;
    }

    public ItemScope getAbout() {
        return this.f2919RN;
    }

    public List<String> getAdditionalName() {
        return this.f2920RO;
    }

    public ItemScope getAddress() {
        return this.f2921RP;
    }

    public String getAddressCountry() {
        return this.f2922RQ;
    }

    public String getAddressLocality() {
        return this.f2923RR;
    }

    public String getAddressRegion() {
        return this.f2924RS;
    }

    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.f2925RT;
    }

    public int getAttendeeCount() {
        return this.f2926RU;
    }

    public List<ItemScope> getAttendees() {
        return (ArrayList) this.f2927RV;
    }

    public ItemScope getAudio() {
        return this.f2928RW;
    }

    public List<ItemScope> getAuthor() {
        return (ArrayList) this.f2929RX;
    }

    public String getBestRating() {
        return this.f2930RY;
    }

    public String getBirthDate() {
        return this.f2931RZ;
    }

    public ItemScope getByArtist() {
        return this.f2939Sa;
    }

    public String getCaption() {
        return this.f2940Sb;
    }

    public String getContentSize() {
        return this.f2941Sc;
    }

    public String getContentUrl() {
        return this.f2965lt;
    }

    public List<ItemScope> getContributor() {
        return (ArrayList) this.f2942Sd;
    }

    public String getDateCreated() {
        return this.f2943Se;
    }

    public String getDateModified() {
        return this.f2944Sf;
    }

    public String getDatePublished() {
        return this.f2945Sg;
    }

    public String getDescription() {
        return this.f2914FH;
    }

    public String getDuration() {
        return this.f2946Sh;
    }

    public String getEmbedUrl() {
        return this.f2947Si;
    }

    public String getEndDate() {
        return this.f2948Sj;
    }

    public String getFamilyName() {
        return this.f2949Sk;
    }

    public String getGender() {
        return this.f2950Sl;
    }

    public ItemScope getGeo() {
        return this.f2951Sm;
    }

    public String getGivenName() {
        return this.f2952Sn;
    }

    public String getHeight() {
        return this.f2953So;
    }

    public String getId() {
        return this.f2967uS;
    }

    public String getImage() {
        return this.f2954Sp;
    }

    public ItemScope getInAlbum() {
        return this.f2955Sq;
    }

    public double getLatitude() {
        return this.f2915KX;
    }

    public ItemScope getLocation() {
        return this.f2956Sr;
    }

    public double getLongitude() {
        return this.f2916KY;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.f2957Ss;
    }

    public List<ItemScope> getPerformers() {
        return (ArrayList) this.f2958St;
    }

    public String getPlayerType() {
        return this.f2959Su;
    }

    public String getPostOfficeBoxNumber() {
        return this.f2960Sv;
    }

    public String getPostalCode() {
        return this.f2961Sw;
    }

    public String getRatingValue() {
        return this.f2962Sx;
    }

    public ItemScope getReviewRating() {
        return this.f2963Sy;
    }

    public String getStartDate() {
        return this.f2964Sz;
    }

    public String getStreetAddress() {
        return this.f2932SA;
    }

    public String getText() {
        return this.f2933SB;
    }

    public ItemScope getThumbnail() {
        return this.f2934SC;
    }

    public String getThumbnailUrl() {
        return this.f2935SD;
    }

    public String getTickerSymbol() {
        return this.f2936SE;
    }

    public String getType() {
        return this.f2917Oc;
    }

    public String getUrl() {
        return this.f2966pS;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f2968wj;
    }

    public String getWidth() {
        return this.f2937SF;
    }

    public String getWorstRating() {
        return this.f2938SG;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hB */
    public Set<Integer> mo5951hB() {
        return this.f2918RM;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hC */
    public C1083im mo5952hC() {
        return this.f2919RN;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hD */
    public C1083im mo5953hD() {
        return this.f2921RP;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hE */
    public List<C1083im> mo5954hE() {
        return this.f2925RT;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hF */
    public List<C1083im> mo5955hF() {
        return this.f2927RV;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hG */
    public C1083im mo5956hG() {
        return this.f2928RW;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hH */
    public List<C1083im> mo5957hH() {
        return this.f2929RX;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hI */
    public C1083im mo5958hI() {
        return this.f2939Sa;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hJ */
    public List<C1083im> mo5959hJ() {
        return this.f2942Sd;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hK */
    public C1083im mo5960hK() {
        return this.f2951Sm;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hL */
    public C1083im mo5961hL() {
        return this.f2955Sq;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hM */
    public C1083im mo5962hM() {
        return this.f2956Sr;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hN */
    public C1083im mo5963hN() {
        return this.f2957Ss;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hO */
    public List<C1083im> mo5964hO() {
        return this.f2958St;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hP */
    public C1083im mo5965hP() {
        return this.f2963Sy;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hQ */
    public C1083im mo5966hQ() {
        return this.f2934SC;
    }

    /* renamed from: hR */
    public C1083im freeze() {
        return this;
    }

    public boolean hasAbout() {
        return this.f2918RM.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.f2918RM.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.f2918RM.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.f2918RM.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.f2918RM.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.f2918RM.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.f2918RM.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.f2918RM.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.f2918RM.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.f2918RM.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.f2918RM.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.f2918RM.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.f2918RM.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.f2918RM.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.f2918RM.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.f2918RM.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.f2918RM.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.f2918RM.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.f2918RM.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.f2918RM.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.f2918RM.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.f2918RM.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.f2918RM.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.f2918RM.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.f2918RM.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.f2918RM.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.f2918RM.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.f2918RM.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.f2918RM.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.f2918RM.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.f2918RM.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.f2918RM.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.f2918RM.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.f2918RM.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.f2918RM.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.f2918RM.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.f2918RM.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.f2918RM.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.f2918RM.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.f2918RM.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.f2918RM.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.f2918RM.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.f2918RM.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.f2918RM.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.f2918RM.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.f2918RM.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.f2918RM.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.f2918RM.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.f2918RM.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.f2918RM.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.f2918RM.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.f2918RM.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.f2918RM.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.f2918RM.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        Iterator it = f2913RL.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C0793a aVar = (C0793a) it.next();
            if (mo5164a(aVar)) {
                i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
            } else {
                i = i2;
            }
        }
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1084in inVar = CREATOR;
        C1084in.m3172a(this, out, flags);
    }
}
