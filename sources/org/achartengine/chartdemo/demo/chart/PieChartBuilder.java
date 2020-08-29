package org.achartengine.chartdemo.demo.chart;

import android.app.Activity;
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
import org.achartengine.chartdemo.demo.C1563R;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class PieChartBuilder extends Activity {
    /* access modifiers changed from: private */
    public static int[] COLORS = {-16711936, -16776961, -65281, -16711681};
    private Button mAdd;
    /* access modifiers changed from: private */
    public GraphicalView mChartView;
    /* access modifiers changed from: private */
    public DefaultRenderer mRenderer = new DefaultRenderer();
    /* access modifiers changed from: private */
    public CategorySeries mSeries = new CategorySeries("");
    /* access modifiers changed from: private */
    public EditText mValue;

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        this.mSeries = (CategorySeries) savedState.getSerializable("current_series");
        this.mRenderer = (DefaultRenderer) savedState.getSerializable("current_renderer");
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("current_series", this.mSeries);
        outState.putSerializable("current_renderer", this.mRenderer);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C1563R.layout.xy_chart);
        this.mValue = (EditText) findViewById(C1563R.C1565id.xValue);
        this.mRenderer.setZoomButtonsVisible(true);
        this.mRenderer.setStartAngle(180.0f);
        this.mRenderer.setDisplayValues(true);
        this.mAdd = (Button) findViewById(C1563R.C1565id.add);
        this.mAdd.setEnabled(true);
        this.mValue.setEnabled(true);
        this.mAdd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    double value = Double.parseDouble(PieChartBuilder.this.mValue.getText().toString());
                    PieChartBuilder.this.mValue.setText("");
                    PieChartBuilder.this.mValue.requestFocus();
                    PieChartBuilder.this.mSeries.add("Series " + (PieChartBuilder.this.mSeries.getItemCount() + 1), value);
                    SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
                    renderer.setColor(PieChartBuilder.COLORS[(PieChartBuilder.this.mSeries.getItemCount() - 1) % PieChartBuilder.COLORS.length]);
                    PieChartBuilder.this.mRenderer.addSeriesRenderer(renderer);
                    PieChartBuilder.this.mChartView.repaint();
                } catch (NumberFormatException e) {
                    PieChartBuilder.this.mValue.requestFocus();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.mChartView == null) {
            LinearLayout layout = (LinearLayout) findViewById(C1563R.C1565id.chart);
            this.mChartView = ChartFactory.getPieChartView(this, this.mSeries, this.mRenderer);
            this.mRenderer.setClickEnabled(true);
            this.mChartView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    boolean z;
                    SeriesSelection seriesSelection = PieChartBuilder.this.mChartView.getCurrentSeriesAndPoint();
                    if (seriesSelection == null) {
                        Toast.makeText(PieChartBuilder.this, "No chart element selected", 0).show();
                        return;
                    }
                    for (int i = 0; i < PieChartBuilder.this.mSeries.getItemCount(); i++) {
                        SimpleSeriesRenderer seriesRendererAt = PieChartBuilder.this.mRenderer.getSeriesRendererAt(i);
                        if (i == seriesSelection.getPointIndex()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        seriesRendererAt.setHighlighted(z);
                    }
                    PieChartBuilder.this.mChartView.repaint();
                    Toast.makeText(PieChartBuilder.this, "Chart data point index " + seriesSelection.getPointIndex() + " selected" + " point value=" + seriesSelection.getValue(), 0).show();
                }
            });
            layout.addView(this.mChartView, new LayoutParams(-1, -1));
            return;
        }
        this.mChartView.repaint();
    }
}
