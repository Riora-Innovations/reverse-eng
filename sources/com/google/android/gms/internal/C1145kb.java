package com.google.android.gms.internal;

import com.google.android.gms.internal.C1144ka;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.kb */
public class C1145kb<M extends C1144ka<M>, T> {
    protected final Class<T> aaf;
    protected final boolean aag;
    protected final int tag;
    protected final int type;

    private C1145kb(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.aaf = cls;
        this.tag = i2;
        this.aag = z;
    }

    /* renamed from: a */
    public static <M extends C1144ka<M>, T extends C1148ke> C1145kb<M, T> m3459a(int i, Class<T> cls, int i2) {
        return new C1145kb<>(i, cls, i2, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6423a(C1150kg kgVar, List<Object> list) {
        list.add(mo6426o(C1139jy.m3383n(kgVar.aai)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: cI */
    public boolean mo6424cI(int i) {
        return i == this.tag;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: g */
    public final T mo6425g(List<C1150kg> list) {
        if (list == null) {
            return null;
        }
        if (this.aag) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                C1150kg kgVar = (C1150kg) list.get(i);
                if (mo6424cI(kgVar.tag) && kgVar.aai.length != 0) {
                    mo6423a(kgVar, arrayList);
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            T cast = this.aaf.cast(Array.newInstance(this.aaf.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        }
        int size2 = list.size() - 1;
        C1150kg kgVar2 = null;
        while (kgVar2 == null && size2 >= 0) {
            C1150kg kgVar3 = (C1150kg) list.get(size2);
            if (!mo6424cI(kgVar3.tag) || kgVar3.aai.length == 0) {
                kgVar3 = kgVar2;
            }
            size2--;
            kgVar2 = kgVar3;
        }
        if (kgVar2 == null) {
            return null;
        }
        return this.aaf.cast(mo6426o(C1139jy.m3383n(kgVar2.aai)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public Object mo6426o(C1139jy jyVar) {
        Class<T> cls = this.aag ? this.aaf.getComponentType() : this.aaf;
        try {
            switch (this.type) {
                case 10:
                    C1148ke keVar = (C1148ke) cls.newInstance();
                    jyVar.mo6369a(keVar, C1151kh.m3488cK(this.tag));
                    return keVar;
                case 11:
                    C1148ke keVar2 = (C1148ke) cls.newInstance();
                    jyVar.mo6368a(keVar2);
                    return keVar2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Error creating instance of class " + cls, e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + cls, e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }
}
