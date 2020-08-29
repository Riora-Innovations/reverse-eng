package com.futaba.androidmadlink.config;

import java.util.ArrayList;
import java.util.List;

public class GaugePageSetting {
    private int _colCount = 2;
    private List<GaugeViewSetting> _listViews = new ArrayList();
    private int _no = 1;
    private int _rowCount = 3;
    private String _title = "Page1";

    public String getTitle() {
        return this._title;
    }

    public void setTitle(String title) {
        this._title = title;
    }

    public int getPageNo() {
        return this._no;
    }

    public void setPageNo(int no) {
        this._no = no;
        for (GaugeViewSetting viewSetting : this._listViews) {
            viewSetting.setPageNo(no);
        }
    }

    public int getRowCount() {
        return this._rowCount;
    }

    public void setRowCount(int rowCount) {
        this._rowCount = rowCount;
    }

    public int getColCount() {
        return this._colCount;
    }

    public void setColCount(int colCount) {
        this._colCount = colCount;
    }

    public void setGaugeViewSetting(GaugeViewSetting gaugeView) {
        for (GaugeViewSetting mViewSetting : this._listViews) {
            if (mViewSetting.getColNo() != gaugeView.getColNo() || mViewSetting.getRowNo() == gaugeView.getRowNo()) {
            }
        }
    }

    public GaugeViewSetting getGaugeViewSetting(int colNo, int rowNo) {
        for (GaugeViewSetting mViewSetting : this._listViews) {
            if (mViewSetting.getColNo() == colNo && mViewSetting.getRowNo() == rowNo) {
                return mViewSetting;
            }
        }
        return null;
    }

    public List<GaugeViewSetting> getGaugeViewList() {
        return this._listViews;
    }

    public void addView(GaugeViewSetting viewSetting) {
        this._listViews.add(viewSetting);
    }

    public void removeView(int colNo, int rowNo) {
        for (GaugeViewSetting vSetting : this._listViews) {
            if (vSetting.getColNo() == colNo && vSetting.getRowNo() == rowNo) {
                this._listViews.remove(vSetting);
                return;
            }
        }
    }
}
