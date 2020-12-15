package com.example.whatsfordinner.db.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_list",foreignKeys = {@ForeignKey(entity = User.class, parentColumns = "uid",childColumns = "uid"),
@ForeignKey(entity = Recipe.class,parentColumns = "recipe_id",childColumns = "recipe_id")})
public class ShoppingList {
    //TODO::create another entity that links the user's id with the ingredients

    @PrimaryKey(autoGenerate = true)
    private Integer shopping_list_id;
    private Integer uid;
    private Integer recipe_id;

    public Integer getShopping_list_id() {
        return shopping_list_id;
    }

    public void setShopping_list_id(Integer shopping_list_id) {
        this.shopping_list_id = shopping_list_id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(Integer recipe_id) {
        this.recipe_id = recipe_id;
    }


    //TODO::create antother Dao for this entity
    //TODO::attach that Dao to the database
    //TODO::attach that to the repository
    //TODO:: then attach it to the viewmodel
}
