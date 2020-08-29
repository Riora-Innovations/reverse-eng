package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer.Orientation;

public class SalesBarChart extends AbstractDemoChart {
    public String getName() {
        return "Sales horizontal bar chart";
    }

    public String getDesc() {
        return "The monthly sales for the last 2 years (horizontal bar chart)";
    }

    public Intent execute(Context context) {
        String[] titles = {"2007", "2008"};
        ArrayList arrayList = new ArrayList();
        arrayList.add(new double[]{5230.0d, 7300.0d, 9240.0d, 10540.0d, 7900.0d, 9200.0d, 12030.0d, 11200.0d, 9500.0d, 10500.0d, 11600.0d, 13500.0d});
        arrayList.add(new double[]{14230.0d, 12300.0d, 14240.0d, 15244.0d, 15900.0d, 19200.0d, 22030.0d, 21200.0d, 19500.0d, 15500.0d, 12600.0d, 14000.0d});
        XYMultipleSeriesRenderer renderer = buildBarRenderer(new int[]{-16711681, -16776961});
        renderer.setOrientation(Orientation.VERTICAL);
        setChartSettings(renderer, "Monthly sales in the last 2 years", "Month", "Units sold", 0.5d, 12.5d, 0.0d, 24000.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(1);
        renderer.setYLabels(10);
        renderer.addXTextLabel(1.0d, "Jan");
        renderer.addXTextLabel(3.0d, "Mar");
        renderer.addXTextLabel(5.0d, "May");
        renderer.addXTextLabel(7.0d, "Jul");
        renderer.addXTextLabel(10.0d, "Oct");
        renderer.addXTextLabel(12.0d, "Dec");
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            renderer.getSeriesRendererAt(i).setDisplayChartValues(true);
        }
        return ChartFactory.getBarChartIntent(context, buildBarDataset(titles, arrayList), renderer, Type.DEFAULT);
    }
}
