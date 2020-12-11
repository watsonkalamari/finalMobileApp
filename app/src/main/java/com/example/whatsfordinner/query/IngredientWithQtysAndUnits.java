package com.example.whatsfordinner.query;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.db.entity.MeasurementQty;

import java.util.List;

public class IngredientWithQtysAndUnits {
    @Embedded public Ingredient ingredient;
    @Relation(
            entity = MeasurementQty.class,
            parentColumn = "ing_id",
            entityColumn = "ing_id"
    )
    public List<QtyWithUnits> qty;
}
