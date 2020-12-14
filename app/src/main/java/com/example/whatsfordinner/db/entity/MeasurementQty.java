package com.example.whatsfordinner.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "measured_ingredients", foreignKeys ={
        @ForeignKey(entity = Recipe.class, parentColumns = "recipe_id", childColumns ="recipe_id" ),
        @ForeignKey(entity = Ingredient.class, parentColumns = "ingredient_id", childColumns = "ingredient_id"),
        @ForeignKey(entity = MeasurementUnits.class, parentColumns = "measurement_unit_id", childColumns = "measurement_unit_id")})
public class MeasurementQty {
    //TODO::change the name

    @NotNull
    @PrimaryKey
    private int measured_ingredients_id;
    private int recipe_id;
    private String measurement_qty;
    private String measurement_unit_id;
    private int ingredient_id;


    public int getMeasured_ingredients_id() {
        return measured_ingredients_id;
    }

    public void setMeasured_ingredients_id(@NotNull int measured_ingredients_id) {
        this.measured_ingredients_id = measured_ingredients_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(@NotNull int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getMeasurement_qty() {
        return measurement_qty;
    }

    public void setMeasurement_qty(String measurement_qty) {
        this.measurement_qty = measurement_qty;
    }

    public String getMeasurement_unit_id() {
        return measurement_unit_id;
    }

    public void setMeasurement_unit_id(String measurement_unit_id) {
        this.measurement_unit_id = measurement_unit_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(@NotNull int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}
