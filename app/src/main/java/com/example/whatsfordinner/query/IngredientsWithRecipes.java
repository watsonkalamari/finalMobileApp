package com.example.whatsfordinner.query;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.whatsfordinner.entity.Ingredient;
import com.example.whatsfordinner.entity.Recipe;
import com.example.whatsfordinner.entity.RecipeIngredientCrossReference;

import java.util.List;

public class IngredientsWithRecipes {
    @Embedded public Ingredient ingredient;
    @Relation(
            parentColumn = "ing_id",
            entityColumn = "rid",
            associateBy = @Junction(RecipeIngredientCrossReference.class)
    )
    public List<Recipe> recipes;
}
