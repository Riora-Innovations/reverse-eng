package com.google.android.gms.internal;

import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.at */
public final class C0538at implements C0536ar {
    /* renamed from: a */
    private static int m1225a(DisplayMetrics displayMetrics, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return C0659cz.m1534a(displayMetrics, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            C0662da.m1555w("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    /* renamed from: a */
    public void mo4576a(C0665dd ddVar, Map<String, String> map) {
        String str = (String) map.get("action");
        if (str == null) {
            C0662da.m1555w("Action missing from video GMSG.");
            return;
        }
        C0581bo ba = ddVar.mo4811ba();
        if (ba == null) {
            C0662da.m1555w("Could not get ad overlay for a video GMSG.");
            return;
        }
        boolean equalsIgnoreCase = "new".equalsIgnoreCase(str);
        boolean equalsIgnoreCase2 = "position".equalsIgnoreCase(str);
        if (equalsIgnoreCase || equalsIgnoreCase2) {
            DisplayMetrics displayMetrics = ddVar.getContext().getResources().getDisplayMetrics();
            int a = m1225a(displayMetrics, map, "x", 0);
            int a2 = m1225a(displayMetrics, map, "y", 0);
            int a3 = m1225a(displayMetrics, map, "w", -1);
            int a4 = m1225a(displayMetrics, map, "h", -1);
            if (!equalsIgnoreCase || ba.mo4637ap() != null) {
                ba.mo4640b(a, a2, a3, a4);
            } else {
                ba.mo4641c(a, a2, a3, a4);
            }
        } else {
            C0588bs ap = ba.mo4637ap();
            if (ap == null) {
                C0588bs.m1314a(ddVar, "no_video_view", (String) null);
            } else if ("click".equalsIgnoreCase(str)) {
                DisplayMetrics displayMetrics2 = ddVar.getContext().getResources().getDisplayMetrics();
                int a5 = m1225a(displayMetrics2, map, "x", 0);
                int a6 = m1225a(displayMetrics2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a5, (float) a6, 0);
                ap.mo4670b(obtain);
                obtain.recycle();
            } else if ("controls".equalsIgnoreCase(str)) {
                String str2 = (String) map.get("enabled");
                if (str2 == null) {
                    C0662da.m1555w("Enabled parameter missing from controls video GMSG.");
                } else {
                    ap.mo4672i(Boolean.parseBoolean(str2));
                }
            } else if ("currentTime".equalsIgnoreCase(str)) {
                String str3 = (String) map.get("time");
                if (str3 == null) {
                    C0662da.m1555w("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    ap.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                } catch (NumberFormatException e) {
                    C0662da.m1555w("Could not parse time parameter from currentTime video GMSG: " + str3);
                }
            } else if ("hide".equalsIgnoreCase(str)) {
                ap.setVisibility(4);
            } else if ("load".equalsIgnoreCase(str)) {
                ap.mo4668ay();
            } else if ("pause".equalsIgnoreCase(str)) {
                ap.pause();
            } else if ("play".equalsIgnoreCase(str)) {
                ap.play();
            } else if ("show".equalsIgnoreCase(str)) {
                ap.setVisibility(0);
            } else if ("src".equalsIgnoreCase(str)) {
                ap.mo4673o((String) map.get("src"));
            } else {
                C0662da.m1555w("Unknown video action: " + str);
            }
        }
    }
}
