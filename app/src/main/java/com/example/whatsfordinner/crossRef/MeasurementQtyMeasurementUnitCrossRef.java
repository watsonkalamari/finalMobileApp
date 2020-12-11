package com.example.whatsfordinner.crossRef;

import androidx.room.Entity;

@Entity(primaryKeys = {"mQtyId","mUnitId"})
public class MeasurementQtyMeasurementUnitCrossRef {
    public int mQtyId;
    public int mUnitId;
}
