package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* renamed from: com.google.android.gms.common.data.c */
public class C0313c<T extends SafeParcelable> extends DataBuffer<T> {

    /* renamed from: zY */
    private static final String[] f584zY = {"data"};

    /* renamed from: zZ */
    private final Creator<T> f585zZ;

    public C0313c(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.f585zZ = creator;
    }

    /* renamed from: H */
    public T get(int i) {
        byte[] byteArray = this.f561zU.getByteArray("data", i, 0);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.f585zZ.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
