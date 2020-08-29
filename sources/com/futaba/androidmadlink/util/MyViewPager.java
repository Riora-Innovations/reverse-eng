package com.futaba.androidmadlink.util;

import android.support.p000v4.view.ViewPager.SimpleOnPageChangeListener;

public class MyViewPager extends SimpleOnPageChangeListener {
    private int currentPage;

    public void onPageSelected(int position) {
        this.currentPage = position;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }
}
