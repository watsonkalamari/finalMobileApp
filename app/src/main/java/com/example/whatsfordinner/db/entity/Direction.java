package com.example.whatsfordinner.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "directions",foreignKeys = @ForeignKey(entity = Recipe.class, parentColumns = "recipe_id", childColumns = "recipe_id"))
public class Direction {
    @PrimaryKey
    private Integer direction_id;
    private Integer recipe_id;
    @ColumnInfo(name = "Step_number")
    private Integer step_number;
    private String direction_description;

    public Integer getDirection_id() {
        return direction_id;
    }

    public void setDirection_id(Integer direction_id) {
        this.direction_id = direction_id;
    }

    public Integer getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Integer recipe_id) {
        this.recipe_id = recipe_id;
    }

    public Integer getStep_number() {
        return step_number;
    }

    public void setStep_number(Integer step_number) {
        this.step_number = step_number;
    }

    public String getDirection_description() {
        return direction_description;
    }

    public void setDirection_description(String direction_description) {
        this.direction_description = direction_description;
    }
}
