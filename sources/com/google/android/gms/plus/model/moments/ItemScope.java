package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.C1083im;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {

        /* renamed from: FH */
        private String f3469FH;

        /* renamed from: KX */
        private double f3470KX;

        /* renamed from: KY */
        private double f3471KY;

        /* renamed from: Oc */
        private String f3472Oc;

        /* renamed from: RM */
        private final Set<Integer> f3473RM = new HashSet();

        /* renamed from: RN */
        private C1083im f3474RN;

        /* renamed from: RO */
        private List<String> f3475RO;

        /* renamed from: RP */
        private C1083im f3476RP;

        /* renamed from: RQ */
        private String f3477RQ;

        /* renamed from: RR */
        private String f3478RR;

        /* renamed from: RS */
        private String f3479RS;

        /* renamed from: RT */
        private List<C1083im> f3480RT;

        /* renamed from: RU */
        private int f3481RU;

        /* renamed from: RV */
        private List<C1083im> f3482RV;

        /* renamed from: RW */
        private C1083im f3483RW;

        /* renamed from: RX */
        private List<C1083im> f3484RX;

        /* renamed from: RY */
        private String f3485RY;

        /* renamed from: RZ */
        private String f3486RZ;

        /* renamed from: SA */
        private String f3487SA;

        /* renamed from: SB */
        private String f3488SB;

        /* renamed from: SC */
        private C1083im f3489SC;

        /* renamed from: SD */
        private String f3490SD;

        /* renamed from: SE */
        private String f3491SE;

        /* renamed from: SF */
        private String f3492SF;

        /* renamed from: SG */
        private String f3493SG;

        /* renamed from: Sa */
        private C1083im f3494Sa;

        /* renamed from: Sb */
        private String f3495Sb;

        /* renamed from: Sc */
        private String f3496Sc;

        /* renamed from: Sd */
        private List<C1083im> f3497Sd;

        /* renamed from: Se */
        private String f3498Se;

        /* renamed from: Sf */
        private String f3499Sf;

        /* renamed from: Sg */
        private String f3500Sg;

        /* renamed from: Sh */
        private String f3501Sh;

        /* renamed from: Si */
        private String f3502Si;

        /* renamed from: Sj */
        private String f3503Sj;

        /* renamed from: Sk */
        private String f3504Sk;

        /* renamed from: Sl */
        private String f3505Sl;

        /* renamed from: Sm */
        private C1083im f3506Sm;

        /* renamed from: Sn */
        private String f3507Sn;

        /* renamed from: So */
        private String f3508So;

        /* renamed from: Sp */
        private String f3509Sp;

        /* renamed from: Sq */
        private C1083im f3510Sq;

        /* renamed from: Sr */
        private C1083im f3511Sr;

        /* renamed from: Ss */
        private C1083im f3512Ss;

        /* renamed from: St */
        private List<C1083im> f3513St;

        /* renamed from: Su */
        private String f3514Su;

        /* renamed from: Sv */
        private String f3515Sv;

        /* renamed from: Sw */
        private String f3516Sw;

        /* renamed from: Sx */
        private String f3517Sx;

        /* renamed from: Sy */
        private C1083im f3518Sy;

        /* renamed from: Sz */
        private String f3519Sz;

        /* renamed from: lt */
        private String f3520lt;
        private String mName;

        /* renamed from: pS */
        private String f3521pS;

        /* renamed from: uS */
        private String f3522uS;

        public ItemScope build() {
            return new C1083im(this.f3473RM, this.f3474RN, this.f3475RO, this.f3476RP, this.f3477RQ, this.f3478RR, this.f3479RS, this.f3480RT, this.f3481RU, this.f3482RV, this.f3483RW, this.f3484RX, this.f3485RY, this.f3486RZ, this.f3494Sa, this.f3495Sb, this.f3496Sc, this.f3520lt, this.f3497Sd, this.f3498Se, this.f3499Sf, this.f3500Sg, this.f3469FH, this.f3501Sh, this.f3502Si, this.f3503Sj, this.f3504Sk, this.f3505Sl, this.f3506Sm, this.f3507Sn, this.f3508So, this.f3522uS, this.f3509Sp, this.f3510Sq, this.f3470KX, this.f3511Sr, this.f3471KY, this.mName, this.f3512Ss, this.f3513St, this.f3514Su, this.f3515Sv, this.f3516Sw, this.f3517Sx, this.f3518Sy, this.f3519Sz, this.f3487SA, this.f3488SB, this.f3489SC, this.f3490SD, this.f3491SE, this.f3472Oc, this.f3521pS, this.f3492SF, this.f3493SG);
        }

        public Builder setAbout(ItemScope about) {
            this.f3474RN = (C1083im) about;
            this.f3473RM.add(Integer.valueOf(2));
            return this;
        }

        public Builder setAdditionalName(List<String> additionalName) {
            this.f3475RO = additionalName;
            this.f3473RM.add(Integer.valueOf(3));
            return this;
        }

        public Builder setAddress(ItemScope address) {
            this.f3476RP = (C1083im) address;
            this.f3473RM.add(Integer.valueOf(4));
            return this;
        }

        public Builder setAddressCountry(String addressCountry) {
            this.f3477RQ = addressCountry;
            this.f3473RM.add(Integer.valueOf(5));
            return this;
        }

        public Builder setAddressLocality(String addressLocality) {
            this.f3478RR = addressLocality;
            this.f3473RM.add(Integer.valueOf(6));
            return this;
        }

        public Builder setAddressRegion(String addressRegion) {
            this.f3479RS = addressRegion;
            this.f3473RM.add(Integer.valueOf(7));
            return this;
        }

        public Builder setAssociated_media(List<ItemScope> associated_media) {
            this.f3480RT = associated_media;
            this.f3473RM.add(Integer.valueOf(8));
            return this;
        }

        public Builder setAttendeeCount(int attendeeCount) {
            this.f3481RU = attendeeCount;
            this.f3473RM.add(Integer.valueOf(9));
            return this;
        }

        public Builder setAttendees(List<ItemScope> attendees) {
            this.f3482RV = attendees;
            this.f3473RM.add(Integer.valueOf(10));
            return this;
        }

        public Builder setAudio(ItemScope audio) {
            this.f3483RW = (C1083im) audio;
            this.f3473RM.add(Integer.valueOf(11));
            return this;
        }

        public Builder setAuthor(List<ItemScope> author) {
            this.f3484RX = author;
            this.f3473RM.add(Integer.valueOf(12));
            return this;
        }

        public Builder setBestRating(String bestRating) {
            this.f3485RY = bestRating;
            this.f3473RM.add(Integer.valueOf(13));
            return this;
        }

        public Builder setBirthDate(String birthDate) {
            this.f3486RZ = birthDate;
            this.f3473RM.add(Integer.valueOf(14));
            return this;
        }

        public Builder setByArtist(ItemScope byArtist) {
            this.f3494Sa = (C1083im) byArtist;
            this.f3473RM.add(Integer.valueOf(15));
            return this;
        }

        public Builder setCaption(String caption) {
            this.f3495Sb = caption;
            this.f3473RM.add(Integer.valueOf(16));
            return this;
        }

        public Builder setContentSize(String contentSize) {
            this.f3496Sc = contentSize;
            this.f3473RM.add(Integer.valueOf(17));
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            this.f3520lt = contentUrl;
            this.f3473RM.add(Integer.valueOf(18));
            return this;
        }

        public Builder setContributor(List<ItemScope> contributor) {
            this.f3497Sd = contributor;
            this.f3473RM.add(Integer.valueOf(19));
            return this;
        }

        public Builder setDateCreated(String dateCreated) {
            this.f3498Se = dateCreated;
            this.f3473RM.add(Integer.valueOf(20));
            return this;
        }

        public Builder setDateModified(String dateModified) {
            this.f3499Sf = dateModified;
            this.f3473RM.add(Integer.valueOf(21));
            return this;
        }

        public Builder setDatePublished(String datePublished) {
            this.f3500Sg = datePublished;
            this.f3473RM.add(Integer.valueOf(22));
            return this;
        }

        public Builder setDescription(String description) {
            this.f3469FH = description;
            this.f3473RM.add(Integer.valueOf(23));
            return this;
        }

        public Builder setDuration(String duration) {
            this.f3501Sh = duration;
            this.f3473RM.add(Integer.valueOf(24));
            return this;
        }

        public Builder setEmbedUrl(String embedUrl) {
            this.f3502Si = embedUrl;
            this.f3473RM.add(Integer.valueOf(25));
            return this;
        }

        public Builder setEndDate(String endDate) {
            this.f3503Sj = endDate;
            this.f3473RM.add(Integer.valueOf(26));
            return this;
        }

        public Builder setFamilyName(String familyName) {
            this.f3504Sk = familyName;
            this.f3473RM.add(Integer.valueOf(27));
            return this;
        }

        public Builder setGender(String gender) {
            this.f3505Sl = gender;
            this.f3473RM.add(Integer.valueOf(28));
            return this;
        }

        public Builder setGeo(ItemScope geo) {
            this.f3506Sm = (C1083im) geo;
            this.f3473RM.add(Integer.valueOf(29));
            return this;
        }

        public Builder setGivenName(String givenName) {
            this.f3507Sn = givenName;
            this.f3473RM.add(Integer.valueOf(30));
            return this;
        }

        public Builder setHeight(String height) {
            this.f3508So = height;
            this.f3473RM.add(Integer.valueOf(31));
            return this;
        }

        public Builder setId(String id) {
            this.f3522uS = id;
            this.f3473RM.add(Integer.valueOf(32));
            return this;
        }

        public Builder setImage(String image) {
            this.f3509Sp = image;
            this.f3473RM.add(Integer.valueOf(33));
            return this;
        }

        public Builder setInAlbum(ItemScope inAlbum) {
            this.f3510Sq = (C1083im) inAlbum;
            this.f3473RM.add(Integer.valueOf(34));
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.f3470KX = latitude;
            this.f3473RM.add(Integer.valueOf(36));
            return this;
        }

        public Builder setLocation(ItemScope location) {
            this.f3511Sr = (C1083im) location;
            this.f3473RM.add(Integer.valueOf(37));
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.f3471KY = longitude;
            this.f3473RM.add(Integer.valueOf(38));
            return this;
        }

        public Builder setName(String name) {
            this.mName = name;
            this.f3473RM.add(Integer.valueOf(39));
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope partOfTVSeries) {
            this.f3512Ss = (C1083im) partOfTVSeries;
            this.f3473RM.add(Integer.valueOf(40));
            return this;
        }

        public Builder setPerformers(List<ItemScope> performers) {
            this.f3513St = performers;
            this.f3473RM.add(Integer.valueOf(41));
            return this;
        }

        public Builder setPlayerType(String playerType) {
            this.f3514Su = playerType;
            this.f3473RM.add(Integer.valueOf(42));
            return this;
        }

        public Builder setPostOfficeBoxNumber(String postOfficeBoxNumber) {
            this.f3515Sv = postOfficeBoxNumber;
            this.f3473RM.add(Integer.valueOf(43));
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.f3516Sw = postalCode;
            this.f3473RM.add(Integer.valueOf(44));
            return this;
        }

        public Builder setRatingValue(String ratingValue) {
            this.f3517Sx = ratingValue;
            this.f3473RM.add(Integer.valueOf(45));
            return this;
        }

        public Builder setReviewRating(ItemScope reviewRating) {
            this.f3518Sy = (C1083im) reviewRating;
            this.f3473RM.add(Integer.valueOf(46));
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.f3519Sz = startDate;
            this.f3473RM.add(Integer.valueOf(47));
            return this;
        }

        public Builder setStreetAddress(String streetAddress) {
            this.f3487SA = streetAddress;
            this.f3473RM.add(Integer.valueOf(48));
            return this;
        }

        public Builder setText(String text) {
            this.f3488SB = text;
            this.f3473RM.add(Integer.valueOf(49));
            return this;
        }

        public Builder setThumbnail(ItemScope thumbnail) {
            this.f3489SC = (C1083im) thumbnail;
            this.f3473RM.add(Integer.valueOf(50));
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.f3490SD = thumbnailUrl;
            this.f3473RM.add(Integer.valueOf(51));
            return this;
        }

        public Builder setTickerSymbol(String tickerSymbol) {
            this.f3491SE = tickerSymbol;
            this.f3473RM.add(Integer.valueOf(52));
            return this;
        }

        public Builder setType(String type) {
            this.f3472Oc = type;
            this.f3473RM.add(Integer.valueOf(53));
            return this;
        }

        public Builder setUrl(String url) {
            this.f3521pS = url;
            this.f3473RM.add(Integer.valueOf(54));
            return this;
        }

        public Builder setWidth(String width) {
            this.f3492SF = width;
            this.f3473RM.add(Integer.valueOf(55));
            return this;
        }

        public Builder setWorstRating(String worstRating) {
            this.f3493SG = worstRating;
            this.f3473RM.add(Integer.valueOf(56));
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
