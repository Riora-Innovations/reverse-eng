package org.achartengine.chartdemo.demo.chart;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Date;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class ProjectStatusChart extends AbstractDemoChart {
    public String getName() {
        return "Project tickets status";
    }

    public String getDesc() {
        return "The opened tickets and the fixed tickets (time chart)";
    }

    public Intent execute(Context context) {
        String[] titles = {"New tickets", "Fixed tickets"};
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = titles.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(new Date[12]);
            ((Date[]) arrayList.get(i))[0] = new Date(108, 9, 1);
            ((Date[]) arrayList.get(i))[1] = new Date(108, 9, 8);
            ((Date[]) arrayList.get(i))[2] = new Date(108, 9, 15);
            ((Date[]) arrayList.get(i))[3] = new Date(108, 9, 22);
            ((Date[]) arrayList.get(i))[4] = new Date(108, 9, 29);
            ((Date[]) arrayList.get(i))[5] = new Date(108, 10, 5);
            ((Date[]) arrayList.get(i))[6] = new Date(108, 10, 12);
            ((Date[]) arrayList.get(i))[7] = new Date(108, 10, 19);
            ((Date[]) arrayList.get(i))[8] = new Date(108, 10, 26);
            ((Date[]) arrayList.get(i))[9] = new Date(108, 11, 3);
            ((Date[]) arrayList.get(i))[10] = new Date(108, 11, 10);
            ((Date[]) arrayList.get(i))[11] = new Date(108, 11, 17);
        }
        arrayList2.add(new double[]{142.0d, 123.0d, 142.0d, 152.0d, 149.0d, 122.0d, 110.0d, 120.0d, 125.0d, 155.0d, 146.0d, 150.0d});
        arrayList2.add(new double[]{102.0d, 90.0d, 112.0d, 105.0d, 125.0d, 112.0d, 125.0d, 112.0d, 105.0d, 115.0d, 116.0d, 135.0d});
        int length2 = ((double[]) arrayList2.get(0)).length;
        XYMultipleSeriesRenderer renderer = buildRenderer(new int[]{-16776961, -16711936}, new PointStyle[]{PointStyle.POINT, PointStyle.POINT});
        setChartSettings(renderer, "Project work status", "Date", "Tickets", (double) ((Date[]) arrayList.get(0))[0].getTime(), (double) ((Date[]) arrayList.get(0))[11].getTime(), 50.0d, 190.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setXLabels(0);
        renderer.setYLabels(10);
        renderer.addYTextLabel(100.0d, "test");
        int length3 = renderer.getSeriesRendererCount();
        for (int i2 = 0; i2 < length3; i2++) {
            renderer.getSeriesRendererAt(i2).setDisplayChartValues(true);
        }
        renderer.setXRoundedLabels(false);
        return ChartFactory.getTimeChartIntent(context, buildDateDataset(titles, arrayList, arrayList2), renderer, "MM/dd/yyyy");
    }
}
