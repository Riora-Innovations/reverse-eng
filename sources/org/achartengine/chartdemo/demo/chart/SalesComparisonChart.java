package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine;

public class SalesComparisonChart extends AbstractDemoChart {
    public String getName() {
        return "Sales comparison";
    }

    public String getDesc() {
        return "Monthly sales advance for 2 years (interpolated line and area charts)";
    }

    public Intent execute(Context context) {
        String[] titles = {"Sales for 2008", "Sales for 2007", "Difference between 2008 and 2007 sales"};
        ArrayList arrayList = new ArrayList();
        arrayList.add(new double[]{14230.0d, 12300.0d, 14240.0d, 15244.0d, 14900.0d, 12200.0d, 11030.0d, 12000.0d, 12500.0d, 15500.0d, 14600.0d, 15000.0d});
        arrayList.add(new double[]{10230.0d, 10900.0d, 11240.0d, 12540.0d, 13500.0d, 14200.0d, 12530.0d, 11200.0d, 10500.0d, 12500.0d, 11600.0d, 13500.0d});
        int length = ((double[]) arrayList.get(0)).length;
        double[] diff = new double[length];
        for (int i = 0; i < length; i++) {
            diff[i] = ((double[]) arrayList.get(0))[i] - ((double[]) arrayList.get(1))[i];
        }
        arrayList.add(diff);
        XYMultipleSeriesRenderer renderer = buildRenderer(new int[]{-16776961, -16711681, -16711936}, new PointStyle[]{PointStyle.POINT, PointStyle.POINT, PointStyle.POINT});
        setChartSettings(renderer, "Monthly sales in the last 2 years", "Month", "Units sold", 0.75d, 12.25d, -5000.0d, 19000.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setChartTitleTextSize(20.0f);
        renderer.setTextTypeface("sans_serif", 1);
        renderer.setLabelsTextSize(14.0f);
        renderer.setAxisTitleTextSize(15.0f);
        renderer.setLegendTextSize(15.0f);
        int length2 = renderer.getSeriesRendererCount();
        for (int i2 = 0; i2 < length2; i2++) {
            XYSeriesRenderer seriesRenderer = (XYSeriesRenderer) renderer.getSeriesRendererAt(i2);
            if (i2 == length2 - 1) {
                FillOutsideLine fill = FillOutsideLine.BOUNDS_ALL;
                fill.setColor(-16711936);
                seriesRenderer.addFillOutsideLine(fill);
            }
            seriesRenderer.setLineWidth(2.5f);
            seriesRenderer.setDisplayChartValues(true);
            seriesRenderer.setChartValuesTextSize(10.0f);
        }
        return ChartFactory.getCubicLineChartIntent(context, buildBarDataset(titles, arrayList), renderer, 0.5f);
    }
}
