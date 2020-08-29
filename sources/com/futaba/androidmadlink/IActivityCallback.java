package com.futaba.androidmadlink;

public interface IActivityCallback {
    void onBusy();

    void onChangeTitle(String str);

    void onIdle();
}
