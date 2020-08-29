package com.futaba.androidmadlink.fragment;

import android.os.Bundle;
import android.support.p000v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.futaba.androidmadlink.C0112R;

public class GaugeFragment extends Fragment {
    public static final String ARG_SECTION_NUMBER = "section_number";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C0112R.layout.fragment_main_dummy, container, false);
        ((TextView) rootView.findViewById(C0112R.C0114id.section_label)).setText(Integer.toString(getArguments().getInt("section_number")));
        return rootView;
    }

    public static GaugeFragment newInstance(int index) {
        GaugeFragment f = new GaugeFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }
}
