package com.example.whatsfordinner.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.query.IngredientWithQtysAndUnits;
import com.example.whatsfordinner.query.IngredientsWithRecipes;
import com.example.whatsfordinner.query.RecipeWithMeasuredIngredients;
import com.example.whatsfordinner.query.RecipesWithIngredients;

import java.util.List;

@Dao
public interface RecipeDao {
    @Insert
    void insert(Recipe recipe);

    @Update
    void update(Recipe recipe);

    @Delete
    void delete(Recipe recipe);

    @Query("DELETE FROM RECIPES")
    void deleteAllNotes();

    @Query("SELECT * FROM recipes ORDER BY rid ASC")
    LiveData<List<Recipe>> getAllRecipes();



    @Query("SELECT * FROM recipes WHERE rid IN (:rid)")
    List<Recipe> loadAllByIds(int[] rid);

    @Transaction
    @Query("SELECT * FROM Ingredient")
    public List<IngredientWithQtysAndUnits> getIngredientsWithQtyAndUnits();

    @Transaction
    @Query("SELECT * FROM RECIPES")
    public List<RecipesWithIngredients> getRecipesWithIngredients();

    @Transaction
    @Query("SELECT * FROM INGREDIENT")
    public List<IngredientsWithRecipes> getIngredientsWithRecipes();

    @Transaction
    @Query("SELECT * FROM RECIPES")
    public List<RecipeWithMeasuredIngredients> getRecipesWithMeasuredIngredients();

    @Transaction
    @Query("SELECT * FROM RECIPES")

    /* @Transaction
     @Query("SELECT * FROM user")
     public List<UserWithRecipeAndIngredients> getUsersWithRecipesAndIngredients();*/
    @Insert
    void insertAll(Recipe recipes);

    @Query("DELETE FROM recipes")
    void deleteAll();


}
