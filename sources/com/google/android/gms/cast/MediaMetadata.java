package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.C0722dz;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata {
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;

    /* renamed from: wR */
    private static final String[] f420wR = {null, "String", "int", "double", "ISO-8601 date String"};

    /* renamed from: wS */
    private static final C0274a f421wS = new C0274a().mo3152a(KEY_CREATION_DATE, "creationDateTime", 4).mo3152a(KEY_RELEASE_DATE, "releaseDate", 4).mo3152a(KEY_BROADCAST_DATE, "originalAirdate", 4).mo3152a(KEY_TITLE, "title", 1).mo3152a(KEY_SUBTITLE, "subtitle", 1).mo3152a(KEY_ARTIST, "artist", 1).mo3152a(KEY_ALBUM_ARTIST, "albumArtist", 1).mo3152a(KEY_ALBUM_TITLE, "albumName", 1).mo3152a(KEY_COMPOSER, "composer", 1).mo3152a(KEY_DISC_NUMBER, "discNumber", 2).mo3152a(KEY_TRACK_NUMBER, "trackNumber", 2).mo3152a(KEY_SEASON_NUMBER, "season", 2).mo3152a(KEY_EPISODE_NUMBER, "episode", 2).mo3152a(KEY_SERIES_TITLE, "seriesTitle", 1).mo3152a(KEY_STUDIO, "studio", 1).mo3152a(KEY_WIDTH, "width", 2).mo3152a(KEY_HEIGHT, "height", 2).mo3152a(KEY_LOCATION_NAME, "location", 1).mo3152a(KEY_LOCATION_LATITUDE, "latitude", 3).mo3152a(KEY_LOCATION_LONGITUDE, "longitude", 3);

    /* renamed from: wT */
    private final Bundle f422wT;

    /* renamed from: wU */
    private int f423wU;

    /* renamed from: wl */
    private final List<WebImage> f424wl;

    /* renamed from: com.google.android.gms.cast.MediaMetadata$a */
    private static class C0274a {

        /* renamed from: wV */
        private final Map<String, String> f425wV = new HashMap();

        /* renamed from: wW */
        private final Map<String, String> f426wW = new HashMap();

        /* renamed from: wX */
        private final Map<String, Integer> f427wX = new HashMap();

        /* renamed from: M */
        public String mo3149M(String str) {
            return (String) this.f425wV.get(str);
        }

        /* renamed from: N */
        public String mo3150N(String str) {
            return (String) this.f426wW.get(str);
        }

        /* renamed from: O */
        public int mo3151O(String str) {
            Integer num = (Integer) this.f427wX.get(str);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        /* renamed from: a */
        public C0274a mo3152a(String str, String str2, int i) {
            this.f425wV.put(str, str2);
            this.f426wW.put(str2, str);
            this.f427wX.put(str, Integer.valueOf(i));
            return this;
        }
    }

    public MediaMetadata() {
        this(0);
    }

    public MediaMetadata(int mediaType) {
        this.f424wl = new ArrayList();
        this.f422wT = new Bundle();
        this.f423wU = mediaType;
    }

    /* renamed from: a */
    private void m368a(JSONObject jSONObject, String... strArr) {
        try {
            for (String str : strArr) {
                if (this.f422wT.containsKey(str)) {
                    switch (f421wS.mo3151O(str)) {
                        case 1:
                        case 4:
                            jSONObject.put(f421wS.mo3149M(str), this.f422wT.getString(str));
                            break;
                        case 2:
                            jSONObject.put(f421wS.mo3149M(str), this.f422wT.getInt(str));
                            break;
                        case 3:
                            jSONObject.put(f421wS.mo3149M(str), this.f422wT.getDouble(str));
                            break;
                    }
                }
            }
            for (String str2 : this.f422wT.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = this.f422wT.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    private boolean m369a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !m369a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    private void m370b(JSONObject jSONObject, String... strArr) {
        HashSet hashSet = new HashSet(Arrays.asList(strArr));
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (!"metadataType".equals(str)) {
                    String N = f421wS.mo3150N(str);
                    if (N == null) {
                        Object obj = jSONObject.get(str);
                        if (obj instanceof String) {
                            this.f422wT.putString(str, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.f422wT.putInt(str, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.f422wT.putDouble(str, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(N)) {
                        try {
                            Object obj2 = jSONObject.get(str);
                            if (obj2 != null) {
                                switch (f421wS.mo3151O(N)) {
                                    case 1:
                                        if (!(obj2 instanceof String)) {
                                            break;
                                        } else {
                                            this.f422wT.putString(N, (String) obj2);
                                            break;
                                        }
                                    case 2:
                                        if (!(obj2 instanceof Integer)) {
                                            break;
                                        } else {
                                            this.f422wT.putInt(N, ((Integer) obj2).intValue());
                                            break;
                                        }
                                    case 3:
                                        if (!(obj2 instanceof Double)) {
                                            break;
                                        } else {
                                            this.f422wT.putDouble(N, ((Double) obj2).doubleValue());
                                            break;
                                        }
                                    case 4:
                                        if ((obj2 instanceof String) && C0722dz.m1805V((String) obj2) != null) {
                                            this.f422wT.putString(N, (String) obj2);
                                            break;
                                        }
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        } catch (JSONException e2) {
        }
    }

    /* renamed from: d */
    private void m371d(String str, int i) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int O = f421wS.mo3151O(str);
        if (O != i && O != 0) {
            throw new IllegalArgumentException("Value for " + str + " must be a " + f420wR[i]);
        }
    }

    public void addImage(WebImage image) {
        this.f424wl.add(image);
    }

    /* renamed from: b */
    public void mo3129b(JSONObject jSONObject) {
        clear();
        this.f423wU = 0;
        try {
            this.f423wU = jSONObject.getInt("metadataType");
        } catch (JSONException e) {
        }
        C0722dz.m1810a(this.f424wl, jSONObject);
        switch (this.f423wU) {
            case 0:
                m370b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 1:
                m370b(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                return;
            case 2:
                m370b(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                return;
            case 3:
                m370b(jSONObject, KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                return;
            case 4:
                m370b(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                return;
            default:
                m370b(jSONObject, new String[0]);
                return;
        }
    }

    /* renamed from: cT */
    public JSONObject mo3130cT() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.f423wU);
        } catch (JSONException e) {
        }
        C0722dz.m1811a(jSONObject, this.f424wl);
        switch (this.f423wU) {
            case 0:
                m368a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 1:
                m368a(jSONObject, KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE);
                break;
            case 2:
                m368a(jSONObject, KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE);
                break;
            case 3:
                m368a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_ALBUM_TITLE, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE);
                break;
            case 4:
                m368a(jSONObject, KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE);
                break;
            default:
                m368a(jSONObject, new String[0]);
                break;
        }
        return jSONObject;
    }

    public void clear() {
        this.f422wT.clear();
        this.f424wl.clear();
    }

    public void clearImages() {
        this.f424wl.clear();
    }

    public boolean containsKey(String key) {
        return this.f422wT.containsKey(key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) other;
        return m369a(this.f422wT, mediaMetadata.f422wT) && this.f424wl.equals(mediaMetadata.f424wl);
    }

    public Calendar getDate(String key) {
        m371d(key, 4);
        String string = this.f422wT.getString(key);
        if (string != null) {
            return C0722dz.m1805V(string);
        }
        return null;
    }

    public String getDateAsString(String key) {
        m371d(key, 4);
        return this.f422wT.getString(key);
    }

    public double getDouble(String key) {
        m371d(key, 3);
        return this.f422wT.getDouble(key);
    }

    public List<WebImage> getImages() {
        return this.f424wl;
    }

    public int getInt(String key) {
        m371d(key, 2);
        return this.f422wT.getInt(key);
    }

    public int getMediaType() {
        return this.f423wU;
    }

    public String getString(String key) {
        m371d(key, 1);
        return this.f422wT.getString(key);
    }

    public boolean hasImages() {
        return this.f424wl != null && !this.f424wl.isEmpty();
    }

    public int hashCode() {
        int i = 17;
        Iterator it = this.f422wT.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return (i2 * 31) + this.f424wl.hashCode();
            }
            int i3 = i2 * 31;
            i = this.f422wT.get((String) it.next()).hashCode() + i3;
        }
    }

    public Set<String> keySet() {
        return this.f422wT.keySet();
    }

    public void putDate(String key, Calendar value) {
        m371d(key, 4);
        this.f422wT.putString(key, C0722dz.m1809a(value));
    }

    public void putDouble(String key, double value) {
        m371d(key, 3);
        this.f422wT.putDouble(key, value);
    }

    public void putInt(String key, int value) {
        m371d(key, 2);
        this.f422wT.putInt(key, value);
    }

    public void putString(String key, String value) {
        m371d(key, 1);
        this.f422wT.putString(key, value);
    }
}
