package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint.Align;
import java.util.ArrayList;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class SalesStackedBarChart extends AbstractDemoChart {
    public String getName() {
        return "Sales stacked bar chart";
    }

    public String getDesc() {
        return "The monthly sales for the last 2 years (stacked bar chart)";
    }

    public Intent execute(Context context) {
        String[] titles = {"2008", "2007"};
        ArrayList arrayList = new ArrayList();
        arrayList.add(new double[]{14230.0d, 12300.0d, 14240.0d, 15244.0d, 15900.0d, 19200.0d, 22030.0d, 21200.0d, 19500.0d, 15500.0d, 12600.0d, 14000.0d});
        arrayList.add(new double[]{5230.0d, 7300.0d, 9240.0d, 10540.0d, 7900.0d, 9200.0d, 12030.0d, 11200.0d, 9500.0d, 10500.0d, 11600.0d, 13500.0d});
        XYMultipleSeriesRenderer renderer = buildBarRenderer(new int[]{-16776961, -16711681});
        setChartSettings(renderer, "Monthly sales in the last 2 years", "Month", "Units sold", 0.5d, 12.5d, 0.0d, 24000.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.getSeriesRendererAt(0).setDisplayChartValues(true);
        renderer.getSeriesRendererAt(1).setDisplayChartValues(true);
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setXLabelsAlign(Align.LEFT);
        renderer.setYLabelsAlign(Align.LEFT);
        renderer.setPanEnabled(true, false);
        renderer.setZoomRate(1.1f);
        renderer.setBarSpacing(0.5d);
        return ChartFactory.getBarChartIntent(context, buildBarDataset(titles, arrayList), renderer, Type.STACKED);
    }
}
