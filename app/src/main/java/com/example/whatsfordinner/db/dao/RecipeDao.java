package com.example.whatsfordinner.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.whatsfordinner.db.entity.Recipe;
/*import com.example.whatsfordinner.query.RecipeWithMeasuredIngredients;
import com.example.whatsfordinner.query.RecipesWithIngredients;*/

import java.util.List;

@Dao
public interface RecipeDao {
    @Insert
    void insert(Recipe recipe);

    @Update
    void update(Recipe recipe);

    @Delete
    void delete(Recipe recipe);

 /*   @Query("DELETE FROM RECIPES")
    void deleteAllNotes();
*/
    @Query("SELECT * FROM recipes ORDER BY recipe_id ASC")
    LiveData<List<Recipe>> getAllRecipes();


    //TODO::make the connection in the repository and view model -- if applicable
    @Query(" SELECT recipes.recipe_name, recipes.recipe_description, recipes.recipe_image FROM measured_ingredients JOIN recipes on recipes.recipe_id = measured_ingredients.recipe_id join ingredient on ingredient.ingredient_id=measured_ingredients.ingredient_id WHERE ingredient.ingredient_name like '%[:ingredient_name]%'")
    LiveData<List<Recipe>> getRecipeInfo(String ingredient_name);

    //TODO::add the other queries that are going to be needed for the display recipe fragment
    @Query("SELECT * FROM recipes WHERE recipe_id IN (:recipe_id)")
    List<Recipe> loadAllByIds(int[] recipe_id);

    @Query("DELETE FROM recipes")
    void deleteAll();


}
