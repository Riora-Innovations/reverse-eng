package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint.Align;
import java.util.ArrayList;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class AverageTemperatureChart extends AbstractDemoChart {
    public String getName() {
        return "Average temperature";
    }

    public String getDesc() {
        return "The average temperature in 4 Greek islands (line chart)";
    }

    public Intent execute(Context context) {
        String[] titles = {"Crete", "Corfu", "Thassos", "Skiathos"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < titles.length; i++) {
            arrayList.add(new double[]{1.0d, 2.0d, 3.0d, 4.0d, 5.0d, 6.0d, 7.0d, 8.0d, 9.0d, 10.0d, 11.0d, 12.0d});
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new double[]{12.3d, 12.5d, 13.8d, 16.8d, 20.4d, 24.4d, 26.4d, 26.1d, 23.6d, 20.3d, 17.2d, 13.9d});
        arrayList2.add(new double[]{10.0d, 10.0d, 12.0d, 15.0d, 20.0d, 24.0d, 26.0d, 26.0d, 23.0d, 18.0d, 14.0d, 11.0d});
        arrayList2.add(new double[]{5.0d, 5.3d, 8.0d, 12.0d, 17.0d, 22.0d, 24.2d, 24.0d, 19.0d, 15.0d, 9.0d, 6.0d});
        arrayList2.add(new double[]{9.0d, 10.0d, 11.0d, 15.0d, 19.0d, 23.0d, 26.0d, 25.0d, 22.0d, 18.0d, 13.0d, 10.0d});
        XYMultipleSeriesRenderer renderer = buildRenderer(new int[]{-16776961, -16711936, -16711681, -256}, new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND, PointStyle.TRIANGLE, PointStyle.SQUARE});
        int length = renderer.getSeriesRendererCount();
        for (int i2 = 0; i2 < length; i2++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i2)).setFillPoints(true);
        }
        setChartSettings(renderer, "Average temperature", "Month", "Temperature", 0.5d, 12.5d, -10.0d, 40.0d, DefaultRenderer.TEXT_COLOR, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Align.RIGHT);
        renderer.setYLabelsAlign(Align.RIGHT);
        renderer.setYLabelsPadding(10.0f);
        renderer.setZoomButtonsVisible(true);
        renderer.setPanLimits(new double[]{-10.0d, 20.0d, -10.0d, 40.0d});
        renderer.setZoomLimits(new double[]{-10.0d, 20.0d, -10.0d, 40.0d});
        XYMultipleSeriesDataset dataset = buildDataset(titles, arrayList, arrayList2);
        dataset.getSeriesAt(0).addAnnotation("Vacation", 6.0d, 30.0d);
        return ChartFactory.getLineChartIntent(context, dataset, renderer, "Average temperature");
    }
}
