package com.example.whatsfordinner.query;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.whatsfordinner.db.entity.MeasurementQty;
import com.example.whatsfordinner.db.entity.Recipe;

public class RecipeWithMeasuredIngredients {
    @Embedded
    public Recipe recipe;
    @Relation(
            parentColumn = "recipe_id",
            entityColumn="recipe_id"
    )
    public MeasurementQty measurementQty;
}
