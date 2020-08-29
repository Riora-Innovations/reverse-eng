package com.futaba.androidmadlink.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.constant.ArgumentKey;
import com.futaba.androidmadlink.view.AltitudeView;
import com.futaba.androidmadlink.view.GPSLocusView;
import com.futaba.androidmadlink.view.GPSView;
import java.util.ArrayList;
import java.util.List;

public class SubMenuFragment extends DialogFragment {
    public static final String TAG = "SubMenuFragment";
    int Col = -1;
    ListView ItemListView;
    int Page = -1;
    int Row = -1;
    String ViewName = "";

    public static SubMenuFragment newInstance() {
        return new SubMenuFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C0112R.layout.dialog_listviewselector, container, false);
        Bundle bundle = getArguments();
        this.Page = bundle.getInt(ArgumentKey.Key_Page);
        this.Row = bundle.getInt(ArgumentKey.Key_Row);
        this.Col = bundle.getInt(ArgumentKey.Key_Col);
        this.ViewName = bundle.getString(ArgumentKey.Key_ViewName);
        this.ItemListView = (ListView) rootView.findViewById(C0112R.C0114id.listview);
        this.ItemListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView listView = (ListView) arg0;
                Intent intent = SubMenuFragment.this.getActivity().getIntent();
                intent.putExtra(ArgumentKey.Key_ItemCode, listView.getItemAtPosition(arg2).toString());
                intent.putExtra(ArgumentKey.Key_Page, SubMenuFragment.this.Page);
                intent.putExtra(ArgumentKey.Key_Row, SubMenuFragment.this.Row);
                intent.putExtra(ArgumentKey.Key_Col, SubMenuFragment.this.Col);
                SubMenuFragment.this.getTargetFragment().onActivityResult(SubMenuFragment.this.getTargetRequestCode(), -1, intent);
                SubMenuFragment.this.getDialog().dismiss();
            }
        });
        doItem();
        return rootView;
    }

    private void doItem() {
        List<String> mArray = new ArrayList<>();
        mArray.add(getString(C0112R.string.action_settings));
        mArray.add(getString(C0112R.string.action_remove));
        if (this.ViewName.equals(AltitudeView.class.getSimpleName()) || this.ViewName.equals(GPSView.class.getSimpleName()) || this.ViewName.equals(GPSLocusView.class.getSimpleName())) {
            mArray.add(getString(C0112R.string.action_reset));
        }
        this.ItemListView.setAdapter(new ArrayAdapter<>(getActivity(), 17367043, mArray));
    }
}
