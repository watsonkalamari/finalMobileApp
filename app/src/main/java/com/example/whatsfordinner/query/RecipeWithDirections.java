package com.example.whatsfordinner.query;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.whatsfordinner.db.entity.Direction;
import com.example.whatsfordinner.db.entity.Recipe;

public class RecipeWithDirections {
    @Embedded public Recipe recipe;
    @Relation(
            parentColumn = "recipe_id",
            entityColumn = "recipe_id"
    )
    public Direction direction;
}
