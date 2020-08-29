package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C0326b {
    /* renamed from: B */
    private static int m597B(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    /* renamed from: C */
    private static void m598C(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    /* renamed from: D */
    public static void m599D(Parcel parcel, int i) {
        m598C(parcel, i);
    }

    /* renamed from: a */
    public static void m600a(Parcel parcel, int i, byte b) {
        m617b(parcel, i, 4);
        parcel.writeInt(b);
    }

    /* renamed from: a */
    public static void m601a(Parcel parcel, int i, double d) {
        m617b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    /* renamed from: a */
    public static void m602a(Parcel parcel, int i, float f) {
        m617b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    /* renamed from: a */
    public static void m603a(Parcel parcel, int i, long j) {
        m617b(parcel, i, 8);
        parcel.writeLong(j);
    }

    /* renamed from: a */
    public static void m604a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int B = m597B(parcel, i);
            parcel.writeBundle(bundle);
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m605a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int B = m597B(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m606a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int B = m597B(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m607a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int B = m597B(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m608a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            m617b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m609a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int B = m597B(parcel, i);
            parcel.writeString(str);
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m610a(Parcel parcel, int i, List<String> list, boolean z) {
        if (list != null) {
            int B = m597B(parcel, i);
            parcel.writeStringList(list);
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m611a(Parcel parcel, int i, short s) {
        m617b(parcel, i, 4);
        parcel.writeInt(s);
    }

    /* renamed from: a */
    public static void m612a(Parcel parcel, int i, boolean z) {
        m617b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    /* renamed from: a */
    public static void m613a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int B = m597B(parcel, i);
            parcel.writeByteArray(bArr);
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static <T extends Parcelable> void m614a(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int B = m597B(parcel, i);
            parcel.writeInt(r3);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    m616a(parcel, t, i2);
                }
            }
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    public static void m615a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int B = m597B(parcel, i);
            parcel.writeStringArray(strArr);
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: a */
    private static <T extends Parcelable> void m616a(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    /* renamed from: b */
    private static void m617b(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    /* renamed from: b */
    public static <T extends Parcelable> void m618b(Parcel parcel, int i, List<T> list, boolean z) {
        if (list != null) {
            int B = m597B(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    m616a(parcel, (T) parcelable, 0);
                }
            }
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: c */
    public static void m619c(Parcel parcel, int i, int i2) {
        m617b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    /* renamed from: c */
    public static void m620c(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int B = m597B(parcel, i);
            parcel.writeList(list);
            m598C(parcel, B);
        } else if (z) {
            m617b(parcel, i, 0);
        }
    }

    /* renamed from: p */
    public static int m621p(Parcel parcel) {
        return m597B(parcel, 20293);
    }
}
