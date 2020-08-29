package com.futaba.androidmadlink.file;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.futaba.androidmadlink.C0112R;
import java.util.ArrayList;
import java.util.List;

public class CellArrayAdapter extends ArrayAdapter<Cell> {
    private Context mContext;
    private List<Cell> mData = new ArrayList();
    private ImageView mIcon;
    private TextView mText;
    private int mViewResourceId;

    public CellArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.mContext = context;
        this.mViewResourceId = textViewResourceId;
    }

    public void add(Cell object) {
        super.add(object);
        this.mData.add(object);
    }

    public void clear() {
        super.clear();
        this.mData.clear();
    }

    public int getCount() {
        return this.mData.size();
    }

    public Cell getItem(int position) {
        return (Cell) this.mData.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(this.mViewResourceId, parent, false);
        }
        Cell cell = getItem(position);
        this.mIcon = (ImageView) view.findViewById(C0112R.C0114id.listViewIcon);
        this.mText = (TextView) view.findViewById(C0112R.C0114id.listViewText);
        this.mText.setText(cell.getText());
        this.mIcon.setImageResource(cell.getIconId());
        return view;
    }
}
