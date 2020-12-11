package com.example.whatsfordinner.query;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.crossRef.RecipeIngredientCrossReference;

import java.util.List;

public class RecipesWithIngredients {
    @Embedded public Recipe recipe;
    @Relation(
            parentColumn = "rid",
            entityColumn = "ing_id",
            associateBy = @Junction(RecipeIngredientCrossReference.class)
    )
    public List<Ingredient> ingredients;
}