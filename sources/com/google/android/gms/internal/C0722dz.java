package com.google.android.gms.internal;

import android.text.TextUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.ads.AdSize;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.dz */
public class C0722dz {

    /* renamed from: xE */
    private static final C0715du f1970xE = new C0715du("MetadataUtils");

    /* renamed from: yE */
    private static final String[] f1971yE = {"Z", "+hh", "+hhmm", "+hh:mm"};

    /* renamed from: yF */
    private static final String f1972yF = ("yyyyMMdd'T'HHmmss" + f1971yE[0]);

    /* renamed from: V */
    public static Calendar m1805V(String str) {
        if (TextUtils.isEmpty(str)) {
            f1970xE.mo4961b("Input string is empty or null", new Object[0]);
            return null;
        }
        String W = m1806W(str);
        if (TextUtils.isEmpty(W)) {
            f1970xE.mo4961b("Invalid date format", new Object[0]);
            return null;
        }
        String X = m1807X(str);
        String str2 = Parameter.DATE_FORMAT_TODAY;
        if (!TextUtils.isEmpty(X)) {
            W = W + "T" + X;
            str2 = X.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : f1972yF;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(W));
            return instance;
        } catch (ParseException e) {
            f1970xE.mo4961b("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    /* renamed from: W */
    private static String m1806W(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            f1970xE.mo4961b("Input string is empty or null", new Object[0]);
            return str2;
        }
        try {
            return str.substring(0, Parameter.DATE_FORMAT_TODAY.length());
        } catch (IndexOutOfBoundsException e) {
            f1970xE.mo4962c("Error extracting the date: %s", e.getMessage());
            return str2;
        }
    }

    /* renamed from: X */
    private static String m1807X(String str) {
        if (TextUtils.isEmpty(str)) {
            f1970xE.mo4961b("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != Parameter.DATE_FORMAT_TODAY.length()) {
            f1970xE.mo4961b("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == "HHmmss".length()) {
                return substring;
            }
            switch (substring.charAt("HHmmss".length())) {
                case '+':
                case '-':
                    if (m1808Y(substring)) {
                        return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    }
                    return null;
                case AdSize.LARGE_AD_HEIGHT /*90*/:
                    if (substring.length() == "HHmmss".length() + f1971yE[0].length()) {
                        return substring.substring(0, substring.length() - 1) + "+0000";
                    }
                    return null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            f1970xE.mo4961b("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    /* renamed from: Y */
    private static boolean m1808Y(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == f1971yE[1].length() + length2 || length == f1971yE[2].length() + length2 || length == length2 + f1971yE[3].length();
    }

    /* renamed from: a */
    public static String m1809a(Calendar calendar) {
        if (calendar == null) {
            f1970xE.mo4961b("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = f1972yF;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = Parameter.DATE_FORMAT_TODAY;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String format = simpleDateFormat.format(calendar.getTime());
        return format.endsWith("+0000") ? format.replace("+0000", f1971yE[0]) : format;
    }

    /* renamed from: a */
    public static void m1810a(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    /* renamed from: a */
    public static void m1811a(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage cT : list) {
                jSONArray.put(cT.mo3407cT());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e) {
            }
        }
    }
}
