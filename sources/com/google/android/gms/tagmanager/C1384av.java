package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* renamed from: com.google.android.gms.tagmanager.av */
class C1384av implements C1405bl {

    /* renamed from: Vi */
    private HttpClient f3602Vi;

    C1384av() {
    }

    /* renamed from: a */
    private InputStream m4037a(HttpClient httpClient, HttpResponse httpResponse) throws IOException {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            C1401bh.m4077v("Success response");
            return httpResponse.getEntity().getContent();
        }
        String str = "Bad response: " + statusCode;
        if (statusCode == 404) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    /* renamed from: a */
    private void m4038a(HttpClient httpClient) {
        if (httpClient != null && httpClient.getConnectionManager() != null) {
            httpClient.getConnectionManager().shutdown();
        }
    }

    /* renamed from: bo */
    public InputStream mo7594bo(String str) throws IOException {
        this.f3602Vi = mo7596jg();
        return m4037a(this.f3602Vi, this.f3602Vi.execute(new HttpGet(str)));
    }

    public void close() {
        m4038a(this.f3602Vi);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: jg */
    public HttpClient mo7596jg() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        return new DefaultHttpClient(basicHttpParams);
    }
}
