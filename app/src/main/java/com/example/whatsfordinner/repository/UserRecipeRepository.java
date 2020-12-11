package com.example.whatsfordinner.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.whatsfordinner.db.AppDatabase;
import com.example.whatsfordinner.db.dao.RecipeDao;
import com.example.whatsfordinner.db.dao.UserDao;
import com.example.whatsfordinner.db.entity.Recipe;
import com.example.whatsfordinner.db.entity.User;

import java.util.List;

public class UserRecipeRepository {
    private UserDao userDao;
    private RecipeDao recipeDao;

    private LiveData<List<User>> allUsers;
    private LiveData<List<Recipe>> allRecipes;

    UserRecipeRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        userDao = db.getUserDao();
        recipeDao = db.getRecipeDao();

        allRecipes = recipeDao.getAllRecipes();
        //TODO::add the oen for userDao
    }

}
