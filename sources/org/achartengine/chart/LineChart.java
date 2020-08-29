package org.achartengine.chart;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer.FillOutsideLine;

public class LineChart extends XYChart {

    /* renamed from: $SWITCH_TABLE$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine */
    private static /* synthetic */ int[] f4047x26b8a26 = null;
    private static final int SHAPE_WIDTH = 30;
    public static final String TYPE = "Line";
    private ScatterChart pointsChart;

    /* renamed from: $SWITCH_TABLE$org$achartengine$renderer$XYSeriesRenderer$FillOutsideLine */
    static /* synthetic */ int[] m4600x26b8a26() {
        int[] iArr = f4047x26b8a26;
        if (iArr == null) {
            iArr = new int[FillOutsideLine.values().length];
            try {
                iArr[FillOutsideLine.ABOVE.ordinal()] = 6;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FillOutsideLine.BELOW.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FillOutsideLine.BOUNDS_ABOVE.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FillOutsideLine.BOUNDS_ALL.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[FillOutsideLine.BOUNDS_BELOW.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[FillOutsideLine.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            f4047x26b8a26 = iArr;
        }
        return iArr;
    }

    LineChart() {
    }

    public LineChart(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        super(dataset, renderer);
        this.pointsChart = new ScatterChart(dataset, renderer);
    }

    /* access modifiers changed from: protected */
    public void setDatasetRenderer(XYMultipleSeriesDataset dataset, XYMultipleSeriesRenderer renderer) {
        super.setDatasetRenderer(dataset, renderer);
        this.pointsChart = new ScatterChart(dataset, renderer);
    }

    public void drawSeries(Canvas canvas, Paint paint, List<Float> points, SimpleSeriesRenderer seriesRenderer, float yAxisValue, int seriesIndex, int startIndex) {
        float referencePoint;
        XYSeriesRenderer renderer = (XYSeriesRenderer) seriesRenderer;
        float lineWidth = paint.getStrokeWidth();
        paint.setStrokeWidth(renderer.getLineWidth());
        FillOutsideLine[] fillOutsideLine = renderer.getFillOutsideLine();
        int length = fillOutsideLine.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                paint.setColor(seriesRenderer.getColor());
                paint.setStyle(Style.STROKE);
                drawPath(canvas, points, paint, false);
                paint.setStrokeWidth(lineWidth);
                return;
            }
            FillOutsideLine fill = fillOutsideLine[i2];
            if (fill != FillOutsideLine.NONE) {
                paint.setColor(fill.getColor());
                List<Float> fillPoints = new ArrayList<>(points);
                switch (m4600x26b8a26()[fill.ordinal()]) {
                    case 2:
                        referencePoint = yAxisValue;
                        break;
                    case 3:
                        referencePoint = yAxisValue;
                        break;
                    case 4:
                        referencePoint = yAxisValue;
                        break;
                    case 5:
                        referencePoint = (float) canvas.getHeight();
                        break;
                    case 6:
                        referencePoint = 0.0f;
                        break;
                    default:
                        throw new RuntimeException("You have added a new type of filling but have not implemented.");
                }
                if (fill == FillOutsideLine.BOUNDS_ABOVE || fill == FillOutsideLine.BOUNDS_BELOW) {
                    List<Float> boundsPoints = new ArrayList<>();
                    boolean add = false;
                    if ((fill == FillOutsideLine.BOUNDS_ABOVE && ((Float) fillPoints.get(1)).floatValue() < referencePoint) || (fill == FillOutsideLine.BOUNDS_BELOW && ((Float) fillPoints.get(1)).floatValue() > referencePoint)) {
                        boundsPoints.add((Float) fillPoints.get(0));
                        boundsPoints.add((Float) fillPoints.get(1));
                        add = true;
                    }
                    int i3 = 3;
                    while (i3 < fillPoints.size()) {
                        float prevValue = ((Float) fillPoints.get(i3 - 2)).floatValue();
                        float value = ((Float) fillPoints.get(i3)).floatValue();
                        if ((prevValue < referencePoint && value > referencePoint) || (prevValue > referencePoint && value < referencePoint)) {
                            float prevX = ((Float) fillPoints.get(i3 - 3)).floatValue();
                            float x = ((Float) fillPoints.get(i3 - 1)).floatValue();
                            boundsPoints.add(Float.valueOf((((x - prevX) * (referencePoint - prevValue)) / (value - prevValue)) + prevX));
                            boundsPoints.add(Float.valueOf(referencePoint));
                            if ((fill != FillOutsideLine.BOUNDS_ABOVE || value <= referencePoint) && (fill != FillOutsideLine.BOUNDS_BELOW || value >= referencePoint)) {
                                boundsPoints.add(Float.valueOf(x));
                                boundsPoints.add(Float.valueOf(value));
                                add = true;
                            } else {
                                i3 += 2;
                                add = false;
                            }
                        } else if (add || ((fill == FillOutsideLine.BOUNDS_ABOVE && value < referencePoint) || (fill == FillOutsideLine.BOUNDS_BELOW && value > referencePoint))) {
                            boundsPoints.add((Float) fillPoints.get(i3 - 1));
                            boundsPoints.add(Float.valueOf(value));
                        }
                        i3 += 2;
                    }
                    fillPoints.clear();
                    fillPoints.addAll(boundsPoints);
                }
                int length2 = fillPoints.size();
                fillPoints.set(0, Float.valueOf(((Float) fillPoints.get(0)).floatValue() + 1.0f));
                fillPoints.add((Float) fillPoints.get(length2 - 2));
                fillPoints.add(Float.valueOf(referencePoint));
                fillPoints.add((Float) fillPoints.get(0));
                fillPoints.add((Float) fillPoints.get(length2 + 1));
                for (int i4 = 0; i4 < length2 + 4; i4 += 2) {
                    if (((Float) fillPoints.get(i4 + 1)).floatValue() < 0.0f) {
                        fillPoints.set(i4 + 1, Float.valueOf(0.0f));
                    }
                }
                paint.setStyle(Style.FILL);
                drawPath(canvas, fillPoints, paint, true);
            }
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: protected */
    public ClickableArea[] clickableAreasForPoints(List<Float> points, List<Double> values, float yAxisValue, int seriesIndex, int startIndex) {
        int length = points.size();
        ClickableArea[] ret = new ClickableArea[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            int selectableBuffer = this.mRenderer.getSelectableBuffer();
            ret[i / 2] = new ClickableArea(new RectF(((Float) points.get(i)).floatValue() - ((float) selectableBuffer), ((Float) points.get(i + 1)).floatValue() - ((float) selectableBuffer), ((float) selectableBuffer) + ((Float) points.get(i)).floatValue(), ((Float) points.get(i + 1)).floatValue() + ((float) selectableBuffer)), ((Double) values.get(i)).doubleValue(), ((Double) values.get(i + 1)).doubleValue());
        }
        return ret;
    }

    public int getLegendShapeWidth(int seriesIndex) {
        return SHAPE_WIDTH;
    }

    public void drawLegendShape(Canvas canvas, SimpleSeriesRenderer renderer, float x, float y, int seriesIndex, Paint paint) {
        canvas.drawLine(x, y, x + 30.0f, y, paint);
        if (isRenderPoints(renderer)) {
            this.pointsChart.drawLegendShape(canvas, renderer, x + 5.0f, y, seriesIndex, paint);
        }
    }

    public boolean isRenderPoints(SimpleSeriesRenderer renderer) {
        return ((XYSeriesRenderer) renderer).getPointStyle() != PointStyle.POINT;
    }

    public ScatterChart getPointsChart() {
        return this.pointsChart;
    }

    public String getChartType() {
        return TYPE;
    }
}
