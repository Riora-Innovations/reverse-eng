package com.google.android.gms.internal;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.kg */
public final class C1150kg {
    final byte[] aai;
    final int tag;

    C1150kg(int i, byte[] bArr) {
        this.tag = i;
        this.aai = bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C1150kg)) {
            return false;
        }
        C1150kg kgVar = (C1150kg) o;
        return this.tag == kgVar.tag && Arrays.equals(this.aai, kgVar.aai);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.aai);
    }
}
