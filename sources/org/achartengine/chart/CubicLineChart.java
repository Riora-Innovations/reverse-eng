package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.List;
import org.achartengine.model.Point;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

public class CubicLineChart extends LineChart {
    public static final String TYPE = "Cubic";
    private float firstMultiplier;

    /* renamed from: p1 */
    private Point f4044p1;

    /* renamed from: p2 */
    private Point f4045p2;

    /* renamed from: p3 */
    private Point f4046p3;
    private float secondMultiplier;

    public CubicLineChart() {
        this.f4044p1 = new Point();
        this.f4045p2 = new Point();
        this.f4046p3 = new Point();
        this.firstMultiplier = 0.33f;
        this.secondMultiplier = 1.0f - this.firstMultiplier;
    }

    public CubicLineChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer, float smoothness) {
        super(dataset, renderer);
        this.f4044p1 = new Point();
        this.f4045p2 = new Point();
        this.f4046p3 = new Point();
        this.firstMultiplier = smoothness;
        this.secondMultiplier = 1.0f - this.firstMultiplier;
    }

    /* access modifiers changed from: protected */
    public void drawPath(Canvas canvas, List<Float> points, Paint paint, boolean circular) {
        int nextIndex;
        int nextNextIndex;
        Path p = new Path();
        p.moveTo(((Float) points.get(0)).floatValue(), ((Float) points.get(1)).floatValue());
        int length = points.size();
        if (circular) {
            length -= 4;
        }
        for (int i = 0; i < length; i += 2) {
            if (i + 2 < length) {
                nextIndex = i + 2;
            } else {
                nextIndex = i;
            }
            if (i + 4 < length) {
                nextNextIndex = i + 4;
            } else {
                nextNextIndex = nextIndex;
            }
            calc(points, this.f4044p1, i, nextIndex, this.secondMultiplier);
            this.f4045p2.setX(((Float) points.get(nextIndex)).floatValue());
            this.f4045p2.setY(((Float) points.get(nextIndex + 1)).floatValue());
            calc(points, this.f4046p3, nextIndex, nextNextIndex, this.firstMultiplier);
            p.cubicTo(this.f4044p1.getX(), this.f4044p1.getY(), this.f4045p2.getX(), this.f4045p2.getY(), this.f4046p3.getX(), this.f4046p3.getY());
        }
        if (circular) {
            for (int i2 = length; i2 < length + 4; i2 += 2) {
                Path path = p;
                path.lineTo(((Float) points.get(i2)).floatValue(), ((Float) points.get(i2 + 1)).floatValue());
            }
            p.lineTo(((Float) points.get(0)).floatValue(), ((Float) points.get(1)).floatValue());
        }
        canvas.drawPath(p, paint);
    }

    private void calc(List<Float> points, Point result, int index1, int index2, float multiplier) {
        float p1x = ((Float) points.get(index1)).floatValue();
        float p1y = ((Float) points.get(index1 + 1)).floatValue();
        float diffY = ((Float) points.get(index2 + 1)).floatValue() - p1y;
        result.setX(((((Float) points.get(index2)).floatValue() - p1x) * multiplier) + p1x);
        result.setY((diffY * multiplier) + p1y);
    }

    public String getChartType() {
        return TYPE;
    }
}
