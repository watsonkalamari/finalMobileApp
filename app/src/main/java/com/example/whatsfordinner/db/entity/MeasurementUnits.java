package com.example.whatsfordinner.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "measurement_units")
public class MeasurementUnits {
    @PrimaryKey
    private int mUnitId;
    private String measurement_unit;

    public int getmUnitId() {
        return mUnitId;
    }

    public void setmUnitId(int mUnitId) {
        this.mUnitId = mUnitId;
    }

    public String getMeasurement() {
        return measurement_unit;
    }

    public void setMeasurement(String measurement) {
        this.measurement_unit = measurement;
    }
}
