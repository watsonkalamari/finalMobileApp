package com.example.whatsfordinner.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.db.entity.ShoppingList;

import java.util.List;

@Dao
public interface ShoppingListDao {
    @Insert
    void insert(ShoppingList shoppingList);

    @Update
    void update(ShoppingList shoppingList);

    @Delete
    void delete(ShoppingList shoppingList);


    @Query("DELETE FROM shopping_list")
    void deleteAll();

    @Query("SELECT * FROM shopping_list ORDER BY shopping_list_id ASC")
    LiveData<List<ShoppingList>> getAllShoppingList();

    @Query("SELECT DISTINCT ingredient.ingredient_id, ingredient.ingredient_name FROM measured_ingredients join shopping_list on shopping_list.recipe_id = measured_ingredients.recipe_id join ingredient on ingredient.ingredient_id=measured_ingredients.ingredient_id join users on users.uid = shopping_list.uid where users.logged_in=1")
    LiveData<List<Ingredient>> getUsersShoppingListIngredients();

    @Query("SELECT ingredient.ingredient_name FROM measured_ingredients join ingredient on ingredient.ingredient_id=measured_ingredients.ingredient_id join recipes on recipes.recipe_id=measured_ingredients.recipe_id where recipes.recipe_name like :recipe_name")
    LiveData<List<Ingredient>> getIngredientsForRecipes(String recipe_name);

    //TODO::make a query that gets show all of the
    // ingredients that are attached to a specific user's shopping list
}
