package org.achartengine.renderer;

import java.util.ArrayList;
import java.util.List;
import org.achartengine.chart.PointStyle;

public class XYSeriesRenderer extends SimpleSeriesRenderer {
    private List<FillOutsideLine> mFillBelowLine = new ArrayList();
    private boolean mFillPoints = false;
    private float mLineWidth = 1.0f;
    private float mPointStrokeWidth = 1.0f;
    private PointStyle mPointStyle = PointStyle.POINT;

    public enum FillOutsideLine {
        NONE,
        BOUNDS_ALL,
        BOUNDS_BELOW,
        BOUNDS_ABOVE,
        BELOW,
        ABOVE;
        
        private int mColor;

        public int getColor() {
            return this.mColor;
        }

        public void setColor(int color) {
            this.mColor = color;
        }
    }

    @Deprecated
    public boolean isFillBelowLine() {
        return this.mFillBelowLine.size() > 0;
    }

    @Deprecated
    public void setFillBelowLine(boolean fill) {
        this.mFillBelowLine.clear();
        if (fill) {
            this.mFillBelowLine.add(FillOutsideLine.BOUNDS_ALL);
        } else {
            this.mFillBelowLine.add(FillOutsideLine.NONE);
        }
    }

    public FillOutsideLine[] getFillOutsideLine() {
        return (FillOutsideLine[]) this.mFillBelowLine.toArray(new FillOutsideLine[0]);
    }

    public void addFillOutsideLine(FillOutsideLine fill) {
        this.mFillBelowLine.add(fill);
    }

    public boolean isFillPoints() {
        return this.mFillPoints;
    }

    public void setFillPoints(boolean fill) {
        this.mFillPoints = fill;
    }

    @Deprecated
    public void setFillBelowLineColor(int color) {
        if (this.mFillBelowLine.size() > 0) {
            ((FillOutsideLine) this.mFillBelowLine.get(0)).setColor(color);
        }
    }

    public PointStyle getPointStyle() {
        return this.mPointStyle;
    }

    public void setPointStyle(PointStyle style) {
        this.mPointStyle = style;
    }

    public float getPointStrokeWidth() {
        return this.mPointStrokeWidth;
    }

    public void setPointStrokeWidth(float strokeWidth) {
        this.mPointStrokeWidth = strokeWidth;
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.mLineWidth = lineWidth;
    }
}
