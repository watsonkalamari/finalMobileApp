package com.example.whatsfordinner.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "measurement_units")
public class MeasurementUnits {
    @PrimaryKey
    private int measurement_unit_id;
    private String unit_description;

    public int getMeasurement_unit_id() {
        return measurement_unit_id;
    }

    public void setMeasurement_unit_id(int measurement_unit_id) {
        this.measurement_unit_id = measurement_unit_id;
    }


    public String getUnit_description() {
        return unit_description;
    }

    public void setUnit_description(String unit_description) {
        this.unit_description = unit_description;
    }
}
