package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.aq */
public final class C0528aq {

    /* renamed from: lW */
    public static final C0536ar f1251lW = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (str == null) {
                C0662da.m1555w("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            HashMap hashMap = new HashMap();
            PackageManager packageManager = ddVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            ddVar.mo4808a("openableURLs", (Map<String, ?>) hashMap);
        }
    };

    /* renamed from: lX */
    public static final C0536ar f1252lX = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            Uri uri;
            String str = (String) map.get("u");
            if (str == null) {
                C0662da.m1555w("URL missing from click GMSG.");
                return;
            }
            Uri parse = Uri.parse(str);
            try {
                C1152l bc = ddVar.mo4813bc();
                if (bc != null && bc.mo6432a(parse)) {
                    uri = bc.mo6430a(parse, ddVar.getContext());
                    new C0658cy(ddVar.getContext(), ddVar.mo4814bd().f1798pU, uri.toString()).start();
                }
            } catch (C1153m e) {
                C0662da.m1555w("Unable to append parameter to URL: " + str);
            }
            uri = parse;
            new C0658cy(ddVar.getContext(), ddVar.mo4814bd().f1798pU, uri.toString()).start();
        }
    };

    /* renamed from: lY */
    public static final C0536ar f1253lY = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            C0581bo ba = ddVar.mo4811ba();
            if (ba == null) {
                C0662da.m1555w("A GMSG tried to close something that wasn't an overlay.");
            } else {
                ba.close();
            }
        }
    };

    /* renamed from: lZ */
    public static final C0536ar f1254lZ = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            C0581bo ba = ddVar.mo4811ba();
            if (ba == null) {
                C0662da.m1555w("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                ba.mo4644g("1".equals(map.get("custom_close")));
            }
        }
    };

    /* renamed from: ma */
    public static final C0536ar f1255ma = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                C0662da.m1555w("URL missing from httpTrack GMSG.");
            } else {
                new C0658cy(ddVar.getContext(), ddVar.mo4814bd().f1798pU, str).start();
            }
        }
    };

    /* renamed from: mb */
    public static final C0536ar f1256mb = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            C0662da.m1553u("Received log message: " + ((String) map.get("string")));
        }
    };

    /* renamed from: mc */
    public static final C0536ar f1257mc = new C0537as();

    /* renamed from: md */
    public static final C0536ar f1258md = new C0536ar() {
        /* renamed from: a */
        public void mo4576a(C0665dd ddVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C1152l bc = ddVar.mo4813bc();
                if (bc != null) {
                    bc.mo6433y().mo5633a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                C0662da.m1555w("Could not parse touch parameters from gmsg.");
            }
        }
    };

    /* renamed from: me */
    public static final C0536ar f1259me = new C0538at();
}
