package com.example.whatsfordinner.query;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.whatsfordinner.entity.Ingredient;
import com.example.whatsfordinner.entity.Recipe;
import com.example.whatsfordinner.entity.RecipeIngredientCrossReference;

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