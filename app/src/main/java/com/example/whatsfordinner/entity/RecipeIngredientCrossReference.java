package com.example.whatsfordinner.entity;

import androidx.room.Entity;

@Entity(primaryKeys = {"rid","ing_id"})
public class RecipeIngredientCrossReference {
    public int rid;
    public int ing_id;
}
