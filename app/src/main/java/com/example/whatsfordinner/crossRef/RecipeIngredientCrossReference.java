package com.example.whatsfordinner.crossRef;

import androidx.room.Entity;

@Entity(primaryKeys = {"rid","ing_id"})
public class RecipeIngredientCrossReference {
    public int rid;
    public int ing_id;
}
