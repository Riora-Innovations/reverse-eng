package com.google.android.gms.internal;

import java.util.Map;
import org.achartengine.chartdemo.demo.chart.IDemoChart;

/* renamed from: com.google.android.gms.internal.ao */
public final class C0526ao implements C0536ar {

    /* renamed from: lV */
    private final C0527ap f1250lV;

    public C0526ao(C0527ap apVar) {
        this.f1250lV = apVar;
    }

    /* renamed from: a */
    public void mo4576a(C0665dd ddVar, Map<String, String> map) {
        String str = (String) map.get(IDemoChart.NAME);
        if (str == null) {
            C0662da.m1555w("App event with no name parameter.");
        } else {
            this.f1250lV.onAppEvent(str, (String) map.get("info"));
        }
    }
}
