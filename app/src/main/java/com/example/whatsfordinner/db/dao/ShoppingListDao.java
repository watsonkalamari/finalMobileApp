package com.example.whatsfordinner.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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

    //TODO::make a query that gets show all of the
    // ingredients that are attached to a specific user's shopping list
}
