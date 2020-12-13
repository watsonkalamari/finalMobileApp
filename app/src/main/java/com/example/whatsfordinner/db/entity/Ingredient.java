package com.example.whatsfordinner.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Recipe.class, parentColumns = "rid", childColumns = "recipe_id"))
public class Ingredient {
    @PrimaryKey
    @NonNull
    private Integer ingredient_id;
   // private List<Ingredient> ingredients=null;
    private String ingredient_name;

    @ColumnInfo(name="recipe_id")
    public int recipeId;

    public Ingredient(Integer id, String ingredient_name){
        this.ingredient_id =id;
        this.ingredient_name = ingredient_name;
    }
    public Integer getId() {
        return ingredient_id;
    }

    public void setId(Integer id) {
        this.ingredient_id = id;
    }
    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }


}
