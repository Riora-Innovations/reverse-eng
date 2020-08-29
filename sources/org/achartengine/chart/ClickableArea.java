package org.achartengine.chart;

import android.graphics.RectF;

public class ClickableArea {
    private RectF rect;

    /* renamed from: x */
    private double f4042x;

    /* renamed from: y */
    private double f4043y;

    public ClickableArea(RectF rect2, double x, double y) {
        this.rect = rect2;
        this.f4042x = x;
        this.f4043y = y;
    }

    public RectF getRect() {
        return this.rect;
    }

    public double getX() {
        return this.f4042x;
    }

    public double getY() {
        return this.f4043y;
    }
}
