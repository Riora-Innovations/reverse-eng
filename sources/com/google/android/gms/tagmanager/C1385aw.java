package com.google.android.gms.tagmanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.tagmanager.aw */
class C1385aw implements C1405bl {

    /* renamed from: Vj */
    private HttpURLConnection f3603Vj;

    C1385aw() {
    }

    /* renamed from: a */
    private InputStream m4041a(HttpURLConnection httpURLConnection) throws IOException {
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            return httpURLConnection.getInputStream();
        }
        String str = "Bad response: " + responseCode;
        if (responseCode == 404) {
            throw new FileNotFoundException(str);
        }
        throw new IOException(str);
    }

    /* renamed from: b */
    private void m4042b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* renamed from: bo */
    public InputStream mo7594bo(String str) throws IOException {
        this.f3603Vj = mo7597bp(str);
        return m4041a(this.f3603Vj);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: bp */
    public HttpURLConnection mo7597bp(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        return httpURLConnection;
    }

    public void close() {
        m4042b(this.f3603Vj);
    }
}
