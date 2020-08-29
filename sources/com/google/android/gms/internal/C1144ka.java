package com.google.android.gms.internal;

import com.google.android.gms.internal.C1144ka;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.ka */
public abstract class C1144ka<M extends C1144ka<M>> extends C1148ke {
    protected List<C1150kg> aae;

    /* renamed from: a */
    public final <T> T mo6421a(C1145kb<M, T> kbVar) {
        return kbVar.mo6425g(this.aae);
    }

    /* renamed from: a */
    public void mo3797a(C1140jz jzVar) throws IOException {
        int size = this.aae == null ? 0 : this.aae.size();
        for (int i = 0; i < size; i++) {
            C1150kg kgVar = (C1150kg) this.aae.get(i);
            jzVar.mo6408cF(kgVar.tag);
            jzVar.mo6415p(kgVar.aai);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo6422a(C1139jy jyVar, int i) throws IOException {
        int position = jyVar.getPosition();
        if (!jyVar.mo6372cv(i)) {
            return false;
        }
        if (this.aae == null) {
            this.aae = new ArrayList();
        }
        this.aae.add(new C1150kg(i, jyVar.mo6377e(position, jyVar.getPosition() - position)));
        return true;
    }

    /* renamed from: c */
    public int mo3799c() {
        int i = 0;
        for (int i2 = 0; i2 < (this.aae == null ? 0 : this.aae.size()); i2++) {
            C1150kg kgVar = (C1150kg) this.aae.get(i2);
            i = i + C1140jz.m3420cG(kgVar.tag) + kgVar.aai.length;
        }
        this.f3121DY = i;
        return i;
    }
}
