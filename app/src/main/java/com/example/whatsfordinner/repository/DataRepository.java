package com.example.whatsfordinner.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.whatsfordinner.db.AppDatabase;
import com.example.whatsfordinner.db.dao.RecipeDao;
import com.example.whatsfordinner.db.dao.UserDao;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.db.entity.User;

import java.util.List;

public class DataRepository {
    private UserDao userDao;
    private RecipeDao recipeDao;

    private LiveData<List<User>> allUsers;
    private LiveData<List<Recipe>> allRecipes;

    DataRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        userDao = db.getUserDao();
        recipeDao = db.getRecipeDao();

        allRecipes = recipeDao.getAllRecipes();
        //TODO::add the oen for userDao
    }

    LiveData<List<Recipe>> getAllRecipes() {
        return allRecipes;
    }

    LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(Recipe recipe) {
        new insertAsyncTask(recipeDao).execute(recipe);
    }

    private static class insertAsyncTask extends AsyncTask<Recipe, Void, Void> {
        private RecipeDao asynchTaskDao;

        insertAsyncTask(RecipeDao dao) {
            asynchTaskDao = dao;
        }

        @Override
        protected void doInBackground(final Recipe params) {
            asynchTaskDao.insert(/*TODO:: Add recipe params*/);
            return null;
        }
    }
}
