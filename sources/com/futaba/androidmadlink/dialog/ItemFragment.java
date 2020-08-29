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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.constant.ArgumentKey;

public class ItemFragment extends DialogFragment {
    public static final String TAG = "ItemFragment";
    EditText Filter;
    ListView ItemListView;
    LinearLayout Layout_PageTitle;
    String Page = "";
    EditText et_PageTitle;

    public static ItemFragment newInstance() {
        return new ItemFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C0112R.layout.dialog_listviewselector, container, false);
        this.Page = getArguments().getString(ArgumentKey.Key_Page);
        this.Layout_PageTitle = (LinearLayout) rootView.findViewById(C0112R.C0114id.Layout_PageTitle);
        this.Layout_PageTitle.setVisibility(0);
        this.et_PageTitle = (EditText) rootView.findViewById(C0112R.C0114id.et_PageTitle);
        this.et_PageTitle.setText("Page" + this.Page);
        this.ItemListView = (ListView) rootView.findViewById(C0112R.C0114id.listview);
        this.ItemListView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                ListView listView = (ListView) arg0;
                Intent intent = ItemFragment.this.getActivity().getIntent();
                String ItemDesc = listView.getItemAtPosition(arg2).toString();
                String pageTitle = ItemFragment.this.et_PageTitle.getText().toString();
                if (pageTitle.equals("")) {
                    pageTitle = "Page" + ItemFragment.this.Page;
                }
                intent.putExtra(ArgumentKey.Key_ItemCode, ItemDesc);
                intent.putExtra(ArgumentKey.Key_Page, ItemFragment.this.Page);
                intent.putExtra("Key_PageTile", pageTitle);
                ItemFragment.this.getTargetFragment().onActivityResult(ItemFragment.this.getTargetRequestCode(), -1, intent);
                ItemFragment.this.getDialog().dismiss();
            }
        });
        doItem();
        return rootView;
    }

    private void doItem() {
        this.ItemListView.setAdapter(new ArrayAdapter<>(getActivity(), 17367043, new String[]{"1X1", "1X2", "2X2", "2X3", "2X4"}));
    }
}
