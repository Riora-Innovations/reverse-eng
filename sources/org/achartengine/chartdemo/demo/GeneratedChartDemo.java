package org.achartengine.chartdemo.demo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.chart.PointStyle;
import org.achartengine.chart.TimeChart;
import org.achartengine.chartdemo.demo.chart.IDemoChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class GeneratedChartDemo extends ListActivity {
    private static final int SERIES_NR = 2;
    private String[] mMenuSummary;
    private String[] mMenuText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mMenuText = new String[]{"Line chart", "Scatter chart", "Time chart", "Bar chart"};
        this.mMenuSummary = new String[]{"Line chart with randomly generated values", "Scatter chart with randomly generated values", "Time chart with randomly generated values", "Bar chart with randomly generated values"};
        setListAdapter(new SimpleAdapter(this, getListValues(), 17367044, new String[]{IDemoChart.NAME, IDemoChart.DESC}, new int[]{16908308, 16908309}));
    }

    private List<Map<String, String>> getListValues() {
        List<Map<String, String>> values = new ArrayList<>();
        int length = this.mMenuText.length;
        for (int i = 0; i < length; i++) {
            Map<String, String> v = new HashMap<>();
            v.put(IDemoChart.NAME, this.mMenuText[i]);
            v.put(IDemoChart.DESC, this.mMenuSummary[i]);
            values.add(v);
        }
        return values;
    }

    private XYMultipleSeriesDataset getDemoDataset() {
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        Random r = new Random();
        for (int i = 0; i < 2; i++) {
            XYSeries series = new XYSeries("Demo series " + (i + 1));
            for (int k = 0; k < 10; k++) {
                series.add((double) k, (double) ((r.nextInt() % 100) + 20));
            }
            dataset.addSeries(series);
        }
        return dataset;
    }

    private XYMultipleSeriesDataset getDateDemoDataset() {
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        long value = new Date().getTime() - 259200000;
        Random r = new Random();
        for (int i = 0; i < 2; i++) {
            TimeSeries series = new TimeSeries("Demo series " + (i + 1));
            for (int k = 0; k < 10; k++) {
                series.add(new Date(((((long) k) * TimeChart.DAY) / 4) + value), (double) ((r.nextInt() % 100) + 20));
            }
            dataset.addSeries(series);
        }
        return dataset;
    }

    private XYMultipleSeriesDataset getBarDemoDataset() {
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        Random r = new Random();
        for (int i = 0; i < 2; i++) {
            CategorySeries series = new CategorySeries("Demo series " + (i + 1));
            for (int k = 0; k < 10; k++) {
                series.add((double) ((r.nextInt() % 100) + 100));
            }
            dataset.addSeries(series.toXYSeries());
        }
        return dataset;
    }

    private XYMultipleSeriesRenderer getDemoRenderer() {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setAxisTitleTextSize(16.0f);
        renderer.setChartTitleTextSize(20.0f);
        renderer.setLabelsTextSize(15.0f);
        renderer.setLegendTextSize(15.0f);
        renderer.setPointSize(5.0f);
        int[] iArr = new int[4];
        iArr[0] = 20;
        iArr[1] = 30;
        iArr[2] = 15;
        renderer.setMargins(iArr);
        XYSeriesRenderer r = new XYSeriesRenderer();
        r.setColor(-16776961);
        r.setPointStyle(PointStyle.SQUARE);
        r.setFillBelowLine(true);
        r.setFillBelowLineColor(-1);
        r.setFillPoints(true);
        renderer.addSeriesRenderer(r);
        XYSeriesRenderer r2 = new XYSeriesRenderer();
        r2.setPointStyle(PointStyle.CIRCLE);
        r2.setColor(-16711936);
        r2.setFillPoints(true);
        renderer.addSeriesRenderer(r2);
        renderer.setAxesColor(-12303292);
        renderer.setLabelsColor(DefaultRenderer.TEXT_COLOR);
        return renderer;
    }

    public XYMultipleSeriesRenderer getBarDemoRenderer() {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setAxisTitleTextSize(16.0f);
        renderer.setChartTitleTextSize(20.0f);
        renderer.setLabelsTextSize(15.0f);
        renderer.setLegendTextSize(15.0f);
        int[] iArr = new int[4];
        iArr[0] = 20;
        iArr[1] = 30;
        iArr[2] = 15;
        renderer.setMargins(iArr);
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(-16776961);
        renderer.addSeriesRenderer(r);
        SimpleSeriesRenderer r2 = new SimpleSeriesRenderer();
        r2.setColor(-16711936);
        renderer.addSeriesRenderer(r2);
        return renderer;
    }

    private void setChartSettings(XYMultipleSeriesRenderer renderer) {
        renderer.setChartTitle("Chart demo");
        renderer.setXTitle("x values");
        renderer.setYTitle("y values");
        renderer.setXAxisMin(0.5d);
        renderer.setXAxisMax(10.5d);
        renderer.setYAxisMin(0.0d);
        renderer.setYAxisMax(210.0d);
    }

    /* access modifiers changed from: protected */
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                startActivity(ChartFactory.getLineChartIntent(this, getDemoDataset(), getDemoRenderer()));
                return;
            case 1:
                startActivity(ChartFactory.getScatterChartIntent(this, getDemoDataset(), getDemoRenderer()));
                return;
            case 2:
                startActivity(ChartFactory.getTimeChartIntent(this, getDateDemoDataset(), getDemoRenderer(), null));
                return;
            case 3:
                XYMultipleSeriesRenderer renderer = getBarDemoRenderer();
                setChartSettings(renderer);
                startActivity(ChartFactory.getBarChartIntent(this, getBarDemoDataset(), renderer, Type.DEFAULT));
                return;
            default:
                return;
        }
    }
}
