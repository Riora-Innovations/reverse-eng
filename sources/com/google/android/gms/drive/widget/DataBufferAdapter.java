package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataBufferAdapter<T> extends BaseAdapter {

    /* renamed from: Fj */
    private final int f852Fj;

    /* renamed from: Fk */
    private int f853Fk;

    /* renamed from: Fl */
    private final int f854Fl;

    /* renamed from: Fm */
    private final List<DataBuffer<T>> f855Fm;

    /* renamed from: Fn */
    private final LayoutInflater f856Fn;

    /* renamed from: Fo */
    private boolean f857Fo;
    private final Context mContext;

    public DataBufferAdapter(Context context, int resource) {
        this(context, resource, 0, (List<DataBuffer<T>>) new ArrayList<DataBuffer<T>>());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId) {
        this(context, resource, textViewResourceId, (List<DataBuffer<T>>) new ArrayList<DataBuffer<T>>());
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, List<DataBuffer<T>> objects) {
        this.f857Fo = true;
        this.mContext = context;
        this.f853Fk = resource;
        this.f852Fj = resource;
        this.f854Fl = textViewResourceId;
        this.f855Fm = objects;
        this.f856Fn = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int resource, int textViewResourceId, DataBuffer<T>... buffers) {
        this(context, resource, textViewResourceId, Arrays.asList(buffers));
    }

    public DataBufferAdapter(Context context, int resource, List<DataBuffer<T>> objects) {
        this(context, resource, 0, objects);
    }

    public DataBufferAdapter(Context context, int resource, DataBuffer<T>... buffers) {
        this(context, resource, 0, Arrays.asList(buffers));
    }

    /* renamed from: a */
    private View m982a(int i, View view, ViewGroup viewGroup, int i2) {
        View view2 = view == null ? this.f856Fn.inflate(i2, viewGroup, false) : view;
        try {
            TextView textView = this.f854Fl == 0 ? (TextView) view2 : (TextView) view2.findViewById(this.f854Fl);
            Object item = getItem(i);
            if (item instanceof CharSequence) {
                textView.setText((CharSequence) item);
            } else {
                textView.setText(item.toString());
            }
            return view2;
        } catch (ClassCastException e) {
            Log.e("DataBufferAdapter", "You must supply a resource ID for a TextView");
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> buffer) {
        this.f855Fm.add(buffer);
        if (this.f857Fo) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer close : this.f855Fm) {
            close.close();
        }
        this.f855Fm.clear();
        if (this.f857Fo) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getCount() {
        int i = 0;
        Iterator it = this.f855Fm.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((DataBuffer) it.next()).getCount() + i2;
        }
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return m982a(position, convertView, parent, this.f853Fk);
    }

    public T getItem(int position) throws CursorIndexOutOfBoundsException {
        int i = position;
        for (DataBuffer dataBuffer : this.f855Fm) {
            int count = dataBuffer.getCount();
            if (count <= i) {
                i -= count;
            } else {
                try {
                    return dataBuffer.get(i);
                } catch (CursorIndexOutOfBoundsException e) {
                    throw new CursorIndexOutOfBoundsException(position, getCount());
                }
            }
        }
        throw new CursorIndexOutOfBoundsException(position, getCount());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return m982a(position, convertView, parent, this.f852Fj);
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f857Fo = true;
    }

    public void setDropDownViewResource(int resource) {
        this.f853Fk = resource;
    }

    public void setNotifyOnChange(boolean notifyOnChange) {
        this.f857Fo = notifyOnChange;
    }
}
