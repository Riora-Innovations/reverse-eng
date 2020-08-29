package com.google.android.gms.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import p004au.com.bytecode.opencsv.CSVWriter;

/* renamed from: com.google.android.gms.analytics.ah */
class C0190ah implements C0212n {
    private final Context mContext;

    /* renamed from: rA */
    private GoogleAnalytics f164rA;

    /* renamed from: ul */
    private final String f165ul;

    /* renamed from: um */
    private final HttpClient f166um;

    /* renamed from: un */
    private URL f167un;

    C0190ah(HttpClient httpClient, Context context) {
        this(httpClient, GoogleAnalytics.getInstance(context), context);
    }

    C0190ah(HttpClient httpClient, GoogleAnalytics googleAnalytics, Context context) {
        this.mContext = context.getApplicationContext();
        this.f165ul = mo2900a("GoogleAnalytics", "3.0", VERSION.RELEASE, C0194ak.m140a(Locale.getDefault()), Build.MODEL, Build.ID);
        this.f166um = httpClient;
        this.f164rA = googleAnalytics;
    }

    /* renamed from: a */
    private void m111a(C0182ab abVar, URL url, boolean z) {
        URL url2;
        if (!TextUtils.isEmpty(abVar.mo2871cn())) {
            if (url == null) {
                try {
                    url2 = this.f167un != null ? this.f167un : new URL("https://ssl.google-analytics.com/collect");
                } catch (MalformedURLException e) {
                    return;
                }
            } else {
                url2 = url;
            }
            HttpHost httpHost = new HttpHost(url2.getHost(), url2.getPort(), url2.getProtocol());
            try {
                HttpEntityEnclosingRequest c = m113c(abVar.mo2871cn(), url2.getPath());
                if (c != null) {
                    c.addHeader("Host", httpHost.toHostString());
                    if (C0181aa.m71cm()) {
                        m112a(c);
                    }
                    if (z) {
                        C0215q.m198p(this.mContext);
                    }
                    HttpResponse execute = this.f166um.execute(httpHost, c);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        C0181aa.m75w("Bad response: " + execute.getStatusLine().getStatusCode());
                    }
                }
            } catch (ClientProtocolException e2) {
                C0181aa.m75w("ClientProtocolException sending monitoring hit.");
            } catch (IOException e3) {
                C0181aa.m75w("Exception sending monitoring hit: " + e3.getClass().getSimpleName());
                C0181aa.m75w(e3.getMessage());
            }
        }
    }

    /* renamed from: a */
    private void m112a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Header obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append(CSVWriter.DEFAULT_LINE_END);
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append(CSVWriter.DEFAULT_LINE_END);
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append(CSVWriter.DEFAULT_LINE_END);
                    }
                }
            } catch (IOException e) {
                C0181aa.m74v("Error Writing hit to log...");
            }
        }
        C0181aa.m74v(stringBuffer.toString());
    }

    /* renamed from: c */
    private HttpEntityEnclosingRequest m113c(String str, String str2) {
        BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        if (TextUtils.isEmpty(str)) {
            C0181aa.m75w("Empty hit, discarding.");
            return null;
        }
        String str3 = str2 + "?" + str;
        if (str3.length() < 2036) {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", str3);
        } else {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", str2);
            try {
                basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str));
            } catch (UnsupportedEncodingException e) {
                C0181aa.m75w("Encoding error, discarding hit");
                return null;
            }
        }
        basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.f165ul);
        return basicHttpEntityEnclosingRequest;
    }

    /* renamed from: A */
    public void mo2898A(String str) {
        try {
            this.f167un = new URL(str);
        } catch (MalformedURLException e) {
            this.f167un = null;
        }
    }

    /* renamed from: a */
    public int mo2899a(List<C0238x> list, C0182ab abVar, boolean z) {
        int i;
        URL url;
        int i2 = 0;
        int min = Math.min(list.size(), 40);
        abVar.mo2870c("_hr", list.size());
        int i3 = 0;
        URL url2 = null;
        boolean z2 = true;
        int i4 = 0;
        while (i4 < min) {
            C0238x xVar = (C0238x) list.get(i4);
            URL a = mo2901a(xVar);
            xVar.mo2986ch().contains("_t=flow");
            if (a == null) {
                if (C0181aa.m71cm()) {
                    C0181aa.m75w("No destination: discarding hit: " + xVar.mo2986ch());
                } else {
                    C0181aa.m75w("No destination: discarding hit.");
                }
                i3++;
                URL url3 = url2;
                i = i2 + 1;
                url = url3;
            } else {
                HttpHost httpHost = new HttpHost(a.getHost(), a.getPort(), a.getProtocol());
                String path = a.getPath();
                String a2 = TextUtils.isEmpty(xVar.mo2986ch()) ? "" : C0239y.m293a(xVar, System.currentTimeMillis());
                HttpEntityEnclosingRequest c = m113c(a2, path);
                if (c == null) {
                    i3++;
                    i = i2 + 1;
                    url = a;
                } else {
                    c.addHeader("Host", httpHost.toHostString());
                    if (C0181aa.m71cm()) {
                        m112a(c);
                    }
                    if (a2.length() > 8192) {
                        C0181aa.m75w("Hit too long (> 8192 bytes)--not sent");
                        i3++;
                    } else if (this.f164rA.isDryRunEnabled()) {
                        C0181aa.m73u("Dry run enabled. Hit not actually sent.");
                    } else {
                        if (z2) {
                            try {
                                C0215q.m198p(this.mContext);
                                z2 = false;
                            } catch (ClientProtocolException e) {
                                C0181aa.m75w("ClientProtocolException sending hit; discarding hit...");
                                abVar.mo2870c("_hd", i3);
                            } catch (IOException e2) {
                                C0181aa.m75w("Exception sending hit: " + e2.getClass().getSimpleName());
                                C0181aa.m75w(e2.getMessage());
                                abVar.mo2870c("_de", 1);
                                abVar.mo2870c("_hd", i3);
                                abVar.mo2870c("_hs", i2);
                                m111a(abVar, a, z2);
                                return i2;
                            }
                        }
                        HttpResponse execute = this.f166um.execute(httpHost, c);
                        int statusCode = execute.getStatusLine().getStatusCode();
                        HttpEntity entity = execute.getEntity();
                        if (entity != null) {
                            entity.consumeContent();
                        }
                        if (statusCode != 200) {
                            C0181aa.m75w("Bad response: " + execute.getStatusLine().getStatusCode());
                        }
                    }
                    abVar.mo2870c("_td", a2.getBytes().length);
                    i = i2 + 1;
                    url = a;
                }
            }
            i4++;
            i2 = i;
            url2 = url;
        }
        abVar.mo2870c("_hd", i3);
        abVar.mo2870c("_hs", i2);
        if (z) {
            m111a(abVar, url2, z2);
        }
        return i2;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo2900a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public URL mo2901a(C0238x xVar) {
        if (this.f167un != null) {
            return this.f167un;
        }
        try {
            return new URL("http:".equals(xVar.mo2989ck()) ? "http://www.google-analytics.com/collect" : "https://ssl.google-analytics.com/collect");
        } catch (MalformedURLException e) {
            C0181aa.m72t("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
    }

    /* renamed from: bA */
    public boolean mo2902bA() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C0181aa.m74v("...no network connectivity");
        return false;
    }
}
