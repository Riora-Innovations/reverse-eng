package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.analytics.C0207j;
import java.io.IOException;
import org.achartengine.chartdemo.demo.chart.IDemoChart;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.k */
abstract class C0208k<T extends C0207j> {
    Context mContext;

    /* renamed from: rb */
    C0209a<T> f194rb;

    /* renamed from: com.google.android.gms.analytics.k$a */
    public interface C0209a<U extends C0207j> {
        /* renamed from: a */
        void mo2903a(String str, int i);

        /* renamed from: a */
        void mo2904a(String str, String str2);

        /* renamed from: b */
        void mo2905b(String str, String str2);

        /* renamed from: bz */
        U mo2906bz();

        /* renamed from: c */
        void mo2907c(String str, boolean z);
    }

    public C0208k(Context context, C0209a<T> aVar) {
        this.mContext = context;
        this.f194rb = aVar;
    }

    /* renamed from: a */
    private T m183a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase();
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, IDemoChart.NAME);
                        String trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                            this.f194rb.mo2904a(attributeValue, trim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, IDemoChart.NAME);
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.f194rb.mo2905b(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, IDemoChart.NAME);
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.f194rb.mo2907c(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e) {
                                C0181aa.m72t("Error parsing bool configuration value: " + trim3);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, IDemoChart.NAME);
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.f194rb.mo2903a(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e2) {
                                C0181aa.m72t("Error parsing int configuration value: " + trim4);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            C0181aa.m72t("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            C0181aa.m72t("Error parsing tracker configuration file: " + e4);
        }
        return this.f194rb.mo2906bz();
    }

    /* renamed from: p */
    public T mo2945p(int i) {
        try {
            return m183a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            C0181aa.m75w("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
