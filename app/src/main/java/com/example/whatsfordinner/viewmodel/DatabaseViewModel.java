package com.example.whatsfordinner.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.whatsfordinner.Adapter.SearchListAdapter;
import com.example.whatsfordinner.MainActivity;
import com.example.whatsfordinner.db.AppDatabase;
import com.example.whatsfordinner.db.entity.Ingredient;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.db.entity.ShoppingList;
import com.example.whatsfordinner.db.entity.User;
import com.example.whatsfordinner.repository.DataRepository;

import java.util.List;

public class DatabaseViewModel extends AndroidViewModel {

    private DataRepository repository;
    private LiveData<List<Recipe>> allRecipes;
    private LiveData<List<ShoppingList>> allShoppingLists;
    private LiveData<List<User>> allUsers;
    private LiveData<List<User>> currentUser;
    private LiveData<List<Ingredient>> allIngredients;
    private LiveData<List<Recipe>> searchResultRecipes;


    public DatabaseViewModel(Application application) {
        super(application);

        repository = new DataRepository(application);
        allRecipes = repository.getAllRecipes();
        allIngredients = repository.getUsersShoppingListIngredients();
        searchResultRecipes = repository.getSearchResultRecipes();

        //TODO::add the one for the users
    }


    //Users
    //TODO:: add the getAllUsers()
    //TODO:: add the insert,update,delete, and deleteAll functions for the users.
    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public LiveData<List<User>> currentUser() {
        return currentUser;
    }

    //Recipes
    public void insert(Recipe recipe) {
        repository.insert(recipe);
    }

    public void update(Recipe recipe) {
        repository.update(recipe);
    }

    public void delete(Recipe recipe) {
        repository.delete(recipe);
    }

    public void deleteAllRecipes() {
        repository.deleteAllRecipes();
    }

    public LiveData<List<Recipe>> getAllRecipes() {
        return allRecipes;
    }

    //Shoppping List
    public void insertShoppingListItem(ShoppingList shoppingList) {
        repository.insert(shoppingList);
    }

    public void updateShoppingListItems(ShoppingList shoppingList) {
        repository.update(shoppingList);
    }

    public void deleteShoppingListItems(ShoppingList shoppingList) {
        repository.delete(shoppingList);
    }

    public void deleteAllShoppingListItems() {
        repository.deleteAllShoppingList();
    }

    public LiveData<List<ShoppingList>> getAllShoppingLists() {
        return allShoppingLists;
    }

    public LiveData<List<Ingredient>> getUsersShoppingListIngredients() {
        return allIngredients;
    }

    public LiveData<List<Recipe>> getSearchResultRecipes() {
        return searchResultRecipes;
    }

    public void searchRecipes(String keyword, SearchListAdapter adapter) {
        new AsyncTask<String, Void, List<Recipe>>() {
            @Override
            protected List<Recipe> doInBackground(String... data) {
                List<Recipe> result = repository.filterRecipes(data[0]);
                return result;
            }

            @Override
            protected void onPostExecute(List<Recipe> result) {
                adapter.setRecipes(result);
                adapter.notifyDataSetChanged();
            }
        }.execute(keyword);
    }

}

