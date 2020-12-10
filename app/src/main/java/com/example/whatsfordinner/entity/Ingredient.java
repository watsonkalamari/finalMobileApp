package com.example.whatsfordinner.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(foreignKeys = @ForeignKey(entity = Recipe.class, parentColumns = "rid", childColumns = "recipe_id"))
public class Ingredient {
    @PrimaryKey
    @NonNull
    private Integer ing_id;
   // private List<Ingredient> ingredients=null;
    private String name;

    @ColumnInfo(name="recipe_id")
    public int recipeId;

    public Ingredient(Integer id, String name){
        this.ing_id=id;
        this.name=name;
    }
    public Integer getId() {
        return ing_id;
    }

    public void setId(Integer id) {
        this.ing_id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
