package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
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
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import p004au.com.bytecode.opencsv.CSVWriter;

/* renamed from: com.google.android.gms.tagmanager.db */
class C1479db implements C1363ab {

    /* renamed from: Xf */
    private final Context f3804Xf;

    /* renamed from: Xw */
    private final String f3805Xw = mo7767a("GoogleTagManager", "3.02b1", VERSION.RELEASE, m4337b(Locale.getDefault()), Build.MODEL, Build.ID);

    /* renamed from: Xx */
    private final HttpClient f3806Xx;

    /* renamed from: Xy */
    private C1480a f3807Xy;

    /* renamed from: com.google.android.gms.tagmanager.db$a */
    public interface C1480a {
        /* renamed from: a */
        void mo7658a(C1377ap apVar);

        /* renamed from: b */
        void mo7659b(C1377ap apVar);

        /* renamed from: c */
        void mo7660c(C1377ap apVar);
    }

    C1479db(HttpClient httpClient, Context context, C1480a aVar) {
        this.f3804Xf = context.getApplicationContext();
        this.f3806Xx = httpClient;
        this.f3807Xy = aVar;
    }

    /* renamed from: a */
    private HttpEntityEnclosingRequest m4335a(URL url) {
        URISyntaxException e;
        HttpEntityEnclosingRequest httpEntityEnclosingRequest;
        try {
            httpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                httpEntityEnclosingRequest.addHeader("User-Agent", this.f3805Xw);
            } catch (URISyntaxException e2) {
                e = e2;
                C1401bh.m4078w("Exception sending hit: " + e.getClass().getSimpleName());
                C1401bh.m4078w(e.getMessage());
                return httpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            httpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            C1401bh.m4078w("Exception sending hit: " + e.getClass().getSimpleName());
            C1401bh.m4078w(e.getMessage());
            return httpEntityEnclosingRequest;
        }
        return httpEntityEnclosingRequest;
    }

    /* renamed from: a */
    private void m4336a(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
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
                C1401bh.m4077v("Error Writing hit to log...");
            }
        }
        C1401bh.m4077v(stringBuffer.toString());
    }

    /* renamed from: b */
    static String m4337b(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            sb.append("-").append(locale.getCountry().toLowerCase());
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo7767a(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    /* renamed from: bA */
    public boolean mo7568bA() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3804Xf.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C1401bh.m4077v("...no network connectivity");
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public URL mo7768d(C1377ap apVar) {
        try {
            return new URL(apVar.mo7584jf());
        } catch (MalformedURLException e) {
            C1401bh.m4075t("Error trying to parse the GTM url.");
            return null;
        }
    }

    /* renamed from: e */
    public void mo7569e(List<C1377ap> list) {
        boolean z;
        int min = Math.min(list.size(), 40);
        boolean z2 = true;
        int i = 0;
        while (i < min) {
            C1377ap apVar = (C1377ap) list.get(i);
            URL d = mo7768d(apVar);
            if (d == null) {
                C1401bh.m4078w("No destination: discarding hit.");
                this.f3807Xy.mo7659b(apVar);
                z = z2;
            } else {
                HttpEntityEnclosingRequest a = m4335a(d);
                if (a == null) {
                    this.f3807Xy.mo7659b(apVar);
                    z = z2;
                } else {
                    HttpHost httpHost = new HttpHost(d.getHost(), d.getPort(), d.getProtocol());
                    a.addHeader("Host", httpHost.toHostString());
                    m4336a(a);
                    if (z2) {
                        try {
                            C1407bn.m4094p(this.f3804Xf);
                            z2 = false;
                        } catch (ClientProtocolException e) {
                            C1401bh.m4078w("ClientProtocolException sending hit; discarding hit...");
                            this.f3807Xy.mo7659b(apVar);
                            z = z2;
                        } catch (IOException e2) {
                            C1401bh.m4078w("Exception sending hit: " + e2.getClass().getSimpleName());
                            C1401bh.m4078w(e2.getMessage());
                            this.f3807Xy.mo7660c(apVar);
                            z = z2;
                        }
                    }
                    HttpResponse execute = this.f3806Xx.execute(httpHost, a);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        C1401bh.m4078w("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.f3807Xy.mo7660c(apVar);
                    } else {
                        this.f3807Xy.mo7658a(apVar);
                    }
                    z = z2;
                }
            }
            i++;
            z2 = z;
        }
    }
}
