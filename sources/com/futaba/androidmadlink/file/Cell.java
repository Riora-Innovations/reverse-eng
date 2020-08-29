package com.futaba.androidmadlink.file;

public class Cell {
    private int mIconId;
    private String mText;

    public Cell(String text, int iconId) {
        this.mText = text;
        this.mIconId = iconId;
    }

    public String getText() {
        return this.mText;
    }

    public int getIconId() {
        return this.mIconId;
    }
}
