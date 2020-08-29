package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.text.TextUtils;
import com.futaba.androidmadlink.config.Parameter;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.cj */
public final class C0635cj {

    /* renamed from: ow */
    private static final SimpleDateFormat f1682ow = new SimpleDateFormat(Parameter.DATE_FORMAT_TODAY);

    /* renamed from: a */
    public static C0628cf m1440a(Context context, C0625cd cdVar, String str) {
        C0628cf cfVar;
        List<String> list;
        List<String> list2;
        List<String> list3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            String optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString5 = jSONObject.optString("orientation", null);
            int i = -1;
            if ("portrait".equals(optString5)) {
                i = C0653cv.m1513aU();
            } else if ("landscape".equals(optString5)) {
                i = C0653cv.m1512aT();
            }
            if (!TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString)) {
                    C0662da.m1555w("Could not parse the mediation config: Missing required ad_base_url field");
                    return new C0628cf(0);
                }
                cfVar = null;
            } else if (!TextUtils.isEmpty(optString2)) {
                C0628cf a = C0633ci.m1436a(context, cdVar.f1646kN.f1798pU, optString2);
                optString = a.f1666nw;
                optString4 = a.f1667oi;
                j = a.f1673oo;
                cfVar = a;
            } else {
                C0662da.m1555w("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                return new C0628cf(0);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List<String> list4 = cfVar == null ? null : cfVar.f1663mt;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList<>();
                }
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    list4.add(optJSONArray.getString(i2));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            List<String> list5 = cfVar == null ? null : cfVar.f1664mu;
            if (optJSONArray2 != null) {
                if (list5 == null) {
                    list5 = new LinkedList<>();
                }
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    list5.add(optJSONArray2.getString(i3));
                }
                list2 = list5;
            } else {
                list2 = list5;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            List<String> list6 = cfVar == null ? null : cfVar.f1671om;
            if (optJSONArray3 != null) {
                if (list6 == null) {
                    list6 = new LinkedList<>();
                }
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    list6.add(optJSONArray3.getString(i4));
                }
                list3 = list6;
            } else {
                list3 = list6;
            }
            if (cfVar != null) {
                if (cfVar.orientation != -1) {
                    i = cfVar.orientation;
                }
                if (cfVar.f1668oj > 0) {
                    j2 = cfVar.f1668oj;
                }
            }
            return new C0628cf(optString, optString4, list, list2, j2, false, -1, list3, -1, i, optString3, j);
        } catch (JSONException e) {
            C0662da.m1555w("Could not parse the mediation config: " + e.getMessage());
            return new C0628cf(0);
        }
    }

    /* renamed from: a */
    public static String m1441a(C0625cd cdVar, C0640cm cmVar, Location location) {
        try {
            HashMap hashMap = new HashMap();
            if (cdVar.f1648ob != null) {
                hashMap.put("ad_pos", cdVar.f1648ob);
            }
            m1445a(hashMap, cdVar.f1649oc);
            hashMap.put("format", cdVar.f1647kQ.f1194ln);
            if (cdVar.f1647kQ.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (cdVar.f1647kQ.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (cdVar.f1647kQ.f1196lp != null) {
                StringBuilder sb = new StringBuilder();
                C0504ab[] abVarArr = cdVar.f1647kQ.f1196lp;
                int length = abVarArr.length;
                for (int i = 0; i < length; i++) {
                    C0504ab abVar = abVarArr[i];
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(abVar.width == -1 ? (int) (((float) abVar.widthPixels) / cmVar.f1718pc) : abVar.width);
                    sb.append("x");
                    sb.append(abVar.height == -2 ? (int) (((float) abVar.heightPixels) / cmVar.f1718pc) : abVar.height);
                }
                hashMap.put("sz", sb);
            }
            hashMap.put("slotname", cdVar.adUnitId);
            hashMap.put("pn", cdVar.applicationInfo.packageName);
            if (cdVar.f1650od != null) {
                hashMap.put("vc", Integer.valueOf(cdVar.f1650od.versionCode));
            }
            hashMap.put("ms", cdVar.f1651oe);
            hashMap.put("seq_num", cdVar.f1652of);
            hashMap.put("session_id", cdVar.f1653og);
            hashMap.put("js", cdVar.f1646kN.f1798pU);
            m1444a(hashMap, cmVar);
            if (cdVar.f1649oc.versionCode >= 2 && cdVar.f1649oc.f3165ll != null) {
                m1442a(hashMap, cdVar.f1649oc.f3165ll);
            }
            if (cdVar.versionCode >= 2) {
                hashMap.put("quality_signals", cdVar.f1654oh);
            }
            if (C0662da.m1550n(2)) {
                C0662da.m1554v("Ad Request JSON: " + C0653cv.m1521m((Map<String, ?>) hashMap).toString(2));
            }
            return C0653cv.m1521m((Map<String, ?>) hashMap).toString();
        } catch (JSONException e) {
            C0662da.m1555w("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static void m1442a(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    /* renamed from: a */
    private static void m1443a(HashMap<String, Object> hashMap, C0524am amVar) {
        String str;
        String str2 = null;
        if (Color.alpha(amVar.f1237lI) != 0) {
            hashMap.put("acolor", m1447m(amVar.f1237lI));
        }
        if (Color.alpha(amVar.backgroundColor) != 0) {
            hashMap.put("bgcolor", m1447m(amVar.backgroundColor));
        }
        if (!(Color.alpha(amVar.f1238lJ) == 0 || Color.alpha(amVar.f1239lK) == 0)) {
            hashMap.put("gradientto", m1447m(amVar.f1238lJ));
            hashMap.put("gradientfrom", m1447m(amVar.f1239lK));
        }
        if (Color.alpha(amVar.f1240lL) != 0) {
            hashMap.put("bcolor", m1447m(amVar.f1240lL));
        }
        hashMap.put("bthick", Integer.toString(amVar.f1241lM));
        switch (amVar.f1242lN) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            hashMap.put("btype", str);
        }
        switch (amVar.f1243lO) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            hashMap.put("callbuttoncolor", str2);
        }
        if (amVar.f1244lP != null) {
            hashMap.put("channel", amVar.f1244lP);
        }
        if (Color.alpha(amVar.f1245lQ) != 0) {
            hashMap.put("dcolor", m1447m(amVar.f1245lQ));
        }
        if (amVar.f1246lR != null) {
            hashMap.put("font", amVar.f1246lR);
        }
        if (Color.alpha(amVar.f1247lS) != 0) {
            hashMap.put("hcolor", m1447m(amVar.f1247lS));
        }
        hashMap.put("headersize", Integer.toString(amVar.f1248lT));
        if (amVar.f1249lU != null) {
            hashMap.put("q", amVar.f1249lU);
        }
    }

    /* renamed from: a */
    private static void m1444a(HashMap<String, Object> hashMap, C0640cm cmVar) {
        hashMap.put("am", Integer.valueOf(cmVar.f1702oM));
        hashMap.put("cog", m1446j(cmVar.f1703oN));
        hashMap.put("coh", m1446j(cmVar.f1704oO));
        if (!TextUtils.isEmpty(cmVar.f1705oP)) {
            hashMap.put("carrier", cmVar.f1705oP);
        }
        hashMap.put("gl", cmVar.f1706oQ);
        if (cmVar.f1707oR) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", m1446j(cmVar.f1708oS));
        hashMap.put("sp", m1446j(cmVar.f1709oT));
        hashMap.put("hl", cmVar.f1710oU);
        if (!TextUtils.isEmpty(cmVar.f1711oV)) {
            hashMap.put("mv", cmVar.f1711oV);
        }
        hashMap.put("muv", Integer.valueOf(cmVar.f1712oW));
        if (cmVar.f1713oX != -2) {
            hashMap.put("cnt", Integer.valueOf(cmVar.f1713oX));
        }
        hashMap.put("gnt", Integer.valueOf(cmVar.f1714oY));
        hashMap.put("pt", Integer.valueOf(cmVar.f1715oZ));
        hashMap.put("rm", Integer.valueOf(cmVar.f1716pa));
        hashMap.put("riv", Integer.valueOf(cmVar.f1717pb));
        hashMap.put("u_sd", Float.valueOf(cmVar.f1718pc));
        hashMap.put("sh", Integer.valueOf(cmVar.f1720pe));
        hashMap.put(Parameter.CMD_WRITE_SETTING, Integer.valueOf(cmVar.f1719pd));
    }

    /* renamed from: a */
    private static void m1445a(HashMap<String, Object> hashMap, C1173z zVar) {
        String aR = C0647cs.m1494aR();
        if (aR != null) {
            hashMap.put("abf", aR);
        }
        if (zVar.f3158le != -1) {
            hashMap.put("cust_age", f1682ow.format(new Date(zVar.f3158le)));
        }
        if (zVar.extras != null) {
            hashMap.put("extras", zVar.extras);
        }
        if (zVar.f3159lf != -1) {
            hashMap.put("cust_gender", Integer.valueOf(zVar.f3159lf));
        }
        if (zVar.f3160lg != null) {
            hashMap.put("kw", zVar.f3160lg);
        }
        if (zVar.tagForChildDirectedTreatment != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(zVar.tagForChildDirectedTreatment));
        }
        if (zVar.f3161lh) {
            hashMap.put("adtest", "on");
        }
        if (zVar.versionCode >= 2) {
            if (zVar.f3162li) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(zVar.f3163lj)) {
                hashMap.put("ppid", zVar.f3163lj);
            }
            if (zVar.f3164lk != null) {
                m1443a(hashMap, zVar.f3164lk);
            }
        }
        if (zVar.versionCode >= 3 && zVar.f3166lm != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, zVar.f3166lm);
        }
    }

    /* renamed from: j */
    private static Integer m1446j(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    /* renamed from: m */
    private static String m1447m(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
