package com.example.whatsfordinner.query;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.whatsfordinner.crossRef.MeasurementQtyMeasurementUnitCrossRef;
import com.example.whatsfordinner.db.entity.MeasurementQty;
import com.example.whatsfordinner.db.entity.MeasurementUnits;

import java.util.List;

public class QtyWithUnits {
    @Embedded public MeasurementQty measurementQty;
    @Relation(
            parentColumn = "mQtyId",
            entityColumn = "mUnitId",
            associateBy = @Junction(MeasurementQtyMeasurementUnitCrossRef.class)
    )
    public List<MeasurementUnits> measurementUnits;
}
