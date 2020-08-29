package com.google.android.gms.internal;

import android.net.LocalSocket;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.ge */
final class C0904ge implements RealTimeSocket {

    /* renamed from: AC */
    private ParcelFileDescriptor f2493AC;

    /* renamed from: GZ */
    private final String f2494GZ;

    /* renamed from: HG */
    private final LocalSocket f2495HG;

    C0904ge(LocalSocket localSocket, String str) {
        this.f2495HG = localSocket;
        this.f2494GZ = str;
    }

    public void close() throws IOException {
        this.f2495HG.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.f2495HG.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f2495HG.getOutputStream();
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        if (this.f2493AC == null && !isClosed()) {
            Parcel obtain = Parcel.obtain();
            obtain.writeFileDescriptor(this.f2495HG.getFileDescriptor());
            obtain.setDataPosition(0);
            this.f2493AC = obtain.readFileDescriptor();
        }
        return this.f2493AC;
    }

    public boolean isClosed() {
        return !this.f2495HG.isConnected() && !this.f2495HG.isBound();
    }
}
