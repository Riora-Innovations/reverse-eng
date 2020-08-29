package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import java.util.ArrayList;
import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.BubbleChart;
import org.achartengine.chart.CubicLineChart;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.model.XYValueSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class CombinedTemperatureChart extends AbstractDemoChart {
    public String getName() {
        return "Combined temperature";
    }

    public String getDesc() {
        return "The average temperature in 2 Greek islands, water temperature and sun shine hours (combined chart)";
    }

    public Intent execute(Context context) {
        String[] titles = {"Crete Air Temperature", "Skiathos Air Temperature"};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < titles.length; i++) {
            arrayList.add(new double[]{1.0d, 2.0d, 3.0d, 4.0d, 5.0d, 6.0d, 7.0d, 8.0d, 9.0d, 10.0d, 11.0d, 12.0d});
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new double[]{12.3d, 12.5d, 13.8d, 16.8d, 20.4d, 24.4d, 26.4d, 26.1d, 23.6d, 20.3d, 17.2d, 13.9d});
        arrayList2.add(new double[]{9.0d, 10.0d, 11.0d, 15.0d, 19.0d, 23.0d, 26.0d, 25.0d, 22.0d, 18.0d, 13.0d, 10.0d});
        XYMultipleSeriesRenderer renderer = buildRenderer(new int[]{-16711936, Color.rgb(200, 150, 0)}, new PointStyle[]{PointStyle.CIRCLE, PointStyle.DIAMOND});
        renderer.setPointSize(5.5f);
        int length = renderer.getSeriesRendererCount();
        for (int i2 = 0; i2 < length; i2++) {
            XYSeriesRenderer r = (XYSeriesRenderer) renderer.getSeriesRendererAt(i2);
            r.setLineWidth(5.0f);
            r.setFillPoints(true);
        }
        setChartSettings(renderer, "Weather data", "Month", "Temperature", 0.5d, 12.5d, 0.0d, 40.0d, DefaultRenderer.TEXT_COLOR, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(12);
        renderer.setYLabels(10);
        renderer.setShowGrid(true);
        renderer.setXLabelsAlign(Align.RIGHT);
        renderer.setYLabelsAlign(Align.RIGHT);
        renderer.setZoomButtonsVisible(true);
        renderer.setPanLimits(new double[]{-10.0d, 20.0d, -10.0d, 40.0d});
        renderer.setZoomLimits(new double[]{-10.0d, 20.0d, -10.0d, 40.0d});
        XYValueSeries sunSeries = new XYValueSeries("Sunshine hours");
        sunSeries.add(1.0d, 35.0d, 4.3d);
        sunSeries.add(2.0d, 35.0d, 4.9d);
        sunSeries.add(3.0d, 35.0d, 5.9d);
        sunSeries.add(4.0d, 35.0d, 8.8d);
        sunSeries.add(5.0d, 35.0d, 10.8d);
        sunSeries.add(6.0d, 35.0d, 11.9d);
        sunSeries.add(7.0d, 35.0d, 13.6d);
        sunSeries.add(8.0d, 35.0d, 12.8d);
        sunSeries.add(9.0d, 35.0d, 11.4d);
        sunSeries.add(10.0d, 35.0d, 9.5d);
        sunSeries.add(11.0d, 35.0d, 7.5d);
        sunSeries.add(12.0d, 35.0d, 5.5d);
        XYSeriesRenderer lightRenderer = new XYSeriesRenderer();
        lightRenderer.setColor(-256);
        XYSeries xYSeries = new XYSeries("Water Temperature");
        xYSeries.add(1.0d, 16.0d);
        xYSeries.add(2.0d, 15.0d);
        xYSeries.add(3.0d, 16.0d);
        xYSeries.add(4.0d, 17.0d);
        xYSeries.add(5.0d, 20.0d);
        xYSeries.add(6.0d, 23.0d);
        xYSeries.add(7.0d, 25.0d);
        xYSeries.add(8.0d, 25.5d);
        xYSeries.add(9.0d, 26.5d);
        xYSeries.add(10.0d, 24.0d);
        xYSeries.add(11.0d, 22.0d);
        xYSeries.add(12.0d, 18.0d);
        renderer.setBarSpacing(0.5d);
        XYSeriesRenderer waterRenderer = new XYSeriesRenderer();
        waterRenderer.setColor(Color.argb(250, 0, 210, 250));
        XYMultipleSeriesDataset dataset = buildDataset(titles, arrayList, arrayList2);
        dataset.addSeries(0, sunSeries);
        dataset.addSeries(0, xYSeries);
        renderer.addSeriesRenderer(0, lightRenderer);
        renderer.addSeriesRenderer(0, waterRenderer);
        waterRenderer.setDisplayChartValues(true);
        waterRenderer.setChartValuesTextSize(10.0f);
        return ChartFactory.getCombinedXYChartIntent(context, dataset, renderer, new String[]{BarChart.TYPE, BubbleChart.TYPE, LineChart.TYPE, CubicLineChart.TYPE}, "Weather parameters");
    }
}
