package org.achartengine.model;

import java.io.Serializable;

public final class Point implements Serializable {

    /* renamed from: mX */
    private float f4055mX;

    /* renamed from: mY */
    private float f4056mY;

    public Point() {
    }

    public Point(float x, float y) {
        this.f4055mX = x;
        this.f4056mY = y;
    }

    public float getX() {
        return this.f4055mX;
    }

    public float getY() {
        return this.f4056mY;
    }

    public void setX(float x) {
        this.f4055mX = x;
    }

    public void setY(float y) {
        this.f4056mY = y;
    }
}
