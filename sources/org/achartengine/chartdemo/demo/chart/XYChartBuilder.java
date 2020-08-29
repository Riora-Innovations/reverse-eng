package org.achartengine.chartdemo.demo.chart;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.chartdemo.demo.C1563R;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class XYChartBuilder extends Activity {
    private Button mAdd;
    /* access modifiers changed from: private */
    public GraphicalView mChartView;
    /* access modifiers changed from: private */
    public XYSeriesRenderer mCurrentRenderer;
    /* access modifiers changed from: private */
    public XYSeries mCurrentSeries;
    /* access modifiers changed from: private */
    public XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
    private Button mNewSeries;
    /* access modifiers changed from: private */
    public XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
    /* access modifiers changed from: private */

    /* renamed from: mX */
    public EditText f4051mX;
    /* access modifiers changed from: private */

    /* renamed from: mY */
    public EditText f4052mY;

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("dataset", this.mDataset);
        outState.putSerializable("renderer", this.mRenderer);
        outState.putSerializable("current_series", this.mCurrentSeries);
        outState.putSerializable("current_renderer", this.mCurrentRenderer);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        this.mDataset = (XYMultipleSeriesDataset) savedState.getSerializable("dataset");
        this.mRenderer = (XYMultipleSeriesRenderer) savedState.getSerializable("renderer");
        this.mCurrentSeries = (XYSeries) savedState.getSerializable("current_series");
        this.mCurrentRenderer = (XYSeriesRenderer) savedState.getSerializable("current_renderer");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1563R.layout.xy_chart);
        this.f4051mX = (EditText) findViewById(C1563R.C1565id.xValue);
        this.f4052mY = (EditText) findViewById(C1563R.C1565id.yValue);
        this.mAdd = (Button) findViewById(C1563R.C1565id.add);
        this.mRenderer.setApplyBackgroundColor(true);
        this.mRenderer.setBackgroundColor(Color.argb(100, 50, 50, 50));
        this.mRenderer.setAxisTitleTextSize(16.0f);
        this.mRenderer.setChartTitleTextSize(20.0f);
        this.mRenderer.setLabelsTextSize(15.0f);
        this.mRenderer.setLegendTextSize(15.0f);
        XYMultipleSeriesRenderer xYMultipleSeriesRenderer = this.mRenderer;
        int[] iArr = new int[4];
        iArr[0] = 20;
        iArr[1] = 30;
        iArr[2] = 15;
        xYMultipleSeriesRenderer.setMargins(iArr);
        this.mRenderer.setZoomButtonsVisible(true);
        this.mRenderer.setPointSize(5.0f);
        this.mNewSeries = (Button) findViewById(C1563R.C1565id.new_series);
        this.mNewSeries.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                XYSeries series = new XYSeries("Series " + (XYChartBuilder.this.mDataset.getSeriesCount() + 1));
                XYChartBuilder.this.mDataset.addSeries(series);
                XYChartBuilder.this.mCurrentSeries = series;
                XYSeriesRenderer renderer = new XYSeriesRenderer();
                XYChartBuilder.this.mRenderer.addSeriesRenderer(renderer);
                renderer.setPointStyle(PointStyle.CIRCLE);
                renderer.setFillPoints(true);
                renderer.setDisplayChartValues(true);
                renderer.setDisplayChartValuesDistance(10);
                XYChartBuilder.this.mCurrentRenderer = renderer;
                XYChartBuilder.this.setSeriesWidgetsEnabled(true);
                XYChartBuilder.this.mChartView.repaint();
            }
        });
        this.mAdd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    try {
                        XYChartBuilder.this.mCurrentSeries.add(Double.parseDouble(XYChartBuilder.this.f4051mX.getText().toString()), Double.parseDouble(XYChartBuilder.this.f4052mY.getText().toString()));
                        XYChartBuilder.this.f4051mX.setText("");
                        XYChartBuilder.this.f4052mY.setText("");
                        XYChartBuilder.this.f4051mX.requestFocus();
                        XYChartBuilder.this.mChartView.repaint();
                    } catch (NumberFormatException e) {
                        XYChartBuilder.this.f4052mY.requestFocus();
                    }
                } catch (NumberFormatException e2) {
                    XYChartBuilder.this.f4051mX.requestFocus();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        boolean enabled = true;
        super.onResume();
        if (this.mChartView == null) {
            LinearLayout layout = (LinearLayout) findViewById(C1563R.C1565id.chart);
            this.mChartView = ChartFactory.getLineChartView(this, this.mDataset, this.mRenderer);
            this.mRenderer.setClickEnabled(true);
            this.mRenderer.setSelectableBuffer(10);
            this.mChartView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    SeriesSelection seriesSelection = XYChartBuilder.this.mChartView.getCurrentSeriesAndPoint();
                    if (seriesSelection == null) {
                        Toast.makeText(XYChartBuilder.this, "No chart element", 0).show();
                    } else {
                        Toast.makeText(XYChartBuilder.this, "Chart element in series index " + seriesSelection.getSeriesIndex() + " data point index " + seriesSelection.getPointIndex() + " was clicked" + " closest point value X=" + seriesSelection.getXValue() + ", Y=" + seriesSelection.getValue(), 0).show();
                    }
                }
            });
            layout.addView(this.mChartView, new LayoutParams(-1, -1));
            if (this.mDataset.getSeriesCount() <= 0) {
                enabled = false;
            }
            setSeriesWidgetsEnabled(enabled);
            return;
        }
        this.mChartView.repaint();
    }

    /* access modifiers changed from: private */
    public void setSeriesWidgetsEnabled(boolean enabled) {
        this.f4051mX.setEnabled(enabled);
        this.f4052mY.setEnabled(enabled);
        this.mAdd.setEnabled(enabled);
    }
}
