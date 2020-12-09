package com.example.whatsfordinner.entity;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "recipes")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private Integer rid;

    @ColumnInfo(name="recipe_name")
    private String name;

    @ColumnInfo(name = "ingredient")

    @Embedded
    private Ingredient ingredient;
    private List<String> ingredientList=null;

    private String direction;
    private List<String> instructionList;

    @Ignore
    Bitmap picture;
    private boolean isSaved;

    public Recipe(){
        isSaved=false;
    }
    public Integer getUid(){
        return rid;
    }
    public void setUid(Integer rid){
        this.rid=rid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }


}
