package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Random;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class ScatterChart extends AbstractDemoChart {
    public String getName() {
        return "Scatter chart";
    }

    public String getDesc() {
        return "Randomly generated values for the scatter chart";
    }

    public Intent execute(Context context) {
        String[] titles = {"Series 1", "Series 2", "Series 3", "Series 4", "Series 5"};
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = titles.length;
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            double[] xValues = new double[20];
            double[] yValues = new double[20];
            for (int k = 0; k < 20; k++) {
                xValues[k] = (double) ((r.nextInt() % 10) + k);
                yValues[k] = (double) ((k * 2) + (r.nextInt() % 10));
            }
            arrayList.add(xValues);
            arrayList2.add(yValues);
        }
        XYMultipleSeriesRenderer renderer = buildRenderer(new int[]{-16776961, -16711681, -65281, DefaultRenderer.TEXT_COLOR, -16711936}, new PointStyle[]{PointStyle.X, PointStyle.DIAMOND, PointStyle.TRIANGLE, PointStyle.SQUARE, PointStyle.CIRCLE});
        setChartSettings(renderer, "Scatter chart", "X", "Y", -10.0d, 30.0d, -10.0d, 51.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(10);
        renderer.setYLabels(10);
        int length2 = renderer.getSeriesRendererCount();
        for (int i2 = 0; i2 < length2; i2++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i2)).setFillPoints(true);
        }
        return ChartFactory.getScatterChartIntent(context, buildDataset(titles, arrayList, arrayList2), renderer);
    }
}
