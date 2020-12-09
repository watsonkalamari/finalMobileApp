package com.example.whatsfordinner.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.whatsfordinner.entity.Recipe;

import java.util.List;

@Dao
public interface RecipeDao {
    @Query("SELECT * FROM recipes")
    List<Recipe> getAll();

    @Query("SELECT * FROM recipes WHERE rid IN (:rid)")
    List<Recipe>loadAllByIds(int[] rid);


    @Insert
    void insertAll(Recipe recipes);

    @Delete
    void delete(Recipe recipe);
}
