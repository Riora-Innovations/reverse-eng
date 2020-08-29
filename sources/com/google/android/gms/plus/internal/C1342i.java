package com.google.android.gms.plus.internal;

import android.content.Context;
import com.google.android.gms.common.Scopes;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.google.android.gms.plus.internal.i */
public class C1342i {

    /* renamed from: Ro */
    private String[] f3461Ro;

    /* renamed from: Rp */
    private String f3462Rp;

    /* renamed from: Rq */
    private String f3463Rq;

    /* renamed from: Rr */
    private String f3464Rr;

    /* renamed from: Rt */
    private PlusCommonExtras f3465Rt;

    /* renamed from: Ru */
    private final ArrayList<String> f3466Ru = new ArrayList<>();

    /* renamed from: Rv */
    private String[] f3467Rv;

    /* renamed from: vi */
    private String f3468vi;

    public C1342i(Context context) {
        this.f3463Rq = context.getPackageName();
        this.f3462Rp = context.getPackageName();
        this.f3465Rt = new PlusCommonExtras();
        this.f3466Ru.add(Scopes.PLUS_LOGIN);
    }

    /* renamed from: aS */
    public C1342i mo7433aS(String str) {
        this.f3468vi = str;
        return this;
    }

    /* renamed from: e */
    public C1342i mo7434e(String... strArr) {
        this.f3466Ru.clear();
        this.f3466Ru.addAll(Arrays.asList(strArr));
        return this;
    }

    /* renamed from: f */
    public C1342i mo7435f(String... strArr) {
        this.f3467Rv = strArr;
        return this;
    }

    /* renamed from: hA */
    public C1341h mo7436hA() {
        if (this.f3468vi == null) {
            this.f3468vi = "<<default account>>";
        }
        return new C1341h(this.f3468vi, (String[]) this.f3466Ru.toArray(new String[this.f3466Ru.size()]), this.f3467Rv, this.f3461Ro, this.f3462Rp, this.f3463Rq, this.f3464Rr, this.f3465Rt);
    }

    /* renamed from: hz */
    public C1342i mo7437hz() {
        this.f3466Ru.clear();
        return this;
    }
}
