package com.example.whatsfordinner.crossRef;

import androidx.room.Entity;

@Entity(primaryKeys = {"rid","ingredient_id"})
public class RecipeIngredientCrossReference {
    public int rid;
    public int ingredient_id;
}
