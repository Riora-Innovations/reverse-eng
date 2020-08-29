package org.achartengine.chartdemo.demo.chart;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
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
import org.achartengine.tools.PanListener;
import org.achartengine.tools.ZoomEvent;
import org.achartengine.tools.ZoomListener;

public class XYChartBuilderBackup extends Activity {
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
    public EditText f4053mX;
    /* access modifiers changed from: private */

    /* renamed from: mY */
    public EditText f4054mY;

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
        this.f4053mX = (EditText) findViewById(C1563R.C1565id.xValue);
        this.f4054mY = (EditText) findViewById(C1563R.C1565id.yValue);
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
                XYSeries series = new XYSeries("Series " + (XYChartBuilderBackup.this.mDataset.getSeriesCount() + 1));
                XYChartBuilderBackup.this.mDataset.addSeries(series);
                XYChartBuilderBackup.this.mCurrentSeries = series;
                XYSeriesRenderer renderer = new XYSeriesRenderer();
                XYChartBuilderBackup.this.mRenderer.addSeriesRenderer(renderer);
                renderer.setPointStyle(PointStyle.CIRCLE);
                renderer.setFillPoints(true);
                renderer.setDisplayChartValues(true);
                renderer.setDisplayChartValuesDistance(10);
                XYChartBuilderBackup.this.mCurrentRenderer = renderer;
                XYChartBuilderBackup.this.setSeriesWidgetsEnabled(true);
                XYChartBuilderBackup.this.mCurrentSeries.add(1.0d, 2.0d);
                XYChartBuilderBackup.this.mCurrentSeries.add(2.0d, 3.0d);
                XYChartBuilderBackup.this.mCurrentSeries.add(3.0d, 0.5d);
                XYChartBuilderBackup.this.mCurrentSeries.add(4.0d, -1.0d);
                XYChartBuilderBackup.this.mCurrentSeries.add(5.0d, 2.5d);
                XYChartBuilderBackup.this.mCurrentSeries.add(6.0d, 3.5d);
                XYChartBuilderBackup.this.mCurrentSeries.add(7.0d, 2.85d);
                XYChartBuilderBackup.this.mCurrentSeries.add(8.0d, 3.25d);
                XYChartBuilderBackup.this.mCurrentSeries.add(9.0d, 4.25d);
                XYChartBuilderBackup.this.mCurrentSeries.add(10.0d, 3.75d);
                XYChartBuilderBackup.this.mRenderer.setRange(new double[]{0.5d, 10.5d, -1.5d, 4.75d});
                XYChartBuilderBackup.this.mChartView.repaint();
            }
        });
        this.mAdd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    try {
                        XYChartBuilderBackup.this.mCurrentSeries.add(Double.parseDouble(XYChartBuilderBackup.this.f4053mX.getText().toString()), Double.parseDouble(XYChartBuilderBackup.this.f4054mY.getText().toString()));
                        XYChartBuilderBackup.this.f4053mX.setText("");
                        XYChartBuilderBackup.this.f4054mY.setText("");
                        XYChartBuilderBackup.this.f4053mX.requestFocus();
                        XYChartBuilderBackup.this.mChartView.repaint();
                    } catch (NumberFormatException e) {
                        XYChartBuilderBackup.this.f4054mY.requestFocus();
                    }
                } catch (NumberFormatException e2) {
                    XYChartBuilderBackup.this.f4053mX.requestFocus();
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
            this.mChartView = ChartFactory.getScatterChartView(this, this.mDataset, this.mRenderer);
            this.mRenderer.setClickEnabled(true);
            this.mRenderer.setSelectableBuffer(100);
            this.mChartView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    SeriesSelection seriesSelection = XYChartBuilderBackup.this.mChartView.getCurrentSeriesAndPoint();
                    if (seriesSelection == null) {
                        Toast.makeText(XYChartBuilderBackup.this, "No chart element was clicked", 0).show();
                        return;
                    }
                    double[] xy = XYChartBuilderBackup.this.mChartView.toRealPoint(0);
                    Toast.makeText(XYChartBuilderBackup.this, "Chart element in series index " + seriesSelection.getSeriesIndex() + " data point index " + seriesSelection.getPointIndex() + " was clicked" + " closest point value X=" + seriesSelection.getXValue() + ", Y=" + seriesSelection.getValue() + " clicked point value X=" + ((float) xy[0]) + ", Y=" + ((float) xy[1]), 0).show();
                }
            });
            this.mChartView.addZoomListener(new ZoomListener() {
                public void zoomApplied(ZoomEvent e) {
                    String type = "out";
                    if (e.isZoomIn()) {
                        type = "in";
                    }
                    Log.i("Zoom", "Zoom " + type + " rate " + e.getZoomRate());
                }

                public void zoomReset() {
                    Log.i("Zoom", "Reset");
                }
            }, true, true);
            this.mChartView.addPanListener(new PanListener() {
                public void panApplied() {
                    Log.i("Pan", "New X range=[" + XYChartBuilderBackup.this.mRenderer.getXAxisMin() + ", " + XYChartBuilderBackup.this.mRenderer.getXAxisMax() + "], Y range=[" + XYChartBuilderBackup.this.mRenderer.getYAxisMax() + ", " + XYChartBuilderBackup.this.mRenderer.getYAxisMax() + "]");
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
        this.f4053mX.setEnabled(enabled);
        this.f4054mY.setEnabled(enabled);
        this.mAdd.setEnabled(enabled);
    }
}
