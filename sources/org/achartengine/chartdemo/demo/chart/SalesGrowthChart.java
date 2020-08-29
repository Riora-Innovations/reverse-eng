package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Date;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine;

public class SalesGrowthChart extends AbstractDemoChart {
    public String getName() {
        return "Sales growth";
    }

    public String getDesc() {
        return "The sales growth across several years (time chart)";
    }

    public Intent execute(Context context) {
        String[] titles = {"Sales growth January 1995 to December 2000"};
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Date[] dateValues = {new Date(95, 0, 1), new Date(95, 3, 1), new Date(95, 6, 1), new Date(95, 9, 1), new Date(96, 0, 1), new Date(96, 3, 1), new Date(96, 6, 1), new Date(96, 9, 1), new Date(97, 0, 1), new Date(97, 3, 1), new Date(97, 6, 1), new Date(97, 9, 1), new Date(98, 0, 1), new Date(98, 3, 1), new Date(98, 6, 1), new Date(98, 9, 1), new Date(99, 0, 1), new Date(99, 3, 1), new Date(99, 6, 1), new Date(99, 9, 1), new Date(100, 0, 1), new Date(100, 3, 1), new Date(100, 6, 1), new Date(100, 9, 1), new Date(100, 11, 1)};
        arrayList.add(dateValues);
        arrayList2.add(new double[]{4.9d, 5.3d, 3.2d, 4.5d, 6.5d, 4.7d, 5.8d, 4.3d, 4.0d, 2.3d, -0.5d, -2.9d, 3.2d, 5.5d, 4.6d, 9.4d, 4.3d, 1.2d, 0.0d, 0.4d, 4.5d, 3.4d, 4.5d, 4.3d, 4.0d});
        XYMultipleSeriesRenderer renderer = buildRenderer(new int[]{-16776961}, new PointStyle[]{PointStyle.POINT});
        setChartSettings(renderer, "Sales growth", "Date", "%", (double) dateValues[0].getTime(), (double) dateValues[dateValues.length - 1].getTime(), -4.0d, 11.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setYLabels(10);
        renderer.setXRoundedLabels(false);
        XYSeriesRenderer xyRenderer = (XYSeriesRenderer) renderer.getSeriesRendererAt(0);
        FillOutsideLine fill = FillOutsideLine.BOUNDS_BELOW;
        fill.setColor(-65281);
        xyRenderer.addFillOutsideLine(fill);
        FillOutsideLine fill2 = FillOutsideLine.BOUNDS_ABOVE;
        fill2.setColor(-16711936);
        xyRenderer.addFillOutsideLine(fill2);
        return ChartFactory.getTimeChartIntent(context, buildDateDataset(titles, arrayList, arrayList2), renderer, "MMM yyyy");
    }
}
