package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.games.d */
public final class C0470d extends C0312b implements Player {

    /* renamed from: Gl */
    private final C0471a f928Gl;

    /* renamed from: com.google.android.gms.games.d$a */
    private static final class C0471a {

        /* renamed from: Gm */
        public final String f929Gm;

        /* renamed from: Gn */
        public final String f930Gn;

        /* renamed from: Go */
        public final String f931Go;

        /* renamed from: Gp */
        public final String f932Gp;

        /* renamed from: Gq */
        public final String f933Gq;

        /* renamed from: Gr */
        public final String f934Gr;

        /* renamed from: Gs */
        public final String f935Gs;

        /* renamed from: Gt */
        public final String f936Gt;

        /* renamed from: Gu */
        public final String f937Gu;

        public C0471a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f929Gm = "external_player_id";
                this.f930Gn = "profile_name";
                this.f931Go = "profile_icon_image_uri";
                this.f932Gp = "profile_icon_image_url";
                this.f933Gq = "profile_hi_res_image_uri";
                this.f934Gr = "profile_hi_res_image_url";
                this.f935Gs = "last_updated";
                this.f936Gt = "is_in_circles";
                this.f937Gu = "played_with_timestamp";
                return;
            }
            this.f929Gm = str + "external_player_id";
            this.f930Gn = str + "profile_name";
            this.f931Go = str + "profile_icon_image_uri";
            this.f932Gp = str + "profile_icon_image_url";
            this.f933Gq = str + "profile_hi_res_image_uri";
            this.f934Gr = str + "profile_hi_res_image_url";
            this.f935Gs = str + "last_updated";
            this.f936Gt = str + "is_in_circles";
            this.f937Gu = str + "played_with_timestamp";
        }
    }

    public C0470d(DataHolder dataHolder, int i) {
        this(dataHolder, i, null);
    }

    public C0470d(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        this.f928Gl = new C0471a(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.m1021a(this, obj);
    }

    /* renamed from: fl */
    public int mo3993fl() {
        return getInteger(this.f928Gl.f936Gt);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString(this.f928Gl.f930Gn);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        mo3372a(this.f928Gl.f930Gn, dataOut);
    }

    public Uri getHiResImageUri() {
        return mo3373aa(this.f928Gl.f933Gq);
    }

    public String getHiResImageUrl() {
        return getString(this.f928Gl.f934Gr);
    }

    public Uri getIconImageUri() {
        return mo3373aa(this.f928Gl.f931Go);
    }

    public String getIconImageUrl() {
        return getString(this.f928Gl.f932Gp);
    }

    public long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.f928Gl.f937Gu)) {
            return -1;
        }
        return getLong(this.f928Gl.f937Gu);
    }

    public String getPlayerId() {
        return getString(this.f928Gl.f929Gm);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.f928Gl.f935Gs);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.m1020a(this);
    }

    public String toString() {
        return PlayerEntity.m1023b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }
}
