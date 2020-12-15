package com.example.whatsfordinner.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.whatsfordinner.db.AppDatabase;
import com.example.whatsfordinner.db.dao.RecipeDao;
import com.example.whatsfordinner.db.dao.ShoppingListDao;
import com.example.whatsfordinner.db.dao.UserDao;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.db.entity.ShoppingList;
import com.example.whatsfordinner.db.entity.User;

import java.util.List;

public class DataRepository {
    private UserDao userDao;
    private RecipeDao recipeDao;
    private ShoppingListDao shoppingListDao;

    private LiveData<List<ShoppingList>> allShoppingList;
    private LiveData<List<User>> allUsers;
    private LiveData<List<Recipe>> allRecipes;

    public DataRepository(Application application) {
       AppDatabase db = AppDatabase.getInstance(application);
        userDao = db.getUserDao();
        recipeDao = db.getRecipeDao();

        allRecipes = recipeDao.getAllRecipes();
        allUsers = userDao.getAllUsers();
    }


    public void insert(Recipe recipe) {
       new insertRecipeAsyncTask(recipeDao).execute(recipe);
    }
    public void update(Recipe recipe){
        new updateRecipeAsyncTask(recipeDao).execute(recipe);
    }
    public void delete(Recipe recipe){
        new deleteRecipeAsyncTask(recipeDao).execute(recipe);
    }
    public void deleteAllRecipes(){
        new deleteAllRecipeAsyncTask(recipeDao).execute();
    }

    public LiveData<List<Recipe>> getAllRecipes() {
        return allRecipes;
    }

    public void insert(ShoppingList shoppingList) {
        new insertShoppingListAsyncTask(shoppingListDao).execute(shoppingList);
    }
    public void update(ShoppingList shoppingList){
        new updateShoppingListAsyncTask(shoppingListDao).execute(shoppingList);
    }
    public void delete(ShoppingList shoppingList){
        new deleteShoppingListAsyncTask(shoppingListDao).execute(shoppingList);
    }
    public void deleteAllShoppingList(){
        new deleteAllShoppingListAsyncTask(shoppingListDao).execute();
    }

    public LiveData<List<ShoppingList>> getAllShoppingList(){return allShoppingList;}

    //TODO:::come back and make the additional functions for the users as well.
    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }



    //Recipes
    private static class insertRecipeAsyncTask extends AsyncTask<Recipe,Void, Void>{
        private RecipeDao recipeDao;

        private insertRecipeAsyncTask(RecipeDao recipeDao){
            this.recipeDao=recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDao.insert(recipes[0]);
            return null;
        }
    }
    private static class updateRecipeAsyncTask extends AsyncTask<Recipe,Void, Void>{
        private RecipeDao recipeDao;

        private updateRecipeAsyncTask(RecipeDao recipeDao){
            this.recipeDao=recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDao.update(recipes[0]);
            return null;
        }
    }
    private static class deleteRecipeAsyncTask extends AsyncTask<Recipe,Void, Void>{
        private RecipeDao recipeDao;

        private deleteRecipeAsyncTask(RecipeDao recipeDao){
            this.recipeDao=recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDao.delete(recipes[0]);
            return null;
        }
    }
    private static class deleteAllRecipeAsyncTask extends AsyncTask<Void,Void, Void>{
        private RecipeDao recipeDao;

        private deleteAllRecipeAsyncTask(RecipeDao recipeDao){
            this.recipeDao=recipeDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            recipeDao.deleteAll();
            return null;
        }
    }

    //Shopping List
    private static class insertShoppingListAsyncTask extends AsyncTask<ShoppingList,Void, Void>{
        private ShoppingListDao shoppingListDao;

        private insertShoppingListAsyncTask(ShoppingListDao shoppingListDao){
            this.shoppingListDao=shoppingListDao;
        }

        @Override
        protected Void doInBackground(ShoppingList... shoppingLists) {
            shoppingListDao.insert(shoppingLists[0]);
            return null;
        }
    }
    private static class updateShoppingListAsyncTask extends AsyncTask<ShoppingList,Void, Void>{
        private ShoppingListDao shoppingListDao;

        private updateShoppingListAsyncTask(ShoppingListDao shoppingListDao){
            this.shoppingListDao=shoppingListDao;
        }

        @Override
        protected Void doInBackground(ShoppingList... shoppingLists) {
            shoppingListDao.insert(shoppingLists[0]);
            return null;
        }
    }
    private static class deleteShoppingListAsyncTask extends AsyncTask<ShoppingList,Void, Void>{
        private ShoppingListDao shoppingListDao;

        private deleteShoppingListAsyncTask(ShoppingListDao shoppingListDao){
            this.shoppingListDao=shoppingListDao;
        }

        @Override
        protected Void doInBackground(ShoppingList... shoppingLists) {
            shoppingListDao.insert(shoppingLists[0]);
            return null;
        }
    }
    private static class deleteAllShoppingListAsyncTask extends AsyncTask<Void,Void, Void>{
        private ShoppingListDao shoppingListDao;

        private deleteAllShoppingListAsyncTask(ShoppingListDao shoppingListDao){
            this.shoppingListDao=shoppingListDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            shoppingListDao.deleteAll();
            return null;
        }
    }


    //Users

    /*public void insert(User user){
        new insertAsyncTask(userDao).execute(user);
    }*/

   /* private static class insertAsyncTask extends AsyncTask<User,Void,Void>{
        private UserDao asynchTaskDao;

        insertAsyncTask(UserDao dao){asynchTaskDao=dao;}


        @Override
        protected Void doInBackground(User... users) {
            asynchTaskDao.insertUser(users[0]);
            return null;
        }
    }*/
    /*private static class insertAsyncTask extends AsyncTask<Recipe,Void, Void> {
        private RecipeDao asynchTaskDao;

        insertAsyncTask(RecipeDao dao) {
            asynchTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            asynchTaskDao.insert(recipes[0]);
            return null;
        }
    }*/
}
