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

public class MultipleTemperatureChart extends AbstractDemoChart {
    public String getName() {
        return "Temperature and sunshine";
    }

    public String getDesc() {
        return "The average temperature and hours of sunshine in Crete (line chart with multiple Y scales and axis)";
    }

    public Intent execute(Context context) {
        String[] titles = {"Air temperature"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < titles.length; i++) {
            arrayList.add(new double[]{1.0d, 2.0d, 3.0d, 4.0d, 5.0d, 6.0d, 7.0d, 8.0d, 9.0d, 10.0d, 11.0d, 12.0d});
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new double[]{12.3d, 12.5d, 13.8d, 16.8d, 20.4d, 24.4d, 26.4d, 26.1d, 23.6d, 20.3d, 17.2d, 13.9d});
        int[] colors = {-16776961, -256};
        PointStyle[] styles = {PointStyle.POINT, PointStyle.POINT};
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer(2);
        setRenderer(renderer, colors, styles);
        int length = renderer.getSeriesRendererCount();
        for (int i2 = 0; i2 < length; i2++) {
            ((XYSeriesRenderer) renderer.getSeriesRendererAt(i2)).setLineWidth(3.0f);
        }
        setChartSettings(renderer, "Average temperature", "Month", "Temperature", 0.5d, 12.5d, 0.0d, 32.0d, DefaultRenderer.TEXT_COLOR, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Align.RIGHT);
        renderer.setYLabelsAlign(Align.RIGHT);
        renderer.setZoomButtonsVisible(true);
        renderer.setPanLimits(new double[]{-10.0d, 20.0d, -10.0d, 40.0d});
        renderer.setZoomLimits(new double[]{-10.0d, 20.0d, -10.0d, 40.0d});
        renderer.setZoomRate(1.05f);
        renderer.setLabelsColor(-1);
        renderer.setXLabelsColor(-16711936);
        renderer.setYLabelsColor(0, colors[0]);
        renderer.setYLabelsColor(1, colors[1]);
        renderer.setYTitle("Hours", 1);
        renderer.setYAxisAlign(Align.LEFT, 1);
        renderer.setYLabelsAlign(Align.LEFT, 1);
        renderer.addYTextLabel(20.0d, "Test", 0);
        renderer.addYTextLabel(10.0d, "New Test", 1);
        XYMultipleSeriesDataset dataset = buildDataset(titles, arrayList, arrayList2);
        arrayList2.clear();
        arrayList2.add(new double[]{4.3d, 4.9d, 5.9d, 8.8d, 10.8d, 11.9d, 13.6d, 12.8d, 11.4d, 9.5d, 7.5d, 5.5d});
        addXYSeries(dataset, new String[]{"Sunshine hours"}, arrayList, arrayList2, 1);
        return ChartFactory.getCubicLineChartIntent(context, dataset, renderer, 0.3f, "Average temperature");
    }
}
