package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0792fb.C0793a;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.io */
public final class C1085io extends C0792fb implements SafeParcelable, Moment {
    public static final C1086ip CREATOR = new C1086ip();

    /* renamed from: RL */
    private static final HashMap<String, C0793a<?, ?>> f2969RL = new HashMap<>();

    /* renamed from: Oc */
    private String f2970Oc;

    /* renamed from: RM */
    private final Set<Integer> f2971RM;

    /* renamed from: SH */
    private C1083im f2972SH;

    /* renamed from: SI */
    private C1083im f2973SI;

    /* renamed from: Sz */
    private String f2974Sz;

    /* renamed from: uS */
    private String f2975uS;

    /* renamed from: wj */
    private final int f2976wj;

    static {
        f2969RL.put("id", C0793a.m2043j("id", 2));
        f2969RL.put("result", C0793a.m2037a("result", 4, C1083im.class));
        f2969RL.put("startDate", C0793a.m2043j("startDate", 5));
        f2969RL.put("target", C0793a.m2037a("target", 6, C1083im.class));
        f2969RL.put("type", C0793a.m2043j("type", 7));
    }

    public C1085io() {
        this.f2976wj = 1;
        this.f2971RM = new HashSet();
    }

    C1085io(Set<Integer> set, int i, String str, C1083im imVar, String str2, C1083im imVar2, String str3) {
        this.f2971RM = set;
        this.f2976wj = i;
        this.f2975uS = str;
        this.f2972SH = imVar;
        this.f2974Sz = str2;
        this.f2973SI = imVar2;
        this.f2970Oc = str3;
    }

    public C1085io(Set<Integer> set, String str, C1083im imVar, String str2, C1083im imVar2, String str3) {
        this.f2971RM = set;
        this.f2976wj = 1;
        this.f2975uS = str;
        this.f2972SH = imVar;
        this.f2974Sz = str2;
        this.f2973SI = imVar2;
        this.f2970Oc = str3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5164a(C0793a aVar) {
        return this.f2971RM.contains(Integer.valueOf(aVar.mo5182eu()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ak */
    public Object mo5165ak(String str) {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: al */
    public boolean mo5166al(String str) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Object mo5169b(C0793a aVar) {
        switch (aVar.mo5182eu()) {
            case 2:
                return this.f2975uS;
            case 4:
                return this.f2972SH;
            case 5:
                return this.f2974Sz;
            case 6:
                return this.f2973SI;
            case 7:
                return this.f2970Oc;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.mo5182eu());
        }
    }

    public int describeContents() {
        C1086ip ipVar = CREATOR;
        return 0;
    }

    /* renamed from: en */
    public HashMap<String, C0793a<?, ?>> mo5170en() {
        return f2969RL;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1085io)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C1085io ioVar = (C1085io) obj;
        for (C0793a aVar : f2969RL.values()) {
            if (mo5164a(aVar)) {
                if (!ioVar.mo5164a(aVar)) {
                    return false;
                }
                if (!mo5169b(aVar).equals(ioVar.mo5169b(aVar))) {
                    return false;
                }
            } else if (ioVar.mo5164a(aVar)) {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return this.f2975uS;
    }

    public ItemScope getResult() {
        return this.f2972SH;
    }

    public String getStartDate() {
        return this.f2974Sz;
    }

    public ItemScope getTarget() {
        return this.f2973SI;
    }

    public String getType() {
        return this.f2970Oc;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.f2976wj;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hB */
    public Set<Integer> mo6036hB() {
        return this.f2971RM;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hS */
    public C1083im mo6037hS() {
        return this.f2972SH;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hT */
    public C1083im mo6038hT() {
        return this.f2973SI;
    }

    /* renamed from: hU */
    public C1085io freeze() {
        return this;
    }

    public boolean hasId() {
        return this.f2971RM.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.f2971RM.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.f2971RM.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.f2971RM.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.f2971RM.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        Iterator it = f2969RL.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            C0793a aVar = (C0793a) it.next();
            if (mo5164a(aVar)) {
                i = mo5169b(aVar).hashCode() + i2 + aVar.mo5182eu();
            } else {
                i = i2;
            }
        }
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1086ip ipVar = CREATOR;
        C1086ip.m3184a(this, out, flags);
    }
}
