package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0660d.C0661a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.aj */
abstract class C1371aj {

    /* renamed from: UW */
    private final Set<String> f3581UW;

    /* renamed from: UX */
    private final String f3582UX;

    public C1371aj(String str, String... strArr) {
        this.f3582UX = str;
        this.f3581UW = new HashSet(strArr.length);
        for (String add : strArr) {
            this.f3581UW.add(add);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7577a(Set<String> set) {
        return set.containsAll(this.f3581UW);
    }

    /* renamed from: iy */
    public abstract boolean mo7566iy();

    /* renamed from: jc */
    public String mo7578jc() {
        return this.f3582UX;
    }

    /* renamed from: jd */
    public Set<String> mo7579jd() {
        return this.f3581UW;
    }

    /* renamed from: u */
    public abstract C0661a mo7567u(Map<String, C0661a> map);
}
