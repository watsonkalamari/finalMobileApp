package com.example.whatsfordinner.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredient")
public class Ingredient {
    @PrimaryKey
    @NonNull
    private Integer ingredient_id;
   // private List<Ingredient> ingredients=null;
    private String ingredient_name;
  /*  public int recipe_id;*/

   /* public Ingredient(Integer id, Integer recipe_id, String ingredient_name){
        this.ingredient_id =id;
        this.recipe_id=recipe_id;
        this.ingredient_name = ingredient_name;
    }*/

    public void setId(Integer id) {
        this.ingredient_id = id;
    }
    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    @NonNull
    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(@NonNull Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
}
