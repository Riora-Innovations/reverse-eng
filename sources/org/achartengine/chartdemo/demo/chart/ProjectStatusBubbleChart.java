package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import org.achartengine.ChartFactory;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYValueSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class ProjectStatusBubbleChart extends AbstractDemoChart {
    public String getName() {
        return "Project tickets status";
    }

    public String getDesc() {
        return "The opened tickets and the fixed tickets (bubble chart)";
    }

    public Intent execute(Context context) {
        XYMultipleSeriesDataset series = new XYMultipleSeriesDataset();
        XYValueSeries newTicketSeries = new XYValueSeries("New Tickets");
        newTicketSeries.add(1.0d, 2.0d, 14.0d);
        newTicketSeries.add(2.0d, 2.0d, 12.0d);
        newTicketSeries.add(3.0d, 2.0d, 18.0d);
        newTicketSeries.add(4.0d, 2.0d, 5.0d);
        newTicketSeries.add(5.0d, 2.0d, 1.0d);
        series.addSeries(newTicketSeries);
        XYValueSeries fixedTicketSeries = new XYValueSeries("Fixed Tickets");
        fixedTicketSeries.add(1.0d, 1.0d, 7.0d);
        fixedTicketSeries.add(2.0d, 1.0d, 4.0d);
        fixedTicketSeries.add(3.0d, 1.0d, 18.0d);
        fixedTicketSeries.add(4.0d, 1.0d, 3.0d);
        fixedTicketSeries.add(5.0d, 1.0d, 1.0d);
        series.addSeries(fixedTicketSeries);
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
        XYSeriesRenderer newTicketRenderer = new XYSeriesRenderer();
        newTicketRenderer.setColor(-16776961);
        renderer.addSeriesRenderer(newTicketRenderer);
        XYSeriesRenderer fixedTicketRenderer = new XYSeriesRenderer();
        fixedTicketRenderer.setColor(-16711936);
        renderer.addSeriesRenderer(fixedTicketRenderer);
        setChartSettings(renderer, "Project work status", "Priority", "", 0.5d, 5.5d, 0.0d, 5.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(7);
        renderer.setYLabels(0);
        renderer.setShowGrid(false);
        return ChartFactory.getBubbleChartIntent(context, series, renderer, "Project tickets");
    }
}
