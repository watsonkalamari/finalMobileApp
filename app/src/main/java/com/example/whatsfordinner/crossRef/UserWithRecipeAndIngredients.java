/*package com.example.whatsfordinner.crossRef;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.db.entity.User;
import com.example.whatsfordinner.query.RecipesWithIngredients;

import java.util.List;

public class UserWithRecipeAndIngredients {
    @Embedded public User user;
    @Relation(
            entity = Recipe.class,
            parentColumn = "uid",
            entityColumn = "userSavedId"
    )
    public List<RecipesWithIngredients> recipes;
}*/
