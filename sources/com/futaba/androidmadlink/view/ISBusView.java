package com.futaba.androidmadlink.view;

import java.util.List;

public interface ISBusView {
    String getAttributes();

    int getCol();

    DataTypes getDataType();

    int getPage();

    int getRow();

    String getSensorTitle();

    SensorTypes getSensorType();

    int getSlot();

    int getSlotCount();

    void reset();

    void setAttributes(String str);

    void setCol(int i);

    void setData(byte[] bArr);

    void setISWriteLog(boolean z);

    void setLogFileName(String str);

    void setPage(int i);

    void setRow(int i);

    void setSensorTitle(String str);

    void setSensorType(SensorTypes sensorTypes);

    void setSensorValue(List<Object> list);
}
